package com.w;

/**
 * @author blue
 * @version 1.0
 */
public class Car {

    public String brand = "比亚迪";
    public int price = 5000;
    public String color = "green";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
