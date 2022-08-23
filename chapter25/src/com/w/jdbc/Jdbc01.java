package com.w.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 * 完成简单的操作
 */
public class Jdbc01 {

    public static void main(String[] args) throws SQLException {

        //注册驱动
        //创建driver对象
        Driver driver = new Driver();

        //得到连接
        String url = "jdbc:mysql://localhost:3306/jdbc";

        //将用户名和密码放入到Properties 对象
        Properties properties = new Properties();
        //user 和 password 是规定好的， 后面的值根据实际情况写
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connect = driver.connect(url, properties);

        //执行sql
        String sql = "insert into actor values(null, 'q', '男', '2022-3-7', '110')";
        //String sql = "update actor set id = 1 where `name` = 'q'";
        //String sql = "delete from actor where id = 1";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);

        System.out.println(rows > 0 ? "成功" : "失败");

        //关闭资源
        statement.close();
        connect.close();



    }

}
