package com.w.homework.homework05;

/**
 * @author blue
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();
        tang.passRiver();
        tang.passRiver();
        tang.common();
        tang.common();
        tang.common();
        tang.passRiver();
        tang.fly();
        tang.passRiver();
        tang.common();
    }
}
