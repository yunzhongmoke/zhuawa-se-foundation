package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args) {
        Car car = new Car(50);
        car.getAir().flow();
        car.setTemperature(-1);
        car.getAir().flow();
        car.setTemperature(20);
        car.getAir().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature >= 40) {
                System.out.println("冷风");
            } else if (temperature <= 0) {
                System.out.println("暖风");
            } else {
                System.out.println("关闭空掉");
            }
        }
    }

    //返回一个Air对象
    public Air getAir() {
        return new Air();
    }

    //在方法中创建Air对象，并且调用对象中的方法
//    public void work() {
//        Air air = new Air();
//        air.flow();
//    }

}
