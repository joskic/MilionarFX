package com.example.milionarfx;

public class CheckAnswer {
    private static int checkpoint;
    public static String correctAnswer = null;

    public static void checkAnswer() {
        //logika pro zjisteni spravne odpovedi

        if (Game.randomAnswer[0] == 1) {
            correctAnswer = "A";
        } else if (Game.randomAnswer[1] == 1) {
            correctAnswer = "B";
        } else if (Game.randomAnswer[2] == 1) {
            correctAnswer = "C";
        } else if (Game.randomAnswer[3] == 1) {
            correctAnswer = "D";
        }

        //23-32 logika pro zachytny body
        if (Game.moneyEnd >= 0 && Game.moneyEnd < 10000) {
            checkpoint = 0;
        } else if (Game.moneyEnd >= 10000 && Game.moneyEnd < 320000) {
            checkpoint = 10000;
        } else if (Game.moneyEnd >= 320000 && Game.moneyEnd < 10000000) {
            checkpoint = 320000;
        }
        if (!Hints.nextLevel) {
            checkpoint = 0;
        }

        //Poznani dosahnuti maximalni urovne -> konec hry
        if (Game.money == 10000000) {
            System.out.println("Vyhrál jsi hru Chcete být milionářem? Gratuluji.");
            System.exit(0);
        }
    }
}
