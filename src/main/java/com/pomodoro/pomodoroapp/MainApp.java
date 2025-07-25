package com.pomodoro.pomodoroapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/pomodoro/pomodoroapp/pomodoro-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/pomodoro/pomodoroapp/styles.css").toExternalForm());

        primaryStage.setTitle("Pomodoro Timer");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(500);
        primaryStage.setWidth(550);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}