package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {         // solved

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList list = new ArrayList<>();
        list.addAll(Arrays.asList(elements));
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet set = new HashSet();
        Collections.addAll(set, elements);
        return set;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap map = new HashMap();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
