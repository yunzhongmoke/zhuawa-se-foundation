package com.w.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author blue
 * @version 1.0
 */
public class BallMove extends JFrame {

    private MyPanel myPanel = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400, 300);
        //添加键盘监听事件
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {

    //初始化小球坐标
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
