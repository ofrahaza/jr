package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        FileWriter file2 = new FileWriter(args[1]);
        String s;
        Pattern pattern = Pattern.compile("[\\S]{7,}");
        Matcher matcher;

        int i = 0;
        while((s = file1.readLine()) != null) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                if (i != 0) {
                    file2.write(",");
                }
                file2.write(matcher.group());
                i++;
            }
        }
        file1.close();
        file2.close();
    }
}
