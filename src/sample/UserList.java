package sample;

import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public abstract class UserList extends AnchorPane {

    protected final ListView players;

    public UserList() {
        players = new ListView();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        players.setLayoutX(163.0);
        players.setLayoutY(20.0);
        players.setPrefHeight(366.0);
        players.setPrefWidth(251.0);
        players.setStyle("-fx-border-color: transport; -fx-background-color: transport;");
        getChildren().add(players);

    }
}
