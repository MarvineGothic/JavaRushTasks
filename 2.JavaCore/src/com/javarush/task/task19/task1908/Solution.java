package com.javarush.task.task19.task1908;

/* 
Выделяем числа

public class Solution {
    public static void main(String[] args) {
    }
}
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {                     // solved
    public static void main(String[] args) throws IOException {
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String s = "";
        while (file1.ready()){
            char c = (char)file1.read();
            if (Character.toString(c).contains("[0-9]")){
                    file2.write(c);
            }
        }

        file1.close();
        file2.close();*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> list = new ArrayList<String>();
        String nextLine;
        while ((nextLine = fileReader.readLine()) != null) {
            list.add(nextLine);
        }
        fileReader.close();

        String[] wordArray;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (String aString : list) {
            wordArray = aString.split(" ");
            for (String aWordArray : wordArray)
            {
                try
                {
                    numbers.add(Integer.parseInt(aWordArray));
                }
                catch (NumberFormatException ignored)
                {
                }
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        for (Integer number : numbers)
            bufferedWriter.write(number + " ");
        bufferedWriter.close();

    }
}
//C://Users/Admin/Desktop/file.txt
// C://Users/Admin/Desktop/file2.txt