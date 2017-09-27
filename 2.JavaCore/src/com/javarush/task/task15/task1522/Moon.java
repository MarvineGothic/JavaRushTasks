package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 29.07.2017.
 */
public class Moon implements Planet{
    private static class MoonHolder {
        private final static Moon ourInstance = new Moon();
    }

    public static Moon getInstance() {
        return MoonHolder.ourInstance;
    }

    private Moon() {
    }
}
