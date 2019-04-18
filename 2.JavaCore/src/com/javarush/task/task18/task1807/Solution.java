package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileIn = new FileInputStream(scan.readLine());
            int count = 0;
            int c;
            try {
                while (fileIn.available() > 0) {
                    c = fileIn.read();
                    if (c == 44) {
                        count++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileIn.close();
            System.out.print(count);

    }
}
