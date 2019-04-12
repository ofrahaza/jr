package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Scanner;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        FileInputStream inFile = new FileInputStream(filePath);

        long[] l = new long[256];

        while (inFile.available() > 0) {
            l[inFile.read()]++;
        }

        /*
        long minRepeat = 0;
        for (int i = 0; i < l.length; i++) {
            if ((l[i] < minRepeat) || (l[i] != 0)) minRepeat = l[i];
        }
        */

        for (int i = 0; i < l.length; i++) {
            if (l[i] == 1) System.out.print(i + " ");
        }
        inFile.close();
    }
}
