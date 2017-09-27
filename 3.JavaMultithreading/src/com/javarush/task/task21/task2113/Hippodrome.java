package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.05.2017.
 */
public class Hippodrome {

    private static List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run()  {
        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse: getHorses()){
            horse.move();
        }
    }

    public void print(){
        for (Horse horse: getHorses()){
            horse.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }
    public Horse getWinner()
    {
        Horse horseWinner = getHorses().get(0);
        for (Horse horse : getHorses())
        {
            if(horseWinner.getDistance() < horse.getDistance()) horseWinner = horse;
        }
        return horseWinner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("One", 3, 0));
        game.horses.add(new Horse("Two", 3, 0));
        game.horses.add(new Horse("Three", 3, 0));
        game.run();
        game.printWinner();
    }
}
