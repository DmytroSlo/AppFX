package com.dmslob.app_fx.appfx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class InlineFX extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Effects
        DropShadow shadow = new DropShadow();
        Font textInside = Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 24);
        Font textLastTest = Font.font("Berlin Sans FB Demi", 14);

        // Logo
        Image image = new Image(getClass().getResourceAsStream("/img/logo.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);

        // Górne menu
        Rectangle uppMenu = new Rectangle(400, 34);
        uppMenu.setFill(Color.web("#EBECE5"));
        uppMenu.setEffect(shadow);

        // Kólko
        Circle circleInline1 = new Circle();
        circleInline1.setFill(Color.web("#1fff6c"));
        circleInline1.setRadius(50);
        circleInline1.setCenterY(95);
        circleInline1.setCenterX(60);

        Circle circleInline2 = new Circle();
        circleInline2.setFill(Color.web("#1fff6c"));
        circleInline2.setRadius(50);
        circleInline2.setCenterY(95);
        circleInline2.setCenterX(200);

        Circle circleInline3 = new Circle();
        circleInline3.setFill(Color.web("#1fff6c"));
        circleInline3.setRadius(50);
        circleInline3.setCenterY(95);
        circleInline3.setCenterX(340);

        // Opisy kół
        Label inline1TextInside = new Label("Inline 1");
        inline1TextInside.setFont(textInside);
        inline1TextInside.setLayoutY(80);
        inline1TextInside.setLayoutX(24);
        inline1TextInside.setTextFill(Color.WHITE);

        Label inline2TextInside = new Label("Inline 2");
        inline2TextInside.setFont(textInside);
        inline2TextInside.setLayoutY(80);
        inline2TextInside.setLayoutX(162);
        inline2TextInside.setTextFill(Color.WHITE);

        Label inline3TextInside = new Label("Inline 3");
        inline3TextInside.setFont(textInside);
        inline3TextInside.setLayoutY(80);
        inline3TextInside.setLayoutX(302);
        inline3TextInside.setTextFill(Color.WHITE);

        // Down Text
        Label lastTimeUp1 = new Label("Ostatni test:");
        lastTimeUp1.setLayoutX(23);
        lastTimeUp1.setLayoutY(150);
        lastTimeUp1.setFont(textLastTest);

        Label lastTimeUp2 = new Label("Ostatni test:");
        lastTimeUp2.setLayoutX(165);
        lastTimeUp2.setLayoutY(150);
        lastTimeUp2.setFont(textLastTest);

        Label lastTimeUp3 = new Label("Ostatni test:");
        lastTimeUp3.setLayoutX(303);
        lastTimeUp3.setLayoutY(150);
        lastTimeUp3.setFont(textLastTest);

        // Last time active box
        Label lastTestInline1 = new Label("2024-01-01 12:23:17");
        lastTestInline1.setFont(textLastTest);
        lastTestInline1.setLayoutX(5);
        lastTestInline1.setLayoutY(165);

        Label lastTestInline2 = new Label("2024-01-01 12:22:17");
        lastTestInline2.setFont(textLastTest);
        lastTestInline2.setLayoutX(142);
        lastTestInline2.setLayoutY(165);

        Label lastTestInline3 = new Label("2024-01-01 12:27:17");
        lastTestInline3.setFont(textLastTest);
        lastTestInline3.setLayoutX(280);
        lastTestInline3.setLayoutY(165);

        // RadioButtonBox Product
        RadioButton p0CheckBox = new RadioButton("P0");
        p0CheckBox.setSelected(true);
        p0CheckBox.setLayoutX(265);
        p0CheckBox.setLayoutY(10);

        RadioButton p15CheckBox = new RadioButton("P15");
        p15CheckBox.setLayoutX(305);
        p15CheckBox.setLayoutY(10);

        RadioButton p21CheckBox = new RadioButton("P21");
        p21CheckBox.setLayoutX(350);
        p21CheckBox.setLayoutY(10);

        ToggleGroup toggleGroup = new ToggleGroup();
        p21CheckBox.setToggleGroup(toggleGroup);
        p15CheckBox.setToggleGroup(toggleGroup);
        p0CheckBox.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton selected = (RadioButton) t1;
            }
        });

        Group group = new Group();
        group.getChildren().add(uppMenu);
        group.getChildren().add(imageView);
        group.getChildren().add(circleInline1);
        group.getChildren().add(circleInline2);
        group.getChildren().add(circleInline3);
        group.getChildren().add(inline1TextInside);
        group.getChildren().add(inline2TextInside);
        group.getChildren().add(inline3TextInside);
        group.getChildren().add(lastTimeUp1);
        group.getChildren().add(lastTimeUp2);
        group.getChildren().add(lastTimeUp3);
        group.getChildren().add(lastTestInline1);
        group.getChildren().add(lastTestInline2);
        group.getChildren().add(lastTestInline3);
        group.getChildren().add(p0CheckBox);
        group.getChildren().add(p15CheckBox);
        group.getChildren().add(p21CheckBox);

        Scene scene = new Scene(group,400, 200, Color.web("#E0E0DA"));

        stage.setTitle("Inline Error Check");
        stage.setScene(scene);
        stage.show();
    }
}
