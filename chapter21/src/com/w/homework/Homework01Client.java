package com.w.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.0.152"), 5555);

        System.out.print("请输入问题：");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(question);
        bw.newLine();
        bw.flush();
        //设置写入结束标志
        socket.shutdownOutput();

        //接收数据
//        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        byte[] bytes = new byte[1024];
//        int length = 0;
//        String s = "";
//        while((length = bis.read(bytes)) != -1){
//            s += new String(bytes, 0, length);
//        }
//        System.out.println(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        String s = "";
        while ((line = br.readLine()) != null){
            s += line;
        }
        System.out.println(s);


        //关闭流和socket
        br.close();
        bw.close();
        socket.close();

    }
}
