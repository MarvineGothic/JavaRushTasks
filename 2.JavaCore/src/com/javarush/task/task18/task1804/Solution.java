package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
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
        printMinBytes(map, compareBytes(map));


    }

    private static void countBytes(ArrayList<Integer> bytes, HashMap<Integer, Integer> map) {
        int k;
        for (k = 0; k < bytes.size(); k++) {
            int n = 0;
            for (int j = 0; j < bytes.size(); j++) {
                if (bytes.get(k) == bytes.get(j)) {
                    n++;
                }
            }
            map.put(bytes.get(k), n);
        }
        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
    }

    public static int compareBytes(HashMap<Integer, Integer> map) {
        int min = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() <= min) {
                min = entry.getValue();
            }
        }
        return min;
    }

    public static void printMinBytes(HashMap<Integer, Integer> map, int minCount) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
// i://new/new.txt