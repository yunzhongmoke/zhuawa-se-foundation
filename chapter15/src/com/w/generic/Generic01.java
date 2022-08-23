package com.w.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author blue
 * @version 1.0
 */
public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        //dogs.add(new Cat("q"));// 报错
        dogs.add(new Dog("狗子"));
        Iterator<Dog> iterator = dogs.iterator();
        while (iterator.hasNext()) {
            Dog next = iterator.next();
            System.out.println(next.getName());
        }
    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String name) {
        this.name = name;
    }
}

class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }
}
