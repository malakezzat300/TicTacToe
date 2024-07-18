package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public abstract class custom_buttonBase extends Button {

    public custom_buttonBase() {

        setMnemonicParsing(false);
        setStyle("-fx-background-color: #2c2c2c; -fx-background-radius: 8px;");
        setText("Button");
        setTextFill(javafx.scene.paint.Color.WHITE);
        setFont(new Font(24.0));

    }

}
