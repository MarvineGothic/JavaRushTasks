package com.javarush.task.task21.task2113;

/**
 * Created by Admin on 05.05.2017.
 */
public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move(){
        distance += Math.random()*speed;
    }

    public void print(){

            for (int i = 0; i <Math.floor(distance); i++){
                System.out.print(".");
            }

            System.out.println(name);

    }
}
