package com.w.homework;

import com.w.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);

        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String question = "";
        String line = "";
        while ((line = br.readLine()) != null){
            question += line;
        }
        System.out.println(question);

        String filePath = "src\\";
        switch (question){
            case "pokemon":
                filePath += "pokemon.jpg";
            default:
                filePath += "洛克王国.png";
        }

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bw.write(filePath);
//        bw.newLine();
//        bw.flush();
//        socket.shutdownOutput();

        byte[] bytes = StreamUtils.streamToByteArray(new FileInputStream(filePath));

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();

        bos.close();
        //bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
