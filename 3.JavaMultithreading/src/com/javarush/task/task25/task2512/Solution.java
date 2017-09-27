package com.javarush.task.task25.task2512;

/* 
Живем своим умом

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
    }

    public static void main(String[] args) {
    }
}
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e.getCause() != null) uncaughtException(t, e.getCause());
        System.out.println((e.getClass()+ ": " + e.getMessage()).substring(6));
    }

    public static void main(String[] args) {
    }
}
