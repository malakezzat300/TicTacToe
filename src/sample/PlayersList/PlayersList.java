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
import sample.CustomLabelController;
import sample.StartScreenBase;

import java.util.ArrayList;
import java.util.List;

public class PlayersList extends AnchorPane {

    protected final ListView<HBox> playersListView;
    protected final List<String> players;
    protected final ImageView backButton;  // Changed to Button for consistency
    protected final Label ListPlayersLabel;

    public PlayersList(Stage stage) {

        playersListView = new ListView<>();
        players = new ArrayList<>();
        backButton = new BackButton();  // Changed to Button for consistency
        ListPlayersLabel = new CustomLabelController();

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

        // Header HBox
        HBox headerBox = new HBox();
        headerBox.setPrefHeight(50.0);
        headerBox.setPrefWidth(700.0);
        headerBox.setSpacing(40);
        headerBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));
        headerBox.setLayoutX(650);  // Adjusted position
        headerBox.setLayoutY(100); // Adjusted position

        Label headerName = new Label("Player Name");
        headerName.setPrefWidth(150.0);
        headerName.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label headerScore = new Label("Score");
        headerScore.setPrefWidth(100.0);
        headerScore.setFont(Font.font("Arial", FontWeight.BOLD, 14));


        Label headerStatus = new Label("Player Status");
        headerStatus.setPrefWidth(100.0);
        headerStatus.setFont(Font.font("Arial", FontWeight.BOLD, 14));


        Label headerAction = new Label("Action");
        headerAction.setPrefWidth(150.0);
        headerAction.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        headerBox.getChildren().addAll(headerName, headerStatus, headerScore, headerAction);

        // ListView Setup
        playersListView.setLayoutX(650);  // Adjusted position to align with header
        playersListView.setLayoutY(150); // Adjusted position to align with header
        playersListView.setPrefHeight(400);
        playersListView.setPrefWidth(700);
        playersListView.setMinHeight(300);
        playersListView.setMinWidth(300);
        playersListView.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");


        for (String player : players) {
            HBox hBox = new HBox();
            hBox.setPrefHeight(50.0);
            hBox.setPrefWidth(700.0);  // Adjusted to match ListView width
            hBox.setSpacing(40);
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));

            Label playerName = new Label(player);
            playerName.setPrefHeight(31.0);
            playerName.setPrefWidth(150.0);
            playerName.setFont(Font.font("Arial", FontWeight.NORMAL, 14));


            Label playerScore = new Label("0");  // Default score, adjust as needed
            playerScore.setPrefHeight(21.0);
            playerScore.setPrefWidth(100.0);
            playerScore.setFont(Font.font("Arial", FontWeight.NORMAL, 12));


            Label playerStatus = new Label("Status");
            playerStatus.setPrefHeight(21.0);
            playerStatus.setPrefWidth(100.0);
            playerStatus.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

            ImageView statusImageView = new ImageView();
            statusImageView.setFitHeight(33.0);
            statusImageView.setFitWidth(27.0);
            statusImageView.setPickOnBounds(true);
            statusImageView.setPreserveRatio(true);
            statusImageView.setImage(new Image(getClass().getResource("/assets/Online.png").toExternalForm()));

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

            hBox.getChildren().addAll(playerName, playerScore, playerStatus, statusImageView, askForGameButton);
            playersListView.getItems().add(hBox);
        }

        ListPlayersLabel.setLayoutX(1600);
        ListPlayersLabel.setLayoutY(60);
        ListPlayersLabel.setText("Records");

        getChildren().add(headerBox);  // Add header to the layout
        getChildren().add(playersListView);

        backButton.setLayoutX(20);
        backButton.setLayoutY(60);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new StartScreenBase(stage) {};
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });


        getChildren().add(backButton);
        getChildren().add(ListPlayersLabel);
    }
}
