package com.javarush.task.task04.task0431;

/* 
От 10 до 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 11;

        while (i > 1) {
            System.out.println(--i);
        }
    }
}

//  или так:
//    int i = 10;
//     while (i > 0) {
//         System.out.println(i--);
