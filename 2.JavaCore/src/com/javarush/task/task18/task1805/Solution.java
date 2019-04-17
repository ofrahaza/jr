package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream fileIn = new FileInputStream(scan.nextLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileIn.available() > 0) {
            list.add(fileIn.read());
        }
        HashSet<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        for (int i : list) {
            System.out.print(i + " ");
        }

        fileIn.close();
    }
}
