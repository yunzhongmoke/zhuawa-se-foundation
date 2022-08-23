package com.w.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author blue
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            String[] split = line.split("=");
            System.out.println(split[0] + " = " + split[1]);
        }
        bufferedReader.close();
    }
}
