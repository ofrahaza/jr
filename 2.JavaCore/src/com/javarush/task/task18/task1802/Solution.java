package com.javarush.task.task18.task1802;

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
        int b = Integer.MAX_VALUE;
        int data = 0;
        while (inputStream.available() > 0) {
            data = inputStream.read();
            if (data < b) b = data;
        }
        inputStream.close();
        System.out.println(b);
    }
}
