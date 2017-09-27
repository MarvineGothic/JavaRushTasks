package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] Street = new int[15];

        Scanner scanner = new Scanner(System.in);
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < Street.length; i++) {
            //      Street[i] = Integer.parseInt(reader.readLine());
            Street[i] = scanner.nextInt();
        }
        //напишите тут ваш код
        int Even = 0;
        int Odd = 0;
        for (int i = 0; i < Street.length; i++) {
            if (i%2 == 0){
                Even = Street[i] + Even;
            } else Odd = Street[i] + Odd;
        }
        if (Even > Odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
