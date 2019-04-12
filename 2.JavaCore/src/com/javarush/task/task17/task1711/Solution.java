package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name, sexInfo;
        Sex sex;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateInfo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person;
        Date bd;
        int index;
        switch (args[0]) {
             case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        sex = (args[i + 1] == "м") ? Sex.MALE : Sex.FEMALE;
                        bd = date.parse(args[i + 2]);
                        if (sex.equals(Sex.MALE)) {
                            person = Person.createMale(name, bd);
                            allPeople.add(person);
                        } else {
                            person = Person.createFemale(name, bd);
                            allPeople.add(person);
                        }
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        index = Integer.parseInt(args[i]);
                        name = args[i + 1];
                        sex = (args[i + 2] == "м") ? Sex.MALE : Sex.FEMALE;
                        bd = date.parse(args[i + 3]);
                        person = allPeople.get(index);
                        person.setName(name);
                        person.setSex(sex);
                        person.setBirthDate(bd);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        person = allPeople.get(index);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        person = allPeople.get(index);
                        sexInfo = (person.getSex() == Sex.MALE) ? "м" : "ж";
                        System.out.println(person.getName() + " " + sexInfo + " " + dateInfo.format(person.getBirthDate()));
                    }
                }
                break;
        }
    }
}
