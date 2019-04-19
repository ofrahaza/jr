package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileInputStream inFile1 = new FileInputStream(scan.nextLine());
        FileOutputStream outFile2 = new FileOutputStream(scan.nextLine());


        byte[] b1 = new byte[inFile1.available()];
        inFile1.read(b1);
        outFile2.write(b1);
        inFile1.close();
        outFile2.close();
    }
}
