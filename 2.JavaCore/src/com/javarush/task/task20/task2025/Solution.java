package com.javarush.task.task20.task2025;

import java.util.Set;
import java.util.TreeSet;
/*
Алгоритмы-числа
*/
public class Solution {

    private static Set<Long> amstrongSet = new TreeSet<>();
    private static long[][] pows;
    private static long T;

    public static long[] getNumbers(long N) {
        long[] result = null;
        T = N;
        if (N > 0) {
            int numberLength = ("" + (N)).length();
            genPows(numberLength);

            for (int i = 1; i <= numberLength; i++) {
                generate(1, 0, i);
            }

            result = new long[amstrongSet.size()];
            int i = 0;

            for (Long l : amstrongSet) {
                result[i++] = l;
            }
            amstrongSet.clear();

        } else {
            return result;
        }
       /* int o = 0;
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
            o++;
        }
        System.out.println();
        System.out.println(o);*/
       // T = 0;
        return result;
    }

    public static void generate(int first, long number, int rank)
    {
        for(int i = first; i < 10; i++){
            long result = number + i * ((long)(Math.pow(10, rank -1)));

            if (result < 0) return;

            long sumOfPowers = sum(result);
            if (isArmstrong(sumOfPowers) && result < T) {
                amstrongSet.add(sumOfPowers);
            }
            if(rank > 1) generate(i, result, rank-1);
        }
    }

    public static long sum(long a) {
        long addition = 0;


        int d = ("" + a).length();
        if (a > 0 && a < 10) {
            return a;
        }
        int b = (int) (a % 10);
        while (a >= 1) {
            addition += pows[b][d];
            a /= 10;
            b = (int) (a % 10);
        }



        //System.out.println(addition);
        return addition;
    }

    private static void genPows(int N) {
        if (N > 19) throw new IllegalArgumentException();

        pows = new long[10][N+2];
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < N+2; j++) {
                pows[i][j] = getPow(i, j);
            }
        }
    }

    public static boolean isArmstrong(long number) {

        boolean isAmstrong = false;
        if (sum(number) ==  number && number < T) {
            isAmstrong = true;
        }
        //System.out.println(isAmstrong);
        return isAmstrong;
    }

    public static long getPow(int num, int exp) {
        long l = 1;
        for (int i = 0; i < exp; i++)
            l *= (long)num;
        return l;
    }


    public static void main(String[] args) {
        //
        //genPows(3);
        //sum(1357);
        //isAmstrong(372);
        //generate(1,0, 4);
      /* for (int i = 0; i < pows.length; i++) {
           System.out.println(Arrays.toString(pows[i]));
       }*/
       // getNumbers(Long.MAX_VALUE + 1);
        getNumbers(1000);
        getNumbers(100);
        //getNumbers(-867);
        // System.out.println(Long.MAX_VALUE);
        /*for (int i = 1; i <= 18; i++) {
            generate(1, 0, i);
        }
        for (long l : amstrongSet) {
            System.out.println(l);
        }*/
    }
}
