package com.w.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8887);

        System.out.print("请输入问题：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        byte[] bytes = s.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.152"), 8888);
        socket.send(packet);


        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);
        socket.receive(packet1);
        int dataLength = packet1.getLength();
        byte[] data = packet1.getData();
        String s1 = new String(data, 0, dataLength);
        System.out.println(s1);

        socket.close();

    }
}
