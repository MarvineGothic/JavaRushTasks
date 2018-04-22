package com.javarush.task;


import edu.princeton.cs.algs4.StdDraw;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Class<?> string = "asdf".getClass();
        Map<String, Integer> map;
        printAllFiles(new File("k://1.Programms/"));

        /*Object object = 5;
        Object d = 5.5;
        double a = (double) d;
        Double ad = (Double) d;
        double sum = (int) object + (double) d;
        //System.out.println(sum);
        System.out.println(factorial(3));*/

        //stringDivider("asdf kje wer oiu dfg").forEach(System.out::println)
    }

    public static List<?> stringDivider(String string) {
        //Collections.addAll(strings, words);
        return Arrays.asList(string.split(" "));
    }

    static long factorial(int n) {
        long result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void printAllFiles(File dir) {
        File[] files;
        files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    printAllFiles(file);
                else
                    System.out.println(file.getAbsolutePath());
            }
        }
    }

    private int getValue() {
        return aPrivate.getVal();
    }
}

class adsf {
    int x = 3;
    int y = getX();

    int getX() {
        return x;
    }

    public static void main(String[] args) {
        adsf adsf=new adsf();
        System.out.println(adsf.x+","+adsf.y);
    }
}

class aPrivate {
    private static int val = 0;

    static int getVal() {
        return val;
    }

    public static void main(String[] args) {
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // initial values
        double rx = 0.480, ry = 0.860;     // position
        double vx = 0.015, vy = 0.023;     // velocity
        double radius = 0.05;              // radius

        // main animation loop
        while (true) {

            // bounce off wall according to law of elastic collision
            if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

            // update position
            rx = rx + vx;
            ry = ry + vy;

            // clear the background
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 1.0);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            // display and pause for 20 ms
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
