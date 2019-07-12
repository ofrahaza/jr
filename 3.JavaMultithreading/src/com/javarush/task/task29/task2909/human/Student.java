package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    @Override
    public String getPosition() {
        return "Студент";
    }

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public void live() {
        learn();
    }

    public void learn() {
    }


    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }



    public void setCourse(double value) {
        course = (int) value;
    }

    public void setAverageGrade( double value) {
        averageGrade = value;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}