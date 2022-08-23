package com.w.tankgame05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

/**
 * @author blue
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    private Hero hero;

    //    Tank tank1 = null;
//    Tank tank2 = null;
//    Tank tank3 = null;
    //创建一个敌方坦克集合
    Vector<Enemy> enemies = new Vector<>();
    //集合大小
    int enemiesSize = 5;

    //设置Node对象的结婚
    Vector<Node> nodes = null;

    //定义一个Vector， 用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹的图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;




    public MyPanel(String key) {
        hero = new Hero(600, 100);//初始化自己的坦克

//        tank1 = new Tank(0, 0);
//        tank2 = new Tank(100, 0);
//        tank3 = new Tank(200, 0);



        //开始新游戏或者继续游戏
        File file = new File(Recorder.getRecordFile());
        if (!file.exists()){
            System.out.println("开始新游戏");
            key = "1";
        }
        switch (key){
            case "1":
                //初始化敌方坦克
                for (int i = 0; i < enemiesSize; i++) {
                    Enemy enemy = new Enemy(100 * (i + 1), 0);
                    //设置方向
                    enemy.setDirection(2);
                    //启动坦克线程
                    new Thread(enemy).start();
                    //加入
                    enemies.add(enemy);
                    //将敌方坦克集合加入至Enemy enemies
                    enemy.setEnemies(enemies);
                    //创建子弹
                    Shot shot = new Shot(enemy.getX() + 20, enemy.getY() + 60, enemy.getDirection());
                    //添加
                    enemy.shots.add(shot);
                    //启动子弹线程
                    new Thread(shot).start();
                }
                break;
            case "2":
                //遍历node对象
                nodes = Recorder.getRecorder();
                for (int i = 0; i < nodes.size(); i++) {
                    //取出Node对象
                    Node node = nodes.get(i);
                    //创建Enemy对象
                    Enemy enemy = new Enemy(node.getX(), node.getY());
                    //direction
                    enemy.setDirection(node.getDirection());
                    //启动坦克线程
                    new Thread(enemy).start();
                    //加入至enemies
                    enemies.add(enemy);
                    //将敌方坦克集合加入至Enemy enemies
                    enemy.setEnemies(enemies);
                    //创建子弹
                    Shot shot = new Shot(enemy.getX() + 20, enemy.getY() + 60, enemy.getDirection());
                    //添加
                    enemy.shots.add(shot);
                    //启动子弹线程
                    new Thread(shot).start();
                }
                break;
        }


        //将MyPanel对象中的 enemies 设置给Recorder中的enemies
        Recorder.setEnemies(enemies);

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    //显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g) {

        //画出玩家的总成绩
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累积击毁的坦克", 1020, 30);
        g.drawString(Recorder.getTouchEnemyNum() + "", 1080, 100);
        drawTank(1020, 60, g, 0, 0);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//默认是黑色

        //调用showInfo方法
        showInfo(g);

        //画出坦克-封装方法
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        }
        //Hero画出子弹
//        if (hero.getShot() != null && hero.getShot().isLive() == true) {
//            g.draw3DRect(hero.getShot().getX(), hero.getShot().getY(), 1, 1, false);
//        }

        //将hero的子弹集合shots，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive() == true) {
                g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
            } else {
                //如果shot对象无效
                hero.shots.remove(shot);
            }
        }

        //如果bombs 集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个的bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让这个炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life为0，就从bomb的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

//        drawTank(tank1.getX(), tank1.getY(), g, tank1.getDirection(), 1);
//        drawTank(tank2.getX(), tank2.getY(), g, tank2.getDirection(), 1);
//        drawTank(tank3.getX(), tank3.getY(), g, tank3.getDirection(), 1);
        //遍历敌方坦克，并画出
        for (int i = 0; i < enemies.size(); i++) {
            //从Vector中取出坦克
            Enemy enemy = enemies.get(i);
            //判断当前坦克是否还存活
            if (enemy.isLive) { //当坦克是存活的才画出该坦克
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 0);

                //画出 enemy 所有子弹
                for (int j = 0; j < enemy.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemy.shots.get(j);
                    if (shot.isLive()) {
                        g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
                    } else {
                        enemy.shots.remove(shot);
                    }
                }
            }
        }

        //敌方坦克子弹

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

    //击中hero
    public void hitHero() {
        //遍历敌方坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            //遍历子弹
            for (int j = 0; j < enemy.shots.size(); j++) {
                Shot shot = enemy.shots.get(j);
                //判断hero是否被击中
                if (hero.isLive && shot.isLive()) {
                    hitTanks(shot, hero);
                }
            }
        }
    }

    //击中敌方坦克
    public void hitEnemyTank() {

        //发射多颗子弹
        for (int j = 0; j < hero.shots.size(); j++) {

            Shot shot = hero.shots.get(j);

            //判断是否击中了敌方坦克
            if (shot != null && shot.isLive()) {
                //遍历敌方所有的坦克
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    hitTanks(shot, enemy);
                }
            }
        }

        //单颗子弹
        //判断是否击中了敌方坦克
//        if (hero.getShot() != null && hero.getShot().isLive()) {
//            //遍历敌方所有的坦克
//            for (int i = 0; i < enemies.size(); i++) {
//                Enemy enemy = enemies.get(i);
//                hitTanks(hero.getShot(), enemy);
//            }
//        }
    }

    //编写方法，判断子弹是否击中坦克
    public void hitTanks(Shot s, Tank tank) {
        //判断s 击中坦克
        switch (tank.getDirection()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 40
                        && s.getY() > tank.getY() && s.getY() < tank.getY() + 60) {
                    s.setLive(false);
                    tank.isLive = false;
                    //子弹击中后，去除坦克
                    enemies.remove(tank);
                    //击毁敌方坦克时，touchEnemyNum++
                    if (tank instanceof Enemy) {
                        Recorder.addTouchEnemyNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //右
            case 3: //左
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 60
                        && s.getY() > tank.getY() && s.getY() < tank.getY() + 40) {
                    s.setLive(false);
                    tank.isLive = false;
                    //子弹击中后，去除坦克
                    enemies.remove(tank);
                    //击毁敌方坦克时，touchEnemyNum++
                    if (tank instanceof Enemy) {
                        Recorder.addTouchEnemyNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //如果用户按下J，发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //判断子弹是否销毁，一颗子弹
//            if (hero.getShot() == null || !hero.getShot().isLive()) {
//                hero.shotEnemyTank();
//            }
            //发射多颗子弹
            hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        //重绘地图
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断是否击中敌方坦克
            hitEnemyTank();
            //判断是否击中hero坦克
            hitHero();

            this.repaint();
        }
    }
}
