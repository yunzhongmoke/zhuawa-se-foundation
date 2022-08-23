package com.w.set_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author blue
 * @version 1.0
 */
public class HashSetExercise02 {
    public static void main(String[] args) throws ParseException {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee1("q", new MyDate("1", "1", "1")));
        hashSet.add(new Employee1("w", new MyDate("1", "1", "1")));
        hashSet.add(new Employee1("q", new MyDate("1", "1", "1")));
        for (Object o : hashSet) {
            System.out.println(o);
        }
//        String s = "2020-1-23";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//        Date date = format.parse(s);
//        System.out.println(date);
    }
}

class Employee1 {
    private String name;
    private MyDate birthday;

    public Employee1(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(name, employee1.name) && Objects.equals(birthday, employee1.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) throws ParseException {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    //格式化日期
    public static String SDFormat(String year, String month, String day) {
        String s = year + "-" + month + "-" + day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String DATE = sdf.format(date);
        return DATE;
    }

    @Override
    public String toString() {
        return SDFormat(year, month, day);
    }
}