package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String s;
        Scanner scan = new Scanner(System.in);
        while (!((s = scan.nextLine()).equals("exit"))) {
            list.add(s);
        }
        for (String str : list) {
            ReadThread r = new ReadThread(str);
            r.start();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
        }
        String fileName;
        int[] l = new int[256];
        int count = 0;
        int b;

        @Override
         public void run() {
            try {
                FileInputStream f = new FileInputStream(fileName);
                while (f.available() > 0) {
                    l[f.read()]++;
                }
                f.close();
            } catch (IOException e) {
                    e.printStackTrace();
                }
            for (int i = 0; i < l.length; i++) {
                if (l[i] > count) {
                    count = l[i];
                    b = i;
                }
            }
            resultMap.put(fileName, b);
        }

    }
}
