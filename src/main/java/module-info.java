module com.example.semesterprojektet {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.semesterprojektet to javafx.fxml;
    exports com.example.semesterprojektet;
}