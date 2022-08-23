package com.w.homework.homework05;

/**
 * @author blue
 * @version 1.0
 */
public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //过河
    public void passRiver(){
        //判断交通工具是否符合
        //利用instanceof 来判断运行类型
        if(!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        //使用接口调用
        //动态绑定机制
        vehicles.work();
    }

    //一般情况
    public void common() {
        //判断交通工具是否符合
        //利用instanceof 来判断运行类型
        //判断不等于所需要的运行类型，其中也满足的非空(对象为null)的条件
        if(!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    //过火焰山
    public void fly() {
        //判断交通工具是否符合
        //利用instanceof 来判断运行类型
        if(!(vehicles instanceof Aircraft)) {
            vehicles = VehiclesFactory.getAircraft();
        }
        vehicles.work();
    }

}
