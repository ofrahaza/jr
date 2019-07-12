package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger count = new AtomicInteger(Thread.MIN_PRIORITY);


    public MyThread() {
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        setPriority(priority);
    }

    public MyThread(Runnable target) {
        super(target);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        int tgmp = currentThread().getThreadGroup().getMaxPriority();
        if (tgmp < priority) priority = tgmp;
        setPriority(priority);
    }

    public MyThread(String name) {
        super(name);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        setPriority(priority);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        int tgmp = currentThread().getThreadGroup().getMaxPriority();
        if (tgmp < priority) priority = tgmp;
        setPriority(priority);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        int tgmp = currentThread().getThreadGroup().getMaxPriority();
        if (tgmp < priority) priority = tgmp;
        setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        int priority = count.getAndIncrement();
        if (priority > Thread.MAX_PRIORITY) priority %= Thread.MAX_PRIORITY;
        if (priority == 0) priority = Thread.MAX_PRIORITY;
        int tgmp = currentThread().getThreadGroup().getMaxPriority();
        if (tgmp < priority) priority = tgmp;
        setPriority(priority);
    }
}
