package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты

public class Solution {
    public static void main(String[] args) {
    }
}

*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {                               // solved
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> map = new HashMap<String, Double>();
        Double value;

        while (in.ready()){
            String[] line = in.readLine().split(" ");
            value = Double.parseDouble(line[1]);

            if (map.containsKey(line[0])){
                value = value + map.get(line[0]);
                map.put(line[0], value);
            }
            else {
                map.put(line[0], value);
            }
        }
        in.close();
        Map<String, Double> sortedMap = new TreeMap<String, Double>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(map);

        for (Map.Entry<String, Double> entry: sortedMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}