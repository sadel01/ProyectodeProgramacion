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
        //String palabra = "vr ror wrn";


        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                if(palabra.charAt(i) == 'a'){
                    LetraA(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='b'){
                    LetraB(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='c'){
                    LetraC(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='d'){
                    LetraD(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'e'){
                    LetraE(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='f'){
                    LetraF(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='g'){
                    LetraG(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='h'){
                    LetraH(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'i'){
                    LetraI(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='j'){
                    LetraJ(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'k'){
                    LetraK(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'l'){
                    LetraL(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'm'){
                    LetraM(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'n'){
                    LetraN(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'ñ'){
                    LetraN_(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'o'){
                    LetraO(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'p'){
                    LetraP(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'q'){
                    LetraQ(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='r'){
                    LetraR(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='s'){
                    LetraS(Det(palabra,i),root);
                }
                if(palabra.charAt(i)=='t'){
                    LetraT(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'u'){
                    LetraU(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'v'){
                    LetraV(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'w'){
                    LetraW(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'x'){
                    LetraX(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'y'){
                    LetraY(Det(palabra,i),root);
                }
                if(palabra.charAt(i) == 'z'){
                    LetraZ(Det(palabra,i),root);
                }
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

        Line l1 = new Line(x, y, x, y+110);
        Line l2 = new Line(x, y, x+120, y);
        Line l3 = new Line(x+120, y, x+120, y+110);
        Line l4 = new Line(x+120, y+110, x, y+110);

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
