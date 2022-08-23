package com.w.homework;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\mysql.properties";
        String charset = "gbk";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset));
        String line = null;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(++i + ". " + line);
        }
        bufferedReader.close();

    }
}
