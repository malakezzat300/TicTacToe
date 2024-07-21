package sample.WinningScreen;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import sample.CustomButtonController;

public  class WinningScreen extends AnchorPane {

    protected final MediaView mediaView;
    protected final VBox vBox;
    protected final CustomButtonController playAgainButton;
    protected final CustomButtonController backHomeButton;

    String videoPath;
    Media media;
    MediaPlayer mediaPlayer;


    public WinningScreen(Stage stage) {

        // media intialize
        videoPath = String.valueOf(getClass().getResource("/sample/WinningScreen/CelebrateVideo.mp4"));
        media = new Media(videoPath) ; // give it the path
        mediaPlayer = new MediaPlayer(media) ;
        mediaView = new MediaView(mediaPlayer);


        mediaView.setFitHeight(400.0);  // some configration for media view
        mediaView.setFitWidth(600.0);
        mediaView.setPreserveRatio(true);
        mediaView.fitWidthProperty().bind(stage.widthProperty());
        mediaView.fitHeightProperty().bind(stage.heightProperty());



        // buttons intialize
        playAgainButton = new CustomButtonController();
        backHomeButton = new CustomButtonController();
        vBox = new VBox(80,playAgainButton,backHomeButton);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);



        vBox.setAlignment(Pos.CENTER_RIGHT);
        vBox.setStyle("-fx-padding: 20px;");

        playAgainButton.setText("Play Again");
        backHomeButton.setText("Back Home");

        // put the VBox in the right of the Anchor pane
        AnchorPane.setTopAnchor(vBox, 20.0);
        AnchorPane.setRightAnchor(vBox, 20.0);

        mediaPlayer.play(); // play the media
        // Set media to repeat
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));

        getChildren().addAll(mediaView,vBox); // adding vBox and media view in Anchor pane



    }
}
