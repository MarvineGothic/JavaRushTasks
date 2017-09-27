package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(reader.readLine());
        String name = reader.readLine();

        System.out.println("Id=" + id + " Name=" + name);
    }
}
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            try {
                String s = reader.readLine();
                if (s.isEmpty())break;
                int id = Integer.parseInt(s);
                String name = reader.readLine();
                if (name.isEmpty()) break;
             //   if (!map.containsValue(name)) {
                    map.put(name, id);
               // }
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getValue()+" "+pair.getKey());
        }
    }
}
