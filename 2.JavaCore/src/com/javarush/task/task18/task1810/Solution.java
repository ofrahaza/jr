package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        FileInputStream fileIn;

        while(true) {
            fileIn = new FileInputStream(scan.nextLine());
            try {
                if (fileIn.available() < 1000) {
                    fileIn.close();
                    throw new DownloadException();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
