package com.example.milionarfx;

import java.util.*;

public class Game extends Questions {
    private static final Random rnd = new Random();
    public static int numbering = 1;
    public static String correctAnswer;
    public static int money;
    public static int moneyEnd;
    public static int random;
    public static Integer[] randomAnswer;
    public static String[][] quest = null;


    public static Integer[] randomAnswerGenerator() {
        //logika pro zamichani odpovedi, aby se pokazde objevovali v jinem poradi
        Integer[] array = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);
        return array;
    }

    public static void getQuestion() {
        //logika pro vybrani otazke z dane oblasti
        switch (numbering) {
            case 1 -> {
                quest = Questions.question1();
                money = 1000;
                moneyEnd = 0;
            }
            case 2 -> {
                quest = Questions.question2();
                money = 2000;
                moneyEnd = 1000;
            }
            case 3 -> {
                quest = Questions.question3();
                money = 3000;
                moneyEnd = 2000;
            }
            case 4 -> {
                quest = Questions.question4();
                money = 5000;
                moneyEnd = 3000;
            }
            case 5 -> {
                quest = Questions.question5();
                money = 10000;
                moneyEnd = 5000;
            }
            case 6 -> {
                quest = Questions.question6();
                money = 20000;
                moneyEnd = 10000;
            }
            case 7 -> {
                quest = Questions.question7();
                money = 40000;
                moneyEnd = 20000;
            }
            case 8 -> {
                quest = Questions.question8();
                money = 80000;
                moneyEnd = 40000;
            }
            case 9 -> {
                quest = Questions.question9();
                money = 160000;
                moneyEnd = 80000;
            }
            case 10 -> {
                quest = Questions.question10();
                money = 320000;
                moneyEnd = 160000;
            }
            case 11 -> {
                quest = Questions.question11();
                money = 640000;
                moneyEnd = 320000;
            }
            case 12 -> {
                quest = Questions.question12();
                money = 1250000;
                moneyEnd = 640000;
            }
            case 13 -> {
                quest = Questions.question13();
                money = 2500000;
                moneyEnd = 1250000;
            }
            case 14 -> {
                quest = Questions.question14();
                money = 5000000;
                moneyEnd = 2500000;
            }
            case 15 -> {
                quest = Questions.question15();
                money = 10000000;
                moneyEnd = 5000000;
            }
        }

        int randomNumber = rnd.nextInt(5);

        random = randomNumber;
        randomAnswer = randomAnswerGenerator();
        correctAnswer = quest[randomNumber][1];
    }
}