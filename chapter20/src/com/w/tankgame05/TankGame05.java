package com.w.tankgame05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author blue
 * @version 1.0
 */
public class TankGame05 extends JFrame {

    //定义MyPanel
    MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame05 tankGame02 = new TankGame05();
    }

    public TankGame05() {
        System.out.println("1.新游戏 2.继续游戏");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        myPanel = new MyPanel(key);
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.setSize(1300, 800);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
