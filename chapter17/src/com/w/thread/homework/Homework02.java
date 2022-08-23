package com.w.thread.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {

        Card card = new Card();

        User1 user1 = new User1(card);
        user1.start();

        User2 user2 = new User2(card);
        Thread thread = new Thread(user2);
        thread.start();
//        System.out.println(0 < 0);
    }
}

class Card {
    public int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class User1 extends Thread {

    private Card card;

    public User1(Card card) {
        this.card = card;
    }

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            synchronized (card) {
                if (card.getBalance() <= 0) {
                    loop = false;
                    return;
                }
                System.out.println("User1取款");
                card.setBalance(card.getBalance() - 1000);
                System.out.println("余额 " + card.getBalance());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class User2 implements Runnable {

    private Card card;

    public User2(Card card) {
        this.card = card;
    }

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            synchronized (card) {
                if (card.getBalance() <= 0) {
                    loop = false;
                    return;
                }
                System.out.println("User2取款");
                card.setBalance(card.getBalance() - 1000);
                System.out.println("余额 " + card.getBalance());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
