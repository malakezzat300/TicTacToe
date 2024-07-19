package sample.SignUpPage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.CustomButtonController;

import java.io.InputStream;

public class SignUpBase extends AnchorPane {

    protected final Text signUpText;
    protected final Text userNameText;
    protected final TextField userNameField;
    protected final Text emailText;
    protected final TextField emailField;
    protected final Text passwordText;
    protected final TextField showPasswordField;
    protected final PasswordField passwordField;
    protected final CustomButtonController registerButton;

    private final ImageView eyeIcon;
    private boolean isPasswordVisible = false;

    public SignUpBase() {

        // Load eye icon resource
        InputStream imageStream = getClass().getResourceAsStream("eye_icon.png");
        if (imageStream == null) {
            System.out.println("Image not found!");
        }
        eyeIcon = new ImageView(new Image(imageStream));

        signUpText = new Text();
        userNameText = new Text();
        userNameField = new TextField();
        emailText = new Text();
        emailField = new TextField();
        passwordText = new Text();
        showPasswordField = new TextField();
        passwordField = new PasswordField();
        registerButton = new CustomButtonController();

        setMaxHeight(800.0);
        setMaxWidth(800.0);
        setMinHeight(800.0);
        setMinWidth(800.0);
        setPrefHeight(778.0);
        setPrefWidth(800.0);

        // Enhanced Text Styling
        signUpText.setLayoutX(82.0);
        signUpText.setLayoutY(69.0);
        signUpText.setText("Sign UP");
        signUpText.setFont(Font.font("Arial", FontWeight.BOLD, 31.0));

        userNameText.setLayoutX(150.0);
        userNameText.setLayoutY(180.0);
        userNameText.setText("UserName");
        userNameText.setFont(Font.font("Arial", FontWeight.BOLD, 23.0));

        userNameField.setLayoutX(151.0);
        userNameField.setLayoutY(211.0);
        userNameField.setPrefHeight(31.0);
        userNameField.setPrefWidth(368.0);

        emailText.setLayoutX(151.0);
        emailText.setLayoutY(291.0);
        emailText.setText("Email");
        emailText.setFont(Font.font("Arial", FontWeight.BOLD, 25.0));

        emailField.setLayoutX(153.0);
        emailField.setLayoutY(333.0);
        emailField.setPrefHeight(26.0);
        emailField.setPrefWidth(368.0);

        passwordText.setLayoutX(153.0);
        passwordText.setLayoutY(426.0);
        passwordText.setText("Password");
        passwordText.setFont(Font.font("Arial", FontWeight.BOLD, 26.0));
        passwordText.setWrappingWidth(150.0);

        showPasswordField.setLayoutX(151.0);
        showPasswordField.setLayoutY(436.0);
        showPasswordField.setPrefHeight(41.0);
        showPasswordField.setPrefWidth(380.0);

        passwordField.setLayoutX(151.0);
        passwordField.setLayoutY(436.0);
        passwordField.setPrefHeight(41.0);
        passwordField.setPrefWidth(380.0);

        eyeIcon.setFitHeight(20.0);  // Set size
        eyeIcon.setFitWidth(20.0);
        eyeIcon.setLayoutX(550.0);  // Set position
        eyeIcon.setLayoutY(446.0);
        setupPasswordVisibilityToggle();
        getChildren().addAll(signUpText, userNameText, userNameField, emailText,
                emailField, passwordText, showPasswordField, passwordField, registerButton, eyeIcon);

        registerButton.setLayoutX(138.0);
        registerButton.setLayoutY(535.0);
        registerButton.setMnemonicParsing(false);
        registerButton.setPrefHeight(31.0);
        registerButton.setPrefWidth(155.0);
        registerButton.setText("Register");

        //______________________________________________
        //______________________________________________
        // working on button register

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userName = userNameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();

                AuthenticateSignUp authenticate; // object from Authenticate
                if (!userName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    authenticate = new AuthenticateSignUp(userName, email, password);

                    try {
                        Thread.sleep(2000); // Sleep for 2 seconds to allow the response to come in
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Now check the userCase
                    String userCase = authenticate.getUserCase();
                    switch (userCase) {
                        case "1":
                            // Handle success case if needed
                            break;
                        case "2":  // Means userName exists
                            showEmailExistsAlert("UserName is Already Exists");
                            break;
                        case "3":  // Means email exists
                            showEmailExistsAlert("Email is Already Exists");
                            break;
                        default:
                            // Handle unknown case if needed
                            break;
                    }
                } else {
                    showEmailExistsAlert("Please fill in all fields.");
                }
            }
        });
    }

    //______________________________________________
    //______________________________________________
    // the Two Functions To Toggle and hide password

    private void setupPasswordVisibilityToggle() {
        eyeIcon.setOnMouseClicked(event -> togglePasswordVisibility());
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordField.setText(showPasswordField.getText()); // put the text that is inside textField
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
