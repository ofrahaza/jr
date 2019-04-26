package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        Pattern pat = Pattern.compile("\\b\\d+\\b");
        Matcher mat;
        while (fileReader.ready()) {
            s = fileReader.readLine();
            mat = pat.matcher(s);
            while(mat.find()) {
                fileWriter.write(mat.group() + " ");
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
//"\b\d+\b"