package com.example.semesterprojektet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
public class OpretØnskeseddelController {
    @FXML
    private TextField BrugerId;
    @FXML
    private TextField OenskelisteNr;
    @FXML
    private TextField Navn;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void opretOenskeseddel(ActionEvent event){
        Oenskeseddel o = new Oenskeseddel ();
        int brugerId = Integer.parseInt(BrugerId.getText());
        int oenskelisteNr = Integer.parseInt(OenskelisteNr.getText());
        String navn = Navn.getText();
        o.setId(brugerId);
        o.setOenskelistenr(oenskelisteNr);
        o.setNavn(navn);
        DbSql db = new DbSql();
        db.opretOenskeseddel(o);
    }
}
