package com.w.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author blue
 * @version 1.0
 */
public class RegTheory {

    public static void main(String[] args) {
        String content =
                "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了" +
                        "第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型" +
                        "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的" +
                        "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应" +
                        "用3443于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个" +
                        "里程碑，标志着Java的应用开始普及9889 ";

        //目的：匹配所有四个数字
        //说明
        //1. \\d表示一个任意的数字
        String regStr = "(\\d\\d)(\\d\\d)";
        //2. 创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        //3. 创建匹配器
        //说明：创建匹配器matcher, 按照正则表达式的规则 去匹配 content 字符串
        Matcher matcher = pattern.matcher(content);
        //4.开始匹配
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第一组： " + matcher.group(1));
            System.out.println("第二组： " + matcher.group(2));
        }
    }
}
