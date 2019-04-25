package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-d")) {
            Scanner scan = new Scanner(System.in);
            String file, id, productName, price, quantity;
            file = scan.nextLine();
            BufferedReader fReader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> list = new ArrayList<>();
            while((line = fReader.readLine()) != null) {
                if(!(line.substring(0,8).trim().equals(args[1])) ) {
                    list.add(line);
                }
            }
            fReader.close();

            FileWriter fWriter = new FileWriter(file, false);
            for (String st : list) {
                fWriter.write(st + "\r\n");
            }
            fWriter.close();

        } else if (args[0].equals("-u")) {
            Scanner scan = new Scanner(System.in);
            String file;
            file = scan.nextLine();
            BufferedReader fReader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> list = new ArrayList<>();
            while((line = fReader.readLine()) != null) {
                if(!(line.substring(0,8).trim().equals(args[1])) ) {
                    list.add(line);
                } else {
                    line = line.substring(0,8) + editString(args[2],30) + editString(args[3],8) + editString(args[4],4);
                    list.add(line);
                }
            }
            fReader.close();

            FileWriter fWriter = new FileWriter(file, false);
            for (String st : list) {
                fWriter.write(st + "\r\n");
            }
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
