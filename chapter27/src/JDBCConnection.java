import java.sql.*;

/**
 * @author blue
 * @version 1.0
 */
public class JDBCConnection {

    public static void main(String[] args) {

        //创建Connection对象
        Connection connection = null;
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        //创建ResultSet对象
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/数据库名称";
            // mysql 账号
            String user = "";
            // 密码
            String password = "";

            connection = DriverManager.getConnection(url, user, password);
            // 编写sql语句
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);

//            //执行dml(增删改)语句
//            int update = preparedStatement.executeUpdate(); //update 返回受影响的行数

//            //执行select sql语句
//            resultSet = preparedStatement.executeQuery(); //resultSet 返回查询结果集
//            //遍历resultSet 对象结果集
//            while (resultSet.next()){
//                resultSet.getString();
//            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //关闭连接
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
