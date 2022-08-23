package com.w.thread.homework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        One one = new One();
        one.start();

        Two two = new Two(one);
        Thread thread = new Thread(two);
        thread.start();
    }
}

class One extends Thread {

    private boolean loop = true;

    Random r = new Random();
    private int num = 0;

    @Override
    public void run() {
        while (loop) {
            num = r.nextInt(100);
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Two implements Runnable, KeyListener {

    private One one;

    public Two(One one) {
        this.one = one;
    }

    Scanner sc = new Scanner(System.in);
    private char c = ' ';

    @Override
    public void run() {
        while (true) {
            System.out.println("输入一个字符：");
            c = sc.next().toUpperCase(Locale.ROOT).charAt(0);
            if (c == 'Q') {
                one.setLoop(false);
                System.out.println("Two退出");
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            c = 'Q';
            System.out.println("Q");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
