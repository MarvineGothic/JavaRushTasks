package com.javarush.task.task25.task2515;

import java.util.ArrayList;

/**
 * Created by Admin on 18.07.2017.
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run() {
    }

    public void draw() {
    }

    public void sleep(int ms) {
    }

    public static Space game;

    public static void main(String[] args) {
    }
}
