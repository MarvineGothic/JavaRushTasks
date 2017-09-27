package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 29.07.2017.
 */
public class Sun implements Planet{
    private static class SunHolder {
        private static Sun ourInstance ;
    }

    public static Sun getInstance() {
        return SunHolder.ourInstance = new Sun();
    }

    private Sun() {
    }
}
