package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution(getName()) {
            void printName() {
                System.out.println("The Darkside Hacker");
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
