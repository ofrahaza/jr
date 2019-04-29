package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String resultString = result.replaceAll("te", "??");
        System.out.println(resultString);
    }

    public static class TestString {
        public void printSomething() {

            System.out.println("it's a text for testing");
        }
    }
}
