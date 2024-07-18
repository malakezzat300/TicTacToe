package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public abstract class CustomButtonBase extends Button {

    public CustomButtonBase() {

        setMnemonicParsing(false);
        setStyle("-fx-background-color: #2c2c2c; -fx-background-radius: 8px;");
        setText("Button");
        setTextFill(javafx.scene.paint.Color.WHITE);
        setFont(new Font(24.0));

    }

}
