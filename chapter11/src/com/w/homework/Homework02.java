package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.shout();
        cat.shout();
    }
}
abstract class Animal{
    public abstract void shout();
}
class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("猫会喵喵叫~~~");
    }
}
class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("狗会汪汪叫~~~");
    }
}
