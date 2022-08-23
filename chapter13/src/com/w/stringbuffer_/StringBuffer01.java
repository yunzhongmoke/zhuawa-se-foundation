package com.w.stringbuffer_;

/**
 * @author blue
 * @version 1.0
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        String price = "1234567.89";//将其转化成1,234,567.89
        StringBuffer sb = new StringBuffer(price);

        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb.insert(i, ",");
        }

        System.out.println(sb);

    }
}
