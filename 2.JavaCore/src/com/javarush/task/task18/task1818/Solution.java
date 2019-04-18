package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileOutputStream fileIn1 = new FileOutputStream(scan.nextLine());
        FileInputStream fileIn2 = new FileInputStream(scan.nextLine());
        FileInputStream fileIn3 = new FileInputStream(scan.nextLine());
        int c;
        while((c = fileIn2.read()) > 0) {
            fileIn1.write(c);
        }

        while((c = fileIn3.read()) > 0) {
            fileIn1.write(c);
        }
        fileIn1.close();
        fileIn2.close();
        fileIn3.close();
    }
}
