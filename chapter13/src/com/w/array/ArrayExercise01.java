package com.w.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author blue
 * @version 1.0
 */
public class ArrayExercise01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("qw", 100);
        books[1] = new Book("q", 99.5);
        books[2] = new Book("word", 5);
        books[3] = new Book("qwe", 300);
        bubble(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                int difference = (int) Math.ceil(book2.getPrice()-book1.getPrice());
                return difference;
            }
        });

        System.out.println("排序后的结果====");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }



    }

    //自定义冒泡排序
    public static void bubble(Book[] books, Comparator c) {
        Book temp = null;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j], books[j + 1]) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;

                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}