package com.javarush.task.task14.task1420;

/* 
НОД
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {                   // solved
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);

        nod(c, d);

    }

    public static void nod(int a, int b) {
        if (a > b) a = a - b;
        else b = b - a;
        if (b == 0) {
            System.out.println(a);
            return;
        }
        nod(a, b);
    }
}
