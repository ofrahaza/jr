package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        System.out.println(thread.getName());
       while(!thread.isInterrupted()) {
           try {
               thread.sleep(100);
               System.out.println(thread.getName());

           } catch (Exception e) {

           }
       }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    public void stop() {
        try {
           // Thread.currentThread().interrupt();
            thread.interrupt();
        } catch (Exception e) {

        }
    }


}
