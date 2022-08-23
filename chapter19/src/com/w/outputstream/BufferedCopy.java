package com.w.outputstream;

import java.io.*;

/**
 * @author blue
 * @version 1.0
 */
public class BufferedCopy {
    public static void main(String[] args) {

        String srcFilePath = "e:\\pokemon.jpg";
        String destFilePath = "e:\\pokemon3.jpg";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));

            byte[] bytes = new byte[1024];
            int readLen = 0;

            while ((readLen = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
