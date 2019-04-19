package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();
        String s;
        Scanner scan = new Scanner(System.in);
        while (!((s = scan.nextLine()).equals("end"))) {
            set.add(s);
        }
        FileOutputStream fileOutput = new FileOutputStream(set.first().substring(0, set.first().indexOf(".part")));
        FileInputStream f;
        for (String str : set) {
            f = new FileInputStream(str);
            byte[] b = new byte[f.available()];
            f.read(b);
            fileOutput.write(b);
            f.close();
        }
        fileOutput.close();
    }
}
