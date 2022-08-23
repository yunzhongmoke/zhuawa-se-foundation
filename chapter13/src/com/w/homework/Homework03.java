package com.w.homework;

import java.util.Locale;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03 {

    public static void main(String[] args) {
        String name = "Wu long Jun";
        a(name);
        name.intern();
    }

    public static void a(String name) {
        String[] names = name.split(" ");
        char c = names[1].toUpperCase().charAt(0);
        //String newName = names[2] + " " + names[0] + " ." + c;
        String format = String.format("%s %s .%c", names[2], names[0], c);
        System.out.println(format);
    }
}
