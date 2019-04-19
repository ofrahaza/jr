package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader f1 = new BufferedReader(new FileReader(scan.nextLine()));
        String line;
       // ArrayList<String> list = new ArrayList<>();
        //int i = Integer.valueOf(args[0]);
        while((line = f1.readLine()) != null){
            if (line.startsWith(args[0] + " ")) {
                //Collections.addAll(list, line.split(" "));
                System.out.print(line);
                break;
            }
        }
        /*
        for (int n = 1; n < list.size(); n++) {
            System.out.print(list.get(n) + " ");
        }
        */
        f1.close();
    }
}
