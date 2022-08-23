package com.w.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    public void create01() {
        String filePath = "e:/news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create03(){
        String parentPath = "e:\\";
        String childPath = "news3.txt";
        File file = new File(parentPath, childPath);

        try {
            file.createNewFile();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
