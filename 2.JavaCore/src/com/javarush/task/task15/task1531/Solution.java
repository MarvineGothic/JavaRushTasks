package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here

        return "";
    }
}

*/

public class Solution {      // solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        if (input < 0) System.out.println(0);
        else
            System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n==0) return "1";
        int a = 1;
        for (int i = 1; i < n + 1; i++) {
            a = a * i;
        }
        String b = String.valueOf(a);
        return b;
    }
}
