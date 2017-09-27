package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
        double sum = 7;
        double n = 0;
        double average = sum/n;
        System.out.println(average);
    }

    public static double convertCelsiumToFahrenheit(int celsium) {

        double tc = celsium;
        return tc*9/5 + 32;
        //напишите тут ваш код

    }
}