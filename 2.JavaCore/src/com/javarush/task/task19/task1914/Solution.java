package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        int resultInt;
        String[] resultString = result.split("\\s");
        if (resultString[1].equals("+")) {
            resultInt = Integer.parseInt(resultString[0]) + Integer.parseInt(resultString[2]);
        } else if (resultString[1].equals("-")) {
            resultInt = Integer.parseInt(resultString[0]) - Integer.parseInt(resultString[2]);
        } else {
            resultInt = Integer.parseInt(resultString[0]) * Integer.parseInt(resultString[2]);
        }
        result += resultInt;
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

