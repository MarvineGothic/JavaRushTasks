package com.javarush.task.task19.task1909;

/* 
Замена знаков

public class Solution {
    public static void main(String[] args) {
    }
}
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {                        // solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));

        while(in.ready()){
            String str = in.readLine();
            str = str.replaceAll("\\.", "!");
            //str = str.replaceAll("\\D", "");   for previous task 1908
            out.write(str);
            out.newLine();
        }

        in.close();
        out.close();
    }
}
