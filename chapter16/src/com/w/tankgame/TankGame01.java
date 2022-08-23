package com.w.tankgame;

import javax.swing.*;

/**
 * @author blue
 * @version 1.0
 */
public class TankGame01 extends JFrame {

    //定义MyPanel
    MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
