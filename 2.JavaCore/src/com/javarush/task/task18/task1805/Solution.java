package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/

public class Solution {               // solved
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sort = new ArrayList<>();


        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        inputStream.close();
        reader.close();

      //  Collections.sort(list);



        for (int i = 0; i < list.size()-1; i++)
        {
            if (list.get(i).equals(list.get(i + 1)))
            {
                list.remove(i);
                i--;
            }
        }

        for (Integer i : list)
        {
            System.out.print(i + " ");
        }
    }


}
