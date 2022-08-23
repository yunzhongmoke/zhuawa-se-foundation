package com.w.qqclient.view;

import com.w.qqclient.service.FileClientService;
import com.w.qqclient.service.MessageClientService;
import com.w.qqclient.service.UserClientService;
import com.w.qqclient.utils.Utility;

/**
 * @author blue
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {

    private boolean loop = true; //控制是否显示菜单
    private String key = ""; //接收用户的键盘输入
    private UserClientService userClientService = new UserClientService(); //对象用于登录服务/注册用户
    private MessageClientService messageClientService = new MessageClientService(); //对象用于私聊/群聊
    private FileClientService fileClientService = new FileClientService(); //对象用于传输文件

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    //显示主菜单
    private void mainMenu() {

        while (loop) {

            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");

            System.out.println("请输入你的选择：");
            key = Utility.readString(1);

            //根据用户的输入，处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);

                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("=====欢迎(用户 " + userId + " )=====");
                        //进入二级菜单
                        while (loop) {
                            System.out.println("\n==========网络通信系统二级菜单(用户 " + userId + " )==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入对大家想说的话: ");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageTOALL(content, userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户(在线):");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话: ");
                                    content = Utility.readString(100);
                                    //编写一个方法，将消息发送给服务器端
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.print("请输入你想拜文件发送给的用户(在线用户): ");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入发送文件的路径(形式 d:\\xx.jpg): ");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入把文件发送给对方的路径(形式 d:\\xx.jpg): ");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src, dest, userId, getterId);

                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else { //登录服务器失败
                        System.out.println("==========登录失败==========");
                    }

                    break;
                case "9":
                    loop = false;
                    break;
            }


        }

    }
}
