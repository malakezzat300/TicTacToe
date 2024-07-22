package sample;



import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    public SceneController() {
    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToRquestPage(ActionEvent event) throws IOException {
        Parent requestPageParent = FXMLLoader.load(this.getClass().getResource("requestPrompt.fxml"));
        Scene requestPageScene = new Scene(requestPageParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(requestPageScene);
        stage.show();
        stage.setFullScreen(false);

    }

    public void switchToRecordPrompt(ActionEvent event) throws IOException {
        Parent recordParent = FXMLLoader.load(this.getClass().getResource("record.fxml"));
        Scene requestPageScene = new Scene(recordParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(requestPageScene);
        stage.show();
        stage.setFullScreen(false);
    }

    public void switchToGameBoard(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = new GameScreenBase(stage,"playerOne","playerTwo",3) {};
        stage.setScene(new Scene(root,800, 800));
        stage.show();
        stage.setMinHeight(800);
        stage.setMinWidth(800);
        stage.setMaxHeight(3000);
        stage.setMaxWidth(3000);
        stage.setFullScreen(true);
    }

    public void switchToPlayerListPage(ActionEvent event) throws IOException {
        Parent recordParent = FXMLLoader.load(this.getClass().getResource("PlayrList.fxml"));
        Scene requestPageScene = new Scene(recordParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(requestPageScene);
        stage.show();
        stage.setFullScreen(false);
    }


    /*
    public void switchToSigupPrompt(ActionEvent event) throws IOException {
        Parent recordParent = FXMLLoader.load(this.getClass().getResource("signup.fxml"));
        Scene requestPageScene = new Scene(recordParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(requestPageScene);
        stage.show();
        stage.setFullScreen(true);
    }*/

}
