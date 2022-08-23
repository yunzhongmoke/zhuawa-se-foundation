package com.w.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //得到Class对象
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] constructors = fileClass.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("e:\\mynew.txt");
        Method createNewFile = fileClass.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);


    }
}
