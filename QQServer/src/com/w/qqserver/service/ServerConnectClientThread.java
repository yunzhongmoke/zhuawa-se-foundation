package com.w.qqserver.service;

import com.w.qqcommon.Message;
import com.w.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author blue
 * @version 1.0
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId; //连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { //这里线程处于run的状态，可以发送/接收消息

        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建一个Message对象，返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //根据message获取getter id，然后再得到对应的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());

                    //添加离线功能
                    if (serverConnectClientThread == null){
                        QQServer.addMessage(message);
                        QQServer.addDb(message.getGetter(),QQServer.getMessages());
                        continue;
                    }

                    //得到对应socket的对象输出流，将message对象转发给指定的客户端
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {

                    //需要遍历 管理线程的集合，把所有的线程的socket得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {

                        //取出在线用户的id
                        String onLineUserId = iterator.next();

                        //排除这个群发的用户
                        if (onLineUserId.equals(message.getSender())) {
                            continue;
                        }

                        ObjectOutputStream oos =
                                new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                        oos.writeObject(message);

                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getter id 获取到对应的线程，将message对象转发
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());

                    //添加离线功能
                    if (serverConnectClientThread == null){
                        QQServer.addMessage(message);
                        QQServer.addDb(message.getGetter(),QQServer.getMessages());
                        continue;
                    }

                    //获取socket
                    Socket socket = serverConnectClientThread.getSocket();
                    //转发
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) { //从客户端退出

                    System.out.println(message.getSender() + " 退出");
                    //将这个客户端对应线程，从集合中删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close(); //关闭连接
                    //退出线程
                    break;

                } else {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
