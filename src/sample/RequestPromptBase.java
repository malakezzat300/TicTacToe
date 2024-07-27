package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import sample.NetworkPackge.ClientSocket;
import sample.PlayersList.PlayersList;

public class RequestPromptBase extends AnchorPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final ImageView backButton;
    protected static String opponent;

    public RequestPromptBase(Stage stage, String opponentName) {

        imageView = new ImageView();
        borderPane = new BorderPane();
        label = new Label();
        button = new Button();
        button0 = new Button();
        backButton = new BackButton();

        setAccessibleRole(javafx.scene.AccessibleRole.TOOL_BAR);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);

        imageView.setFitHeight(1500.0);
        imageView.setFitWidth(1942.0);
        imageView.setLayoutX(100.0);
        imageView.setLayoutY(10.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/tictactoebackground.jpg").toExternalForm()));

        borderPane.setLayoutX(534.0);
        borderPane.setLayoutY(370.0);
        borderPane.setOpacity(0.6);
        borderPane.setPrefHeight(304.0);
        borderPane.setPrefWidth(827.0);
        borderPane.setStyle("-fx-background-color: WHITE; ");

        label.setLayoutX(749.0);
        label.setLayoutY(479.0);
        label.setPrefHeight(87.0);
        label.setPrefWidth(470.0);
        label.setText("Player " +opponentName+ " invited you to join a game ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#101046"));
        label.setFont(new Font("Jura Light", 26.0));

        button.setGraphicTextGap(8.0);
        button.setLayoutX(693.0);
        button.setLayoutY(619.0);
        // button.setOnAction(this::onAccepted);
        button.setPrefHeight(46.0);
        button.setPrefWidth(171.0);
        button.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button.setText("Accept");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Jura Light", 18.0));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClientSocket clientSocket = ClientSocket.getInstance();
                clientSocket.connectClient();
                JSONObject jsonObject = types.responseAccept();
                String jsonText = jsonObject.toString();
                ClientSocket.sendToServer(jsonText,0);
                Parent root = new GameScreenBase(stage,LoginScreenBase.getUserName(),PlayersList.getOpponent(),GameScreenBase.ONLINE_MODE,false) {};
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });
//
        button0.setGraphicTextGap(8.0);
        button0.setLayoutX(1030.0);
        button0.setLayoutY(620.0);
        button0.setPrefHeight(46.0);
        button0.setPrefWidth(171.0);
        button0.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button0.setText("Reject");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("Jura Light", 18.0));
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClientSocket clientSocket = ClientSocket.getInstance();
                clientSocket.connectClient();
                JSONObject jsonObject = types.responseRefuse();
                String jsonText = jsonObject.toString();
                ClientSocket.sendToServer(jsonText,0);
                Parent root = new PlayersList(stage){
                };
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });
//
//
        getChildren().add(imageView);
        getChildren().add(borderPane);
        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);


    }
}



