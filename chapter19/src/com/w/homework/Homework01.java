package com.w.homework;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {

        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("目录已存在");
        } else {
            file.mkdir();
        }

        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件已存在");
        } else {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write("hello,world");
        fileWriter.close();

    }
}
