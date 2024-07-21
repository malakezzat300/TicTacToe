package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class GameScreenBase extends GridPane {

    protected ColumnConstraints columnConstraints;
    protected ColumnConstraints columnConstraints0;
    protected ColumnConstraints columnConstraints1;
    protected ColumnConstraints columnConstraints2;
    protected ColumnConstraints columnConstraints3;
    protected ColumnConstraints columnConstraints4;
    protected ColumnConstraints columnConstraints5;
    protected ColumnConstraints columnConstraints6;
    protected RowConstraints rowConstraints;
    protected RowConstraints rowConstraints0;
    protected RowConstraints rowConstraints1;
    protected RowConstraints rowConstraints2;
    protected RowConstraints rowConstraints3;
    protected ImageView backgroundImageView;
    protected GridPane gridPane;
    protected ColumnConstraints columnConstraints7;
    protected ColumnConstraints columnConstraints8;
    protected ColumnConstraints columnConstraints9;
    protected RowConstraints rowConstraints4;
    protected RowConstraints rowConstraints5;
    protected RowConstraints rowConstraints6;
    protected Rectangle rectangle;
    protected Rectangle rectangle0;
    protected Rectangle rectangle1;
    protected Rectangle rectangle2;
    protected Rectangle rectangle3;
    protected Rectangle rectangle4;
    protected Rectangle rectangle5;
    protected Rectangle rectangle6;
    protected Rectangle rectangle7;
    protected ImageView zeroXzeroButton;
    protected ImageView zeroXoneButton;
    protected ImageView zeroXtwoButton;
    protected ImageView oneXzeroButton;
    protected ImageView oneXoneButton;
    protected ImageView oneXtwoButton;
    protected ImageView twoXzeroButton;
    protected ImageView twoXoneButton;
    protected ImageView twoXtwoButton;
    protected CustomButtonController withdrawButton;
    protected ImageView recordButton;
    protected CustomLabelController playerText;
    protected CustomLabelController playerTurnText;
    protected Line winLine;
    protected final static String XPATH = "../assets/x.png";
    protected final static String OPATH = "../assets/o.png";
    protected static int turnNumber = 0;
    protected char[][] matrix= new char[3][3];
    protected String playerOne;
    protected String playerTwo;
    protected Media sound;
    protected MediaPlayer mediaPlayer;
    protected ArrayList<ImageView> boardButtons;


    public GameScreenBase(Stage stage, String playerOne, String playerTwo,int mode) {


        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
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
        gridPane = new GridPane();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        rectangle3 = new Rectangle();
        rectangle4 = new Rectangle();
        rectangle5 = new Rectangle();
        rectangle6 = new Rectangle();
        rectangle7 = new Rectangle();
        zeroXzeroButton = new ImageView();
        zeroXoneButton = new ImageView();
        zeroXtwoButton = new ImageView();
        oneXzeroButton = new ImageView();
        oneXoneButton = new ImageView();
        oneXtwoButton = new ImageView();
        twoXzeroButton = new ImageView();
        twoXoneButton = new ImageView();
        twoXtwoButton = new ImageView();
        withdrawButton = new CustomButtonController();
        recordButton = new ImageView();
        playerText = new CustomLabelController();
        playerTurnText = new CustomLabelController();
        winLine = new Line();
        boardButtons = new ArrayList<>();

        boardButtons.add(zeroXzeroButton);
        boardButtons.add(zeroXoneButton);
        boardButtons.add(zeroXtwoButton);
        boardButtons.add(oneXzeroButton);
        boardButtons.add(oneXoneButton);
        boardButtons.add(oneXtwoButton);
        boardButtons.add(twoXzeroButton);
        boardButtons.add(twoXoneButton);
        boardButtons.add(twoXtwoButton);

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

        GridPane.setColumnIndex(gridPane, 2);
        GridPane.setColumnSpan(gridPane, 3);
        GridPane.setHalignment(gridPane, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(gridPane, 1);
        GridPane.setRowSpan(gridPane, 3);
        GridPane.setValignment(gridPane, javafx.geometry.VPos.CENTER);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);

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

        GridPane.setHalignment(rectangle, javafx.geometry.HPos.RIGHT);
        GridPane.setHgrow(rectangle, javafx.scene.layout.Priority.ALWAYS);
        GridPane.setValignment(rectangle, javafx.geometry.VPos.BOTTOM);
        GridPane.setVgrow(rectangle, javafx.scene.layout.Priority.ALWAYS);
        rectangle.setArcHeight(30.0);
        rectangle.setArcWidth(30.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(200.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeWidth(6.0);
        rectangle.setWidth(210.0);

        GridPane.setHalignment(rectangle0, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(rectangle0, 1);
        GridPane.setValignment(rectangle0, javafx.geometry.VPos.CENTER);
        rectangle0.setArcHeight(30.0);
        rectangle0.setArcWidth(30.0);
        rectangle0.setFill(javafx.scene.paint.Color.WHITE);
        rectangle0.setHeight(200.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeWidth(6.0);
        rectangle0.setWidth(210.0);

        GridPane.setHalignment(rectangle1, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(rectangle1, 2);
        GridPane.setValignment(rectangle1, javafx.geometry.VPos.TOP);
        rectangle1.setArcHeight(30.0);
        rectangle1.setArcWidth(30.0);
        rectangle1.setFill(javafx.scene.paint.Color.WHITE);
        rectangle1.setHeight(200.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeWidth(6.0);
        rectangle1.setWidth(210.0);

        GridPane.setColumnIndex(rectangle2, 1);
        GridPane.setHalignment(rectangle2, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(rectangle2, javafx.geometry.VPos.BOTTOM);
        rectangle2.setArcHeight(30.0);
        rectangle2.setArcWidth(30.0);
        rectangle2.setFill(javafx.scene.paint.Color.WHITE);
        rectangle2.setHeight(200.0);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeWidth(6.0);
        rectangle2.setWidth(210.0);

        GridPane.setColumnIndex(rectangle3, 1);
        GridPane.setHalignment(rectangle3, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(rectangle3, 1);
        GridPane.setValignment(rectangle3, javafx.geometry.VPos.CENTER);
        rectangle3.setArcHeight(30.0);
        rectangle3.setArcWidth(30.0);
        rectangle3.setFill(javafx.scene.paint.Color.WHITE);
        rectangle3.setHeight(200.0);
        rectangle3.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle3.setStrokeWidth(6.0);
        rectangle3.setWidth(210.0);

        GridPane.setColumnIndex(rectangle4, 1);
        GridPane.setHalignment(rectangle4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(rectangle4, 2);
        GridPane.setValignment(rectangle4, javafx.geometry.VPos.TOP);
        rectangle4.setArcHeight(30.0);
        rectangle4.setArcWidth(30.0);
        rectangle4.setFill(javafx.scene.paint.Color.WHITE);
        rectangle4.setHeight(200.0);
        rectangle4.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle4.setStrokeWidth(6.0);
        rectangle4.setWidth(210.0);

        GridPane.setColumnIndex(rectangle5, 2);
        GridPane.setHalignment(rectangle5, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(rectangle5, javafx.geometry.VPos.BOTTOM);
        rectangle5.setArcHeight(30.0);
        rectangle5.setArcWidth(30.0);
        rectangle5.setFill(javafx.scene.paint.Color.WHITE);
        rectangle5.setHeight(200.0);
        rectangle5.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle5.setStrokeWidth(6.0);
        rectangle5.setWidth(210.0);

        GridPane.setColumnIndex(rectangle6, 2);
        GridPane.setHalignment(rectangle6, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(rectangle6, 1);
        GridPane.setValignment(rectangle6, javafx.geometry.VPos.CENTER);
        rectangle6.setArcHeight(30.0);
        rectangle6.setArcWidth(30.0);
        rectangle6.setFill(javafx.scene.paint.Color.WHITE);
        rectangle6.setHeight(200.0);
        rectangle6.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle6.setStrokeWidth(6.0);
        rectangle6.setWidth(210.0);

        GridPane.setColumnIndex(rectangle7, 2);
        GridPane.setHalignment(rectangle7, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(rectangle7, 2);
        GridPane.setValignment(rectangle7, javafx.geometry.VPos.TOP);
        rectangle7.setArcHeight(30.0);
        rectangle7.setArcWidth(30.0);
        rectangle7.setFill(javafx.scene.paint.Color.WHITE);
        rectangle7.setHeight(200.0);
        rectangle7.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle7.setStrokeWidth(6.0);
        rectangle7.setWidth(210.0);

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

        GridPane.setHalignment(zeroXzeroButton, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(zeroXzeroButton, javafx.geometry.VPos.BOTTOM);
        zeroXzeroButton.setFitHeight(150.0);
        zeroXzeroButton.setFitWidth(150.0);
        zeroXzeroButton.setPickOnBounds(true);
        zeroXzeroButton.setPreserveRatio(true);
        zeroXzeroButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    zeroXzeroButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[0][0] = putXorO.charAt(10);
                    zeroXzeroButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(zeroXzeroButton, new Insets(0.0, 30.0, 30.0, 0.0));

        GridPane.setHalignment(zeroXoneButton, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(zeroXoneButton, 1);
        GridPane.setValignment(zeroXoneButton, javafx.geometry.VPos.CENTER);
        zeroXoneButton.setFitHeight(150.0);
        zeroXoneButton.setFitWidth(150.0);
        zeroXoneButton.setPickOnBounds(true);
        zeroXoneButton.setPreserveRatio(true);
        zeroXoneButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    zeroXoneButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[0][1] = putXorO.charAt(10);
                    zeroXoneButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(zeroXoneButton, new Insets(0.0, 30.0, 0.0, 0.0));

        GridPane.setHalignment(zeroXtwoButton, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(zeroXtwoButton, 2);
        GridPane.setValignment(zeroXtwoButton, javafx.geometry.VPos.TOP);
        zeroXtwoButton.setFitHeight(150.0);
        zeroXtwoButton.setFitWidth(150.0);
        zeroXtwoButton.setPickOnBounds(true);
        zeroXtwoButton.setPreserveRatio(true);
        zeroXtwoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    zeroXtwoButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[0][2] = putXorO.charAt(10);
                    zeroXtwoButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });

        GridPane.setMargin(zeroXtwoButton, new Insets(30.0, 30.0, 0.0, 0.0));

        GridPane.setColumnIndex(oneXzeroButton, 1);
        GridPane.setHalignment(oneXzeroButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(oneXzeroButton, javafx.geometry.VPos.BOTTOM);
        oneXzeroButton.setFitHeight(150.0);
        oneXzeroButton.setFitWidth(150.0);
        oneXzeroButton.setPickOnBounds(true);
        oneXzeroButton.setPreserveRatio(true);
        oneXzeroButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    oneXzeroButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[1][0] = putXorO.charAt(10);
                    oneXzeroButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(oneXzeroButton, new Insets(0.0, 0.0, 30.0, 0.0));

        GridPane.setColumnIndex(oneXoneButton, 1);
        GridPane.setHalignment(oneXoneButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(oneXoneButton, 1);
        GridPane.setValignment(oneXoneButton, javafx.geometry.VPos.CENTER);
        oneXoneButton.setFitHeight(150.0);
        oneXoneButton.setFitWidth(150.0);
        oneXoneButton.setPickOnBounds(true);
        oneXoneButton.setPreserveRatio(true);
        oneXoneButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    oneXoneButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[1][1] = putXorO.charAt(10);
                    oneXoneButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });

        GridPane.setColumnIndex(oneXtwoButton, 1);
        GridPane.setHalignment(oneXtwoButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(oneXtwoButton, 2);
        GridPane.setValignment(oneXtwoButton, javafx.geometry.VPos.TOP);
        oneXtwoButton.setFitHeight(150.0);
        oneXtwoButton.setFitWidth(150.0);
        oneXtwoButton.setPickOnBounds(true);
        oneXtwoButton.setPreserveRatio(true);
        oneXtwoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    oneXtwoButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[1][2] = putXorO.charAt(10);
                    oneXtwoButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(oneXtwoButton, new Insets(30.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(twoXzeroButton, 2);
        GridPane.setHalignment(twoXzeroButton, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(twoXzeroButton, javafx.geometry.VPos.BOTTOM);
        twoXzeroButton.setFitHeight(150.0);
        twoXzeroButton.setFitWidth(150.0);
        twoXzeroButton.setPickOnBounds(true);
        twoXzeroButton.setPreserveRatio(true);
        twoXzeroButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    twoXzeroButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[2][0] = putXorO.charAt(10);
                    twoXzeroButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(twoXzeroButton, new Insets(0.0, 0.0, 30.0, 30.0));

        GridPane.setColumnIndex(twoXoneButton, 2);
        GridPane.setHalignment(twoXoneButton, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(twoXoneButton, 1);
        GridPane.setValignment(twoXoneButton, javafx.geometry.VPos.CENTER);
        twoXoneButton.setFitHeight(150.0);
        twoXoneButton.setFitWidth(150.0);
        twoXoneButton.setPickOnBounds(true);
        twoXoneButton.setPreserveRatio(true);
        twoXoneButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    twoXoneButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[2][1] = putXorO.charAt(10);
                    twoXoneButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(twoXoneButton, new Insets(0.0, 0.0, 0.0, 30.0));

        GridPane.setColumnIndex(twoXtwoButton, 2);
        GridPane.setHalignment(twoXtwoButton, javafx.geometry.HPos.LEFT);
        GridPane.setRowIndex(twoXtwoButton, 2);
        GridPane.setValignment(twoXtwoButton, javafx.geometry.VPos.TOP);
        twoXtwoButton.setFitHeight(150.0);
        twoXtwoButton.setFitWidth(150.0);
        twoXtwoButton.setPickOnBounds(true);
        twoXtwoButton.setPreserveRatio(true);
        twoXtwoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(MouseEvent.MOUSE_CLICKED == event.getEventType()){
                    String putXorO = putXorO();
                    twoXtwoButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
                    matrix[2][2] = putXorO.charAt(10);
                    twoXtwoButton.setDisable(true);
                    if(isWinState()){
                        doWinEvent();
                    } else if(isDrawState()){
                        doDrawEvent();
                    } else {
                        if (mode == 1 && isComputerTurn()) {
                            makeComputerPlay();
                        }
                    }
                }
            }
        });
        GridPane.setMargin(twoXtwoButton, new Insets(30.0, 0.0, 0.0, 30.0));

        GridPane.setColumnIndex(withdrawButton, 6);
        GridPane.setHalignment(withdrawButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(withdrawButton, 4);
        GridPane.setValignment(withdrawButton, javafx.geometry.VPos.CENTER);
        withdrawButton.setMnemonicParsing(false);
        withdrawButton.setPrefHeight(31.0);
        withdrawButton.setPrefWidth(200);
        withdrawButton.setText("withdraw");
        withdrawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new StartScreenBase(stage) {};
                stage.setScene(new Scene(root,800, 800));
                stage.show();
                stage.setMinHeight(800);
                stage.setMinWidth(800);
                stage.setFullScreen(true);
            }
        });
        GridPane.setMargin(withdrawButton, new Insets(0.0));

        GridPane.setColumnIndex(recordButton, 1);
        GridPane.setHalignment(recordButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(recordButton, javafx.geometry.VPos.CENTER);
        recordButton.setFitHeight(120.0);
        recordButton.setFitWidth(120.0);
        recordButton.setPickOnBounds(true);
        recordButton.setPreserveRatio(true);
        recordButton.setImage(new Image(getClass().getResource("../assets/play.png").toExternalForm()));
        GridPane.setMargin(recordButton, new Insets(20.0, 0.0, 0.0, 20.0));

        GridPane.setColumnIndex(playerTurnText, 3);
        GridPane.setHalignment(playerTurnText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(playerTurnText, 0);
        GridPane.setValignment(playerTurnText, javafx.geometry.VPos.CENTER);
        playerTurnText.setText(playerOne + " Turn ( X )");
        playerTurnText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerTurnText.setTextFill(Color.BLACK);
        playerTurnText.setFont(new Font(30.0));

        GridPane.setColumnIndex(playerText, 6);
        GridPane.setHalignment(playerText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(playerText, 2);
        GridPane.setValignment(playerText, javafx.geometry.VPos.CENTER);
        playerText.setText(playerOne + "\n" + "VS" + "\n" + playerTwo);
        playerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerText.setTextFill(Color.BLACK);
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
        gridPane.getColumnConstraints().add(columnConstraints7);
        gridPane.getColumnConstraints().add(columnConstraints8);
        gridPane.getColumnConstraints().add(columnConstraints9);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getRowConstraints().add(rowConstraints6);
        gridPane.getChildren().add(rectangle);
        gridPane.getChildren().add(rectangle0);
        gridPane.getChildren().add(rectangle1);
        gridPane.getChildren().add(rectangle2);
        gridPane.getChildren().add(rectangle3);
        gridPane.getChildren().add(rectangle4);
        gridPane.getChildren().add(rectangle5);
        gridPane.getChildren().add(rectangle6);
        gridPane.getChildren().add(rectangle7);
        gridPane.getChildren().add(zeroXzeroButton);
        gridPane.getChildren().add(zeroXoneButton);
        gridPane.getChildren().add(zeroXtwoButton);
        gridPane.getChildren().add(oneXzeroButton);
        gridPane.getChildren().add(oneXoneButton);
        gridPane.getChildren().add(oneXtwoButton);
        gridPane.getChildren().add(twoXzeroButton);
        gridPane.getChildren().add(twoXoneButton);
        gridPane.getChildren().add(twoXtwoButton);
        gridPane.getChildren().add(winLine);
        getChildren().add(gridPane);
        getChildren().add(withdrawButton);
        getChildren().add(recordButton);
        getChildren().add(playerText);
        getChildren().add(playerTurnText);

    }


    public void makeWinLine(int winCase){
        winLine.setVisible(true);
        switch (winCase){
            case 1:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 0);
                winLine.setEndX(480.0);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            case 2:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(480.0);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            case 3:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 2);
                winLine.setEndX(480.0);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            case 4:
                GridPane.setColumnIndex(winLine, 0);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(380);
                winLine.setRotate(90);
                GridPane.setMargin(winLine, new Insets(0,0,0,180));
                break;
            case 5:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(380);
                winLine.setRotate(90);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            case 6:
                GridPane.setColumnIndex(winLine, 2);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(380);
                winLine.setRotate(90);
                GridPane.setMargin(winLine, new Insets(0,180,0,0));
                break;
            case 7:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(650);
                winLine.setRotate(38);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            case 8:
                GridPane.setColumnIndex(winLine, 1);
                GridPane.setRowIndex(winLine, 1);
                winLine.setEndX(650);
                winLine.setRotate(142);
                GridPane.setMargin(winLine, new Insets(0.0));
                break;
            default:
                break;


        }

    }

    public boolean isWinState(){
        if(matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0] && (matrix[2][0] == 'x' ||  matrix[2][0] == 'o')){
            return true;
        } else if(matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1] && (matrix[2][1] == 'x' ||  matrix[2][1] == 'o')){
            return true;
        } else if(matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return true;
        } else if(matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && (matrix[0][2] == 'x' ||  matrix[0][2] == 'o')){
            return true;
        } else if(matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && (matrix[1][2] == 'x' ||  matrix[1][2] == 'o')){
            return true;
        } else if(matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return true;
        } else if(matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return true;
        } else if(matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && (matrix[2][0] == 'x' ||  matrix[2][0] == 'o')){
            return true;
        } else {
            return false;
        }
    }

    public int getWinState(){
        if(matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0] && (matrix[2][0] == 'x' ||  matrix[2][0] == 'o')){
            return 1;
        } else if(matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1] && (matrix[2][1] == 'x' ||  matrix[2][1] == 'o')){
            return 2;
        } else if(matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return 3;
        } else if(matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && (matrix[0][2] == 'x' ||  matrix[0][2] == 'o')){
            return 4;
        } else if(matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && (matrix[1][2] == 'x' ||  matrix[1][2] == 'o')){
            return 5;
        } else if(matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return 6;
        } else if(matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && (matrix[2][2] == 'x' ||  matrix[2][2] == 'o')){
            return 7;
        } else if(matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && (matrix[2][0] == 'x' ||  matrix[2][0] == 'o')){
            return 8;
        } else {
            return 0;
        }
    }

    public String putXorO(){
        if(turnNumber % 2 == 0){
            //makeXSound();
            ++turnNumber;
            playerTurnText.setText(playerTwo + " Turn ( O )");
            return XPATH;
        } else {
            //makeOSound();
            ++turnNumber;
            playerTurnText.setText(playerOne + " Turn ( X )");
            return OPATH;
        }
    }

    public String getWinner(){
        if(turnNumber % 2 == 0){
            return playerTwo;
        } else {

            return playerOne;
        }
    }

    public void doWinEvent(){
        makeWinLine(getWinState());
        disableAllButtons();
        playerTurnText.setText("The Winner is " + getWinner());
    }

    public void disableAllButtons(){
        zeroXzeroButton.setDisable(true);
        zeroXoneButton.setDisable(true);
        zeroXtwoButton.setDisable(true);
        oneXzeroButton.setDisable(true);
        oneXoneButton.setDisable(true);
        oneXtwoButton.setDisable(true);
        twoXzeroButton.setDisable(true);
        twoXoneButton.setDisable(true);
        twoXtwoButton.setDisable(true);
        withdrawButton.setDisable(true);
        recordButton.setDisable(true);
    }

    public boolean isDrawState(){
        if(zeroXzeroButton.isDisabled() &&
        zeroXoneButton.isDisabled() &&
        zeroXtwoButton.isDisabled() &&
        oneXzeroButton.isDisabled() &&
        oneXoneButton.isDisabled() &&
        oneXtwoButton.isDisabled() &&
        twoXzeroButton.isDisabled() &&
        twoXoneButton.isDisabled() &&
        twoXtwoButton.isDisabled() &&
        !isWinState()){
            return true;
        } else {
            return false;
        }
    }

    public void doDrawEvent(){
        withdrawButton.setDisable(true);
        playerTurnText.setText("The Match is Draw!");
    }

    public boolean isComputerTurn(){
        if(turnNumber % 2 != 0){
            return true;
        } else {
            return false;
        }
    }

    public int getXFromImageView(ImageView imageView){
        if (imageView.equals(zeroXzeroButton) || imageView.equals(zeroXoneButton) || imageView.equals(zeroXtwoButton)) {
            return 0;
        } else if (imageView.equals(oneXzeroButton) || imageView.equals(oneXoneButton) || imageView.equals(oneXtwoButton) ) {
            return 1;
        } else if (imageView.equals(twoXzeroButton) || imageView.equals(twoXoneButton) || imageView.equals(twoXtwoButton) ) {
            return 2;
        } else {
            return -1;
        }
    }

    public int getYFromImageView(ImageView imageView){
        if (imageView.equals(zeroXzeroButton) || imageView.equals(oneXzeroButton) || imageView.equals(twoXzeroButton)) {
            return 0;
        } else if (imageView.equals(zeroXoneButton) || imageView.equals(oneXoneButton) || imageView.equals(twoXoneButton) ) {
            return 1;
        } else if (imageView.equals(zeroXtwoButton) || imageView.equals(oneXtwoButton) || imageView.equals(twoXtwoButton) ) {
            return 2;
        } else {
            return -1;
        }
    }

    public void makeComputerPlay(){
        Random random = new Random();
        int randomInt = random.nextInt(9);
        ImageView boradButton = boardButtons.get(randomInt);
        if(boradButton.isDisabled()){
            makeComputerPlay();
        } else {
            String putXorO = putXorO();
            boradButton.setImage(new Image(getClass().getResource(putXorO).toExternalForm()));
            matrix[getXFromImageView(boradButton)][getYFromImageView(boradButton)] = putXorO.charAt(10);
            if(isWinState()){
                doWinEvent();
            }
            boradButton.setDisable(true);
        }
        if(isWinState()){
            doWinEvent();
        } else if(isDrawState()){
            doDrawEvent();
        }
    }

    /*
    public void makeOSound(){
        sound = new Media(Objects.requireNonNull(getClass().getResource("sounds/osound.mp3")).toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void makeXSound(){
        sound = new Media(Objects.requireNonNull(getClass().getResource("sounds/xsound.mp3")).toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
     */

}
