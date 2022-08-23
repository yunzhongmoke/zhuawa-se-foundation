package com.w.homework;

/**
 * @author blue
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        //抛出三个异常,ArithmeticException,ArrayIndexOutOfBoundsException,
        // NumberFormatException
        try {
            if (args.length != 3) {
                throw new ArrayIndexOutOfBoundsException("需要输入两个整数");
            }

            String str1 = args[0];
            String str2 = args[1];
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            int res = calculation(num1, num2);
            System.out.println("res=" + res);
            Object o = args[2];
            Integer i = (Integer) o;
            System.out.println("i=" + i);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("需要输入整数");
        } catch (ArithmeticException e) {
            System.out.println("除数为0");
        }catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculation(int num1, int num2) {
        return num1 / num2;
    }
}
