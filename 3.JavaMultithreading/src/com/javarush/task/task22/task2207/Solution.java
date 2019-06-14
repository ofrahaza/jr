package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String s;

        while((s = file.readLine()) != null) {
            for (String o : s.replace("\uFEFF", "").split("\\s")) {
                list.add(o);
            }
        }
        reader.close();
        file.close();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) continue;
            StringBuilder stringBuilder = new StringBuilder(list.get(i));
            stringBuilder.reverse();
            String reversedString = stringBuilder.toString();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == null) continue;
                if (j == i) continue;
                if (list.get(j).equals(reversedString)) {
                    result.add(new Pair(list.get(i),list.get(j)));
                    list.set(i, null);
                    list.set(j, null);
                    break;
                }
            }

        }

        for (Pair p : result) {
            System.out.println(p.toString());
        }
    }

    public static class Pair {
        String first;
        String second;
        public Pair() {
        }


        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
