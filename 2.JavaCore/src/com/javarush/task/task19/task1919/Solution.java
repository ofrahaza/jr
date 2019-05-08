package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String s, name = "";
        float value = 0;
        TreeMap<String, Float> map = new TreeMap<>();
        while ((s = file.readLine()) != null) {
            name = s.substring(0, s.indexOf(" "));
            value = Float.parseFloat(s.substring(s.indexOf(" ") + 1));
            value = value + map.getOrDefault(name,0f);
            map.put(name, value);
        }
        file.close();
            for (Map.Entry e : map.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue());

            }
        }
    }

