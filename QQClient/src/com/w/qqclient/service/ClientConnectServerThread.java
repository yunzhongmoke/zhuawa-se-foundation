package com.w.qqclient.service;

import com.w.qqcommon.Message;
import com.w.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread {

    //该线程需要持有Socket
    private Socket socket;

    //构造器接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        //因为Thread需要在后台和服务器通信，因此while循环
        while (true) {

            try {
                System.out.println("等待服务端信息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //判断message类型，然后做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息，并显示
                    //规定
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n========当前在线用户列表========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户: " + onlineUsers[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //显示再客户端的控制台
                    System.out.println("\n" + message.getSender() + " 对大家说: " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //把从服务器转发的消息，显示到控制台即可
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + " 说: " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + " 给 " + message.getGetter()
                            + " 发文件: " + message.getSrc() + " 到我的电脑目录 " + message.getDest());

                    //取出message的文件字节数组，通过文件输出流写入到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    //关闭流
                    fileOutputStream.close();
                    System.out.println("\n保存文件成功~");
                } else {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
