package sample.RecordGame;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RecordLists extends AnchorPane {

    protected final ListView<HBox> playersListView; // Change to ListView of HBox
    List<String> recordsT;
    String recordsPath = "C:\\TicTacToe\\Records\\";
    protected final static int RECORD_SHOW = 7;
    protected final ImageView backButton;
    protected final Label recordsLabel;

    public RecordLists(Stage stage,List<String> records) { // take a list Here
        recordsT = records;
        playersListView = new ListView<>();
        backButton = new BackButton();
        recordsLabel = new CustomLabelController();

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
        playersListView.setPrefWidth(700);
        playersListView.setMinHeight(300);
        playersListView.setMinWidth(300);
        playersListView.setLayoutX(600);
        playersListView.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        int counter = 1;
        // Populate ListView with HBox
        for (String recordName : recordsT) {

            String record = "Record" ;
            HBox hBox = new HBox();
            Label recordNameLabel = new Label(recordName);
            counter++;

            ImageView imageView = new ImageView();

            recordNameLabel.setPrefHeight(21.0);
            recordNameLabel.setPrefWidth(400);
            recordNameLabel.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

            imageView.setFitHeight(46.0);
            imageView.setFitWidth(55.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
            imageView.setImage(new Image(getClass().getResource("RecordGame/play1.png").toExternalForm()));
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    System.out.println(recordName);
                    String filePath = recordsPath + recordName + ".dat";
                    MatchRecord matchRecord = new MatchRecord();
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                        Object obj = ois.readObject();
                        if (obj instanceof MatchRecord) {
                            matchRecord = (MatchRecord) obj;
                            System.out.println("The winner is: " + matchRecord.getMessage());
                            for (RecordUnit record : matchRecord.getRecords()) {
                                System.out.println(record);
                            }
                        } else {
                            System.out.println("Unknown data format.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Parent root = new GameScreenBase(stage,matchRecord,RECORD_SHOW){};
                    stage.setScene(new Scene(root,600, 600));
                    stage.show();
                    stage.setMinHeight(800);
                    stage.setMinWidth(800);
                    stage.setFullScreen(true);
                }
            });

            hBox.getChildren().add(recordNameLabel);  // add the label
            hBox.getChildren().add(imageView);    // add the image
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 30.0));
            hBox.setSpacing(150);


            playersListView.getItems().add(hBox);  // add  every HBox in the listView

        }

        recordsLabel.setLayoutX(150);
        recordsLabel.setLayoutY(60);
        recordsLabel.setText("Records");


        backButton.setLayoutX(1600);
        backButton.setLayoutY(60);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new StartScreenBase(stage) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

        getChildren().add(playersListView);
        getChildren().add(backButton);
        getChildren().add(recordsLabel);
    }
}
