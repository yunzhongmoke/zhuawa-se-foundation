package com.w.mhl.dao;

import com.w.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author blue
 * @version 1.0
 * 开发BasicDAO，是其他DAO的父类
 * 泛型使用之前需要声明
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();
    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    //开发通用的dml方法，针对任意的表
    public int update(String sql, Object... parameters) {

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //返回多个对象(即查询的结果是多行),针对任意表

    /**
     * @param sql        sql 语句，可以有 ?
     * @param clazz      传入一个类的Class对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {

        connection = JDBCUtilsByDruid.getConnection();
        try {
            List<T> list = qr.query(connection, sql, new BeanListHandler<>(clazz), parameters);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行结果的通用方法
    public T querySingle(String sql, Class<T> clazz, Object...parameters) {

        connection = JDBCUtilsByDruid.getConnection();
        try {
            T query = qr.query(connection, sql, new BeanHandler<>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行单列的方法，即返回单值的方法
    public Object queryScalar(String sql, Object...parameters){

        connection = JDBCUtilsByDruid.getConnection();
        try {
            Object query = qr.query(connection, sql, new ScalarHandler(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

}
