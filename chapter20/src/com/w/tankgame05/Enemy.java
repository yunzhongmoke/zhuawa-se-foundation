package com.w.tankgame05;

import java.util.Vector;

/**
 * @author blue
 * @version 1.0
 */
public class Enemy extends Tank implements Runnable {
    //创建子弹集合
    Vector<Shot> shots = new Vector<>();
    //增加成员可以获取敌方坦克的Vector
    Vector<Enemy> enemies = new Vector<>();
    boolean isLive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }


    //获取敌方坦克
    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }

    //编写方法，判断enemy坦克是否发生重叠和碰撞
    public boolean isTouchEnemy() {

        //判断当前敌方坦克的方向
        switch (this.getDirection()) {
            case 0: //上
                //让当前敌方坦克和其他的敌方坦克比较
                for (int i = 0; i < enemies.size(); i++) {
                    //从Vector中取出单个敌方坦克
                    Enemy enemy = enemies.get(i);
                    //不和自身比较
                    if (enemy == this) {
                        continue;
                    }
                    //如果其他敌方坦克是上\下
                    if (enemy.getDirection() == 0 || enemy.getDirection() == 2) {
                        //判断当前敌方坦克左上角坐标 x,y
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 40
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 60) {
                            return false;
                        }
                        //判断当前敌方坦克右上角坐标 x+60,y
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 40
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 60) {
                            return false;
                        }
                    }
                    //如果其他敌方坦克是右\左
                    if (enemy.getDirection() == 1 || enemy.getDirection() == 3) {
                        //判断当前敌方坦克左上角坐标 x,y
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 60
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 40) {
                            return false;
                        }
                        //判断当前敌方坦克右上角坐标 x+60,y
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 60
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 1: //右
                //让当前敌方坦克和其他的敌方坦克比较
                for (int i = 0; i < enemies.size(); i++) {
                    //从Vector中取出单个敌方坦克
                    Enemy enemy = enemies.get(i);
                    //不和自身比较
                    if (enemy == this) {
                        continue;
                    }
                    //如果其他敌方坦克是上\下
                    if (enemy.getDirection() == 0 || enemy.getDirection() == 2) {
                        //判断当前敌方坦克右上角坐标 x+60,y
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 40
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 60) {
                            return false;
                        }
                        //判断当前敌方坦克右下角坐标 x+60,y+40
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 40
                                && this.getY() + 40 >= enemy.getY()
                                && this.getY() + 40 <= enemy.getY() + 60) {
                            return false;
                        }
                    }
                    //如果其他敌方坦克是右\左
                    if (enemy.getDirection() == 1 || enemy.getDirection() == 3) {
                        //判断当前敌方坦克右上角坐标 x+60,y
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 60
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 40) {
                            return false;
                        }
                        //判断当前敌方坦克右下角坐标 x+60,y+40
                        if (this.getX() + 60 >= enemy.getX()
                                && this.getX() + 60 <= enemy.getX() + 60
                                && this.getY() + 40 >= enemy.getY()
                                && this.getY() + 40 <= enemy.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 2: //下
                //让当前敌方坦克和其他的敌方坦克比较
                for (int i = 0; i < enemies.size(); i++) {
                    //从Vector中取出单个敌方坦克
                    Enemy enemy = enemies.get(i);
                    //不和自身比较
                    if (enemy == this) {
                        continue;
                    }
                    //如果其他敌方坦克是上\下
                    if (enemy.getDirection() == 0 || enemy.getDirection() == 2) {
                        //判断当前敌方坦克左下角坐标 x,y+60
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 40
                                && this.getY() + 60 >= enemy.getY()
                                && this.getY() + 60 <= enemy.getY() + 60) {
                            return false;
                        }
                        //判断当前敌方坦克右下角坐标 x+40,y+60
                        if (this.getX() + 40 >= enemy.getX()
                                && this.getX() + 40 <= enemy.getX() + 40
                                && this.getY() + 60 >= enemy.getY()
                                && this.getY() + 60 <= enemy.getY() + 60) {
                            return false;
                        }
                    }
                    //如果其他敌方坦克是右\左
                    if (enemy.getDirection() == 1 || enemy.getDirection() == 3) {
                        //判断当前敌方坦克左下角坐标 x,y+60
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 60
                                && this.getY() + 60 >= enemy.getY()
                                && this.getY() + 60 <= enemy.getY() + 40) {
                            return false;
                        }
                        //判断当前敌方坦克右下角坐标 x+40,y+60
                        if (this.getX() + 40 >= enemy.getX()
                                && this.getX() + 40 <= enemy.getX() + 60
                                && this.getY() + 60 >= enemy.getY()
                                && this.getY() + 60 <= enemy.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 3: //左
                //让当前敌方坦克和其他的敌方坦克比较
                for (int i = 0; i < enemies.size(); i++) {
                    //从Vector中取出单个敌方坦克
                    Enemy enemy = enemies.get(i);
                    //不和自身比较
                    if (enemy == this) {
                        continue;
                    }
                    //如果其他敌方坦克是上\下
                    if (enemy.getDirection() == 0 || enemy.getDirection() == 2) {
                        //判断当前敌方坦克左上角坐标 x,y
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 40
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 60) {
                            return false;
                        }
                        //判断当前敌方坦克左下角坐标 x,y+40
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 40
                                && this.getY() + 40 >= enemy.getY()
                                && this.getY() + 40 <= enemy.getY() + 60) {
                            return false;
                        }
                    }
                    //如果其他敌方坦克是右\左
                    if (enemy.getDirection() == 1 || enemy.getDirection() == 3) {
                        //判断当前敌方坦克左上角坐标 x,y
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 60
                                && this.getY() >= enemy.getY()
                                && this.getY() <= enemy.getY() + 40) {
                            return false;
                        }
                        //判断当前敌方坦克左下角坐标 x,y+40
                        if (this.getX() >= enemy.getX()
                                && this.getX() <= enemy.getX() + 60
                                && this.getY() + 40 >= enemy.getY()
                                && this.getY() + 40 <= enemy.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
        }

        return true;
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
                        if (getY() > 0 && isTouchEnemy()) {
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
                        if (getX() + 60 < 1000 && isTouchEnemy()) {
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
                        if (getY() + 60 < 750 && isTouchEnemy()) {
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
                        if (getX() > 0 && isTouchEnemy()) {
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
