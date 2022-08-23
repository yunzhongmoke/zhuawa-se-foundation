package com.w.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务器在9999号端口监听....");

        Socket socket = serverSocket.accept();

        System.out.println("服务端：" + socket.getClass());

        //读取客户端数据
        byte[] bytes = new byte[1024];
        int readLen = 0;
        InputStream inputStream = socket.getInputStream();
        System.out.println("读取内容：");
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        //关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务端退出");

    }
}
