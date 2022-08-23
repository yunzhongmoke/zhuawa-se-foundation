package com.w.exception_;

import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class Exception02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = null;
        int num = 0;

        while (true) {
            System.out.print("请输入一个整数：");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);//可能会抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("要输入一个整数！");
            }
        }

        System.out.println("num=" + num);

    }
}
