package com.w.print_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author blue
 * @version 1.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\b.txt"));
        printWriter.print("啦啦啦");
        //一定要关闭或刷新流,数据才会写入
        printWriter.close();
        //printWriter.flush();
    }
}
