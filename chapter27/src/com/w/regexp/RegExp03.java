package com.w.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author blue
 * @version 1.0
 */
public class RegExp03 {

    public static void main(String[] args) {

        String content = "a11c8abcABC";
        //匹配 a-z 之间任意一个字符
//        String regStr = "[a-z]";
        //匹配 A-Z 之间任意一个字符
//        String regStr = "[A-Z]";
//        String regStr = "abc"; //默认区分大小写
//        String regStr = "(?i)abc"; //不区分大小写
//        String regStr = "abc";
        //匹配 0-9 之间的字符
//        String regStr = "[0-9]";
        //不在 0-9 之间的字符
//        String regStr = "[^0-9]";
        //不在 a-z 之间的字符
        String regStr = "[^a-z]{3}";


//        Pattern pattern = Pattern.compile(regStr);
        //不区分大小写
        Pattern pattern = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到： " + matcher.group(0));
        }

    }

}
