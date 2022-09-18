package codigo.proyecto; 

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class Dibujo {

    int x = 50;
    int y = 300;
    int aux=0;
    int grosor = 4;
    ArrayList<Circle> circulos = new ArrayList<>();
    Color color = Color.BLACK;
    Color color2 = Color.web("#5F9EA0");

    public void SelectorColor(String clr){
        if(clr.equals("Rojo")){
            color = Color.RED;
        }else if(clr.equals("Verde")){
            color = Color.GREEN;
        }else if(clr.equals("Azul")){
            color = Color.BLUE;
        }else if(clr.equals("Negro")){
            color = Color.BLACK;
        }else if(clr.equals("Gris")){
            color = Color.GREY;
        }else if(clr.equals("Naranjo")){
            color = Color.ORANGE;
        }else if(clr.equals("Violeta")){
            color = Color.VIOLET;
        }else if(clr.equals("Morado")){
            color = Color.PURPLE;
        }else if(clr.equals("Celeste")){
            color = Color.SKYBLUE;
        }else if(clr.equals("Rosado")){
            color = Color.PINK;
        }
    }

    void fun(AnchorPane root, ToggleButton puntosdeControl, int... lista){

        int j = 0;

        for (int i = 0; i < lista.length; i+=2) {
            Circle c = new Circle(lista[i], lista[i+1], grosor);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.TRANSPARENT);
            c.setStrokeWidth(grosor - 1);
            root.getChildren().add(c);

            circulos.add(c);
        }
    }

    void BotonAct(ToggleButton puntosdeControl) {

        if (!puntosdeControl.isSelected()) {
            for (int i = 0; i < circulos.size(); i++) {
                circulos.get(i).setStroke(Color.TRANSPARENT);
                puntosdeControl.setText("Mostrar puntos de control");
            }
        } else {
            for (int i = 0; i < circulos.size(); i++) {
                circulos.get(i).setStroke(color2);
                puntosdeControl.setText("Ocultar puntos de control");
            }
        }
    }

    public void Selector(char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl){

        if(caracter == 'a' || caracter == 'A' || caracter == 'á' || caracter == 'Á') {
            if(caracter == 'a' || caracter == 'á'){

                CubicCurve c= new CubicCurve(x+30, y+10, x-5, y-30, x-20, y+85, x+25, y+30);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+35, y, x+10, y+60, x+50, y+65, x+60, y+15);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                //Text t1 = new Text(caracter + ":\nX1: " + (x-5) + " Y1: " + (y-30) + "\nX2: " + (x-20) + " Y2: " + (y+85) + "\n"); //CTRL-X1:
                Text t1 = new Text(caracter + ":\nXI: " + (x+30) + " YI: " + (y+10) + "\tXF: " + (x+25) + " YF: " + (y+30));
                Text t2 = new Text( "\nX1: " + (x-5) + " Y1: " + (y-30) + "\tX2: " + (x-20) + " Y2: " + (y+85));
                
                t2.setFill(Color.RED);

                fun(root, puntosDeControl, x+30, y+10, x-5, y-30, x-20, y+85, x+25, y+30, x+35, y, x+10, y+60, x+50, y+65, x+60, y+15);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                root.getChildren().add(c);
                root.getChildren().add(c2);

                if(caracter == 'á'){
                    Line tilde = new Line(x+15,y-10,x+30,y-30);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    root.getChildren().add(tilde);
                }
                x = x+60;

            }else{
                CubicCurve c = new CubicCurve(x, y+50, x+20, y+60, x+20, y-50, x+30, y-50); // IZQ
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+30, y-50, x+50, y-60, x+40, y+120, x+65, y+15); // DER
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x, y+15, x+10, y-10, x+30, y+30, x+44, y); // MED
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text(caracter + ":\nX1: " + (x-5) + " Y1: " + (y-30) + "\nX2: " + (x-20) + " Y2: " + (y+85) + "\n");
                Text t2 = new Text(caracter + ":\nX1: " + (x-5) + " Y1: " + (y-30) + "\nX2: " + (x-20) + " Y2: " + (y+85) + "\n");
                Text t3 = new Text("X3: " + (x+10) + " Y3: " + (y+60) + "\nX4: " + (x+50) + " Y4: " + (y+65) + "\n\n");

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                if(caracter == 'Á'){
                    Line tilde = new Line(x+30,y-60,x+45,y-80);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y-60) + "\nX8: " + (x+45) + " Y8: " + (y-80) + "\n");

                    t4.setFill(Color.GREEN);

                    textoCoord.getChildren().add(t4);

                    root.getChildren().add(tilde);
                }
                Text t4 = new Text("\n");
                textoCoord.getChildren().add(t4);
                x = x+65;
            }
        }
        if(caracter == 'b' || caracter == 'B'){

            if(caracter == 'b'){
                CubicCurve cb1 = new CubicCurve(x, y+15, x+70, y-80, x-10, y-80, x, y+50); //"l" superior
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x, y+30, x+50, y-50, x+35, y+100, x+5, y+50);
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb3 = new CubicCurve(x+5, y+50, x, y+30, x+60, y+50, x+60, y+20);
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

                Text t1 = new Text("b:\nX1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+30) + "\nX4: " + (x+5) + " Y4: " + (y+50) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+5) + " Y5: " + (y+50) + "\nX6: " + (x+60) + " Y6: " + (y+20) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                fun(root, puntosDeControl, x+70, y-80, x-10, y+80, x+50, y-50, x+35, y+100, x, y+30, x+60, x+50);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(cb3);
                x = x+60;
            }else{

                QuadCurve c = new QuadCurve(x+30, y-20, x+30, y+50, x+40, y+50); // inferior b
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+40, y+50, x+60, y+60, x+80, y-10, x+30, y+20); // guata b
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+20, y+10, x-10, y+10, x, y-50, x+30, y-50); // izq sombrero
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                CubicCurve c4 = new CubicCurve(x+30, y-50, x+70, y-50, x+70, y, x+30, y+20); // der sombrero
                c4.setFill(Color.TRANSPARENT);
                c4.setStroke(color);
                c4.setStrokeWidth(grosor);

                QuadCurve c5 = new QuadCurve(x+58, y+40, x+70, y+60, x+80, y+15);
                c5.setFill(Color.TRANSPARENT);
                c5.setStroke(color);
                c5.setStrokeWidth(grosor);

                Text t1 = new Text("B:\nX1: " + (x+30) + " Y1: " + (y-20) + "\nX2: " + (x+40) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+40) + " Y3: " + (y+50) + "\nX4: " + (x+30) + " Y4: " + (y+20) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y+10) + "\nX6: " + (x+30) + " Y6: " + (y-50) + "\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y-50) + "\nX8: " + (x+30) + " Y8: " + (y+20) + "\n");
                t4.setFill(Color.GREEN);
                Text t5 = new Text("X9: " + (x+58) + " Y9: " + (y+40) + "\nX10: " + (x+80) + " Y10: " + (y+15) + "\n\n");
                t5.setFill(Color.PURPLE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);
                root.getChildren().add(c5);
                x = x+80;
            }
        }
        if(caracter == 'c' || caracter == 'C'){

            if(caracter == 'c'){
                CubicCurve c = new CubicCurve(x, y+25, x, y-20, x+40, y-5, x+25 , y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c1 = new CubicCurve(x, y+25, x, y+45, x+30, y+80, x+60, y+15);
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                Text t1 = new Text("c:\nX1: " + (x) + " Y1: " + (y+25) + "\nX2: " + (x+25) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+25) + "\nX4: " + (x+60) + " Y4: " + (y+15) + "\n\n");
                t2.setFill(Color.RED);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);


                root.getChildren().add(c);
                root.getChildren().add(c1);

                x = x+60;
            }else{

                CubicCurve c = new CubicCurve(x+20, y-40, x-25, y-10, x+10, y+110, x+60, y+15); // C
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+20, y-40, x+30+15, y-60, x+60+15, y-35, x+10, y);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+10, y, x-20, y+10, x-20, y-30, x, y-40);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("C:\nX1: " + (x+20) + " Y1: " + (y-40) + "\nX2: " + (x+60) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+20) + " Y3: " + (y-40) + "\nX4: " + (x+10) + " Y4: " + (y) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+10) + " Y5: " + (y) + "\nX6: " + (x) + " Y6: " + (y-40) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+60;
            }

        }
        if(caracter == 'd' || caracter == 'D'){

            if (caracter == 'd'){
                CubicCurve c = new CubicCurve(x+25, y+15, x-15, y-30, x, y+90, x+25, y+25);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+25, y+5, x+80, y-50, x+20, y-80, x+25, y+25);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+25, y+25, x+30, y+50, x+50, y+50, x+60, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("d:\nX1: " + (x+25) + " Y1: " + (y+15) + "\nX2: " + (x+25) + " Y2: " + (y+25) + "\n");
                Text t2 = new Text("X3: " + (x+25) + " Y3: " + (y+5) + "\nX4: " + (x+25) + " Y4: " + (y+25) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+25) + " Y5: " + (y+25) + "\nX6: " + (x+60) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+60;
            }else{

                CubicCurve c1 = new CubicCurve(x+20, y+10, x-10, y+10, x, y-50, x+30, y-50); // izq sombrero
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+30, y-50, x+80, y-50, x+80, y+50, x+50, y+50); // izq sombrero
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+50, y+50, x+30, y+50, x+30, y+50, x+30, y-30); // izq sombrero
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("D:\nX1: " + (x+20) + " Y1: " + (y+10) + "\nX2: " + (x+30) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X3: " + (x+30) + " Y3: " + (y-50) + "\nX4: " + (x+50) + " Y4: " + (y+50) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+50) + " Y5: " + (y+50) + "\nX6: " + (x+30) + " Y6: " + (y-30) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c1);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+90;
            }
        }
        if(caracter == 'e' || caracter == 'E' || caracter == 'é' || caracter == 'É'){

            if (caracter == 'e' || caracter == 'é'){
                Text t4 = new Text(caracter +"\n");
                textoCoord.getChildren().add(t4);

                CubicCurve b = new CubicCurve(x, y+25, x-5, y-20, x+53, y, x+2, y+30);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x, y+25, x, y+50, x+40, y+70, x+50, y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text("X1: " + (x) + " Y1: " + (y+25) + "\nX2: " + (x+2) + " Y2: " + (y+30) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+25) + "\nX4: " + (x+50) + " Y4: " + (y+15) + "\n");

                t2.setFill(Color.RED);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(b);
                root.getChildren().add(c);

                if(caracter == 'é'){
                    Line tilde = new Line(x+20,y-10,x+35,y-30);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y-10) + "\nX6: " + (x+35) + " Y6: " + (y-30) + "\n");

                    t3.setFill(Color.BLUE);

                    textoCoord.getChildren().add(t3);

                    root.getChildren().add(tilde);
                }
                Text t3 = new Text("\n");
                textoCoord.getChildren().add(t3);

                x = x+50;
            }else{
                Text t = new Text(caracter + "\n");
                textoCoord.getChildren().add(t);

                CubicCurve c2 = new CubicCurve(x+25, y-10, x-20, y-10, x, y+120, x+60, y+15);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+25, y-10, x-20, y-10, x+10, y-50, x+20, y-50);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                CubicCurve c4 = new CubicCurve(x+20, y-50, x+40, y-50, x+30, y-10, x, y-50);
                c4.setFill(Color.TRANSPARENT);
                c4.setStroke(color);
                c4.setStrokeWidth(grosor);

                Text t1 = new Text("X1: " + (x+25) + " Y1: " + (y-10) + "\nX2: " + (x+60) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+25) + " Y3: " + (y-10) + "\nX4: " + (x+20) + " Y4: " + (y-50) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y-50) + "\nX6: " + (x) + " Y6: " + (y-50) + "\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                if(caracter == 'É'){
                    Line tilde = new Line(x+30,y-60,x+45,y-80);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y-20) + "\nX8: " + (x+40) + " Y8: " + (y+50) + "\n");

                    t4.setFill(Color.GREEN);

                    textoCoord.getChildren().add(t4);

                    root.getChildren().add(tilde);
                }
                Text t4 = new Text( "\n");

                textoCoord.getChildren().add(t4);

                x = x+60;
            }

            //tamaÃ±o caracter
        }
        if(caracter == 'f' || caracter == 'F'){

            if (caracter == 'f'){
                CubicCurve c1 = new CubicCurve(x, y+10, x, y-60, x+60, y-60, x, y+10); // Curva Superior
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x, y, x, y+110, x+50, y+60, x+2, y+15); // Curva inferior
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                QuadCurve c3 = new QuadCurve(x+2, y+25, x+35, y+60, x+50, y+15); // Conexion
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("f:\nX1: " + (x) + " Y1: " + (y+10) + "\nX2: " + (x) + " Y2: " + (y+10) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y) + "\nX4: " + (x+2) + " Y4: " + (y+15) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+2) + " Y5: " + (y+25) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c1);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+50;
            }else{
                CubicCurve c = new CubicCurve(x, y-40, x+10, y-70, x+50, y-10, x+60, y-50);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                QuadCurve c2 = new QuadCurve(x+30, y-37, x+20, y+70, x+10, y+40);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                Line l = new Line(x+10, y, x+40, y);
                l.setFill(Color.TRANSPARENT);
                l.setStroke(color);
                l.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+10, y+10, x+20, y, x+30, y+20, x+50, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("F:\nX1: " + (x) + " Y1: " + (y-40) + "\nX2: " + (x+60) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X3: " + (x+30) + " Y3: " + (y-37) + "\nX4: " + (x+10) + " Y4: " + (y+40) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+10) + " Y5: " + (y) + "\nX6: " + (x+40) + " Y6: " + (y) + "\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+10) + " Y7: " + (y+10) + "\nX8: " + (x+50) + " Y8: " + (y+15) + "\n\n");
                t4.setFill(Color.GREEN);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+50;
            }


        }
        if(caracter == 'g' || caracter =='G'){

            if (caracter == 'g'){
                CubicCurve c = new CubicCurve(x+25, y+10, x-10, y-20, x-10, y+70, x+25, y+40); // Circulo
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+25, y, x+35, y+90, x+10, y+90, x+10, y+80);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+10, y+80, x+10, y+30, x+60, y+60, x+60, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("g:\nX1: " + (x+25) + " Y1: " + (y+10) + "\nX2: " + (x+25) + " Y2: " + (y+40) + "\n");
                Text t2 = new Text("X3: " + (x+25) + " Y3: " + (y) + "\nX4: " + (x+10) + " Y4: " + (y+80) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+10) + " Y5: " + (y+80) + "\nX6: " + (x+60) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+60;
            }else{
                CubicCurve c = new CubicCurve(x, y+20, x+70, y+10, x+60, y-50, x+40, y-50); // mitad e
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+40, y-50, x, y-50, x+10, y+110, x+59, y+20); // otra mitad
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+60, y+10, x+60, y+100, x+20, y+100, x+30, y+80); // mitad j
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                CubicCurve c4 = new CubicCurve(x+30, y+80, x+40, y+60, x+60, y+60, x+80, y+15); // otra mitad j
                c4.setFill(Color.TRANSPARENT);
                c4.setStroke(color);
                c4.setStrokeWidth(grosor);

                Text t1 = new Text("G:\nX1: " + (x) + " Y1: " + (y+20) + "\nX2: " + (x+40) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X3: " + (x+40) + " Y3: " + (y-50) + "\nX4: " + (x+59) + " Y4: " + (y+20) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+60) + " Y5: " + (y+10) + "\nX6: " + (x+30) + " Y6: " + (y+80) + "\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y+80) + "\nX8: " + (x+80) + " Y8: " + (y+15) + "\n\n");
                t4.setFill(Color.GREEN);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                x = x + 80;
            }

        }
        if(caracter == 'h' || caracter == 'H'){

            if(caracter == 'h'){
                CubicCurve c2 = new CubicCurve(x, y+15, x+50, y-50, x-10, y-90, x, y+50); // l
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x, y+40, x+10, y, x+25, y+5, x+25, y+35); // guata
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+25, y+35, x+25, y+60, x+40, y+60, x+50, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("h:\nX1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+40) + "\nX4: " + (x+25) + " Y4: " + (y+35) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+25) + " Y5: " + (y+35) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+50;
            }else{
                CubicCurve c = new CubicCurve(x, y-40, x+10, y-60, x+30, y-30, x+20, y+40); // primera curva hacia abajo
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+20, y+40, x+10, y+80, x-10, y+30, x+40, y); // segunda curva
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+40, y, x+60, y-10, x+60, y-50, x+50, y-50);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                CubicCurve c4 = new CubicCurve(x+50, y-50, x+40, y-50, x+40, y+120, x+70, y+15);
                c4.setFill(Color.TRANSPARENT);
                c4.setStroke(color);
                c4.setStrokeWidth(grosor);

                Text t1 = new Text("H:\nX1: " + (x) + " Y1: " + (y-40) + "\nX2: " + (x+20) + " Y2: " + (y+40) + "\n");
                Text t2 = new Text("X3: " + (x+20) + " Y3: " + (y+40) + "\nX4: " + (x+40) + " Y4: " + (y) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+40) + " Y5: " + (y) + "\nX6: " + (x+50) + " Y6: " + (y-50) + "\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+50) + " Y7: " + (y-50) + "\nX8: " + (x+70) + " Y8: " + (y+15) + "\n\n");
                t4.setFill(Color.GREEN);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                x = x+70;
            }
        }
        if(caracter == 'i' || caracter == 'I' || caracter == 'í' || caracter == 'Í'){

            if (caracter == 'i' || caracter == 'í'){

                Text t = new Text(caracter+ "\n");
                textoCoord.getChildren().add(t);

                CubicCurve c = new CubicCurve(x+2, y, x-10, y+80, x+30, y+40, x+40, y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text("X1: " + (x+2) + " Y1: " + (y) + "\nX2: " + (x+40) + " Y2: " + (y+15) + "\n");
                textoCoord.getChildren().add(t1);
                root.getChildren().add(c);

                if(caracter == 'í'){
                    Line tilde = new Line(x,y-10,x+15,y-30);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t2 = new Text("X3: " + (x) + " Y3: " + (y-10) + "\nX4: " + (x+15) + " Y4: " + (y-30) + "\n\n");

                    t2.setFill(Color.RED);

                    textoCoord.getChildren().add(t2);

                    root.getChildren().add(tilde);
                }
                else{
                    Circle p = new Circle(x+3, y-10, 1);
                    p.setFill(Color.TRANSPARENT);
                    p.setStroke(color);
                    p.setStrokeWidth(grosor);

                    Text t2 = new Text("X3: " + (x+3) + " Y3: " + (y-10) + "\n\n");

                    t2.setFill(Color.RED);

                    textoCoord.getChildren().add(t2);

                    root.getChildren().add(p);
                }
                x = x+40;
            }else{

                Text t = new Text(caracter+"\n" );
                textoCoord.getChildren().add(t);


                CubicCurve c1 = new CubicCurve(x, y-50, x+20, y-60, x+30, y-40, x+50, y-40);
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+50, y-40,x+70, y-40, x+50, y-120, x+40, y+20);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+40, y+20, x+35, y+70, x, y+40, x, y+30);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                Text t1 = new Text("X1: " + (x) + " Y1: " + (y-50) + "\nX2: " + (x+50) + " Y2: " + (y-40) + "\n");
                Text t2 = new Text("X3: " + (x+50) + " Y3: " + (y-40) + "\nX4: " + (x+40) + " Y4: " + (y+20) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+40) + " Y5: " + (y+20) + "\nX6: " + (x) + " Y6: " + (y+30) + "\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(c1);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                if(caracter == 'Í'){
                    Line tilde = new Line(x+30,y-60,x+45,y-80);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y-60) + "\nX8: " + (x+45) + " Y8: " + (y-80) + "\n");

                    t4.setFill(Color.GREEN);

                    textoCoord.getChildren().add(t4);

                    root.getChildren().add(tilde);
                }

                Text t4 = new Text("\n");
                textoCoord.getChildren().add(t4);
                x = x+55;
            }
        }
        if(caracter == 'j' || caracter == 'J'){
            if (caracter == 'j'){
                CubicCurve cb1 = new CubicCurve(x - 15, y + 65, x - 15, y + 50, x + 30, y + 35, x + 30, y + 15); //"l" superior
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                root.getChildren().add(cb1);

                CubicCurve cb2 = new CubicCurve(x, y + 70, x - 5, y + 95, x - 20, y + 85, x - 15, y + 65); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                root.getChildren().add(cb2);

                CubicCurve cb3 = new CubicCurve(x, y, x - 1, y + 20, x + 5, y + 60, x, y + 70); //"l" superior
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

                root.getChildren().add(cb3);

                Circle cd1 = new Circle(x, y - 10, 1);
                cd1.setStrokeWidth(grosor);
                cd1.setFill(Color.TRANSPARENT);
                cd1.setStroke(color);

                root.getChildren().add(cd1);

                Text t1 = new Text("j:\nX1: " + (x-15) + " Y1: " + (y+65) + "\nX2: " + (x+30) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+70) + "\nX4: " + (x-15) + " Y4: " + (y+65) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x) + " Y5: " + (y) + "\nX6: " + (x) + " Y6: " + (y+70) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                x = x + 30;
            }
            else{
                QuadCurve qv1 = new QuadCurve(x, y-40,x+20,y-50,x+50,y-40);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                CubicCurve cb1 = new CubicCurve(x+50, y-40,x+70, y-40, x+50, y-120, x+40, y+30); //"l" superior
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x+40, y+30,x+40, y+55, x+10, y+60, x+5, y+40); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb4 = new CubicCurve(x+5, y+40, x, y+20, x+15, y, x+50, y-15);
                cb4.setFill(Color.TRANSPARENT);
                cb4.setStroke(color);
                cb4.setStrokeWidth(grosor);

                Text t1 = new Text("J:\nX1: " + (x) + " Y1: " + (y-40) + "\nX2: " + (x+50) + " Y2: " + (y-40) + "\n");
                Text t2 = new Text("X3: " + (x+50) + " Y3: " + (y-40) + "\nX4: " + (x+40) + " Y4: " + (y+30) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+40) + " Y5: " + (y+30) + "\nX6: " + (x+5) + " Y6: " + (y+40) + "\n\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+5) + " Y7: " + (y+40) + "\nX8: " + (x+50) + " Y8: " + (y-15) + "\n\n");
                t3.setFill(Color.GREEN);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                root.getChildren().add(qv1);
                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(cb4);

                x = x + 50;
            }
        }
        if(caracter == 'k' || caracter == 'K'){

            if (caracter == 'k') {
                CubicCurve cb1 = new CubicCurve(x+2, y,x+37, y, x-3, y-150, x-1, y+50); //"l" superior
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x, y+18,x+7, y-10, x+42, y+20, x+17, y+30); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb3 = new CubicCurve(x+17, y+30,x+37, y+72, x+47, y+50, x+55, y+15);  //Curva derecha (conector)
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

                Text t1 = new Text("k:\nX1: " + (x+2) + " Y1: " + (y) + "\nX2: " + (x-1) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+18) + "\nX4: " + (x+17) + " Y4: " + (y+30) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+17) + " Y5: " + (y+30) + "\nX6: " + (x+55) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(cb3);

                x = x+55;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x, y-20, x+40, y-120, x+40, y+80, x+10, y+40); // primera curva hacia
                // abajo
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x+10, y+40,x-20, y, x+60, y, x+60, y-50); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb3 = new CubicCurve(x+33, y-5,x+60, y-10, x+60, y+115, x+80, y+15);  //Curva derecha (conector)
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

                Text t1 = new Text("K:\nX1: " + (x) + " Y1: " + (y-20) + "\nX2: " + (x+10) + " Y2: " + (y+40) + "\n");
                Text t2 = new Text("X3: " + (x+10) + " Y3: " + (y+40) + "\nX4: " + (x+60) + " Y4: " + (y-50) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+33) + " Y5: " + (y-5) + "\nX6: " + (x+80) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(cb3);

                x = x +80;
            }
        }
        if(caracter == 'l' || caracter == 'L'){
            if (caracter == 'l') {
                CubicCurve cb1 = new CubicCurve(x, y + 15, x + 37, y - 40, x - 3, y - 120, x - 1, y + 40); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x - 1, y + 40, x, y + 60, x + 20, y + 60, x + 30, y + 15);  //Curva derecha (conector)
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text("l:\nX1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x-1) + " Y2: " + (y+40) + "\n");
                Text t2 = new Text("X3: " + (x-1) + " Y3: " + (y+40) + "\nX4: " + (x+30) + " Y4: " + (y+15) + "\n\n");
                t2.setFill(Color.RED);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);

                x = x + 30;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x, y+15, x+80, y-80, x+5, y-60, x+15, y-5); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x+15, y-5,x+15, y+100, x-30, y+10, x+20, y+50); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                QuadCurve qv1 = new QuadCurve(x+20, y+50,x+45,y+60,x+50,y+15);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text("L:\nX1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x+15) + " Y2: " + (y-5) + "\n");
                Text t2 = new Text("X3: " + (x+15) + " Y3: " + (y-5) + "\nX4: " + (x+20) + " Y4: " + (y+50) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y+50) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(qv1);

                x = x + 50;
            }
        }
        if(caracter == 'm' || caracter == 'M'){
            if (caracter == 'm') {
                QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 15, y-50, x + 28, y+48);
                qv2.setFill(Color.TRANSPARENT);
                qv2.setStroke(color);
                qv2.setStrokeWidth(grosor);

                QuadCurve qv3 = new QuadCurve(x + 28, y + 48, x + 40, y-50, x + 48, y+48);
                qv3.setFill(Color.TRANSPARENT);
                qv3.setStroke(color);
                qv3.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 48, y+48, x+50, y+60, x + 68, y + 65, x + 70, y + 15); //Curva principal
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text("m:\nX1: " + (x) + " Y1: " + (y) + "\nX2: " + (x+8) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+8) + " Y3: " + (y+50) + "\nX4: " + (x+28) + " Y4: " + (y+48) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+28) + " Y5: " + (y+48) + "\nX6: " + (x+48) + " Y6: " + (y+48) + "\n");
                t3.setFill(Color.BLUE);
                Text t4 = new Text("X7: " + (x+48) + " Y7: " + (y+48) + "\nX8: " + (x+70) + " Y8: " + (y+15) + "\n\n");
                t4.setFill(Color.GREEN);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(qv1);
                root.getChildren().add(qv2);
                root.getChildren().add(qv3);
                root.getChildren().add(cb2);

                x = x + 70;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x+5, y+15, x-15, y-70, x+29, y-85, x+15, y+50); // primera curva hacia
                // abajo
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                QuadCurve qv1 = new QuadCurve(x+15, y+50, x+35, y-90, x+40, y + 40);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                QuadCurve qv2 = new QuadCurve(x+40, y+40, x + 60, y-83, x + 65, y+50);
                qv2.setFill(Color.TRANSPARENT);
                qv2.setStroke(color);
                qv2.setStrokeWidth(grosor);

                Text t1 = new Text("M:\nX1: " + (x+5) + " Y1: " + (y+15) + "\nX2: " + (x+15) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+15) + " Y3: " + (y+50) + "\nX4: " + (x+40) + " Y4: " + (y+40) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+40) + " Y5: " + (y+40) + "\nX6: " + (x+65) + " Y6: " + (y+50) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(qv1);
                root.getChildren().add(qv2);

                x = x + 78;
            }
        }
        if(caracter == 'n' || caracter == 'N'){
            if (caracter == 'n') {
                QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 30, y-50, x + 30, y+48);
                qv2.setFill(Color.TRANSPARENT);
                qv2.setStroke(color);
                qv2.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 30, y+48, x + 30, y+60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text("n:\nX1: " + (x) + " Y1: " + (y) + "\nX2: " + (x+8) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+8) + " Y3: " + (y+50) + "\nX4: " + (x+30) + " Y4: " + (y+48) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+30) + " Y5: " + (y+48) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(qv1);
                root.getChildren().add(qv2);
                root.getChildren().add(cb2);

                x = x + 50;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x+5, y+15, x-15, y-70, x+29, y-85, x+15, y+50); // primera curva hacia
                // abajo
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                QuadCurve qv1 = new QuadCurve(x+15, y+50, x+40, y-93, x+45, y + 60);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text("N:\nX1: " + (x+5) + " Y1: " + (y+15) + "\nX2: " + (x+15) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+15) + " Y3: " + (y+50) + "\nX4: " + (x+45) + " Y4: " + (y+60) + "\n\n");
                t2.setFill(Color.RED);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(cb1);
                root.getChildren().add(qv1);

                x = x + 55;
            }
        }
        if(caracter == 'ñ' || caracter == 'Ñ'){
            if (caracter == 'ñ') {
                QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 30, y-50, x + 30, y+48);
                qv2.setFill(Color.TRANSPARENT);
                qv2.setStroke(color);
                qv2.setStrokeWidth(grosor);

                CubicCurve cb1 = new CubicCurve(x + 30, y+48, x + 30, y+60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 15, y - 15, x + 20, y - 25, x + 25, y - 5, x + 30, y - 15);
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text("ñ:\nX1: " + (x) + " Y1: " + (y) + "\nX2: " + (x+8) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+8) + " Y3: " + (y+50) + "\nX4: " + (x+30) + " Y4: " + (y+48) + "\n");
                t2.setFill(Color.RED);
                Text t3 = new Text("X5: " + (x+30) + " Y5: " + (y+48) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                t3.setFill(Color.BLUE);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(qv1);
                root.getChildren().add(qv2);
                root.getChildren().add(cb1);
                root.getChildren().add(cb2);

                x = x + 50;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x+5, y+15, x-15, y-70, x+29, y-85, x+15, y+50); // primera curva hacia
                // abajo
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                QuadCurve qv1 = new QuadCurve(x+15, y+50, x+40, y-93, x+45, y + 60);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 25, y - 40, x + 30, y - 50, x + 40, y - 30, x + 45, y - 40);
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text("Ñ:\nX1: " + (x+5) + " Y1: " + (y+15) + "\nX2: " + (x+15) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x+15) + " Y3: " + (y+50) + "\nX4: " + (x+45) + " Y4: " + (y+60) + "\n\n");
                t2.setFill(Color.RED);
                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(qv1);

                x = x + 55;
            }
        }
        if(caracter == 'o' || caracter == 'O' || caracter == 'ó' || caracter == 'Ó'){
            if (caracter == 'o' || caracter == 'ó') {
                Text t1 = new Text(caracter +"\n");
                textoCoord.getChildren().add(t1);

                CubicCurve cb1 = new CubicCurve(x, y+20, x, y+60, x + 30, y + 60, x + 30, y + 20); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 30, y+20, x + 30, y-5, x, y-5, x, y+20);
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                QuadCurve qv1 = new QuadCurve(x+5, y+6, x + 30, y + 50, x + 50, y + 15);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t2 = new Text("X1: " + (x) + " Y1: " + (y+20) + "\nX2: " + (x+30) + " Y2: " + (y+20) + "\n");
                Text t3 = new Text("X3: " + (x+30) + " Y3: " + (y+20) + "\nX4: " + (x) + " Y4: " + (y+20) + "\n");
                t3.setFill(Color.RED);
                Text t4 = new Text("X5: " + (x+5) + " Y5: " + (y+6) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n");
                t4.setFill(Color.BLUE);

                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                if(caracter == 'ó'){
                    Line tilde = new Line(x+20,y-10,x+35,y-30);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t5 = new Text("X7: " + (x+20) + " Y7: " + (y-10) + "\nX8: " + (x+35) + " Y8: " + (y-30) + "\n");

                    t5.setFill(Color.GREEN);

                    textoCoord.getChildren().add(t5);

                    root.getChildren().add(tilde);

                }
                Text t5 = new Text( "\n");
                textoCoord.getChildren().add(t5);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(qv1);

                x = x + 50;
            }
            else{
                Text t1 = new Text(caracter+"\n");
                textoCoord.getChildren().add(t1);

                CubicCurve cb1 = new CubicCurve(x+13, y-10, x, y+70, x+57, y+70, x+57, y-10); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x+57, y-10,x+40, y-125, x-55, y+50, x+45, y+10); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t2 = new Text("X1: " + (x+13) + " Y1: " + (y-10) + "\nX2: " + (x+57) + " Y2: " + (y-10) + "\n");
                Text t3 = new Text("X3: " + (x+57) + " Y3: " + (y-10) + "\nX4: " + (x+45) + " Y4: " + (y+10) + "\n");
                t3.setFill(Color.RED);

                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                if(caracter == 'Ó'){
                    Line tilde = new Line(x+20,y-60,x+35,y-80);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t4 = new Text("X5: " + (x+20) + " Y5: " + (y-60) + "\nX6: " + (x+35) + " Y6: " + (y-80) + "\n");
                    t4.setFill(Color.BLUE);

                    textoCoord.getChildren().add(t4);

                    root.getChildren().add(tilde);
                }
                Text t4 = new Text( "\n");
                textoCoord.getChildren().add(t4);

                x = x + 65;
            }
        }
        if(caracter == 'p' || caracter == 'P'){
            if (caracter == 'p') {
                QuadCurve qv1 = new QuadCurve(x, y, x - 2, y + 15, x, y + 85);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                CubicCurve cb1 = new CubicCurve(x + 1, y + 15, x + 40, y - 15, x + 35, y + 50, x + 25, y + 50); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 25, y + 50, x, y + 60, x, y + 30, x + 30, y + 35); //Curva principal
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                QuadCurve d = new QuadCurve(x + 30, y + 35, x + 40, y + 30, x + 55, y + 15);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x) + " Y1: " + (y) + "\nX2: " + (x) + " Y2: " + (y+85) + "\n");
                Text t2 = new Text("X3: " + (x+1) + " Y3: " + (y+15) + "\nX4: " + (x+57) + " Y4: " + (y+50) + "\n");
                Text t3 = new Text("X5: " + (x+25) + " Y5: " + (y+50) + "\nX6: " + (x+30) + " Y6: " + (y+35) + "\n");
                Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y+35) + "\nX8: " + (x+55) + " Y8: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x,y,x,y+85,x+1,y+15,x+57,y+50,x+25,y+50,x+30,y+35,x+30,y+35,x+55,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(qv1);
                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(d);

                x = x + 55;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x, y+15, x, y-70, x+30, y-90, x+25, y+85); // primera curva hacia
                // abajo
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 24, y-20, x+60, y-110, x+70, y+60, x + 26, y+30); //Curva principal
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x+25) + " Y2: " + (y+85) + "\n");
                Text t2 = new Text("X3: " + (x+24) + " Y3: " + (y-20) + "\nX4: " + (x+26) + " Y4: " + (y+30) + "\n\n");
                fun(root,puntosDeControl,x,y+15,x+25,y+85,x+24,y-20,x+26,y+30);

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);

                x = x + 58;
            }
        }
        if(caracter == 'q' || caracter == 'Q'){
            if (caracter == 'q') {
                QuadCurve qv1 = new QuadCurve(x + 30, y, x + 28, y + 28, x + 30, y + 85);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                CubicCurve cb1 = new CubicCurve(x + 28, y + 12, x - 12, y - 10, x - 13, y + 60, x + 28, y + 40); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                QuadCurve qv2 = new QuadCurve(x + 30, y + 47, x + 50, y + 47, x + 60, y + 15);
                qv2.setFill(Color.TRANSPARENT);
                qv2.setStroke(color);
                qv2.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x + 30, y + 85, x + 40, y + 80, x + 40, y + 50, x + 30, y + 47); //Curva principal
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+30) + " Y1: " + (y+28) + "\nX2: " + (x+30) + " Y2: " + (y+85) + "\n");
                Text t2 = new Text("X3: " + (x+28) + " Y3: " + (y+12) + "\nX4: " + (x+28) + " Y4: " + (y+40) + "\n");
                Text t3 = new Text("X5: " + (x+30) + " Y5: " + (y+47) + "\nX6: " + (x+60) + " Y6: " + (y+15) + "\n");
                Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y+85) + "\nX8: " + (x+30) + " Y8: " + (y+47) + "\n\n");
                fun(root,puntosDeControl,x+30,y+85,x+28,y+12,x+28,y+40,x+30,y+47,x+60,y+15,x+30,y+85,x+30,y+47);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(qv1);
                root.getChildren().add(qv2);
                root.getChildren().add(cb1);
                root.getChildren().add(cb2);

                x = x + 60;
            }
            else{
                CubicCurve cb1 = new CubicCurve(x+13, y-10, x, y+70, x+57, y+70, x+57, y-10); //Curva principal
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x+57, y-10,x+40, y-125, x-55, y+50, x+45, y+10); //Semi ovalo
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb3 = new CubicCurve(x+35, y+37,x+45, y+27, x+55, y+62, x+65, y+47);  //Curva derecha (conector)
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+13) + " Y1: " + (y-10) + "\nX2: " + (x+57) + " Y2: " + (y-10) + "\n");
                Text t2 = new Text("X3: " + (x+57) + " Y3: " + (y-10) + "\nX4: " + (x+45) + " Y4: " + (y+10) + "\n");
                Text t3 = new Text("X5: " + (x+35) + " Y5: " + (y+37) + "\nX6: " + (x+65) + " Y6: " + (y+47) + "\n\n");
                fun(root,puntosDeControl,x+13,y-10,x+57,y-10,x+45,y+10,x+35,y+37,x+65,y+47,x+57,y-10);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(cb1);
                root.getChildren().add(cb2);
                root.getChildren().add(cb3);

                x = x + 65;
            }

        }
        if(caracter == 'r' || caracter == 'R' ){
            if(caracter =='r'){
                if(caracterAnt == ' '){
                    CubicCurve a = new CubicCurve(x+20, y+40, x+10, y+60, x+50, y+65, x+60, y+15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    root.getChildren().add(a);
                    x=x+60;
                }
                //CurvA
                CubicCurve a = new CubicCurve(x+9-10,y+10,x+10-10,y-21,x-22-10,y+40,x+30,y);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+30,y,x+9,y+28,x+25,y+95,x+55,y+15);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x-1) + " Y1: " + (y+10) + "\nX2: " + (x+30) + " Y2: " + (y) + "\n");
                Text t2 = new Text("X3: " + (x+30) + " Y3: " + (y) + "\nX4: " + (x+55) + " Y4: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x-1,y+10,x+30,y,x+30,y,x+55,y+15);

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                //EspacioDecaracterR
                x= x+55;
            }
            else{
                //CurvA
                QuadCurve a = new QuadCurve(x,y+15,x+15,y-20,x+20,y-50);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvB
                QuadCurve b = new QuadCurve(x+20,y-50,x+25,y,x+10,y+50);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurvC
                CubicCurve c = new CubicCurve(x+20,y-40,x+80,y-80,x+50,y+20,x+20,y);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //CurvC
                CubicCurve d = new CubicCurve(x+20,y,x+40,y,x+40,y+55,x+60,y+55);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                //CurvB
                QuadCurve e = new QuadCurve(x+60,y+55,x+70,y+55,x+80,y+15);
                e.setFill(Color.TRANSPARENT);
                e.setStroke(color);
                e.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x+20) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X3: " + (x+20) + " Y3: " + (y-50) + "\nX4: " + (x+10) + " Y4: " + (y+50) + "\n");
                Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y-40) + "\nX6: " + (x+20) + " Y6: " + (y) + "\n");
                Text t4 = new Text("X7: " + (x+20) + " Y7: " + (y+40) + "\nX8: " + (x+60) + " Y8: " + (y+55) + "\n");
                Text t5 = new Text("X9: " + (x+60) + " Y9: " + (y+55) + "\nX10: " + (x+80) + " Y10: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x,y+15,x+20,y-50,x+20,y-50,x+10,y+50,x+20,y-40,x+20,y,x+20,y+40,x+60,y+55,x+60,y+55,x+80,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);
                t5.setFill(Color.ORANGE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                root.getChildren().add(e);

                x = x +80;
            }
        }
        if(caracter == 's' || caracter == 'S'){
            if(caracter =='s'){
                if(caracterAnt == ' '){
                    CubicCurve a = new CubicCurve(x+20, y+40, x+10, y+60, x+50, y+65, x+60, y+15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    root.getChildren().add(a);
                    x=x+60;
                }
                //CurvaA
                CubicCurve a = new CubicCurve(x+20,y+35,x-40,y-15,x+40,y-15,x,y+10+5);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurbaB
                CubicCurve b = new CubicCurve(x+20,y+35,x+45,y+60,x-10,y+60,x+22,y+40);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurbaC
                QuadCurve c = new QuadCurve(x+22,y+40,x+35,y+30,x+40,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+20) + " Y1: " + (y+35) + "\nX2: " + (x) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+20) + " Y3: " + (y+35) + "\nX4: " + (x+22) + " Y4: " + (y+40) + "\n");
                Text t3 = new Text("X5: " + (x+22) + " Y5: " + (y+40) + "\nX6: " + (x+40) + " Y6: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x+20,y+35,x,y+15,x+20,y+35,x+22,y+40,x+22,y+40,x+40,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //Espaciocaracter s
                x = x+40;
            }
            else{
                //CurvaA
                CubicCurve a = new CubicCurve(x-1,y+15,x,y-15,x-30,y+20,x+10,y+40);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+10,y+40,x+65,y+70,x+50,y+10,x+25,y);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurvaC
                QuadCurve c = new QuadCurve(x+44,y+47,x+55,y+45,x+70,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //CurvaD
                CubicCurve d = new CubicCurve(x+25,y,x-30,y-30,x+90,y-80,x+35,y-20);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x-1) + " Y1: " + (y+15) + "\nX2: " + (x+10) + " Y2: " + (y+40) + "\n");
                Text t2 = new Text("X3: " + (x+10) + " Y3: " + (y+40) + "\nX4: " + (x+25) + " Y4: " + (y) + "\n");
                Text t3 = new Text("X5: " + (x+44) + " Y5: " + (y+47) + "\nX6: " + (x+70) + " Y6: " + (y+15) + "\n");
                Text t4 = new Text("X7: " + (x+25) + " Y7: " + (y) + "\nX8: " + (x+35) + " Y8: " + (y-20) + "\n\n");
                fun(root,puntosDeControl,x-1,y+15,x+10,y+40,x+10,y+40,x+25,y,x+44,y+47,x+70,y+15,x+25,y,x+35,y-20);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                x = x+70;
            }

        }
        if(caracter == 't' || caracter == 'T'){
            if(caracter == 't'){
                //CurvaA
                CubicCurve a = new CubicCurve(x+10,y-40,x-15,y,x+15,y+100,x+30,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x-10,y-25,x-5,y-30,x+10,y-20,x+15,y-25);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y-40) + "\nX2: " + (x+30) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x-10) + " Y3: " + (y-25) + "\nX4: " + (x+15) + " Y4: " + (y-25) + "\n\n");
                fun(root,puntosDeControl,x+10,y-40,x+30,y+15,x-10,y-25,x+15,y-25);

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                //EspaciocaracterT
                x=x+30;
            }
            else{
                //CurvaA
                CubicCurve a = new CubicCurve(x+10,y-50,x-20,y,x+15,y+100,x+30,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaA
                CubicCurve b = new CubicCurve(x-30,y-40,x-20,y-55,x+40,y-40,x+45,y-55);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y-50) + "\nX2: " + (x+30) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x-30) + " Y3: " + (y-40) + "\nX4: " + (x+45) + " Y4: " + (y-55) + "\n\n");
                fun(root,puntosDeControl,x+10,y-50,x+30,y+15,x-30,y-40,x+45,y-55);

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(a);
                root.getChildren().add(b);
                x=x+30;
            }
        }
        if(caracter == 'u' || caracter == 'U' ||caracter == 'ü' || caracter =='Ü' || caracter == 'ú' || caracter == 'Ú' ){
            if(caracter == 'u' || caracter == 'ü' || caracter == 'ú'){
                Text t = new Text(caracter +"\n");
                textoCoord.getChildren().add(t);

                //CurvaA
                CubicCurve a = new CubicCurve(x+2,y,x-6,y+30,x+9,y+80,x+24,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+28,y,x+18,y+30,x+33,y+100,x+48,y+15);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                Text t1 = new Text("X1: " + (x+2) + " Y1: " + (y) + "\nX2: " + (x+24) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+28) + " Y3: " + (y) + "\nX4: " + (x+48) + " Y4: " + (y+15) + "\n");

                t1.setFill(Color.RED);
                t2.setFill(Color.BLUE);;

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                if(caracter == 'ü'){
                    Circle p = new Circle(x+2, y-10, 2);
                    p.setFill(Color.TRANSPARENT);
                    p.setStroke(color);
                    p.setStrokeWidth(grosor);

                    Circle p2 = new Circle(x+28, y-10, 2);
                    p2.setFill(Color.TRANSPARENT);
                    p2.setStroke(color);
                    p2.setStrokeWidth(grosor);

                    root.getChildren().add(p);
                    root.getChildren().add(p2);

                    Text t3 = new Text("X5: " + (x+2) + " Y5: " + (y-10) + "\n");
                    Text t4 = new Text("X6: " + (x+28) + " Y6: " + (y-10) +"\n");

                    t3.setFill(Color.GREEN);
                    t4.setFill(Color.PURPLE);

                    textoCoord.getChildren().add(t3);
                    textoCoord.getChildren().add(t4);

                }
                if(caracter == 'ú'){
                    Line tilde = new Line(x+20,y-10,x+35,y-30);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t3 = new Text("X5: " + (x+20) + " Y5: " + (y-10) + "\nX6: " + (x+35) + " Y6: " + (y-30) + "\n");
                    t3.setFill(Color.GREEN);

                    textoCoord.getChildren().add(t3);

                    root.getChildren().add(tilde);
                }
                Text t3 = new Text( "\n");
                textoCoord.getChildren().add(t3);

                //largo de caracter i
                x=x+50;
            }
            else{
                Text t1 = new Text(caracter +"\n");
                textoCoord.getChildren().add(t1);
                //CurvaA
                CubicCurve a = new CubicCurve(x+2,y-35,x-6,y+30,x+9,y+80,x+24+5,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+28+5,y-35,x+18+5,y+30,x+33+5,y+100,x+48+5,y+15);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurvaC
                CubicCurve c = new CubicCurve(x+2,y-35,x+10,y-60,x-20,y-50,x-20,y-20);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t2 = new Text("X1: " + (x+2) + " Y1: " + (y-35) + "\nX2: " + (x+29) + " Y2: " + (y+15) + "\n");
                Text t3 = new Text("X3: " + (x+33) + " Y3: " + (y-35) + "\nX4: " + (x+53) + " Y4: " + (y+15) + "\n");
                Text t4 = new Text("X5: " + (x+2) + " Y5: " + (y-35) + "\nX6: " + (x+20) + " Y6: " + (y-20) + "\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                if(caracter == 'Ü'){
                    Circle p = new Circle(x+2, y-60, 2);
                    p.setFill(Color.TRANSPARENT);
                    p.setStroke(color);
                    p.setStrokeWidth(grosor);

                    Circle p2 = new Circle(x+33, y-60, 2);
                    p2.setFill(Color.TRANSPARENT);
                    p2.setStroke(color);
                    p2.setStrokeWidth(grosor);

                    Text t5 = new Text("X7: " + (x+2) + " Y7: " + (y-60) +"\n");
                    Text t6 = new Text("X8: " + (x+33) + " Y8: " + (y-60) +"\n");

                    t5.setFill(Color.PURPLE);
                    t6.setFill(Color.BROWN);

                    textoCoord.getChildren().add(t5);
                    textoCoord.getChildren().add(t6);

                    root.getChildren().add(p);
                    root.getChildren().add(p2);
                }
                if(caracter == 'Ú'){
                    Line tilde = new Line(x+20,y-60,x+35,y-80);
                    tilde.setFill(Color.TRANSPARENT);
                    tilde.setStroke(color);
                    tilde.setStrokeWidth(grosor);

                    Text t5 = new Text("X7: " + (x+20) + " Y7: " + (y-60) + "\nX8: " + (x+35) + " Y8: " + (y-80) + "\n");
                    t5.setFill(Color.PURPLE);
                    textoCoord.getChildren().add(t5);
                    root.getChildren().add(tilde);
                }
                Text t5 = new Text("\n");
                textoCoord.getChildren().add(t5);

                //largo de caracter i
                x=x+55;
            }
        }
        if(caracter == 'v' || caracter == 'V'){
            if(caracter =='v'){
                //curvaA
                CubicCurve a = new CubicCurve(x-3,y, x+10, y+63,x+25,y+63,x+35,y);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //curvaB
                CubicCurve b = new CubicCurve(x+35,y,x+35,y-20,x+10,y+12,x+30,y+25);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //curvaC
                CubicCurve c = new CubicCurve(x+30,y+25,x+35,y+25,x+45,y+20,x+50,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x-3) + " Y1: " + (y) + "\nX2: " + (x+63) + " Y2: " + (y) + "\n");
                Text t2 = new Text("X3: " + (x+35) + " Y3: " + (y) + "\nX4: " + (x+30) + " Y4: " + (y+25) + "\n");
                Text t3 = new Text("X5: " + (x+30) + " Y5: " + (y+25) + "\nX6: " + (x+50) + " Y6: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x-3,y,x+63,y,x+35,y,x+30,y+25,x+30,y+25,x+50,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //espaciocaracter v
                x=x+50;
            }
            else{
                //CurvaC
                CubicCurve d = new CubicCurve(x+2,y-35,x+10,y-60,x-20,y-50,x-20,y-20);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                //CurvaA
                CubicCurve a = new CubicCurve(x+2,y-35,x-6,y+30,x+9,y+100,x+35,y-15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //curvaB
                CubicCurve b = new CubicCurve(x+35,y-15,x+35,y-20-15,x+10,y+12-15,x+30,y+25-15);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //curvaC
                CubicCurve c = new CubicCurve(x+30,y+25-15,x+35,y+25-15,x+45,y+20-15,x+50,y);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+2) + " Y1: " + (y-35) + "\nX2: " + (x-20) + " Y2: " + (y-20) + "\n");
                Text t2 = new Text("X3: " + (x+2) + " Y3: " + (y-35) + "\nX4: " + (x+35) + " Y4: " + (y-15) + "\n");
                Text t3 = new Text("X5: " + (x+35) + " Y5: " + (y-15) + "\nX6: " + (x+30) + " Y6: " + (y+10) + "\n");
                Text t4 = new Text("X7: " + (x+30) + " Y7: " + (y+10) + "\nX8: " + (x+50) + " Y8: " + (y) + "\n\n");
                fun(root,puntosDeControl,x+2,y-35,x-20,y-20,x+2,y-35,x+35,y-15,x+35,y-15,x+30,y+10,x+30,y+10,x+50,y);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                //espaciocaracter v
                x=x+50;

            }
        }
        if(caracter == 'w' || caracter == 'W'){
            if(caracter == 'w'){
                //CurvaA
                CubicCurve a = new CubicCurve(x+4,y,x-6,y+30,x+9,y+80,x+24,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);
                //curvaA
                CubicCurve b = new CubicCurve(x+24,y+15, x+20, y+73,x+40,y+83,x+50,y);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //curvaB
                CubicCurve c = new CubicCurve(x+50,y,x+50,y-20,x+25,y+12,x+45,y+25);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //curvaC
                CubicCurve d = new CubicCurve(x+45,y+25,x+50,y+25,x+60,y+20,x+65,y+15);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+4) + " Y1: " + (y) + "\nX2: " + (x+24) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+24) + " Y3: " + (y+15) + "\nX4: " + (x+50) + " Y4: " + (y) + "\n");
                Text t3 = new Text("X5: " + (x+50) + " Y5: " + (y) + "\nX6: " + (x+45) + " Y6: " + (y+25) + "\n");
                Text t4 = new Text("X7: " + (x+45) + " Y7: " + (y+25) + "\nX7: " + (x+65) + " Y7: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x+4,y,x+24,y+15,x+24,y+15,x+50,y,x+50,y,x+45,y+25,x+45,y+25,x+65,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                //espaciocaracter v
                x=x+65;

            }
            else{
                //CurvaA
                CubicCurve a = new CubicCurve(x+2,y-35,x-6,y+30,x+9,y+80,x+24+5,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);
                //curvaA
                CubicCurve b = new CubicCurve(x+30,y, x+25, y+73,x+45,y+83,x+60,y-13);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);
                //CurvaC
                CubicCurve d = new CubicCurve(x+2,y-35,x+10,y-60,x-20,y-50,x-20,y-20);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                //curvaB
                CubicCurve c = new CubicCurve(x+35+25,y-15,x+35+25,y-20-15,x+10+25,y+12-15,x+30+25,y+25-15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //curvaC
                CubicCurve e = new CubicCurve(x+30+25,y+25-15,x+35+25,y+25-15,x+45+25,y+20-15,x+50+25,y);
                e.setFill(Color.TRANSPARENT);
                e.setStroke(color);
                e.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+2) + " Y1: " + (y-35) + "\nX2: " + (x+29) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+30) + " Y3: " + (y+25) + "\nX4: " + (x+60) + " Y4: " + (y-13) + "\n");
                Text t3 = new Text("X5: " + (x+2) + " Y5: " + (y-35) + "\nX6: " + (x-20) + " Y6: " + (y-20) + "\n");
                Text t4 = new Text("X7: " + (x+55) + " Y7: " + (y-15) + "\nX8: " + (x+55) + " Y8: " + (y+10) + "\n");
                Text t5 = new Text("X9: " + (x+55) + " Y9: " + (y+10) + "\nX10: " + (x+75) + " Y10: " + (y) + "\n\n");
                fun(root,puntosDeControl,x+2,y-35,x+29,y+15,x+30,y+25,x+60,y-13,x+2,y-35,x-20,y-20,x+55,y-15,x+55,y+10,x+55,y+10,x+75,y);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);
                t5.setFill(Color.ORANGE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);


                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                root.getChildren().add(e);

                x=x+70;
            }
        }
        if(caracter == 'x' || caracter == 'X'){
            if(caracter == 'x' ){
                //curva a
                CubicCurve a = new CubicCurve(x-3,y+10,x+45,y+100,x+50,y+50,x+60,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //curva b
                QuadCurve b = new QuadCurve(x+5,y+50, x+30, y+10,x+45,y);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x-3) + " Y1: " + (y+10) + "\nX2: " + (x+60) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+5) + " Y3: " + (y+50) + "\nX4: " + (x+45) + " Y4: " + (y) + "\n\n");

                fun(root,puntosDeControl,x-3,y+10,x+60,y+15,x+5,y+50,x+45,y);

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                //tamaÃ±ocaracter x
                x=x+60;
            }
            else{
                //curva a
                CubicCurve a = new CubicCurve(x+2,y-35,x+45,y+100,x+50,y+50,x+80,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //curva b
                QuadCurve b = new QuadCurve(x,y+50, x-10, y,x+45,y-50);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurvaC
                CubicCurve c = new CubicCurve(x+2,y-35,x-5,y-60,x-20,y-50,x-20,y-20);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+2) + " Y1: " + (y-35) + "\nX2: " + (x+80) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y+50) + "\nX4: " + (x+45) + " Y4: " + (y-50) + "\n");
                Text t3 = new Text("X5: " + (x+2) + " Y5: " + (y-35) + "\nX6: " + (x-20) + " Y6: " + (y-20) + "\n\n");
                fun(root,puntosDeControl,x+2,y-35,x+80,y+15,x,y+50,x+45,y-50,x+2,y-35,x-20,y-20);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //tamaÃ±ocaracter x
                x=x+80;

            }
        }
        if(caracter == 'y' || caracter == 'Y'){
            if(caracter == 'y'){
                //curvaA
                CubicCurve a = new CubicCurve(x+2,y,x-6,y+30,x+9,y+80,x+24,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+24,y,x+35,y+113,x-40,y+98,x+24,y+50);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                QuadCurve c = new QuadCurve(x+23,y+51, x+35, y+50,x+45,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+2) + " Y1: " + (y) + "\nX2: " + (x+24) + " Y2: " + (y+15) + "\n");
                Text t2 = new Text("X3: " + (x+24) + " Y3: " + (y) + "\nX4: " + (x+24) + " Y4: " + (y+50) + "\n");
                Text t3 = new Text("X5: " + (x+23) + " Y5: " + (y+51) + "\nX6: " + (x+45) + " Y7: " + (y+15) + "\n\n");
                fun(root,puntosDeControl,x+2,y,x+24,y+15,x+24,y,x+24,y+50,x+23,y+51,x+45,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //espaciocaracter v
                x=x+45;
            }
            else{
                //curvaA
                CubicCurve a = new CubicCurve(x+2,y-35,x-6,y+30-50,x+9,y+80-50,x+30,y+15-50);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+30,y-50,x+30,y+140-50,x-40+5,y+105-50,x+25,y+10);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                QuadCurve c = new QuadCurve(x+23+5,y+10, x+40, y+10,x+50,y);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //CurvaC
                CubicCurve d = new CubicCurve(x+2,y-35,x+10,y-60,x-20,y-50,x-20,y-20);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+2) + " Y1: " + (y-35) + "\nX2: " + (x+30) + " Y2: " + (y-35) + "\n");
                Text t2 = new Text("X3: " + (x+30) + " Y3: " + (y-50) + "\nX4: " + (x+25) + " Y4: " + (y+10) + "\n");
                Text t3 = new Text("X5: " + (x+28) + " Y5: " + (y+10) + "\nX6: " + (x+50) + " Y6: " + (y) + "\n");
                Text t4 = new Text("X7: " + (x+2) + " Y7: " + (y-35) + "\nX8: " + (x-20) + " Y8: " + (y-20) + "\n\n");
                fun(root,puntosDeControl,x+2,y-35,x+30,y-35,x+30,y-50,x+25,y+10,x+28,y+10,x+50,y,x+2,y-35,x-20,y-20);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                x=x+46;

            }
        }
        if(caracter == 'z' || caracter == 'Z'){
            if(caracter == 'z' ){
                //CurvA
                CubicCurve a = new CubicCurve(x-1,y+10,x,y-21,x-32,y+40,x+40,y);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //curvaB
                Line b = new Line(x+40,y,x+7,y+47);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //CurvC
                CubicCurve c = new CubicCurve(x+7,y+47,x+50,y+10,x+45,y+80,x+35,y+90);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //CurvD
                CubicCurve d = new CubicCurve(x+35,y+90,x+15,y+120,x-15,y+45,x+40,y+50);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                //curvaE
                QuadCurve e = new QuadCurve(x+40,y+50,x+55,y+50,x+60,y+15);
                e.setFill(Color.TRANSPARENT);
                e.setStroke(color);
                e.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x-1) + " Y1: " + (y+10) + "\nX2: " + (x+40) + " Y2: " + (y) + "\n");
                Text t2 = new Text("X3: " + (x+40) + " Y3: " + (y) + "\nX4: " + (x+7) + " Y4: " + (y+47) + "\n");
                Text t3 = new Text("X5: " + (x+7) + " Y5: " + (y+47) + "\nX6: " + (x+35) + " Y6: " + (y+90) + "\n");
                Text t4 = new Text("X7: " + (x+35) + " Y7: " + (y+90) + "\nX8: " + (x+40) + " Y8: " + (y+50) + "\n");
                Text t5 = new Text("X9: " + (x+40) + " Y9: " + (y+50) + "\nX10: " + (x+60) + " Y10: " + (y+15) + "\n\n");

                fun(root,puntosDeControl,x-1,y+10,x+40,y,x+40,y,x+7,y+47,x+7,y+47,x+35,y+90,x+35,y+90,x+40,y+50,x+40,y+50,x+60,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);
                t5.setFill(Color.ORANGE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                root.getChildren().add(e);

                //largo de z
                x=x+60;
            }
            else{
                QuadCurve a = new QuadCurve(x,y-50,x+25,y-45,x+65,y-50);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                QuadCurve b = new QuadCurve(x+65,y-50,x+25,y-45,x,y+50);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x,y+50,x+10,y+20,x+50,y+100,x+65,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve d = new CubicCurve(x,y+50-35,x+10,y+20-35,x+20,y+40,x+40,y+15);
                d.setFill(Color.TRANSPARENT);
                d.setStroke(color);
                d.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x) + " Y1: " + (y-50) + "\nX2: " + (x+65) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X1: " + (x+65) + " Y1: " + (y-50) + "\nX2: " + (x) + " Y2: " + (y+50) + "\n");
                Text t3 = new Text("X1: " + (x+50) + " Y1: " + (y+10) + "\nX2: " + (x+65) + " Y2: " + (y+15) + "\n");
                Text t4 = new Text("X1: " + (x) + " Y1: " + (y+15) + "\nX2: " + (x+40) + " Y2: " + (y+15) + "\n");

                fun(root,puntosDeControl,x,y-50,x+65,y-50,x+65,y-50,x,y+50,x+50,y+10,x+65,y+15,x,y+15,x+40,y+15);

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);
                t4.setFill(Color.GREEN);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                x=x+65;
            }
        }
        if(caracter == '(' || caracter == ')'){
            if (caracter == '('){
                QuadCurve qv1 = new QuadCurve(x+20, y-50, x, y, x+20, y + 50);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+20) + " Y1: " + (y-50) + "\nX2: " + (x+20) + " Y2: " + (y+50) + "\n\n");

                textoCoord.getChildren().add(t1);

                root.getChildren().add(qv1);
                fun(root,puntosDeControl,x+20,y-50,x+20,y+50);

                x = x + 30;
            }
            else{
                QuadCurve qv1 = new QuadCurve(x+5, y-50, x+25, y, x+5, y + 50);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+5) + " Y1: " + (y-50) + "\nX2: " + (x+5) + " Y2: " + (y+50) + "\n\n");

                textoCoord.getChildren().add(t1);

                root.getChildren().add(qv1);
                fun(root,puntosDeControl,x+5,y-50,x+5,y+50);

                x = x + 25;
            }
        }
        if(caracter == '[' || caracter == ']'){
            if (caracter == '['){
                Line l1 = new Line(x, y-50, x, y+50);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Line l2 = new Line(x, y-50, x+20, y-50);
                l2.setFill(Color.TRANSPARENT);
                l2.setStroke(color);
                l2.setStrokeWidth(grosor);

                Line l3 = new Line(x, y+50, x+20, y+50);
                l3.setFill(Color.TRANSPARENT);
                l3.setStroke(color);
                l3.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x) + " Y1: " + (y-50) + "\nX2: " + (x) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y-50) + "\nX4: " + (x+20) + " Y4: " + (y-50) + "\n");
                Text t3 = new Text("X5: " + (x) + " Y5: " + (y+50) + "\nX6: " + (x+20) + " Y6: " + (y+50) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(l1);
                root.getChildren().add(l2);
                root.getChildren().add(l3);
                fun(root,puntosDeControl,x,y-50,x,y+50,x,y-50,x+20,y-50,x,y+50,x+20,y+50);

                x = x + 30;
            }
            else{
                Line l1 = new Line(x+20, y-50, x+20, y+50);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Line l2 = new Line(x, y-50, x+20, y-50);
                l2.setFill(Color.TRANSPARENT);
                l2.setStroke(color);
                l2.setStrokeWidth(grosor);

                Line l3 = new Line(x, y+50, x+20, y+50);
                l3.setFill(Color.TRANSPARENT);
                l3.setStroke(color);
                l3.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+20) + " Y1: " + (y-50) + "\nX2: " + (x+20) + " Y2: " + (y+50) + "\n");
                Text t2 = new Text("X3: " + (x) + " Y3: " + (y-50) + "\nX4: " + (x+20) + " Y4: " + (y-50) + "\n");
                Text t3 = new Text("X5: " + (x) + " Y5: " + (y+50) + "\nX6: " + (x+20) + " Y6: " + (y+50) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(l1);
                root.getChildren().add(l2);
                root.getChildren().add(l3);
                fun(root,puntosDeControl,x+20,y-50,x+20,y+50,x,y-50,x+20,y-50,x,y+50,x+20,y+50);

                x = x + 35;
            }
        }
        if(caracter == '-' || caracter == '_'){
            if (caracter == '-'){
                Line l1 = new Line(x+10, y+25, x+40, y+25);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+25) + "\nX2: " + (x+40) + " Y2: " + (y+25) + "\n\n");

                textoCoord.getChildren().add(t1);

                root.getChildren().add(l1);
                fun(root,puntosDeControl,x+10,y+25,x+40,y+25);

                x = x + 55;
            }
            else{
                Line l1 = new Line(x+10, y+50, x+60, y+50);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+50) + "\nX2: " + (x+60) + " Y2: " + (y+50) + "\n\n");

                textoCoord.getChildren().add(t1);

                root.getChildren().add(l1);
                fun(root,puntosDeControl,x+10,y+50,x+60,y+50);

                x = x + 70;
            }
        }
        if(caracter == '<' || caracter == '>'){
            if (caracter == '<'){
                Line l1 = new Line(x+10, y+25, x+50, y);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Line l2 = new Line(x+10, y+25, x+50, y+50);
                l2.setFill(Color.TRANSPARENT);
                l2.setStroke(color);
                l2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+25) + "\nX2: " + (x+50) + " Y2: " + (y) + "\n");
                Text t2 = new Text("X3: " + (x+10) + " Y3: " + (y+25) + "\nX4: " + (x+50) + " Y4: " + (y+50) + "\n\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(l1);
                root.getChildren().add(l2);
                fun(root,puntosDeControl,x+10,y+25,x+50,y,x+10,y+25,x+50,y+50);

                x = x + 65;
            }
            else{
                Line l1 = new Line(x+10, y, x+50, y+25);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);

                Line l2 = new Line(x+10, y+50, x+50, y+25);
                l2.setFill(Color.TRANSPARENT);
                l2.setStroke(color);
                l2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y) + "\nX2: " + (x+50) + " Y2: " + (y+25) + "\n");
                Text t2 = new Text("X3: " + (x+10) + " Y3: " + (y+50) + "\nX4: " + (x+50) + " Y4: " + (y+25) + "\n\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(l1);
                root.getChildren().add(l2);
                fun(root,puntosDeControl,x+10,y,x+50,y+25,x+10,y+50,x+50,y+25);

                x = x + 65;
            }
        }
        if(caracter == '.' || caracter == ','){
            Circle cd1;
            if (caracter == '.'){
                cd1 = new Circle(x + 10, y + 50, grosor - 1);
                cd1.setFill(color);
                cd1.setStroke(color);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+50) +"\n\n");
                fun(root,puntosDeControl,x+10,y+50);

                textoCoord.getChildren().add(t1);
            }
            else{
                cd1 = new Circle(x + 15, y + 50, grosor - 1);
                cd1.setFill(color);
                cd1.setStroke(color);

                QuadCurve qv1 = new QuadCurve(x+15, y+50, x+14, y+60, x+10, y + 65);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+15) + " Y1: " + (y+50) + "\n");
                Text t2 = new Text("X2: " + (x+15) + " Y2: " + (y+50) + "\nX3: " + (x+10) + " Y3: " + (y+65) + "\n\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(qv1);
                fun(root,puntosDeControl,x+15,y+50,x+15,y+50,x+10,y+65);

            }
            root.getChildren().add(cd1);
            x = x + 20;
        }
        if(caracter == ':' || caracter == ';'){

            Circle cd1 = new Circle(x + 20, y+10, grosor - 1);
            cd1.setFill(color);
            cd1.setStroke(color);

            Circle cd2 = new Circle(x + 20, y+50, grosor - 1);
            cd2.setFill(color);
            cd2.setStroke(color);

            if (caracter == ';'){
                QuadCurve qv1 = new QuadCurve(x+20, y+50, x+19, y+60, x+15, y + 65);
                qv1.setFill(Color.TRANSPARENT);
                qv1.setStroke(color);
                qv1.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+20) + " Y1: " + (y+10) + "\n");
                Text t2 = new Text("X2: " + (x+20) + " Y2: " + (y+50) + "\n");
                Text t3 = new Text("X3: " + (x+20) + " Y3: " + (y+50) + "\nX4: " + (x+15) + " Y4: " + (y+65) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(qv1);
                fun(root,puntosDeControl,x+20,y+10,x+20,y+50,x+20,y+50,x+15,y+65);
            }
            else{
                Text t1 = new Text(caracter +"\n"+"X1: " + (x+20) + " Y1: " + (y+10) + "\n");
                Text t2 = new Text("X2: " + (x+20) + " Y2: " + (y+50) + "\n\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                fun(root,puntosDeControl,x+20,y+10,x+20,y+50);

            }

            root.getChildren().add(cd1);
            root.getChildren().add(cd2);
            x = x + 30;
        }
        if(caracter == '{' || caracter == '}'){
            if (caracter == '{'){
                CubicCurve c1 = new CubicCurve(x+25, y-50, x+10, y-50, x+30, y, x+5, y); // Curva Superior
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+25, y+50, x+10, y+50, x+30, y, x+5, y); // Curva Superior
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+25) + " Y1: " + (y-50) + "\nX2: " + (x+5) + " Y2: " + (y) + "\n");
                Text t2 = new Text("X3: " + (x+25) + " Y3: " + (y+50) + "\nX4: " + (x+5) + " Y4: " + (y) + "\n\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(c1);
                root.getChildren().add(c2);
                fun(root,puntosDeControl,x+25,y-50,x+5,y,x+25,y+50,x+5,y);

                x = x + 40;
            }
            else{
                CubicCurve c1 = new CubicCurve(x+25, y, x, y, x+25, y-50, x+5, y-50); // Curva Superior
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+25, y, x, y, x+25, y+50, x+5, y+50); // Curva Superior
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+25) + " Y1: " + (y) + "\nX2: " + (x+5) + " Y2: " + (y-50) + "\n");
                Text t2 = new Text("X1: " + (x+25) + " Y1: " + (y) + "\nX2: " + (x+5) + " Y2: " + (y+50) + "\n");

                t2.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);

                root.getChildren().add(c1);
                root.getChildren().add(c2);

                fun(root,puntosDeControl,x+25,y,x+5,y-50,x+25,y,x+5,y+50);

                x = x + 40;
            }
        }
        if(caracter == '"' ||caracter =='\''){
            int rep = 0;
            if(caracter == '\''){
               rep = 1;
            }
            else{
                rep = 2;
            }
            for(int j = 0;j<rep;j++) {
                if (aux == 0) {
                    QuadCurve a = new QuadCurve(x + 5, y - 20, x, y - 35, x + 5, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    CubicCurve b = new CubicCurve(x+5,y-20,x+25,y+15,x+35,y-20,x+7,y-20);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    Text t1 = new Text(caracter +"\n"+"X1: " + (x+5) + " Y1: " + (y-20) + "\nX2: " + (x+5) + " Y2: " + (y-50) + "\n");
                    Text t2 = new Text("X3: " + (x+5) + " Y3: " + (y-20) + "\nX4: " + (x+7) + " Y4: " + (y-20) + "\n\n");

                    t2.setFill(Color.RED);

                    textoCoord.getChildren().add(t1);
                    textoCoord.getChildren().add(t2);

                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    fun(root,puntosDeControl,x+5,y-20,x+5,y-50,x+5,y+20);
                    x = x + 25;
                } else {
                    QuadCurve a = new QuadCurve(x + 5, y - 20, x + 10, y - 35, x + 5, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    CubicCurve b = new CubicCurve(x+5,y-50,x-25,y-90,x-25,y-40,x+3,y-50);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    Text t3 = new Text(caracter+"\n"+"X1: " + (x+5) + " Y1: " + (y-20) + "\nX2: " + (x+5) + " Y2: " + (y-50) + "\n");
                    Text t4 = new Text("X3: " + (x+5) + " Y3: " + (y-50) + "\nX4: " + (x+3) + " Y4: " + (y-50) + "\n\n");

                    t4.setFill(Color.RED);
                    
                    textoCoord.getChildren().add(t3);
                    textoCoord.getChildren().add(t4);

                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    fun(root,puntosDeControl,x+5,y-20,x+5,y-50,x+5,y-50);
                    x = x + 25;
                }
            }
            x=x+20;
            if(aux == 0){
                aux = 1;
            }
            else{
                aux = 0;
            }

        }
        if(caracter == '¡' || caracter == '!'){
            if(caracter == '¡'){
                Circle a = new Circle(x+10, y, 2);
                a.setFill(color);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                QuadCurve b = new QuadCurve(x+10,y+10,x+5,y+80,x+10,y+80);
                b.setFill(color);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                QuadCurve c = new QuadCurve(x+10,y+10,x+15,y+80,x+10,y+80);
                c.setFill(color);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+10) + "\nX2: " + (x+10) + " Y2: " + (y+80) + "\n");
                Text t2 = new Text("X3: " + (x+10) + " Y3: " + (y) +"\n");
                Text t3 = new Text("X4: " + (x+10) + " Y4: " + (y+10) + "\nX5: " + (x+10) + " Y5: " + (y+80) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                fun(root,puntosDeControl,x+10,y+10,x+10,y+80,x+10,y,x+10,y+10,x+10,y+80);
                x = x +25;
            }
            else{
                Circle a = new Circle(x+10, y+80, 2);
                a.setFill(color);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                QuadCurve b = new QuadCurve(x+10,y+70,x+5,y,x+10,y);
                b.setFill(color);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                QuadCurve c = new QuadCurve(x+10,y+70,x+15,y,x+10,y);
                c.setFill(color);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y+80) + "\n");
                Text t2 = new Text("X1: " + (x+10) + " Y1: " + (y+70) + "\nX2: " + (x+10) + " Y2: " + (y) + "\n");
                Text t3 = new Text("X1: " + (x+10) + " Y1: " + (y+70) + "\nX2: " + (x+10) + " Y2: " + (y) + "\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                fun(root,puntosDeControl,x+10,y+80,x+10,y+70,x+10,y,x+10,y+70,x+10,y);
                x = x +25;

            }
        }
        if(caracter == '¿' || caracter == '?'){
            if(caracter == '¿'){
                Circle a = new Circle(x+10, y, 2);
                a.setFill(color);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                CubicCurve b = new CubicCurve(x+7,y+30,x,y,x+25,y,x,y+50);
                b.setFill(color);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x,y+50,x-15,y+90,x+30,y+90,x+25,y+60);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+10) + " Y1: " + (y) + "\n");
                Text t2 = new Text("X2: " + (x+7) + " Y2: " + (y+30) + "\nX3: " + (x) + " Y3: " + (y+50) + "\n");
                Text t3 = new Text("X4: " + (x) + " Y4: " + (y+50) + "\nX5: " + (x+25) + " Y5: " + (y+60) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                fun(root,puntosDeControl,x+10,y,x+7,y+30,x,y+50,x,y+50,x+25,y+60);
                x=x+45;
            }
            else{
                Circle a = new Circle(x+30, y+80, 2);
                a.setFill(color);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                CubicCurve b = new CubicCurve(x+27,y+50,x+20,y+75,x+35,y+80,x+30,y+47);
                b.setFill(color);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x+27,y+50,x+65,y-15,x+5,y-20,x+10,y+20);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                Text t1 = new Text(caracter +"\n"+"X1: " + (x+30) + " Y1: " + (y+80) +"\n");
                Text t2 = new Text("X2: " + (x+27) + " Y2: " + (y+50) + "\nX3: " + (x+30) + " Y3: " + (y+47) + "\n");
                Text t3 = new Text("X4: " + (x+27) + " Y4: " + (y+50) + "\nX5: " + (x+10) + " Y5: " + (y+20) + "\n\n");

                t2.setFill(Color.RED);
                t3.setFill(Color.BLUE);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                fun(root,puntosDeControl,x+30,y+80,x+27,y+50,x+30,y+47,x+27,y+50,x+10,y+20);
                x=x+45;
            }
        }
    }
}