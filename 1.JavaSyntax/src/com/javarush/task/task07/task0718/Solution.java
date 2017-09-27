package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            String read = reader.readLine();
            list.add(i, read);
        }
        for (int n = 1; n<list.size(); ){
            if(list.get(n).length()>list.get(n-1).length()){
                n++;
            }
            else {
                System.out.println(n);
                break;
            }

        }
        //напишите тут ваш код
    }
}

