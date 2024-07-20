package sample.database;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public  class View extends AnchorPane {
   public static SimpleStringProperty stringProperty= new SimpleStringProperty();
    public static ObservableList<User> stringProperty2= FXCollections.observableArrayList();

    protected final Button SServerButton;
    protected final Button StoServerButton;
    protected final AnchorPane PlayerButton;
    protected final Circle circle;
    protected final Label label;
    protected final Label onlinelabe;
    protected final Circle circle0;
    protected final Label label0;
    protected final Label ingamelabel;
    protected final Circle circle1;
    protected final Label label1;
    protected final Label offlinelabe;
    protected final Button button;
    protected final ListView<User> users;

    public View(DAO dao) {
        setStyle("-fx-background-image: url('/sample/database/back.jpg'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        SServerButton = new Button();
        StoServerButton = new Button();
        PlayerButton = new AnchorPane();
        circle = new Circle();
        label = new Label();
        onlinelabe = new Label();
        circle0 = new Circle();
        label0 = new Label();
        ingamelabel = new Label();
        circle1 = new Circle();
        label1 = new Label();
        offlinelabe = new Label();
        button = new Button();
        users = new ListView<User>();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);

        AnchorPane.setRightAnchor(SServerButton, 26.0);
        AnchorPane.setTopAnchor(SServerButton, 414.0);
        SServerButton.setLayoutX(334.0);
        SServerButton.setLayoutY(414.0);
        SServerButton.setMaxHeight(USE_PREF_SIZE);
        SServerButton.setMaxWidth(USE_PREF_SIZE);
        SServerButton.setMinHeight(USE_PREF_SIZE);
        SServerButton.setMinWidth(USE_PREF_SIZE);
        SServerButton.setMnemonicParsing(false);
        SServerButton.setPrefHeight(90.0);
        SServerButton.setPrefWidth(440.0);
        SServerButton.setStyle("-fx-background-radius: 25; -fx-border-radius: 25; -fx-background-color: green;");
        SServerButton.setText("Start");
        SServerButton.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        SServerButton.setFont(new Font(27.0));

        AnchorPane.setRightAnchor(StoServerButton, 26.0);
        AnchorPane.setTopAnchor(StoServerButton, 240.0);
        StoServerButton.setLayoutX(334.0);
        StoServerButton.setLayoutY(240.0);
        StoServerButton.setMnemonicParsing(false);
        StoServerButton.setPrefHeight(90.0);
        StoServerButton.setPrefWidth(440.0);
        StoServerButton.setStyle("-fx-background-radius: 25; -fx-border-radius: 25; -fx-border-width: 0; -fx-background-color: red;");
        StoServerButton.setText("Stop");
        StoServerButton.setFont(new Font(27.0));

        AnchorPane.setBottomAnchor(PlayerButton, 400.0);
        AnchorPane.setLeftAnchor(PlayerButton, 11.0);
        AnchorPane.setRightAnchor(PlayerButton, 580.0);
        AnchorPane.setTopAnchor(PlayerButton, 19.0);
        PlayerButton.setLayoutX(45.0);
        PlayerButton.setLayoutY(19.0);
        PlayerButton.setPrefHeight(121.0);
        PlayerButton.setPrefWidth(211.0);

        circle.setFill(javafx.scene.paint.Color.valueOf("#1fff7c"));
        circle.setLayoutX(34.0);
        circle.setLayoutY(22.0);
        circle.setRadius(8.0);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        label.setLayoutX(60.0);
        label.setLayoutY(13.0);
        label.setText("online");

        onlinelabe.setLayoutX(113.0);
        onlinelabe.setLayoutY(14.0);
        onlinelabe.setText("0");

        circle0.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle0.setLayoutX(34.0);
        circle0.setLayoutY(58.0);
        circle0.setRadius(8.0);
        circle0.setStroke(javafx.scene.paint.Color.BLACK);
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        label0.setLayoutX(55.0);
        label0.setLayoutY(49.0);
        label0.setText("in game");

        ingamelabel.setLayoutX(113.0);
        ingamelabel.setLayoutY(49.0);
        ingamelabel.setText("0");

        circle1.setFill(javafx.scene.paint.Color.valueOf("#ff1f1f"));
        circle1.setLayoutX(34.0);
        circle1.setLayoutY(92.0);
        circle1.setRadius(8.0);
        circle1.setStroke(javafx.scene.paint.Color.BLACK);
        circle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        label1.setLayoutX(59.0);
        label1.setLayoutY(86.0);
        label1.setText("offline");

        offlinelabe.setLayoutX(113.0);
        offlinelabe.setLayoutY(83.0);
        offlinelabe.setText("0");

        AnchorPane.setRightAnchor(button, 26.0);
        AnchorPane.setTopAnchor(button, 75.0);
        button.setLayoutX(334.0);
        button.setLayoutY(75.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(90.0);
        button.setPrefWidth(440.0);
        button.setStyle("-fx-background-radius: 25; -fx-border-radius: 25; -fx-background-color: cyan;");
        button.setText("Score");
        button.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        button.setFont(new Font(27.0));

        AnchorPane.setBottomAnchor(users, 1.0);
        AnchorPane.setLeftAnchor(users, 11.0);
        AnchorPane.setTopAnchor(users, 140.0);
        users.setLayoutX(14.0);
        users.setLayoutY(140.0);
        users.setPrefHeight(90);
        users.setPrefWidth(350);
        StoServerButton.setDisable(true);
        getChildren().add(SServerButton);
        getChildren().add(StoServerButton);
        PlayerButton.getChildren().add(circle);
        PlayerButton.getChildren().add(label);
        PlayerButton.getChildren().add(onlinelabe);
        PlayerButton.getChildren().add(circle0);
        PlayerButton.getChildren().add(label0);
        PlayerButton.getChildren().add(ingamelabel);
        PlayerButton.getChildren().add(circle1);
        PlayerButton.getChildren().add(label1);
        PlayerButton.getChildren().add(offlinelabe);
        getChildren().add(PlayerButton);
        getChildren().add(button);
        getChildren().add(users);
        SServerButton.setOnAction(e->{
            stringProperty.addListener(ee->{offlinelabe.setText(stringProperty.getValue());});
            stringProperty.setValue(dao.numberofpalyers().toString());
            StoServerButton.setDisable(false);
            SServerButton.setDisable(true);
            try {
                dao.getallsuers();
                users.setItems(stringProperty2);
                users.setCellFactory(ez->new ListItem());
            } catch (Exception exception) {
                exception.printStackTrace();
            }


        });
        StoServerButton.setOnAction(e->{
            stringProperty.setValue("0");
            stringProperty2.clear();
            users.setItems(stringProperty2);
            stringProperty.removeListener(ee->{offlinelabe.setText(stringProperty.getValue());});
            StoServerButton.setDisable(true);
            SServerButton.setDisable(false);

        });
    }
}

