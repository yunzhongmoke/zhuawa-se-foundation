package com.w.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author blue
 * @version 1.0
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("DESKTOP-5HCI3E6");
        System.out.println(byName);

        String hostName = localHost.getHostName();
        System.out.println(hostName);

        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);

        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);
        String hostAddress1 = byName1.getHostAddress();
        System.out.println(hostAddress1);

    }
}
