package com.w.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //读取本地数据
        String filePath = "e:\\pokemon.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //使用StreamUtils工具类
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //发送至服务器端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        //设置写入写入结束标志
        bis.close();
        socket.shutdownOutput();

        //接收服务器端信息
        InputStream inputStream = socket.getInputStream();
        System.out.println(StreamUtils.streamToString(inputStream));

        //关闭流和socket
        inputStream.close();
        bos.close();
        socket.close();
    }
}
