package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        Pattern pat = Pattern.compile("\\.");
        Matcher mat;
        String replace = "!";
        while (fileReader.ready()) {
            s = fileReader.readLine();
            mat = pat.matcher(s);
            s = mat.replaceAll(replace);
            fileWriter.write(s);
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
