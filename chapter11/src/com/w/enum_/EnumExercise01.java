package com.w.enum_;

/**
 * @author blue
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Season2 AUTUMN = Season2.AUTUMN;

        System.out.println(AUTUMN.name());

        System.out.println(AUTUMN.ordinal());

        //values() 返回Season2[]
        //含有定义的所有枚举对象
        Season2[] season2 = Season2.values();
        for (Season2 season : season2) {
            System.out.println(season);
        }

        //将枚举对象重命名
        Season2 autumn = Season2.valueOf("AUTUMN");
        System.out.println(autumn);

        Season2 SUMMER = Season2.SUMMER;
        //compareTo()方法 比较两个枚举常量，比较的就是编号
        System.out.println(SUMMER.compareTo(AUTUMN));
    }
}
