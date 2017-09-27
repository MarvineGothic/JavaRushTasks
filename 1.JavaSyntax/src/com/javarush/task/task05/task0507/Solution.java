package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x;
        int y = 0;
        float sum = 0;
        while ((x = Integer.parseInt(reader.readLine())) != -1){

            sum = sum + x;
            y++;

        }

            System.out.println(sum/y);

        //напишите тут ваш код
    }
}

