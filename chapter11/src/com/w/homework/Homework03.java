package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {

        CellPhone cell = new CellPhone();
        cell.TestWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 1, 2);
    }
}

interface ICalculate {
    double work(double n1, double n2);
}

class CellPhone {
    public void TestWork(ICalculate iCalculate, double n1, double n2) {
        System.out.println(iCalculate.work(n1, n2));
    }
}