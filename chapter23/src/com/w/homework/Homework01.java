package com.w.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //得到Class对象
        Class<?> pTClass = Class.forName("com.w.homework.PrivateTest");
        //创建对象
        Object o = pTClass.getDeclaredConstructor().newInstance();

        Field name = pTClass.getDeclaredField("name");
        //需要对name进行暴破
        name.setAccessible(true);
        name.set(o, "la");

        Method getName = pTClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);


    }
}

class PrivateTest{
    private String name = "hellokitty";

    public String getName(){
        return name;
    }
}
