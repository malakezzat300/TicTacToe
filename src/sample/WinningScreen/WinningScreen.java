package sample.WinningScreen;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

public  class WinningScreen extends AnchorPane {

    protected final MediaView mediaView;
    protected final VBox vBox;
    protected final Button playAgainButton;
    protected final Button backHomeButton;

    public WinningScreen() {

        mediaView = new MediaView();
        vBox = new VBox();
        playAgainButton = new Button();
        backHomeButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        mediaView.setFitHeight(400.0);
        mediaView.setFitWidth(600.0);

        vBox.setLayoutX(493.0);
        vBox.setLayoutY(116.0);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        playAgainButton.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        playAgainButton.setMnemonicParsing(false);
        playAgainButton.setText("Play Again");

        backHomeButton.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        backHomeButton.setLayoutX(493.0);
        backHomeButton.setLayoutY(285.0);
        backHomeButton.setMnemonicParsing(false);
        backHomeButton.setText("Back Home");

        getChildren().add(mediaView);
        vBox.getChildren().add(playAgainButton);
        getChildren().add(vBox);
        getChildren().add(backHomeButton);

    }
}
