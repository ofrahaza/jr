package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        int resFirst = first != null ? first.hashCode() : 0;
        int resLast = last != null ? last.hashCode() : 0;
        int res =  31 * resFirst + resLast;
        return res;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;

        if (o == null) return false;

        if(o == this) return true;

        Solution n = (Solution) o;


        if(first != null ? !first.equals(n.first) : n.first != null)
            return false;
        if(last != null ? !last.equals(n.last) : n.last != null)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
