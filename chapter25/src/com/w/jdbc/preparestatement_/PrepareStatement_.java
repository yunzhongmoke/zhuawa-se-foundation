package com.w.jdbc.preparestatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class PrepareStatement_ {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入账号: ");
        String user_name = scanner.nextLine();
        System.out.print("请输入密码: ");
        String user_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //driver -> com.mysql.cj.jdbc.Driver
        //url -> jdbc:mysql://localhost:3306/数据库名称
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select name, password from admin where `name` = ? and password = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, user_pwd);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
