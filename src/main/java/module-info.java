module com.example.semesterprojektet {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens src.main.semesterprojektet to javafx.fxml;
    exports src.main.semesterprojektet;
}