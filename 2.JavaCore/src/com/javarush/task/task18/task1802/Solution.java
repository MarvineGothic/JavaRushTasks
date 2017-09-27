package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/

public class Solution {                    // solved
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int min = inputStream.read();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();    // very important to initialize a new variable
            if (data < min){
                min = data;
            }
        }
        reader.close();
        inputStream.close();

        System.out.println(min);
    }

}
// i://new/new.txt