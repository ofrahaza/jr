package com.javarush.task.task17.task1710;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

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
                name = args[1];
                sex = (args[2] == "м") ? Sex.MALE : Sex.FEMALE;
                bd = date.parse(args[3]);
                    if (sex.equals(Sex.MALE)) {
                        person = Person.createMale(name, bd);
                        allPeople.add(person);
                    } else {
                        person = Person.createFemale(name, bd);
                        allPeople.add(person);
                    }
                System.out.println(allPeople.indexOf(person));
                break;
            case "-u":
                index = Integer.parseInt(args[1]);
                name = args[2];
                sex = (args[3] == "м") ? Sex.MALE : Sex.FEMALE;
                bd = date.parse(args[4]);
                person = allPeople.get(index);
                person.setName(name);
                person.setSex(sex);
                person.setBirthDate(bd);
                break;
            case "-d":
                index = Integer.parseInt(args[1]);
                person = allPeople.get(index);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
            case "-i":
                index = Integer.parseInt(args[1]);
                person = allPeople.get(index);
                sexInfo = (person.getSex() == Sex.MALE) ? "м" : "ж";
                System.out.println(person.getName() + " " + sexInfo + " " + dateInfo.format(person.getBirthDate()));
                break;
        }
    }
}
