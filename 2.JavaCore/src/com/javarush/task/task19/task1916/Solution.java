package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String s;

        while (file1.ready()) {
            s = file1.readLine();
            list1.add(s);
        }

        while (file2.ready()) {
            s = file2.readLine();
            list2.add(s);
        }

        while (list1.size() < list2.size()) {
            list1.add("");
        }

        while (list1.size() >= list2.size()) {
            list2.add("");
        }


        for (int i =0; i < list1.size(); i++) {

            if (list1.get(i).equals(list2.get(i))) {
            } else if (!list1.get(i).equals(list2.get(i+1))) {
                list2.add(i,"");
            } else {
                list1.add(i, "");
            }
        }
        while (list1.size() < list2.size()) {
            list1.add("");
        }

        while (list1.size() > list2.size()) {
            list2.add("");
        }

        for (int l = 0; l < list2.size(); l++) {
            if (list1.get(l).equals(list2.get(l)) && list1.get(l).equals("") && list1.get(l).equals("")) {
                list1.remove(l);
                list2.remove(l);
            }
        }

            for (int i =0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i)) && !list1.get(i).equals("")) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            } else if(list1.get(i).equals("")) {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
            } else {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
        }

        for (LineItem q : lines) {

            System.out.println(q.type + " " + q.line);
        }

        reader.close();
        file1.close();
        file2.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
