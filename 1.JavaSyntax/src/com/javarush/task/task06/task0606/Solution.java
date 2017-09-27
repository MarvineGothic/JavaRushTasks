package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.ArrayList;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        reader.close();

        while (x > 0) {
            if (x%2 == 0)
                even++;
             else odd++;
            x = x / 10;
        }

        System.out.println("Even: " + even + " Odd: " + odd);

        //напишите тут ваш код
    }

}
