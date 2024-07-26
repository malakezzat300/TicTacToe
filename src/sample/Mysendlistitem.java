package sample;


import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.database.User;

class ListItem2 extends ListCell<User> {
    HBox box;
    TextField name;
    Rectangle rectangle;
    ListItem2() {

        setStyle(" -fx-background-color: transparent;\n" +
                "    -fx-border-color: transparent ;-fx-font-size: 14 ;");
        box = new HBox();
        name = new TextField();
        name.setEditable(false);
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
                name.setText("name\n  ");
                name.setStyle(" -fx-background-color: transparent;-fx-text-fill: black; -fx-font-weight: bold;");
                rectangle.setFill(Color.RED);
            } else {
                name.setText(item.name);
                name.setStyle(" -fx-background-color: transparent;-fx-text-fill: black; -fx-font-weight: bold;");

                if (item.Status==1) {
                    rectangle.setFill(Color.GREEN);
                } else if (item.Status==0){
                    rectangle.setFill(Color.RED);
                }else
                    rectangle.setFill(Color.AQUA);
            }
            box.getChildren().setAll(name, rectangle);
            setGraphic(box);
        }
    }
}
