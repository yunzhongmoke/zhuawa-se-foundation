package com.w.jdbc.datasource;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class JDBCUtilsByDruid_Use {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要查询的内容(name): ");
        String user_name = scanner.nextLine();
//        testDruid(user_name);
    }

    @Test
    public static void testDruid() {

        //获取连接
        Connection connection = null;

        //编写sql语句
//        String sql = "select * from admin where `name` like '%" + user_name + "%'";
        String sql = "select * from admin";
        //创建PrepareStatement对象
        PreparedStatement preparedStatement = null;

        //创建ResultSet对象
        ResultSet resultSet = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                System.out.println(name + "\t" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }


    }

    //土办法封装
    @Test
    public void testEncapsulation() {

        //获取连接
        Connection connection = null;

        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;

        //编写sql语句
        String sql = "select * from admin";

        //创建ResultSet对象
        ResultSet resultSet = null;


        try {

            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            //创建 ArrayList数组
            ArrayList<Admin> list = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                list.add(new Admin(name, password));
            }

            //遍历list数组
            for (Admin admin : list){
                System.out.print(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }


    }

}
