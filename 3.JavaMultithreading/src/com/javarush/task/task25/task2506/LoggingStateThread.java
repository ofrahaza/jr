package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;
    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State state, lastState = null;

        super.run();
        do {
            state = target.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        } while (state != State.TERMINATED);
    }


}
