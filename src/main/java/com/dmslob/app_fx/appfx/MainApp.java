package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Stage -> Scane -> StackPane -> Text
        Text text = new Text("Hello world!");
        Button button = new Button("Klick mi");
        Text textDrugi = new Text("Text 2");

        // root
//        StackPane root = new StackPane();
//        HBox root = new HBox();
        VBox root = new VBox();
        root.getChildren().add(text);
        root.getChildren().add(button);
        root.getChildren().add(textDrugi);

        // Scene
        Scene scene = new Scene(root);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("My application");
        primaryStage.setX(1150);
        primaryStage.setY(600);
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.setFullScreen(true);

        primaryStage.setResizable(false);

        primaryStage.show();
    }
}