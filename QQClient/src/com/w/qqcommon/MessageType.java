package com.w.qqcommon;

/**
 * @author blue
 * @version 1.0
 * 表示消息类型
 */
public interface MessageType {

    String MESSAGE_LOGIN_SUCCEED = "1";
    String MESSAGE_LOGIN_FAIL = "2";
    String MESSAGE_COMM_MES = "3"; //普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4"; //要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5"; //返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; //客户端请求退出
    String MESSAGE_TO_ALL_MES = "7"; //群发消息报
    String MESSAGE_FILE_MES = "8"; //文件消息(发送文件)

}
