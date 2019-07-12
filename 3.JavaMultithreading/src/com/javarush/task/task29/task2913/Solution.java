package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String result = "";
        int c;
        if (a < b) {
            c = a;
            while (c <= b) {
                result += c + " ";
                c++;
            }
            return result.trim();
        } else {
            if (a == b) {
                return Integer.toString(a);
            }

            c = a;
            while (c >= b) {
                result += c + " ";
                c--;
            }

            return result.trim();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(100);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}