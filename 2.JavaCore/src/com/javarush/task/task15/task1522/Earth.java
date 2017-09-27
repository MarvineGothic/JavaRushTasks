package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 29.07.2017.
 */
public class Earth implements Planet{
    private static class EarthHolder {
        private final static Earth ourInstance = new Earth();
    }

    public static Earth getInstance() {
        return EarthHolder.ourInstance;
    }

    private Earth() {
    }
}
