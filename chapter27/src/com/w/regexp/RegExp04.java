package com.w.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author blue
 * @version 1.0
 */
public class RegExp04 {

    public static void main(String[] args) {

        String content = "laleha 啦啦 拉";
        String regStr = "la|啦|拉";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }

    }
}
