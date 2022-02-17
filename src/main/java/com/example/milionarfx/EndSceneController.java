package com.example.milionarfx;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndSceneController implements Initializable {
    public Label moneyMessage;

    public void onNewGameButton(ActionEvent actionEvent) {
    }

    public void onEndGameButton(ActionEvent actionEvent) {
        try {
            FXMLManager.getInstance().setView("hello-view", "game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
