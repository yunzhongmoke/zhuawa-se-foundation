package com.w.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class ResultSet_ {

    public static void main(String[] args) throws Exception {

        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "select * from news;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String content = resultSet.getString(2);
            System.out.println(id + "\t" + content);
        }

        //关闭连接资源
        resultSet.close();
        statement.close();
        connection.close();

    }

}
