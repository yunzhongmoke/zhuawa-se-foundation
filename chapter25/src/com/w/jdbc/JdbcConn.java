package com.w.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 * 演示连接数据库的五种方式
 */
public class JdbcConn {

    @Test
    public void Connection01() throws SQLException {

        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connect = driver.connect(url, properties);

        System.out.println(connect);

    }

    @Test
    public void Connection02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException {

        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.getConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/test";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");

        Connection connect = driver.connect(url, properties);

        System.out.println(connect);

    }

    @Test
    public void Connection03() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Driver driver = new Driver();
        //com.mysql.cj.jdbc.Driver 底层已经注册了driver
        /**
         * static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */
        //Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        //Driver driver = (Driver) aClass.getConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "1234";

        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }

    @Test
    public void Connection04() throws ClassNotFoundException, SQLException {

        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    @Test
    public void Connection05() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//jdbc.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //使用反射加载Driver
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }

}
