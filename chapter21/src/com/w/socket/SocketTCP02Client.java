package com.w.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        System.out.println("客户端");

        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        //设置写入结束标志
        socket.shutdownOutput();

        //接收数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        //关闭流和socket
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
