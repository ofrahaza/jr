package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String result = "";
        try {
            String[] arr = string.split(" ");
            return String.format("%s %s %s %s", arr[1], arr[2], arr[3], arr[4]);
          //  result = string.substring(string.indexOf("\\s") + 1);
        } catch (Exception e) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
