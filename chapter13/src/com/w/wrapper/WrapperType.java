package com.w.wrapper;

/**
 * @author blue
 * @version 1.0
 */
public class WrapperType {
    //boolean --> Boolean
    //char --> Character
    //byte --> Byte
    public static void main(String[] args) {
        Integer integer = 2;
        int i = integer;
        String str = integer.toString();
        System.out.println(str);

    }

}

