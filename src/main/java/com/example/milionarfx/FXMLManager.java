package com.example.milionarfx;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

public class FXMLManager {

    private static final FXMLManager fxmlManager = new FXMLManager();
    private Stage stage;
    private Class<?> mainClass;
    private boolean changeTitleOnLoad = true;
    private AnchorPane mainLayout = new AnchorPane();
    private HashMap<String, FXMLLoader> views = new HashMap<>();

    private FXMLManager() {}

    public static FXMLManager getInstance() {
        return fxmlManager;
    }

    public void init(Class<?> mainClass, Stage stage) {
        this.mainClass = mainClass;
        this.stage = stage;
        initMainLayout();
        loadViews();
    }

    public void setView(String name) throws IOException {
        if (changeTitleOnLoad) {
            stage.setTitle(name);
        }
        initMainLayout();
        mainLayout.getChildren().clear();
        mainLayout.getChildren().add(views.get(name).getRoot());
        Platform.runLater(() -> mainLayout.requestFocus());
    }

    public void setView(String name, String customNameForStage) throws IOException {
        stage.setTitle(customNameForStage);
        initMainLayout();
        mainLayout.getChildren().clear();
        mainLayout.getChildren().add(views.get(name).getRoot());
        Platform.runLater(() -> mainLayout.requestFocus());
    }

    public void setTitleChangeOnLoad(boolean shouldBeChangedOnLoad) {
        changeTitleOnLoad = shouldBeChangedOnLoad;
    }

    public void setAppIcon(String path) {
        try {
            stage.getIcons().addAll(new Image(Objects.requireNonNull(mainClass.getResourceAsStream(path))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStyleSheet(String path) {
        try {
            stage.getScene().getStylesheets().add(Objects.requireNonNull(mainClass.getResource(path)).toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMainLayout() {
        if (stage.getScene() == null) {
            stage.setScene(new Scene(mainLayout));
            mainLayout.prefWidthProperty().bind(stage.widthProperty());
            mainLayout.prefHeightProperty().bind(stage.heightProperty());
        }
    }

    private void loadViews() {
        try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources/" + mainClass.getPackage().getName().replace(".", "/") + "/views"))) {
            paths.filter(Files::isRegularFile).forEach((file) -> {
                try {
                    FXMLLoader shadow = new FXMLLoader(Objects.requireNonNull(mainClass.getResource("views/" + file.getFileName())));
                    views.put(file.getFileName().toString().replace(".fxml", ""), shadow);
                    shadow.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getController(String name) {
        return views.get(name).getController();
    }

    public void printViews() {
        System.out.println("Loaded views:");
        views.keySet().forEach(System.out::println);
    }
}