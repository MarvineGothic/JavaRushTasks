package com.javarush.task.task14.task1420;

/* 
НОД
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/

import java.util.Scanner;

public class Solution {                   // solved
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        int nod = 0;

        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        if (num1 <= 0 || num2 <= 0) {
            throw new NumberFormatException();
        }

        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0 && i > nod) {
                nod = i;
            }
        }

        System.out.println(nod);
    }
}
