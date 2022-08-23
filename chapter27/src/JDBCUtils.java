import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * @author blue
 * @version 1.0
 * 这是一个工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关的属性(4个),因为只需要一份，用static
    private static String user; //用户名
    private static String password; //密码
    private static String url; //url
    private static String driver; //驱动名

    //在static代码块去初始化
    static {

        //读取相关的属性值
        user = "";
        password = "";
        url = "jdbc:mysql://localhost:3306/数据库名称";
        driver = "com.mysql.jdbc.Driver";

    }

    //连接数据库，返回Connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转成 运行异常
            //2. 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便.
            throw new RuntimeException(e);
        }

    }

    //关闭相关资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        //判断是否为空
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常转换为运行异常
            throw new RuntimeException(e);
        }

    }
}
