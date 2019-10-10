package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File renamedFile = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        //FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt"));
        if (Files.exists(Paths.get(args[0]))) {
            FileUtils.renameFile(resultFileAbsolutePath,  renamedFile);
        }

        FileOutputStream fos = new FileOutputStream(renamedFile);
        List<File> filesList = new ArrayList<>();
        collectFileList(path, filesList);
        Collections.sort(filesList);

        for (File file : filesList) {
            FileInputStream fis = new FileInputStream(file);
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
            fos.write(System.lineSeparator().getBytes());
        }
        fos.close();


    }

    private static void collectFileList(File directory, List<File> list) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                collectFileList(file, list);
                continue;
            }
            if (file.length() <= 50) {
                list.add(file);
            }
        }
    }
}
