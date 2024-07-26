package sample.PlayersList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.BackButton;  // Ensure this is the correct import
import sample.StartScreenBase;

import java.util.ArrayList;
import java.util.List;

public class PlayersList extends AnchorPane {

    protected final ListView<HBox> playersListView;
    protected final List<String> players;
    protected final Button backButton;  // Changed to Button for consistency

    public PlayersList(Stage stage) {

        playersListView = new ListView<>();
        players = new ArrayList<>();
        backButton = new Button("Back");  // Changed to Button for consistency

        // Sample players for demonstration
        players.add("Player 1");
        players.add("Player 2");
        players.add("Player 3");

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

        for (String player : players) {
            HBox hBox = new HBox();
            hBox.setPrefHeight(50.0);
            hBox.setPrefWidth(407.0);
            hBox.setSpacing(40);
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));

            Label playerName = new Label(player);
            playerName.setPrefHeight(31.0);
            playerName.setPrefWidth(150.0);
            playerName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            playerName.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

            Label playerStatus = new Label("Status");
            playerStatus.setPrefHeight(21.0);
            playerStatus.setPrefWidth(100.0);
            playerStatus.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            playerStatus.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

            ImageView statusImageView = new ImageView();
            statusImageView.setFitHeight(33.0);
            statusImageView.setFitWidth(27.0);
            statusImageView.setPickOnBounds(true);
            statusImageView.setPreserveRatio(true);
            statusImageView.setImage(new Image(getClass().getResource("/sample/assets/Online.png").toExternalForm()));

            Button askForGameButton = new Button("Ask For Game");
            askForGameButton.setMnemonicParsing(false);
            askForGameButton.setPrefHeight(25.0);
            askForGameButton.setPrefWidth(120.0);
            askForGameButton.setFont(Font.font("Arial", FontPosture.ITALIC, 12));
            askForGameButton.setStyle("-fx-text-fill: white; -fx-background-color: #0073e6;");
            askForGameButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Asked " + player + " for a game!");
                }
            });

            hBox.getChildren().addAll(playerName, playerStatus, statusImageView, askForGameButton);
            playersListView.getItems().add(hBox);
        }

        getChildren().add(playersListView);

        backButton.setLayoutX(20);
        backButton.setLayoutY(60);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new StartScreenBase(stage) {};
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

        getChildren().add(backButton);
    }
}
