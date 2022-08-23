package com.w.reflection.class_;

import com.w.Car;

/**
 * @author blue
 * @version 1.0
 * 演示得到Class对象的各种方法
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName
        String classAllPath = "com.w.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2.类名.class,用于参数传参
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //3.对象.getClass,用于有对象示例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器[4种]来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        //5.基本数据
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        //6.基本数据类型对应的包装类
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());
    }
}
