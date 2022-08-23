package com.w.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);
        m.put("jack", 2600);
        //System.out.println(m);
//        Collection values = m.values();
//        for (Object value : values) {
//            Integer value1 = (Integer) value;
//            value1 += 100;
//
//        }
//        Set set1 = m.keySet();
//        for (Object o : set1) {
//            m.put(o, (Integer) m.get(o) + 100);
//        }
//        System.out.println(m);

        Set set = m.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            Integer i = (Integer) entry.getValue();
            i += 100;
            entry.setValue(i);
        }
        for (Object o : set) {
            System.out.println(o);
        }
        Collection values = m.values();
        for (Object value : values) {
            System.out.println(value);
        }


    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
