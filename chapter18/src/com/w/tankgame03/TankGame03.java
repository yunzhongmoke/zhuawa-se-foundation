package com.w.tankgame03;

import javax.swing.*;

/**
 * @author blue
 * @version 1.0
 */
public class TankGame03 extends JFrame {

    //定义MyPanel
    MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame03 tankGame02 = new TankGame03();
    }

    public TankGame03() {
        myPanel = new MyPanel();
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.setSize(1000, 750);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
