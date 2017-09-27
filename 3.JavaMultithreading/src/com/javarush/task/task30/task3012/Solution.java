package com.javarush.task.task30.task3012;

/* 
Получи заданное число
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
    }
}
*/

public class Solution {               // not solved
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.sign(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код


    }


    public void sign(int x) {
        int a = x % 3;
        int b = x / 3;
        StringBuilder string = new StringBuilder();
        System.out.print(string);
        if (a == 0) string.append("0");//System.out.print("0");
        if (a == 1)  string.append("+");//System.out.print("+");
        if (a == 2) {
           string.append("-");// System.out.print("-");
            b++;
        }
        if (b > 2) {
            sign(b);
        }
        if (b == 1) string.append("+");//System.out.print("+");
        if (b == 2) string.append("-");//System.out.print("-");
    }
}