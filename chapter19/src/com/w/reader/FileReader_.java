package com.w.reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "e:\\new1.txt";
        FileReader fileReader = null;
        int readDate = 0;
        try {
            fileReader = new FileReader(filePath);
            while ((readDate = fileReader.read()) != -1) {
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void readFile02() {
        String filePath = "e:\\new1.txt";
        FileReader fileReader = null;
        char[] chars = new char[4];
        int readLen = 0;

        try {
            fileReader = new FileReader(filePath);
            while ((readLen = fileReader.read(chars)) != -1){
                System.out.print(new String(chars, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
