package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Charset windows1251 = Charset.forName("Windows-1251");
        FileInputStream reader = new FileInputStream(args[0]);
        FileOutputStream writer = new FileOutputStream(args[1]);

        byte[] buffer = new byte[reader.available()];
        reader.read(buffer);

        writer.write(new String(buffer, "Windows-1251").getBytes("UTF-8"));

        reader.close();
        writer.close();

    }
}
