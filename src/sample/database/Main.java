package sample.database;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
  public  static   DAO dao;

    static {
        try {
            dao = new DAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

   public static MainServer s;

    @Override
    public void start(Stage primaryStage) throws Exception{
        s= new MainServer();

        Parent root = new View(dao);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
