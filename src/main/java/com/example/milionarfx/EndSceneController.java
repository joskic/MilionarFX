package com.example.milionarfx;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndSceneController extends MainController implements Initializable {
    public Label moneyMessage;

    public void onNewGameButton(ActionEvent actionEvent) {
//        try {
//            FXMLManager.getInstance().setView("main-view", "game");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void onEndGameButton(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    moneyMessage.setText("Odcházíš s " + Game.moneyEnd + " CZK.");
    }
}
