package com.w.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author blue
 * @version 1.0
 */
public class UDPReceiveA {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象，在9999端口接收信息
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建DatagramPacket对象，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //3.调用接受方法，装包
        socket.receive(packet);
        //4.将packet拆包
        int dataLength = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0, dataLength);
        System.out.println(s);

        //发送数据
        byte[] bytes1 = "好的".getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("192.168.0.152"), 9998);
        socket.send(packet1);

        //5.关闭资源
        socket.close();
    }
}
