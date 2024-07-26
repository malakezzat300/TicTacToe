package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.RecordGame.RecordLists;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class StartScreenBase extends GridPane {

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
    protected final CustomLabelController ticTacToeText;
    protected final CustomButtonController singleModeButton;
    protected final CustomButtonController multiplayerOfflineButton;
    protected final CustomButtonController multiplayerOnlineButton;
    protected final CustomButtonController recordsButton;
    protected final CustomButtonController exitButton;
    protected final ImageView imageView;
    protected final static int SINGLE_MODE = 1;
    protected final static int OFFLINE_MODE = 2;
    protected final static int SINGLE_MODE_RECORDING = 3;
    protected final static int OFFLINE_MODE_RECORDING = 4;
    protected final static String recordsPath = "C:\\TicTacToe\\Records\\";
    protected final ImageView settingsButton;

    public StartScreenBase(Stage stage) {

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
        ticTacToeText = new CustomLabelController();
        singleModeButton = new CustomButtonController();
        multiplayerOfflineButton = new CustomButtonController();
        multiplayerOnlineButton = new CustomButtonController();
        recordsButton = new CustomButtonController();
        exitButton = new CustomButtonController();
        imageView = new ImageView();
        settingsButton = new ImageView();

        setMinHeight(800.0);
        setMinWidth(800.0);
        setPrefHeight(654.0);
        setPrefWidth(937.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(Double.MAX_VALUE);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPercentWidth(20);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(Double.MAX_VALUE);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(60);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPercentWidth(20);

        rowConstraints.setMaxHeight(44.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(23.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(Double.MAX_VALUE);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(Double.MAX_VALUE);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(Double.MAX_VALUE);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(Double.MAX_VALUE);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(Double.MAX_VALUE);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(Double.MAX_VALUE);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(1.0);
        rowConstraints6.setPercentHeight(6.0);
        rowConstraints6.setPrefHeight(1.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(ticTacToeText, 1);
        GridPane.setHalignment(ticTacToeText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(ticTacToeText, 1);
        GridPane.setValignment(ticTacToeText, javafx.geometry.VPos.CENTER);
        ticTacToeText.setAlignment(javafx.geometry.Pos.CENTER);
        ticTacToeText.setFont(Font.font(90));
        ticTacToeText.setText("Tic Tac Toe");
        ticTacToeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);


        GridPane.setColumnIndex(imageView, 0);
        GridPane.setRowIndex(imageView, 0);
        GridPane.setColumnSpan(imageView, 2147483647);
        GridPane.setRowSpan(imageView,2147483647);
        imageView.setFitHeight(2000);
        imageView.setFitWidth(2000);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../assets/tictactoebackground.jpg").toExternalForm()));

        GridPane.setColumnIndex(singleModeButton, 1);
        GridPane.setHalignment(singleModeButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(singleModeButton, 2);
        GridPane.setValignment(singleModeButton, javafx.geometry.VPos.CENTER);
        singleModeButton.setMnemonicParsing(false);
        singleModeButton.setMinWidth(600);
        singleModeButton.setText("Single Mode");
        singleModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new OfflineNamesBase(stage,SINGLE_MODE) {};
                stage.setScene(new Scene(root,200, 200));
                stage.show();
                stage.setMinHeight(600);
                stage.setMinWidth(600);
                stage.setFullScreen(true);

            }
        });

        GridPane.setColumnIndex(multiplayerOfflineButton, 1);
        GridPane.setHalignment(multiplayerOfflineButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(multiplayerOfflineButton, 3);
        GridPane.setValignment(multiplayerOfflineButton, javafx.geometry.VPos.CENTER);
        multiplayerOfflineButton.setMnemonicParsing(false);
        multiplayerOfflineButton.setMinWidth(600);
        multiplayerOfflineButton.setText("Two-Players Mode");
        multiplayerOfflineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new OfflineNamesBase(stage,OFFLINE_MODE) {};
                stage.setScene(new Scene(root,600, 600));
                stage.show();
                stage.setMinHeight(600);
                stage.setMinWidth(600);
                stage.setFullScreen(true);

            }
        });

        GridPane.setColumnIndex(multiplayerOnlineButton, 1);
        GridPane.setHalignment(multiplayerOnlineButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(multiplayerOnlineButton, 4);
        GridPane.setValignment(multiplayerOnlineButton, javafx.geometry.VPos.CENTER);
        multiplayerOnlineButton.setMnemonicParsing(false);
        multiplayerOnlineButton.setMinWidth(600);
        multiplayerOnlineButton.setText("Multi-player Online");
        multiplayerOnlineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new GoOnlineBase(stage) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

        GridPane.setColumnIndex(recordsButton, 1);
        GridPane.setHalignment(recordsButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(recordsButton, 5);
        GridPane.setValignment(recordsButton, javafx.geometry.VPos.CENTER);
        recordsButton.setMnemonicParsing(false);
        recordsButton.setMinWidth(600);
        recordsButton.setText("Records");
        recordsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ArrayList<String> arrayList = getFiles();
                Parent root = new RecordLists(stage,arrayList) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

        GridPane.setColumnIndex(exitButton, 1);
        GridPane.setHalignment(exitButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(exitButton, 6);
        GridPane.setValignment(exitButton, javafx.geometry.VPos.CENTER);
        exitButton.setMnemonicParsing(false);
        exitButton.setMinWidth(600);
        exitButton.setText("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        GridPane.setColumnIndex(settingsButton, 2);
        GridPane.setHalignment(settingsButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(settingsButton, 1);
        GridPane.setValignment(settingsButton, javafx.geometry.VPos.CENTER);
        settingsButton.setFitHeight(120.0);
        settingsButton.setFitWidth(120.0);
        settingsButton.setPickOnBounds(true);
        settingsButton.setPreserveRatio(true);
        settingsButton.setImage(new Image(getClass().getResource("/assets/settings.png").toExternalForm()));
        settingsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root = new SettingsScreenBase(stage) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });

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


    public ArrayList<String> getFiles(){
        File directory = new File(recordsPath);
        File[] filesList = directory.listFiles();
        ArrayList<String> fileNames = new ArrayList<>();
        if (filesList != null) {
            List<File> files = new ArrayList<>();
            Collections.addAll(files, filesList);

            files.sort((file1, file2) -> Long.compare(file2.lastModified(), file1.lastModified()));

            for (File file : files) {
                if (file.isFile()) {
                    String nameOfRecord = file.getName().substring(0, file.getName().indexOf('.'));
                    fileNames.add(nameOfRecord);
                }
            }

        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
        return fileNames;
    }
}
