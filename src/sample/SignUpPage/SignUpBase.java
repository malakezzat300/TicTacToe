package sample.SignUpPage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.CustomButtonController;

public class SignUpBase extends GridPane {

    AuthenticateSignUp authenticate ; // object from Authenticate

    private final ColumnConstraints columnConstraints;
    private final ColumnConstraints columnConstraints0;
    private final ColumnConstraints columnConstraints1;
    private final RowConstraints rowConstraints;
    private final RowConstraints rowConstraints0;
    private final RowConstraints rowConstraints1;
    private final RowConstraints rowConstraints2;
    private final RowConstraints rowConstraints3;
    private final RowConstraints rowConstraints4;
    private final RowConstraints rowConstraints5;
    private final RowConstraints rowConstraints6;
    private final RowConstraints rowConstraints7;
    private final TextField userNameField;
    private final Text emailText;
    private final Text passwordText;
    private final CustomButtonController registerButton;
    private final Text userNameText;
    private final TextField emailField;
    private final BorderPane borderPane;
    private final Text text;

    // fields related when typing pasword

    private final PasswordField passwordField;
    private final TextField showPasswordField;
    private final ImageView eyeIcon;
    private boolean isPasswordVisible = false;

    public SignUpBase() {
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        userNameField = new TextField();
        emailText = new Text();
        passwordText = new Text();
        registerButton = new CustomButtonController();
        userNameText = new Text();
        emailField = new TextField();
        borderPane = new BorderPane();
        text = new Text();
        passwordField = new PasswordField();
        showPasswordField = new TextField();
        // putting eye resource
        eyeIcon = new ImageView(new Image(getClass().
                getResourceAsStream("eye_icon.png")));

        setupLayout();
        setupPasswordVisibilityToggle();
    }

    private void setupLayout() {
        setAlignment(javafx.geometry.Pos.CENTER);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(813.0);
        setPrefWidth(1001.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(Double.MAX_VALUE);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(132.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(Double.MAX_VALUE);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(654.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(140.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(5.0);
        rowConstraints5.setPrefHeight(15.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(30.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(userNameField, 1);
        GridPane.setRowIndex(userNameField, 2);
        userNameField.setFont(new Font(23.0));

        GridPane.setColumnIndex(emailText, 1);
        GridPane.setRowIndex(emailText, 3);
        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("Email");
        emailText.setFont(new Font(25.0));

        GridPane.setColumnIndex(passwordText, 1);
        GridPane.setRowIndex(passwordText, 5);
        passwordText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        passwordText.setStrokeWidth(0.0);
        passwordText.setText("Password");
        passwordText.setFont(new Font(26.0));

        GridPane.setColumnIndex(registerButton, 1);
        GridPane.setRowIndex(registerButton, 7);
        registerButton.setMnemonicParsing(false);
        registerButton.setText("Register");
        registerButton.setFont(new Font(25.0));

        GridPane.setColumnIndex(userNameText, 1);
        GridPane.setRowIndex(userNameText, 1);
        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("UserName");
        userNameText.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        GridPane.setMargin(userNameText, new Insets(0.0));
        userNameText.setFont(new Font(32.0));

        GridPane.setColumnIndex(emailField, 1);
        GridPane.setRowIndex(emailField, 4);
        emailField.setFont(new Font(25.0));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Sign Up");
        text.setFont(new Font(33.0));
        borderPane.setBottom(text);

        GridPane.setColumnIndex(passwordField, 1);
        GridPane.setRowIndex(passwordField, 6);
        passwordField.setPrefHeight(53.0);
        passwordField.setPrefWidth(679.0);

        GridPane.setColumnIndex(showPasswordField, 1);
        GridPane.setRowIndex(showPasswordField, 6);
        showPasswordField.setPrefHeight(54.0);
        showPasswordField.setPrefWidth(679.0);
        showPasswordField.setVisible(false);

        GridPane.setColumnIndex(eyeIcon, 2);
        GridPane.setRowIndex(eyeIcon, 6);
        eyeIcon.setFitHeight(24.0);
        eyeIcon.setFitWidth(24.0);
        eyeIcon.setPreserveRatio(true);
        eyeIcon.setPickOnBounds(true);

        getColumnConstraints().addAll(columnConstraints, columnConstraints0, columnConstraints1);
        getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4, rowConstraints5, rowConstraints6, rowConstraints7);
        getChildren().addAll(userNameField, emailText, passwordText, registerButton, userNameText, emailField, borderPane, passwordField, showPasswordField, eyeIcon);

        /********************************************/
        /********************************************/
        // working on button register

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userName = userNameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                // send data to Authenticate class
                authenticate  = new AuthenticateSignUp(userName,email,password) ;
                if (!userName.isEmpty()&&email.isEmpty()&&password.isEmpty()){
                    authenticate.sendSignUpData();
                }
                if (authenticate.getUserCase().equals("1")){

                } else if (authenticate.getUserCase().equals("2")) { // mean userName Exsist

                    showEmailExistsAlert("UserName is Already Exists");

                } else if (authenticate.getUserCase().equals("3")) { // means EmailExsist
                    showEmailExistsAlert("Email is Already Exsists ");
                }
            }
        });

    }
    /********************************************/
    /********************************************/

    // the Two Functions To Toggile and hide password

    private void setupPasswordVisibilityToggle() {
        eyeIcon.setOnMouseClicked(event -> togglePasswordVisibility());
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordField.setText(showPasswordField.getText());
            passwordField.setVisible(true);
            showPasswordField.setVisible(false);
            isPasswordVisible = false;
        } else {
            showPasswordField.setText(passwordField.getText());
            showPasswordField.setVisible(true);
            passwordField.setVisible(false);
            isPasswordVisible = true;
        }

    }
    // alert to put to user

    public void showEmailExistsAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sign Up Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
