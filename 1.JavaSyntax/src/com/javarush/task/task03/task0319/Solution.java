package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String sNumber1 = reader.readLine();
        int nNumber1 = Integer.parseInt(sNumber1);
        String sNumber2 = reader.readLine();
        int nNumber2 = Integer.parseInt(sNumber2);
        System.out.print(name + " получает " + nNumber1 + " через " + nNumber2 + " лет.");
    }
}
