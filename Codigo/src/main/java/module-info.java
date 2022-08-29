module com.example.codigo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codigo to javafx.fxml;
    exports com.example.codigo;
}