package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class SettingsScreenBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final ImageView backgroundImageView;
    protected final Rectangle rectangle;
    protected final Label settingsLabel;
    protected final Label musicLabel;
    protected final Label soundsLabel;
    protected final StackPane musicSwitch;
    protected final StackPane soundsSwitch;
    protected final ImageView backButton;

    public SettingsScreenBase(Stage stage) {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        backgroundImageView = new ImageView();
        rectangle = new Rectangle();
        settingsLabel = new Label();
        musicLabel = new Label();
        soundsLabel = new Label();
        musicSwitch = new SwitchButton();
        soundsSwitch = new SwitchButton();
        backButton = new BackButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPercentWidth(30.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(20.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPercentWidth(20.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPercentWidth(30.0);
        columnConstraints2.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(20.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPercentHeight(20.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPercentHeight(20.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPercentHeight(20.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPercentHeight(20.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPercentHeight(20.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(backgroundImageView, 2);
        GridPane.setRowSpan(backgroundImageView, 2);
        backgroundImageView.setFitHeight(1600.0);
        backgroundImageView.setFitWidth(1950.0);
        backgroundImageView.setPickOnBounds(true);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setImage(new Image(getClass().getResource("BackGround.jpg").toExternalForm()));

        GridPane.setColumnIndex(rectangle, 1);
        GridPane.setColumnSpan(rectangle, 2);
        GridPane.setHalignment(rectangle, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(rectangle, 2);
        GridPane.setRowSpan(rectangle, 2);
        GridPane.setValignment(rectangle, javafx.geometry.VPos.CENTER);
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(600.0);
        rectangle.setOpacity(0.6);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(800.0);

        GridPane.setHalignment(settingsLabel, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(settingsLabel, javafx.geometry.VPos.CENTER);
        settingsLabel.setText("Settings");
        settingsLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        settingsLabel.setFont(new Font(64.0));

        GridPane.setColumnIndex(musicLabel, 1);
        GridPane.setHalignment(musicLabel, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(musicLabel, 2);
        GridPane.setValignment(musicLabel, javafx.geometry.VPos.CENTER);
        musicLabel.setText("Music");
        musicLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        musicLabel.setFont(new Font(36.0));

        GridPane.setColumnIndex(soundsLabel, 1);
        GridPane.setHalignment(soundsLabel, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(soundsLabel, 3);
        GridPane.setValignment(soundsLabel, javafx.geometry.VPos.CENTER);
        soundsLabel.setText("Sounds");
        soundsLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        soundsLabel.setFont(new Font(36.0));

        GridPane.setColumnIndex(musicSwitch, 2);
        GridPane.setHalignment(musicSwitch, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(musicSwitch, 2);
        GridPane.setValignment(musicSwitch, javafx.geometry.VPos.CENTER);
        musicSwitch.setPrefHeight(100);
        musicSwitch.setPrefWidth(100);
        musicSwitch.setMaxSize(200,200);


        GridPane.setColumnIndex(soundsSwitch, 2);
        GridPane.setHalignment(soundsSwitch, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(soundsSwitch, 3);
        GridPane.setValignment(soundsSwitch, javafx.geometry.VPos.CENTER);
        soundsSwitch.setPrefHeight(100);
        soundsSwitch.setPrefWidth(100);
        soundsSwitch.setMaxSize(200,200);

        GridPane.setColumnIndex(backButton, 3);
        GridPane.setHalignment(backButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(backButton, javafx.geometry.VPos.CENTER);
        GridPane.setMargin(backButton, new Insets(30, 0.0, 0.0, 0));
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
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getChildren().add(backgroundImageView);
        getChildren().add(rectangle);
        getChildren().add(settingsLabel);
        getChildren().add(musicLabel);
        getChildren().add(soundsLabel);
        getChildren().add(musicSwitch);
        getChildren().add(soundsSwitch);
        getChildren().add(backButton);

    }
}
