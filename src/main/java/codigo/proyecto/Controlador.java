package codigo.proyecto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.util.ResourceBundle;

public class Controlador extends Dibujo implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField CuadroTexto;

    @FXML
    private ChoiceBox<String> Colores;

    @FXML
    private Rectangle rectColor;

    @FXML
    private TextFlow textoCoord;

    @FXML
    private ToggleButton puntosDeControl;

    @FXML
    private void obtenerLetra(MouseEvent event) {
        String palabra = ' '+CuadroTexto.getText();
        textoCoord.setStyle("-fx-font-size: 15px; -fx-padding: 5 0 0 5; -fx-font-weight: bold; -fx-font-family: Arial");
        for (int i = 1; i < palabra.length(); i++) {
            //cuadrado();
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                Selector(palabra.charAt(i),palabra.charAt(i-1), root, textoCoord, puntosDeControl);
                puntosDeControl.setDisable(false);
            }
        }
    }
    
    private void ColorRectangulo(){
        if(Colores.getValue().equals("Rojo")){
            rectColor.setFill(Color.RED);
            rectColor.setStroke(Color.RED);
        }else if(Colores.getValue().equals("Verde")){
            rectColor.setFill(Color.GREEN);
            rectColor.setStroke(Color.GREEN);
        }else if(Colores.getValue().equals("Azul")){
            rectColor.setFill(Color.BLUE);
            rectColor.setStroke(Color.BLUE);
        }else if(Colores.getValue().equals("Negro")){
            rectColor.setFill(Color.BLACK);
            rectColor.setStroke(Color.BLACK);
        }else if(Colores.getValue().equals("Gris")){
            rectColor.setFill(Color.GREY);
            rectColor.setStroke(Color.GREY);
        }else if(Colores.getValue().equals("Naranjo")){
            rectColor.setFill(Color.ORANGE);
            rectColor.setStroke(Color.ORANGE);
        }else if(Colores.getValue().equals("Violeta")){
            rectColor.setFill(Color.VIOLET);
            rectColor.setStroke(Color.VIOLET);
        }else if(Colores.getValue().equals("Morado")){
            rectColor.setFill(Color.PURPLE);
            rectColor.setStroke(Color.PURPLE);
        }else if(Colores.getValue().equals("Celeste")){
            rectColor.setFill(Color.SKYBLUE);
            rectColor.setStroke(Color.SKYBLUE);
        }else if(Colores.getValue().equals("Rosado")){
            rectColor.setFill(Color.PINK);
            rectColor.setStroke(Color.PINK);
        }
    }


    @FXML
    private void BorrarPalabra(MouseEvent event) {
        root.getChildren().clear();
        CuadroTexto.clear();
        textoCoord.getChildren().clear();
        puntosDeControl.setDisable(true);
        puntosDeControl.setText("Mostrar puntos de control");
        x = 50;
        y = 250;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family: Arial");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> {SelectorColor(Colores.getValue()); ColorRectangulo();});
        puntosDeControl.setDisable(true);
        puntosDeControl.setCursor(Cursor.HAND);
        puntosDeControl.setOnAction(actionEvent -> BotonAct(puntosDeControl));
    }
}