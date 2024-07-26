package sample;


import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BackButton extends ImageView {

    public BackButton(){
        setFitHeight(120);
        setFitWidth(120);
        setPickOnBounds(true);
        setPreserveRatio(true);
        setImage(new Image(getClass().getResource("assets/arrow.png").toExternalForm()));
    }

}
