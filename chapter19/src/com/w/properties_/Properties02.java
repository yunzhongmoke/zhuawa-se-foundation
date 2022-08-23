package com.w.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //创建一个Properties对象
        Properties properties = new Properties();
        //加载文件
        properties.load(new FileReader("src\\mysql.properties"));
        //打印输出到控制台
        properties.list(System.out);

        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");

        System.out.println(user);
        System.out.println(pwd);



    }
}
