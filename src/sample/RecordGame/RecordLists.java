package sample.RecordGame;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.List;

public class RecordLists extends AnchorPane {

    protected final ListView<HBox> playersListView; // Change to ListView of HBox
    List<String> recordsT;

    public RecordLists(List<String> records) { // take a list Here
        recordsT = records;
        playersListView = new ListView<>();

   /*     // make list viewe in the middlee
        AnchorPane.setTopAnchor(playersListView, 20.0);
        AnchorPane.setLeftAnchor(playersListView, 20.0);
        AnchorPane.setRightAnchor(playersListView, 20.0);
        AnchorPane.setBottomAnchor(playersListView, 20.0);*/

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(594.0);
        setPrefWidth(746.0);
        setStyle("-fx-background-image: url('/sample/RecordGame/BackGround.jpg'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");

        playersListView.setLayoutX(20);
        playersListView.setLayoutY(100);
        playersListView.setPrefHeight(800);
        playersListView.setPrefWidth(500);
        playersListView.setMinHeight(300);
        playersListView.setMinWidth(300);
        playersListView.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        int counter = 1;
        // Populate ListView with HBox
        for (String recordName : recordsT) {

            String record = "Record" ;
            HBox hBox = new HBox();
            Label recordNameLabel = new Label(record+counter);
            counter++;

            ImageView imageView = new ImageView();

            recordNameLabel.setPrefHeight(21.0);
            recordNameLabel.setPrefWidth(72.0);
            recordNameLabel.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

            imageView.setFitHeight(46.0);
            imageView.setFitWidth(55.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            imageView.setImage(new Image(getClass().getResource("play1.png").toExternalForm()));
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    // action here like show the Recorded video
                    System.out.println("make an Action here ");
                }
            });

            hBox.getChildren().add(recordNameLabel);  // add the label
            hBox.getChildren().add(imageView);    // add the image
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 30.0));
            hBox.setSpacing(150);


            playersListView.getItems().add(hBox);  // add  every HBox in the listView

        }

        getChildren().add(playersListView);
    }
}
