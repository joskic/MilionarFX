package com.example.milionarfx;

import javafx.animation.PauseTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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

    public void checkAnswer() {
        CheckAnswer.checkAnswer();
        answerA.setDisable(true);
        answerB.setDisable(true);
        answerC.setDisable(true);
        answerD.setDisable(true);

        switch (CheckAnswer.correctAnswer) {
            case "A" -> answerA.setStyle("-fx-base: green; -fx-opacity: 1.0;");
            case "B" -> answerB.setStyle("-fx-base: green; -fx-opacity: 1.0;");
            case "C" -> answerC.setStyle("-fx-base: green; -fx-opacity: 1.0;");
            case "D" -> answerD.setStyle("-fx-base: green; -fx-opacity: 1.0;");
        }

        PauseTransition pause = new PauseTransition(
                Duration.seconds(2)
        );
        pause.setOnFinished(event -> {
            answerA.setDisable(false);
            answerB.setDisable(false);
            answerC.setDisable(false);
            answerD.setDisable(false);
            answerA.setStyle(null);
            answerB.setStyle(null);
            answerC.setStyle(null);
            answerD.setStyle(null);
            if (CheckAnswer.correctAnswer.equals(answerFromUser)) {
                questions();
            } else {
                onActionEnd();
            }
        });
        pause.play();
        if (!CheckAnswer.correctAnswer.equals(answerFromUser)) {
            switch (answerFromUser) {
                case "A" -> answerA.setStyle("-fx-base: red; -fx-opacity: 1.0;");
                case "B" -> answerB.setStyle("-fx-base: red; -fx-opacity: 1.0;");
                case "C" -> answerC.setStyle("-fx-base: red; -fx-opacity: 1.0;");
                case "D" -> answerD.setStyle("-fx-base: red; -fx-opacity: 1.0;");
            }
        }
    }

    public void onActionAnswerA() {
        answerFromUser = "A";
        checkAnswer();
    }

    public void onActionAnswerC() {
        answerFromUser = "C";
        checkAnswer();
    }

    public void onActionAnswerB() {
        answerFromUser = "B";
        checkAnswer();
    }

    public void onActionAnswerD() {
        answerFromUser = "D";
        checkAnswer();
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
        if (!Hints.fiftyFifty) {
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
        }
        if (Game.randomAnswer[1] == 2 || Game.randomAnswer[1] == 3) {
            answerB.setText("");
            answerB.setDisable(true);
        }
        if (Game.randomAnswer[2] == 2 || Game.randomAnswer[2] == 3) {
            answerC.setText("");
            answerC.setDisable(true);
        }
        if (Game.randomAnswer[3] == 2 || Game.randomAnswer[3] == 3) {
            answerD.setText("");
            answerD.setDisable(true);
        }
        fiftyButton.setDisable(true);
        Hints.fiftyFifty = false;
    }

    public void onActionNext() {
        questions();
        Hints.nextLevel = false;
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
        Hints.newQuestion = false;
        changeButton.setDisable(true);
    }

    public void onActionEnd() {
        try {
            FXMLManager.getInstance().setView("end-scene", "Chcete být milionářem?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reset() {
//        Game.numbering = 0;
//        Hints.fiftyFifty = true;
//        Hints.nextLevel = true;
//        Hints.newQuestion = true;
//        questions();
       // setVisibleAnswer();
       // System.out.println("xd");
    }
}