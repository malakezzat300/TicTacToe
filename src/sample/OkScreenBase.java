package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import sample.PlayersList.PlayersList;
import sample.SignUpPage.SignUpBase;


import java.awt.*;
import java.util.Objects;

import static sample.PlayersList.PlayersList.getOpponent;

public class OkScreenBase extends AnchorPane {

    protected ImageView backButton;
    protected Label label;
    protected Label label0;
    protected Label label1;
    protected Button button;
    protected ImageView imageView;
    protected Label label2;
    protected Rectangle rect;
    public static final int LOGIN = 1;
    public static final int SIGNUP = 2;
    public static final int LOGIN_ERROR = 3;
    public static final int SIGNUP_ERROR = 4;
    public static final int RequestPrompt = 5;
    public static final int CLOSESERVER = 6;
    protected int mode;

    public OkScreenBase(Stage stage,String message,int mode) {

        backButton = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        button = new Button();
        imageView = new ImageView();


        Image background = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/tictactoebackground.jpg")));
        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        true, true, true, true));
        this.setBackground(new Background(bgImage));

        setAccessibleRole(AccessibleRole.TOOL_BAR);
        setMaxHeight(1000.0);
        setMaxWidth(1800.0);
        setPrefHeight(900.0);
        setPrefWidth(1500.0);



        Image image = new Image(getClass().getResource("").toExternalForm());

        // Create a BackgroundImage
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                       800,
                 500,          true,
                        true,
                        true,
                        true
                )
        );

        // Create a Background with the BackgroundImage
        Background bkg = new Background(backgroundImage);

        // Set the Background to the Label
        label2.setBackground(bkg);
        label2.setLayoutX(740);
        label2.setLayoutY(240);
        label2.setTextFill(Color.BLACK);
        label2.setAlignment(Pos.CENTER);
        label2.setOpacity(0.8);
        label2.setText(message);
        label2.setFont(new Font("Jura SemiBold", 30));
        label2.setPrefSize(500, 300);





        button.setGraphicTextGap(8.0);
        button.setLayoutX(838.0);
        button.setLayoutY(610.0);
        button.setPrefHeight(46.0);
        button.setPrefWidth(250.0);
        button.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button.setText("OK");
        button.setTextFill(Color.WHITE);
        button.setFont(new Font("Jura SemiBold", 18.0));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(mode == LOGIN){
                    Parent root = new PlayersList(stage) {};
                    stage.setScene(new Scene(root,800, 800));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                } else if (mode == SIGNUP || mode == LOGIN_ERROR){
                    Parent root = new LoginScreenBase(stage) {};
                    stage.setScene(new Scene(root,800, 800));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                } else if (mode == SIGNUP_ERROR){
                    Parent root = new SignUpBase(stage) {};
                    stage.setScene(new Scene(root,800, 800));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                } else if (mode == RequestPrompt){
                    Parent root = new RequestPromptBase(stage,getOpponent()) {
                    };
                    stage.setScene(new Scene(root,800, 800));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                } else if (mode == CLOSESERVER){
                    Parent root = new StartScreenBase(stage) {
                    };
                    stage.setScene(new Scene(root,800, 800));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                }
            }
        });

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(150.0);
        imageView.setLayoutX(1900);
        imageView.setLayoutY(63.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/tictactoebackground.jpg").toExternalForm()));


        getChildren().add(backButton);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(button);
        getChildren().add(imageView);
        getChildren().add(label2);


    }


    public OkScreenBase() {

    }
}

