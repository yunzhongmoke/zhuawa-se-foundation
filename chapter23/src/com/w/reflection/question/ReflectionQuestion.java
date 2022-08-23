package com.w.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class ReflectionQuestion {

    public static void main(String[] args) {

        //创建Properties对象
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\re.properties"));
            String classfullpath = properties.getProperty("classfullpath");
            String methodName = properties.get("method").toString();

            //利用反射
            //得到类
            Class<?> cls = Class.forName(classfullpath);
            //得到对象
            //Object o = cls.newInstance();
            Object o = cls.getDeclaredConstructor().newInstance();
            //得到方法的对象
            Method method = cls.getMethod(methodName);
            method.invoke(o);
            //得到字段/属性
            Field nameField = cls.getField("age");
            System.out.println(nameField.get(o));
            //得到构造器
            Constructor<?> constructor = cls.getConstructor();
            System.out.println(constructor);
            Constructor<?> constructor1 = cls.getConstructor(String.class);
            System.out.println(constructor1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
