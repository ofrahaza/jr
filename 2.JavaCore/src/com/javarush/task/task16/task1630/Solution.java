package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //add your code here - добавьте код тут
    
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) { }
    }
    
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        
        String fileName;
        String fileContent = "";

        public void setFileName(String fullFileName){
            fileName = fullFileName;
        }
        public String getFileContent() {
            return fileContent;
        }
        
        @Override 
        public void run(){
            try {
                BufferedReader fr = new BufferedReader(new FileReader(fileName));
                StringBuilder sb = new StringBuilder();
                synchronized (sb) {
                    while (fr.ready()) {
                        sb.append(fr.readLine()).append(" ");
                    }
                    fr.close();
                    fileContent = sb.toString();

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
