package codigo.proyecto;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class Dibujo {

    int x = 30;
    int y = 100;
    //int yi = 100;
    int aux = 0;
    int grosor = 4;
    //variables para el subrayado
    boolean auxSub=false;
    int xInicialSu=0;
    int yInicialSu=0;
    //-----------------------
    //variables para negrita
    int auxBold = 1;
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

    public void fun(AnchorPane root, ToggleButton puntosdeControl, int... lista){

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

    public void BotonAct(ToggleButton puntosdeControl) {

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

    public void Subrayar(int xa,int ya,int xb,int yb, AnchorPane root){
        Line subrayado = new Line(xa,ya,xb,yb+55);
        subrayado.setFill(Color.TRANSPARENT);
        subrayado.setStroke(color);
        subrayado.setStrokeWidth(grosor);
        root.getChildren().add(subrayado);
    }

    public void Letras(char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl, int borrar, ScrollPane scrollPane) {

        if (borrar == 1) {
            x = 30;
            y = 100;
        }
        if (x >= scrollPane.getWidth() - 120) {
            if (caracter != ' ' && caracterAnt != ' ') {
                Line l1 = new Line(x + 20, y + 30, x + 50, y + 30);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);
                root.getChildren().add(l1);
            }
            x = 30;
            y = y + 150;
            xInicialSu = x;
            yInicialSu = y + 55;
        }
        if (caracter == ' ') {
            if (x != 30) {
                x = x + 50;
            }
            auxSub = false;
            auxBold = 1;
        }

        int cont = 0;
        if (caracter == 'a' || caracter == 'A' || caracter == 'á' || caracter == 'Á') {
            
            if (caracter == 'a' || caracter == 'á') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30, y+10, x+25, y+30, x-5, y-30, x-20, y+85);
                pts(textoCoord, root, puntosDeControl, x+35, y, x+60, y+15, x+10, y+60, x+50, y+65);

                fun(root, puntosDeControl, x + 30, y + 10, x - 5, y - 30, x - 20, y + 85, x + 25, y + 30, x + 35, y, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);

                while(cont < auxBold){
                    CubicCurve c = new CubicCurve(x + 30, y + 10, x - 5, y - 30, x - 20, y + 85, x + 25, y + 30);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 35, y, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);

                    if (caracter == 'á') {
                        Line tilde = new Line(x + 15, y - 10, x + 30, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+15, y-10, x+30, y-30);
                            fun(root, puntosDeControl, x + 15, y - 10, x + 30, y - 30);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }


            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                pts(textoCoord, root, puntosDeControl, x, y+50, x+30, y-50, x+20, y+60, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+65, y+15, x+50, y-60, x+40, y+120);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+44, y, x+10, y-10, x+30, y+30);

                fun(root, puntosDeControl, x, y + 50, x + 20, y + 60, x + 20, y - 50, x + 30, y - 50, x + 30, y - 50, x + 50, y - 60, x + 40, y + 120, x + 65, y + 15, x, y + 15, x + 10, y - 10, x + 30, y + 30, x + 44, y);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y + 50, x + 20, y + 60, x + 20, y - 50, x + 30, y - 50); // IZQ
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 30, y - 50, x + 50, y - 60, x + 40, y + 120, x + 65, y + 15); // DER
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x, y + 15, x + 10, y - 10, x + 30, y + 30, x + 44, y); // MED
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);



                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if (caracter == 'Á') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'b' || caracter == 'B') {

            if (caracter == 'b') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                fun(root, puntosDeControl, x, y + 15, x + 70, y - 80, x - 10, y - 80, x, y + 50, x, y + 30, x + 50, y - 50, x + 35, y + 100, x + 5, y + 50, x + 5, y + 50, x, y + 30, x + 60, y + 50, x + 60, y + 20);

                pts(textoCoord, root, puntosDeControl, x, y+15, x, y+50, x+70, y-80, x-10, y-80);
                pts(textoCoord, root, puntosDeControl, x, y+30, x+5, y+50, x+50, y-50, x+35, y+100);
                pts(textoCoord, root, puntosDeControl, x+5, y+50, x+60, y+20, x, y+30, x+60, y+50);


                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 70, y - 80, x - 10, y - 80, x, y + 50); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x, y + 30, x + 50, y - 50, x + 35, y + 100, x + 5, y + 50);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 5, y + 50, x, y + 30, x + 60, y + 50, x + 60, y + 20);
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                pts(textoCoord, root, puntosDeControl, x+30, y-20, x+40, y+50, x+30, y+50);
                pts(textoCoord, root, puntosDeControl, x+40, y+50, x+30, y+20, x+60, y+60, x+80, y-10);
                pts(textoCoord, root, puntosDeControl, x+20, y+10, x+30, y-50, x-10, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+30, y+20, x+70, y-50, x+70, y);
                pts(textoCoord, root, puntosDeControl, x+58, y+40, x+80, y+15, x+70, y+60);


                fun(root, puntosDeControl, x + 30, y - 20, x + 30, y + 50, x + 40, y + 50, x + 40, y + 50, x + 60, y + 60, x + 80, y - 10, x + 30, y + 20, x + 20, y + 10, x - 10,
                        y + 10, x, y - 50, x + 30, y - 50, x + 30, y - 50, x + 70, y - 50, x + 70, y, x + 30, y + 20, x + 58, y + 40, x + 70, y + 60, x + 80, y + 15);

                while(cont < auxBold) {
                    QuadCurve c = new QuadCurve(x + 30, y - 20, x + 30, y + 50, x + 40, y + 50); // inferior b
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 40, y + 50, x + 60, y + 60, x + 80, y - 10, x + 30, y + 20); // guata b
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 20, y + 10, x - 10, y + 10, x, y - 50, x + 30, y - 50); // izq sombrero
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 30, y - 50, x + 70, y - 50, x + 70, y, x + 30, y + 20); // der sombrero
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    QuadCurve c5 = new QuadCurve(x + 58, y + 40, x + 70, y + 60, x + 80, y + 15);
                    c5.setFill(Color.TRANSPARENT);
                    c5.setStroke(color);
                    c5.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);
                    root.getChildren().add(c5);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'c' || caracter == 'C') {

            if (caracter == 'c') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+25, y+15, x, y-20, x+40, y-5);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+60, y+15, x, y+45, x+30, y+80);

                fun(root, puntosDeControl, x, y + 25, x, y - 20, x + 40, y - 5, x + 25, y + 15, x, y + 25, x, y + 45, x + 30, y + 80, x + 60, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y + 25, x, y - 20, x + 40, y - 5, x + 25, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c1 = new CubicCurve(x, y + 25, x, y + 45, x + 30, y + 80, x + 60, y + 15);
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c1);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+60, y+15, x-25, y-10, x+10, y+110);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+10, y, x+45, y-60, x+75, y-35);
                pts(textoCoord, root, puntosDeControl, x+10, y, x, y-40, x-20, y+10, x-20, y-30);

                fun(root, puntosDeControl, x + 20, y - 40, x - 25, y - 10, x + 10, y + 110, x + 60, y + 15, x + 20, y - 40, x + 45, y - 60, x + 75, y - 35, x + 10, y, x + 10, y, x - 20, y + 10, x - 20, y - 30, x, y - 40);


                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 20, y - 40, x - 25, y - 10, x + 10, y + 110, x + 60, y + 15); // C
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 20, y - 40, x + 45, y - 60, x + 75, y - 35, x + 10, y);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y, x - 20, y + 10, x - 20, y - 30, x, y - 40);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

        }
        if (caracter == 'd' || caracter == 'D') {

            if (caracter == 'd') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y+15, x+25, y+25, x-15, y-30, x, y+90);
                pts(textoCoord, root, puntosDeControl, x+25, y+5, x+25, y+25, x+80, y-50, x+20, y-80);
                pts(textoCoord, root, puntosDeControl, x+25, y+25, x+60, y+15, x+30, y+50, x+50, y+50);

                fun(root, puntosDeControl, x + 25, y + 15, x - 15, y - 30, x, y + 90, x + 25, y + 25, x + 25, y + 5, x + 80, y - 50, x + 20, y - 80, x + 25, y + 25, x + 25, y + 25, x + 30, y + 50, x + 50, y + 50, x + 60, y + 15);


                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 25, y + 15, x - 15, y - 30, x, y + 90, x + 25, y + 25);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 25, y + 5, x + 80, y - 50, x + 20, y - 80, x + 25, y + 25);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 25, y + 25, x + 30, y + 50, x + 50, y + 50, x + 60, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y+10, x+30, y-50, x-10, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+50, y+50, x+80, y-50, x+80, y+50);
                pts(textoCoord, root, puntosDeControl, x+50, y+50, x+30, y-30, x+30, y+50, x+30, y+50);

                fun(root, puntosDeControl, x + 20, y + 10, x - 10, y + 10, x, y - 50, x + 30, y - 50, x + 30, y - 50, x + 80, y - 50, x + 80, y + 50, x + 50, y + 50, x + 50, y + 50, x + 30, y + 50, x + 30, y + 50, x + 30, y - 30);

                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x + 20, y + 10, x - 10, y + 10, x, y - 50, x + 30, y - 50); // izq sombrero
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 30, y - 50, x + 80, y - 50, x + 80, y + 50, x + 50, y + 50); // izq sombrero
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 50, y + 50, x + 30, y + 50, x + 30, y + 50, x + 30, y - 30); // izq sombrero
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);


                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 90;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'e' || caracter == 'E' || caracter == 'é' || caracter == 'É') {

            if (caracter == 'e' || caracter == 'é') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+2, y+30, x-5, y-20, x+53, y);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+50, y+15, x, y+50, x+40, y+70);

                fun(root, puntosDeControl, x, y + 25, x - 5, y - 20, x + 53, y, x + 2, y + 30, x, y + 25, x, y + 50, x + 40, y + 70, x + 50, y + 15);
                while(cont < auxBold) {
                    CubicCurve b = new CubicCurve(x, y + 25, x - 5, y - 20, x + 53, y, x + 2, y + 30);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 25, x, y + 50, x + 40, y + 70, x + 50, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if (caracter == 'é') {
                        Line tilde = new Line(x + 20, y - 10, x + 35, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20, y-10, x+35, y-30);
                            fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y-10, x+60, y+15, x-20, y-10, x, y+120);
                pts(textoCoord, root, puntosDeControl, x+25, y-10, x+20, y-50, x-20, y-10, x+10, y-50);

                fun(root, puntosDeControl, x + 25, y - 10, x - 20, y - 10, x, y + 120, x + 60, y + 15, x + 25, y - 10, x - 20, y - 10, x + 10, y - 50, x + 20, y - 50, x + 20, y - 50, x + 40, y - 50, x + 30, y - 10, x, y - 50);
                while(cont < auxBold) {
                    CubicCurve c2 = new CubicCurve(x + 25, y - 10, x - 20, y - 10, x, y + 120, x + 60, y + 15);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 25, y - 10, x - 20, y - 10, x + 10, y - 50, x + 20, y - 50);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 20, y - 50, x + 40, y - 50, x + 30, y - 10, x, y - 50);
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if (caracter == 'É') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);


                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

            //tamaÃ±o caracter
        }
        if (caracter == 'f' || caracter == 'F') {

            if (caracter == 'f') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+10, x, y+10, x, y-60, x+60, y-60);
                pts(textoCoord, root, puntosDeControl, x, y, x+2, y+15, x, y+110, x+50, y+60);
                pts(textoCoord, root, puntosDeControl, x+2, y+25, x+50, y+15, x+35, y+60);

                fun(root, puntosDeControl, x, y + 10, x, y - 60, x + 60, y - 60, x, y + 10, x, y, x, y + 110, x + 50, y + 60, x + 2, y + 15, x + 2, y + 25, x + 35, y + 60, x + 50, y + 15);


                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x, y + 10, x, y - 60, x + 60, y - 60, x, y + 10); // Curva Superior
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x, y, x, y + 110, x + 50, y + 60, x + 2, y + 15); // Curva inferior
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    QuadCurve c3 = new QuadCurve(x + 2, y + 25, x + 35, y + 60, x + 50, y + 15); // Conexion
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);


                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+60, y-50, x+10, y-70, x+50, y-10);
                pts(textoCoord, root, puntosDeControl, x+30, y-37, x+10, y+40, x+20, y+70);
                pts(textoCoord, root, puntosDeControl, x+10, y, x+40, y);
                pts(textoCoord, root, puntosDeControl, x+10, y+10, x+50, y+15, x+20, y, x+30, y+20);


                fun(root, puntosDeControl, x, y - 40, x + 10, y - 70, x + 50, y - 10, x + 60, y - 50, x + 30, y - 37, x + 20, y + 70, x + 10, y + 40, x + 10, y, x + 40, y, x + 10, y + 10, x + 20, y, x + 30, y + 20, x + 50, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y - 40, x + 10, y - 70, x + 50, y - 10, x + 60, y - 50);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    QuadCurve c2 = new QuadCurve(x + 30, y - 37, x + 20, y + 70, x + 10, y + 40);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    Line l = new Line(x + 10, y, x + 40, y);
                    l.setFill(Color.TRANSPARENT);
                    l.setStroke(color);
                    l.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y + 10, x + 20, y, x + 30, y + 20, x + 50, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'g' || caracter == 'G') {

            if (caracter == 'g') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y+10, x+25, y+40, x-10, y-20, x-10, y+70);
                pts(textoCoord, root, puntosDeControl, x+25, y, x+10, y+80, x+35, y+90, x+10, y+90);
                pts(textoCoord, root, puntosDeControl, x+10, y+80, x+60, y+15, x+10, y+30, x+60, y+60);


                fun(root, puntosDeControl, x + 25, y + 10, x - 10, y - 20, x - 10, y + 70, x + 25, y + 40, x + 25, y, x + 35, y + 90, x + 10, y + 90, x + 10, y + 80, x + 10, y + 80, x + 10, y + 30, x + 60, y + 60, x + 60, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 25, y + 10, x - 10, y - 20, x - 10, y + 70, x + 25, y + 40); // Circulo
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 25, y, x + 35, y + 90, x + 10, y + 90, x + 10, y + 80);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y + 80, x + 10, y + 30, x + 60, y + 60, x + 60, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+40, y-50, x+70, y+10, x+60, y-50);
                pts(textoCoord, root, puntosDeControl, x+40, y-50, x+59, y+20, x, y-50, x+10, y+110);
                pts(textoCoord, root, puntosDeControl, x+60, y+10, x+30, y+80, x+60, y+100, x+20, y+100);
                pts(textoCoord, root, puntosDeControl, x+30, y+80, x+80, y+15, x+40, y+60, x+60, y+60);


                fun(root, puntosDeControl, x, y + 20, x + 70, y + 10, x + 60, y - 50, x + 40, y - 50, x + 40, y - 50, x, y - 50, x + 10, y + 110, x + 59, y + 20, x + 60, y + 10, x + 60, y + 100, x + 20, y + 100, x + 30, y + 80, x + 30, y + 80, x + 40, y + 60, x + 60, y + 60, x + 80, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y + 20, x + 70, y + 10, x + 60, y - 50, x + 40, y - 50); // mitad e
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 40, y - 50, x, y - 50, x + 10, y + 110, x + 59, y + 20); // otra mitad
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 60, y + 10, x + 60, y + 100, x + 20, y + 100, x + 30, y + 80); // mitad j
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 30, y + 80, x + 40, y + 60, x + 60, y + 60, x + 80, y + 15); // otra mitad j
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);


                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'h' || caracter == 'H') {

            if (caracter == 'h') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x, y+50, x+50, y-50, x-10, y-90);
                pts(textoCoord, root, puntosDeControl, x, y+40, x+25, y+35, x+10, y, x+25, y+5);
                pts(textoCoord, root, puntosDeControl, x+25, y+35, x+50, y+15, x+25, y+60, x+40, y+60);


                fun(root, puntosDeControl, x, y + 15, x + 50, y - 50, x - 10, y - 90, x, y + 50, x, y + 40, x + 10, y, x + 25, y + 5, x + 25, y + 35, x + 25, y + 35, x + 25, y + 60, x + 40, y + 60, x + 50, y + 15);


                while(cont < auxBold) {
                    CubicCurve c2 = new CubicCurve(x, y + 15, x + 50, y - 50, x - 10, y - 90, x, y + 50); // l
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 40, x + 10, y, x + 25, y + 5, x + 25, y + 35); // guata
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 25, y + 35, x + 25, y + 60, x + 40, y + 60, x + 50, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+20, y+40, x+10, y-60, x+30, y-30);
                pts(textoCoord, root, puntosDeControl, x+20, y+40, x+40, y, x+10, y+80, x-10, y+30);
                pts(textoCoord, root, puntosDeControl, x+40, y, x+50, y-50, x+60, y-10, x+60, x-50);
                pts(textoCoord, root, puntosDeControl, x+50, y-50, x+70, y+15, x+40, y-50, x+40, y+120);


                fun(root, puntosDeControl, x, y - 40, x + 10, y - 60, x + 30, y - 30, x + 20, y + 40, x + 20, y + 40, x + 10, y + 80, x - 10, y + 30, x + 40, y, x + 40, y, x + 60, y - 10, x + 60, y - 50, x + 50, y - 50, x + 50, y - 50, x + 40, y - 50, x + 40, y + 120, x + 70, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y - 40, x + 10, y - 60, x + 30, y - 30, x + 20, y + 40); // primera curva hacia abajo
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 20, y + 40, x + 10, y + 80, x - 10, y + 30, x + 40, y); // segunda curva
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 40, y, x + 60, y - 10, x + 60, y - 50, x + 50, y - 50);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 50, y - 50, x + 40, y - 50, x + 40, y + 120, x + 70, y + 15);
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'i' || caracter == 'I' || caracter == 'í' || caracter == 'Í') {

            if (caracter == 'i' || caracter == 'í') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x+40, y+15, x-10, y+80, x+30, y+40);

                fun(root, puntosDeControl, x + 2, y, x - 10, y + 80, x + 30, y + 40, x + 40, y + 15);
                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 2, y, x - 10, y + 80, x + 30, y + 40, x + 40, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    root.getChildren().add(c);

                    if (caracter == 'í') {
                        Line tilde = new Line(x, y - 10, x + 15, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x, y-10, x+15, y-30);
                            fun(root, puntosDeControl, x, y - 10, x + 15, y - 30);
                        }

                        root.getChildren().add(tilde);
                    } else {
                        Circle p = new Circle(x + 3, y - 10, 1);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+3, y-10);
                            fun(root, puntosDeControl, x + 3, y - 10);
                        }

                        root.getChildren().add(p);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 40;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+50, y-40, x+20, y-60, x+30, y-40);
                pts(textoCoord, root, puntosDeControl, x+50, y-40, x+40, y+20, x+70, x-40, x+50, y-120);
                pts(textoCoord, root, puntosDeControl, x+40, y+20, x, y+30, x+35, y+70, x, y+40);


                fun(root, puntosDeControl, x, y - 50, x + 20, y - 60, x + 30, y - 40, x + 50, y - 40, x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 40, y + 20, x + 40, y + 20, x + 35, y + 70, x, y + 40, x, y + 30);
                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x, y - 50, x + 20, y - 60, x + 30, y - 40, x + 50, y - 40);
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 40, y + 20);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 40, y + 20, x + 35, y + 70, x, y + 40, x, y + 30);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if (caracter == 'Í') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'j' || caracter == 'J') {

            if (caracter == 'j') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-15, y+65, x+30, y+15, x-15, y+50, x+30, y+35);
                pts(textoCoord, root, puntosDeControl, x, y+70, x-15, y+65, x-5, y+95, x-20, y+85);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+70, x-1, y+20, x+5, y+60);
                pts(textoCoord, root, puntosDeControl, x, y-10);

                fun(root, puntosDeControl, x - 15, y + 65, x - 15, y + 50, x + 30, y + 35, x + 30, y + 15, x, y + 70, x - 5, y + 95, x - 20, y + 85, x - 15, y + 65, x, y, x - 1, y + 20, x + 5, y + 60, x, y + 70);

                while(cont < auxBold) {
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


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+50, y-40, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x+50, y-40, x+40, y+30, x+70, y-40, x+50, y-120);
                pts(textoCoord, root, puntosDeControl, x+40, y+30, x+5, y+40, x+40, y+55, x+10, y+60);
                pts(textoCoord, root, puntosDeControl, x+5, y+40, x+50, y-15, x, y+20, x+15, y);
                fun(root, puntosDeControl, x, y - 40, x + 50, y - 40, x + 20, y - 50, x + 70, y - 40, x + 50, y - 120, x + 40, y + 55, x + 10, y + 60, x + 50, y - 40, x + 40, y + 30, x + 40, y + 30, x + 5, y + 40, x + 5, y + 40, x + 50, y - 15);

                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x, y - 40, x + 20, y - 50, x + 50, y - 40);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    CubicCurve cb1 = new CubicCurve(x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 40, y + 30); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 40, y + 30, x + 40, y + 55, x + 10, y + 60, x + 5, y + 40); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb4 = new CubicCurve(x + 5, y + 40, x, y + 20, x + 15, y, x + 50, y - 15);
                    cb4.setFill(Color.TRANSPARENT);
                    cb4.setStroke(color);
                    cb4.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'k' || caracter == 'K') {

            if (caracter == 'k') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x-1, y+50, x+37, y, x-3, y-150);
                pts(textoCoord, root, puntosDeControl, x, y+18, x+17, y+30, x+7, y-10, x+42, y+20);
                pts(textoCoord, root, puntosDeControl, x+17, y+30, x+55, y+15, x+37, y+72, x+47, y+50);
                fun(root, puntosDeControl, x + 2, y, x + 37, y, x - 3, y - 150, x + 7, y - 10, x + 42, y + 20, x + 37, y + 72, x + 47, y + 50, x - 1, y + 50, x, y + 18, x + 17, y + 30, x + 17, y + 30, x + 55, y + 15);

                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 2, y, x + 37, y, x - 3, y - 150, x - 1, y + 50); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x, y + 18, x + 7, y - 10, x + 42, y + 20, x + 17, y + 30); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 17, y + 30, x + 37, y + 72, x + 35, y + 50, x + 55, y + 15);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else{
                Text t = new Text("\n" + caracter + ":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y - 20, x + 10, y + 40, x + 40, y - 120, x + 40, y + 80);
                pts(textoCoord, root, puntosDeControl, x + 10, y + 40, x + 60, y - 50, x - 20, y, x + 60, y);
                pts(textoCoord, root, puntosDeControl, x + 33, y - 5, x + 80, y + 15, x + 60, y - 10, x + 60, y + 115);
                fun(root, puntosDeControl, x, y - 20, x + 40, y - 120, x + 40, y + 80, x - 20, y, x + 60, y, x + 60, y - 10, x + 60, y + 115, x + 10, y + 40, x + 10, y + 40, x + 60, y - 50, x + 33, y - 5, x + 80, y + 15);

                while (cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y - 20, x + 40, y - 120, x + 40, y + 80, x + 10, y + 40); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 10, y + 40, x - 20, y, x + 60, y, x + 60, y - 50); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 33, y - 5, x + 60, y - 10, x + 60, y + 115, x + 80, y + 15);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if (auxBold > 1) {
                        x++;
                    }

                    cont++;
                }
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            }
        }
        if (caracter == 'l' || caracter == 'L') {
            if (caracter == 'l') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x-1, y+40, x+37, y-40, x-3, y-120);
                pts(textoCoord, root, puntosDeControl, x-1, y+40, x+30, y+15, x, y+60, x+20, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 37, y - 40, x - 3, y - 120, x, y + 60, x + 20, y + 60, x - 1, y + 40, x - 1, y + 40, x + 30, y + 15);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 37, y - 40, x - 3, y - 120, x - 1, y + 40); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x - 1, y + 40, x, y + 60, x + 20, y + 60, x + 30, y + 15);  //Curva derecha (conector)
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+15, y-5, x+80, y-80, x+5, y-60);
                pts(textoCoord, root, puntosDeControl, x+15, y-5, x+20, y+50, x+15, y+100, x-30, y+10);
                pts(textoCoord, root, puntosDeControl, x+20, y+50, x+50, y+15, x+45, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 15, y + 100, x - 30, y + 10, x + 45, y + 60, x + 15, y - 5, x + 15, y - 5, x + 20, y + 50, x + 20, y + 50, x + 50, y + 15);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 80, y - 80, x + 5, y - 60, x + 15, y - 5); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 15, y - 5, x + 15, y + 100, x - 30, y + 10, x + 20, y + 50); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 20, y + 50, x + 45, y + 60, x + 50, y + 15);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            }
        }
        if (caracter == 'm' || caracter == 'M') {
            if (caracter == 'm') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x-1, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+28, y+48, x+15, y-50);
                pts(textoCoord, root, puntosDeControl, x+28, y+48, x+48, y+48, x+40, y-50);
                pts(textoCoord, root, puntosDeControl, x+48, y+48, x+70, x+15, x+50, y+60, x+68, y+65);

                fun(root, puntosDeControl, x, y, x - 1, y + 50, x + 15, y - 50, x + 40, y - 50, x + 50, y + 60, x + 68, y + 65, x + 8, y + 50, x + 8, y + 50, x + 28, y + 48, x + 28, y + 48, x + 48, y + 48, x + 48, y + 48, x + 70, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 15, y - 50, x + 28, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    QuadCurve qv3 = new QuadCurve(x + 28, y + 48, x + 40, y - 50, x + 48, y + 48);
                    qv3.setFill(Color.TRANSPARENT);
                    qv3.setStroke(color);
                    qv3.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 48, y + 48, x + 50, y + 60, x + 68, y + 65, x + 70, y + 15); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(qv3);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                pts(textoCoord, root, puntosDeControl, x+15, y+50, x+40, y+40, x+35, y-90);
                pts(textoCoord, root, puntosDeControl, x+40, y+40, x+65, y+50, x+60, y-83);

                fun(root, puntosDeControl, x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 35, y - 90, x + 60, y - 83, x + 15, y + 50, x + 15, y + 50, x + 40, y + 40, x + 40, y + 40, x + 65, y + 50);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 15, y + 50); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 35, y - 90, x + 40, y + 40);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 40, y + 40, x + 60, y - 83, x + 65, y + 50);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 78;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'n' || caracter == 'N') {
            if (caracter == 'n') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+30, y+48, x+30, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y+48, x+50, y+15, x+30, y+60, x+45, y+65);

                fun(root, puntosDeControl, x, y, x + 50, y + 50, x + 30, y - 50, x + 30, y + 60, x + 45, y + 65, x + 8, y + 50, x + 8, y + 50, x + 30, y + 48, x + 30, y + 48, x + 50, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 30, y - 50, x + 30, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 30, y + 48, x + 30, y + 60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                if(caracterAnt != '^') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                    pts(textoCoord, root, puntosDeControl, x+15, y+50, x+45, y+60, x+40, y-93);

                    fun(root, puntosDeControl, x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 40, y - 93, x + 15, y + 50, x + 15, y + 50, x + 45, y + 60);
                    while(cont < auxBold) {
                        CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 15, y + 50); // primera curva hacia
                        // abajo
                        cb1.setFill(Color.TRANSPARENT);
                        cb1.setStroke(color);
                        cb1.setStrokeWidth(grosor);

                        QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 40, y - 93, x + 45, y + 60);
                        qv1.setFill(Color.TRANSPARENT);
                        qv1.setStroke(color);
                        qv1.setStrokeWidth(grosor);

                        root.getChildren().add(cb1);
                        root.getChildren().add(qv1);

                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }
                    x = x + 55;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu, x, y, root);

                    }
                }else{
                    auxBold = 4;
                }
            }
        }
        if (caracter == 'ñ' || caracter == 'Ñ') {
            if (caracter == 'ñ') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+30, y+48, x+30, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y+48, x+50, y+15, x+30, y+60, x+45, y+65);

                fun(root, puntosDeControl, x, y, x + 50, y + 50, x + 30, y - 50, x + 30, y + 60, x + 45, y + 65, x + 8, y + 50, x + 8, y + 50, x + 30, y + 48, x + 30, y + 48, x + 50, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x, y, x - 1, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 30, y - 50, x + 30, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    CubicCurve cb1 = new CubicCurve(x + 30, y + 48, x + 30, y + 60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 15, y - 15, x + 20, y - 25, x + 25, y - 5, x + 30, y - 15);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                pts(textoCoord, root, puntosDeControl, x+15, y+50, x+45, y+60, x+40, y-93);
                pts(textoCoord, root, puntosDeControl, x+25, y-40, x+45, y-40, x+30, y-50, x+40, y-30);

                fun(root, puntosDeControl, x + 5, y + 15, x + 30, y - 50, x + 40, y - 30, x - 15, y - 70, x + 29, y - 85, x + 40, y - 93, x + 15, y + 50, x + 15, y + 50, x + 45, y + 60);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 15, y + 50); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 40, y - 93, x + 45, y + 60);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 25, y - 40, x + 30, y - 50, x + 40, y - 30, x + 45, y - 40);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'o' || caracter == 'O' || caracter == 'ó' || caracter == 'Ó') {
            if (caracter == 'o' || caracter == 'ó') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+30, y+20, x, y+60, x+30, y+60);
                pts(textoCoord, root, puntosDeControl, x+30, y+20, x, y+20, x+30, y-5, x, y-5);
                pts(textoCoord, root, puntosDeControl, x+5, y+6, x+50, y+15, x+30, y+50);

                fun(root, puntosDeControl, x, y + 20, x, y + 60, x + 30, y + 60, x + 30, y + 20, x + 30, y + 20, x + 30, y - 5, x, y - 5, x, y + 20, x + 5, y + 6, x + 30, y + 50, x + 50, y + 15);
                while(cont < auxBold) {

                    CubicCurve cb1 = new CubicCurve(x, y + 20, x, y + 60, x + 30, y + 60, x + 30, y + 20); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 30, y + 20, x + 30, y - 5, x, y - 5, x, y + 20);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 5, y + 6, x + 30, y + 50, x + 50, y + 15);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);


                    if (caracter == 'ó') {
                        Line tilde = new Line(x + 20, y - 10, x + 35, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20, y-10, x+35, y-30);
                            fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);
                        }


                        root.getChildren().add(tilde);

                    }
                    Text t8 = new Text("\n");
                    textoCoord.getChildren().add(t8);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13, y-10, x+57, y-10, x, y+70, x+57, y+70);
                pts(textoCoord, root, puntosDeControl, x+57, y-10, x+45, y+10, x+40, y-125, x-55, y+50);

                fun(root, puntosDeControl, x + 13, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10, x + 57, y - 10, x + 40, y - 125, x - 55, y + 50, x + 45, y + 10);
                while(cont < auxBold) {

                    CubicCurve cb1 = new CubicCurve(x + 13, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 57, y - 10, x + 40, y - 125, x - 55, y + 50, x + 45, y + 10); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    if (caracter == 'Ó') {
                        Line tilde = new Line(x + 20, y - 60, x + 35, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1) {
                            pts(textoCoord, root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                            fun(root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                        }
                        root.getChildren().add(tilde);
                    }
                    Text t6 = new Text("\n");
                    textoCoord.getChildren().add(t6);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'p' || caracter == 'P') {
            if (caracter == 'p') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+85, x-2, y+15);
                pts(textoCoord, root, puntosDeControl, x+1, y+15, x+25, y+50, x+40, y-15, x+35, y+50);
                pts(textoCoord, root, puntosDeControl, x+25, y+50, x+30, y+35, x, y+60, x, y+30);
                pts(textoCoord, root, puntosDeControl, x+30, y+35, x+55, y+15, x+40, y+30);

                fun(root, puntosDeControl, x, y, x, y + 85, x - 2, y + 15, x + 1, y + 15, x + 25, y + 50, x + 40, y - 15, x + 35, y + 50, x + 25, y + 50, x + 30, y + 35, x, y + 60, x, y + 30, x + 30, y + 35, x + 55, y + 15, x + 40, y + 30);
                while(cont < auxBold) {
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

                    root.getChildren().add(qv1);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+25, y+85, x, y-70, x+30, y-90);
                pts(textoCoord, root, puntosDeControl, x+24, y-20, x+26, y+30, x+60, y-110, x+70, y+60);

                fun(root, puntosDeControl, x, y + 15, x, y - 70, x + 30, y - 90, x + 60, y - 110, x + 70, y + 60, x + 25, y + 85, x + 24, y - 20, x + 26, y + 30);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x, y - 70, x + 30, y - 90, x + 25, y + 85); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 24, y - 20, x + 60, y - 110, x + 70, y + 60, x + 26, y + 30); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);


                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 58;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'q' || caracter == 'Q') {
            if (caracter == 'q') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30, y, x+30, y+85, x+28, y+28);
                pts(textoCoord, root, puntosDeControl, x+28, y+12, x+28, y+40, x-12, y-10, x-13, y+60);
                pts(textoCoord, root, puntosDeControl, x+30, y+47, x+60, y+15, x+50, y+47);
                pts(textoCoord, root, puntosDeControl, x+30, y+85, x+30, y+47, x+40, y+80, x+40, y+50);

                fun(root, puntosDeControl, x + 30, y + 85, x + 28, y + 28, x - 12, y - 10, x - 13, y + 60, x + 50, y + 47, x + 40, y + 80, x + 40, y + 50, x + 28, y + 12, x + 28, y + 40, x + 30, y + 47, x + 60, y + 15, x + 30, y + 85, x + 30, y + 47);
                while(cont < auxBold) {
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

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13, y-10, x+57, y-10, x, y+70, x+57, y+70);
                pts(textoCoord, root, puntosDeControl, x+57, y-10, x+45, y+10, x+40, y-125, x-55, y+50);
                pts(textoCoord, root, puntosDeControl, x+35, y+37, x+65, y+47, x+45, y+27, x+55, y+62);

                fun(root, puntosDeControl, x + 13, y - 10, x + 57, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10, x + 45, y + 10, x + 40, y - 125, x - 55, y + 50, x + 35, y + 37, x + 65, y + 47, x + 45, y + 27, x + 55, y + 62);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 13, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 57, y - 10, x + 40, y - 125, x - 55, y + 50, x + 45, y + 10); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 35, y + 37, x + 45, y + 27, x + 55, y + 62, x + 65, y + 47);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

        }
        if (caracter == 'r' || caracter == 'R') {
            if (caracter == 'r') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+30, y, x+30, y, x+55, y+15);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+30, y, x+30, y, x+55, y+15);

                fun(root, puntosDeControl, x + 9 - 10, y + 10, x + 10 - 10, y - 21, x - 22 - 10, y + 40, x + 30, y, x + 30, y, x + 9, y + 28, x + 25, y + 95, x + 55, y + 15);
                while(cont < auxBold) {
                    if (caracterAnt == ' ') {
                        CubicCurve a = new CubicCurve(x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        Text t6 = new Text("\nX1: " + (x + 20) + " Y1: " + (y + 40) + "\tX2: " + (x + 60) + " Y2: " + (y + 15));
                        Text t7 = new Text("\nX1: " + (x + 10) + " Y1: " + (y + 60) + "\tX2: " + (x + 50) + " Y2: " + (y + 65) + "\n");

                        t7.setFill(Color.RED);

                        textoCoord.getChildren().add(t6);
                        textoCoord.getChildren().add(t7);

                        fun(root, puntosDeControl, x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);

                        root.getChildren().add(a);
                        x = x + 60;
                        if (auxSub) {
                            Subrayar(xInicialSu, yInicialSu, x, y, root);
                        }
                    }
                    //CurvA
                    CubicCurve a = new CubicCurve(x + 9 - 10, y + 10, x + 10 - 10, y - 21, x - 22 - 10, y + 40, x + 30, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 30, y, x + 9, y + 28, x + 25, y + 95, x + 55, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //EspacioDecaracterR
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+20, y-50, x+15, y-20);
                pts(textoCoord, root, puntosDeControl, x+20, y-50, x+10, y+50, x+25, y);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+20, y, x+80, y-80, x+50, y+20);
                pts(textoCoord, root, puntosDeControl, x+20, y+40, x+60, y+55, x+40, y, x+40, y+55);
                pts(textoCoord, root, puntosDeControl, x+60, y+55, x+80, y+15, x+70, y+55);

                fun(root, puntosDeControl, x, y + 15, x + 15, y - 20, x + 20, y - 50, x + 20, y - 50, x + 25, y, x + 10, y + 50, x + 20, y - 40, x + 80, y - 80, x + 50, y + 20, x + 20, y, x + 20, y, x + 40, y, x + 40, y + 55, x + 60, y + 55, x + 60, y + 55, x + 70, y + 55, x + 80, y + 15);
                while(cont < auxBold) {//CurvA
                    QuadCurve a = new QuadCurve(x, y + 15, x + 15, y - 20, x + 20, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvB
                    QuadCurve b = new QuadCurve(x + 20, y - 50, x + 25, y, x + 10, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve c = new CubicCurve(x + 20, y - 40, x + 80, y - 80, x + 50, y + 20, x + 20, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve d = new CubicCurve(x + 20, y, x + 40, y, x + 40, y + 55, x + 60, y + 55);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //CurvB
                    QuadCurve e = new QuadCurve(x + 60, y + 55, x + 70, y + 55, x + 80, y + 15);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 's' || caracter == 'S') {
            if (caracter == 's') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y+35, x, y+15, x-40, y-15, x+40, y-15);
                pts(textoCoord, root, puntosDeControl, x+20, y+35, x+22, y+40, x+45, y+60, x-10, y+60);
                pts(textoCoord, root, puntosDeControl, x+22, y+40, x+40, y+15, x+35, y+30);


                fun(root, puntosDeControl, x + 20, y + 35, x - 40, y - 15, x + 40, y - 15, x, y + 10 + 5, x + 20, y + 35, x + 45, y + 60, x - 10, y + 60, x + 22, y + 40, x + 22, y + 40, x + 35, y + 30, x + 40, y + 15);
                while(cont < auxBold) {

                    if (caracterAnt == ' ') {
                        CubicCurve a = new CubicCurve(x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        if(cont < 1){
                            fun(root, puntosDeControl, x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                            pts(textoCoord, root, puntosDeControl, x+20, y+40, x+60, y+15, x+10, y+60, x+50, y-65);
                        }

                        root.getChildren().add(a);
                        x = x + 60;
                        if (auxSub) {
                            Subrayar(xInicialSu, yInicialSu, x, y, root);
                        }
                    }
                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 20, y + 35, x - 40, y - 15, x + 40, y - 15, x, y + 10 + 5);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurbaB
                    CubicCurve b = new CubicCurve(x + 20, y + 35, x + 45, y + 60, x - 10, y + 60, x + 22, y + 40);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurbaC
                    QuadCurve c = new QuadCurve(x + 22, y + 40, x + 35, y + 30, x + 40, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //Espaciocaracter s
                x = x + 40;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                if (caracterAnt != '^') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);

                    pts(textoCoord, root, puntosDeControl, x-1, y+15, x+10, y+40, x, y-15, x-30, y+20);
                    pts(textoCoord, root, puntosDeControl, x+10, y+40, x+25, y, x+65, y+70, x+50, y+10);
                    pts(textoCoord, root, puntosDeControl, x+44, y+47, x+70, y+15, x+55, y+45);
                    pts(textoCoord, root, puntosDeControl, x+25, y, x+35, y-20, x-30, y-30, x+90, y-80);

                    fun(root, puntosDeControl, x - 1, y + 15, x, y - 15, x - 30, y + 20, x + 10, y + 40, x + 10, y + 40, x + 65, y + 70, x + 50, y + 10, x + 25, y, x + 44, y + 47, x + 55, y + 45, x + 70, y + 15, x + 25, y, x - 30, y - 30, x + 90, y - 80, x + 35, y - 20);

                    while(cont < auxBold) {//CurvaA
                        CubicCurve a = new CubicCurve(x - 1, y + 15, x, y - 15, x - 30, y + 20, x + 10, y + 40);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        //CurvaB
                        CubicCurve b = new CubicCurve(x + 10, y + 40, x + 65, y + 70, x + 50, y + 10, x + 25, y);
                        b.setFill(Color.TRANSPARENT);
                        b.setStroke(color);
                        b.setStrokeWidth(grosor);

                        //CurvaC
                        QuadCurve c = new QuadCurve(x + 44, y + 47, x + 55, y + 45, x + 70, y + 15);
                        c.setFill(Color.TRANSPARENT);
                        c.setStroke(color);
                        c.setStrokeWidth(grosor);

                        //CurvaD
                        CubicCurve d = new CubicCurve(x + 25, y, x - 30, y - 30, x + 90, y - 80, x + 35, y - 20);
                        d.setFill(Color.TRANSPARENT);
                        d.setStroke(color);
                        d.setStrokeWidth(grosor);




                        root.getChildren().add(a);
                        root.getChildren().add(b);
                        root.getChildren().add(c);
                        root.getChildren().add(d);

                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }
                    x = x + 70;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu, x, y, root);
                    }
                } else {// Cuando quiere subrayar
                    auxSub = true;
                    xInicialSu = x;
                    yInicialSu = y + 55;
                }

            }

        }
        if (caracter == 't' || caracter == 'T') {
            if (caracter == 't') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+10, y-40, x+30, y+15, x-15, y, x+15, y+100);
                pts(textoCoord, root, puntosDeControl, x-10, y-25, x+15, y-25, x-5, y-30, x+10, y-20);

                fun(root, puntosDeControl, x + 10, y - 40, x - 15, y, x + 15, y + 100, x + 30, y + 15, x - 10, y - 25, x - 5, y - 30, x + 10, y - 20, x + 15, y - 25);


                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 10, y - 40, x - 15, y, x + 15, y + 100, x + 30, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x - 10, y - 25, x - 5, y - 30, x + 10, y - 20, x + 15, y - 25);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //EspaciocaracterT
                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+10, y-50, x+30, y+15, x-20, y, x+15, y+100);
                pts(textoCoord, root, puntosDeControl, x-30, y-40, x+45, y-55, x-20, y-55, x+40, y-40);


                fun(root, puntosDeControl, x + 10, y - 50, x - 20, y, x + 15, y + 100, x + 30, y + 15, x - 30, y - 40, x - 20, y - 55, x + 40, y - 40, x + 45, y - 55);

                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 10, y - 50, x - 20, y, x + 15, y + 100, x + 30, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaA
                    CubicCurve b = new CubicCurve(x - 30, y - 40, x - 20, y - 55, x + 40, y - 40, x + 45, y - 55);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'u' || caracter == 'U' || caracter == 'ü' || caracter == 'Ü' || caracter == 'ú' || caracter == 'Ú') {
            if (caracter == 'u' || caracter == 'ü' || caracter == 'ú') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                fun(root, puntosDeControl, x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 28, y, x + 18, y + 30, x + 33, y + 100, x + 48, y + 15);

                pts(textoCoord, root, puntosDeControl, x+2, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+28, y, x+48, y+15, x+18, y+30, x+33, y+100);
                while(cont < auxBold) {

                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 28, y, x + 18, y + 30, x + 33, y + 100, x + 48, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if (caracter == 'ü') {
                        Circle p = new Circle(x + 2, y - 10, 2);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        Circle p2 = new Circle(x + 28, y - 10, 2);
                        p2.setFill(Color.TRANSPARENT);
                        p2.setStroke(color);
                        p2.setStrokeWidth(grosor);

                        root.getChildren().add(p);
                        root.getChildren().add(p2);

                        fun(root, puntosDeControl, x + 2, y - 10, x + 28, y - 10);

                        Text t5 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 10));
                        Text t6 = new Text("\n");
                        Text t7 = new Text("\nX1: " + (x + 28) + " Y1: " + (y - 10));
                        Text t8 = new Text("\n");

                        t5.setFill(Color.BLUE);
                        t6.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t5);
                        textoCoord.getChildren().add(t6);
                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);

                    }
                    if (caracter == 'ú') {
                        Line tilde = new Line(x + 20, y - 10, x + 35, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);

                        Text t9 = new Text("\nX1: " + (x + 20) + " Y1: " + (y - 10) + "\tX2: " + (x + 35) + " Y2: " + (y - 30) + "\n");
                        t9.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t9);

                        root.getChildren().add(tilde);
                    }
                    Text t10 = new Text("\n");
                    textoCoord.getChildren().add(t10);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de caracter i
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15, x + 28 + 5, y - 35, x + 18 + 5, y + 30, x + 33 + 5, y + 100, x + 48 + 5, y + 15, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);

                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+29, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+33, y-35, x+53, y+15, x+22, y+30, x+38, y+100);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+20, y-20, x+10, y-60, x-20, y-50);
                while(cont < auxBold) {
                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 28 + 5, y - 35, x + 18 + 5, y + 30, x + 33 + 5, y + 100, x + 48 + 5, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve c = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);




                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if (caracter == 'Ü') {
                        Circle p = new Circle(x + 2, y - 60, 2);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        Circle p2 = new Circle(x + 33, y - 60, 2);
                        p2.setFill(Color.TRANSPARENT);
                        p2.setStroke(color);
                        p2.setStrokeWidth(grosor);

                        fun(root, puntosDeControl, x + 2, y - 60, x + 33, y - 60);


                        Text t7 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 60) + "\n");
                        Text t8 = new Text("\nX1: " + (x + 33) + " Y1: " + (y - 60) + "\n");

                        t7.setFill(Color.BLUE);
                        t8.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);

                        root.getChildren().add(p);
                        root.getChildren().add(p2);
                    }
                    if (caracter == 'Ú') {
                        Line tilde = new Line(x + 20, y - 60, x + 35, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);
                        fun(root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);

                        Text t9 = new Text("\nX1: " + (x + 20) + " Y1: " + (y - 60) + "\tX2: " + (x + 35) + " Y2: " + (y - 80) + "\n");
                        t9.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t9);
                        root.getChildren().add(tilde);
                    }
                    Text t10 = new Text("\n");
                    textoCoord.getChildren().add(t10);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de caracter i
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
                x = x + 55;
            }
        }
        if (caracter == 'v' || caracter == 'V') {
            if (caracter == 'v') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3, y, x+63, y, x+10, y+63, x+25, y+63);
                pts(textoCoord, root, puntosDeControl, x+35, y, x+30, y+25, x+35, y-20, x+10, y+12);
                pts(textoCoord, root, puntosDeControl, x+30, y+25, x+50, y+15, x+35, y+25, x+45, y+20);

                fun(root, puntosDeControl, x - 3, y, x + 10, y + 63, x + 25, y + 63, x + 35, y, x + 35, y, x + 35, y - 20, x + 10, y + 12, x + 30, y + 25, x + 30, y + 25, x + 35, y + 25, x + 45, y + 20, x + 50, y + 15);

                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x - 3, y, x + 10, y + 63, x + 25, y + 63, x + 35, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve b = new CubicCurve(x + 35, y, x + 35, y - 20, x + 10, y + 12, x + 30, y + 25);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve c = new CubicCurve(x + 30, y + 25, x + 35, y + 25, x + 45, y + 20, x + 50, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //espaciocaracter v
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x+10, y-60, x-20, y-50);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+35, y-15, x-6, y+30, x+9, y+100);
                pts(textoCoord, root, puntosDeControl, x+35, y-15, x+30, y+10, x+35, y-35, x+10, y-3);
                pts(textoCoord, root, puntosDeControl, x+30, y+10, x+50, y, x+35, y+10, x+45, y+5);

                fun(root, puntosDeControl, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20, x + 2, y - 35, x - 6, y + 30, x + 9, y + 100, x + 35, y - 15, x + 35, y - 15, x + 35, y - 20 - 15, x + 10, y + 12 - 15, x + 30, y + 25 - 15, x + 30, y + 25 - 15, x + 35, y + 25 - 15, x + 45, y + 20 - 15, x + 50, y);


                while(cont < auxBold) {//CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30, x + 9, y + 100, x + 35, y - 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve b = new CubicCurve(x + 35, y - 15, x + 35, y - 20 - 15, x + 10, y + 12 - 15, x + 30, y + 25 - 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve c = new CubicCurve(x + 30, y + 25 - 15, x + 35, y + 25 - 15, x + 45, y + 20 - 15, x + 50, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                if(auxBold > 1){
                    x++;
                }
                //espaciocaracter v
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'w' || caracter == 'W') {
            if (caracter == 'w') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+4, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+24, y+15, x+50, y, x+20, y+73, x+40, y+83);
                pts(textoCoord, root, puntosDeControl, x+50, y, x+45, y+25, x+50, y-20, x+25, y+12);
                pts(textoCoord, root, puntosDeControl, x+45, y+25, x+65, y+15, x+50, y+25, x+60, y+20);

                fun(root, puntosDeControl, x + 4, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 24, y + 15, x + 20, y + 73, x + 40, y + 83, x + 50, y, x + 50, y, x + 50, y - 20, x + 25, y + 12, x + 45, y + 25, x + 45, y + 25, x + 50, y + 25, x + 60, y + 20, x + 65, y + 15);


                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 4, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);
                    //curvaA
                    CubicCurve b = new CubicCurve(x + 24, y + 15, x + 20, y + 73, x + 40, y + 83, x + 50, y);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve c = new CubicCurve(x + 50, y, x + 50, y - 20, x + 25, y + 12, x + 45, y + 25);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve d = new CubicCurve(x + 45, y + 25, x + 50, y + 25, x + 60, y + 20, x + 65, y + 15);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //espaciocaracter v
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                Text t1 = new Text("\n" + caracter + "\n" + "X1: " + (x + 2) + " Y1: " + (y - 35) + "\tX2: " + (x + 29) + " Y2: " + (y + 15));
                Text t2 = new Text("\nX3: " + (x - 6) + " Y3: " + (y + 30) + "\tX4: " + (x + 9) + " Y4: " + (y + 80) + "\n");

                Text t3 = new Text("\nX1: " + (x + 30) + " Y1: " + (y + 25) + "\tX2: " + (x + 60) + " Y2: " + (y - 13));
                Text t4 = new Text("\nX3: " + (x + 25) + " Y3: " + (y + 73) + "\tX4: " + (x + 45) + " Y4: " + (y + 83) + "\n");

                Text t5 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 35) + "\tX2: " + (x - 20) + " Y2: " + (y - 20));
                Text t6 = new Text("\nX3: " + (x + 10) + " Y3: " + (y - 60) + "\tX4: " + (x - 20) + " Y4: " + (y - 50) + "\n");

                Text t7 = new Text("\nX1: " + (x + 55) + " Y1: " + (y - 15) + "\tX2: " + (x + 55) + " Y2: " + (y + 10));
                Text t8 = new Text("\nX3: " + (x + 60) + " Y3: " + (y - 35) + "\tX4: " + (x + 35) + " Y4: " + (y - 3) + "\n");

                Text t9 = new Text("\nX1: " + (x + 55) + " Y1: " + (y + 10) + "\tX2: " + (x + 75) + " Y2: " + (y));
                Text t10 = new Text("\nX3: " + (x + 60) + " Y3: " + (y + 10) + "\tX4: " + (x + 70) + " Y4: " + (y + 5) + "\n");

                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15, x + 30, y, x + 25, y + 73, x + 45, y + 83, x + 60, y - 13, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20, x + 35 + 25, y - 15, x + 35 + 25, y - 20 - 15, x + 10 + 25, y + 12 - 15, x + 30 + 25, y + 25 - 15, x + 30 + 25, y + 25 - 15, x + 35 + 25, y + 25 - 15, x + 45 + 25, y + 20 - 15, x + 50 + 25, y);

                t2.setFill(Color.RED);
                t4.setFill(Color.RED);
                t6.setFill(Color.RED);
                t8.setFill(Color.RED);
                t10.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);
                textoCoord.getChildren().add(t6);
                textoCoord.getChildren().add(t7);
                textoCoord.getChildren().add(t8);
                textoCoord.getChildren().add(t9);
                textoCoord.getChildren().add(t10);

                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);
                    //curvaA
                    CubicCurve b = new CubicCurve(x + 30, y, x + 25, y + 73, x + 45, y + 83, x + 60, y - 13);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);
                    //CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve c = new CubicCurve(x + 35 + 25, y - 15, x + 35 + 25, y - 20 - 15, x + 10 + 25, y + 12 - 15, x + 30 + 25, y + 25 - 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve e = new CubicCurve(x + 30 + 25, y + 25 - 15, x + 35 + 25, y + 25 - 15, x + 45 + 25, y + 20 - 15, x + 50 + 25, y);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);


                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'x' || caracter == 'X') {
            if (caracter == 'x') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3, y+10, x+60, y+15, x+45, y+100, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+5, y+50, x+45, y, x+30, y+10);


                fun(root, puntosDeControl, x - 3, y + 10, x + 45, y + 100, x + 50, y + 50, x + 60, y + 15, x + 5, y + 50, x + 30, y + 10, x + 45, y);


                while(cont < auxBold) {//curva a
                    CubicCurve a = new CubicCurve(x - 3, y + 10, x + 45, y + 100, x + 50, y + 50, x + 60, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curva b
                    QuadCurve b = new QuadCurve(x + 5, y + 50, x + 30, y + 10, x + 45, y);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+80, y+15, x+45, y+100, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+45, y-50, x-10, y);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x-5, y-60, x-20, y-50);


                fun(root, puntosDeControl, x + 2, y - 35, x + 45, y + 100, x + 50, y + 50, x + 80, y + 15, x, y + 50, x - 10, y, x + 45, y - 50, x + 2, y - 35, x - 5, y - 60, x - 20, y - 50, x - 20, y - 20);


                while(cont < auxBold) {//curva a
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x + 45, y + 100, x + 50, y + 50, x + 80, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curva b
                    QuadCurve b = new QuadCurve(x, y + 50, x - 10, y, x + 45, y - 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve c = new CubicCurve(x + 2, y - 35, x - 5, y - 60, x - 20, y - 50, x - 20, y - 20);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'y' || caracter == 'Y') {
            if (caracter == 'y') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+24, y, x+24, y+50, x+35, y+113, x-40, y+98);
                pts(textoCoord, root, puntosDeControl, x+23, y+51, x+45, y+15, x+35, y+50);


                fun(root, puntosDeControl, x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 24, y, x + 35, y + 113, x - 40, y + 98, x + 24, y + 50, x + 23, y + 51, x + 35, y + 50, x + 45, y + 15);

                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 24, y, x + 35, y + 113, x - 40, y + 98, x + 24, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 23, y + 51, x + 35, y + 50, x + 45, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //espaciocaracter v
                x = x + 45;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+30, y-35, x-6, y-20, x+9, y+30);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+25, y+10, x+30, y+90, x-35, y+55);
                pts(textoCoord, root, puntosDeControl, x+28, y+10, x+50, y, x+40, y+10);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x+10, y-60, x-20, y-50);


                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30 - 50, x + 9, y + 80 - 50, x + 30, y + 15 - 50, x + 30, y - 50, x + 30, y + 140 - 50, x - 40 + 5, y + 105 - 50, x + 25, y + 10, x + 23 + 5, y + 10, x + 40, y + 10, x + 50, y, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);


                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30 - 50, x + 9, y + 80 - 50, x + 30, y + 15 - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 30, y - 50, x + 30, y + 140 - 50, x - 40 + 5, y + 105 - 50, x + 25, y + 10);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 23 + 5, y + 10, x + 40, y + 10, x + 50, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 46;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'z' || caracter == 'Z') {
            if (caracter == 'z') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+40, y, x, y-21, x-32, y+40);
                pts(textoCoord, root, puntosDeControl, x+40, y, x+7, y+47);
                pts(textoCoord, root, puntosDeControl, x+7, y+47, x+35, y+90, x+50, y+10, x+45, y+80);
                pts(textoCoord, root, puntosDeControl, x+35, y+90, x+40, y+50, x+15, y+120, x-15, y+45);
                pts(textoCoord, root, puntosDeControl, x+40, y+50, x+60, y+15, x+55, y+50, x+60, y+15);


                fun(root, puntosDeControl, x - 1, y + 10, x, y - 21, x - 32, y + 40, x + 40, y, x + 40, y, x + 7, y + 47, x + 7, y + 47, x + 50, y + 10, x + 45, y + 80, x + 35, y + 90, x + 35, y + 90, x + 15, y + 120, x - 15, y + 45, x + 40, y + 50, x + 40, y + 50, x + 55, y + 50, x + 60, y + 15);


                while(cont < auxBold) {//CurvA
                    CubicCurve a = new CubicCurve(x - 1, y + 10, x, y - 21, x - 32, y + 40, x + 40, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    Line b = new Line(x + 40, y, x + 7, y + 47);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve c = new CubicCurve(x + 7, y + 47, x + 50, y + 10, x + 45, y + 80, x + 35, y + 90);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvD
                    CubicCurve d = new CubicCurve(x + 35, y + 90, x + 15, y + 120, x - 15, y + 45, x + 40, y + 50);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //curvaE
                    QuadCurve e = new QuadCurve(x + 40, y + 50, x + 55, y + 50, x + 60, y + 15);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);



                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de z
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+65, y-50, x+25, y-45);
                pts(textoCoord, root, puntosDeControl, x+65, y-50, x, y+50, x+25, y-45);
                pts(textoCoord, root, puntosDeControl, x+50, y+10, x+65, y+15, x+10, y+20, x+50, y+100);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+40, y+15, x+10, y-15, x+20, y+40);


                fun(root, puntosDeControl, x, y - 50, x + 25, y - 45, x + 65, y - 50, x + 65, y - 50, x + 25, y - 45, x, y + 50, x, y + 50, x + 10, y + 20, x + 50, y + 100, x + 65, y + 15, x, y + 50 - 35, x + 10, y + 20 - 35, x + 20, y + 40, x + 40, y + 15);


                while(cont < auxBold) {
                    QuadCurve a = new QuadCurve(x, y - 50, x + 25, y - 45, x + 65, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    QuadCurve b = new QuadCurve(x + 65, y - 50, x + 25, y - 45, x, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 50, x + 10, y + 20, x + 50, y + 100, x + 65, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve d = new CubicCurve(x, y + 50 - 35, x + 10, y + 20 - 35, x + 20, y + 40, x + 40, y + 15);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);



                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
    }

    public void Simbolos(char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl, int borrar, ScrollPane scrollPane){
        if (x >= scrollPane.getWidth() - 120) {
            if (caracter != ' ' && caracterAnt != ' ') {
                Line l1 = new Line(x + 20, y + 30, x + 50, y + 30);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);
                root.getChildren().add(l1);
            }
            x = 30;
            y = y + 150;
            xInicialSu = x;
            yInicialSu = y + 55;
        }
        if (borrar == 1) {
            x = 30;
            y = 100;
        }
        if (caracter == ' ') {
            if (x != 30) {
                x = x + 50;
            }
            auxSub = false;
            auxBold = 1;
        }

        int cont = 0;
        if(caracter == '(' || caracter == ')'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);

            if (caracter == '('){

                pts(textoCoord, root, puntosDeControl, x+20, y-50, x+20, y+50);
                fun(root, puntosDeControl, x + 20, y - 50, x, y, x + 20, y + 50);


                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x + 20, y - 50, x, y, x + 20, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 30;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+5, y-50, x+5, y+50);
                fun(root, puntosDeControl, x + 5, y - 50, x + 25, y, x + 5, y + 50);

                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x + 5, y - 50, x + 25, y, x + 5, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 25;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if(caracter == '[' || caracter == ']'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '['){

                pts(textoCoord, root, puntosDeControl, x, y-50, x, y+50);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+20, y+50);

                fun(root, puntosDeControl, x, y - 50, x, y + 50, x, y - 50, x + 20, y - 50, x, y + 50, x + 20, y + 50);

                while(cont < auxBold) {
                    Line l1 = new Line(x, y - 50, x, y + 50);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    Line l2 = new Line(x, y - 50, x + 20, y - 50);
                    l2.setFill(Color.TRANSPARENT);
                    l2.setStroke(color);
                    l2.setStrokeWidth(grosor);

                    Line l3 = new Line(x, y + 50, x + 20, y + 50);
                    l3.setFill(Color.TRANSPARENT);
                    l3.setStroke(color);
                    l3.setStrokeWidth(grosor);

                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 30;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+20, y-50, x+20, y+50);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+20, y+50);
                fun(root, puntosDeControl, x + 20, y - 50, x + 20, y + 50, x, y - 50, x + 20, y - 50, x, y + 50, x + 20, y + 50);

                while(cont < auxBold) {
                    Line l1 = new Line(x + 20, y - 50, x + 20, y + 50);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    Line l2 = new Line(x, y - 50, x + 20, y - 50);
                    l2.setFill(Color.TRANSPARENT);
                    l2.setStroke(color);
                    l2.setStrokeWidth(grosor);

                    Line l3 = new Line(x, y + 50, x + 20, y + 50);
                    l3.setFill(Color.TRANSPARENT);
                    l3.setStroke(color);
                    l3.setStrokeWidth(grosor);


                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 35;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if(caracter == '-' || caracter == '_'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '-'){

                pts(textoCoord, root, puntosDeControl, x+10, y+25, x+40, y+25);
                fun(root, puntosDeControl, x + 10, y + 25, x + 40, y + 25);

                while(cont < auxBold) {
                    Line l1 = new Line(x + 10, y + 25, x + 40, y + 25);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    root.getChildren().add(l1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+10, y+50, x+60, y+50);
                fun(root, puntosDeControl, x + 10, y + 50, x + 60, y + 50);

                while(cont < auxBold) {
                    Line l1 = new Line(x + 10, y + 50, x + 60, y + 50);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    root.getChildren().add(l1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 70;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if(caracter == '<' || caracter == '>'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '<'){

                pts(textoCoord, root, puntosDeControl, x+10, y+25, x+50, y);
                pts(textoCoord, root, puntosDeControl, x+10, y+25, x+50, y+50);
                fun(root, puntosDeControl, x + 10, y + 25, x + 50, y, x + 10, y + 25, x + 50, y + 50);

                while(cont < auxBold) {
                    Line l1 = new Line(x + 10, y + 25, x + 50, y);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    Line l2 = new Line(x + 10, y + 25, x + 50, y + 50);
                    l2.setFill(Color.TRANSPARENT);
                    l2.setStroke(color);
                    l2.setStrokeWidth(grosor);

                    root.getChildren().add(l1);
                    root.getChildren().add(l2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+10, y, x+50, y+25);
                pts(textoCoord, root, puntosDeControl, x+10, y+50, x+50, y+25);
                fun(root, puntosDeControl, x + 10, y, x + 50, y + 25, x + 10, y + 50, x + 50, y + 25);

                while(cont < auxBold) {
                    Line l1 = new Line(x + 10, y, x + 50, y + 25);
                    l1.setFill(Color.TRANSPARENT);
                    l1.setStroke(color);
                    l1.setStrokeWidth(grosor);

                    Line l2 = new Line(x + 10, y + 50, x + 50, y + 25);
                    l2.setFill(Color.TRANSPARENT);
                    l2.setStroke(color);
                    l2.setStrokeWidth(grosor);

                    root.getChildren().add(l1);
                    root.getChildren().add(l2);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if(caracter == '.' || caracter == ','){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '.'){

                pts(textoCoord, root, puntosDeControl, x+10, y+50);
                fun(root, puntosDeControl, x + 10, y + 50);

                while(cont < auxBold) {
                    Circle cd1 = new Circle(x + 10, y + 50, grosor - 1);
                    cd1.setFill(color);
                    cd1.setStroke(color);

                    root.getChildren().add(cd1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
            }

            else{

                pts(textoCoord, root, puntosDeControl, x+15, y+50);
                pts(textoCoord, root, puntosDeControl, x+15, y+50, x+10, y+65);
                fun(root, puntosDeControl, x + 15, y + 50, x + 15, y + 50, x + 14, y + 60, x + 10, y + 65);

                while(cont < auxBold) {
                    Circle cd1 = new Circle(x + 15, y + 50, grosor - 1);
                    cd1.setFill(color);
                    cd1.setStroke(color);

                    QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 14, y + 60, x + 10, y + 65);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(cd1);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
            }


            x = x + 20;
            if(auxSub){
                Subrayar(xInicialSu, yInicialSu, x, y, root);
            }
        }
        if(caracter == ':' || caracter == ';'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == ';'){

                pts(textoCoord, root, puntosDeControl, x+20, y+10);
                pts(textoCoord, root, puntosDeControl, x+20, y+50);
                pts(textoCoord, root, puntosDeControl, x+20, y+50, x+15, y+65);
                fun(root, puntosDeControl, x + 20, y + 10, x + 20, y + 50, x + 20, y + 50, x + 19, y + 60, x + 15, y + 65);

                while(cont < auxBold) {

                    Circle cd1 = new Circle(x + 20, y+10, grosor - 1);
                    cd1.setFill(color);
                    cd1.setStroke(color);

                    Circle cd2 = new Circle(x + 20, y+50, grosor - 1);
                    cd2.setFill(color);
                    cd2.setStroke(color);

                    QuadCurve qv1 = new QuadCurve(x + 20, y + 50, x + 19, y + 60, x + 15, y + 65);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);


                    root.getChildren().add(cd1);
                    root.getChildren().add(cd2);
                    root.getChildren().add(qv1);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+20, y+10);
                pts(textoCoord, root, puntosDeControl, x+20, y+50);
                fun(root, puntosDeControl, x + 20, y + 10, x + 20, y + 50);

                while(cont < auxBold) {

                    Circle cd1 = new Circle(x + 20, y+10, grosor - 1);
                    cd1.setFill(color);
                    cd1.setStroke(color);

                    Circle cd2 = new Circle(x + 20, y+50, grosor - 1);
                    cd2.setFill(color);
                    cd2.setStroke(color);

                    root.getChildren().add(cd1);
                    root.getChildren().add(cd2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
            }


            x = x + 30;
            if(auxSub){
                Subrayar(xInicialSu, yInicialSu, x, y, root);
            }
        }
        if(caracter == '{' || caracter == '}'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '{'){

                pts(textoCoord, root, puntosDeControl, x+25, y-50, x+5, y);
                pts(textoCoord, root, puntosDeControl, x+25, y+50, x+5, y);
                fun(root, puntosDeControl, x + 25, y - 50, x + 10, y - 50, x + 30, y, x + 5, y, x + 25, y + 50, x + 10, y + 50, x + 30, y, x + 5, y);

                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x + 25, y - 50, x + 10, y - 50, x + 30, y, x + 5, y); // Curva Superior
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 25, y + 50, x + 10, y + 50, x + 30, y, x + 5, y); // Curva Superior
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    root.getChildren().add(c1);
                    root.getChildren().add(c2);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 40;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+25, y, x+5, y-50);
                pts(textoCoord, root, puntosDeControl, x+25, y, x+5, y+50);
                fun(root, puntosDeControl, x + 25, y, x, y, x + 25, y - 50, x + 5, y - 50, x + 25, y, x, y, x + 25, y + 50, x + 5, y + 50);

                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x + 25, y, x, y, x + 25, y - 50, x + 5, y - 50); // Curva Superior
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 25, y, x, y, x + 25, y + 50, x + 5, y + 50); // Curva Superior
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    root.getChildren().add(c1);
                    root.getChildren().add(c2);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 40;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if(caracter == '"' || caracter =='\''){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            int rep = 0;
            if(caracter == '\''){
                rep = 1;
            }
            else{
                rep = 2;
            }
            for(int j = 0;j<rep;j++) {
                if (aux == 0) {

                    pts(textoCoord, root, puntosDeControl, x+5, y-20, x+5, y-50);
                    pts(textoCoord, root, puntosDeControl, x+5, y-20, x+7, y-20);
                    fun(root, puntosDeControl, x + 5, y - 20, x, y - 35, x + 5, y - 50, x + 5, y - 20, x + 25, y + 15, x + 35, y - 20, x + 7, y - 20);

                    while(cont < auxBold) {
                        QuadCurve a = new QuadCurve(x + 5, y - 20, x, y - 35, x + 5, y - 50);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        CubicCurve b = new CubicCurve(x + 5, y - 20, x + 25, y + 15, x + 35, y - 20, x + 7, y - 20);
                        b.setFill(color);
                        b.setStroke(color);
                        b.setStrokeWidth(grosor);

                        root.getChildren().add(a);
                        root.getChildren().add(b);

                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }

                    x = x + 25;
                    if(auxSub){
                        Subrayar(xInicialSu, yInicialSu, x, y, root);
                    }
                } else {

                    pts(textoCoord, root, puntosDeControl, x+5, y-20, x+5, y-50);
                    pts(textoCoord, root, puntosDeControl, x+5, y-50, x+3, y-50);
                    fun(root, puntosDeControl, x + 5, y - 20, x + 10, y - 35, x + 5, y - 50, x + 5, y - 50, x - 25, y - 90, x - 25, y - 40, x + 3, y - 50);

                    while(cont < auxBold) {
                        QuadCurve a = new QuadCurve(x + 5, y - 20, x + 10, y - 35, x + 5, y - 50);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        CubicCurve b = new CubicCurve(x + 5, y - 50, x - 25, y - 90, x - 25, y - 40, x + 3, y - 50);
                        b.setFill(color);
                        b.setStroke(color);
                        b.setStrokeWidth(grosor);

                        root.getChildren().add(a);
                        root.getChildren().add(b);


                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }

                    x = x + 25;
                    if(auxSub){
                        Subrayar(xInicialSu, yInicialSu, x, y, root);
                    }
                }
            }
            x=x+20;
            if(auxSub){
                Subrayar(xInicialSu, yInicialSu, x, y, root);
            }
            if(aux == 0){
                aux = 1;
            }
            else{
                aux = 0;
            }

        }
        if(caracter == '¡' || caracter == '!'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if(caracter == '¡'){

                pts(textoCoord, root, puntosDeControl, x+10, y+10, x+10, y+80);
                pts(textoCoord, root, puntosDeControl, x+10, y);
                pts(textoCoord, root, puntosDeControl, x+10, y+10, x+10, y+80);
                fun(root, puntosDeControl, x + 10, y, x + 10, y + 10, x + 5, y + 80, x + 10, y + 80, x + 10, y + 10, x + 15, y + 80, x + 10, y + 80);

                while(cont < auxBold) {
                    Circle a = new Circle(x + 10, y, 2);
                    a.setFill(color);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    QuadCurve b = new QuadCurve(x + 10, y + 10, x + 5, y + 80, x + 10, y + 80);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 10, y + 10, x + 15, y + 80, x + 10, y + 80);
                    c.setFill(color);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x +25;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+10, y+80);
                pts(textoCoord, root, puntosDeControl, x+10, y+70, x+10, y);
                pts(textoCoord, root, puntosDeControl, x+10, y+70, x+10, y);
                fun(root, puntosDeControl, x + 10, y + 80, x + 10, y + 70, x + 5, y, x + 10, y, x + 10, y + 70, x + 15, y, x + 10, y);


                while(cont < auxBold) {
                    Circle a = new Circle(x + 10, y + 80, 2);
                    a.setFill(color);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    QuadCurve b = new QuadCurve(x + 10, y + 70, x + 5, y, x + 10, y);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 10, y + 70, x + 15, y, x + 10, y);
                    c.setFill(color);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x +25;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if(caracter == '¿' || caracter == '?'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if(caracter == '¿'){

                pts(textoCoord, root, puntosDeControl, x+10, y);
                pts(textoCoord, root, puntosDeControl, x+7, y+30, x, y+50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+25, y+60);
                fun(root, puntosDeControl, x + 10, y, x + 7, y + 30, x, y, x + 25, y, x, y + 50, x, y + 50, x - 15, y + 90, x + 30, y + 90, x + 25, y + 60);

                while(cont < auxBold) {
                    Circle a = new Circle(x + 10, y, 2);
                    a.setFill(color);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    CubicCurve b = new CubicCurve(x + 7, y + 30, x, y, x + 25, y, x, y + 50);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 50, x - 15, y + 90, x + 30, y + 90, x + 25, y + 60);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x=x+45;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
            else{

                pts(textoCoord, root, puntosDeControl, x+30, y+80);
                pts(textoCoord, root, puntosDeControl, x+27, y+50, x+30, y+47);
                pts(textoCoord, root, puntosDeControl, x+27, y+50, x+10, y+20);
                fun(root, puntosDeControl, x + 30, y + 80, x + 27, y + 50, x + 20, y + 75, x + 35, y + 80, x + 30, y + 47, x + 27, y + 50, x + 65, y - 15, x + 5, y - 20, x + 10, y + 20);

                while(cont < auxBold) {
                    Circle a = new Circle(x + 30, y + 80, 2);
                    a.setFill(color);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    CubicCurve b = new CubicCurve(x + 27, y + 50, x + 20, y + 75, x + 35, y + 80, x + 30, y + 47);
                    b.setFill(color);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x + 27, y + 50, x + 65, y - 15, x + 5, y - 20, x + 10, y + 20);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x=x+45;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
    }

    public void pts(TextFlow textoCoord, AnchorPane root, ToggleButton puntosdeControl, int... lista){


        if(lista.length == 8) {
            Text t1 = new Text(String.format("\n%s%-4s %s%-6s %s%-4s %s%s", "X1:", lista[0], "Y1:" , lista[1], "X2:", lista[2], "Y2:", lista[3]));
            Text t2 = new Text(String.format("\n%s%-4s %s%-6s %s%-4s %s%s\n", "X3:", lista[4], "Y3:" , lista[5], "X4:", lista[6], "Y4:", lista[7]));
            t1.setFont(Font.font("Menlo", 14));
            t2.setFont(Font.font("Menlo", 14));
            t2.setFill(Color.RED);
            textoCoord.getChildren().add(t1);
            textoCoord.getChildren().add(t2);
        }else if(lista.length == 6){
            Text t1 = new Text(String.format("\n%s%-4s %s%-6s %s%-4s %s%s", "X1:", lista[0], "Y1:" , lista[1], "X2:", lista[2], "Y2:", lista[3]));
            Text t2 = new Text(String.format("\n%s%-4s %s%-6s\n", "X3:", lista[4], "Y3:" , lista[5]));
            t1.setFont(Font.font("Menlo", 14));
            t2.setFont(Font.font("Menlo", 14));
            t2.setFill(Color.RED);
            textoCoord.getChildren().add(t1);
            textoCoord.getChildren().add(t2);
        }else if(lista.length == 4){
            Text t1 = new Text(String.format("\n%s%-4s %s%-6s %s%-4s %s%s\n", "X1:", lista[0], "Y1:" , lista[1], "X2:", lista[2], "Y2:", lista[3]));
            t1.setFont(Font.font("Menlo", 14));
            textoCoord.getChildren().add(t1);
        }else if(lista.length == 2){
            Text t1 = new Text(String.format("\n%s%-4s %s%-6s\n", "X1:", lista[0], "Y1:" , lista[1]));
            t1.setFont(Font.font("Menlo", 14));
            textoCoord.getChildren().add(t1);
        }
    }

    public void Cursivas(char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl, int borrar, ScrollPane scrollPane){

        if (x >= scrollPane.getWidth() - 120) {
            if (caracter != ' ' && caracterAnt != ' ') {
                Line l1 = new Line(x + 20, y + 30, x + 50, y + 30);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);
                root.getChildren().add(l1);
            }
            x = 30;
            y = y + 150;
            xInicialSu = x;
            yInicialSu = y + 55;
        }

        int cont = 0;

        if (caracter == 'a' || caracter == 'A' || caracter == 'á' || caracter == 'Á') {

            if (caracter == 'a' || caracter == 'á') {

                x = x - 15;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30, y+10, x+25, y+30, x-5, y-30, x-20, y+85);
                pts(textoCoord, root, puntosDeControl, x+35, y, x+60, y+15, x+10, y+60, x+50, y+65);

                fun(root, puntosDeControl, x + 30, y + 10, x - 5, y - 30, x - 20, y + 85, x + 25, y + 30, x + 35, y, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);

                while(cont < auxBold){
                    CubicCurve c = new CubicCurve(x + 42, y + 10, x + 20, y - 30, x - 10, y + 85, x + 35, y + 30);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y, x + 15, y + 60, x + 50, y + 65, x + 60, y + 15);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);

                    if (caracter == 'á') {
                        Line tilde = new Line(x + 30, y - 10, x + 45, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+15, y-10, x+30, y-30);
                            fun(root, puntosDeControl, x + 15, y - 10, x + 30, y - 30);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 58;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }


            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                pts(textoCoord, root, puntosDeControl, x, y+50, x+30, y-50, x+20, y+60, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+65, y+15, x+50, y-60, x+40, y+120);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+44, y, x+10, y-10, x+30, y+30);

                fun(root, puntosDeControl, x, y + 50, x + 20, y + 60, x + 20, y - 50, x + 30, y - 50, x + 30, y - 50, x + 50, y - 60, x + 40, y + 120, x + 65, y + 15, x, y + 15, x + 10, y - 10, x + 30, y + 30, x + 44, y);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y + 50, x + 20, y + 60, x + 30, y - 50, x + 50, y - 50); // IZQ
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y - 50, x + 30, y - 60, x + 20, y + 120, x + 65, y + 15); // DER
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x+5, y + 15, x + 15, y - 10, x + 35, y + 30, x + 49, y); // MED
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);



                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if (caracter == 'Á') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'b' || caracter == 'B') {

            if (caracter == 'b') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                fun(root, puntosDeControl, x, y + 15, x + 70, y - 80, x - 10, y - 80, x, y + 50, x, y + 30, x + 50, y - 50, x + 35, y + 100, x + 5, y + 50, x + 5, y + 50, x, y + 30, x + 60, y + 50, x + 60, y + 20);

                pts(textoCoord, root, puntosDeControl, x, y+15, x, y+50, x+70, y-80, x-10, y-80);
                pts(textoCoord, root, puntosDeControl, x, y+30, x+5, y+50, x+50, y-50, x+35, y+100);
                pts(textoCoord, root, puntosDeControl, x+5, y+50, x+60, y+20, x, y+30, x+60, y+50);


                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 130, y - 80, x , y - 80, x, y + 50); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x, y + 30, x + 70, y - 50, x + 50, y + 100, x + 10, y + 50);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 10, y + 50, x+10, y + 30, x + 60, y + 50, x + 60, y + 20);
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                pts(textoCoord, root, puntosDeControl, x+30, y-20, x+40, y+50, x+30, y+50);
                pts(textoCoord, root, puntosDeControl, x+40, y+50, x+30, y+20, x+60, y+60, x+80, y-10);
                pts(textoCoord, root, puntosDeControl, x+20, y+10, x+30, y-50, x-10, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+30, y+20, x+70, y-50, x+70, y);
                pts(textoCoord, root, puntosDeControl, x+58, y+40, x+80, y+15, x+70, y+60);


                fun(root, puntosDeControl, x + 30, y - 20, x + 30, y + 50, x + 40, y + 50, x + 40, y + 50, x + 60, y + 60, x + 80, y - 10, x + 30, y + 20, x + 20, y + 10, x - 10,
                        y + 10, x, y - 50, x + 30, y - 50, x + 30, y - 50, x + 70, y - 50, x + 70, y, x + 30, y + 20, x + 58, y + 40, x + 70, y + 60, x + 80, y + 15);

                while(cont < auxBold) {
                    QuadCurve c = new QuadCurve(x + 50, y - 20, x + 30, y + 50, x + 40, y + 50); // inferior b
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 40, y + 50, x + 60, y + 60, x + 80, y - 10, x + 30, y + 20); // guata b
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 20, y + 10, x, y + 10, x+7, y - 50, x + 50, y - 50); // izq sombrero
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 50, y - 50, x + 90, y - 50, x + 90, y, x + 30, y + 20); // der sombrero
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    QuadCurve c5 = new QuadCurve(x + 58, y + 40, x + 70, y + 60, x + 80, y + 15);
                    c5.setFill(Color.TRANSPARENT);
                    c5.setStroke(color);
                    c5.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);
                    root.getChildren().add(c5);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'c' || caracter == 'C') {

            if (caracter == 'c') {

                x = x - 10;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+25, y+15, x, y-20, x+40, y-5);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+60, y+15, x, y+45, x+30, y+80);

                fun(root, puntosDeControl, x, y + 25, x, y - 20, x + 40, y - 5, x + 25, y + 15, x, y + 25, x, y + 45, x + 30, y + 80, x + 60, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x+10, y + 25, x+10, y - 20, x + 60, y - 5, x + 40, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c1 = new CubicCurve(x+10, y + 25, x+10, y + 45, x + 30, y + 80, x + 60, y + 15);
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c1);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+60, y+15, x-25, y-10, x+10, y+110);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+10, y, x+45, y-60, x+75, y-35);
                pts(textoCoord, root, puntosDeControl, x+10, y, x, y-40, x-20, y+10, x-20, y-30);

                fun(root, puntosDeControl, x + 20, y - 40, x - 25, y - 10, x + 10, y + 110, x + 60, y + 15, x + 20, y - 40, x + 45, y - 60, x + 75, y - 35, x + 10, y, x + 10, y, x - 20, y + 10, x - 20, y - 30, x, y - 40);


                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 40, y - 40, x - 10, y - 20, x + 10, y + 110, x + 60, y + 15); // C
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 40, y - 40, x + 60, y - 45, x + 75, y - 35, x + 10, y);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y, x - 15 , y + 10, x - 20, y - 30, x, y - 40);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

        }
        if (caracter == 'd' || caracter == 'D') {

            if (caracter == 'd') {

                x = x - 10;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y+15, x+25, y+25, x-15, y-30, x, y+90);
                pts(textoCoord, root, puntosDeControl, x+25, y+5, x+25, y+25, x+80, y-50, x+20, y-80);
                pts(textoCoord, root, puntosDeControl, x+25, y+25, x+60, y+15, x+30, y+50, x+50, y+50);

                fun(root, puntosDeControl, x + 25, y + 15, x - 15, y - 30, x, y + 90, x + 25, y + 25, x + 25, y + 5, x + 80, y - 50, x + 20, y - 80, x + 25, y + 25, x + 25, y + 25, x + 30, y + 50, x + 50, y + 50, x + 60, y + 15);


                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 28, y + 15, x+5, y - 30, x, y + 90, x + 25, y + 25);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 33, y + 5, x + 100, y - 50, x + 60, y - 80, x + 25, y + 25);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 25, y + 25, x + 30, y + 50, x + 50, y + 50, x + 60, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y+10, x+30, y-50, x-10, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+50, y+50, x+80, y-50, x+80, y+50);
                pts(textoCoord, root, puntosDeControl, x+50, y+50, x+30, y-30, x+30, y+50, x+30, y+50);

                fun(root, puntosDeControl, x + 20, y + 10, x - 10, y + 10, x, y - 50, x + 30, y - 50, x + 30, y - 50, x + 80, y - 50, x + 80, y + 50, x + 50, y + 50, x + 50, y + 50, x + 30, y + 50, x + 30, y + 50, x + 30, y - 30);

                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x + 20, y + 10, x - 10, y + 10, x, y - 50, x + 30, y - 50); // izq sombrero
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 30, y - 50, x + 100, y - 50, x + 114, y + 50, x + 50, y + 50); // izq sombrero
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 50, y + 50, x + 30, y + 50, x + 30, y + 50, x + 50, y - 30); // izq sombrero
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);


                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 90;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'e' || caracter == 'E' || caracter == 'é' || caracter == 'É') {

            if (caracter == 'e' || caracter == 'é') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+2, y+30, x-5, y-20, x+53, y);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+50, y+15, x, y+50, x+40, y+70);

                fun(root, puntosDeControl, x, y + 25, x - 5, y - 20, x + 53, y, x + 2, y + 30, x, y + 25, x, y + 50, x + 40, y + 70, x + 50, y + 15);
                while(cont < auxBold) {
                    CubicCurve b = new CubicCurve(x, y + 25, x + 10, y - 20, x + 73, y, x + 2, y + 30);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 25, x, y + 50, x + 40, y + 70, x + 50, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if (caracter == 'é') {
                        Line tilde = new Line(x + 20, y - 10, x + 35, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20, y-10, x+35, y-30);
                            fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y-10, x+60, y+15, x-20, y-10, x, y+120);
                pts(textoCoord, root, puntosDeControl, x+25, y-10, x+20, y-50, x-20, y-10, x+10, y-50);

                fun(root, puntosDeControl, x + 25, y - 10, x - 20, y - 10, x, y + 120, x + 60, y + 15, x + 25, y - 10, x - 20, y - 10, x + 10, y - 50, x + 20, y - 50, x + 20, y - 50, x + 40, y - 50, x + 30, y - 10, x, y - 50);
                while(cont < auxBold) {
                    CubicCurve c2 = new CubicCurve(x + 35, y - 10, x - 10, y - 10, x, y + 120, x + 60, y + 15);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 35, y - 10, x - 10, y - 10, x, y - 50, x + 45, y - 50);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 45, y - 50, x + 80, y - 50, x + 40, y - 10, x, y - 50);
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if (caracter == 'É') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);


                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

            //tamaÃ±o caracter
        }
        if (caracter == 'f' || caracter == 'F') {

            if (caracter == 'f') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+10, x, y+10, x, y-60, x+60, y-60);
                pts(textoCoord, root, puntosDeControl, x, y, x+2, y+15, x, y+110, x+50, y+60);
                pts(textoCoord, root, puntosDeControl, x+2, y+25, x+50, y+15, x+35, y+60);

                fun(root, puntosDeControl, x, y + 10, x, y - 60, x + 60, y - 60, x, y + 10, x, y, x, y + 110, x + 50, y + 60, x + 2, y + 15, x + 2, y + 25, x + 35, y + 60, x + 50, y + 15);


                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x, y + 10, x+20, y - 60, x + 90, y - 60, x, y + 10); // Curva Superior
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x, y+5, x-30, y + 110, x + 30, y + 60, x + 2, y + 15); // Curva inferior
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    QuadCurve c3 = new QuadCurve(x, y + 14, x + 35, y + 60, x + 50, y + 15); // Conexion
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);


                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+60, y-50, x+10, y-70, x+50, y-10);
                pts(textoCoord, root, puntosDeControl, x+30, y-37, x+10, y+40, x+20, y+70);
                pts(textoCoord, root, puntosDeControl, x+10, y, x+40, y);
                pts(textoCoord, root, puntosDeControl, x+10, y+10, x+50, y+15, x+20, y, x+30, y+20);


                fun(root, puntosDeControl, x, y - 40, x + 10, y - 70, x + 50, y - 10, x + 60, y - 50, x + 30, y - 37, x + 20, y + 70, x + 10, y + 40, x + 10, y, x + 40, y, x + 10, y + 10, x + 20, y, x + 30, y + 20, x + 50, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x+10, y - 40, x + 20, y - 70, x + 50, y - 25, x + 60, y - 45);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    QuadCurve c2 = new QuadCurve(x + 40, y - 37, x + 20, y + 100, x + 10, y + 26);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y, x + 20, y-10, x + 30, y + 10, x + 50, y + 5);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'g' || caracter == 'G') {

            if (caracter == 'g') {

                x = x - 18;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25, y+10, x+25, y+40, x-10, y-20, x-10, y+70);
                pts(textoCoord, root, puntosDeControl, x+25, y, x+10, y+80, x+35, y+90, x+10, y+90);
                pts(textoCoord, root, puntosDeControl, x+10, y+80, x+60, y+15, x+10, y+30, x+60, y+60);


                fun(root, puntosDeControl, x + 25, y + 10, x - 10, y - 20, x - 10, y + 70, x + 25, y + 40, x + 25, y, x + 35, y + 90, x + 10, y + 90, x + 10, y + 80, x + 10, y + 80, x + 10, y + 30, x + 60, y + 60, x + 60, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 47, y + 10, x + 5, y - 20, x + 5, y + 70, x + 48, y + 40); // Circulo
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y, x + 35, y + 90, x + 10, y + 90, x + 10, y + 80);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 10, y + 80, x + 10, y + 30, x + 60, y + 60, x + 60, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+40, y-50, x+70, y+10, x+60, y-50);
                pts(textoCoord, root, puntosDeControl, x+40, y-50, x+59, y+20, x, y-50, x+10, y+110);
                pts(textoCoord, root, puntosDeControl, x+60, y+10, x+30, y+80, x+60, y+100, x+20, y+100);
                pts(textoCoord, root, puntosDeControl, x+30, y+80, x+80, y+15, x+40, y+60, x+60, y+60);


                fun(root, puntosDeControl, x, y + 20, x + 70, y + 10, x + 60, y - 50, x + 40, y - 50, x + 40, y - 50, x, y - 50, x + 10, y + 110, x + 59, y + 20, x + 60, y + 10, x + 60, y + 100, x + 20, y + 100, x + 30, y + 80, x + 30, y + 80, x + 40, y + 60, x + 60, y + 60, x + 80, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y + 20, x + 110, y + 10, x + 80, y - 50, x + 50, y - 50); // mitad e
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y - 50, x+30, y - 50, x + 20, y + 90, x + 69, y + 20); // otra mitad
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 70, y + 10, x + 60, y + 100, x + 20, y + 100, x + 15, y + 80); // mitad j
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 15, y + 80, x + 40, y + 35, x + 60, y + 60, x + 80, y + 15); // otra mitad j
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);


                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'h' || caracter == 'H') {

            if (caracter == 'h') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x, y+50, x+50, y-50, x-10, y-90);
                pts(textoCoord, root, puntosDeControl, x, y+40, x+25, y+35, x+10, y, x+25, y+5);
                pts(textoCoord, root, puntosDeControl, x+25, y+35, x+50, y+15, x+25, y+60, x+40, y+60);


                fun(root, puntosDeControl, x, y + 15, x + 50, y - 50, x - 10, y - 90, x, y + 50, x, y + 40, x + 10, y, x + 25, y + 5, x + 25, y + 35, x + 25, y + 35, x + 25, y + 60, x + 40, y + 60, x + 50, y + 15);


                while(cont < auxBold) {
                    CubicCurve c2 = new CubicCurve(x, y + 15, x + 100, y - 50, x+40, y - 90, x, y + 50); // l
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x+3, y + 40, x + 10, y, x + 35, y + 5, x + 30, y + 35); // guata
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 30, y + 35, x + 25, y + 60, x + 40, y + 60, x + 50, y + 15);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+20, y+40, x+10, y-60, x+30, y-30);
                pts(textoCoord, root, puntosDeControl, x+20, y+40, x+40, y, x+10, y+80, x-10, y+30);
                pts(textoCoord, root, puntosDeControl, x+40, y, x+50, y-50, x+60, y-10, x+60, x-50);
                pts(textoCoord, root, puntosDeControl, x+50, y-50, x+70, y+15, x+40, y-50, x+40, y+120);


                fun(root, puntosDeControl, x, y - 40, x + 10, y - 60, x + 30, y - 30, x + 20, y + 40, x + 20, y + 40, x + 10, y + 80, x - 10, y + 30, x + 40, y, x + 40, y, x + 60, y - 10, x + 60, y - 50, x + 50, y - 50, x + 50, y - 50, x + 40, y - 50, x + 40, y + 120, x + 70, y + 15);

                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x, y - 40, x + 10, y - 60, x + 30, y - 30, x + 20, y + 40); // primera curva hacia abajo
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 20, y + 40, x + 10, y + 80, x - 10, y + 30, x + 40, y); // segunda curva
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 40, y, x + 60, y - 10, x + 60, y - 50, x + 50, y - 50);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    CubicCurve c4 = new CubicCurve(x + 50, y - 50, x + 40, y - 50, x + 40, y + 120, x + 70, y + 15);
                    c4.setFill(Color.TRANSPARENT);
                    c4.setStroke(color);
                    c4.setStrokeWidth(grosor);

                    root.getChildren().add(c);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);
                    root.getChildren().add(c4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'i' || caracter == 'I' || caracter == 'í' || caracter == 'Í') {

            if (caracter == 'i' || caracter == 'í') {

                x = x - 20;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x+40, y+15, x-10, y+80, x+30, y+40);

                fun(root, puntosDeControl, x + 2, y, x - 10, y + 80, x + 30, y + 40, x + 40, y + 15);
                while(cont < auxBold) {
                    CubicCurve c = new CubicCurve(x + 30, y, x - 10, y + 80, x + 30, y + 40, x + 40, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    root.getChildren().add(c);

                    if (caracter == 'í') {
                        Line tilde = new Line(x + 35, y - 10, x + 45, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x, y-10, x+15, y-30);
                            fun(root, puntosDeControl, x, y - 10, x + 15, y - 30);
                        }

                        root.getChildren().add(tilde);
                    } else {
                        Circle p = new Circle(x + 35, y - 10, 1);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+3, y-10);
                            fun(root, puntosDeControl, x + 3, y - 10);
                        }

                        root.getChildren().add(p);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 40;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+50, y-40, x+20, y-60, x+30, y-40);
                pts(textoCoord, root, puntosDeControl, x+50, y-40, x+40, y+20, x+70, x-40, x+50, y-120);
                pts(textoCoord, root, puntosDeControl, x+40, y+20, x, y+30, x+35, y+70, x, y+40);


                fun(root, puntosDeControl, x, y - 50, x + 20, y - 60, x + 30, y - 40, x + 50, y - 40, x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 40, y + 20, x + 40, y + 20, x + 35, y + 70, x, y + 40, x, y + 30);
                while(cont < auxBold) {
                    CubicCurve c1 = new CubicCurve(x, y - 60, x + 20, y - 60, x + 30, y - 40, x + 50, y - 40);
                    c1.setFill(Color.TRANSPARENT);
                    c1.setStroke(color);
                    c1.setStrokeWidth(grosor);

                    CubicCurve c2 = new CubicCurve(x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 30, y + 20);
                    c2.setFill(Color.TRANSPARENT);
                    c2.setStroke(color);
                    c2.setStrokeWidth(grosor);

                    CubicCurve c3 = new CubicCurve(x + 30, y + 20, x + 25, y + 70, x, y + 40, x, y + 30);
                    c3.setFill(Color.TRANSPARENT);
                    c3.setStroke(color);
                    c3.setStrokeWidth(grosor);

                    root.getChildren().add(c1);
                    root.getChildren().add(c2);
                    root.getChildren().add(c3);

                    if (caracter == 'Í') {
                        Line tilde = new Line(x + 30, y - 60, x + 45, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30, y-60, x+45, y-80);
                            fun(root, puntosDeControl, x + 30, y - 60, x + 45, y - 80);
                        }

                        root.getChildren().add(tilde);
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'j' || caracter == 'J') {

            if (caracter == 'j') {

                x = x - 15;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-15, y+65, x+30, y+15, x-15, y+50, x+30, y+35);
                pts(textoCoord, root, puntosDeControl, x, y+70, x-15, y+65, x-5, y+95, x-20, y+85);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+70, x-1, y+20, x+5, y+60);
                pts(textoCoord, root, puntosDeControl, x, y-10);

                fun(root, puntosDeControl, x - 15, y + 65, x - 15, y + 50, x + 30, y + 35, x + 30, y + 15, x, y + 70, x - 5, y + 95, x - 20, y + 85, x - 15, y + 65, x, y, x - 1, y + 20, x + 5, y + 60, x, y + 70);

                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x - 15, y + 65, x - 15, y + 50, x + 30, y + 35, x + 30, y + 15); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);

                    CubicCurve cb2 = new CubicCurve(x, y + 70, x - 15, y + 95, x - 20, y + 85, x - 15, y + 65); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb2);

                    CubicCurve cb3 = new CubicCurve(x+20, y, x +20, y + 20, x + 5, y + 60, x, y + 70); //"l" superior
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb3);

                    Circle cd1 = new Circle(x+20, y - 10, 1);
                    cd1.setStrokeWidth(grosor);
                    cd1.setFill(Color.TRANSPARENT);
                    cd1.setStroke(color);

                    root.getChildren().add(cd1);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+50, y-40, x+20, y-50);
                pts(textoCoord, root, puntosDeControl, x+50, y-40, x+40, y+30, x+70, y-40, x+50, y-120);
                pts(textoCoord, root, puntosDeControl, x+40, y+30, x+5, y+40, x+40, y+55, x+10, y+60);
                pts(textoCoord, root, puntosDeControl, x+5, y+40, x+50, y-15, x, y+20, x+15, y);
                fun(root, puntosDeControl, x, y - 40, x + 50, y - 40, x + 20, y - 50, x + 70, y - 40, x + 50, y - 120, x + 40, y + 55, x + 10, y + 60, x + 50, y - 40, x + 40, y + 30, x + 40, y + 30, x + 5, y + 40, x + 5, y + 40, x + 50, y - 15);

                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x, y - 50, x + 20, y - 50, x + 50, y - 40);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    CubicCurve cb1 = new CubicCurve(x + 50, y - 40, x + 70, y - 40, x + 50, y - 120, x + 20, y + 30); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 20, y + 30, x + 20, y + 55, x, y + 60, x, y + 40); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb4 = new CubicCurve(x, y + 40, x, y + 20, x + 15, y, x + 50, y - 15);
                    cb4.setFill(Color.TRANSPARENT);
                    cb4.setStroke(color);
                    cb4.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'k' || caracter == 'K') {

            if (caracter == 'k') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x-1, y+50, x+37, y, x-3, y-150);
                pts(textoCoord, root, puntosDeControl, x, y+18, x+17, y+30, x+7, y-10, x+42, y+20);
                pts(textoCoord, root, puntosDeControl, x+17, y+30, x+55, y+15, x+37, y+72, x+47, y+50);
                fun(root, puntosDeControl, x + 2, y, x + 37, y, x - 3, y - 150, x + 7, y - 10, x + 42, y + 20, x + 37, y + 72, x + 47, y + 50, x - 1, y + 50, x, y + 18, x + 17, y + 30, x + 17, y + 30, x + 55, y + 15);

                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 2, y, x + 37, y, x - 3, y - 150, x - 1, y + 50); //"l" superior
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x, y + 18, x + 7, y - 10, x + 42, y + 20, x + 17, y + 30); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 17, y + 30, x + 37, y + 72, x + 35, y + 50, x + 55, y + 15);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else if (caracterAnt != '^') {
                Text t = new Text("\n" + caracter + ":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y - 20, x + 10, y + 40, x + 40, y - 120, x + 40, y + 80);
                pts(textoCoord, root, puntosDeControl, x + 10, y + 40, x + 60, y - 50, x - 20, y, x + 60, y);
                pts(textoCoord, root, puntosDeControl, x + 33, y - 5, x + 80, y + 15, x + 60, y - 10, x + 60, y + 115);
                fun(root, puntosDeControl, x, y - 20, x + 40, y - 120, x + 40, y + 80, x - 20, y, x + 60, y, x + 60, y - 10, x + 60, y + 115, x + 10, y + 40, x + 10, y + 40, x + 60, y - 50, x + 33, y - 5, x + 80, y + 15);

                while (cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y - 20, x + 40, y - 120, x + 40, y + 80, x + 10, y + 40); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 10, y + 40, x - 20, y, x + 60, y, x + 60, y - 50); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 33, y - 5, x + 60, y - 10, x + 60, y + 115, x + 80, y + 15);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if (auxBold > 1) {
                        x++;
                    }

                    cont++;
                }
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            }
        }
        if (caracter == 'l' || caracter == 'L') {
            if (caracter == 'l') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x-1, y+40, x+37, y-40, x-3, y-120);
                pts(textoCoord, root, puntosDeControl, x-1, y+40, x+30, y+15, x, y+60, x+20, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 37, y - 40, x - 3, y - 120, x, y + 60, x + 20, y + 60, x - 1, y + 40, x - 1, y + 40, x + 30, y + 15);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 60, y - 40, x + 40, y - 120, x - 1, y + 40); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x - 1, y + 41, x, y + 60, x + 20, y + 60, x + 30, y + 15);  //Curva derecha (conector)
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+15, y-5, x+80, y-80, x+5, y-60);
                pts(textoCoord, root, puntosDeControl, x+15, y-5, x+20, y+50, x+15, y+100, x-30, y+10);
                pts(textoCoord, root, puntosDeControl, x+20, y+50, x+50, y+15, x+45, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 15, y + 100, x - 30, y + 10, x + 45, y + 60, x + 15, y - 5, x + 15, y - 5, x + 20, y + 50, x + 20, y + 50, x + 50, y + 15);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x + 120, y - 80, x + 50, y - 80, x + 20, y - 5); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 20, y - 5, x , y + 100, x - 30, y + 10, x + 20, y + 50); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 20, y + 50, x + 45, y + 60, x + 50, y + 15);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);

                }
            }
        }
        if (caracter == 'm' || caracter == 'M') {
            if (caracter == 'm') {

                x = x - 11;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x-1, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+28, y+48, x+15, y-50);
                pts(textoCoord, root, puntosDeControl, x+28, y+48, x+48, y+48, x+40, y-50);
                pts(textoCoord, root, puntosDeControl, x+48, y+48, x+70, x+15, x+50, y+60, x+68, y+65);

                fun(root, puntosDeControl, x, y, x - 1, y + 50, x + 15, y - 50, x + 40, y - 50, x + 50, y + 60, x + 68, y + 65, x + 8, y + 50, x + 8, y + 50, x + 28, y + 48, x + 28, y + 48, x + 48, y + 48, x + 48, y + 48, x + 70, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x+15, y, x, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 55, y - 50, x + 28, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    QuadCurve qv3 = new QuadCurve(x + 28, y + 48, x + 75, y - 50, x + 48, y + 48);
                    qv3.setFill(Color.TRANSPARENT);
                    qv3.setStroke(color);
                    qv3.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 48, y + 48, x + 50, y + 60, x + 68, y + 65, x + 70, y + 15); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(qv3);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 71;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                pts(textoCoord, root, puntosDeControl, x+15, y+50, x+40, y+40, x+35, y-90);
                pts(textoCoord, root, puntosDeControl, x+40, y+40, x+65, y+50, x+60, y-83);

                fun(root, puntosDeControl, x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 35, y - 90, x + 60, y - 83, x + 15, y + 50, x + 15, y + 50, x + 40, y + 40, x + 40, y + 40, x + 65, y + 50);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 50, y - 85, x + 15, y + 50); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 70, y - 90, x + 40, y + 40);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 40, y + 40, x + 105, y - 83, x + 65, y + 50);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 78;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'n' || caracter == 'N') {
            if (caracter == 'n') {

                x = x - 11;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+30, y+48, x+30, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y+48, x+50, y+15, x+30, y+60, x+45, y+65);

                fun(root, puntosDeControl, x, y, x + 50, y + 50, x + 30, y - 50, x + 30, y + 60, x + 45, y + 65, x + 8, y + 50, x + 8, y + 50, x + 30, y + 48, x + 30, y + 48, x + 50, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x+15, y, x, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 55, y - 50, x + 30, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 30, y + 48, x + 30, y + 60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                if(caracterAnt != '^') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                    pts(textoCoord, root, puntosDeControl, x+15, y+50, x+45, y+60, x+40, y-93);

                    fun(root, puntosDeControl, x + 5, y + 15, x - 15, y - 70, x + 29, y - 85, x + 40, y - 93, x + 15, y + 50, x + 15, y + 50, x + 45, y + 60);
                    while(cont < auxBold) {
                        CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 60, y - 85, x + 15, y + 50); // primera curva hacia
                        // abajo
                        cb1.setFill(Color.TRANSPARENT);
                        cb1.setStroke(color);
                        cb1.setStrokeWidth(grosor);

                        QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 80, y - 93, x + 45, y + 60);
                        qv1.setFill(Color.TRANSPARENT);
                        qv1.setStroke(color);
                        qv1.setStrokeWidth(grosor);

                        root.getChildren().add(cb1);
                        root.getChildren().add(qv1);

                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }
                    x = x + 55;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu, x, y, root);

                    }
                }else{
                    auxBold = 4;
                }
            }
        }
        if (caracter == 'ñ' || caracter == 'Ñ') {
            if (caracter == 'ñ') {

                x = x - 11;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8, y+50, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+8, y+50, x+30, y+48, x+30, y-50);
                pts(textoCoord, root, puntosDeControl, x+30, y+48, x+50, y+15, x+30, y+60, x+45, y+65);

                fun(root, puntosDeControl, x, y, x + 50, y + 50, x + 30, y - 50, x + 30, y + 60, x + 45, y + 65, x + 8, y + 50, x + 8, y + 50, x + 30, y + 48, x + 30, y + 48, x + 50, y + 15);
                while(cont < auxBold) {
                    QuadCurve qv1 = new QuadCurve(x+15, y, x, y + 50, x + 8, y + 50);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    QuadCurve qv2 = new QuadCurve(x + 8, y + 50, x + 55, y - 50, x + 30, y + 48);
                    qv2.setFill(Color.TRANSPARENT);
                    qv2.setStroke(color);
                    qv2.setStrokeWidth(grosor);

                    CubicCurve cb1 = new CubicCurve(x + 30, y + 48, x + 30, y + 60, x + 45, y + 65, x + 50, y + 15); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 30, y - 15, x + 35, y - 25, x + 40, y - 5, x + 45, y - 15);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5, y+15, x+15, y+50, x-15, y-70, x+29, y-85);
                pts(textoCoord, root, puntosDeControl, x+15, y+50, x+45, y+60, x+40, y-93);
                pts(textoCoord, root, puntosDeControl, x+25, y-40, x+45, y-40, x+30, y-50, x+40, y-30);

                fun(root, puntosDeControl, x + 5, y + 15, x + 30, y - 50, x + 40, y - 30, x - 15, y - 70, x + 29, y - 85, x + 40, y - 93, x + 15, y + 50, x + 15, y + 50, x + 45, y + 60);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 5, y + 15, x - 15, y - 70, x + 60, y - 85, x + 15, y + 50); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 15, y + 50, x + 80, y - 93, x + 45, y + 60);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 40, y - 40, x + 45, y - 50, x + 55, y - 30, x + 60, y - 40);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'o' || caracter == 'O' || caracter == 'ó' || caracter == 'Ó') {
            if (caracter == 'o' || caracter == 'ó') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+30, y+20, x, y+60, x+30, y+60);
                pts(textoCoord, root, puntosDeControl, x+30, y+20, x, y+20, x+30, y-5, x, y-5);
                pts(textoCoord, root, puntosDeControl, x+5, y+6, x+50, y+15, x+30, y+50);

                fun(root, puntosDeControl, x, y + 20, x, y + 60, x + 30, y + 60, x + 30, y + 20, x + 30, y + 20, x + 30, y - 5, x, y - 5, x, y + 20, x + 5, y + 6, x + 30, y + 50, x + 50, y + 15);
                while(cont < auxBold) {

                    CubicCurve cb1 = new CubicCurve(x, y + 20, x-20, y + 60, x + 10, y + 60, x + 30, y + 20); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 30, y + 20, x + 40, y - 5, x+10, y - 5, x, y + 20);
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    QuadCurve qv1 = new QuadCurve(x + 9, y + 6, x + 30, y + 50, x + 50, y + 15);
                    qv1.setFill(Color.TRANSPARENT);
                    qv1.setStroke(color);
                    qv1.setStrokeWidth(grosor);


                    if (caracter == 'ó') {
                        Line tilde = new Line(x + 20, y - 10, x + 35, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20, y-10, x+35, y-30);
                            fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);
                        }


                        root.getChildren().add(tilde);

                    }
                    Text t8 = new Text("\n");
                    textoCoord.getChildren().add(t8);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(qv1);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13, y-10, x+57, y-10, x, y+70, x+57, y+70);
                pts(textoCoord, root, puntosDeControl, x+57, y-10, x+45, y+10, x+40, y-125, x-55, y+50);

                fun(root, puntosDeControl, x + 13, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10, x + 57, y - 10, x + 40, y - 125, x - 55, y + 50, x + 45, y + 10);
                while(cont < auxBold) {

                    CubicCurve cb1 = new CubicCurve(x + 13, y - 10, x, y + 70, x + 37, y + 70, x + 57, y - 10); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 57, y - 10, x + 80, y - 125, x - 20, y + 50, x + 45, y + 10); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    if (caracter == 'Ó') {
                        Line tilde = new Line(x + 20, y - 60, x + 35, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        if(cont < 1) {
                            pts(textoCoord, root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                            fun(root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                        }
                        root.getChildren().add(tilde);
                    }
                    Text t6 = new Text("\n");
                    textoCoord.getChildren().add(t6);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'p' || caracter == 'P') {
            if (caracter == 'p') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+85, x-2, y+15);
                pts(textoCoord, root, puntosDeControl, x+1, y+15, x+25, y+50, x+40, y-15, x+35, y+50);
                pts(textoCoord, root, puntosDeControl, x+25, y+50, x+30, y+35, x, y+60, x, y+30);
                pts(textoCoord, root, puntosDeControl, x+30, y+35, x+55, y+15, x+40, y+30);

                fun(root, puntosDeControl, x, y, x, y + 85, x - 2, y + 15, x + 1, y + 15, x + 25, y + 50, x + 40, y - 15, x + 35, y + 50, x + 25, y + 50, x + 30, y + 35, x, y + 60, x, y + 30, x + 30, y + 35, x + 55, y + 15, x + 40, y + 30);
                while(cont < auxBold) {
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

                    root.getChildren().add(qv1);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+25, y+85, x, y-70, x+30, y-90);
                pts(textoCoord, root, puntosDeControl, x+24, y-20, x+26, y+30, x+60, y-110, x+70, y+60);

                fun(root, puntosDeControl, x, y + 15, x, y - 70, x + 30, y - 90, x + 60, y - 110, x + 70, y + 60, x + 25, y + 85, x + 24, y - 20, x + 26, y + 30);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x, y + 15, x+30, y - 70, x + 60, y - 90, x + 12, y + 85); // primera curva hacia
                    // abajo
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 34, y - 20, x + 120, y - 110, x + 100, y + 60, x + 26, y + 30); //Curva principal
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);


                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 58;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'q' || caracter == 'Q') {
            if (caracter == 'q') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30, y, x+30, y+85, x+28, y+28);
                pts(textoCoord, root, puntosDeControl, x+28, y+12, x+28, y+40, x-12, y-10, x-13, y+60);
                pts(textoCoord, root, puntosDeControl, x+30, y+47, x+60, y+15, x+50, y+47);
                pts(textoCoord, root, puntosDeControl, x+30, y+85, x+30, y+47, x+40, y+80, x+40, y+50);

                fun(root, puntosDeControl, x + 30, y + 85, x + 28, y + 28, x - 12, y - 10, x - 13, y + 60, x + 50, y + 47, x + 40, y + 80, x + 40, y + 50, x + 28, y + 12, x + 28, y + 40, x + 30, y + 47, x + 60, y + 15, x + 30, y + 85, x + 30, y + 47);
                while(cont < auxBold) {
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

                    root.getChildren().add(qv1);
                    root.getChildren().add(qv2);
                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13, y-10, x+57, y-10, x, y+70, x+57, y+70);
                pts(textoCoord, root, puntosDeControl, x+57, y-10, x+45, y+10, x+40, y-125, x-55, y+50);
                pts(textoCoord, root, puntosDeControl, x+35, y+37, x+65, y+47, x+45, y+27, x+55, y+62);

                fun(root, puntosDeControl, x + 13, y - 10, x + 57, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10, x + 45, y + 10, x + 40, y - 125, x - 55, y + 50, x + 35, y + 37, x + 65, y + 47, x + 45, y + 27, x + 55, y + 62);
                while(cont < auxBold) {
                    CubicCurve cb1 = new CubicCurve(x + 13, y - 10, x, y + 70, x + 57, y + 70, x + 57, y - 10); //Curva principal
                    cb1.setFill(Color.TRANSPARENT);
                    cb1.setStroke(color);
                    cb1.setStrokeWidth(grosor);

                    CubicCurve cb2 = new CubicCurve(x + 57, y - 10, x + 40, y - 125, x - 55, y + 50, x + 45, y + 10); //Semi ovalo
                    cb2.setFill(Color.TRANSPARENT);
                    cb2.setStroke(color);
                    cb2.setStrokeWidth(grosor);

                    CubicCurve cb3 = new CubicCurve(x + 35, y + 37, x + 45, y + 27, x + 55, y + 62, x + 65, y + 47);  //Curva derecha (conector)
                    cb3.setFill(Color.TRANSPARENT);
                    cb3.setStroke(color);
                    cb3.setStrokeWidth(grosor);

                    root.getChildren().add(cb1);
                    root.getChildren().add(cb2);
                    root.getChildren().add(cb3);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }

        }
        if (caracter == 'r' || caracter == 'R') {
            if (caracter == 'r') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+30, y, x+30, y, x+55, y+15);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+30, y, x+30, y, x+55, y+15);

                fun(root, puntosDeControl, x + 9 - 10, y + 10, x + 10 - 10, y - 21, x - 22 - 10, y + 40, x + 30, y, x + 30, y, x + 9, y + 28, x + 25, y + 95, x + 55, y + 15);
                while(cont < auxBold) {
                    if (caracterAnt == 'K') {
                        CubicCurve a = new CubicCurve(x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        Text t6 = new Text("\nX1: " + (x + 20) + " Y1: " + (y + 40) + "\tX2: " + (x + 60) + " Y2: " + (y + 15));
                        Text t7 = new Text("\nX1: " + (x + 10) + " Y1: " + (y + 60) + "\tX2: " + (x + 50) + " Y2: " + (y + 65) + "\n");

                        t7.setFill(Color.RED);

                        textoCoord.getChildren().add(t6);
                        textoCoord.getChildren().add(t7);

                        fun(root, puntosDeControl, x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);

                        root.getChildren().add(a);
                        x = x + 60;
                        if (auxSub) {
                            Subrayar(xInicialSu, yInicialSu, x, y, root);
                        }
                    }
                    //CurvA
                    CubicCurve a = new CubicCurve(x + 20, y + 10, x + 10 - 10, y - 21, x - 22 - 10, y + 40, x + 50, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 50, y, x + 9, y + 28, x + 25, y + 95, x + 55, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //EspacioDecaracterR
                x = x + 55;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+20, y-50, x+15, y-20);
                pts(textoCoord, root, puntosDeControl, x+20, y-50, x+10, y+50, x+25, y);
                pts(textoCoord, root, puntosDeControl, x+20, y-40, x+20, y, x+80, y-80, x+50, y+20);
                pts(textoCoord, root, puntosDeControl, x+20, y+40, x+60, y+55, x+40, y, x+40, y+55);
                pts(textoCoord, root, puntosDeControl, x+60, y+55, x+80, y+15, x+70, y+55);

                fun(root, puntosDeControl, x, y + 15, x + 15, y - 20, x + 20, y - 50, x + 20, y - 50, x + 25, y, x + 10, y + 50, x + 20, y - 40, x + 80, y - 80, x + 50, y + 20, x + 20, y, x + 20, y, x + 40, y, x + 40, y + 55, x + 60, y + 55, x + 60, y + 55, x + 70, y + 55, x + 80, y + 15);
                while(cont < auxBold) {//CurvA
                    QuadCurve a = new QuadCurve(x, y + 15, x + 15, y - 20, x + 20, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvB
                    QuadCurve b = new QuadCurve(x + 20, y - 50, x + 25, y, x + 10, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve c = new CubicCurve(x + 20, y - 40, x + 80, y - 80, x + 50, y + 20, x + 20, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve d = new CubicCurve(x + 20, y, x + 40, y, x + 40, y + 55, x + 60, y + 55);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //CurvB
                    QuadCurve e = new QuadCurve(x + 60, y + 55, x + 70, y + 55, x + 80, y + 15);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 's' || caracter == 'S') {
            if (caracter == 's') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20, y+35, x, y+15, x-40, y-15, x+40, y-15);
                pts(textoCoord, root, puntosDeControl, x+20, y+35, x+22, y+40, x+45, y+60, x-10, y+60);
                pts(textoCoord, root, puntosDeControl, x+22, y+40, x+40, y+15, x+35, y+30);


                fun(root, puntosDeControl, x + 20, y + 35, x - 40, y - 15, x + 40, y - 15, x, y + 10 + 5, x + 20, y + 35, x + 45, y + 60, x - 10, y + 60, x + 22, y + 40, x + 22, y + 40, x + 35, y + 30, x + 40, y + 15);
                while(cont < auxBold) {

                    if (caracterAnt == 'K') {
                        CubicCurve a = new CubicCurve(x + 20, y + 40, x, y + 60, x + 20, y + 65, x + 60, y + 15);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        if(cont < 1){
                            fun(root, puntosDeControl, x + 20, y + 40, x + 10, y + 60, x + 50, y + 65, x + 60, y + 15);
                            pts(textoCoord, root, puntosDeControl, x+20, y+40, x+60, y+15, x+10, y+60, x+50, y-65);
                        }

                        root.getChildren().add(a);
                        x = x + 60;
                        if (auxSub) {
                            Subrayar(xInicialSu, yInicialSu, x, y, root);
                        }
                    }
                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 20, y + 35, x - 30, y - 30, x + 40, y - 15, x, y + 10 + 5);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurbaB
                    CubicCurve b = new CubicCurve(x + 20, y + 35, x + 30, y + 60, x - 10, y + 60, x + 22, y + 40);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurbaC
                    QuadCurve c = new QuadCurve(x + 22, y + 40, x + 35, y + 30, x + 40, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //Espaciocaracter s
                x = x + 40;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                if (caracterAnt != '^') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);

                    pts(textoCoord, root, puntosDeControl, x-1, y+15, x+10, y+40, x, y-15, x-30, y+20);
                    pts(textoCoord, root, puntosDeControl, x+10, y+40, x+25, y, x+65, y+70, x+50, y+10);
                    pts(textoCoord, root, puntosDeControl, x+44, y+47, x+70, y+15, x+55, y+45);
                    pts(textoCoord, root, puntosDeControl, x+25, y, x+35, y-20, x-30, y-30, x+90, y-80);

                    fun(root, puntosDeControl, x - 1, y + 15, x, y - 15, x - 30, y + 20, x + 10, y + 40, x + 10, y + 40, x + 65, y + 70, x + 50, y + 10, x + 25, y, x + 44, y + 47, x + 55, y + 45, x + 70, y + 15, x + 25, y, x - 30, y - 30, x + 90, y - 80, x + 35, y - 20);

                    while(cont < auxBold) {//CurvaA
                        CubicCurve a = new CubicCurve(x - 1, y + 15, x, y - 15, x - 30, y + 20, x + 10, y + 40);
                        a.setFill(Color.TRANSPARENT);
                        a.setStroke(color);
                        a.setStrokeWidth(grosor);

                        //CurvaB
                        CubicCurve b = new CubicCurve(x + 10, y + 40, x + 65, y + 70, x + 50, y + 10, x + 25, y);
                        b.setFill(Color.TRANSPARENT);
                        b.setStroke(color);
                        b.setStrokeWidth(grosor);

                        //CurvaC
                        QuadCurve c = new QuadCurve(x + 44, y + 47, x + 55, y + 45, x + 70, y + 15);
                        c.setFill(Color.TRANSPARENT);
                        c.setStroke(color);
                        c.setStrokeWidth(grosor);

                        //CurvaD
                        CubicCurve d = new CubicCurve(x + 25, y, x - 30, y - 30, x + 90, y - 80, x + 35, y - 20);
                        d.setFill(Color.TRANSPARENT);
                        d.setStroke(color);
                        d.setStrokeWidth(grosor);




                        root.getChildren().add(a);
                        root.getChildren().add(b);
                        root.getChildren().add(c);
                        root.getChildren().add(d);

                        if(auxBold > 1){
                            x++;
                        }

                        cont++;
                    }
                    x = x + 70;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu, x, y, root);
                    }
                } else {// Cuando quiere subrayar
                    auxSub = true;
                    xInicialSu = x;
                    yInicialSu = y + 55;
                }

            }

        }
        if (caracter == 't' || caracter == 'T') {
            if (caracter == 't') {

                x = x - 5;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+10, y-40, x+30, y+15, x-15, y, x+15, y+100);
                pts(textoCoord, root, puntosDeControl, x-10, y-25, x+15, y-25, x-5, y-30, x+10, y-20);

                fun(root, puntosDeControl, x + 10, y - 40, x - 15, y, x + 15, y + 100, x + 30, y + 15, x - 10, y - 25, x - 5, y - 30, x + 10, y - 20, x + 15, y - 25);


                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 40, y - 40, x - 15, y, x + 15, y + 100, x + 30, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 5, y - 25, x + 10, y - 30, x + 35, y - 20, x + 40, y - 25);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //EspaciocaracterT
                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+10, y-50, x+30, y+15, x-20, y, x+15, y+100);
                pts(textoCoord, root, puntosDeControl, x-30, y-40, x+45, y-55, x-20, y-55, x+40, y-40);


                fun(root, puntosDeControl, x + 10, y - 50, x - 20, y, x + 15, y + 100, x + 30, y + 15, x - 30, y - 40, x - 20, y - 55, x + 40, y - 40, x + 45, y - 55);

                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 40, y - 50, x - 20, y, x + 15, y + 100, x + 30, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaA
                    CubicCurve b = new CubicCurve(x - 5, y - 40, x + 5, y - 55, x + 65, y - 40, x + 70, y - 55);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 30;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'u' || caracter == 'U' || caracter == 'ü' || caracter == 'Ü' || caracter == 'ú' || caracter == 'Ú') {
            if (caracter == 'u' || caracter == 'ü' || caracter == 'ú') {

                x = x - 4;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                fun(root, puntosDeControl, x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 28, y, x + 18, y + 30, x + 33, y + 100, x + 48, y + 15);

                pts(textoCoord, root, puntosDeControl, x+2, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+28, y, x+48, y+15, x+18, y+30, x+33, y+100);
                while(cont < auxBold) {

                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 12, y, x - 6, y + 30, x + 9, y + 80, x + 34, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 42, y, x + 18, y + 30, x + 33, y + 100, x + 48, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);


                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);

                    if (caracter == 'ü') {
                        Circle p = new Circle(x + 12, y - 10, 2);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        Circle p2 = new Circle(x + 42, y - 10, 2);
                        p2.setFill(Color.TRANSPARENT);
                        p2.setStroke(color);
                        p2.setStrokeWidth(grosor);

                        root.getChildren().add(p);
                        root.getChildren().add(p2);

                        fun(root, puntosDeControl, x + 2, y - 10, x + 28, y - 10);

                        Text t5 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 10));
                        Text t6 = new Text("\n");
                        Text t7 = new Text("\nX1: " + (x + 28) + " Y1: " + (y - 10));
                        Text t8 = new Text("\n");

                        t5.setFill(Color.BLUE);
                        t6.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t5);
                        textoCoord.getChildren().add(t6);
                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);

                    }
                    if (caracter == 'ú') {
                        Line tilde = new Line(x + 25, y - 10, x + 40, y - 30);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);

                        fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);

                        Text t9 = new Text("\nX1: " + (x + 20) + " Y1: " + (y - 10) + "\tX2: " + (x + 35) + " Y2: " + (y - 30) + "\n");
                        t9.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t9);

                        root.getChildren().add(tilde);
                    }
                    Text t10 = new Text("\n");
                    textoCoord.getChildren().add(t10);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de caracter i
                x = x + 45;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15, x + 28 + 5, y - 35, x + 18 + 5, y + 30, x + 33 + 5, y + 100, x + 48 + 5, y + 15, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);

                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+29, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+33, y-35, x+53, y+15, x+22, y+30, x+38, y+100);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+20, y-20, x+10, y-60, x-20, y-50);
                while(cont < auxBold) {
                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 20, y - 35, x - 10, y + 30, x + 9, y + 80, x + 35, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 52, y - 35, x + 18 + 5, y + 30, x + 33 + 5, y + 100, x + 48 + 5, y + 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve c = new CubicCurve(x + 20, y - 35, x + 30, y - 60, x - 20, y - 50, x - 20, y - 20);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);




                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if (caracter == 'Ü') {
                        Circle p = new Circle(x + 20, y - 60, 2);
                        p.setFill(Color.TRANSPARENT);
                        p.setStroke(color);
                        p.setStrokeWidth(grosor);

                        Circle p2 = new Circle(x + 52, y - 60, 2);
                        p2.setFill(Color.TRANSPARENT);
                        p2.setStroke(color);
                        p2.setStrokeWidth(grosor);

                        fun(root, puntosDeControl, x + 2, y - 60, x + 33, y - 60);


                        Text t7 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 60) + "\n");
                        Text t8 = new Text("\nX1: " + (x + 33) + " Y1: " + (y - 60) + "\n");

                        t7.setFill(Color.BLUE);
                        t8.setFill(Color.BLUE);

                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);

                        root.getChildren().add(p);
                        root.getChildren().add(p2);
                    }
                    if (caracter == 'Ú') {
                        Line tilde = new Line(x + 35, y - 60, x + 50, y - 80);
                        tilde.setFill(Color.TRANSPARENT);
                        tilde.setStroke(color);
                        tilde.setStrokeWidth(grosor);
                        fun(root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);

                        Text t9 = new Text("\nX1: " + (x + 20) + " Y1: " + (y - 60) + "\tX2: " + (x + 35) + " Y2: " + (y - 80) + "\n");
                        t9.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t9);
                        root.getChildren().add(tilde);
                    }
                    Text t10 = new Text("\n");
                    textoCoord.getChildren().add(t10);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de caracter i
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
                x = x + 55;
            }
        }
        if (caracter == 'v' || caracter == 'V') {
            if (caracter == 'v') {

                x = x + 11;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3, y, x+63, y, x+10, y+63, x+25, y+63);
                pts(textoCoord, root, puntosDeControl, x+35, y, x+30, y+25, x+35, y-20, x+10, y+12);
                pts(textoCoord, root, puntosDeControl, x+30, y+25, x+50, y+15, x+35, y+25, x+45, y+20);

                fun(root, puntosDeControl, x - 3, y, x + 10, y + 63, x + 25, y + 63, x + 35, y, x + 35, y, x + 35, y - 20, x + 10, y + 12, x + 30, y + 25, x + 30, y + 25, x + 35, y + 25, x + 45, y + 20, x + 50, y + 15);

                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x - 3, y, x-25, y + 63, x, y + 63, x + 35, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve b = new CubicCurve(x + 35, y, x + 35, y - 20, x + 10, y + 12, x + 30, y + 25);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve c = new CubicCurve(x + 30, y + 25, x + 35, y + 25, x + 45, y + 20, x + 50, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //espaciocaracter v
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x+10, y-60, x-20, y-50);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+35, y-15, x-6, y+30, x+9, y+100);
                pts(textoCoord, root, puntosDeControl, x+35, y-15, x+30, y+10, x+35, y-35, x+10, y-3);
                pts(textoCoord, root, puntosDeControl, x+30, y+10, x+50, y, x+35, y+10, x+45, y+5);

                fun(root, puntosDeControl, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20, x + 2, y - 35, x - 6, y + 30, x + 9, y + 100, x + 35, y - 15, x + 35, y - 15, x + 35, y - 20 - 15, x + 10, y + 12 - 15, x + 30, y + 25 - 15, x + 30, y + 25 - 15, x + 35, y + 25 - 15, x + 45, y + 20 - 15, x + 50, y);


                while(cont < auxBold) {//CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 35, y + 30, x, y + 100, x + 35, y - 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve b = new CubicCurve(x + 35, y - 15, x + 35, y - 20 - 15, x + 10, y + 12 - 15, x + 30, y + 25 - 15);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve c = new CubicCurve(x + 30, y + 25 - 15, x + 35, y + 25 - 15, x + 45, y + 20 - 15, x + 50, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                if(auxBold > 1){
                    x++;
                }
                //espaciocaracter v
                x = x + 50;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'w' || caracter == 'W') {
            if (caracter == 'w') {

                x = x + 12;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+4, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+24, y+15, x+50, y, x+20, y+73, x+40, y+83);
                pts(textoCoord, root, puntosDeControl, x+50, y, x+45, y+25, x+50, y-20, x+25, y+12);
                pts(textoCoord, root, puntosDeControl, x+45, y+25, x+65, y+15, x+50, y+25, x+60, y+20);

                fun(root, puntosDeControl, x + 4, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 24, y + 15, x + 20, y + 73, x + 40, y + 83, x + 50, y, x + 50, y, x + 50, y - 20, x + 25, y + 12, x + 45, y + 25, x + 45, y + 25, x + 50, y + 25, x + 60, y + 20, x + 65, y + 15);


                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 4, y, x - 30, y + 30, x-10, y + 80, x + 24, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);
                    //curvaA
                    CubicCurve b = new CubicCurve(x + 24, y + 15, x-10, y + 73, x + 30, y + 83, x + 50, y);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve c = new CubicCurve(x + 50, y, x + 50, y - 20, x + 25, y + 12, x + 45, y + 25);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve d = new CubicCurve(x + 45, y + 25, x + 50, y + 25, x + 60, y + 20, x + 65, y + 15);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //espaciocaracter v
                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                Text t1 = new Text("\n" + caracter + "\n" + "X1: " + (x + 2) + " Y1: " + (y - 35) + "\tX2: " + (x + 29) + " Y2: " + (y + 15));
                Text t2 = new Text("\nX3: " + (x - 6) + " Y3: " + (y + 30) + "\tX4: " + (x + 9) + " Y4: " + (y + 80) + "\n");

                Text t3 = new Text("\nX1: " + (x + 30) + " Y1: " + (y + 25) + "\tX2: " + (x + 60) + " Y2: " + (y - 13));
                Text t4 = new Text("\nX3: " + (x + 25) + " Y3: " + (y + 73) + "\tX4: " + (x + 45) + " Y4: " + (y + 83) + "\n");

                Text t5 = new Text("\nX1: " + (x + 2) + " Y1: " + (y - 35) + "\tX2: " + (x - 20) + " Y2: " + (y - 20));
                Text t6 = new Text("\nX3: " + (x + 10) + " Y3: " + (y - 60) + "\tX4: " + (x - 20) + " Y4: " + (y - 50) + "\n");

                Text t7 = new Text("\nX1: " + (x + 55) + " Y1: " + (y - 15) + "\tX2: " + (x + 55) + " Y2: " + (y + 10));
                Text t8 = new Text("\nX3: " + (x + 60) + " Y3: " + (y - 35) + "\tX4: " + (x + 35) + " Y4: " + (y - 3) + "\n");

                Text t9 = new Text("\nX1: " + (x + 55) + " Y1: " + (y + 10) + "\tX2: " + (x + 75) + " Y2: " + (y));
                Text t10 = new Text("\nX3: " + (x + 60) + " Y3: " + (y + 10) + "\tX4: " + (x + 70) + " Y4: " + (y + 5) + "\n");

                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15, x + 30, y, x + 25, y + 73, x + 45, y + 83, x + 60, y - 13, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20, x + 35 + 25, y - 15, x + 35 + 25, y - 20 - 15, x + 10 + 25, y + 12 - 15, x + 30 + 25, y + 25 - 15, x + 30 + 25, y + 25 - 15, x + 35 + 25, y + 25 - 15, x + 45 + 25, y + 20 - 15, x + 50 + 25, y);

                t2.setFill(Color.RED);
                t4.setFill(Color.RED);
                t6.setFill(Color.RED);
                t8.setFill(Color.RED);
                t10.setFill(Color.RED);

                textoCoord.getChildren().add(t1);
                textoCoord.getChildren().add(t2);
                textoCoord.getChildren().add(t3);
                textoCoord.getChildren().add(t4);
                textoCoord.getChildren().add(t5);
                textoCoord.getChildren().add(t6);
                textoCoord.getChildren().add(t7);
                textoCoord.getChildren().add(t8);
                textoCoord.getChildren().add(t9);
                textoCoord.getChildren().add(t10);

                while(cont < auxBold) {//CurvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);
                    //curvaA
                    CubicCurve b = new CubicCurve(x + 30, y, x + 25, y + 73, x + 45, y + 83, x + 60, y - 13);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);
                    //CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //curvaB
                    CubicCurve c = new CubicCurve(x + 35 + 25, y - 15, x + 35 + 25, y - 20 - 15, x + 10 + 25, y + 12 - 15, x + 30 + 25, y + 25 - 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //curvaC
                    CubicCurve e = new CubicCurve(x + 30 + 25, y + 25 - 15, x + 35 + 25, y + 25 - 15, x + 45 + 25, y + 20 - 15, x + 50 + 25, y);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);


                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
        if (caracter == 'x' || caracter == 'X') {
            if (caracter == 'x') {

                x = x - 10;

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3, y+10, x+60, y+15, x+45, y+100, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x+5, y+50, x+45, y, x+30, y+10);


                fun(root, puntosDeControl, x - 3, y + 10, x + 45, y + 100, x + 50, y + 50, x + 60, y + 15, x + 5, y + 50, x + 30, y + 10, x + 45, y);


                while(cont < auxBold) {//curva a
                    CubicCurve a = new CubicCurve(x + 15, y + 10, x + 20, y + 100, x + 50, y + 50, x + 60, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curva b
                    QuadCurve b = new QuadCurve(x + 5, y + 50, x + 60, y + 10, x + 45, y);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+80, y+15, x+45, y+100, x+50, y+50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+45, y-50, x-10, y);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x-5, y-60, x-20, y-50);


                fun(root, puntosDeControl, x + 2, y - 35, x + 45, y + 100, x + 50, y + 50, x + 80, y + 15, x, y + 50, x - 10, y, x + 45, y - 50, x + 2, y - 35, x - 5, y - 60, x - 20, y - 50, x - 20, y - 20);


                while(cont < auxBold) {//curva a
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x + 25, y + 100, x + 50, y + 50, x + 80, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curva b
                    QuadCurve b = new QuadCurve(x, y + 50, x+60, y, x + 45, y - 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve c = new CubicCurve(x + 2, y - 35, x - 5, y - 60, x - 20, y - 50, x - 20, y - 20);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 80;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'y' || caracter == 'Y') {
            if (caracter == 'y') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y, x+24, y+15, x-6, y+30, x+9, y+80);
                pts(textoCoord, root, puntosDeControl, x+24, y, x+24, y+50, x+35, y+113, x-40, y+98);
                pts(textoCoord, root, puntosDeControl, x+23, y+51, x+45, y+15, x+35, y+50);


                fun(root, puntosDeControl, x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15, x + 24, y, x + 35, y + 113, x - 40, y + 98, x + 24, y + 50, x + 23, y + 51, x + 35, y + 50, x + 45, y + 15);

                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x + 2, y, x - 6, y + 30, x + 9, y + 80, x + 24, y + 15);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 24, y, x + 35, y + 113, x - 40, y + 98, x + 24, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 23, y + 51, x + 35, y + 50, x + 45, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //espaciocaracter v
                x = x + 45;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x+30, y-35, x-6, y-20, x+9, y+30);
                pts(textoCoord, root, puntosDeControl, x+30, y-50, x+25, y+10, x+30, y+90, x-35, y+55);
                pts(textoCoord, root, puntosDeControl, x+28, y+10, x+50, y, x+40, y+10);
                pts(textoCoord, root, puntosDeControl, x+2, y-35, x-20, y-20, x+10, y-60, x-20, y-50);


                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30 - 50, x + 9, y + 80 - 50, x + 30, y + 15 - 50, x + 30, y - 50, x + 30, y + 140 - 50, x - 40 + 5, y + 105 - 50, x + 25, y + 10, x + 23 + 5, y + 10, x + 40, y + 10, x + 50, y, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);


                while(cont < auxBold) {//curvaA
                    CubicCurve a = new CubicCurve(x + 2, y - 35, x - 6, y + 30 - 50, x + 9, y + 80 - 50, x + 30, y + 15 - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //CurvaB
                    CubicCurve b = new CubicCurve(x + 30, y - 50, x + 30, y + 140 - 50, x - 40 + 5, y + 105 - 50, x + 25, y + 10);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    QuadCurve c = new QuadCurve(x + 23 + 5, y + 10, x + 40, y + 10, x + 50, y);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvaC
                    CubicCurve d = new CubicCurve(x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);


                    //Roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 46;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }

            }
        }
        if (caracter == 'z' || caracter == 'Z') {
            if (caracter == 'z') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1, y+10, x+40, y, x, y-21, x-32, y+40);
                pts(textoCoord, root, puntosDeControl, x+40, y, x+7, y+47);
                pts(textoCoord, root, puntosDeControl, x+7, y+47, x+35, y+90, x+50, y+10, x+45, y+80);
                pts(textoCoord, root, puntosDeControl, x+35, y+90, x+40, y+50, x+15, y+120, x-15, y+45);
                pts(textoCoord, root, puntosDeControl, x+40, y+50, x+60, y+15, x+55, y+50, x+60, y+15);


                fun(root, puntosDeControl, x - 1, y + 10, x, y - 21, x - 32, y + 40, x + 40, y, x + 40, y, x + 7, y + 47, x + 7, y + 47, x + 50, y + 10, x + 45, y + 80, x + 35, y + 90, x + 35, y + 90, x + 15, y + 120, x - 15, y + 45, x + 40, y + 50, x + 40, y + 50, x + 55, y + 50, x + 60, y + 15);


                while(cont < auxBold) {//CurvA
                    CubicCurve a = new CubicCurve(x - 1, y + 10, x, y - 21, x - 32, y + 40, x + 40, y);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    //curvaB
                    Line b = new Line(x + 40, y, x + 7, y + 47);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    //CurvC
                    CubicCurve c = new CubicCurve(x + 7, y + 47, x + 50, y + 10, x + 45, y + 80, x + 35, y + 90);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    //CurvD
                    CubicCurve d = new CubicCurve(x + 35, y + 90, x + 15, y + 120, x - 15, y + 45, x + 40, y + 50);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);

                    //curvaE
                    QuadCurve e = new QuadCurve(x + 40, y + 50, x + 55, y + 50, x + 60, y + 15);
                    e.setFill(Color.TRANSPARENT);
                    e.setStroke(color);
                    e.setStrokeWidth(grosor);



                    //roots
                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);
                    root.getChildren().add(e);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de z
                x = x + 60;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+65, y-50, x+25, y-45);
                pts(textoCoord, root, puntosDeControl, x+65, y-50, x, y+50, x+25, y-45);
                pts(textoCoord, root, puntosDeControl, x+50, y+10, x+65, y+15, x+10, y+20, x+50, y+100);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+40, y+15, x+10, y-15, x+20, y+40);


                fun(root, puntosDeControl, x, y - 50, x + 25, y - 45, x + 65, y - 50, x + 65, y - 50, x + 25, y - 45, x, y + 50, x, y + 50, x + 10, y + 20, x + 50, y + 100, x + 65, y + 15, x, y + 50 - 35, x + 10, y + 20 - 35, x + 20, y + 40, x + 40, y + 15);


                while(cont < auxBold) {
                    QuadCurve a = new QuadCurve(x, y - 50, x + 25, y - 45, x + 65, y - 50);
                    a.setFill(Color.TRANSPARENT);
                    a.setStroke(color);
                    a.setStrokeWidth(grosor);

                    QuadCurve b = new QuadCurve(x + 65, y - 50, x + 85, y - 45, x, y + 50);
                    b.setFill(Color.TRANSPARENT);
                    b.setStroke(color);
                    b.setStrokeWidth(grosor);

                    CubicCurve c = new CubicCurve(x, y + 50, x + 10, y + 20, x + 50, y + 100, x + 65, y + 15);
                    c.setFill(Color.TRANSPARENT);
                    c.setStroke(color);
                    c.setStrokeWidth(grosor);

                    CubicCurve d = new CubicCurve(x+10, y + 50 - 35, x + 20, y + 20 - 35, x + 30, y + 40, x + 50, y + 15);
                    d.setFill(Color.TRANSPARENT);
                    d.setStroke(color);
                    d.setStrokeWidth(grosor);



                    root.getChildren().add(a);
                    root.getChildren().add(b);
                    root.getChildren().add(c);
                    root.getChildren().add(d);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu, x, y, root);
                }
            }
        }
    }
}
