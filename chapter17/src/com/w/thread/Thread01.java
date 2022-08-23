package com.w.thread;

/**
 * @author blue
 * @version 1.0
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    private int count;

    @Override
    public void run() {
        while (true) {
            System.out.println("Cat" + ++count + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
