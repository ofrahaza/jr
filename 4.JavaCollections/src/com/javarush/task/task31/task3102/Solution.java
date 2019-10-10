package com.javarush.task.task31.task3102;

import sun.misc.Queue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        ArrayDeque<File> queue = new ArrayDeque<File>();
        List<String> filelist = new ArrayList<>();
        Collections.addAll(queue, file.listFiles());

        while (!queue.isEmpty()) {
            File currentFile = queue.remove();

            if (currentFile.isDirectory()) {
                Collections.addAll(queue, currentFile.listFiles());
            } else {
                filelist.add(currentFile.getAbsolutePath());
            }
        }
        return filelist;
    }

    public static void main(String[] args) {
        
    }
}
