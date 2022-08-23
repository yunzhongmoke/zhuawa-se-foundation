package com.w.properties_;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        properties.setProperty("user", "啦啦啦");
        properties.setProperty("pws", "123456");

        //存储
        //properties.store(new FileOutputStream("src\\mysql2.properties"), null);
        properties.store(new FileWriter("src\\mysql2.properties"), null);



    }
}
