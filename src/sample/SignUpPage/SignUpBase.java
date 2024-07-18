package sample.SignUpPage;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class SignUpBase extends AnchorPane {

    protected final Text signUpText;
    protected final Text userNameText;
    protected final TextField userNameField;
    protected final Text emailText;
    protected final TextField emailField;
    protected final Text passwordText;
    protected final TextField passwordField;
    protected final Button registerButton;

    public SignUpBase() {

        signUpText = new Text();
        userNameText = new Text();
        userNameField = new TextField();
        emailText = new Text();
        emailField = new TextField();
        passwordText = new Text();
        passwordField = new TextField();
        registerButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        signUpText.setLayoutX(65.0);
        signUpText.setLayoutY(56.0);
        signUpText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signUpText.setStrokeWidth(0.0);
        signUpText.setText("Sign Up");
        signUpText.setStyle("-fx-font-weight: bold;");

        userNameText.setLayoutX(103.0);
        userNameText.setLayoutY(93.0);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("User Name");
        userNameText.setStyle("-fx-font-weight: bold;");

        userNameField.setLayoutX(103.0);
        userNameField.setLayoutY(120.0);

        emailText.setLayoutX(103.0);
        emailText.setLayoutY(180.0);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("Email");
        emailText.setStyle("-fx-font-weight: bold;");

        emailField.setLayoutX(103.0);
        emailField.setLayoutY(200.0);

        passwordText.setLayoutX(107.0);
        passwordText.setLayoutY(270.0);
        passwordText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        passwordText.setStrokeWidth(0.0);
        passwordText.setText("Password");
        passwordText.setStyle("-fx-font-weight: bold;");

        passwordField.setLayoutX(103.0);
        passwordField.setLayoutY(297.0);

        registerButton.setLayoutX(103.0);
        registerButton.setLayoutY(349.0);
        registerButton.setMnemonicParsing(false);
        registerButton.setText("Register");

        getChildren().add(signUpText);
        getChildren().add(userNameText);
        getChildren().add(userNameField);
        getChildren().add(emailText);
        getChildren().add(emailField);
        getChildren().add(passwordText);
        getChildren().add(passwordField);
        getChildren().add(registerButton);
    }
}


