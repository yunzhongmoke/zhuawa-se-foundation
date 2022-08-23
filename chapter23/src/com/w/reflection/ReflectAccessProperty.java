package com.w.reflection;

import java.lang.reflect.Field;

/**
 * @author blue
 * @version 1.0
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> stuClass = Class.forName("com.w.reflection.Student");
        //创建对象
        Object o = stuClass.newInstance();
        //使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 2);
        System.out.println(age.get(o));

        //使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破
        name.setAccessible(true);
        //name是static属性
//        name.set(o, "q");
        name.set(null, "q");
        System.out.println(name.get(o));
        System.out.println(name.get(null));


    }
}

class Student{
    public int age;
    private static String name;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ",name=" + name +
                '}';
    }

}
