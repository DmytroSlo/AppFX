package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Zadanie extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label text1 = new Label("Pasek postępu");
        text1.setLayoutY(10);
        text1.setLayoutX(10);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setLayoutY(30);
        progressBar.setLayoutX(10);

        Label text2 = new Label("Zakończono");
        text2.setLayoutX(10);
        text2.setLayoutY(50);
        text2.setVisible(false);

        Button startButton = new Button("Start");
        startButton.setLayoutY(70);
        startButton.setLayoutX(10);

        Button restartButton = new Button("Restart");
        restartButton.setLayoutX(55);
        restartButton.setLayoutY(70);
        restartButton.setDisable(true);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startButton.setDisable(true);
                Thread thread = new Thread(() -> {
                    for(int i = 0; i <= 100; i++){
                        double progress = (double)i / 100;
                        Platform.runLater(() -> progressBar.setProgress(progress));

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        if(progressBar.getProgress() == 1.0){
                            restartButton.setDisable(false);
                            text2.setVisible(true);
                        }
                    }
                });

                thread.start();
            }
        });

        restartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text2.setVisible(false);
                restartButton.setDisable(true);
                startButton.setDisable(false);
                progressBar.setProgress(0);
            }
        });

        Group group = new Group();
        group.getChildren().add(text1);
        group.getChildren().add(progressBar);
        group.getChildren().add(text2);
        group.getChildren().add(startButton);
        group.getChildren().add(restartButton);

        Scene scene = new Scene(group,250, 150, Color.web("#E0E0DA"));

        stage.setScene(scene);
        stage.setTitle("Zadanie domowe");
        stage.show();
    }
}
