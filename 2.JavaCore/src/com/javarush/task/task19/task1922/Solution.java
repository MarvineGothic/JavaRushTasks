package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

    }
}
*/

public class Solution {                          // solved
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        ArrayList<String> fileList = new ArrayList<String>();
        String input;
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((input = fileReader.readLine()) != null)
            fileList.add(input);
        fileReader.close();
        bufferedReader.close();
        for (String aFileList : fileList)
        {
            String[] stringArray = aFileList.split(" ");
            int match = 0;
            for (String aStringArray : stringArray)
            {
                for (String word : words)
                {
                    if (word.equals(aStringArray))
                        match++;
                }
            }
            if (match == 2)
                System.out.println(aFileList);
        }
    }
}
