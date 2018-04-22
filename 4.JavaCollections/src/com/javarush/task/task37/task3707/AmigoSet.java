package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {    // solved
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        AmigoSet initialAmigoSet = new AmigoSet<>();

        for (int i = 0; i < 10; i++) {
            initialAmigoSet.add(i);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(initialAmigoSet);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        AmigoSet loadedAmigoSet = (AmigoSet) objectInputStream.readObject();

        System.out.println(initialAmigoSet.size() + " " + loadedAmigoSet.size());
    }

    // AbstractCollection
    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int size = map.size();
        c.forEach(col -> map.put(col, PRESENT));
        return map.size() > size;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    // AbstractSet
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    // Cloneable
    @Override
    public Object clone() {
        AmigoSet amigoSet;
        try {
            amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }

    // Serializable
    private void writeObject(ObjectOutputStream outputStream) {
        try {
            int capacity = HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity");
            float loadFactor = HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor");
            outputStream.defaultWriteObject();
            outputStream.writeInt(capacity);
            outputStream.writeFloat(loadFactor);
            outputStream.writeInt(map.size());
            for (E o : map.keySet()) outputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readObject(ObjectInputStream inputStream) {
        try {
            inputStream.defaultReadObject();
            int capacity = inputStream.readInt();
            float loadFactor = inputStream.readFloat();
            int size = inputStream.readInt();
            map = new HashMap<>(capacity, loadFactor);

            for (int i = 0; i < size; i++) {
                E e = (E) inputStream.readObject();
                map.put(e, PRESENT);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
