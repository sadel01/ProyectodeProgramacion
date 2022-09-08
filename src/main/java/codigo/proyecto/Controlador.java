package codigo.proyecto;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

public class Controlador extends Dibujo{

    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField CuadroTexto;

    @FXML
    void obtenerLetra(MouseEvent event) {
        //String palabra = CuadroTexto.getText();
        String palabra = "rrr";

        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                Selector(palabra.charAt(i),Det(palabra,i),root);
            }
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

        Line l1 = new Line(x, y, x, y+60);
        Line l2 = new Line(x, y, x+60, y);
        Line l3 = new Line(x+60, y, x+60, y+60);
        Line l4 = new Line(x+60, y+60, x, y+60);

        l1.setFill(Color.TRANSPARENT);
        l1.setStroke(Color.BLUE);
        l1.setStrokeWidth(2);

        l2.setFill(Color.TRANSPARENT);
        l2.setStroke(Color.BLUE);
        l2.setStrokeWidth(2);

        l3.setFill(Color.TRANSPARENT);
        l3.setStroke(Color.BLUE);
        l3.setStrokeWidth(2);

        l4.setFill(Color.TRANSPARENT);
        l4.setStroke(Color.BLUE);
        l4.setStrokeWidth(2);

        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        x=x+60;
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



}
