package com.w.mhl.utils;

import java.sql.Connection;

/**
 * @author blue
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("测试Utility类");
        System.out.print("输入一个数值： ");
        int i = Utility.readInt();
        System.out.println("i=" + i);

        System.out.println("测试JDBCUtilsByDruid类");
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
