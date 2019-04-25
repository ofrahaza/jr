package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        String s;
        int count = 0;
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher;
        while ((s = fReader.readLine()) != null) {
            matcher = pattern.matcher(s);
            while(matcher.find()) {
                count++;
            }
        }
        reader.close();
        fReader.close();
        System.out.println(count);
    }
}
