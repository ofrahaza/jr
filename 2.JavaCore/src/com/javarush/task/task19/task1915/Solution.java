package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileWriter = new FileOutputStream(reader.readLine());

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        fileWriter.write(result.getBytes());
        reader.close();
        fileWriter.close();

        /*
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

         */


        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

