package com.w.homework;

import com.w.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {

        System.out.println("输入：");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();

        Socket socket = new Socket(InetAddress.getByName("192.168.0.152"), 6666);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(question);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        //接收数据
        //BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String destFilePath = "e:\\" + question + ".png";

        //BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(socket.getInputStream());

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        bos.close();
        //bis.close();
        //br.close();
        bw.close();
        socket.close();


    }
}
