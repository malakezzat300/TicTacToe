package sample.SignUpPage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import sample.CustomButtonController;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.InputStream;
import java.util.Objects;

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
    protected final Label passwordValidationLabel; // used to view pass State
    protected final Label emailValidationLabel; //email validation label

    private final ImageView eyeIcon;
    private boolean isPasswordVisible = false;

    public SignUpBase() {

        // backGround image

        // Background image (Stretch to fit)
        Image background = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BackGround.jpg")));
        BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        true, true, true, true));
        this.setBackground(new Background(bgImage));

        // Load eye icon resource
        InputStream imageStream = getClass().getResourceAsStream("eye_icon.png");
        if (imageStream == null) {System.out.println("Image not found!");}
        eyeIcon = new ImageView(new Image(Objects.requireNonNull(imageStream)));

        signUpText = new Text();
        userNameText = new Text();
        userNameField = new TextField();
        emailText = new Text();
        emailField = new TextField();
        passwordText = new Text();
        showPasswordField = new TextField();
        passwordField = new PasswordField();
        registerButton = new CustomButtonController();
        passwordValidationLabel = new Label(); // password validation intialize
        emailValidationLabel = new Label(); // email validation intialize



        setMinHeight(800.0);
        setMinWidth(800.0);



        // SignUp Text Styling
        signUpText.setLayoutX(82.0);
        signUpText.setLayoutY(69.0);
        signUpText.setStrokeWidth(0.0);
        signUpText.setText("Sign UP");
        signUpText.setFont(Font.font("Arial", FontWeight.BOLD, 31.0));


        userNameText.setLayoutX(106.0);
        userNameText.setLayoutY(169.0);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("UserName");
        userNameText.setFont(Font.font("Arial", FontWeight.BOLD, 23.0));

        userNameField.setLayoutX(106.0);
        userNameField.setLayoutY(201.0);
        userNameField.setPrefHeight(63.0);
        userNameField.setPrefWidth(656.0);


        emailText.setLayoutX(109.0);
        emailText.setLayoutY(343.0);
        emailText.setStrokeWidth(0.0);
        emailText.setText("Email");
        emailText.setFont(Font.font("Arial", FontWeight.BOLD, 25.0));

        emailField.setLayoutX(106.0);
        emailField.setLayoutY(370.0);
        emailField.setPrefHeight(63.0);
        emailField.setPrefWidth(656.0);

        passwordText.setLayoutX(103.0);
        passwordText.setLayoutY(512.0);
        passwordText.setStrokeWidth(0.0);
        passwordText.setText("Password");
        passwordText.setFont(Font.font("Arial", FontWeight.BOLD, 26.0));
        passwordText.setWrappingWidth(150.0);

        showPasswordField.setLayoutX(106.0);
        showPasswordField.setLayoutY(535.0);
        showPasswordField.setPrefHeight(63.0);
        showPasswordField.setPrefWidth(656.0);

        passwordField.setLayoutX(106.0);
        passwordField.setLayoutY(535.0);
        passwordField.setPrefHeight(63.0);
        passwordField.setPrefWidth(656.0);


        eyeIcon.setFitHeight(30.0);  // Set size
        eyeIcon.setFitWidth(30);
        eyeIcon.setLayoutX(700.0);  // Set position
        eyeIcon.setLayoutY(500.0);

        registerButton.setLayoutX(103.0);
        registerButton.setLayoutY(643.0);
        registerButton.setMnemonicParsing(false);
        registerButton.setPrefHeight(31.0);
        registerButton.setPrefWidth(155.0);
        registerButton.setText("Register");

        // password validation properties
        passwordValidationLabel.setLayoutX(151.0);
        passwordValidationLabel.setLayoutY(600.0);
        passwordValidationLabel.setStyle("-fx-text-fill: red;");
        // email validation properties
        emailValidationLabel.setLayoutX(151.0);
        emailValidationLabel.setLayoutY(430.0);
        emailValidationLabel.setStyle("-fx-text-fill: red;");
        // password visability fun
        setupPasswordVisibilityToggle();
        // password validation  fun
        setupPasswordValidation ();
        // email validation fun
        setupEmailValidation();

        // adding elements to Anchor pane node
        getChildren().addAll(signUpText, userNameText, userNameField,
                emailText, emailField, passwordText,
                showPasswordField, passwordField, registerButton,
                eyeIcon,passwordValidationLabel,emailValidationLabel);
        //______________________________________________
        // working on button register

        registerButton.setOnAction(event -> {
            String userName = userNameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String userType = "1";  // mean user in register state

            AuthenticateSignUp authenticate; // object from Authenticate
            if (!userName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                authenticate = new AuthenticateSignUp(userName, email, password,userType);

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
        });
    }
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
        alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();
    }
    //______________________________________________
    //______________________________________________
    // working on Type of password user Enter
    private void setupPasswordValidation(){
        // lamda take three elements
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(validatePassword(newValue)){
                passwordValidationLabel.setText("");
            }
            else{
                passwordValidationLabel.setText("Password must be at least 8 characters" +
                        " and contain uppercase, lowercase, numbers, and special characters.");
            }

        });
    }

    private boolean validatePassword(String password) {
        // Minimum 8 characters, at least one uppercase letter, one lowercase letter, one number, and one special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }

    //______________________________________________
    //______________________________________________
    // working on email validation
    private void setupEmailValidation() {
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (validateEmail(newValue)) {
                emailValidationLabel.setText("");
            } else {
                emailValidationLabel.setText("Invalid email format.");
            }
        });
    }

    private boolean validateEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailPattern);
    }

}