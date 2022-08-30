module com.example.codigo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.codigo to javafx.fxml;
    opens Codigo to javafx.base, javafx.fxml;
    exports com.example.codigo;
    exports Codigo;
}