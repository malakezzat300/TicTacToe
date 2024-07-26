package sample;

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

public abstract class RequestPromptBase extends AnchorPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final ImageView backButton;

    public RequestPromptBase(Stage stage) {

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

        imageView.setFitHeight(1509.0);
        imageView.setFitWidth(1942.0);
        imageView.setLayoutX(-24.0);
        imageView.setLayoutY(-13.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("wp8984753.jpg").toExternalForm()));

        borderPane.setLayoutX(534.0);
        borderPane.setLayoutY(388.0);
        borderPane.setOpacity(0.6);
        borderPane.setPrefHeight(304.0);
        borderPane.setPrefWidth(827.0);
        borderPane.setStyle("-fx-background-color: WHITE; ");

        label.setLayoutX(749.0);
        label.setLayoutY(479.0);
        label.setPrefHeight(87.0);
        label.setPrefWidth(422.0);
        label.setText("Player X invited you to join a game ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#101046"));
        label.setFont(new Font("Jura Light", 26.0));

        button.setGraphicTextGap(8.0);
        button.setLayoutX(693.0);
        button.setLayoutY(619.0);
        button.setOnAction(this::onAccepted);
        button.setPrefHeight(46.0);
        button.setPrefWidth(171.0);
        button.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button.setText("Accept");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Jura Light", 18.0));

        button0.setGraphicTextGap(8.0);
        button0.setLayoutX(1030.0);
        button0.setLayoutY(620.0);
        button0.setOnAction(this::onRejected);
        button0.setPrefHeight(46.0);
        button0.setPrefWidth(171.0);
        button0.setStyle("-fx-background-color: #2c2c3c; -fx-background-radius: 8; -fx-opacity: 0.9;");
        button0.setText("Reject");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("Jura Light", 18.0));

        backButton.setFitHeight(150.0);
        backButton.setFitWidth(150.0);
        backButton.setLayoutX(1619.0);
        backButton.setLayoutY(63.0);
        backButton.setOnMouseClicked(this::onAccepted);
        backButton.setPickOnBounds(true);
        backButton.setPreserveRatio(true);
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

        getChildren().add(imageView);
        getChildren().add(borderPane);
        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(backButton);

    }

    protected abstract void onAccepted(javafx.event.ActionEvent actionEvent);

    protected abstract void onRejected(javafx.event.ActionEvent actionEvent);

    protected abstract void onAccepted(javafx.scene.input.MouseEvent mouseEvent);

}
