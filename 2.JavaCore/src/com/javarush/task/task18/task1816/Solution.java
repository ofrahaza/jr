package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isLetter;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader(args[0]);

        /*
        int c;
        int count = 0;
        while ((c = file.read()) != -1) {
            if (isLetter((char)c)) {
                count++;
            }
        }
        file.close();
        System.out.println(count);
    }     */

        int iChar;
        int count = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        while ((iChar = file.read()) != -1) {
            char ch = (char) iChar;
            if (Character.isLetter(ch)) {
                Matcher matcher = pattern.matcher(Character.toString(ch));
                if (matcher.matches())
                    count++;
            }
        }
        System.out.println(count);
        file.close();
    }
}
