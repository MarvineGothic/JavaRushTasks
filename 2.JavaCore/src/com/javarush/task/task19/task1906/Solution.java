package com.javarush.task.task19.task1906;

/* 
Четные байты

public class Solution {
    public static void main(String[] args) {
    }
}
*/

import java.io.*;

public class Solution {                 // solved
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader read = new FileReader(reader.readLine());
        FileWriter write = new FileWriter(reader.readLine());
        int count = 0;
        while (read.ready()){

            int data = read.read();
            count++;
            if (count%2 == 0){
                write.write(data);
            }
        }
        reader.close();
        read.close();
        write.close();


    }
}
