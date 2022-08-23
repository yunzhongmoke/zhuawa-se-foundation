package com.w.homework.homework05;

/**
 * @author blue
 * @version 1.0
 */
//交通工厂，实现各种交通
public class VehiclesFactory {

    //得到马类
    //一直骑白龙马
    //构造方法私有化
    private VehiclesFactory() {
    }
    //单例模式-->饥汉式
    private static Horse horse = new Horse();

    public static Horse getHorse() {
        return horse;
    }

    //得到船对象
    public static Boat getBoat() {
        return new Boat();
    }

    //得到飞机对象
    public static Aircraft getAircraft() {
        return new Aircraft();
    }
}
