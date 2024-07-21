package sample.database;

import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

 class ListItem extends ListCell<User> {
    HBox box;
    TextField name;
    TextField email;
    Rectangle rectangle;

    ListItem() {
        box = new HBox();
        name = new TextField();
        email = new TextField();
        name.setDisable(true);
        email.setDisable(true);
        rectangle = new Rectangle(20, 20);
        rectangle.setFill(Color.RED);
    }

    @Override
    protected void updateItem(User item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            box.getChildren().clear();
            setText(null);
            setGraphic(null);
        } else {
            if (item.name.isEmpty() && item.email.isEmpty()) {
                name.setText("name");
                email.setText("email");
                name.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                email.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                rectangle.setFill(Color.RED);
            } else {
                name.setText(item.name);
                email.setText(item.email);
                name.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                email.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

                if (item.Status) {
                    rectangle.setFill(Color.GREEN);
                } else {
                    rectangle.setFill(Color.RED);
                }
            }

            box.getChildren().setAll(name, email, rectangle);
            setGraphic(box);
        }
    }
}
