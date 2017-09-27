package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/

public class Solution {                  // solved
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> bytes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            bytes.add(inputStream.read());
        }

        inputStream.close();
        reader.close();

       /* for (int i = 0; i < bytes.size(); i++) {
            System.out.println(bytes.get(i));
        }*/

        countBytes(bytes, map);
       // compareBytes(map);
        printMaxBytes(map, compareBytes(map));


    }

    private static void countBytes(ArrayList<Integer> bytes, HashMap<Integer, Integer> map) {

        for (int i = 0; i < bytes.size(); i++) {
            int count = 0;
            for (int j = 0; j < bytes.size(); j++) {
                if (bytes.get(i) == bytes.get(j)) {
                    count++;
                }
            }
            map.put(bytes.get(i), count);
        }
        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
    }

    public static int compareBytes(HashMap<Integer, Integer> map) {
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public static void printMaxBytes(HashMap<Integer, Integer> map, int maxCount){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxCount){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
// i://new/new.txt