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

        if (args.length > 0) {
            Scanner scan = new Scanner(System.in);
            String file, id, productName, price, quantity;
            file = scan.nextLine();
            BufferedReader fReader = new BufferedReader(new FileReader(file));
            String line;
            int maxID = -1;

                while((line = fReader.readLine()) != null) {
                    if(Integer.valueOf(line.substring(0,8).trim()) > maxID) {
                        maxID = Integer.valueOf(line.substring(0,8).trim());
                    }
                }

            fReader.close();
            maxID++;
            id = "" + maxID;
            productName = editString(args[1],30);
            price = editString(args[2],8);
            quantity = editString(args[3],4);
            line = id + productName + price + quantity;
            FileWriter fWriter = new FileWriter(file, true);
            fWriter.write("\r\n");
            fWriter.write(line);
            fWriter.close();
        }
    }

    public static String editString(String s, int count) {
        String result;
        if (s.length() > count) {
            result = s.substring(0,count);
        } else {
            result = s;
            for (int i = 0; i < count - s.length(); i++) {
                result = result + " ";
            }
        }
        return result;
    }
}
