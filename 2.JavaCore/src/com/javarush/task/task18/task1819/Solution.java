package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String file1Name = scan.nextLine();
        FileInputStream inFile1 = new FileInputStream(file1Name);
        FileOutputStream outFile1 = new FileOutputStream(file1Name);
        FileInputStream inFile2 = new FileInputStream(scan.nextLine());
        byte[] b1 = new byte[inFile1.available()];
        byte[] b2 = new byte[inFile2.available()];
        inFile1.read(b1);
        inFile2.read(b2);
        outFile1.write(b2, 0, b2.length);
        outFile1.write(b1);
        inFile1.close();
        outFile1.close();
        inFile2.close();
    }
}
