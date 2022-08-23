package com.w.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author blue
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
//    Tank tank1 = null;
//    Tank tank2 = null;
//    Tank tank3 = null;
    //创建一个敌方坦克集合
    Vector<Enemy> enemies = new Vector<>();
    //集合大小
    int enemiesSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
//        tank1 = new Tank(0, 0);
//        tank2 = new Tank(100, 0);
//        tank3 = new Tank(200, 0);
        for (int i = 0; i < enemiesSize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            //设置方法
            enemy.setDirection(2);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//默认是黑色

        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
//        drawTank(tank1.getX(), tank1.getY(), g, tank1.getDirection(), 1);
//        drawTank(tank2.getX(), tank2.getY(), g, tank2.getDirection(), 1);
//        drawTank(tank3.getX(), tank3.getY(), g, tank3.getDirection(), 1);
        for (Enemy enemy : enemies) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
        }
    }

    //编写方法，画出坦克

    /**
     * @param x         坦克的左上角x坐标
     * @param y         坦克的左上角y坐标
     * @param g         画笔
     * @param direction 坦克的方法
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        //根据不同类型坦克，设置不同的颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌方坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        switch (direction) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
