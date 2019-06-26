package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        r(e);
    }

    public void r(Throwable e){
        if(e.getCause()!=null) r(e.getCause());
        System.out.println(e.getClass().getName() +": " + e.getMessage());
    }

    public static void main(String[] args) {
    }
}
