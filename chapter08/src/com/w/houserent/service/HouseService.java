package com.w.houserent.service;

import com.w.houserent.domain.House;

/**
 * HouseService.java<=>类 [业务层]
 * 定义House[],保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋各种操作(增删改查crud)
 */
public class HouseService {

    private House[] houses;//保存House对象
    private int houseNum = 1;//记录当前有多少个房屋信息
    private int idCounter = 0;//记录当前的id增长到哪个值
    //构造器
    public HouseService(int size){

        //new houses
        houses = new House[size];//当创建HouseService对象，指定数组大小
        //编号  房主  电话  地址  月租  状态(未出租/已出租)
        houses[0] = new House("me", "123", "啦啦啦", 2000, "未出租");

    }
    //findById方法，返回House对象或者null
    public House findById(int findId) {
        //遍历数组
        for (int i = 0; i < houseNum; i++) {
            if(findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId) {

        //应当招到要删除的房屋信息对应的下标
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if(delId == houses[i].getId()) {//要删除的房屋id，是数组下标为i的元素
                index = i;
            }
        }

        if(index == -1) {//说明delId在数组中不存在
            return false;
        }
        //如果找到
        for (int i = 0; i < houseNum - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNum] = null;//把当前存在的房屋信息的最后一个，设置为null
        return true;

    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse) {
        //判断是否还能继续添加
        if(houseNum == houses.length) {//不能再添加
//            System.out.println("不能再添加了");
//            return false;

            //实现扩容
            House[] arr = new House[houses.length+1];
            for (int i = 0; i < houses.length; i++) {
                arr[i] = houses[i];
            }

            houses = arr;

        }
        //把newHouse对象加入到，新增加了一个房屋
        houses[houseNum++] = newHouse;
        //设计一个id自增加的机制
        newHouse.setId(++idCounter);
        return true;

    }

    //list方法，返回houses
    public House[] list(){
        return houses;
    }

}
