package com.example.codigo;

import Codigo.Vocales;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.awt.Graphics;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.io.IOException;

public class ControladorBase extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControladorBase.class.getResource("Interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Transformador");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private TextField barraDeTexto;

    @FXML
    private Pane ventanaMuestra;

    @FXML
    void AccionEscribirBarraDeTexto(KeyEvent event) {
        Vocales v = new Vocales("aoaoa");
    }

}