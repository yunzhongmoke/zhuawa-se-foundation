package com.w.generic;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author blue
 * @version 1.0
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("qw", 3000, new MyDate(2002, 4, 5)));
        employees.add(new Employee("q", 2000, new MyDate(2003, 1, 1)));
        employees.add(new Employee("qwe", 1000, new MyDate(2004, 2, 4)));
        employees.add(new Employee("123", 1000, new MyDate(2005, 2, 4)));
        employees.add(new Employee("234", 1000, new MyDate(2004, 5, 4)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().length() == o2.getName().length()) {
                    //return (int) (o2.getBirthday().getTime() - o1.getBirthday().getTime()); //数据太大，可能导致结果有误
//                    int i = (int) Math.ceil(o1.getBirthday().getTime() - o2.getBirthday().getTime());
//                    return i;
                    return o1.compareTo(o2);
                }

                return o1.getName().length() - o2.getName().length();
//                int i = (int) Math.ceil(o2.getBirthday().getTime() - o1.getBirthday().getTime());
//                return i;
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
            //System.out.println(employee.getBirthday().getTime());
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday.format(birthday);
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) Math.ceil(getBirthday().getTime() - o.getBirthday().getTime());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //转换为Date类型
    public Date format(MyDate birthday) {
        String s = "" + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDay();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
