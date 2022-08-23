package com.w.homework;

import java.io.IOException;
import java.net.*;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        socket.receive(packet);

        int dataLength = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0, dataLength);
        System.out.println(s);

        String answer = null;
        switch (s) {
            case "四大名著":
                answer = "西游记，红楼梦，三国演义，水浒传";
                break;
            default:
                answer = "你在说啥";
        }
        byte[] bytes1 = answer.getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("192.168.0.152"), 8887);
        socket.send(packet1);

        //关闭资源
        socket.close();

    }
}
