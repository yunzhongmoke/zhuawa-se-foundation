package com.w.tankgame05;

import java.io.*;
import java.util.Vector;

/**
 * @author blue
 * @version 1.0
 */
public class Recorder {
    private static int touchEnemyNum = 0;
    private static String recordFile = "src\\myRecord.txt";
    private static BufferedWriter bw = null;
    //定义Vector，指向MyPanel对象的敌方坦克Vector
    private static Vector<Enemy> enemies = null;
    //定义Vector，保存Node对象
    private static Vector<Node> nodes = new Vector<>();
    private static BufferedReader br = null;

    public static int getTouchEnemyNum() {
        return touchEnemyNum;
    }

    public static void setTouchEnemyNum(int touchEnemyNum) {
        Recorder.touchEnemyNum = touchEnemyNum;
    }

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static String getRecordFile() {
        return recordFile;
    }

    //增加数量
    public static void addTouchEnemyNum() {
        Recorder.touchEnemyNum++;
    }

    //存取文件
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(touchEnemyNum + "\r\n");
            //遍历敌方坦克的Vector
            for (int i = 0; i < enemies.size(); i++) {
                //取出敌方坦克
                Enemy enemy = enemies.get(i);
                if (enemy.isLive) {
                    String record = enemy.getX() + " " + enemy.getY() + " " + enemy.getDirection();
                    //写入到文件
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取文件
    public static Vector<Node> getRecorder() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            touchEnemyNum = Integer.parseInt(br.readLine());
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return nodes;
    }

}
