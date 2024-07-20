package sample;


import java.awt.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
    Pane pane = new Pane();
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;
    @FXML
    private Button btnSignUpId;
    @FXML
    private Button btnloginId;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    SceneController Switch = new SceneController();

    public LoginController() {
    }

    public void setStageAndSetupListeners(Stage stage) {
    }

    @FXML
    void btnLoginClicked(ActionEvent event) {
        try {
            String username = this.usernameField.getText();
            String password = this.passwordField.getText();
            if ("ahmed".equals(username) && "123".equals(password)) {
                try {
                    this.Switch.switchToRquestPage(event);
                } catch (IOException var5) {
                    IOException e1 = var5;
                    e1.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Please provide your email and password");
                alert.show();
            }

        } catch (Exception var6) {
            Exception e = var6;
            throw new RuntimeException(e);
        }
    }
}

