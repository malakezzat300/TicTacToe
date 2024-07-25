package sample.RecordGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestRun  extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = new RecordLists();
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
