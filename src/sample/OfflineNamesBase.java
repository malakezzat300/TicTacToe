package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class OfflineNamesBase extends StackPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final CustomButtonController startButton;
    protected final TextField firstPlayerTextField;
    protected final TextField secondPlayerTextField;
    protected static String playerOne;
    protected static String playerTwo;
    protected static int mode;
    protected final static int SINGLE_MODE = 1;
    protected final static int OFFLINE_MODE = 2;
    protected final static int SINGLE_MODE_RECORDING = 3;
    protected final static int OFFLINE_MODE_RECORDING = 4;

    public OfflineNamesBase(Stage stage,int mode) {

        OfflineNamesBase.mode = mode;
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        startButton = new CustomButtonController();
        firstPlayerTextField = new TextField();
        secondPlayerTextField = new TextField();

        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(1080.0);
        gridPane.setPrefWidth(1920.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(Double.MAX_VALUE);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPercentWidth(40.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(Double.MAX_VALUE);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(20.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPercentWidth(40.0);

        rowConstraints.setMaxHeight(Double.MAX_VALUE);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(Double.MAX_VALUE);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPercentHeight(10.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(Double.MAX_VALUE);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPercentHeight(10.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(Double.MAX_VALUE);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPercentHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(Double.MAX_VALUE);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPercentHeight(10.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(Double.MAX_VALUE);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPercentHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(imageView, 0);
        GridPane.setRowIndex(imageView, 0);
        GridPane.setColumnSpan(imageView, 2147483647);
        GridPane.setRowSpan(imageView,2147483647);
        imageView.setFitHeight(2000);
        imageView.setFitWidth(2000);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../assets/tictactoebackground.jpg").toExternalForm()));

        GridPane.setColumnIndex(label, 1);
        GridPane.setValignment(label, javafx.geometry.VPos.BOTTOM);
        label.setText("Enter Two Names:");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(Color.BLACK);
        label.setFont(new Font(24.0));

        GridPane.setColumnIndex(label0, 1);
        GridPane.setRowIndex(label0, 1);
        GridPane.setValignment(label0, javafx.geometry.VPos.BOTTOM);
        label0.setText("Player 1");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(Color.BLACK);
        label0.setFont(new Font(18.0));

        GridPane.setColumnIndex(label1, 1);
        GridPane.setRowIndex(label1, 3);
        GridPane.setValignment(label1, javafx.geometry.VPos.BOTTOM);
        label1.setStyle("-fx-stroke: firebrick; -fx-stroke-width: 5;");
        label1.setText("Player 2");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(Color.BLACK);
        label1.setFont(new Font(18.0));

        GridPane.setColumnIndex(startButton, 1);
        GridPane.setHalignment(startButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(startButton, 5);
        GridPane.setValignment(startButton, javafx.geometry.VPos.TOP);
        startButton.setMnemonicParsing(false);
        startButton.setText("Start");
        startButton.setDefaultButton(true);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerOne = "Player1";
                playerTwo = "Player2";
                if(!firstPlayerTextField.getText().equals("")){
                    playerOne = firstPlayerTextField.getText();
                }
                if(!secondPlayerTextField.getText().equals("")){
                    playerTwo = secondPlayerTextField.getText();
                }
                if(mode == SINGLE_MODE){
                    playerTwo = "Computer";
                }

                /*
                do you want to record the game screen
                 */
                Parent recordParent = null;
                try {
                    recordParent = FXMLLoader.load(this.getClass().getResource("record.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert recordParent != null;
                Scene requestPageScene = new Scene(recordParent);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(requestPageScene);
                stage.show();
                stage.setFullScreen(true);




                //-----------------------------------
                /*
                Parent root = new GameScreenBase(stage,playerOne,playerTwo,mode) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setMaxHeight(3000);
                stage.setMaxWidth(3000);
                stage.setFullScreen(true);


                 */

            }
        });



        GridPane.setColumnIndex(firstPlayerTextField, 1);
        GridPane.setRowIndex(firstPlayerTextField, 2);
        GridPane.setValignment(firstPlayerTextField, javafx.geometry.VPos.TOP);
        firstPlayerTextField.setFont(new Font(18.0));

        GridPane.setColumnIndex(secondPlayerTextField, 1);
        GridPane.setRowIndex(secondPlayerTextField, 4);
        GridPane.setValignment(secondPlayerTextField, javafx.geometry.VPos.TOP);
        secondPlayerTextField.setFont(new Font(18.0));

        if(mode == 1){
            label1.setVisible(false);
            secondPlayerTextField.setVisible(false);
            label0.setText("Player");
            label.setText("Enter Your Name:");
        }

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(imageView);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(startButton);
        gridPane.getChildren().add(firstPlayerTextField);
        gridPane.getChildren().add(secondPlayerTextField);
        getChildren().add(gridPane);

    }

    public static String getPlayerOne(){
        return playerOne;
    }

    public static String getPlayerTwo(){
        return playerTwo;
    }

    public static int getMode(){
        return mode;
    }
}
