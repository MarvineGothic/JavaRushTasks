package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/*public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
    }
}*/

public class Solution {          // solved
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = threads.get(1);
        thread2.start();
        Thread.sleep(100);
        thread2.interrupt();

        Thread thread4 = threads.get(3);
        Message message = (Message) thread4;
        thread4.start();
        Thread.sleep(100);
        message.showWarning();
        System.out.println(thread4.isAlive());
    }

    public static class ThreadOne extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadTwo extends Thread {
        public void run() {
            try {
                while (!isInterrupted()) {

                }
                throw new InterruptedIOException();
            } catch (InterruptedIOException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class ThreadFour extends Thread implements Message {
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadFive extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            try {
                while (!isInterrupted()) {
                    String s = reader.readLine();
                    if (s.equals("N")) this.interrupt();
                    else {
                        int n = Integer.parseInt(s);
                        sum += n;
                    }
                }
                throw new InterruptedException();
            } catch (IOException e) {

            } catch (InterruptedException e) {
                System.out.println(sum);
            }
        }
    }
}