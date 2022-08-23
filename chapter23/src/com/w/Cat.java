package com.w;

/**
 * @author blue
 * @version 1.0
 */
public class Cat {

    private String name = "q";
    public int age = 2;

    public Cat(){}

    public Cat(String name){
        this.name = name;
    }

    public void hi() {
        System.out.println("hi " + name);
    }

    public void cry() {
        System.out.println("cry " + name);
    }
}
