package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i<10; i++)
        {
            for (int w = 0; w<10; w++)
            {
                System.out.print(((i+1) * (w+1)) + " ");
            }
            System.out.println();
        }
    }
}
