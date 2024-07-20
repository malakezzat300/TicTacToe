package sample;


import java.awt.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;



public class RequestController {
    private Button btnSignUpId;
    @FXML
    private Button acceptId;
    @FXML
    private Button rejectId;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    SceneController Switch = new SceneController();

    public RequestController() {
    }


    @FXML
    void onAccepted(ActionEvent event) {
        try {
            try {
                this.Switch.switchToRecordPrompt(event);
            } catch (IOException var3) {
                IOException e1 = var3;
                e1.printStackTrace();
            }

        } catch (Exception var4) {
            Exception e = var4;
            throw new RuntimeException(e);
        }
    }
}
