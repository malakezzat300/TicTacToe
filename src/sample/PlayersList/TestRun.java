package sample.PlayersList;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.RecordGame.ReadRecordedGame;
import sample.RecordGame.RecordLists;

public class TestRun extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // make an object of readRecordedGame and pass the list with fileName;
        ReadRecordedGame readFile = new ReadRecordedGame();
        Parent root = new PlayersList(primaryStage);
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
