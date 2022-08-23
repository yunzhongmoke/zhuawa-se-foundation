package com.w.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author blue
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String filePath = "src\\dog.properties";
        Dog dog = null;
        String serFilePath = "e:\\dog.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            properties.load(new FileReader(filePath));
            String name = properties.getProperty("name");
            int age = Integer.parseInt(properties.getProperty("age"));
            String color = properties.getProperty("color");
            dog = new Dog(name, age, color);
            System.out.println(dog);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(serFilePath));
            objectOutputStream.writeObject(dog);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void Deserializable(){
        String serFilePath = "e:\\dog.dat";
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(serFilePath));
            Dog dog = (Dog) ois.readObject();
            System.out.println(dog);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
