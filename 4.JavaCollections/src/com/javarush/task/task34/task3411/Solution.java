package com.javarush.task.task34.task3411;

/* 
Ханойские башни
public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
    }
}
*/

public class Solution {          // solved
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
        if (count == 1) print(a, b);
        else {
            if (count > 1) {
                moveRing(a, c, b, count - 1);
                print(a, b);
                moveRing(c, b, a, count - 1);
            }
        }
    }

    public static void print(char a, char b) {
        System.out.println("from " + a + " to " + b);
    }
}