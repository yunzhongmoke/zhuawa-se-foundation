package com.w.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author blue
 * @version 1.0
 */
public class DrawCircle extends JFrame {

    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(300, 400);
        this.setVisible(true);
        //退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10, 10, 100, 100);
    }
}
