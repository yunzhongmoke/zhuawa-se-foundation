package com.w.jdbc.classroompractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class Practice01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

//        String sql = "create table news(" +
//                "id int primary key," +
//                "content varchar(100)" +
//                ");";
//        String sql = "insert into news " +
//                "values(1, 'q')," +
//                "(2, 'w')," +
//                "(3, 'e')," +
//                "(4, 'r')," +
//                "(5, 't');";
//        String sql = "update news set content = '一个新的消息' where id = 1;";
        String sql = "delete from news where id = 3;";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        //关闭资源
        statement.close();
        connection.close();

    }

}
