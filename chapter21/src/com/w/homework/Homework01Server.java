package com.w.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);

        Socket socket = serverSocket.accept();

//        byte[] bytes = new byte[1024];
//        int length = 0;
//        String s = new String();
//        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        while ((length = bis.read(bytes)) != -1) {
//            s += (new String(bytes, 0, length));
//        }
//        System.out.println(s);

        String line = null;
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((line = br.readLine()) != null){
            s += line;
        }
        System.out.println(s);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String answer = null;
        /**
         * 用switch更简洁
         */
        if ("name".equals(s)) {
            answer = "我是nava";
        } else if (s.equals("hobby")) {
            answer = "编写java程序";
        } else {
            answer = "你说啥呢？";
        }
        bw.write(answer);
        bw.flush();
        //设置写入结束标志
        socket.shutdownOutput();

//        byte[] answer = null;
//        BufferedOutputStream bos = bos = new BufferedOutputStream(socket.getOutputStream());;
//        if (s.equals("name")) {
//            answer = "我是nava".getBytes();
//        } else if (s.equals("hobby")) {
//            answer = "编写java程序".getBytes();
//        } else {
//            answer = "你说啥呢？".getBytes();
//        }
//        bos.write(answer);
//        bos.flush();
//        //设置写入结束标志
//        socket.shutdownOutput();

        //关闭流和socket
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
