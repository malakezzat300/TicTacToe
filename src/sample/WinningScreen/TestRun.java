package sample.WinningScreen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestRun  extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = new WinningScreen(primaryStage);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene); // put the Scene
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}
