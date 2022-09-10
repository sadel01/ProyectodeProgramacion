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
        String palabra = CuadroTexto.getText();

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

    @FXML
    void BorrarPalabra(MouseEvent event) {
        root.getChildren().clear();
        CuadroTexto.clear();
        x = 50;
        y = 250;
    }

    void cuadrado() {

        Line la= new Line(x, y, x, y+50);
        Line lb = new Line(x, y, x+60, y);
        Line lc = new Line(x+60, y, x+60, y+50);
        Line ld = new Line(x+60, y+50, x, y+50);

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
}