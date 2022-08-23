package com.w.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "e:\\new2.txt";
        FileWriter fileWriter = null;
        char[] chars = {'啦', 'a', 'b'};
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write('H');
            fileWriter.write("we啦");
            fileWriter.write(chars);
            fileWriter.write(chars, 0, 1);
            fileWriter.write("风雨之后，必有彩虹！", 5, 4);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
