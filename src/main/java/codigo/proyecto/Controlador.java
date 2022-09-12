package codigo.proyecto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
    private void obtenerLetra(MouseEvent event) {
        String palabra = CuadroTexto.getText();

        for (int i = 0; i < palabra.length(); i++) {
            //cuadrado();
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                Selector(palabra.charAt(i), root);
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

    void cuadrado() {

        Line l1 = new Line(x, y, x, y+50);
        Line l2 = new Line(x, y, x+60, y);
        Line l3 = new Line(x+60, y, x+60, y+50);
        Line l4 = new Line(x+60, y+50, x, y+50);

        l1.setFill(Color.TRANSPARENT);
        l1.setStroke(Color.BLUE);
        l1.setStrokeWidth(3);

        l2.setFill(Color.TRANSPARENT);
        l2.setStroke(Color.BLUE);
        l2.setStrokeWidth(3);

        l3.setFill(Color.TRANSPARENT);
        l3.setStroke(Color.BLUE);
        l3.setStrokeWidth(3);

        l4.setFill(Color.TRANSPARENT);
        l4.setStroke(Color.BLUE);
        l4.setStrokeWidth(3);

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
    }

    @FXML
    private void BorrarPalabra(MouseEvent event) {
        root.getChildren().clear();
        CuadroTexto.clear();
        x = 50;
        y = 250;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> {SelectorColor(Colores.getValue()); ColorRectangulo();});
    }
}