package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String file1, file2;
        file1 = scan.nextLine();
        file2 = scan.nextLine();
        FileReader infile1 = new FileReader(file1);
        FileReader infile2 = new FileReader(file2);
        BufferedReader reader1 = new BufferedReader(infile1);
        BufferedReader reader2 = new BufferedReader(infile2);
        String s;
        Solution sol = new Solution();

        while ((s = reader1.readLine()) != null){
            allLines.add(s);
        }
        reader1.close();

        while ((s = reader2.readLine()) != null){
            forRemoveLines.add(s);
        }

        reader2.close();
        sol.joinData();
    }

    public void joinData() throws CorruptedDataException {
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        for (int i = 0; i < allLines.size(); i++) {
            for (String d : forRemoveLines) {
                if (allLines.get(i) == d) {
                    allLines.remove(i);
                }
            }
        }
    }
}
