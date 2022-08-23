package com.w.qqserver.service;

import com.w.qqcommon.Message;
import com.w.qqcommon.MessageType;
import com.w.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author blue
 * @version 1.0
 * 这是服务器，在监听9999，等待客户端的连接，并保持通信
 */
public class QQServer {

    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法的
    private static HashMap<String, User> validUsers = new HashMap<>();

    private static ConcurrentHashMap<String, ArrayList<Message>> db = new ConcurrentHashMap<>();
    private static ArrayList<Message> messages = new ArrayList<>();

    //在静态代码块，初始化validUsers
    static {

        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("啦啦啦", new User("啦啦啦", "123456"));

    }

    public static void addDb(String userId, ArrayList<Message> messages) {
        db.put(userId, messages);
    }

    public static void removeDb(String userId) {
        db.remove(userId);
    }

    public static void addMessage(Message message) {
        messages.add(message);
    }

    public static ConcurrentHashMap<String, ArrayList<Message>> getDb() {
        return db;
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }

    //验证用户是否有效的方法
    public boolean checkUser(String userId, String passwd) {

        User user = validUsers.get(userId);
        //判断用户是否存在
        if (user == null) {
            return false;
        }
        //判断密码是否正确
        if (!user.getPassword().equals(passwd)) {
            return false;
        }

        return true;

    }

    //离线功能
    public void offline(String userId, Socket socket) {

        //遍历db中的userId
        ConcurrentHashMap<String, ArrayList<Message>> db = getDb();

        Iterator<String> iterator = db.keySet().iterator();
        while (iterator.hasNext()) {
            //判断当前用户
            if (!iterator.next().equals(userId)) {
                continue;
            }

            ArrayList<Message> messages = db.get(userId);
            for (Message message : messages) {
                try {

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        //删除离线信息
        removeDb(userId);


    }

    public QQServer() {

        try {
            System.out.println("服务端在9999端口监听...");
            ss = new ServerSocket(9999);
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();

            while (true) { //当和某个客户端连接后，会继续监听，因此while

                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //读取客户端发送的user对象
                User u = (User) ois.readObject();
                //创建一个Message对象，准备回复客户端
                Message message = new Message();
                //验证用户 方法
                if (checkUser(u.getUserId(), u.getPassword())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复个给客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //把该线程对象，放入到一个集合中，进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);
                    //调用离线功能
                    offline(u.getUserId(), socket);

                } else { //登录失败
                    System.out.println("用户" + u.getUserId() + "登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //如果服务器退出了while，说明服务器端不在监听，因此关闭ServerSocket

            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
