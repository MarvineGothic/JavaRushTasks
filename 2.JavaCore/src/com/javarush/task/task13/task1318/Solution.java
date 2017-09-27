package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла


public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}
*/

public class Solution {      // not solved
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream stream = new FileInputStream(fileName);
        Scanner sc = new Scanner(stream);

        while (sc.hasNext())
        {
            Object x = sc.next();
            System.out.println(x);
        }
        stream.close();
        reader.close();
    }
}
