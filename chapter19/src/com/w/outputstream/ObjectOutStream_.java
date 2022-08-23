package com.w.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author blue
 * @version 1.0
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\data.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        objectOutputStream.writeInt(100);
        objectOutputStream.writeDouble(200);
        objectOutputStream.writeObject(new Dog("q", 2));
    }
}
