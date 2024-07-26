package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    protected final static int SINGLE_MODE = 1;
    protected final static int OFFLINE_MODE = 2;
    protected final static int SINGLE_MODE_RECORDING = 3;
    protected final static int OFFLINE_MODE_RECORDING = 4;


    public RecordController() {
    }


    @FXML
    void onAccepted(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = new GameScreenBase(stage,OfflineNamesBase.getPlayerOne(),OfflineNamesBase.getPlayerTwo(),makeRecordMode(OfflineNamesBase.getMode())) {};
        stage.setScene(new Scene(root,800, 800));
        stage.show();
        stage.setMinHeight(800);
        stage.setMinWidth(800);
        stage.setMaxHeight(3000);
        stage.setMaxWidth(3000);
        stage.setFullScreen(true);
    }


    public void onReject(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = new GameScreenBase(stage,OfflineNamesBase.getPlayerOne(),OfflineNamesBase.getPlayerTwo(),OfflineNamesBase.getMode()) {};
        stage.setScene(new Scene(root,800, 800));
        stage.show();
        stage.setMinHeight(800);
        stage.setMinWidth(800);
        stage.setMaxHeight(3000);
        stage.setMaxWidth(3000);
        stage.setFullScreen(true);

    }

    public int makeRecordMode(int mode){
        if(mode == SINGLE_MODE){
            return SINGLE_MODE_RECORDING;
        } else if(mode == OFFLINE_MODE){
            return OFFLINE_MODE_RECORDING;
        } else {
            return mode;
        }
    }
}

