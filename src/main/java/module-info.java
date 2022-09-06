module codigo.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens codigo.proyecto to javafx.fxml;
    exports codigo.proyecto;
}