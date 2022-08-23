package com.w.qqserver.service;

import com.w.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author blue
 * @version 1.0
 * 多余的操作
 */
public class Offline implements Runnable {

    private ArrayList<Message> messages;
    private Socket socket;

    public Offline(ArrayList<Message> messages, Socket socket) {
        this.messages = messages;
        this.socket = socket;
    }

    @Override
    public void run() {
        for (Message message : messages) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
