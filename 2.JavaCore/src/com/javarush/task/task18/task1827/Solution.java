package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String file, id, productName, price, quantity;
        file = scan.nextLine();
        BufferedReader fReader = new BufferedReader(new FileReader(file));
        FileWriter fWriter = new FileWriter(file);
        String line;
        int maxID = Integer.MIN_VALUE;
        while((line = fReader.readLine()) != null) {
            if(Integer.valueOf(line.substring(0,line.indexOf(" "))) > maxID) {
                maxID = Integer.valueOf(line.substring(0, line.indexOf(" ")));
            }
        }
        maxID++;

        if (args[0] != null) {
            id = "" + maxID;
            productName = editString(args[1],30);
            price = editString(args[2],8);
            quantity = editString(args[3],4);
            line = id + " " + productName + " " + price + " "  + quantity;
            fWriter.write(line);
        }
        fReader.close();
        fWriter.close();
    }


    public static String editString(String s, int count) {
        String result;
        if (s.length() > count) {
            result = s.substring(0,count-1);
        } else {
            result = s;
            for (int i = 0; i < count - s.length() - 1; i++) {
                result = result + " ";
            }
        }
        return result;
    }
}
