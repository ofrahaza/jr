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

        List list = new ArrayList<Integer>();
        List result = new ArrayList<Integer>();


        while(inFile.available() > 0) {
            list.add(inFile.read());
        }

        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) > count)  {
                result.clear();
                count = Collections.frequency(list, list.get(i));
                result.add(list.get(i));
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(j) == list.get(i)) {
                        list.remove(j);
                    }
                }
            }
            else {
                if (Collections.frequency(list, list.get(i)) == count) {
                    result.add(list.get(i));
                    for (int j = i+1; j < list.size(); j++) {
                        if (list.get(j) == list.get(i)) {
                            list.remove(j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        inFile.close();
    }
}
