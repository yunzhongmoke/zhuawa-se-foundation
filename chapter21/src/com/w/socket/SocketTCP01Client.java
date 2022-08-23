package com.w.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author blue
 * @version 1.0
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        System.out.println("客户端：" + socket.getClass());

        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("hello,server".getBytes());

        //关闭流和socket
        outputStream.close();
        socket.close();


    }
}
