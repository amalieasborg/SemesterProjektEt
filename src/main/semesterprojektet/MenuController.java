package src.main.semesterprojektet;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class MenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToOpretBruger(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OpretBruger.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOpretØnskeseddel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OpretØnskeseddel.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSeØnskeseddel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SeØnskeseddel.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
