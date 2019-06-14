package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null || telNumber.isEmpty()) return false;
        int numbersCount = telNumber.replaceAll("\\D", "").length();

        if (telNumber.matches("^\\+{1}\\d{1,3}?(\\(\\d+\\))? \\d+-?\\d+-?\\d+$") && numbersCount == 12) return true;

        if (telNumber.matches("\\d?(\\(\\d{3}\\))?(\\d+-){0,2}?\\d+$") && numbersCount==10) return true;

        return false;
    }

    public static void main(String[] args) {

    }
}
