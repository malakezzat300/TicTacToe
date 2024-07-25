package sample.record;


import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class c extends AnchorPane  {

    protected final ListView mylist;

    public c() {

        mylist = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);

        this.setStyle("-fx-background-image: url('/assets/tictactoebackground.jpg'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        AnchorPane.setBottomAnchor(mylist, 50.0);
        AnchorPane.setLeftAnchor(mylist, 50.0);
        AnchorPane.setRightAnchor(mylist, 50.0);
        AnchorPane.setTopAnchor(mylist, 50.0);
        mylist.setLayoutX(57.0);
        mylist.setLayoutY(71.0);
        mylist.setMaxHeight(Double.MAX_VALUE);
        mylist.setMaxWidth(Double.MAX_VALUE);
        mylist.setPrefHeight(466.0);
        mylist.setPrefWidth(333.0);
        mylist.setCellFactory(e->new ListCell<String >(){
            HBox box;
            TextField name;
            ImageView image;
            Image myim;

             {
                box = new HBox();
                name = new TextField();
                name.setDisable(true);
                try {

                        image = new ImageView("sample/record/play1.png");
                        image.setFitHeight(30.0);
                        image.setFitWidth(30.0);

                }catch (Exception e){
                    //System.out.println(e.getMessage());
                }

             }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    box.getChildren().clear();
                    setText(null);
                    setGraphic(null);
                } else {
                    name.setText(item.isEmpty() ? "name" : item);
                    name.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                    box.getChildren().setAll(name, image);
                    HBox.setHgrow(name, Priority.ALWAYS);
                    name.setMaxWidth(Double.MAX_VALUE);
                    name.styleProperty().bind(
                            Bindings.concat("-fx-font-size: ",mylist.heightProperty().divide(25).asString(), "px;")
                    );

                    setGraphic(box);
                }
            }
        });
        ObservableList<String> strings= FXCollections.observableArrayList();
        strings.add("xxxxxxxx");
        mylist.setItems(strings);
        mylist.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        getChildren().add(mylist);

    }
}

