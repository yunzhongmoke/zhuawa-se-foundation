package com.w.jdbc.batch_;

import com.w.jdbc.utils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author blue
 * @version 1.0
 */
public class Batch_ {

    public static void main(String[] args) {
        System.out.println(10 % 9);
    }

    @Test
    public void batch() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {

            preparedStatement.setString(1, "q" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.addBatch();
            if ((i + 1) % 1000 == 0){
                preparedStatement.executeBatch();
                //清空batch
                preparedStatement.clearBatch();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        JDBCUtils.close(null, preparedStatement, connection);

    }

}
