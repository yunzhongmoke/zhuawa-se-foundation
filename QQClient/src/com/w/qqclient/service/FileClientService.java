package com.w.qqclient.service;

import com.w.qqclient.utils.StreamUtils;
import com.w.qqcommon.Message;
import com.w.qqcommon.MessageType;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 * 该类/对象完成 文件传输服务
 */
public class FileClientService {

    public void sendFileToOne(String src, String dest, String senderId, String getterId) {

        //读取src文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件读取
        FileInputStream fileInputStream = null;
        //byte[] fileBytes = new byte[(int) new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            byte[] fileBytes = StreamUtils.streamToByteArray(fileInputStream);
            //fileInputStream.read(fileBytes);
            //将文件对应的字节数组设置给message
            message.setFileBytes(fileBytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                //关闭
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //发送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //提示信息
        System.out.println("\n" + senderId + " 给 " + getterId + " 发送文件: " + src
                + " 到对方的电脑目录 " + dest);

    }

}
