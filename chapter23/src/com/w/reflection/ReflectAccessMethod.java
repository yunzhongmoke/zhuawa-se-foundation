package com.w.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author blue
 * @version 1.0
 */
public class ReflectAccessMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //得到Boss类对应的Class对象
        Class<?> bossClass = Class.forName("com.w.reflection.Boss");
        //创建对象
        Object o = bossClass.getDeclaredConstructor().newInstance();
        //调用hi方法
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "q");

        //调用say方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        //需要对private属性的方法进行暴破
        say.setAccessible(true);
//        Object invoke = say.invoke(o, 100, "w", 'e');
        Object invoke = say.invoke(null, 100, "w", 'e');
        System.out.println(invoke);
        System.out.println(invoke.getClass());



    }

}

class Boss {
    public int age;
    private static String name;

    public Boss() {

    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("hi " + s);
    }
}
