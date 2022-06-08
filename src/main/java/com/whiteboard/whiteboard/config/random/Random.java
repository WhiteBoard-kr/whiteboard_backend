package com.whiteboard.whiteboard.config.random;

public class Random {
    static int rand;

    public static int generate_random() {
        rand = (int) (Math.random() * 99096) + 1000;
        System.out.println(rand);
        return rand;
    }
}
