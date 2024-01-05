package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


        // TextArea
        TextArea textArea = new TextArea();
        textArea.setLayoutX(80);
        textArea.setLayoutY(180);
        textArea.setPromptText("Tutaj!");
        textArea.setMaxSize(400, 100);


        // CheckBox
        CheckBox checkBox = new CheckBox("First");
        checkBox.setLayoutX(80);
        checkBox.setLayoutY(285);
        checkBox.setText("Akcept");
        checkBox.setSelected(true);
        checkBox.isSelected();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Email: " + textField.getText() + "\n" +
                        "Hasło: " + passwordField.getText() +
                        "\nCheck box is: " + checkBox.isSelected());
                textField.clear();
                passwordField.clear();
            }
        });

        // RadioButton
        RadioButton radioButtonP21 = new RadioButton("P21");
        radioButtonP21.setLayoutX(80);
        radioButtonP21.setLayoutY(310);
        radioButtonP21.setSelected(true);
//        radioButtonP21.isSelected();

        RadioButton radioButtonP0 = new RadioButton("P0");
        radioButtonP0.setLayoutY(330);
        radioButtonP0.setLayoutX(80);

        RadioButton radioButtonP15 = new RadioButton("P15");
        radioButtonP15.setLayoutY(350);
        radioButtonP15.setLayoutX(80);


        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonP21.setToggleGroup(toggleGroup);
        radioButtonP0.setToggleGroup(toggleGroup);
        radioButtonP15.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton selected = (RadioButton) toggle;
                System.out.println("Wybrany " + selected.getText());
            }
        });

        // ChoiceBox
        String[] listaWyborow = {"Pierwszy", "Drugi", "Trzeci", "Czwarty"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(400);
        choiceBox.getItems().addAll(listaWyborow);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                String wybur = listaWyborow[t1.intValue()];
                System.out.println(wybur);
            }
        });

        // ListView
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(listaWyborow);
        listView.setLayoutX(350);
        listView.setLayoutY(50);
        listView.setMaxHeight(70);
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                String wybur2 = listaWyborow[t1.intValue()];
                System.out.println("ListView: " + wybur2);
            }
        });

        // ProgressBar
        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(350);
        progressBar.setLayoutY(125);
//        progressBar.setProgress(0.3); - 30% progresu

        //ProgresIndicator
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(455);
        progressIndicator.setLayoutY(125);
//        progressIndicator.setProgress(0.3);

        //Slider
        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutY(400);
        slider.setPrefWidth(300);
//        slider.setMin(10);
//        slider.setMax(68);
//        slider.setValue(13);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("Slider: " + t1.doubleValue());

                if (t1.intValue() == 100) {
                    progressBar.setVisible(false);
                    progressIndicator.setVisible(false);
                } else{
                    progressIndicator.setVisible(true);
                    progressBar.setVisible(true);
                    double progressValueProcent = t1.doubleValue() / 100;
                    progressBar.setProgress(progressValueProcent);
                    progressIndicator.setProgress(progressValueProcent);
                }
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
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButtonP21);
        group.getChildren().add(radioButtonP0);
        group.getChildren().add(radioButtonP15);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(slider);


        Scene scene = new Scene(group, 900, 720, Color.GREY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Application konrolki");
        primaryStage.show();
    }

}
