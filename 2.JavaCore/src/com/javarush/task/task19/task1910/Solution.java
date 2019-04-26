package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine(), true));
        String s;

        String replace = "!";
        while (fileReader.ready()) {
            s = fileReader.readLine();
            s = s.replaceAll("\\p{Punct}", "");
            s = s.replaceAll("\\n", "");
            fileWriter.write(s);
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
