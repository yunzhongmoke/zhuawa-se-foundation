package com.w.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author blue
 * @version 1.0
 */
public class RegExp02 {

    public static void main(String[] args) {

        String content = "abc$(abc.(123(";
        //匹配 (
//        String regStr = "\\(";
        //匹配 .
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }

}
