package com.w.tankgame03;

import java.util.Vector;

/**
 * @author blue
 * @version 1.0
 */
public class Enemy extends Tank implements Runnable {
    //创建子弹集合
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {

            //shots集合
            if (isLive && shots.size() < 10) {
                Shot shot = null;
                switch (getDirection()) {
                    case 0:
                        shot = new Shot(getX() + 20, getY(), 0);
                    case 1:
                        shot = new Shot(getX() + 60, getY() + 20, 1);
                    case 2:
                        shot = new Shot(getX() + 20, getY() + 60, 2);
                    case 3:
                        shot = new Shot(getX(), getY() + 20, 3);
                }

                //加入到shots集合中
                shots.add(shot);
                //启动线程
                new Thread(shot).start();
            }

            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        //线程休眠
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        //线程休眠
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        //线程休眠
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        //线程休眠
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //随机改变坦克方向
            setDirection((int) (Math.random() * 4));

            //退出线程
            if (!isLive) {
                break;
            }
        }
    }
}
