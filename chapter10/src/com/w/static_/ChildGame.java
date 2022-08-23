package com.w.static_;

public class ChildGame {

    public static void main(String[] args) {

        Child child1 = new Child("q");
        child1.join();
        child1.count++;

        Child child2 = new Child("w");
        child2.join();
        child2.count++;

        Child child3 = new Child("e");
        child3.join();
        child3.count++;

        //类变量，可以通过类名类访问
        System.out.println("共有" + Child.count + " 小孩加入了游戏..");
    }

}
class Child{//类
    private String name;
    //定义一个变量 count，是一个类变量(静态变量) static 静态
    //该变量最大的特点就是会被Child 类的所有对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join(){
        System.out.println(name + " 加入了游戏~");
    }
}
