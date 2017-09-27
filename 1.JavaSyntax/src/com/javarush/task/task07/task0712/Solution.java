package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> List = new ArrayList<String>();

        int max = 0;
        int min = 0;
        for (int i = 0; i < 10; i++) {
            String read = reader.readLine();
            List.add(i, read);
        }
        for (int i = 0; i<List.size(); i++){
            if (List.get(i).length()<List.get(min).length()){
                min = i;
            }
            if (List.get(i).length() > List.get(max).length()){
                max = i;
            }
        }
        for (int i = 0; i<List.size(); i++){
            if (i == min || i == max) {
                System.out.println(List.get(i));
                break;
            }
        }
        //напишите тут ваш код
    }
}
