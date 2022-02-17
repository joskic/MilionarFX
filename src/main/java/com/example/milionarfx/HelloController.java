package com.example.milionarfx;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label question;
    public Button answerA;
    public Button answerB;
    public Button answerC;
    public Button answerD;
    public Label questionInfo;
    public Label moneyEnd;
    public Button nextButton;
    public Button endButton;
    public Button changeButton;
    public static String answerFromUser = null;
    public Button fiftyButton;
    private FXMLManager fxmlManager;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fxmlManager = FXMLManager.getInstance();
        questions();
    }

    public void onActionAnswerA() {
        answerFromUser = "A";
        CheckAnswer.checkAnswer();
        if (CheckAnswer.correctAnswer.equals(answerFromUser)) {
            questions();
        } else {
            answerA.setStyle("-fx-background-color: red");
        }
    }

    public void onActionAnswerC() {
        answerFromUser = "C";
        CheckAnswer.checkAnswer();
        if (CheckAnswer.correctAnswer.equals(answerFromUser)) {
            questions();
        } else {
            answerC.setStyle("-fx-background-color: red");
        }
    }

    public void onActionAnswerB() {
        answerFromUser = "B";
        CheckAnswer.checkAnswer();

        if (CheckAnswer.correctAnswer.equals(answerFromUser)) {
            questions();
        } else {
            answerB.setStyle("-fx-background-color: red");
        }
    }

    public void onActionAnswerD() {
        answerFromUser = "D";
        CheckAnswer.checkAnswer();
        if (CheckAnswer.correctAnswer.equals(answerFromUser)) {
            questions();
        } else {
            answerD.setStyle("-fx-background-color: red");
        }
    }

    public void questions() {
        Game.getQuestion();
        Game.numbering++;
        question.setText(Game.quest[Game.random][0]);
        answerA.setText(Game.quest[Game.random][Game.randomAnswer[0]]);
        answerB.setText(Game.quest[Game.random][Game.randomAnswer[1]]);
        answerC.setText(Game.quest[Game.random][Game.randomAnswer[2]]);
        answerD.setText(Game.quest[Game.random][Game.randomAnswer[3]]);
        questionInfo.setText("Otázka za " + Game.money + " CZK");
        moneyEnd.setText((Game.moneyEnd + " CZK"));
        if (Hints.fiftyFifty == false) {
          setVisibleAnswer();
        }
    }

    public void setVisibleAnswer() {
        answerA.setDisable(false);
        answerB.setDisable(false);
        answerC.setDisable(false);
        answerD.setDisable(false);
    }

    public void onActionFifty() {
        System.out.println(Game.randomAnswer[0]);
        System.out.println(Game.randomAnswer[1]);
        System.out.println(Game.randomAnswer[2]);
        System.out.println(Game.randomAnswer[3]);

        if (Game.randomAnswer[0] == 2 || Game.randomAnswer[0] == 3) {
            answerA.setText("");
            answerA.setDisable(true);
            Hints.fiftyFifty = false;
        }
        if (Game.randomAnswer[1] == 2 || Game.randomAnswer[1] == 3) {
            answerB.setText("");
            answerB.setDisable(true);
            Hints.fiftyFifty = false;
        }
        if (Game.randomAnswer[2] == 2 || Game.randomAnswer[2] == 3) {
            answerC.setText("");
            answerC.setDisable(true);
            Hints.fiftyFifty = false;
        }
        if (Game.randomAnswer[3] == 2 || Game.randomAnswer[3] == 3) {
            answerD.setText("");
            answerD.setDisable(true);
            Hints.fiftyFifty = false;
        }
        fiftyButton.setDisable(true);
    }

    public void onActionNext() {
        questions();
        nextButton.setDisable(true);

    }

    public void onActionChange() {
        Game.getQuestion();
        setVisibleAnswer();
        int randomNumber = Game.random;
        while (randomNumber == Game.random) {

            randomNumber = Hints.randomNumber();

            if (randomNumber != Game.random) {
                Game.randomAnswer = Hints.randomAnswerGenerator();

                question.setText(Game.quest[randomNumber][0]);
                answerA.setText(Game.quest[randomNumber][Game.randomAnswer[0]]);
                answerB.setText(Game.quest[randomNumber][Game.randomAnswer[1]]);
                answerC.setText(Game.quest[randomNumber][Game.randomAnswer[2]]);
                answerD.setText(Game.quest[randomNumber][Game.randomAnswer[3]]);
            }
        }
        changeButton.setDisable(true);

        Hints.nextLevel = false;
    }

    public void onActionEnd() {
        try {
            FXMLManager.getInstance().setView("end-scene", "Chcete být milionářem?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}