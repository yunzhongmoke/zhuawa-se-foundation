package com.w.tankgame03;

/**
 * @author blue
 * @version 1.0
 */
public class Tank {
    private int x;//坦克横坐标
    private int y;//坦克纵坐标
    private int direction;//坦克的方向
    private int speed = 10;//坦克的速度
    boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //控制坦克的方向
    public void moveUp() {
        direction = 0;
        y -= speed;
    }

    public void moveRight() {
        direction = 1;
        x += speed;
    }

    public void moveDown() {
        direction = 2;
        y += speed;
    }

    public void moveLeft() {
        direction = 3;
        x -= speed;
    }


}
