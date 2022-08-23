package com.w.thread;

/**
 * @author blue
 * @version 1.0
 */
public class Thread02 {
    public static void main(String[] args) {

        T1 t1 = new T1();
        Thread thread1 = new Thread(t1);
        thread1.start();

        Thread thread2 = new Thread(t1);
        thread2.start();

        T2 t2 = new T2();
        //t2.start();
    }
}

class T1 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("T1 " + (++count) + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 50) {
                break;
            }
        }
    }
}

class T2 extends Thread {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("T2 " + (++count) + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 60) {
                break;
            }
        }
    }
}
