package com.w.collection_;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author blue
 * @version 1.0
 */
public class CollectionIterator {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("q");
        list.add("w");
        list.add("e");
        System.out.println(list);

        //迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //增强型for循环
        //底层仍然是迭代器

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
