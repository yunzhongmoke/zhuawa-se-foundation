package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        String name = "la";
        String password = "1234w6";
        String email = "1@.";
        try {
            check(name, password, email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String str1, String str2, String str3) {
        if (!(str1.length() >= 2 && str1.length() <= 4)) {
            throw new RuntimeException("输入用户名格式不正确");
        }

        if (!(str2.length() == 6 && isDigital(str2))) {
            throw new RuntimeException("密码格式不正确");
        }

        int password = Integer.parseInt(str2);

        int i1 = str3.indexOf("@");
        int i2 = str3.indexOf(".");
        if (!(i1 > 0 && i1 < i2)) {
            throw new RuntimeException("邮箱格式不正确");
        }

        System.out.println("注册成功");
    }

    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //判断chars[i]是否为数字
            if (/*chars[i] < '0' || chars[i] > '9'*/!Character.isDigit(chars[i])) {
                return false;
            }
            //Character.isDigit(chars[i])
        }
        return true;
    }

}
