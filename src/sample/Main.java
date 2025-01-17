package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.NetworkPackge.ClientSocket;
import sample.NetworkPackge.Network;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new StartScreenBase(primaryStage) {};
        primaryStage.setTitle("Tic Tac Toe");

        primaryStage.setScene(new Scene(root,800, 800));
        primaryStage.setOnCloseRequest(e->{
            if (ClientSocket.getInstance()!=null)
                ClientSocket.getInstance().closeConnections();
        });
        primaryStage.show();
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(800);
        primaryStage.setFullScreen(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
