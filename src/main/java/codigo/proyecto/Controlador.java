package codigo.proyecto;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador extends Dibujo implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField CuadroTexto;

    @FXML
    private ChoiceBox<String> Colores;

    @FXML
    private Rectangle rectColor;

    @FXML
    void obtenerLetra(MouseEvent event) {
        String palabra = CuadroTexto.getText();
        //String palabra = "Hola";

        for (int i = 0; i < palabra.length(); i++) {
            //cuadrado();
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                //cuadrado();
                Selector(palabra.charAt(i),Det(palabra,i),root);
            }
        }
    }

    void ColorRectangulo(){
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
    void BorrarPalabra(MouseEvent event) {
        root.getChildren().clear();
        CuadroTexto.clear();
        x = 50;
        y = 250;
    }

    void cuadrado() {

        Line la= new Line(x, y-50, x, y+50);
        Line lb = new Line(x, y-50, x+80, y-50);
        Line lc = new Line(x+80, y-50, x+80, y+50);
        Line ld = new Line(x+80, y+50, x, y+50);

        la.setFill(Color.TRANSPARENT);
        la.setStroke(Color.BLUE);
        la.setStrokeWidth(grosor);

        lb.setFill(Color.TRANSPARENT);
        lb.setStroke(Color.BLUE);
        lb.setStrokeWidth(grosor);

        lc.setFill(Color.TRANSPARENT);
        lc.setStroke(Color.BLUE);
        lc.setStrokeWidth(grosor);

        ld.setFill(Color.TRANSPARENT);
        ld.setStroke(Color.BLUE);
        ld.setStrokeWidth(grosor);

        root.getChildren().add(la);
        root.getChildren().add(lb);
        root.getChildren().add(lc);
        root.getChildren().add(ld);
    }

    int Det(String palabra, int i){
        if(i>=1){
            if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'  ){
                return 1;// letra con una 'v','o' o 'w' antes
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> {SelectorColor(Colores.getValue()); ColorRectangulo();});
    }
}