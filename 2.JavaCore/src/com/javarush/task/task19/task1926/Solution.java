package com.javarush.task.task19.task1926;

/* 
Перевертыши
public class Solution {
    public static void main(String[] args) {
    }
}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {                 // solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));

        while (fileIn.ready()){
            String line = fileIn.readLine();
            System.out.println(new StringBuffer(line).reverse().toString());
        }

        reader.close();
        fileIn.close();
    }
}