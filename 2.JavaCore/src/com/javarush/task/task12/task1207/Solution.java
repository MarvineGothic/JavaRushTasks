package com.javarush.task.task12.task1207;

/* 
Int и Integer
public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
}
*/

public class Solution {            // solved
    public static void main(String[] args) {
// Т.К. b типа Integer, то сработает метод именно с Integer
        Integer b = 9;
        print(9);
        print(b.hashCode());

    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(Integer a) {
        System.out.println(a);
    }
    //Напишите тут ваши методы
}
