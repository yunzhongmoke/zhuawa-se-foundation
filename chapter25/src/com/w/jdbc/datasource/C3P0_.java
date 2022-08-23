package com.w.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class C3P0_ {

    //方式1： 相关参数，在程序中指定user, url, password等
    @Test
    public void testC3P0_01() throws Exception {

        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件获取相关的连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));
        //读取相关属性
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 ComboPooledDataSource 设置相关的参数
        //连接的管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //这个方法就是从 DataSource 接口实现的
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功");
        connection.close();

    }

    //方式2： 使用配置文件模板来完成
    @Test
    public void testC3PO_02() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("w");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功");
        connection.close();

    }
}
