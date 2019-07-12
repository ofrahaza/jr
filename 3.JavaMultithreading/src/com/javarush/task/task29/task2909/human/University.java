package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        super(name, age);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }






    public Student getStudentWithAverageGrade(double d) {
        for (Student s : students) {
            if(s.getAverageGrade() == d) {
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double d = Double.MIN_VALUE;
        Student student = new Student("name", 0, 0);
        for (Student s : students) {
            if(s.getAverageGrade() > d) {
                d = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        double d = Double.MAX_VALUE;
        Student student = new Student("name", 0, 0);
        for (Student s : students) {
            if(s.getAverageGrade() < d) {
                d = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}