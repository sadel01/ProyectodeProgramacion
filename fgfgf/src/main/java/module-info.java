module codigo.fgfgf {
    requires javafx.controls;
    requires javafx.fxml;


    opens codigo.fgfgf to javafx.fxml;
    exports codigo.fgfgf;
}