package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Kontrolki extends Application {
    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Font font = Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 36);
        Color color = Color.web("#E7F93B");
        System.out.println(Font.getFamilies());

        Label label = new Label("My first label");
        label.setLayoutX(10);
        label.setLayoutY(10);
//        label.setFont(new Font(20));
        label.setFont(font);
//        label.setTextFill(Color.YELLOW);
        label.setTextFill(color);
        label.setMaxWidth(12);
        label.setWrapText(true);
        label.setRotate(1);

        // Image

        Image image = new Image(getClass().getResourceAsStream("/img/logo.png"));
        ImageView imageView = new ImageView(image);
//        label.setGraphic(imageView);
        imageView.setX(150);
        imageView.setY(10);
        imageView.setFitHeight(50);
        imageView.setFitWidth(130);
        imageView.setPreserveRatio(true); // Równomierni rozciąga po mniejszej wartości
//        Label labelSecond = new Label("Second text", imageView);
//        labelSecond.setLayoutY(100);
//        labelSecond.setLayoutX(125);

        // Button
        Button button = new Button("Klick my");
        button.setLayoutX(150);
        button.setLayoutY(80);
        button.setText("Don't klick my");
        button.setTextFill(Color.GREEN);
//        button.setGraphic(imageView);
        button.setDisable(false);
        button.setMaxWidth(500);
//        button.setMaxHeight(120);
        button.setWrapText(true);


        // Add text
        TextField textField = new TextField();
        textField.setLayoutX(150);
        textField.setLayoutY(110);
//        textField.setText("Next");
        textField.setPromptText("Wpisz Email");
        textField.setPrefColumnCount(10);

        // Passord
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(150);
        passwordField.setLayoutY(140);
        passwordField.setPromptText("Wpisz hasło");
        passwordField.setPrefColumnCount(10);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                System.out.println("Klick");
//                int i = 0;
//                String text = button.getText() + "Stoped!";
//                button.setText(text);
//                button.setDisable(true);
                System.out.println("Email: " + textField.getText() + "\n" +
                        "Hasło: " + passwordField.getText());
                textField.clear();
                passwordField.clear();
            }
        });



        ///////////
        Group group = new Group();
        group.getChildren().add(label);
//        group.getChildren().add(labelSecond);
        group.getChildren().add(imageView);
        group.getChildren().add(button);
        group.getChildren().add(textField);
        group.getChildren().add(passwordField);

        Scene scene = new Scene(group, 400, 200, Color.GREY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Application konrolki");
        primaryStage.show();
    }

}
