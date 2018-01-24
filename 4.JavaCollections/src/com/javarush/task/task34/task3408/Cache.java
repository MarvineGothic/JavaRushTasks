package com.javarush.task.task34.task3408;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {       // solved
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        cache.putIfAbsent(key, clazz.getConstructor(key.getClass()).newInstance(key));
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        int a = cache.size();
        Method method;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            cache.put((K) method.invoke(obj), obj);
            //if (cache.size() > a) return true;
            return cache.containsKey(method.invoke(obj));
        } catch (Exception ignore) {
            // return false;
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}
