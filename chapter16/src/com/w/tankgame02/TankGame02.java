package com.w.tankgame02;

import javax.swing.*;

/**
 * @author blue
 * @version 1.0
 */
public class TankGame02 extends JFrame {

    //定义MyPanel
    MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame02 tankGame02 = new TankGame02();
    }

    public TankGame02() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000, 750);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
