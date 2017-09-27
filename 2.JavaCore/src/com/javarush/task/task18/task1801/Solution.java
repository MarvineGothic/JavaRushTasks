package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/

public class Solution {               // solved
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        int max = 0;
        while (stream.available() > 0){
            int data = stream.read();
            if (data > max){
                max = data;
            }
        }
        stream.close();
        reader.close();
        System.out.println(max);
    }
}
// i://new/new.txt