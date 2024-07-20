package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;

public abstract class CustomLabelController extends CustomLabelBase {

    public CustomLabelController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_label.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);



    }

}
