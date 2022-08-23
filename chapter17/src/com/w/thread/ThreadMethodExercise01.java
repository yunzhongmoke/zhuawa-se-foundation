package com.w.thread;

/**
 * @author blue
 * @version 1.0
 */
public class ThreadMethodExercise01 {
    public static void main(String[] args) throws InterruptedException {

        Son son = new Son();
        Thread thread = new Thread(son);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            Thread.sleep(1000);
            if (i == 4) {
                thread.start();
                thread.join();
            }
        }
    }
}

class Son implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
            count++;
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
