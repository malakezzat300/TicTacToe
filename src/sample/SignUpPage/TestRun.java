package sample.SignUpPage;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestRun extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = new SignUpBase();
        primaryStage.setTitle("Sign Up Page");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}