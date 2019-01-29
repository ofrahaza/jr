package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.*;
import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int b = 0;
        int data = 0;
        while (inputStream.available() > 0) {
            data = inputStream.read();
            if (data > b) data = b;
        }
        inputStream.close();
        System.out.println(data);
    }
}
