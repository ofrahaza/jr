package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        FileInputStream inFile = new FileInputStream(filePath);
        int count = 0;
       // int dbyte = Integer.MIN_VALUE;

        List list = new ArrayList<Integer>();
        List result = new ArrayList<Integer>();
        result.add(Integer.MIN_VALUE);

        while(inFile.available() > 0) {
            list.add(inFile.read());
        }

        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) > count)  {
                result.clear();
                count = Collections.frequency(list, list.get(i));
                //dbyte = (int) list.get(i);
                result.add(list.get(i));
            }
            else {
                if ((Collections.frequency(list, list.get(i)) == count) && (list.get(i) != list.get(0))) {
                    result.add(list.get(i));
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print((byte) result.get(i) + " ");
        }

        inFile.close();
    }
}
