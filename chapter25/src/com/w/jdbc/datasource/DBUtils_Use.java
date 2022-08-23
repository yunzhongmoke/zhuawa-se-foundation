package com.w.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author blue
 * @version 1.0
 */
public class DBUtils_Use {

    @Test
    public void testDBUtils() {

        //获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        //获取QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from admin where name = ?";
        try {
            //List<Admin> list = queryRunner.query(connection, sql, new BeanListHandler<>(Admin.class));
            Admin admin = queryRunner.query(connection, sql, new BeanHandler<>(Admin.class), "blue");
//            for (Admin admin : list) {
//                System.out.print(admin);
//            }
            System.out.println(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    @Test
    public void testScalar() {

        //获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "select name from admin where name = ? ";
        try {
            Object object = queryRunner.query(connection, sql, new ScalarHandler(), "blue");
            System.out.println(object);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    @Test
    public void testDML() {

        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        //String sql = "insert into admin values (?, ?)";
        //String sql = "update admin set password = '1234' where name = ?";
        String sql = "delete from admin where name = ?";
        try {
            //int affectedRow = queryRunner.update(connection, sql, "lalal", "1234");
            int affectedRow = queryRunner.update(connection, sql, "lalal");
            System.out.println(affectedRow > 0 ? "执行成功" : "表未受到影响");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }


}
