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
    void obtenerLetra() {
        String palabra = CuadroTexto.getText();


        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i)==' '){
                x = x+85;
            }
            else{
                if(palabra.charAt(i) == 'a'){
                    if(i>=1){
                        if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'  ){
                            LetraA(1,root);//se hace la letra a sin la primera curva
                        }
                        else{
                            LetraA(0,root);// se hace la letra a con la curva
                        }
                    }
                    else{
                        LetraA(0,root);// se hace la letra a con la curva
                    }
                }
                if(palabra.charAt(i)=='b'){
                    LetraB(root);
                }
                if(palabra.charAt(i)=='c'){
                    LetraC(root);
                }
                if(palabra.charAt(i)=='d'){
                    LetraD(root);
                }
                if(palabra.charAt(i) == 'e'){
                    if(i >= 1){
                        if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'){
                            LetraE(1,root);
                        }
                        else{
                            LetraE(0,root);
                        }
                    }
                    else{
                        LetraE(0,root);
                    }
                }
                if(palabra.charAt(i)=='f'){
                    LetraF(root);
                }
                if(palabra.charAt(i)=='g'){
                    LetraG(root);
                }
                if(palabra.charAt(i)=='h'){
                    LetraH(root);
                }
                if(palabra.charAt(i) == 'i'){
                    if(i>=1){
                        if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'){
                            LetraI(1,root);
                        }
                        else{
                            LetraI(0,root);
                        }
                    }
                    else{
                        LetraI(0,root);
                    }
                }
                if(palabra.charAt(i)=='j'){
                    LetraJ(root);
                }
                if(palabra.charAt(i) == 'k'){
                    LetraK(root);
                }
                if(palabra.charAt(i) == 'l'){
                    LetraL(root);
                }
                if(palabra.charAt(i) == 'm'){
                    LetraM(root);
                }
                if(palabra.charAt(i) == 'n'){
                    LetraN(root);
                }
                if(palabra.charAt(i) == 'ñ'){
                    LetraN_(root);
                }
                if(palabra.charAt(i) == 'o'){
                    if(i>=1){
                        if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'){
                            LetraO(1,root);
                        }
                        else{
                            LetraO(0,root);
                        }

                    }
                    else{
                        LetraO(0,root);
                    }

                }
                if(palabra.charAt(i) == 'p'){
                    LetraP(root);
                }
                if(palabra.charAt(i) == 'q'){
                    LetraQ(root);
                }
                if(palabra.charAt(i)=='r'){
                    LetraR(root);
                }
                if(palabra.charAt(i)=='s'){
                    LetraS(root);
                }
                if(palabra.charAt(i)=='t'){
                    LetraT(root);
                }
                if(palabra.charAt(i) == 'u'){
                    if(i>=1){
                        if(palabra.charAt(i-1) == 'v' || palabra.charAt(i-1) == 'w' || palabra.charAt(i-1) == 'o'  ){
                            LetraU(1,root);//se hace la letra u sin la primera curva
                        }
                        else{
                            LetraU(0,root);// se hace la letra u con la curva
                        }
                    }
                    else{
                        LetraU(0,root);// se hace la letra u con la curva
                    }
                }
                if(palabra.charAt(i) == 'v'){
                    LetraV(root);
                }
                if(palabra.charAt(i) == 'w'){
                    LetraW(root);
                }
                if(palabra.charAt(i) == 'x'){
                    LetraX(root);
                }
                if(palabra.charAt(i) == 'y'){
                    LetraY(root);
                }
                if(palabra.charAt(i) == 'z'){
                    LetraZ(root);
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



}
