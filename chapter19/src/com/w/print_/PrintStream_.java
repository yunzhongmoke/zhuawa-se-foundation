package com.w.print_;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author blue
 * @version 1.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.print("啦啦啦   ");
        out.write(100);
        out.write("  啦啦啦啦".getBytes());
        out.close();

        //改变输出位置
        String filePath = "e:\\a.txt";
        System.setOut(new PrintStream(filePath));
        System.out.println("lalla，啦啦啦");
    }
}
