package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public abstract class LoginScreenBase extends AnchorPane {

    protected ImageView backButton;
    protected Label label;
    protected TextField usernameField;
    protected Label label0;
    protected PasswordField passwordField;
    protected Label label1;
    protected Button button;
    protected ImageView imageView;

    public LoginScreenBase(Stage stage) {

        backButton = new ImageView();
        label = new Label();
        usernameField = new TextField();
        label0 = new Label();
        passwordField = new PasswordField();
        label1 = new Label();
        button = new Button();
        imageView = new ImageView();


        Image background = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/tictactoebackground.jpg")));
        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        true, true, true, true));
        this.setBackground(new Background(bgImage));

        setAccessibleRole(javafx.scene.AccessibleRole.TOOL_BAR);
        setMaxHeight(1000.0);
        setMaxWidth(1800.0);
        setPrefHeight(900.0);
        setPrefWidth(1500.0);

        backButton.setFitHeight(120);
        backButton.setFitWidth(120);
        backButton.setLayoutX(1650);
        backButton.setLayoutY(80);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
        backButton.setImage(new Image(getClass().getResource("/assets/arrow.png").toExternalForm()));
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new GoOnlineBase(stage) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

        label.setLayoutX(884.0);
        label.setLayoutY(197.0);
        label.setText("Login");
        label.setFont(new Font(64.0));

        usernameField.setLayoutX(747.0);
        usernameField.setLayoutY(365.0);
        usernameField.setPrefHeight(60.0);
        usernameField.setPrefWidth(450.0);
        usernameField.setFont(new Font(24.0));

        label0.setLayoutX(752.0);
        label0.setLayoutY(329.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(138.0);
        label0.setText("Username");
        label0.setFont(new Font("Jura SemiBold", 26.0));

        passwordField.setLayoutX(747.0);
        passwordField.setLayoutY(489.0);
        passwordField.setPrefHeight(60.0);
        passwordField.setPrefWidth(450.0);
        passwordField.setFont(new Font(24.0));

        label1.setGraphicTextGap(7.0);
        label1.setLayoutX(746.0);
        label1.setLayoutY(454.0);
        label1.setText("Password");
        label1.setFont(new Font("Jura SemiBold", 26.0));

        button.setGraphicTextGap(8.0);
        button.setLayoutX(838.0);
        button.setLayoutY(610.0);
        button.setPrefHeight(46.0);
        button.setPrefWidth(250.0);
        button.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button.setText("Login");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Jura SemiBold", 18.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(150.0);
        imageView.setLayoutX(1900);
        imageView.setLayoutY(63.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("wp8984753.jpg").toExternalForm()));

        getChildren().add(backButton);
        getChildren().add(label);
        getChildren().add(usernameField);
        getChildren().add(label0);
        getChildren().add(passwordField);
        getChildren().add(label1);
        getChildren().add(button);
        getChildren().add(imageView);

    }



}
