package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException, ParseException {
            String s = this.fileScanner.nextLine();
            String[]arr =  s.split("\\s",4);
            SimpleDateFormat datetime = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = datetime.parse(arr[3]);
            return new Person(arr[1],arr[2],arr[0],birthDate);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
