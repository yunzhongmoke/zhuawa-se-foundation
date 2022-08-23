package com.w.inputstream;

import com.w.outputstream.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author blue
 * @version 1.0
 */
public class ObjectInStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "e:\\data.txt";

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readDouble());
        Object o = objectInputStream.readObject();
        Dog dog = (Dog) o;
        System.out.println(o.getClass());
        System.out.println(o);
        System.out.println(dog.getName());
    }
}
