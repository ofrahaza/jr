package com.javarush.task.task30.ClientServerChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            s = readString();
        }
        return s;
    }

    public static int readInt() {
        int n = 0;
        try {
            n = Integer.parseInt(readString());

        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            n = readInt();
        }
        return n;
    }
}
