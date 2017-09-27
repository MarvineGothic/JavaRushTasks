package com.javarush.task.task10.task1011;

/* 
Большая зарплата

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код

    }

}
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        int i = 0;
        while (i<40){
            System.out.println( s.substring(i, s.length()));
            i++;
        }
    }

}

