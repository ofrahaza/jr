package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        String s;

        while((s = file1.readLine()) != null) {
            for (int i = s.length()-1; i >=0; i--) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
        reader.close();
        file1.close();

    }
}
