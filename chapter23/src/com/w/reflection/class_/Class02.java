package com.w.reflection.class_;

import com.w.Car;

import java.lang.reflect.Field;

/**
 * @author blue
 * @version 1.0
 */
public class Class02 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.w.Car";
        //1.获取到Car类对应的Class对象
        Class<?> cls = Class.forName(classAllPath);
        //2.输出cls
        System.out.println(cls);
        System.out.println(cls.getClass());
        //3.得到包名
        System.out.println(cls.getPackage().getName());
        //4.得到全类名
        System.out.println(cls.getName());
        //5.通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);
        //6.通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //7.通过反射给属性赋值
        brand.set(car, "BYD");
        System.out.println(brand.get(car));
        //8.获取所有字段(属性)
        System.out.println("======");
        Field[] fields = cls.getFields();
        for (Field field : fields){
            System.out.println(field.getName());
//            System.out.println(field.get(car));
        }



    }

}
