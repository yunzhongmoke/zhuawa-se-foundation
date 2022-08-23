package com.w.jdbc.transaction_;

import com.w.jdbc.utils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author blue
 * @version 1.0
 */
public class Transaction_ {

    @Test
    public void useTransaction(){
        //获取连接
        Connection connection = null;

        //编写sql语句
        String sql = "update account set money = money + 200 where id = 1;";
        String sql2 = "update account set money = money - 200 where id = 2;";

        //创建PreparedStatement
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //关闭自动提交，开启事务
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句
            preparedStatement.executeUpdate();

            //int i = 1 / 0; //抛出异常 ArithmeticException

            preparedStatement = connection.prepareStatement(sql2);
            //执行sql语句
            preparedStatement.executeUpdate();

            //提交事务
            connection.commit();
        } catch (Exception e) {
            //设置回滚点
            System.out.println("发生了异常，撤销执行的sql语句");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

}
