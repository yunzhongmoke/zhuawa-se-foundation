package com.w.transformation;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\b.txt";
        String charset = "gbk";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), charset);
        BufferedReader br = new BufferedReader(isr);
        String la = br.readLine();
        System.out.println(la);
        br.close();
    }
}
