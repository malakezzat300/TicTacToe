package sample.PlayersList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import sample.*;
import sample.NetworkPackge.ClientSocket;
import sample.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayersList extends AnchorPane {

    protected final ListView<HBox> playersListView;
    protected final List<String> players;
    protected final ImageView backButton;
    protected final Label ListPlayersLabel;
    protected final static String OFFLINE = "offline";
    protected final static String ONLINE = "online";
    protected final static String REQUEST = "request";
    protected final static String INGAME = "inGame";
    protected final ImageView refreshButton;
    ArrayList<UserRecord> userArrayList = new ArrayList<>();
    protected HBox headerBox;
    protected HBox hBox;


    public PlayersList(Stage stage) {

        ClientSocket clientSocket = ClientSocket.getInstance();
        clientSocket.connectClient();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(types.type,types.List);
        jsonObject.put(types.Username,LoginScreenBase.getUserName());
        jsonObject.put(types.Password,LoginScreenBase.getPassword());
        ClientSocket.sendToServer(jsonObject.toString(),0);

        System.out.println(clientSocket.getMesage());



        playersListView = new ListView<>();
        players = new ArrayList<>();
        backButton = new BackButton();  // Changed to Button for consistency
        ListPlayersLabel = new CustomLabelController();
        refreshButton = new ImageView();
        MyUpdateTask myUpdateTask = new MyUpdateTask();
        Thread  t =new Thread(myUpdateTask);
        t.setDaemon(true);
        t.start();

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
        headerBox = new HBox();
        headerBox.setPrefHeight(50.0);
        headerBox.setPrefWidth(700.0);
        headerBox.setSpacing(40);
        headerBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));
        headerBox.setLayoutX(650);  // Adjusted position
        headerBox.setLayoutY(100); // Adjusted position

        Label headerName = new Label("Player Name");
        headerName.setPrefWidth(150.0);
        headerName.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label headerScore = new Label("Status");
        headerScore.setPrefWidth(100.0);
        headerScore.setFont(Font.font("Arial", FontWeight.BOLD, 14));


        Label headerStatus = new Label("Player Score");
        headerStatus.setPrefWidth(100.0);
        headerStatus.setFont(Font.font("Arial", FontWeight.BOLD, 14));


        Label headerAction = new Label("Action");
        headerAction.setPrefWidth(150.0);
        headerAction.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        headerBox.getChildren().addAll(headerName, headerStatus, headerScore, headerAction);

        // ListView Setup

        playersListView.setLayoutX(650);  // Adjusted position to align with header
        playersListView.setLayoutY(150); // Adjusted position to align with header
        playersListView.setPrefHeight(800);
        playersListView.setPrefWidth(700);
        playersListView.setMinHeight(300);
        playersListView.setMinWidth(300);
        playersListView.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        myUpdateTask.messageProperty().addListener((x,y,z)-> {
            System.out.println("--------------->" + ClientSocket.myMesage);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        org.json.simple.JSONObject object = (org.json.simple.JSONObject) JSONValue.parse(ClientSocket.myMesage);

                        try {
                            userArrayList = getUsers(ClientSocket.myMesage);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        if (object.get(types.type).equals(types.startGame)) {
                            // navigate

                        }
                        if (object.get(types.type).equals(types.RequestToPlayResponse)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText((String) object.get(types.Message));
                            alert.showAndWait();
                        }
                        System.out.println("entered  1" + ClientSocket.myMesage);
                        System.out.println("entered  1" + object.get(types.type).equals(types.RequestToPlay));

                        if (object.get(types.type).equals(types.RequestToPlay)) {
                            System.out.println("entered  " + ClientSocket.myMesage);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText((String) object.get(types.Opponent));
                            alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                            Optional<ButtonType> result = alert.showAndWait();
                            // Determine which button was clicked
                            if (result.isPresent()) {
                                if (result.get() == ButtonType.YES) {
                                    JSONObject jsonObject1 = new JSONObject();
                                    jsonObject1.put(types.type, types.RequestToPlayResponse);
                                    jsonObject1.put(types.Message, types.Accept);
                                    ClientSocket.sendToServer(jsonObject1.toString(), 2);
                                } else if (result.get() == ButtonType.NO) {
                                    JSONObject jsonObject1 = new JSONObject();
                                    jsonObject1.put(types.type, types.RequestToPlayResponse);
                                    jsonObject1.put(types.Message, types.Refuse);
                                    ClientSocket.sendToServer(jsonObject1.toString(), 0);

                                }
                            }
                        }
                        for (UserRecord player : userArrayList) {
                            HBox hBox = new HBox();
                            hBox.setPrefHeight(50.0);
                            hBox.setPrefWidth(700.0);  // Adjusted to match ListView width
                            hBox.setSpacing(40);
                            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));
                            Label playerName = new Label(player.getUsername());
                            playerName.setPrefHeight(31.0);
                            playerName.setPrefWidth(150.0);
                            playerName.setFont(Font.font("Arial", FontWeight.NORMAL, 14));


                            Label playerScore = new Label(String.valueOf(player.getPscore()));  // Default score, adjust as needed
                            playerScore.setPrefHeight(21.0);
                            playerScore.setPrefWidth(100.0);
                            playerScore.setFont(Font.font("Arial", FontWeight.NORMAL, 12));


                            Label playerStatus = new Label(player.getState());
                            playerStatus.setPrefHeight(21.0);
                            playerStatus.setPrefWidth(100.0);
                            playerStatus.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

                            ImageView statusImageView = new ImageView();
                            statusImageView.setFitHeight(33.0);
                            statusImageView.setFitWidth(27.0);
                            statusImageView.setPickOnBounds(true);
                            statusImageView.setPreserveRatio(true);
                            if (player.getState().equals(ONLINE)) {
                                statusImageView.setImage(new Image(getClass().getResource("/assets/Online.png").toExternalForm()));
                            } else if (player.getState().equals(OFFLINE)) {
                                statusImageView.setImage(new Image(getClass().getResource("/assets/offline.png").toExternalForm()));
                            } else if (player.getState().equals(REQUEST)) {
                                statusImageView.setImage(new Image(getClass().getResource("/assets/request.png").toExternalForm()));
                            } else if (player.getState().equals(INGAME)) {
                                statusImageView.setImage(new Image(getClass().getResource("/assets/InGame.png").toExternalForm()));
                            }


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
                                    org.json.simple.JSONObject object1 = new org.json.simple.JSONObject();
                                    object1.put(types.Opponent, player.getUsername());
                                    object1.put(types.type, types.RequestToPlay);
                                    ClientSocket.sendToServer(object1.toString(), 1);
                                }
                            });

                            hBox.getChildren().addAll(playerName, playerScore, playerStatus, statusImageView, askForGameButton);
                            playersListView.getItems().add(hBox);
                        }

                    }
                });

          });


        for (UserRecord player : userArrayList) {
            hBox = new HBox();
            hBox.setPrefHeight(50.0);
            hBox.setPrefWidth(700.0);  // Adjusted to match ListView width
            hBox.setSpacing(40);
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));

            Label playerName = new Label(player.getUsername());
            playerName.setPrefHeight(31.0);
            playerName.setPrefWidth(150.0);
            playerName.setFont(Font.font("Arial", FontWeight.NORMAL, 14));


            Label playerScore = new Label(String.valueOf(player.getPscore()));  // Default score, adjust as needed
            playerScore.setPrefHeight(21.0);
            playerScore.setPrefWidth(100.0);
            playerScore.setFont(Font.font("Arial", FontWeight.NORMAL, 12));


            Label playerStatus = new Label(player.getState());
            playerStatus.setPrefHeight(21.0);
            playerStatus.setPrefWidth(100.0);
            playerStatus.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

            ImageView statusImageView = new ImageView();
            statusImageView.setFitHeight(33.0);
            statusImageView.setFitWidth(27.0);
            statusImageView.setPickOnBounds(true);
            statusImageView.setPreserveRatio(true);
            if(player.getState().equals(ONLINE)){
                statusImageView.setImage(new Image(getClass().getResource("/assets/Online.png").toExternalForm()));
            } else if(player.getState().equals(OFFLINE)){
                statusImageView.setImage(new Image(getClass().getResource("/assets/offline.png").toExternalForm()));
            } else if(player.getState().equals(REQUEST)){
                statusImageView.setImage(new Image(getClass().getResource("/assets/request.png").toExternalForm()));
            } else if(player.getState().equals(INGAME)){
                statusImageView.setImage(new Image(getClass().getResource("/assets/InGame.png").toExternalForm()));
            }


            Button askForGameButton = new Button("Ask For Game");
            askForGameButton.setMnemonicParsing(false);
            askForGameButton.setPrefHeight(25.0);
            askForGameButton.setPrefWidth(120.0);
            askForGameButton.setFont(Font.font("Arial", FontPosture.ITALIC, 12));
            askForGameButton.setStyle("-fx-text-fill: white; -fx-background-color: #0073e6;");
            askForGameButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ClientSocket clientSocket2 = ClientSocket.getInstance();
                    clientSocket2.connectClient();
                    org.json.simple.JSONObject jsonObject2 = new org.json.simple.JSONObject();
                    jsonObject2.put(types.type,types.RequestToPlay);
                    jsonObject2.put(types.Opponent,player.getUsername());
                    ClientSocket.sendToServer(jsonObject2.toString(),0);
                    System.out.println(clientSocket2.getMesage());
                    System.out.println("Asked " + player.getUsername() + " for a game!");
                }
            });

            hBox.getChildren().addAll(playerName, playerScore, playerStatus, statusImageView, askForGameButton);
            playersListView.getItems().add(hBox);
        }


        ListPlayersLabel.setLayoutX(80);
        ListPlayersLabel.setLayoutY(60);
        ListPlayersLabel.setText("Records");

        getChildren().add(headerBox);  // Add header to the layout
        getChildren().add(playersListView);

        backButton.setLayoutX(1600);
        backButton.setLayoutY(60);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new LoginScreenBase(stage) {};
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });


        refreshButton.setFitHeight(120);
        refreshButton.setFitWidth(120.0);
        refreshButton.setLayoutX(1400);
        refreshButton.setLayoutY(60);
        refreshButton.setImage(new Image(getClass().getResource("/assets/refresh.png").toExternalForm()));
        refreshButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    refreshPlayersList();
                }catch (Exception e){

                }

            }
        });


        getChildren().add(backButton);
        getChildren().add(ListPlayersLabel);
        getChildren().add(refreshButton);
    }

    private void populateList(ArrayList<UserRecord> userArrayList) {
        playersListView.getItems().clear();
        for (UserRecord player : userArrayList) {
            hBox = new HBox();
            hBox.setPrefHeight(50.0);
            hBox.setPrefWidth(700.0);  // Adjusted to match ListView width
            hBox.setSpacing(40);
            hBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));

            Label playerName = new Label(player.getUsername());
            playerName.setPrefHeight(31.0);
            playerName.setPrefWidth(150.0);
            playerName.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

            Label playerScore = new Label(String.valueOf(player.getPscore()));  // Default score, adjust as needed
            playerScore.setPrefHeight(21.0);
            playerScore.setPrefWidth(100.0);
            playerScore.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

            Label playerStatus = new Label(player.getState());
            playerStatus.setPrefHeight(21.0);
            playerStatus.setPrefWidth(100.0);
            playerStatus.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

            ImageView statusImageView = new ImageView();
            statusImageView.setFitHeight(33.0);
            statusImageView.setFitWidth(27.0);
            statusImageView.setPickOnBounds(true);
            statusImageView.setPreserveRatio(true);
            if (player.getState().equals(ONLINE)) {
                statusImageView.setImage(new Image(getClass().getResource("/assets/Online.png").toExternalForm()));
            } else if (player.getState().equals(OFFLINE)) {
                statusImageView.setImage(new Image(getClass().getResource("/assets/offline.png").toExternalForm()));
            } else if (player.getState().equals(REQUEST)) {
                statusImageView.setImage(new Image(getClass().getResource("/assets/request.png").toExternalForm()));
            } else if (player.getState().equals(INGAME)) {
                statusImageView.setImage(new Image(getClass().getResource("/assets/InGame.png").toExternalForm()));
            }

            Button askForGameButton = new Button("Ask For Game");
            askForGameButton.setMnemonicParsing(false);
            askForGameButton.setPrefHeight(25.0);
            askForGameButton.setPrefWidth(120.0);
            askForGameButton.setFont(Font.font("Arial", FontPosture.ITALIC, 12));
            askForGameButton.setStyle("-fx-text-fill: white; -fx-background-color: #0073e6;");
            askForGameButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("2Asked " + player + " for a game!");
                }
            });

            hBox.getChildren().addAll(playerName, playerScore, playerStatus, statusImageView, askForGameButton);
            playersListView.getItems().add(hBox);
        }
    }

    private void refreshPlayersList() throws Exception {
        ClientSocket clientSocket = ClientSocket.getInstance();
        clientSocket.connectClient();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(types.type, types.UpdateList);
        jsonObject.put(types.Username, LoginScreenBase.getUserName());
        jsonObject.put(types.Password, LoginScreenBase.getPassword());
        ClientSocket.sendToServer(jsonObject.toString(),0);
        System.out.println(clientSocket.getMesage());
        ArrayList<UserRecord> userArrayList = getUsers(clientSocket.getMesage());
        populateList(userArrayList);
    }

    public ArrayList<UserRecord> getUsers(String message){

        String jsonString = message;
        ArrayList<UserRecord> userRecords = new ArrayList<>();

        // Parse the JSON string
        System.out.println("patttt  ---- >"+message);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("List");

        // Iterate over the JSON array and create UserRecord objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonRecord = jsonArray.getJSONObject(i);
            int pscore = jsonRecord.getInt("pscore");
            String username = jsonRecord.getString("Username");
            int state = jsonRecord.getInt("State");
            UserRecord userRecord = new UserRecord(pscore, username, state);
            userRecords.add(userRecord);
        }
        System.out.println(userRecords.size());
        return userRecords;
    }
}
