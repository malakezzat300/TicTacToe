package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class game_screenBasetest extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final ImageView backgroundImageView;
    protected final Rectangle rectangle;
    protected final GridPane childGridPane;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final ColumnConstraints columnConstraints9;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle rectangle3;
    protected final Rectangle rectangle4;
    protected final Rectangle rectangle5;
    protected final Rectangle rectangle6;
    protected final Rectangle rectangle7;
    protected final Rectangle rectangle8;
    protected final ImageView zeroXzeroButton;
    protected final ImageView zeroXoneButton;
    protected final ImageView zeroXtwoButton;
    protected final ImageView oneXzeroButton;
    protected final ImageView oneXoneButton;
    protected final ImageView oneXtwoButton;
    protected final ImageView twoXzeroButton;
    protected final ImageView twoXoneButton;
    protected final ImageView twoXtwoButton;
    protected final Line winLine;
    protected final Button withdrawButton;
    protected final ImageView recordButton;
    protected final Label playerText;

    public game_screenBasetest() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        backgroundImageView = new ImageView();
        rectangle = new Rectangle();
        childGridPane = new GridPane();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        rectangle3 = new Rectangle();
        rectangle4 = new Rectangle();
        rectangle5 = new Rectangle();
        rectangle6 = new Rectangle();
        rectangle7 = new Rectangle();
        rectangle8 = new Rectangle();
        zeroXzeroButton = new ImageView();
        zeroXoneButton = new ImageView();
        zeroXtwoButton = new ImageView();
        oneXzeroButton = new ImageView();
        oneXoneButton = new ImageView();
        oneXtwoButton = new ImageView();
        twoXzeroButton = new ImageView();
        twoXoneButton = new ImageView();
        twoXtwoButton = new ImageView();
        winLine = new Line();
        withdrawButton = new Button();
        recordButton = new ImageView();
        playerText = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1080.0);
        setPrefWidth(1920.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPercentWidth(15.0);
        columnConstraints0.setPrefWidth(146.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(160.0);
        columnConstraints1.setPercentWidth(20.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(165.0);
        columnConstraints2.setPercentWidth(20.0);
        columnConstraints2.setPrefWidth(153.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(160.0);
        columnConstraints3.setPercentWidth(20.0);
        columnConstraints3.setPrefWidth(168.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPercentWidth(5.0);
        columnConstraints4.setPrefWidth(134.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPercentWidth(15.0);
        columnConstraints5.setPrefWidth(186.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPercentWidth(5.0);
        columnConstraints6.setPrefWidth(116.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(14.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(15.0);
        rowConstraints0.setPercentHeight(24.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(160.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPercentHeight(24.0);
        rowConstraints1.setPrefHeight(114.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(163.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPercentHeight(24.0);
        rowConstraints2.setPrefHeight(162.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPercentHeight(14.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(backgroundImageView, 1);
        GridPane.setColumnSpan(backgroundImageView, 2147483647);
        GridPane.setHalignment(backgroundImageView, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(backgroundImageView, 1);
        GridPane.setRowSpan(backgroundImageView, 2147483647);
        GridPane.setValignment(backgroundImageView, javafx.geometry.VPos.CENTER);
        backgroundImageView.setFitHeight(1926.0);
        backgroundImageView.setFitWidth(1962.0);
        backgroundImageView.setPickOnBounds(true);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setImage(new Image(getClass().getResource("../assets/tictactoebackground.jpg").toExternalForm()));

        GridPane.setColumnIndex(rectangle, 1);
        GridPane.setRowIndex(rectangle, 2);
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(1200.0);
        rectangle.setOpacity(0.3);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(1600.0);
        GridPane.setMargin(rectangle, new Insets(0.0, 0.0, 0.0, 220.0));

        GridPane.setColumnIndex(childGridPane, 2);
        GridPane.setColumnSpan(childGridPane, 3);
        GridPane.setHalignment(childGridPane, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(childGridPane, 1);
        GridPane.setRowSpan(childGridPane, 3);
        GridPane.setValignment(childGridPane, javafx.geometry.VPos.CENTER);
        childGridPane.setAlignment(javafx.geometry.Pos.CENTER);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(Double.MAX_VALUE);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPercentWidth(33.33);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(Double.MAX_VALUE);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPercentWidth(33.33);

        columnConstraints9.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints9.setMaxWidth(Double.MAX_VALUE);
        columnConstraints9.setMinWidth(10.0);
        columnConstraints9.setPercentWidth(33.33);

        rowConstraints4.setMaxHeight(Double.MAX_VALUE);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPercentHeight(33.33);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(Double.MAX_VALUE);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPercentHeight(33.33);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(Double.MAX_VALUE);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPercentHeight(33.33);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(rectangle0, javafx.geometry.HPos.RIGHT);
        GridPane.setHgrow(rectangle0, javafx.scene.layout.Priority.ALWAYS);
        GridPane.setValignment(rectangle0, javafx.geometry.VPos.BOTTOM);
        GridPane.setVgrow(rectangle0, javafx.scene.layout.Priority.ALWAYS);
        rectangle0.setArcHeight(30.0);
        rectangle0.setArcWidth(30.0);
        rectangle0.setFill(javafx.scene.paint.Color.WHITE);
        rectangle0.setHeight(200.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeWidth(6.0);
        rectangle0.setWidth(210.0);

        GridPane.setHalignment(rectangle1, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(rectangle1, 1);
        GridPane.setValignment(rectangle1, javafx.geometry.VPos.CENTER);
        rectangle1.setArcHeight(30.0);
        rectangle1.setArcWidth(30.0);
        rectangle1.setFill(javafx.scene.paint.Color.WHITE);
        rectangle1.setHeight(200.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeWidth(6.0);
        rectangle1.setWidth(210.0);

        GridPane.setHalignment(rectangle2, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(rectangle2, 2);
        GridPane.setValignment(rectangle2, javafx.geometry.VPos.TOP);
        rectangle2.setArcHeight(30.0);
        rectangle2.setArcWidth(30.0);
        rectangle2.setFill(javafx.scene.paint.Color.WHITE);
        rectangle2.setHeight(200.0);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeWidth(6.0);
        rectangle2.setWidth(210.0);

        GridPane.setColumnIndex(rectangle3, 1);
        GridPane.setHalignment(rectangle3, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(rectangle3, javafx.geometry.VPos.BOTTOM);
        rectangle3.setArcHeight(30.0);
        rectangle3.setArcWidth(30.0);
        rectangle3.setFill(javafx.scene.paint.Color.WHITE);
        rectangle3.setHeight(200.0);
        rectangle3.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle3.setStrokeWidth(6.0);
        rectangle3.setWidth(210.0);

        GridPane.setColumnIndex(rectangle4, 1);
        GridPane.setHalignment(rectangle4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(rectangle4, 1);
        GridPane.setValignment(rectangle4, javafx.geometry.VPos.CENTER);
        rectangle4.setArcHeight(30.0);
        rectangle4.setArcWidth(30.0);
        rectangle4.setFill(javafx.scene.paint.Color.WHITE);
        rectangle4.setHeight(200.0);
        rectangle4.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle4.setStrokeWidth(6.0);
        rectangle4.setWidth(210.0);

        GridPane.setColumnIndex(rectangle5, 1);
        GridPane.setHalignment(rectangle5, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(rectangle5, 2);
        GridPane.setValignment(rectangle5, javafx.geometry.VPos.TOP);
        rectangle5.setArcHeight(30.0);
        rectangle5.setArcWidth(30.0);
        rectangle5.setFill(javafx.scene.paint.Color.WHITE);
        rectangle5.setHeight(200.0);
        rectangle5.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle5.setStrokeWidth(6.0);
        rectangle5.setWidth(210.0);

        GridPane.setColumnIndex(rectangle6, 2);
        GridPane.setHalignment(rectangle6, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(rectangle6, javafx.geometry.VPos.BOTTOM);
        rectangle6.setArcHeight(30.0);
        rectangle6.setArcWidth(30.0);
        rectangle6.setFill(javafx.scene.paint.Color.WHITE);
        rectangle6.setHeight(200.0);
        rectangle6.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle6.setStrokeWidth(6.0);
        rectangle6.setWidth(210.0);

        GridPane.setColumnIndex(rectangle7, 2);
        GridPane.setHalignment(rectangle7, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(rectangle7, 1);
        GridPane.setValignment(rectangle7, javafx.geometry.VPos.CENTER);
        rectangle7.setArcHeight(30.0);
        rectangle7.setArcWidth(30.0);
        rectangle7.setFill(javafx.scene.paint.Color.WHITE);
        rectangle7.setHeight(200.0);
        rectangle7.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle7.setStrokeWidth(6.0);
        rectangle7.setWidth(210.0);

        GridPane.setColumnIndex(rectangle8, 2);
        GridPane.setHalignment(rectangle8, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(rectangle8, 2);
        GridPane.setValignment(rectangle8, javafx.geometry.VPos.TOP);
        rectangle8.setArcHeight(30.0);
        rectangle8.setArcWidth(30.0);
        rectangle8.setFill(javafx.scene.paint.Color.WHITE);
        rectangle8.setHeight(200.0);
        rectangle8.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle8.setStrokeWidth(6.0);
        rectangle8.setWidth(210.0);

        GridPane.setHalignment(zeroXzeroButton, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(zeroXzeroButton, javafx.geometry.VPos.BOTTOM);
        zeroXzeroButton.setFitHeight(150.0);
        zeroXzeroButton.setFitWidth(150.0);
        zeroXzeroButton.setPickOnBounds(true);
        zeroXzeroButton.setPreserveRatio(true);
        GridPane.setMargin(zeroXzeroButton, new Insets(0.0, 30.0, 30.0, 0.0));

        GridPane.setHalignment(zeroXoneButton, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(zeroXoneButton, 1);
        GridPane.setValignment(zeroXoneButton, javafx.geometry.VPos.CENTER);
        zeroXoneButton.setFitHeight(150.0);
        zeroXoneButton.setFitWidth(150.0);
        zeroXoneButton.setPickOnBounds(true);
        zeroXoneButton.setPreserveRatio(true);
        GridPane.setMargin(zeroXoneButton, new Insets(0.0, 30.0, 0.0, 0.0));

        GridPane.setHalignment(zeroXtwoButton, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(zeroXtwoButton, 2);
        GridPane.setValignment(zeroXtwoButton, javafx.geometry.VPos.TOP);
        zeroXtwoButton.setFitHeight(150.0);
        zeroXtwoButton.setFitWidth(150.0);
        zeroXtwoButton.setPickOnBounds(true);
        zeroXtwoButton.setPreserveRatio(true);
        GridPane.setMargin(zeroXtwoButton, new Insets(30.0, 30.0, 0.0, 0.0));

        GridPane.setColumnIndex(oneXzeroButton, 1);
        GridPane.setHalignment(oneXzeroButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(oneXzeroButton, javafx.geometry.VPos.BOTTOM);
        oneXzeroButton.setFitHeight(150.0);
        oneXzeroButton.setFitWidth(150.0);
        oneXzeroButton.setPickOnBounds(true);
        oneXzeroButton.setPreserveRatio(true);
        GridPane.setMargin(oneXzeroButton, new Insets(0.0, 0.0, 30.0, 0.0));

        GridPane.setColumnIndex(oneXoneButton, 1);
        GridPane.setHalignment(oneXoneButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(oneXoneButton, 1);
        GridPane.setValignment(oneXoneButton, javafx.geometry.VPos.CENTER);
        oneXoneButton.setFitHeight(150.0);
        oneXoneButton.setFitWidth(150.0);
        oneXoneButton.setPickOnBounds(true);
        oneXoneButton.setPreserveRatio(true);

        GridPane.setColumnIndex(oneXtwoButton, 1);
        GridPane.setHalignment(oneXtwoButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(oneXtwoButton, 2);
        GridPane.setValignment(oneXtwoButton, javafx.geometry.VPos.TOP);
        oneXtwoButton.setFitHeight(150.0);
        oneXtwoButton.setFitWidth(150.0);
        oneXtwoButton.setPickOnBounds(true);
        oneXtwoButton.setPreserveRatio(true);
        GridPane.setMargin(oneXtwoButton, new Insets(30.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(twoXzeroButton, 2);
        GridPane.setHalignment(twoXzeroButton, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(twoXzeroButton, javafx.geometry.VPos.BOTTOM);
        twoXzeroButton.setFitHeight(150.0);
        twoXzeroButton.setFitWidth(150.0);
        twoXzeroButton.setPickOnBounds(true);
        twoXzeroButton.setPreserveRatio(true);
        GridPane.setMargin(twoXzeroButton, new Insets(0.0, 0.0, 30.0, 30.0));

        GridPane.setColumnIndex(twoXoneButton, 2);
        GridPane.setHalignment(twoXoneButton, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(twoXoneButton, 1);
        GridPane.setValignment(twoXoneButton, javafx.geometry.VPos.CENTER);
        twoXoneButton.setFitHeight(150.0);
        twoXoneButton.setFitWidth(150.0);
        twoXoneButton.setPickOnBounds(true);
        twoXoneButton.setPreserveRatio(true);
        GridPane.setMargin(twoXoneButton, new Insets(0.0, 0.0, 0.0, 30.0));

        GridPane.setColumnIndex(twoXtwoButton, 2);
        GridPane.setHalignment(twoXtwoButton, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(twoXtwoButton, 2);
        GridPane.setValignment(twoXtwoButton, javafx.geometry.VPos.TOP);
        twoXtwoButton.setFitHeight(150.0);
        twoXtwoButton.setFitWidth(150.0);
        twoXtwoButton.setPickOnBounds(true);
        twoXtwoButton.setPreserveRatio(true);
        GridPane.setMargin(twoXtwoButton, new Insets(30.0, 0.0, 0.0, 30.0));

        GridPane.setColumnIndex(winLine, 1);
        GridPane.setHalignment(winLine, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(winLine, 1);
        GridPane.setValignment(winLine, javafx.geometry.VPos.CENTER);
        winLine.setEndX(480.0);
        winLine.setStartX(-100.0);
        winLine.setStroke(javafx.scene.paint.Color.valueOf("#f44336"));
        winLine.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        winLine.setStrokeWidth(12.0);
        winLine.setVisible(false);
        GridPane.setMargin(winLine, new Insets(0.0));

        GridPane.setColumnIndex(withdrawButton, 6);
        GridPane.setHalignment(withdrawButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(withdrawButton, 4);
        GridPane.setValignment(withdrawButton, javafx.geometry.VPos.CENTER);
        withdrawButton.setMnemonicParsing(false);
        withdrawButton.setPrefHeight(31.0);
        withdrawButton.setPrefWidth(83.0);
        withdrawButton.setText("Button");
        GridPane.setMargin(withdrawButton, new Insets(0.0));

        GridPane.setColumnIndex(recordButton, 1);
        GridPane.setHalignment(recordButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(recordButton, javafx.geometry.VPos.CENTER);
        recordButton.setFitHeight(120.0);
        recordButton.setFitWidth(120.0);
        recordButton.setPickOnBounds(true);
        recordButton.setPreserveRatio(true);
        recordButton.setImage(new Image(getClass().getResource("../assets/record.png").toExternalForm()));
        GridPane.setMargin(recordButton, new Insets(20.0, 0.0, 0.0, 20.0));

        GridPane.setColumnIndex(playerText, 6);
        GridPane.setHalignment(playerText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(playerText, 2);
        GridPane.setValignment(playerText, javafx.geometry.VPos.CENTER);
        playerText.setText("Label");
        playerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerText.setTextFill(javafx.scene.paint.Color.WHITE);
        playerText.setFont(new Font(24.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getColumnConstraints().add(columnConstraints4);
        getColumnConstraints().add(columnConstraints5);
        getColumnConstraints().add(columnConstraints6);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getChildren().add(backgroundImageView);
        getChildren().add(rectangle);
        childGridPane.getColumnConstraints().add(columnConstraints7);
        childGridPane.getColumnConstraints().add(columnConstraints8);
        childGridPane.getColumnConstraints().add(columnConstraints9);
        childGridPane.getRowConstraints().add(rowConstraints4);
        childGridPane.getRowConstraints().add(rowConstraints5);
        childGridPane.getRowConstraints().add(rowConstraints6);
        childGridPane.getChildren().add(rectangle0);
        childGridPane.getChildren().add(rectangle1);
        childGridPane.getChildren().add(rectangle2);
        childGridPane.getChildren().add(rectangle3);
        childGridPane.getChildren().add(rectangle4);
        childGridPane.getChildren().add(rectangle5);
        childGridPane.getChildren().add(rectangle6);
        childGridPane.getChildren().add(rectangle7);
        childGridPane.getChildren().add(rectangle8);
        childGridPane.getChildren().add(zeroXzeroButton);
        childGridPane.getChildren().add(zeroXoneButton);
        childGridPane.getChildren().add(zeroXtwoButton);
        childGridPane.getChildren().add(oneXzeroButton);
        childGridPane.getChildren().add(oneXoneButton);
        childGridPane.getChildren().add(oneXtwoButton);
        childGridPane.getChildren().add(twoXzeroButton);
        childGridPane.getChildren().add(twoXoneButton);
        childGridPane.getChildren().add(twoXtwoButton);
        childGridPane.getChildren().add(winLine);
        getChildren().add(childGridPane);
        getChildren().add(withdrawButton);
        getChildren().add(recordButton);
        getChildren().add(playerText);

    }
}
