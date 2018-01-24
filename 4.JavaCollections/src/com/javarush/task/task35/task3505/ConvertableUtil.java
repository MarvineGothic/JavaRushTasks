package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {    // solved

    public static <K, V extends Convertable<K>> Map convert(List<? extends V> list) {
        Map<K, V> result = new HashMap<>();
        for (V v : list) {
            K key = v.getKey();
            result.put(key, v);
        }
        return result;
    }
}
    /*public static Map convert(List <? extends Convertable> list ) {

        Map<Object, Convertable<?>> result = new HashMap();

        for (Convertable<?> key : list) {
            result.put(key.getKey(), key);
        }
        return result;
    }*/