package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStreamIn = new FileInputStream(args[1]);
        FileOutputStream fileStreamOut = new FileOutputStream(args[2]);
        int s;
        while (fileStreamIn.available() > 0) {
            s = fileStreamIn.read();
            if (args[0].equals("-e")) {
                s = s + 1;
            } else {
                s = s - 1;
            }
            fileStreamOut.write(s);
        }
        fileStreamIn.close();
        fileStreamOut.close();
    }

}
