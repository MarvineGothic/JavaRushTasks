package com.javarush.task.task25.task2506;

/**
 * Created by Admin on 08.06.2017.
 */
public class LoggingStateThread extends Thread {

    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != this.target.getState()) {
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }
}
