package com.javarush.task.task19.task1921;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String s;
        Pattern pat = Pattern.compile("([\\D]+)\\D+(\\d+ \\d+ \\d+)");
        Matcher mat;
        SimpleDateFormat datetime = new SimpleDateFormat("dd MM yyyy");
        while ((s = file.readLine()) != null) {
            mat = pat.matcher(s);
            while(mat.find()) {
                //System.out.println(mat.group(1) + " ");
                PEOPLE.add(new Person(mat.group(1), datetime.parse(mat.group(2))));
            }
        }
        file.close();
    }
}
