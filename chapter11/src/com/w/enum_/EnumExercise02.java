package com.w.enum_;

/**
 * @author blue
 * @version 1.0
 */
public class EnumExercise02 {
    public static void main(String[] args) {
        System.out.println("==所有星期的信息如下==");
        Day[] days = Day.values();
        for (Day day : days) {
            System.out.println(day);
        }
    }
}

enum Day {

    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String name;

    private Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}