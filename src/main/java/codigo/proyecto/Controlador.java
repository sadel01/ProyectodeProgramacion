package codigo.proyecto;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.nio.channels.Selector;
import java.util.ResourceBundle;

public class Controlador extends Dibujo implements Initializable, EventHandler<KeyEvent> {

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
    private void obtenerLetra(KeyEvent event) {

        textoCoord.setStyle("-fx-font-size: 15px; -fx-padding: 5 0 0 5; -fx-font-weight: bold; -fx-font-family: Arial");
        String palabra = " " + CuadroTexto.getText();
        root.getChildren().clear();
        textoCoord.getChildren().clear();
        for(int i=0;i<palabra.length();i++){

            if(i==0){
                Selector(palabra.charAt(i),palabra.charAt(i),root, textoCoord, puntosDeControl,1);
            }
            else{
                Selector(palabra.charAt(i), palabra.charAt(i-1),root, textoCoord, puntosDeControl,0);
            }

            if (puntosDeControl.isSelected()){
                BotonAct(puntosDeControl);
            }

        }

        if (palabra.length() < 2){
            puntosDeControl.setDisable(true);
        }else{
            puntosDeControl.setDisable(false);
        }
    }


    private void ColorRectangulo() {

        if (Colores.getValue().equals("Rojo")) {
            rectColor.setFill(Color.RED);
            rectColor.setStroke(Color.RED);
        } else if (Colores.getValue().equals("Verde")) {
            rectColor.setFill(Color.GREEN);
            rectColor.setStroke(Color.GREEN);
        } else if (Colores.getValue().equals("Azul")) {
            rectColor.setFill(Color.BLUE);
            rectColor.setStroke(Color.BLUE);
        } else if (Colores.getValue().equals("Negro")) {
            rectColor.setFill(Color.BLACK);
            rectColor.setStroke(Color.BLACK);
        } else if (Colores.getValue().equals("Gris")) {
            rectColor.setFill(Color.GREY);
            rectColor.setStroke(Color.GREY);
        } else if (Colores.getValue().equals("Naranjo")) {
            rectColor.setFill(Color.ORANGE);
            rectColor.setStroke(Color.ORANGE);
        } else if (Colores.getValue().equals("Violeta")) {
            rectColor.setFill(Color.VIOLET);
            rectColor.setStroke(Color.VIOLET);
        } else if (Colores.getValue().equals("Morado")) {
            rectColor.setFill(Color.PURPLE);
            rectColor.setStroke(Color.PURPLE);
        } else if (Colores.getValue().equals("Celeste")) {
            rectColor.setFill(Color.SKYBLUE);
            rectColor.setStroke(Color.SKYBLUE);
        } else if (Colores.getValue().equals("Rosado")) {
            rectColor.setFill(Color.PINK);
            rectColor.setStroke(Color.PINK);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family: Arial");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> {
            SelectorColor(Colores.getValue());
            ColorRectangulo();
        });
        puntosDeControl.setDisable(true);
        puntosDeControl.setCursor(Cursor.HAND);
        puntosDeControl.setOnAction(actionEvent -> BotonAct(puntosDeControl));
    }


    @Override
    public void handle(KeyEvent keyEvent) {
        CuadroTexto.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("Hola");
                System.out.println(keyEvent.getCode());
            }
        });
    }
}