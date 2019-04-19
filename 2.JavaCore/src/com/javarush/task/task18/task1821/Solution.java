package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < 128; i++) {
            map.put((char)i,0);
        }
        try
        {
            BufferedReader br = new BufferedReader (new FileReader(args[0]));
            int c;
            while((c = br.read())!=-1){
                map.replace((char)c,map.get((char)c)+1);
            }
            br.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0)
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
