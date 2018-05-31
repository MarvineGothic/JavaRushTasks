package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("all")
public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;
    private int size;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        V lastElement = null;
        if (values == null) values = new ArrayList<>();
        else {
            lastElement = values.get(values.size() - 1);
            if (values.size() == this.repeatCount)
                values.remove(0);
        }
        values.add(value);
        map.put(key, values);
        return lastElement;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        V elementToRemove = null;
        if (!map.containsKey((K) key)) return null;

        List<V> values = map.get((K) key);

        elementToRemove = values.get(0);
        values.remove(0);

        if (values.size() == 0) map.remove((K) key);
        return elementToRemove;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> result = new ArrayList<>();
        for (List<V> values : map.values())
            result.addAll(values);
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}