package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public abstract class start_screenBaseTest extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final ImageView imageView;
    protected final Label ticTacToeText;
    protected final Button singleModeButton;
    protected final Button multiplayerOfflineButton;
    protected final Button multiplayerOnlineButton;
    protected final Button recordsButton;
    protected final Button exitButton;
    protected final ImageView settingsButton;

    public start_screenBaseTest() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        imageView = new ImageView();
        ticTacToeText = new Label();
        singleModeButton = new Button();
        multiplayerOfflineButton = new Button();
        multiplayerOnlineButton = new Button();
        recordsButton = new Button();
        exitButton = new Button();
        settingsButton = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(Double.MAX_VALUE);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPercentWidth(20.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(Double.MAX_VALUE);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(60.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPercentWidth(20.0);

        rowConstraints.setMaxHeight(44.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(5.0);
        rowConstraints.setPrefHeight(23.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(Double.MAX_VALUE);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPercentHeight(15.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(Double.MAX_VALUE);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPercentHeight(15.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(Double.MAX_VALUE);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPercentHeight(15.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(Double.MAX_VALUE);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPercentHeight(15.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(Double.MAX_VALUE);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPercentHeight(15.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(Double.MAX_VALUE);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPercentHeight(15.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(1.0);
        rowConstraints6.setPercentHeight(5.0);
        rowConstraints6.setPrefHeight(1.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(imageView, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(imageView, javafx.geometry.VPos.TOP);
        imageView.setFitHeight(2000.0);
        imageView.setFitWidth(2000.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../assets/tictactoebackground.jpg").toExternalForm()));

        GridPane.setColumnIndex(ticTacToeText, 1);
        GridPane.setHalignment(ticTacToeText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(ticTacToeText, 1);
        GridPane.setValignment(ticTacToeText, javafx.geometry.VPos.CENTER);
        ticTacToeText.setAlignment(javafx.geometry.Pos.CENTER);
        ticTacToeText.setText("Tic Tac Toe");
        ticTacToeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(singleModeButton, 1);
        GridPane.setHalignment(singleModeButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(singleModeButton, 2);
        GridPane.setValignment(singleModeButton, javafx.geometry.VPos.CENTER);
        singleModeButton.setMnemonicParsing(false);
        singleModeButton.setText("Single Mode");

        GridPane.setColumnIndex(multiplayerOfflineButton, 1);
        GridPane.setHalignment(multiplayerOfflineButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(multiplayerOfflineButton, 3);
        GridPane.setValignment(multiplayerOfflineButton, javafx.geometry.VPos.CENTER);
        multiplayerOfflineButton.setMnemonicParsing(false);
        multiplayerOfflineButton.setText("Multi-player offline");

        GridPane.setColumnIndex(multiplayerOnlineButton, 1);
        GridPane.setHalignment(multiplayerOnlineButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(multiplayerOnlineButton, 4);
        GridPane.setValignment(multiplayerOnlineButton, javafx.geometry.VPos.CENTER);
        multiplayerOnlineButton.setMnemonicParsing(false);
        multiplayerOnlineButton.setText("Multi-player online");

        GridPane.setColumnIndex(recordsButton, 1);
        GridPane.setHalignment(recordsButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(recordsButton, 5);
        GridPane.setValignment(recordsButton, javafx.geometry.VPos.CENTER);
        recordsButton.setMnemonicParsing(false);
        recordsButton.setText("Records");

        GridPane.setColumnIndex(exitButton, 1);
        GridPane.setHalignment(exitButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(exitButton, 6);
        GridPane.setValignment(exitButton, javafx.geometry.VPos.CENTER);
        exitButton.setMnemonicParsing(false);
        exitButton.setText("Exit");

        GridPane.setColumnIndex(settingsButton, 2);
        GridPane.setHalignment(settingsButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(settingsButton, 1);
        GridPane.setValignment(settingsButton, javafx.geometry.VPos.CENTER);
        settingsButton.setFitHeight(120.0);
        settingsButton.setFitWidth(120.0);
        settingsButton.setPickOnBounds(true);
        settingsButton.setPreserveRatio(true);
        settingsButton.setImage(new Image(getClass().getResource("assets/settings.png").toExternalForm()));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getRowConstraints().add(rowConstraints6);
        getChildren().add(imageView);
        getChildren().add(ticTacToeText);
        getChildren().add(singleModeButton);
        getChildren().add(multiplayerOfflineButton);
        getChildren().add(multiplayerOnlineButton);
        getChildren().add(recordsButton);
        getChildren().add(exitButton);
        getChildren().add(settingsButton);

    }
}
