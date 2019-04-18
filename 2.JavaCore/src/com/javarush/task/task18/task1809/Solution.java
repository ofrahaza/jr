package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileInputStream fileIn1 = new FileInputStream(scan.nextLine());
        FileOutputStream fileOut2 = new FileOutputStream(scan.nextLine());
        ArrayList<Integer> l = new ArrayList<>();
        try {
            while(fileIn1.available() > 0) {
                l.add(fileIn1.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = l.size()-1; i >= 0; i--) {
            fileOut2.write(l.get(i));
        }
        fileIn1.close();
        fileOut2.close();
    }
}
