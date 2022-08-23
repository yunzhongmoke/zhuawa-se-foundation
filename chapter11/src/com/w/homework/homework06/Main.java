package com.w.homework.homework06;

/**
 * @author blue
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Color.RED.show();
        Color.GREEN.show();
        //获取所有枚举对象
        Color[] colors = Color.values();
        Color red = Color.RED;
        switch (Color.GREEN){

            case RED:
                System.out.println("红色");
                break;
            default:
                System.out.println("没有匹配的");
        }
    }
}
