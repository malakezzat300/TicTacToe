package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;

public class CustomLabelController extends Label {

    public CustomLabelController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_label.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException ex){
            ex.printStackTrace();
        }



    }

}
