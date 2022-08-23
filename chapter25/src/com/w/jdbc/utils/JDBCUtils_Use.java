package com.w.jdbc.utils;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author blue
 * @version 1.0
 */
public class JDBCUtils_Use {

    @Test
    public void testSelect() {

        //获取连接
        Connection connection = null;

        //编写sql语句
        String sql = "select * from admin;";

        //创建PreparedStatement
        PreparedStatement preparedStatement = null;

        //创建ResultSet
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

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
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

    }

    @Test
    public void testDML() {

        //获取连接
        Connection connection = null;

        //编写sql语句
        String sql = "update admin set password = ? where `name` = ?;";

        //创建PreparedStatement
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "2");
            preparedStatement.setString(2, "q");
            //执行sql语句
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }

}
