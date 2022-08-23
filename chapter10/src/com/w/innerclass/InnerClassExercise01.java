package com.w.innerclass;

public class InnerClassExercise01 {

    public static void main(String[] args) {
        CellPhone cell = new CellPhone();
        cell.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cell.alarmClock(new Bell(){
            @Override
            public void ring(){
                System.out.println("小伙伴上课了");
            }
        });
    }
}
interface Bell{//接口
    void ring();//方法
}
class CellPhone{//类
    public void alarmClock(Bell bell) {//形参是Bell接口类型
        bell.ring();
    }
}
