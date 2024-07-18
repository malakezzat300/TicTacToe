package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;

public class CustomButtonController extends CustomButtonBase {

    public CustomButtonController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_button.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> handleMouseEntered());
        this.addEventHandler(MouseEvent.MOUSE_EXITED, event -> handleMouseExited());


    }

    private void handleMouseEntered() {
        this.setStyle("-fx-background-color: lightblue;");
        setTextFill(Color.BLACK);
    }

    private void handleMouseExited() {
        this.setStyle("-fx-background-color: #2c2c2c;");
        setTextFill(Color.WHITE);
    }

}
