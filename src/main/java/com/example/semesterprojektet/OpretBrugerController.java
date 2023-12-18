package com.example.semesterprojektet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class OpretBrugerController {
    @FXML
    private TextField Brugernavn;
    @FXML
    private TextField Email;

    @FXML
    private PasswordField passwordHidden;
    @FXML
    private TextField passwordText;
    @FXML
    private CheckBox checkBox;

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
    public void visKodeord(ActionEvent event){
        if (checkBox.isSelected()){
            passwordText.setText(passwordHidden.getText());
            passwordText.setVisible(true);
            passwordHidden.setVisible(false);
            return;
        }
        passwordHidden.setText(passwordText.getText());
        passwordHidden.setVisible(true);
        passwordText.setVisible(false);
    }
    @FXML
    public void tilfoejBruger(ActionEvent event){
        Bruger b = new Bruger ();
        String navn = Brugernavn.getText();
        String kodeord = passwordHidden.getText();
        String email = Email.getText();
        b.setBrugernavn(navn);
        b.setKodeord(kodeord);
        b.setEmail(email);
        DbSql db = new DbSql();
        db.opretBruger(b);

    }
}
