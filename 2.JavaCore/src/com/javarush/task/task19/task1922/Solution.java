package com.javarush.task.task19.task1922;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String s;
        Pattern pattern;
        Matcher matcher;

        while((s = file.readLine()) != null) {
            int count = 0;
                for (String singleWord : words) {
                    if (s.contains(singleWord)) {
                        pattern = Pattern.compile("\\b" + singleWord + "\\b");
                        matcher = pattern.matcher(s);
                        while (matcher.find()) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    System.out.println(s);
                }
        }

        reader.close();
        file.close();
    }
}
