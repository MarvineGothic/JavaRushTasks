package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int c = number%10;
        int ab = number/10;
        int b = ab%10;
        int a = ab/10;
        return a+b+c;
        //напишите тут ваш код
    }
}