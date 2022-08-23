package com.w.list_;

import java.util.*;

/**
 * @author blue
 * @version 1.0
 */
public class ListExercise02 {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add(new Book("q", 12, "q"));
//        list.add(new Book("w", 11, "w"));
//        list.add(new Book("e", 14, "e"));
//        bubble(list);
//        for (Object o : list) {
//            System.out.println(o);
//        }
//
//        List list1 = new ArrayList();
//        for (int i = 0; i < 15; i++) {
//            list1.add(i);
//        }
//
//        List list2 = new ArrayList(8);
//
//        List list3 = new Vector(8);
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.remove();
    }

    //冒泡排序
    public static void bubble(List list) {
        //按价格排序 低->高
        //Object temp = null;
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                //向下转型
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
//                    temp = list.get(j);
//                    list.set(j,list.get(j+1));
//                    list.set(j+1,temp);
                    list.set(j, book2);
                    list.set(j + 1, book1);

                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t" + "价格：" + price + "\t\t" + "作者：" + author;
    }
}
