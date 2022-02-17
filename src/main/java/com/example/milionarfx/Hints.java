package com.example.milionarfx;

import java.util.Random;

public class Hints extends Game {

    private static final Random rnd = new Random();
    public static boolean nextLevel = true;
    public static boolean fiftyFifty = true;

    public static int randomNumber() {
        int randomNumber = rnd.nextInt(5);
        return randomNumber;
    }
}