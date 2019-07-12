package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
    public static AtomicInteger factoryNumbers = new AtomicInteger(1);
    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {


            private  AtomicInteger thread = new AtomicInteger(1);
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            int factoryNumber = factoryNumbers.getAndIncrement();
            @Override
            public Thread newThread(Runnable r) {
                Thread th = new Thread(threadGroup,r);
                th.setName(String.format("%s-pool-%s-thread-%s", threadGroup.getName(), factoryNumber, thread.getAndIncrement()));
                th.setDaemon(false);
                th.setPriority(5);
                return th;
            }

    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
