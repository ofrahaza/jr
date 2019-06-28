package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        public int compare(T o1, T o2) {
            for (Comparator<T> c : comparators) {
                int result = c.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }

    }
}
