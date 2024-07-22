package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;

public class RecordController {





    Pane pane = new Pane();
    private Button btnSignUpId;
    @FXML
    private Button acceptId;
    @FXML
    private Button rejectId;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    SceneController Switch = new SceneController();

    public RecordController() {
    }


    @FXML
    void onAccepted(ActionEvent event) {
        try {
            try {
                this.Switch.switchToGameBoard(event);
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

