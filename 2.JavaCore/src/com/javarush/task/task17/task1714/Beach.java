package com.javarush.task.task17.task1714;

/* 
Comparable
public class Beach {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}
*/

public class Beach implements Comparable<Beach>{         // solved
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        Beach beach = (Beach) o;
        if(this == beach) return 0;

        int first = 0, second = 0;
        if(getDistance() == beach.getDistance()) {first++; second++;}

        else if (getDistance() <  beach.getDistance()) first++;
        else second++;
        if(getQuality() == beach.getQuality()) {first++; second++;}
        else if (getQuality()> beach.getQuality()) first++;
        else second++;
        if(first == second) return 0;
        return (first > second)?1: -1;
    }
}
