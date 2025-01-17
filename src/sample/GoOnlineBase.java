package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.SignUpPage.SignUpBase;

import java.io.IOException;

public abstract class GoOnlineBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final CustomLabelController goOnlineText;
    protected final CustomButtonController signupButton;
    protected final CustomButtonController loginButton;
    protected final ImageView imageView;
    protected final ImageView backButton;

    public GoOnlineBase(Stage stage) {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        goOnlineText = new CustomLabelController();
        signupButton = new CustomButtonController();
        loginButton = new CustomButtonController();
        imageView = new ImageView();
        backButton = new BackButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(632.0);
        setPrefWidth(864.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(Double.MAX_VALUE);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPercentWidth(20);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(Double.MAX_VALUE);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(30);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPercentWidth(30);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(Double.MAX_VALUE);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPercentWidth(20);

        rowConstraints.setMinHeight(5.0);
        rowConstraints.setPrefHeight(5.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(imageView, 0);
        GridPane.setRowIndex(imageView, 0);
        GridPane.setColumnSpan(imageView, 2147483647);
        GridPane.setRowSpan(imageView,2147483647);
        imageView.setFitHeight(2000);
        imageView.setFitWidth(2000);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/tictactoebackground.jpg").toExternalForm()));


        GridPane.setColumnIndex(goOnlineText, 1);
        GridPane.setColumnSpan(goOnlineText, 2);
        GridPane.setHalignment(goOnlineText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(goOnlineText, 1);
        GridPane.setValignment(goOnlineText, javafx.geometry.VPos.CENTER);
        goOnlineText.setAlignment(javafx.geometry.Pos.CENTER);
        goOnlineText.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        goOnlineText.setText("Go Online");
        goOnlineText.setTextFill(Color.BLACK);
        goOnlineText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        goOnlineText.setFont(new Font(120));

        GridPane.setColumnIndex(signupButton, 1);
        GridPane.setHalignment(signupButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(signupButton, 2);
        GridPane.setValignment(signupButton, javafx.geometry.VPos.CENTER);
        signupButton.setMnemonicParsing(false);
        signupButton.setText("Sign up");
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new SignUpBase(stage);
                stage.setScene(new Scene(root, 900.0, 700));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);

            }
        });

        GridPane.setColumnIndex(loginButton, 2);
        GridPane.setHalignment(loginButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(loginButton, 2);
        GridPane.setValignment(loginButton, javafx.geometry.VPos.CENTER);
        loginButton.setMnemonicParsing(false);
        loginButton.setText("Log in");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new LoginScreenBase(stage) {};
                stage.setScene(new Scene(root, 900.0, 700));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);

            }
        });

        GridPane.setColumnIndex(backButton, 3);
        GridPane.setHalignment(backButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(backButton, javafx.geometry.VPos.CENTER);
        GridPane.setMargin(backButton, new Insets(0.0, 0.0, 0.0, 0));
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


        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getChildren().add(imageView);
        getChildren().add(goOnlineText);
        getChildren().add(signupButton);
        getChildren().add(loginButton);
        getChildren().add(backButton);

    }
}
