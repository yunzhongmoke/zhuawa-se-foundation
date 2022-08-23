package com.w.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * read()
     */
    @Test
    public void readFile() {
        String filePath = "e:\\hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readDate = fileInputStream.read()) != -1) {
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        byte[] buf = new byte[2];
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
