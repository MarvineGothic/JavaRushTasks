package com.javarush.task.task34.task3403;

/*
Разложение на множители с помощью рекурсии
public class Solution {
    public void recursion(int n) {
    }
}
*/
public class Solution {      // solved
    public static void main(String[] args) {
        Solution solution = new Solution();
        //recursion(132);
    }

    public void recursion(int n) {
        if (n > 1) {
            int m = 2;
            while (true) {
                if (n % m == 0) {
                    System.out.print(m + " ");
                    if (m == n)
                        return;
                    break;
                }
                m++;
            }
            recursion(n / m);
        }
    }
}
