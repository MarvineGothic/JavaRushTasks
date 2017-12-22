package com.javarush.task.task14.task1421;

/* 
Singleton
public class Solution {
    public static void main(String[] args) {
    }
}
*/
public class Solution {                   // solved
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton.equals(singleton1));
        System.out.println(singleton.toString());
        System.out.println(singleton1.toString());

    }
}
