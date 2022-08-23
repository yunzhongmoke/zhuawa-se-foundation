package com.w.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) {
        String filePath = "e:\\me.txt";
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("啦啦啦,is me");
            bufferedWriter.newLine();
            bufferedWriter.write("啦啦啦,is me");
            bufferedWriter.newLine();
            bufferedWriter.write('H');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
