package com.example.milionarfx;

import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLManager fxmlManager = FXMLManager.getInstance();
        fxmlManager.init(Application.class, stage);
        fxmlManager.setTitleChangeOnLoad(true);
        fxmlManager.setView("main-view", "Chcete být milionářem?");
        fxmlManager.printViews();
        stage.show();
    }

    public static void main(String[] args) {
        Game.getQuestion();
        launch();
    }
}