package com.w.set_;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author blue
 * @version 1.0
 */
public class LinkedHashSetExercise01 {
    public static void main(String[] args) {
        HashSet lhs = new LinkedHashSet();
        lhs.add(new Car("q", 2));
        lhs.add(new Car("w", 2));
        lhs.add(new Car("q", 2));
        lhs.add("q");
        lhs.add("q");
        for (Object o : lhs) {
            System.out.println(o);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}