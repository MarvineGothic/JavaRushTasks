package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        return 0;
    }
}
*/
public class Solution {        // solved
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        int i = 0;
        if (n == 0 || n == 1) return 1;
        if (n > 1) {
            i = n * factorial(n - 1);
        }
        return i;
    }
}
