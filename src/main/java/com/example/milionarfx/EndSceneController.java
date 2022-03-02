package com.example.milionarfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndSceneController  implements Initializable {
    public Label moneyMessage;

    public void onNewGameButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLManager.getInstance().setView("main-view", "game");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader loader = new FXMLLoader( (getClass().getResource("main-view.fxml")));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.reset();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onEndGameButton(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    moneyMessage.setText("Odcházíš s " + Game.moneyEnd + " CZK.");
    }

}
