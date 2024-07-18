package sample;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public abstract class sampleBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final BorderPane borderPane;
    protected final CustomButtonController button;
    protected final CustomLabelController label;

    public sampleBase() {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        borderPane = new BorderPane();
        button = new CustomButtonController();
        label = new CustomLabelController();


        setHgap(10);
        setVgap(10);


        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setText("Button");
        borderPane.setCenter(button);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("Label");
        borderPane.setTop(label);

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getChildren().add(borderPane);

    }
}
