package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UkladWidoku extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Layout

        // HBox
        HBox hBox = new HBox();
        Button menuButton = new Button("Menu");
        Button kontaktButton = new Button("Kontakt");
        Button zamowieneButton = new Button("Zamówienie");
//        hBox.getChildren().add(menuButton);
//        hBox.getChildren().add(kontaktButton);
//        hBox.getChildren().add(zamowieneButton);
        hBox.getChildren().addAll(menuButton, kontaktButton, zamowieneButton);
        hBox.setSpacing(10);
        //top, right, bottom, left
        hBox.setPadding(new Insets(10, 5, 10, 5));
        hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //VBox
        VBox vBox = new VBox();
        ImageView pizzaImageVive = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/ikony/pizza.png")));
        Label pizzaLabel = new Label("Pizza", pizzaImageVive);
        ImageView hamburgerImageVi = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/ikony/hamburger.png")));
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageVi);
        ImageView napojeImage = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/ikony/napoje.png")));
        Label napojeLabel = new Label("Napoje", napojeImage);
        vBox.getChildren().addAll(pizzaLabel, hamburgerLabel, napojeLabel);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        // StackPane
        StackPane stackPane = new StackPane();
        ImageView pizzaForMax = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-cztery-sery-duza.png")));
        Label pizzaForCheez = new Label("Pizza cztery sery - mozzarella, rokpol, feta edamski");
        pizzaForCheez.setTextFill(Color.WHITE);
        stackPane.getChildren().addAll(pizzaForMax, pizzaForCheez);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //FlowPane
        FlowPane flowPane = new FlowPane();
        ImageView pizzaCzetyrySeryImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-cztery-sery.png")));        ImageView pizzafunghiImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-funghi.png")));
        ImageView pizzaMargarittaImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-margaritta.png")));
        ImageView pizzaMexicannaImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-mexicana.png")));
        ImageView pizzaPapieroniImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-pepperoni.png")));
        ImageView pizzaSalamiImV = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-salami.png")));
        flowPane.getChildren().addAll(
                pizzaCzetyrySeryImV,
                pizzafunghiImV,
                pizzaMargarittaImV,
                pizzaPapieroniImV,
                pizzaMexicannaImV,
                pizzaSalamiImV);

        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setMaxWidth(150);
        flowPane.setHgap(5);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(5));

        // GridPane
        GridPane gridPane = new GridPane();
        Button minus = new Button("-");
        minus.setPrefSize(30, 30);
        Button plus = new Button("+");
        plus.setPrefSize(30, 30);
        Label iloscLabel = new Label("1");
        Button ok = new Button("Ok");
        Button cancel = new Button("Anuluj");

        iloscLabel.setPadding(new Insets(0, 10, 0, 10));

        Pane pane = new Pane();
        pane.setPrefWidth(50);

        gridPane.add(minus, 0, 0); // 1 - kolumna, 1 - wiersz
        gridPane.add(iloscLabel, 1, 0); // 2 - kolumna, 1 - wiersz
        gridPane.add(plus, 2, 0); // 3 - kolumna, 1 - wirsz
        gridPane.add(pane, 3, 1);
        gridPane.add(ok, 4, 1); // 5 - kolumna, 2 - wiersz
        gridPane.add(cancel, 5, 1);

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        for(int i = 0; i < 20; i++){
            ImageView kopiePizzaImageView = new ImageView(new Image(getClass().getResourceAsStream("/obrazki/pizza/pizza-salami.png")));
            flowPane.getChildren().add(kopiePizzaImageView);
        }

        scrollPane.setContent(flowPane);
        scrollPane.setMaxWidth(150);

        // BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(stackPane);
        borderPane.setRight(scrollPane);
        borderPane.setBottom(gridPane);

        Scene scene = new Scene(borderPane, 800, 640, Color.GREY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Układ elementów widoku");
        primaryStage.show();

    }
}
