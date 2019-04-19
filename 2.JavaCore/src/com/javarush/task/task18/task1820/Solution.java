package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader f1 = new BufferedReader(new FileReader(scan.nextLine()));
        BufferedWriter f2 = new BufferedWriter(new FileWriter(scan.nextLine()));
        String line;
        ArrayList<String> list = new ArrayList<String>();

        while((line = f1.readLine()) != null){
            Collections.addAll(list, line.split(" "));
        }

        int f;
        for (String s : list) {
            f = (int) Math.round(Double.parseDouble(s));
            System.out.print(f + " ");
            f2.write(f + " ");
            //f2.write(" ");
        }
        f1.close();
        f2.close();
    }
}


