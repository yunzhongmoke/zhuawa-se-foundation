package com.w.writer;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "e:\\me.txt";
        String destFilePath = "e:\\me2.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
