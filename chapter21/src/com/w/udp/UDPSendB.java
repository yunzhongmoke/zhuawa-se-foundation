package com.w.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author blue
 * @version 1.0
 */
public class UDPSendB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        //发送数据
        byte[] bytes = "hello,A".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.152"), 9999);

        socket.send(packet);

        //接收数据
        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);

        socket.receive(packet1);

        int length = packet1.getLength();
        byte[] data = packet1.getData();

        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();

    }
}
