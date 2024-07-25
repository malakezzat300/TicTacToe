package sample.RecordGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestRun  extends Application {

    List<String> records = new ArrayList<String>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        records.add("ahmed");
        records.add("lolo");
        records.add("medo");
        Parent root = new RecordLists(records);
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);

        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
