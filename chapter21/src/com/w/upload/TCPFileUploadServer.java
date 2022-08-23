package com.w.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class TCPFileUploadServer {
    private static String destFilePath;

    public static void main(String[] args) throws Exception {
        //服务器监听
        ServerSocket serverSocket = new ServerSocket(8888);

        //等待连接
        Socket socket = serverSocket.accept();

        //读取客户端的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //将数组写入至指定文件
        String destFilePath = "src\\pokemon.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        //发送数据给客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        outputStream.flush();
        //设置写入结束标志
        socket.shutdownOutput();

        //关闭流和socket
        outputStream.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
