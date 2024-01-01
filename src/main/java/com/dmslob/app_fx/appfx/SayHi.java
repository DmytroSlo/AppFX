package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SayHi extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Font mainFont = Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 16);

        Label labelHi = new Label("Hi:");
        labelHi.setLayoutY(10);
        labelHi.setLayoutX(10);
        labelHi.setFont(mainFont);

        Label labelAction = new Label("Jak się nazywaasz?");
        labelAction.setLayoutX(10);
        labelAction.setLayoutY(40);
        labelAction.setFont(Font.font("Berlin Sans FB Demi", 12));

        TextField textField = new TextField();
        textField.setPromptText("Wpisz imię!");
        textField.setLayoutX(7);
        textField.setLayoutY(60);

        Button button = new Button("Say Hi!");
        button.setLayoutX(10);
        button.setLayoutY(90);

        Group group = new Group();
        group.getChildren().add(labelHi);
        group.getChildren().add(labelAction);
        group.getChildren().add(textField);
        group.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Label warningText = new Label("Nić nie wpisałeś!");
                warningText.setLayoutX(10);
                warningText.setLayoutY(120);
                warningText.setTextFill(Color.RED);
                warningText.setFont(Font.font("Berlin Sans FB Demi", 20));
                if(textField.getText().isEmpty()){
                    group.getChildren().add(warningText);
                } else {
                    labelHi.setText("Hi: " + textField.getText());
                    textField.clear();
                    button.setDisable(true);
                    group.getChildren().remove(warningText);
                }
            }
        });

        Scene scene = new Scene(group, 400, 200, Color.GREY);

        stage.setTitle("Say Hi");
        stage.setScene(scene);
        stage.show();
    }
}
