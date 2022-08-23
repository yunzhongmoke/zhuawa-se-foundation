package com.w.jdbc.classroompractice;

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
public class Practice02 {

    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入账号: ");
//        String user_name = scanner.nextLine();
//        System.out.print("请输入密码: ");
//        String user_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Connection connection = DriverManager.getConnection(url, user, password);
        //创建admin表
//        String sql = "create table admin (" +
//                "`name` varchar(32)," +
//                "`password` varchar(32));";
        //添加记录
        //String sql = "insert into admin values (?, ?);";

        //修改记录
        //String sql = "update admin set password = ? where `name` = ?";

        //删除记录
        //String sql = "delete from admin where `name` = ?;";

        //查询记录
        String sql = "select `name`, `password` from admin";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        boolean execute = preparedStatement.execute();
//        System.out.println(execute ? "创建成功" : "创建失败");

//        preparedStatement.setString(1, user_name);
//        preparedStatement.setString(2, user_pwd);

//        preparedStatement.setString(1, user_pwd);
//        preparedStatement.setString(2, user_name);

//        preparedStatement.setString(1, user_name);
//        int rows = preparedStatement.executeUpdate();
//        System.out.println("rows=" + rows);
//        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String user_name = resultSet.getString("name");
            String user_pwd = resultSet.getString("password");
            System.out.println(user_name + "\t" + user_pwd);
        }

        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
