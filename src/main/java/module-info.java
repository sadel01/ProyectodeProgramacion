module codigo.proyectoprogramacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens codigo.proyectoprogramacion to javafx.fxml;
    exports codigo.proyectoprogramacion;
}