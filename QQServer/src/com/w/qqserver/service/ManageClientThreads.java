package com.w.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author blue
 * @version 1.0
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    //根据userId 返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //从集合中，移除某个线程对象
    public static void removeServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    //返回在线用户列表
    public static String getOnlineUser() {
        //集合遍历，遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        StringBuilder onlineUserList = new StringBuilder();
        while (iterator.hasNext()) {
            onlineUserList.append(iterator.next() + " ");
        }

        return onlineUserList.toString();

    }

}
