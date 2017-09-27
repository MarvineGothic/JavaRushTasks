package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Anton", 500);
        map.put("Igor", 450);
        map.put("Ivan", 560);
        map.put("Vasya", 450);
        map.put("Valera", 760);

        map.put("Max", 800);
        map.put("Soeren", 980);
        map.put("Petr", 879);
        map.put("Dasha", 768);
        map.put("Masha", 987);
        //напишите тут ваш код
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);


        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500) {

                map.remove(pair.getKey());
            }

        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        HashMap<String, Integer> copy = createMap();
        removeItemFromMap(copy);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            System.out.println(pair);
        }

    }
}