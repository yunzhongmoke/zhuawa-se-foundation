package com.w.homework;

import java.util.Arrays;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str);
        try {
            str = reverse(null, 0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    //编写一个交换方法,实现翻转
    public static String reverse(String str, int start, int end) {
        //健壮性完善
        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("输入参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        //返回一个新数组，原数组并没有发生变化
        return new String(chars);
    }
}
