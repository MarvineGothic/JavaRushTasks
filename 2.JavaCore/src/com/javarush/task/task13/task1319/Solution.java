package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли


public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

    }
}
*/

public class Solution {                         //  solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())));

        String next;
        do
        {
            next = reader.readLine();
            writer.write(next);

            if (!next.equals("exit"))
            {
                writer.newLine();
            }
            else break;
        }
        while (!next.equals("exit"));
        reader.close();
        writer.close();
        // напишите тут ваш код
    }
}