package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object n) {

        if (n == null) return false;

        if(n == this) return true;

        if (!(n instanceof Solution)) return false;

        Solution solution = (Solution) n;

        if(first != null ? !first.equals(solution.first) : solution.first != null)
            return false;
        if(last != null ? !last.equals(solution.last) : solution.last != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int resFirst = first != null ? first.hashCode() : 0;
        int resLast = last != null ? last.hashCode() : 0;
        int res =  31 * resFirst + resLast;
        return res;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

    }
}
