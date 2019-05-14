package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        FileWriter file2 = new FileWriter(args[1]);
        String s;
        Pattern pattern = Pattern.compile("\\b\\S*\\d+\\S*\\b");
        Matcher matcher;

        while((s = file1.readLine()) != null) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                file2.write(matcher.group() + " ");
            }
        }
        file1.close();
        file2.close();
    }
}
