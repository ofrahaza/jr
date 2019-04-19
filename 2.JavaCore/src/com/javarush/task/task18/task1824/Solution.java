package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String s;
        while (true) {
            s = scan.nextLine();
            try {
                FileInputStream f = new FileInputStream(s);
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
