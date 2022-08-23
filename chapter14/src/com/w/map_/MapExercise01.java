package com.w.map_;

import java.util.*;

/**
 * @author blue
 * @version 1.0
 */
public class MapExercise01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee(1, "q", 2000));
        map.put(2, new Employee(2, "w", 1000));
        map.put(3, new Employee(3, "e", 4000));
        map.put(3, new Employee(3, "e", 4000));

        Set set = map.keySet();
        for (Object o : set) {
            Employee e = (Employee) map.get(o);
            if (e.getSalary() < 2000) {
                continue;
            }
            System.out.println(map.get(o));
        }

        System.out.println();
        Collection values = map.values();
        for (Object o : values) {
            Employee e = (Employee) o;
            if(e.getSalary() < 2000) {
                continue;
            }
            System.out.println(e);
        }

        System.out.println();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Employee e= (Employee) next;
            if(e.getSalary() < 2000) {
                continue;
            }
            System.out.println(e);

        }


        System.out.println();
        Set set1 = map.entrySet();
        for (Object o : set1) {
            Map.Entry entry = (Map.Entry) o;
            Object key = entry.getValue();
            Employee e = (Employee) key;
            if (e.getSalary() < 2000) {
                continue;
            }
            System.out.println(e);
        }
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
