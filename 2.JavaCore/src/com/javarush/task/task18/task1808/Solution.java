package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
        FileOutputStream fileOut3 = new FileOutputStream(scan.nextLine());
        //ArrayList<Integer> l = new ArrayList<>();
        int listLength;
        byte[] f2;
        byte[] f3;

        if (fileIn1.available() % 2 == 0) {
            listLength = fileIn1.available()/2;
            f2 = new byte[listLength];
            f3 = new byte[listLength];

        } else {
            listLength = (fileIn1.available()/2) + 1;
            f2 = new byte[listLength];
            f3 = new byte[listLength-1];
        }

        try {
            if (fileIn1.available() != -1) {
                fileIn1.read(f2);
                fileIn1.read(f3, 0, f3.length);
            }

            fileOut2.write(f2);
            fileOut3.write(f3);


        } catch (IOException e) {
            e.printStackTrace();
        }
            /*
            try {
                if (fileIn1.available() != -1) {
                    l.add(fileIn1.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if ((l.size()) % 2 == 0) {
                listLength = l.size()/2;
            } else {
                listLength = (l.size()/2)+1;
            }
            for (int i = 0; i < listLength; i++) {
                fileOut2.write(l.get(i));
            }
            for (int j = listLength; j < l.size(); j++) {
                fileOut3.write(l.get(j));
            } */
            fileIn1.close();
            fileOut2.close();
            fileOut3.close();
    }
}
