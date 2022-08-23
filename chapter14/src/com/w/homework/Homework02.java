package com.w.homework;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Car("q", 2000));
        list.add(new Car("w", 3000));
        list.add(new Car("e", 4000));
        Car r = new Car("r", 5000);

        list.add(r);
        //list.remove(0);
        //System.out.println(list.contains(r));
        //System.out.println(list.size());
        //list.clear();
        //System.out.println(list.isEmpty());
        Car t = new Car("t", 5000);
        Car y = new Car("y", 5000);
        ArrayList list1 = new ArrayList();
        list1.add(t);
        list1.add(y);
        list.addAll(list1);
        System.out.println(list.containsAll(list1));
        list.removeAll(list1);
        System.out.println(list);
        for (Object o : list) {
            System.out.println(o);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
