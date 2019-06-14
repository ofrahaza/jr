package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String, String> e : params.entrySet()) {
            if (e.getValue() != null) {
                if (result.length() == 0) {

                } else {
                    result.append( " and ");

                }
                result.append(e.getKey() + " = '" + e.getValue() + "'");
            }
        }
        return result.toString().trim();
    }
}
