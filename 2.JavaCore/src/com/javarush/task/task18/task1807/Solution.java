package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
public class Solution {
    public static void main(String[] args) {
    }
}
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {                // solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Character> characters = new ArrayList<>();
        while (inputStream.available() > 0){
            characters.add((char) inputStream.read());
        }
        inputStream.close();
        reader.close();

        countChar(characters);
    }

    private static void countChar(ArrayList<Character> list){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(',')){
                count++;
            }
        }
        System.out.println(count);
    }
}
