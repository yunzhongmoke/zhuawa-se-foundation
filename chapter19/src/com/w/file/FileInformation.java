package com.w.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class FileInformation {


    @Test
    public void info(){
        //先创建文件对象
        File file = new File("e:\\new1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("name=" + file.getName());

        System.out.println(file.getAbsolutePath());

        System.out.println(file.exists());
    }
}
