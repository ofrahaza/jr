package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = "";
        FileReader file = new FileReader(args[0]);
        float countSpace = 0, countChar = 0;
        int i;
        while ((i = file.read()) != -1) {
            countChar++;
            if (i == 32) countSpace++;
        }
        System.out.println(String.format("%.2f", (countSpace/countChar*100)));
        file.close();
    }
}
