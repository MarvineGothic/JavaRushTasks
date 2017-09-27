package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int x = 1, y = 0;
        for (int i = 0; i < 10; i++) {

            // x++;
            System.out.println(y += x++);
        }
    }
}
