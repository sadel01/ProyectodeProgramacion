package codigo.proyecto;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Scanner;

public class Dibujo {
    int x, xa;
    int y, ya;
    int xinicial, yinicial;
    //int yi = 100;
    int aux = 0;
    int grosor = 4;
    //variables para el subrayado
    boolean auxSub=false;
    boolean auxK=false;
    int xInicialSu=30;
    int yInicialSu=100;
    //-----------------------
    //variables para negrita
    int auxBold = 1;
    boolean espejo = false;
    int e = 1; //valor espejo

    int xTras = 0;
    int yTras = 0;
    ArrayList<Circle> circulos = new ArrayList<>();
    Color color = Color.BLACK;
    Color color2 = Color.web("#5F9EA0");

    boolean tras = false;

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

    public void Subrayar(int xa,int ya,int xb, AnchorPane root){
        Line subrayado = new Line(xa,ya,xb,ya);
        subrayado.setFill(Color.TRANSPARENT);
        subrayado.setStroke(color);
        subrayado.setStrokeWidth(grosor);
        root.getChildren().add(subrayado);
    }

    public void traslacion(int xTras, int yTras){

        this.xTras = xTras;
        this.yTras = yTras;
        this.tras = true;
        setTraslacion();
    }

    public void setTraslacion(){
        if (tras){
            this.x = xTras;
            this.y = yTras;
        }else{
            this.x = 30;
            this.y = 100;
        }
    }

    public void setEspejo(int xN) {
        this.x = xN;
        System.out.println(x);
    }

    public void Letras(boolean cursiva,String estilo, char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl, int borrar, ScrollPane scrollPane, int tamanio, int grados) {
        auxK=cursiva;
        if (borrar == 1) {
            if(!tras){
                x = 30;
                y = 100;
                xa = x;
                ya = y;
                xinicial=200;
                yinicial=400;
            }else if (tras){
                x = xTras;
                y = yTras;
            }

        }

        if (e == -1 && x <= 80) {
            if (caracter != ' ' && caracterAnt != ' ') {
                dibujo(grados,root, x - 5, y + 30, x - 30, y + 30);
            }

            x = 1450;
            y = y + 150;
            xInicialSu = x;
            yInicialSu = y + 55*tamanio;
        }

        if (x >= scrollPane.getWidth() - 120) {
            if (caracter != ' ' && caracterAnt != ' ') {
                Line l1 = new Line(x + 20, y + 30, x + 50, y + 30);
                l1.setFill(Color.TRANSPARENT);
                l1.setStroke(color);
                l1.setStrokeWidth(grosor);
                root.getChildren().add(l1);
            }
            x = 30*tamanio*e;
            y = y + 150*tamanio;
            xInicialSu = x;
            yInicialSu = y + 55*tamanio;
        }

        if(estilo.contains("N")){
            auxBold = 4;
        }

        if(estilo.contains("S")){
            auxSub = true;
            xInicialSu = x;
            yInicialSu = y + 55;
        }
        ArrayList<Shape> objetos = new ArrayList<Shape>();

        int cont = 0;
        if (caracter == 'a' || caracter == 'A' || caracter == 'á' || caracter == 'Á') {
            
            if (caracter == 'a' || caracter == 'á') {
                if(caracterAnt!='^' && caracterAnt!='+') {
                    Text t = new Text("\n" + caracter + ":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x + 30 * e, y + 10, x + 25 * e, y + 30, x - 5 * e, y - 30, x - 20 * e, y + 85);
                    pts(textoCoord, root, puntosDeControl, x + 35 * e, y, x + 60 * e, y + 15, x + 10 * e, y + 60, x + 50 * e, y + 65);
                    fun(root, puntosDeControl, x + 30 * e, y + 10, x - 5 * e, y - 30, x - 20 * e, y + 85, x + 25 * e, y + 30, x + 35 * e, y, x + 10 * e, y + 60, x + 50 * e, y + 65, x + 60 * e, y + 15);


                    while (cont < auxBold) {

                        dibujo(grados,root, x + 30 * e * tamanio, y + 10 * tamanio, x - 5 * e * tamanio, y - 30 * tamanio, x - 20 * e * tamanio, y + 85 * tamanio, x + 25 * e * tamanio, y + 30 * tamanio);
                        dibujo(grados,root, x + 35 * e * tamanio, y, x + 10 * e * tamanio, y + 60 * tamanio, x + 50 * e * tamanio, y + 65 * tamanio, x + 60 * e * tamanio, y + 15 * tamanio);

                        if (caracter == 'á') {
                            dibujo(grados,root, x + 15 * e * tamanio, y - 10 * tamanio, x + 30 * e * tamanio, y - 30 * tamanio);

                            if (cont < 1) {
                                pts(textoCoord, root, puntosDeControl, x + 15 * e, y - 10, x + 30 * e, y - 30);
                                fun(root, puntosDeControl, x + 15 * e, y - 10, x + 30 * e, y - 30);
                            }
                        }
                        if (auxBold > 1) {
                            x++;
                        }
                        cont++;
                    }
                    xinicial = xinicial + 60 * tamanio;
                    x = x + 60 * tamanio * e;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu, x, root);
                    }
                }
            } else {
                if(caracterAnt!='^' && caracterAnt!='+') {
                    Text t = new Text("\n" + caracter + ":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x, y + 50, x + 30 * e, y - 50, x + 20 * e, y + 60, x + 20 * e, y - 50);
                    pts(textoCoord, root, puntosDeControl, x + 30 * e, y - 50, x + 65 * e, y + 15, x + 50 * e, y - 60, x + 40 * e, y + 120);
                    pts(textoCoord, root, puntosDeControl, x, y + 15, x + 44 * e, y, x + 10 * e, y - 10, x + 30 * e, y + 30);
                    fun(root, puntosDeControl, x, y + 50, x + 20 * e, y + 60, x + 20 * e, y - 50, x + 30 * e, y - 50, x + 30 * e, y - 50, x + 50 * e, y - 60, x + 40 * e, y + 120, x + 65 * e, y + 15, x, y + 15, x + 10 * e, y - 10, x + 30 * e, y + 30, x + 44 * e, y);

                    while (cont < auxBold) {

                        dibujo(grados, root, x, y + 50 * tamanio, x + 20 * e * tamanio, y + 60 * tamanio, x + 20 * e * tamanio, y - 50 * tamanio, x + 30 * e * tamanio, y - 50 * tamanio);
                        dibujo(grados, root, x + 30 * e * tamanio, y - 50 * tamanio, x + 50 * e * tamanio, y - 60 * tamanio, x + 40 * e * tamanio, y + 120 * tamanio, x + 65 * e * tamanio, y + 15 * tamanio);
                        dibujo(grados, root, x, y + 15 * tamanio, x + 10 * e * tamanio, y - 10 * tamanio, x + 30 * e * tamanio, y + 30 * tamanio, x + 44 * e * tamanio, y);


                        if (caracter == 'Á') {
                            dibujo(grados, root, x + 30 * e * tamanio, y - 60 * tamanio, x + 45 * e * tamanio, y - 80 * tamanio);

                            if (cont < 1) {
                                pts(textoCoord, root, puntosDeControl, x + 30 * e, y - 60, x + 45 * e, y - 80);
                                fun(root, puntosDeControl, x + 30 * e, y - 60, x + 45 * e, y - 80);
                            }
                        }

                        if (auxBold > 1) {
                            x++;
                        }
                        cont++;
                    }

                    x = x + 65 * tamanio * e;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu * tamanio, x * tamanio, root);
                    }
                }
            }
        }
        if (caracter == 'b' || caracter == 'B') {

            if (caracter == 'b') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                fun(root, puntosDeControl, x, y + 15, x + 70 * e, y - 80, x - 10 * e, y - 80, x, y + 50, x, y + 30, x + 50 * e, y - 50, x + 35 * e, y + 100, x + 5 * e, y + 50, x + 5 * e, y + 50, x, y + 30, x + 60 * e, y + 50, x + 60 * e, y + 20);
                pts(textoCoord, root, puntosDeControl, x, y + 15, x, y + 50, x + 70, y - 80, x - 10 * e, y - 80);
                pts(textoCoord, root, puntosDeControl, x, y + 30, x + 5 * e, y + 50, x + 50 * e, y - 50, x + 35 * e, y + 100);
                pts(textoCoord, root, puntosDeControl, x + 5 * e, y + 50, x + 60 * e, y + 20, x, y + 30, x + 60 * e, y + 50);

                while(cont < auxBold) {

                    dibujo(grados,root, x * tamanio, y + 15 * tamanio, x + 70 * e * tamanio, y - 80 * tamanio, x - 10 * e * tamanio, y - 80 * tamanio, x * tamanio, y + 50 * tamanio);
                    dibujo(grados,root, x * tamanio, y + 30 * tamanio, x + 50 * e * tamanio, y - 50 * tamanio, x + 35 * e * tamanio, y + 100 * tamanio, x + 5 * e * tamanio, y + 50 * tamanio);
                    dibujo(grados,root, x + 5*e* tamanio, y + 50 * tamanio, x* tamanio, y + 30 * tamanio, x + 60 *e* tamanio, y + 50 * tamanio, x + 60 * e * tamanio, y + 20 * tamanio);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30*e, y-20, x+40*e, y+50, x+30*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+40*e, y+50, x+30*e, y+20, x+60*e, y+60, x+80*e, y-10);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+10, x+30*e, y-50, x-10*e, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30*e, y-50, x+30*e, y+20, x+70*e, y-50, x+70*e, y);
                pts(textoCoord, root, puntosDeControl, x+58*e, y+40, x+80*e, y+15, x+70*e, y+60);
                fun(root, puntosDeControl, x + 30*e, y - 20, x + 30*e, y + 50, x + 40*e, y + 50, x + 40*e, y + 50, x + 60*e, y + 60, x + 80*e, y - 10, x + 30*e, y + 20, x + 20*e, y + 10, x - 10*e,
                        y + 10, x, y - 50, x + 30*e, y - 50, x + 30*e, y - 50, x + 70*e, y - 50, x + 70*e, y, x + 30*e, y + 20, x + 58*e, y + 40, x + 70*e, y + 60, x + 80*e, y + 15);

                while(cont < auxBold) {

                    dibujo(grados,root, x + 30*e*tamanio, y - 20*tamanio, x + 30*e*tamanio, y + 50*tamanio, x + 40*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 40*e*tamanio, y + 50*tamanio, x + 60*e*tamanio, y + 60*tamanio, x + 80*e*tamanio, y - 10*tamanio,x + 30*e*tamanio, y + 20*tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y + 10*tamanio, x - 10*e*tamanio, y + 10*tamanio, x, y - 50*tamanio, x + 30*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y - 50*tamanio, x + 70*e*tamanio, y - 50*tamanio, x + 70*e*tamanio, y, x + 30*e*tamanio, y + 20*tamanio);
                    dibujo(grados,root, x + 58*e*tamanio, y + 40*tamanio, x + 70*e*tamanio, y + 60*tamanio, x + 80*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 80*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'c' || caracter == 'C') {

            if (caracter == 'c') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+25*e, y+15, x, y-20, x+40*e, y-5);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+60*e, y+15, x, y+45, x+30*e, y+80);
                fun(root, puntosDeControl, x, y + 25, x, y - 20, x + 40*e, y - 5, x + 25*e, y + 15, x, y + 25, x, y + 45, x + 30*e, y + 80, x + 60*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 25*tamanio, x, y - 20*tamanio, x + 40*e*tamanio, y - 5*tamanio, x + 25*e*tamanio, y + 15*tamanio );
                    dibujo(grados,root, x, y + 25*tamanio, x, y + 45*tamanio, x + 30*e*tamanio, y + 80*tamanio, x + 60*e*tamanio, y + 15*tamanio);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20*e, y-40, x+60*e, y+15, x-25*e, y-10, x+10*e, y+110);
                pts(textoCoord, root, puntosDeControl, x+20*e, y-40, x+10*e, y, x+45*e, y-60, x+75*e, y-35);
                pts(textoCoord, root, puntosDeControl, x+10*e, y, x, y-40, x-20*e, y+10, x-20*e, y-30);
                fun(root, puntosDeControl, x + 20*e, y - 40, x - 25*e, y - 10, x + 10*e, y + 110, x + 60*e, y + 15, x + 20*e, y - 40, x + 45*e, y - 60, x + 75*e, y - 35, x + 10*e, y, x + 10*e, y, x - 20*e, y + 10, x - 20*e, y - 30, x, y - 40);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 20*e*tamanio, y - 40*tamanio, x - 25*e*tamanio, y - 10*tamanio, x + 10*e*tamanio, y + 110*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y - 40*tamanio, x + 45*e*tamanio, y - 60*tamanio, x + 75*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y);
                    dibujo(grados,root, x + 10*e*tamanio, y, x - 20*e*tamanio, y + 10*tamanio, x - 20*e*tamanio, y - 30*tamanio, x, y - 40*tamanio);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }

        }
        if (caracter == 'd' || caracter == 'D') {

            if (caracter == 'd') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+15, x+25*e, y+25, x-15*e, y-30, x, y+90);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+5, x+25*e, y+25, x+80*e, y-50, x+20*e, y-80);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+25, x+60*e, y+15, x+30*e, y+50, x+50*e, y+50);
                fun(root, puntosDeControl, x + 25*e, y + 15, x - 15*e, y - 30, x, y + 90, x + 25*e, y + 25, x + 25*e, y + 5, x + 80*e, y - 50, x + 20*e, y - 80, x + 25*e, y + 25, x + 25*e, y + 25, x + 30*e, y + 50, x + 50*e, y + 50, x + 60*e, y + 15);
                while(cont < auxBold) {

                    dibujo(grados,root, x + 25*e*tamanio, y + 15*tamanio, x - 15*e*tamanio, y - 30*tamanio, x, y + 90*tamanio, x + 25*e*tamanio, y + 25*tamanio);
                    dibujo(grados,root, x + 25*e*tamanio, y + 5*tamanio, x + 80*e*tamanio, y - 50*tamanio, x + 20*e*tamanio, y - 80*tamanio, x + 25*e*tamanio, y + 25*tamanio);
                    dibujo(grados,root, x + 25*e*tamanio, y + 25*tamanio, x + 30*e*tamanio, y + 50*tamanio, x + 50*e*tamanio, y + 50*tamanio, x + 60*e*tamanio, y + 15*tamanio);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }


                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+10, x+30*e, y-50, x-10*e, y+10, x, y-50);
                pts(textoCoord, root, puntosDeControl, x+30*e, y-50, x+50*e, y+50, x+80*e, y-50, x+80*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+50*e, y+50, x+30*e, y-30, x+30*e, y+50, x+30*e, y+50);

                fun(root, puntosDeControl, x + 20*e, y + 10, x - 10, y + 10, x, y - 50, x + 30*e, y - 50, x + 30*e, y - 50, x + 80*e, y - 50, x + 80*e, y + 50, x + 50*e, y + 50, x + 50*e, y + 50, x + 30*e, y + 50, x + 30*e, y + 50, x + 30*e, y - 30);

                while(cont < auxBold) {

                    dibujo(grados,root, x + 2*e*tamanio, y + 10*tamanio, x - 10*e*tamanio, y + 10*tamanio, x, y - 50*tamanio, x + 30*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y - 50*tamanio, x + 80*e*tamanio, y - 50*tamanio, x + 80*e*tamanio, y + 50*tamanio, x + 50*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 50*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y - 30*tamanio);

                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 90*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'e' || caracter == 'E' || caracter == 'é' || caracter == 'É') {

            if (caracter == 'e' || caracter == 'é') {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+2*e, y+30, x-5*e, y-20, x+53*e, y);
                pts(textoCoord, root, puntosDeControl, x, y+25, x+50*e, y+15, x, y+50, x+40*e, y+70);

                fun(root, puntosDeControl, x, y + 25, x - 5*e, y - 20, x + 53*e, y, x + 2*e, y + 30, x, y + 25, x, y + 50, x + 40*e, y + 70, x + 50*e, y + 15);
                while(cont < auxBold) {

                    dibujo(grados,root, x, y + 25*tamanio, x - 5*e*tamanio, y - 20*tamanio, x + 53*e*tamanio, y, x + 2*e*tamanio, y + 30*tamanio);
                    dibujo(grados,root, x, y + 25*tamanio, x, y + 50*tamanio, x + 40*e*tamanio, y + 70*tamanio, x + 50*e*tamanio, y + 15*tamanio);

                    if (caracter == 'é') {
                        dibujo(grados,root, x + 20*e*tamanio, y - 10*tamanio, x + 35*e*tamanio, y - 30*tamanio);

                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20*e, y-10, x+35*e, y-30);
                            fun(root, puntosDeControl, x + 20*e, y - 10, x + 35*e, y - 30);
                        }
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {

                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25*e, y-10, x+60*e, y+15, x-20*e, y-10, x, y+120);
                pts(textoCoord, root, puntosDeControl, x+25*e, y-10, x+20*e, y-50, x-20*e, y-10, x+10*e, y-50);

                fun(root, puntosDeControl, x + 25*e, y - 10, x - 20*e, y - 10, x, y + 120, x + 60*e, y + 15, x + 25*e, y - 10, x - 20*e, y - 10, x + 10*e, y - 50, x + 20*e, y - 50, x + 20*e, y - 50, x + 40*e, y - 50, x + 30*e, y - 10, x, y - 50);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 25*e*tamanio, y - 10*tamanio, x - 20*e*tamanio, y - 10*tamanio, x, y + 120*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 25*e*tamanio, y - 10*tamanio, x - 20*e*tamanio, y - 10*tamanio, x + 10*e*tamanio, y - 50*tamanio, x + 20*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y - 50*tamanio, x + 40*e*tamanio, y - 50*tamanio, x + 30*e*tamanio, y - 10*tamanio, x, y - 50*tamanio);

                    if (caracter == 'É') {
                        dibujo(grados,root, x + 30*e*tamanio, y - 60*tamanio, x + 45*e*tamanio, y - 80*tamanio);
                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30*e, y-60, x+45*e, y-80);
                            fun(root, puntosDeControl, x + 30*e, y - 60, x + 45*e, y - 80);
                        }
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }

            //tamaÃ±o caracter
        }
        if (caracter == 'f' || caracter == 'F') {

            if (caracter == 'f') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+10, x, y+10, x, y-60, x+60*e, y-60);
                pts(textoCoord, root, puntosDeControl, x, y, x+2*e, y+15, x, y+110, x+50*e, y+60);
                pts(textoCoord, root, puntosDeControl, x+2*e, y+25, x+50*e, y+15, x+35*e, y+60);
                fun(root, puntosDeControl, x, y + 10, x, y - 60, x + 60*e, y - 60, x, y + 10, x, y, x, y + 110, x + 50*e, y + 60, x + 2*e, y + 15, x + 2*e, y + 25, x + 35*e, y + 60, x + 50*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 10*tamanio, x, y - 60*tamanio, x + 60*e*tamanio, y - 60*tamanio, x, y + 10*tamanio); // Curva Superior
                    dibujo(grados,root, x, y, x, y + 110*tamanio, x + 50*e*tamanio, y + 60*tamanio, x + 2*e*tamanio, y + 15*tamanio); // Curva inferior
                    dibujo(grados,root, x + 2*e*tamanio, y + 25*tamanio, x + 35*e*tamanio, y + 60*tamanio, x + 50*e*tamanio, y + 15*tamanio); // Conexion
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+60*e, y-50, x+10*e, y-70, x+50*e, y-10);
                pts(textoCoord, root, puntosDeControl, x+30*e, y-37, x+10*e, y+40, x+20*e, y+70);
                pts(textoCoord, root, puntosDeControl, x+10*e, y+10, x+50*e, y+15, x+20*e, y, x+30*e, y+20);
                fun(root, puntosDeControl, x, y - 40, x + 10*e, y - 70, x + 50*e, y - 10, x + 60*e, y - 50, x + 30*e, y - 37, x + 20*e, y + 70, x + 10, y + 10, x + 20*e, y, x + 30*e, y + 20, x + 50*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x, y - 40*tamanio, x + 10*e*tamanio, y - 70*tamanio, x + 50*e*tamanio, y - 10*tamanio, x + 60*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y - 37*tamanio, x + 20*e*tamanio, y + 70*tamanio, x + 10*e*tamanio, y + 40*tamanio);
                    dibujo(grados,root, x + 10*e*tamanio, y + 10*tamanio, x + 20*e*tamanio, y, x + 30*e*tamanio, y + 20*tamanio, x + 50*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'g' || caracter == 'G') {

            if (caracter == 'g') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+10, x+25*e, y+40, x-10*e, y-20, x-10*e, y+70);
                pts(textoCoord, root, puntosDeControl, x+25*e, y, x+10*e, y+80, x+35*e, y+90, x+10*e, y+90);
                pts(textoCoord, root, puntosDeControl, x+10*e, y+80, x+60*e, y+15, x+10*e, y+30, x+60*e, y+60);
                fun(root, puntosDeControl, x + 25*e, y + 10, x - 10*e, y - 20, x - 10*e, y + 70, x + 25*e, y + 40, x + 25*e, y, x + 35*e, y + 90, x + 10*e, y + 90, x + 10*e, y + 80, x + 10*e, y + 80, x + 10*e, y + 30, x + 60*e, y + 60, x + 60*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x + 25*e*tamanio, y + 10*tamanio, x - 10*e*tamanio, y - 20*tamanio, x - 10*e*tamanio, y + 70*tamanio, x + 25*e*tamanio, y + 40*tamanio); // Circulo
                    dibujo(grados,root, x + 25*e*tamanio, y, x + 35*e*tamanio, y + 90*tamanio, x + 10*e*tamanio, y + 90*tamanio, x + 10*e*tamanio, y + 80*tamanio);
                    dibujo(grados,root, x + 10*e*tamanio, y + 80*tamanio, x + 10*e*tamanio, y + 30*tamanio, x + 60*e*tamanio, y + 60*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+40*e, y-50, x+70*e, y+10, x+60*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+40*e, y-50, x+59*e, y+20, x, y-50, x+10*e, y+110);
                pts(textoCoord, root, puntosDeControl, x+60*e, y+10, x+30*e, y+80, x+60*e, y+100, x+20*e, y+100);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+80, x+80*e, y+15, x+40*e, y+60, x+60*e, y+60);
                fun(root, puntosDeControl, x, y + 20, x + 70*e, y + 10, x + 60*e, y - 50, x + 40*e, y - 50, x + 40*e, y - 50, x, y - 50, x + 10*e, y + 110, x + 59*e, y + 20, x + 60*e, y + 10, x + 60*e, y + 100, x + 20*e, y + 100, x + 30*e, y + 80, x + 30*e, y + 80, x + 40*e, y + 60, x + 60*e, y + 60, x + 80*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 20*tamanio, x + 70*e*tamanio, y + 10*tamanio, x + 60*e*tamanio, y - 50*tamanio, x + 40*e*tamanio, y - 50*tamanio); // mitad e
                    dibujo(grados,root, x + 40*e*tamanio, y - 50*tamanio, x, y - 50*tamanio, x + 10*e*tamanio, y + 110*tamanio, x + 59*e*tamanio, y + 20*tamanio); // otra mitad
                    dibujo(grados,root, x + 60*e*tamanio, y + 10*tamanio, x + 60*e*tamanio, y + 100*tamanio, x + 20*e*tamanio, y + 100*tamanio, x + 30*e*tamanio, y + 80*tamanio); // mitad j
                    dibujo(grados,root, x + 30*e*tamanio, y + 80*tamanio, x + 40*e*tamanio, y + 60*tamanio, x + 60*e*tamanio, y + 60*tamanio, x + 80*e*tamanio, y + 15*tamanio); // otra mitad j
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 80*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'h' || caracter == 'H') {

            if (caracter == 'h') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x, y+50, x+50*e, y-50, x-10*e, y-90);
                pts(textoCoord, root, puntosDeControl, x, y+40, x+25*e, y+35, x+10*e, y, x+25*e, y+5);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+35, x+50*e, y+15, x+25*e, y+60, x+40*e, y+60);
                fun(root, puntosDeControl, x, y + 15, x + 50*e, y - 50, x - 10*e, y - 90, x, y + 50, x, y + 40, x + 10*e, y, x + 25*e, y + 5, x + 25*e, y + 35, x + 25*e, y + 35, x + 25*e, y + 60, x + 40*e, y + 60, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 15*tamanio, x + 50*e*tamanio, y - 50*tamanio, x - 10*e*tamanio, y - 90*tamanio, x, y + 50*tamanio); // l
                    dibujo(grados,root, x, y + 40*tamanio, x + 10*e*tamanio, y, x + 25*e*tamanio, y + 5*tamanio, x + 25*e*tamanio, y + 35*tamanio); // guata
                    dibujo(grados,root, x + 25*e*tamanio, y + 35*tamanio, x + 25*e*tamanio, y + 60*tamanio, x + 40*e*tamanio, y + 60*tamanio, x + 50*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50*tamanio*e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+20*e, y+40, x+10*e, y-60, x+30*e, y-30);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+40, x+40*e, y, x+10*e, y+80, x-10*e, y+30);
                pts(textoCoord, root, puntosDeControl, x+40*e, y, x+50*e, y-50, x+60*e, y-10, x+60*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+50*e, y-50, x+70*e, y+15, x+40*e, y-50, x+40*e, y+120);
                fun(root, puntosDeControl, x, y - 40, x + 10*e, y - 60, x + 30*e, y - 30, x + 20*e, y + 40, x + 20*e, y + 40, x + 10*e, y + 80, x - 10*e, y + 30, x + 40*e, y, x + 40*e, y, x + 60*e, y - 10, x + 60*e, y - 50, x + 50*e, y - 50, x + 50*e, y - 50, x + 40*e, y - 50, x + 40*e, y + 120, x + 70*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x, y - 40*tamanio, x + 10*e*tamanio, y - 60*tamanio, x + 30*e*tamanio, y - 30*tamanio, x + 20*e*tamanio, y + 40*tamanio); // primera curva hacia abajo
                    dibujo(grados,root, x + 20*e*tamanio, y + 40*tamanio, x + 10*e*tamanio, y + 80*tamanio, x - 10*e*tamanio, y + 30*tamanio, x + 40*e*tamanio, y); // segunda curva
                    dibujo(grados,root, x + 40*e*tamanio, y, x + 60*e*tamanio, y - 10*tamanio, x + 60*e*tamanio, y - 50*tamanio, x + 50*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 50*e*tamanio, y - 50*tamanio, x + 40*e*tamanio, y - 50*tamanio, x + 40*e*tamanio, y + 120*tamanio, x + 70*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 70*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'i' || caracter == 'I' || caracter == 'í' || caracter == 'Í') {

            if (caracter == 'i' || caracter == 'í') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y, x+40*e, y+15, x-10*e, y+80, x+30*e, y+40);
                fun(root, puntosDeControl, x + 2*e, y, x - 10*e, y + 80, x + 30*e, y + 40, x + 40*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y, x - 10*e*tamanio, y + 80*tamanio, x + 30*e*tamanio, y + 40*tamanio, x + 40*e*tamanio, y + 15*tamanio);
                    if (caracter == 'í') {
                        dibujo(grados,root, x, y - 10*tamanio, x + 15*e*tamanio, y - 30*tamanio);
                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x, y-10, x+15*e, y-30);
                            fun(root, puntosDeControl, x, y - 10, x + 15*e, y - 30);
                        }
                    } else {
                        dibujo(grados,root, x + 3*e*tamanio, y - 10*tamanio, tamanio);
                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+3*e, y-10);
                            fun(root, puntosDeControl, x + 3*e, y - 10);
                        }
                    }
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 40*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+50*e, y-40, x+20*e, y-60, x+30*e, y-40);
                pts(textoCoord, root, puntosDeControl, x+50*e, y-40, x+40*e, y+20, x+70*e, x-40, x+50*e, y-120);
                pts(textoCoord, root, puntosDeControl, x+40*e, y+20, x, y+30, x+35*e, y+70, x, y+40);
                fun(root, puntosDeControl, x, y - 50, x + 20*e, y - 60, x + 30*e, y - 40, x + 50*e, y - 40, x + 50*e, y - 40, x + 70*e, y - 40, x + 50*e, y - 120, x + 40*e, y + 20, x + 40*e, y + 20, x + 35*e, y + 70, x, y + 40, x, y + 30);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y - 50*tamanio, x + 20*e*tamanio, y - 60*tamanio, x + 30*e*tamanio, y - 40*tamanio, x + 50*e*tamanio, y - 40*tamanio);
                    dibujo(grados,root, x + 50*e*tamanio, y - 40*tamanio, x + 70*e*tamanio, y - 40*tamanio, x + 50*e*tamanio, y - 120*tamanio, x + 40*e*tamanio, y + 20*tamanio);
                    dibujo(grados,root, x + 40*e*tamanio, y + 20*tamanio, x + 35*e*tamanio, y + 70*tamanio, x, y + 40*tamanio, x, y + 30*tamanio);

                    if (caracter == 'Í') {
                        dibujo(grados,root, x + 30*e*tamanio, y - 60*tamanio, x + 45*e*tamanio, y - 80*tamanio);
                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+30*e, y-60, x+45*e, y-80);
                            fun(root, puntosDeControl, x + 30*e, y - 60, x + 45*e, y - 80);
                        }
                    }

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'j' || caracter == 'J') {

            if (caracter == 'j') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-15*e, y+65, x+30*e, y+15, x-15*e, y+50, x+30*e, y+35);
                pts(textoCoord, root, puntosDeControl, x, y+70, x-15*e, y+65, x-5*e, y+95, x-20*e, y+85);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+70, x-1*e, y+20, x+5*e, y+60);
                pts(textoCoord, root, puntosDeControl, x, y-10);
                fun(root, puntosDeControl, x - 15*e, y + 65, x - 15*e, y + 50, x + 30*e, y + 35, x + 30*e, y + 15, x, y + 70, x - 5*e, y + 95, x - 20*e, y + 85, x - 15*e, y + 65, x, y, x - 1*e, y + 20, x + 5*e, y + 60, x, y + 70);

                while(cont < auxBold) {
                    dibujo(grados,root, x - 15*e*tamanio, y + 65*tamanio, x - 15*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y + 35*tamanio, x + 30*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x, y + 70*tamanio, x - 5*e*tamanio, y + 95*tamanio, x - 20*e*tamanio, y + 85*tamanio, x - 15*e*tamanio, y + 65*tamanio);
                    dibujo(grados,root, x, y, x - 1*e*tamanio, y + 20*tamanio, x + 5*e*tamanio, y + 60*tamanio, x, y + 70*tamanio);
                    dibujo(grados,root, x, y - 10*tamanio, tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                x = x + 30*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-40, x+50*e, y-40, x+20*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+50*e, y-40, x+40*e, y+30, x+70*e, y-40, x+50*e, y-120);
                pts(textoCoord, root, puntosDeControl, x+40*e, y+30, x+5*e, y+40, x+40*e, y+55, x+10*e, y+60);
                pts(textoCoord, root, puntosDeControl, x+5*e, y+40, x+50*e, y-15, x, y+20, x+15*e, y);
                fun(root, puntosDeControl, x, y - 40, x + 50*e, y - 40, x + 20*e, y - 50, x + 70*e, y - 40, x + 50*e, y - 120, x + 40*e, y + 55, x + 10*e, y + 60, x + 50*e, y - 40, x + 40*e, y + 30, x + 40*e, y + 30, x + 5*e, y + 40, x + 5*e, y + 40, x + 50*e, y - 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y - 40*tamanio, x + 20*e*tamanio, y - 50*tamanio, x + 50*e*tamanio, y - 40*tamanio);
                    dibujo(grados,root, x + 50*e*tamanio, y - 40*tamanio, x + 70*e*tamanio, y - 40*tamanio, x + 50*e*tamanio, y - 120*tamanio, x + 40*e*tamanio, y + 30*tamanio);
                    dibujo(grados,root, x + 40*e*tamanio, y + 30*tamanio, x + 40*e*tamanio, y + 55*tamanio, x + 10*e*tamanio, y + 60*tamanio, x + 5*e*tamanio, y + 40*tamanio);
                    dibujo(grados,root, x + 5*e*tamanio, y + 40*tamanio, x, y + 20*tamanio, x + 15*e*tamanio, y, x + 50*e*tamanio, y - 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'k' || caracter == 'K') {

            if (caracter == 'k') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y, x-1*e, y+50, x+37*e, y, x-3*e, y-150);
                pts(textoCoord, root, puntosDeControl, x, y+18, x+17*e, y+30, x+7*e, y-10, x+42*e, y+20);
                pts(textoCoord, root, puntosDeControl, x+17*e, y+30, x+55*e, y+15, x+37*e, y+72, x+47*e, y+50);
                fun(root, puntosDeControl, x + 2*e, y, x + 37*e, y, x - 3*e, y - 150, x + 7*e, y - 10, x + 42*e, y + 20, x + 37*e, y + 72, x + 47*e, y + 50, x - 1*e, y + 50, x, y + 18, x + 17*e, y + 30, x + 17*e, y + 30, x + 55*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y, x + 37*e*tamanio, y, x - 3*e*tamanio, y - 150*tamanio, x - tamanio, y + 50*tamanio);
                    dibujo(grados,root, x, y + 18*tamanio, x + 7*e*tamanio, y - 10*tamanio, x + 42*e*tamanio, y + 20*tamanio, x + 17*e*tamanio, y + 30*tamanio);
                    dibujo(grados,root, x + 17*e*tamanio, y + 30*tamanio, x + 37*e*tamanio, y + 72*tamanio, x + 35*e*tamanio, y + 50*tamanio, x + 55*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 55*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else{
                if(caracterAnt!='^' && caracterAnt!='+' ) {
                    Text t = new Text("\n" + caracter + ":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x, y - 20, x + 10 * e, y + 40, x + 40 * e, y - 120, x + 40 * e, y + 80);
                    pts(textoCoord, root, puntosDeControl, x + 10 * e, y + 40, x + 60 * e, y - 50, x - 20 * e, y, x + 60 * e, y);
                    pts(textoCoord, root, puntosDeControl, x + 33 * e, y - 5, x + 80 * e, y + 15, x + 60 * e, y - 10, x + 60 * e, y + 115);
                    fun(root, puntosDeControl, x, y - 20, x + 40 * e, y - 120, x + 40 * e, y + 80, x - 20 * e, y, x + 60 * e, y, x + 60 * e, y - 10, x + 60 * e, y + 115, x + 10 * e, y + 40, x + 10 * e, y + 40, x + 60 * e, y - 50, x + 33 * e, y - 5, x + 80 * e, y + 15);

                    while (cont < auxBold) {
                        dibujo(grados, root, x, y - 20 * tamanio, x + 40 * e * tamanio, y - 120 * tamanio, x + 40 * e * tamanio, y + 80 * tamanio, x + 10 * e * tamanio, y + 40 * tamanio); // primera curva hacia
                        // abajo
                        dibujo(grados, root, x + 10 * e * tamanio, y + 40 * tamanio, x - 20 * e * tamanio, y, x + 60 * e * tamanio, y, x + 60 * e * tamanio, y - 50 * tamanio);
                        dibujo(grados, root, x + 33 * e * tamanio, y - 5 * tamanio, x + 60 * e * tamanio, y - 10 * tamanio, x + 60 * e * tamanio, y + 115 * tamanio, x + 80 * e * tamanio, y + 15 * tamanio);

                        if (auxBold > 1) {
                            x++;
                        }

                        cont++;
                    }
                    x = x + 80 * tamanio * e;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu * tamanio, x * tamanio, root);

                    }
                }
            }
        }
        if (caracter == 'l' || caracter == 'L') {
            if (caracter == 'l') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x-1*e, y+40, x+37*e, y-40, x-3*e, y-120);
                pts(textoCoord, root, puntosDeControl, x-1*e, y+40, x+30*e, y+15, x, y+60, x+20*e, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 37*e, y - 40, x - 3*e, y - 120, x, y + 60, x + 20*e, y + 60, x - 1*e, y + 40, x - 1*e, y + 40, x + 30*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 15*tamanio, x + 37*e*tamanio, y - 40*tamanio, x - 3*e*tamanio, y - 120*tamanio, x - tamanio, y + 40*tamanio); //Curva principal
                    dibujo(grados,root, x - tamanio, y + 40*tamanio, x, y + 60*tamanio, x + 20*e*tamanio, y + 60*tamanio, x + 30*e*tamanio, y + 15*tamanio);  //Curva derecha (conector)
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 30*tamanio*e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);

                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+15*e, y-5, x+80*e, y-80, x+5*e, y-60);
                pts(textoCoord, root, puntosDeControl, x+15*e, y-5, x+20*e, y+50, x+15*e, y+100, x-30*e, y+10);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+50, x+50*e, y+15, x+45*e, y+60);

                fun(root, puntosDeControl, x, y + 15, x + 15*e, y + 100, x - 30*e, y + 10, x + 45*e, y + 60, x + 15*e, y - 5, x + 15*e, y - 5, x + 20*e, y + 50, x + 20*e, y + 50, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 15*tamanio, x + 80*e*tamanio, y - 80*tamanio, x + 5*e*tamanio, y - 60*tamanio, x + 15*e*tamanio, y - 5*tamanio); //Curva principal
                    dibujo(grados,root, x + 15*e*tamanio, y - 5*tamanio, x + 15*e*tamanio, y + 100*tamanio, x - 30*e*tamanio, y + 10*tamanio, x + 20*e*tamanio, y + 50*tamanio); //Semi ovalo
                    dibujo(grados,root, x + 20*e*tamanio, y + 50*tamanio, x + 45*e*tamanio, y + 60*tamanio, x + 50*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);

                }
            }
        }
        if (caracter == 'm' || caracter == 'M') {
            if (caracter == 'm') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8*e, y+50, x-1*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+8*e, y+50, x+28*e, y+48, x+15*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+28*e, y+48, x+48*e, y+48, x+40*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+48*e, y+48, x+70*e, x+15, x+50*e, y+60, x+68*e, y+65);
                fun(root, puntosDeControl, x, y, x - 1*e, y + 50, x + 15*e, y - 50, x + 40*e, y - 50, x + 50*e, y + 60, x + 68*e, y + 65, x + 8*e, y + 50, x + 8*e, y + 50, x + 28*e, y + 48, x + 28*e, y + 48, x + 48*e, y + 48, x + 48*e, y + 48, x + 70*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y, x - tamanio, y + 50*tamanio, x + 8*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 8*e*tamanio, y + 50*tamanio, x + 15*e*tamanio, y - 50*tamanio, x + 28*e*tamanio, y + 48*tamanio);
                    dibujo(grados,root, x + 28*e*tamanio, y + 48*tamanio, x + 40*e*tamanio, y - 50*tamanio, x + 48*e*tamanio, y + 48*tamanio);
                    dibujo(grados,root, x + 48*e*tamanio, y + 48*tamanio, x + 50*e*tamanio, y + 60*tamanio, x + 68*e*tamanio, y + 65*tamanio, x + 70*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 70*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5*e, y+15, x+15*e, y+50, x-15*e, y-70, x+29*e, y-85);
                pts(textoCoord, root, puntosDeControl, x+15*e, y+50, x+40*e, y+40, x+35*e, y-90);
                pts(textoCoord, root, puntosDeControl, x+40*e, y+40, x+65*e, y+50, x+60*e, y-83);

                fun(root, puntosDeControl, x + 5*e, y + 15, x - 15*e, y - 70, x + 29*e, y - 85, x + 35*e, y - 90, x + 60*e, y - 83, x + 15*e, y + 50, x + 15*e, y + 50, x + 40*e, y + 40, x + 40*e, y + 40, x + 65*e, y + 50);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 5*e*tamanio, y + 15*tamanio, x - 15*e*tamanio, y - 70*tamanio, x + 29*e*tamanio, y - 85*tamanio, x + 15*e*tamanio, y + 50*tamanio); // primera curva hacia
                    // abajo
                    dibujo(grados,root, x + 15*e*tamanio, y + 50*tamanio, x + 35*e*tamanio, y - 90*tamanio, x + 40*e*tamanio, y + 40*tamanio);
                    dibujo(grados,root, x + 40*e*tamanio, y + 40*tamanio, x + 60*e*tamanio, y - 83*tamanio, x + 65*e*tamanio, y + 50*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 78*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'n' || caracter == 'N') {
            if (caracter == 'n') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x+8*e, y+50, x+50*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+8*e, y+50, x+30*e, y+48, x+30*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+48, x+50*e, y+15, x+30*e, y+60, x+45*e, y+65);

                fun(root, puntosDeControl, x, y, x + 50*e, y + 50, x + 30*e, y - 50, x + 30*e, y + 60, x + 45*e, y + 65, x + 8*e, y + 50, x + 8*e, y + 50, x + 30*e, y + 48, x + 30*e, y + 48, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y, x - tamanio, y + 50*tamanio, x + 8*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 8*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y -50*tamanio, x + 30*e*tamanio, y + 48*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 48*tamanio, x + 30*e*tamanio, y + 60*tamanio, x + 45*e*tamanio, y + 65*tamanio, x + 50*e*tamanio, y + 15*tamanio); //Curva principal
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                if(caracterAnt != '^' && caracterAnt != '+') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x+5*e, y+15, x+15*e, y+50, x-15*e, y-70, x+29*e, y-85);
                    pts(textoCoord, root, puntosDeControl, x+15*e, y+50, x+45*e, y+60, x+40*e, y-93);
                    fun(root, puntosDeControl, x + 5*e, y + 15, x - 15*e, y - 70, x + 29*e, y - 85, x + 40*e, y - 93, x + 15*e, y + 50, x + 15*e, y + 50, x + 45*e, y + 60);
                    while(cont < auxBold) {
                        dibujo(grados,root, x + 5*e*tamanio, y + 15*tamanio, x - 15*e*tamanio, y - 70*tamanio, x + 29*e*tamanio, y - 85*tamanio, x + 15*e*tamanio, y + 50*tamanio); //1era curva hacia abajo
                        dibujo(grados,root, x + 15*e*tamanio, y + 50*tamanio, x + 40*e*tamanio, y - 93*tamanio, x + 45*e*tamanio, y + 60*tamanio);
                        if(auxBold > 1){
                            x++;
                        }
                        cont++;
                    }
                    x = x + 55*tamanio;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);

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
                pts(textoCoord, root, puntosDeControl, x, y, x+8*e, y+50, x+50*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+8*e, y+50, x+30*e, y+48, x+30*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+48, x+50*e, y+15, x+30*e, y+60, x+45*e, y+65);
                fun(root, puntosDeControl, x, y, x + 50*e, y + 50, x + 30*e, y - 50, x + 30*e, y + 60, x + 45*e, y + 65, x + 8*e, y + 50, x + 8*e, y + 50, x + 30*e, y + 48, x + 30*e, y + 48, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y, x - tamanio, y + 50*tamanio, x + 8*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 8*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y -50*tamanio, x + 30*e*tamanio, y + 48*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 48*tamanio, x + 30*e*tamanio, y + 60*tamanio, x + 45*e*tamanio, y + 65*tamanio, x + 50*e*tamanio, y + 15*tamanio); //Curva principal
                    dibujo(grados,root, x + 15*e*tamanio, y - 15*tamanio, x + 20*e*tamanio, y - 25*tamanio, x + 25*e*tamanio, y - 5*tamanio, x + 30*e*tamanio, y - 15*tamanio);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+5*e, y+15, x+15*e, y+50, x-15*e, y-70, x+29*e, y-85);
                pts(textoCoord, root, puntosDeControl, x+15*e, y+50, x+45*e, y+60, x+40*e, y-93);
                pts(textoCoord, root, puntosDeControl, x+25*e, y-40, x+45*e, y-40, x+30*e, y-50, x+40*e, y-30);

                fun(root, puntosDeControl, x + 5*e, y + 15, x - 15*e, y - 70, x + 29*e, y - 85, x + 40*e, y - 93, x + 15*e, y + 50, x + 15*e, y + 50, x + 45*e, y + 60);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 5*e*tamanio, y + 15*tamanio, x - 15*e*tamanio, y - 70*tamanio, x + 29*e*tamanio, y - 85*tamanio, x + 15*e*tamanio, y + 50*tamanio); //1era curva hacia abajo
                    dibujo(grados,root, x + 15*e*tamanio, y + 50*tamanio, x + 40*e*tamanio, y - 93*tamanio, x + 45*e*tamanio, y + 60*tamanio);
                    dibujo(grados,root, x + 25*e*tamanio, y - 40*tamanio, x + 30*e*tamanio, y - 50*tamanio, x + 40*e*tamanio, y - 30*tamanio, x + 45*e*tamanio, y - 40*tamanio);
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 55*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'o' || caracter == 'O' || caracter == 'ó' || caracter == 'Ó') {
            if (caracter == 'o' || caracter == 'ó') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+20, x+30*e, y+20, x, y+60, x+30*e, y+60);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+20, x, y+20, x+30*e, y-5, x, y-5);
                pts(textoCoord, root, puntosDeControl, x+5*e, y+6, x+50*e, y+15, x+30*e, y+50);
                fun(root, puntosDeControl, x, y + 20, x, y + 60, x + 30*e, y + 60, x + 30*e, y + 20, x + 30*e, y + 20, x + 30*e, y - 5, x, y - 5, x, y + 20, x + 5*e, y + 6, x + 30*e, y + 50, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 20*tamanio, x, y + 60*tamanio, x + 30*e*tamanio, y + 60*tamanio, x + 30*e*tamanio, y + 20*tamanio); //Curva principal
                    dibujo(grados,root, x + 30*e*tamanio, y + 20*tamanio, x + 30*e*tamanio, y - 5*tamanio, x, y - 5*tamanio, x, y + 20*tamanio);
                    dibujo(grados,root, x + 5*e*tamanio, y + 6*tamanio, x + 30*e*tamanio, y + 50*tamanio, x + 50*e*tamanio, y + 15*tamanio);
                    if (caracter == 'ó') {
                        dibujo(grados,root, x + 20*e*tamanio, y - 10*tamanio, x + 35*e*tamanio, y - 30*tamanio);
                        if(cont < 1){
                            pts(textoCoord, root, puntosDeControl, x+20, y-10, x+35, y-30);
                            fun(root, puntosDeControl, x + 20, y - 10, x + 35, y - 30);
                        }
                    }
                    Text t8 = new Text("\n");
                    textoCoord.getChildren().add(t8);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 50*tamanio*e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13*e, y-10, x+57*e, y-10, x, y+70, x+57*e, y+70);
                pts(textoCoord, root, puntosDeControl, x+57*e, y-10, x+45*e, y+10, x+40*e, y-125, x-55*e, y+50);
                fun(root, puntosDeControl, x + 13*e, y - 10, x, y + 70, x + 57*e, y + 70, x + 57*e, y - 10, x + 57*e, y - 10, x + 40*e, y - 125, x - 55*e, y + 50, x + 45*e, y + 10);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 13*e*tamanio, y - 10*tamanio, x, y + 70*tamanio, x + 57*e*tamanio, y + 70*tamanio, x + 57*e*tamanio, y - 10*tamanio);
                    dibujo(grados,root, x + 57*e*tamanio, y - 10*tamanio, x + 40*e*tamanio, y - 125*tamanio, x - 55*e*tamanio, y + 50*tamanio, x + 45*e*tamanio, y + 10*tamanio);
                    if (caracter == 'Ó') {
                        dibujo(grados,root, x + 20*e*tamanio, y - 60*tamanio, x + 35*e*tamanio, y - 80*tamanio);
                        if(cont < 1) {
                            pts(textoCoord, root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                            fun(root, puntosDeControl, x + 20, y - 60, x + 35, y - 80);
                        }
                    }
                    Text t6 = new Text("\n");
                    textoCoord.getChildren().add(t6);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 65*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'p' || caracter == 'P') {
            if (caracter == 'p') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y, x, y+85, x-2*e, y+15);
                pts(textoCoord, root, puntosDeControl, x+1*e, y+15, x+25*e, y+50, x+40*e, y-15, x+35*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+25*e, y+50, x+30*e, y+35, x, y+60, x, y+30);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+35, x+55*e, y+15, x+40*e, y+30);
                fun(root, puntosDeControl, x, y, x, y + 85, x - 2*e, y + 15, x + 1*e, y + 15, x + 25*e, y + 50, x + 40*e, y - 15, x + 35*e, y + 50, x + 25*e, y + 50, x + 30*e, y + 35, x, y + 60, x, y + 30, x + 30*e, y + 35, x + 55*e, y + 15, x + 40*e, y + 30);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y, x - 2*e*tamanio, y + 15*tamanio, x, y + 85*tamanio);
                    dibujo(grados,root, x + tamanio, y + 15*tamanio, x + 40*e*tamanio, y - 15*tamanio, x + 35*e*tamanio, y + 50*tamanio, x + 25*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 25*e*tamanio, y + 50*tamanio, x, y + 60*tamanio, x, y + 30*tamanio, x + 30*e*tamanio, y + 35*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 35*tamanio, x + 40*e*tamanio, y + 30*tamanio, x + 55*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 55*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+25*e, y+85, x, y-70, x+30*e, y-90);
                pts(textoCoord, root, puntosDeControl, x+24*e, y-20, x+26*e, y+30, x+60*e, y-110, x+70*e, y+60);
                fun(root, puntosDeControl, x, y + 15, x, y - 70, x + 30*e, y - 90, x + 60*e, y - 110, x + 70*e, y + 60, x + 25*e, y + 85, x + 24*e, y - 20, x + 26*e, y + 30);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y + 15*tamanio, x, y - 70*tamanio, x + 30*e*tamanio, y - 90*tamanio, x + 25*e*tamanio, y + 85*tamanio); // primera curva hacia
                    // abajo
                    dibujo(grados,root, x + 24*e*tamanio, y - 20*tamanio, x + 60*e*tamanio, y - 110*tamanio, x + 70*e*tamanio, y + 60*tamanio, x + 26*e*tamanio, y + 30*tamanio); //Curva principal
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 58*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'q' || caracter == 'Q') {
            if (caracter == 'q') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+30*e, y, x+30*e, y+85, x+28*e, y+28);
                pts(textoCoord, root, puntosDeControl, x+28*e, y+12, x+28*e, y+40, x-12*e, y-10, x-13*e, y+60);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+47, x+60*e, y+15, x+50*e, y+47);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+85, x+30*e, y+47, x+40*e, y+80, x+40*e, y+50);
                fun(root, puntosDeControl, x + 30*e, y + 85, x + 28*e, y + 28, x - 12*e, y - 10, x - 13*e, y + 60, x + 50*e, y + 47, x + 40*e, y + 80, x + 40*e, y + 50, x + 28*e, y + 12, x + 28*e, y + 40, x + 30, y + 47, x + 60*e, y + 15, x + 30*e, y + 85, x + 30*e, y + 47);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 30*e*tamanio, y, x + 28*e*tamanio, y + 28*tamanio, x + 30*e*tamanio, y + 85*tamanio);
                    dibujo(grados,root, x + 28*e*tamanio, y + 12*tamanio, x - 12*e*tamanio, y - 10*tamanio, x - 13*e*tamanio, y + 60*tamanio, x + 28*e*tamanio, y + 40*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 47*tamanio, x + 50*e*tamanio, y + 47*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 85*tamanio, x + 40*e*tamanio, y + 80*tamanio, x + 40*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y + 47*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+13*e, y-10, x+57*e, y-10, x, y+70, x+57*e, y+70);
                pts(textoCoord, root, puntosDeControl, x+57*e, y-10, x+45*e, y+10, x+40*e, y-125, x-55*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+35*e, y+37, x+65*e, y+47, x+45*e, y+27, x+55*e, y+62);
                fun(root, puntosDeControl, x + 13*e, y - 10, x + 57*e, y - 10, x, y + 70, x + 57*e, y + 70, x + 57*e, y - 10, x + 45*e, y + 10, x + 40*e, y - 125, x - 55*e, y + 50, x + 35*e, y + 37, x + 65*e, y + 47, x + 45*e, y + 27, x + 55*e, y + 62);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 13*e*tamanio, y - 10*tamanio, x, y + 70*tamanio, x + 57*e*tamanio, y + 70*tamanio, x + 57*e*tamanio, y - 10*tamanio);
                    dibujo(grados,root, x + 57*e*tamanio, y - 10*tamanio, x + 40*e*tamanio, y - 125*tamanio, x - 55*e*tamanio, y + 50*tamanio, x + 45*e*tamanio, y + 10*tamanio); //Semi ovalo
                    dibujo(grados,root, x + 35*e*tamanio, y + 37*tamanio, x + 45*e*tamanio, y + 27*tamanio, x + 55*e*tamanio, y + 62*tamanio, x + 65*e*tamanio, y + 47*tamanio);  //Curva derecha (conector)
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 65*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'r' || caracter == 'R') {
            if (caracter == 'r') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1*e, y+10, x+30*e, y, x+30*e, y, x+55*e, y+15);
                pts(textoCoord, root, puntosDeControl, x-1*e, y+10, x+30*e, y, x+30*e, y, x+55*e, y+15);
                fun(root, puntosDeControl, x -1*e, y + 10, x + 10 - 10, y - 21, x - 22 - 10, y + 40, x + 30*e, y, x + 30*e, y, x + 9*e, y + 28, x + 25*e, y + 95, x + 55*e, y + 15);
                while(cont < auxBold) {
                    //CurvA
                    dibujo(grados,root, x  - tamanio*e, y + 10*tamanio, x , y - 21*tamanio, x - 32*e*tamanio, y + 40*tamanio, x + 30*e*tamanio, y);
                    dibujo(grados,root, x + 30*e*tamanio, y, x + 9*e*tamanio, y + 28*tamanio, x + 25*e*tamanio, y + 95*tamanio, x + 55*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //EspacioDecaracterR
                x = x + 55*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+20*e, y-50, x+15*e, y-20);
                pts(textoCoord, root, puntosDeControl, x+20*e, y-50, x+10*e, y+50, x+25*e, y);
                pts(textoCoord, root, puntosDeControl, x+20*e, y-40, x+20*e, y, x+80*e, y-80, x+50*e, y+20);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+40, x+60*e, y+55, x+40*e, y, x+40*e, y+55);
                pts(textoCoord, root, puntosDeControl, x+60*e, y+55, x+80*e, y+15, x+70*e, y+55);
                fun(root, puntosDeControl, x, y + 15, x + 15*e, y - 20, x + 20*e, y - 50, x + 20*e, y - 50, x + 25*e, y, x + 10*e, y + 50, x + 20*e, y - 40, x + 80*e, y - 80, x + 50*e, y + 20, x + 20*e, y, x + 20*e, y, x + 40*e, y, x + 40*e, y + 55, x + 60*e, y + 55, x + 60*e, y + 55, x + 70*e, y + 55, x + 80*e, y + 15);
                while(cont < auxBold) {//CurvA
                    dibujo(grados,root, x, y + 15*tamanio, x + 15*e*tamanio, y - 20*tamanio, x + 20*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y - 50*tamanio, x + 25*e*tamanio, y, x + 10*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y - 40*tamanio, x + 80*e*tamanio, y - 80*tamanio, x + 50*e*tamanio, y + 20*tamanio, x + 20*e*tamanio, y);
                    dibujo(grados,root, x + 20*e*tamanio, y, x + 40*e*tamanio, y, x + 40*e*tamanio, y + 55*tamanio, x + 60*e*tamanio, y + 55*tamanio);
                    dibujo(grados,root, x + 60*e*tamanio, y + 55*tamanio, x + 70*e*tamanio, y + 55*tamanio, x + 80*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                x = x + 80*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 's' || caracter == 'S') {
            if (caracter == 's') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+35, x, y+15, x-40*e, y-15, x+40*e, y-15);
                pts(textoCoord, root, puntosDeControl, x+20*e, y+35, x+22*e, y+40, x+45*e, y+60, x-10*e, y+60);
                pts(textoCoord, root, puntosDeControl, x+22*e, y+40, x+40*e, y+15, x+35*e, y+30);
                fun(root, puntosDeControl, x + 20*e, y + 35, x - 40*e, y - 15, x + 40*e, y - 15, x, y + 10 + 5, x + 20*e, y + 35, x + 45*e, y + 60, x - 10*e, y + 60, x + 22*e, y + 40, x + 22*e, y + 40, x + 35*e, y + 30, x + 40*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 20*e*tamanio, y + 35*tamanio, x - 40*e*tamanio, y - 15*tamanio, x + 40*e*tamanio, y - 15*tamanio, x, y + 15 *tamanio);
                    dibujo(grados,root, x + 20*e*tamanio, y + 35*tamanio, x + 45*e*tamanio, y + 60*tamanio, x - 10*e*tamanio, y + 60*tamanio, x + 22*e*tamanio, y + 40*tamanio);
                    dibujo(grados,root, x + 22*e*tamanio, y + 40*tamanio, x + 35*e*tamanio, y + 30*tamanio, x + 40*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //Espaciocaracter s
                x = x + 40*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                if (caracterAnt != '^' && caracterAnt != '+') {
                    Text t = new Text("\n"+caracter+":");
                    textoCoord.getChildren().add(t);

                    pts(textoCoord, root, puntosDeControl, x-1*e, y+15, x+10*e, y+40, x, y-15, x-30*e, y+20);
                    pts(textoCoord, root, puntosDeControl, x+10*e, y+40, x+25*e, y, x+65*e, y+70, x+50*e, y+10);
                    pts(textoCoord, root, puntosDeControl, x+44*e, y+47, x+70*e, y+15, x+55*e, y+45);
                    pts(textoCoord, root, puntosDeControl, x+25*e, y, x+35*e, y-20, x-30*e, y-30, x+90*e, y-80);
                    fun(root, puntosDeControl, x - 1*e, y + 15, x, y - 15, x - 30*e, y + 20, x + 10*e, y + 40, x + 10*e, y + 40, x + 65*e, y + 70, x + 50*e, y + 10, x + 25*e, y, x + 44*e, y + 47, x + 55*e, y + 45, x + 70*e, y + 15, x + 25*e, y, x - 30*e, y - 30, x + 90*e, y - 80, x + 35*e, y - 20);

                    while(cont < auxBold) {
                        dibujo(grados,root, x - 1*e*tamanio, y + 15*tamanio, x, y - 15*tamanio, x - 30*e*tamanio, y + 20*tamanio, x + 10*e*tamanio, y + 40*tamanio);
                        dibujo(grados,root, x + 10*e*tamanio, y + 40*tamanio, x + 65*e*tamanio, y + 70*tamanio, x + 50*e*tamanio, y + 10*tamanio, x + 25*e*tamanio, y);
                        dibujo(grados,root, x + 44*e*tamanio, y + 47*tamanio, x + 55*e*tamanio, y + 45*tamanio, x + 70*e*tamanio, y + 15*tamanio);
                        dibujo(grados,root, x + 25*e*tamanio, y, x - 30*e*tamanio, y - 30*tamanio, x + 90*e*tamanio, y - 80*tamanio, x + 35*e*tamanio, y - 20*tamanio);
                        if(auxBold > 1){
                            x++;
                        }
                        cont++;
                    }
                    x = x + 70*tamanio* e;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                    }
                }
                else {// Cuando quiere subrayar
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
                pts(textoCoord, root, puntosDeControl, x+10*e, y-40, x+30*e, y+15, x-15*e, y, x+15*e, y+100);
                pts(textoCoord, root, puntosDeControl, x-10*e, y-25, x+15*e, y-25, x-5*e, y-30, x+10*e, y-20);
                fun(root, puntosDeControl, x + 10*e, y - 40, x - 15*e, y, x + 15*e, y + 100, x + 30*e, y + 15, x - 10*e, y - 25, x - 5*e, y - 30, x + 10*e, y - 20, x + 15*e, y - 25);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 10*e*tamanio, y - 40*tamanio, x - 15*e*tamanio, y, x + 15*e*tamanio, y + 100*tamanio, x + 30*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x - 10*e*tamanio, y - 25*tamanio, x - 5*e*tamanio, y - 30*tamanio, x + 10*e*tamanio, y - 20*tamanio, x + 15*e*tamanio, y - 25*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //EspaciocaracterT
                x = x + 30*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                if(caracterAnt=='^' || caracterAnt=='+'){

                }
                else {
                    Text t = new Text("\n" + caracter + ":");
                    textoCoord.getChildren().add(t);
                    pts(textoCoord, root, puntosDeControl, x + 10*e, y - 50, x + 30*e, y + 15, x - 20*e, y, x + 15*e, y + 100);
                    pts(textoCoord, root, puntosDeControl, x - 30*e, y - 40, x + 45*e, y - 55, x - 20*e, y - 55, x + 40*e, y - 40);
                    fun(root, puntosDeControl, x + 10*e, y - 50, x - 20*e, y, x + 15*e, y + 100, x + 30*e, y + 15, x - 30*e, y - 40, x - 20*e, y - 55, x + 40*e, y - 40, x + 45*e, y - 55);

                    while (cont < auxBold) {
                        dibujo(grados,root, x + 10*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y, x + 15*e*tamanio, y + 100*tamanio, x + 30*e*tamanio, y + 15*tamanio);
                        dibujo(grados,root, x - 30*e*tamanio, y - 40*tamanio, x - 20*e*tamanio, y - 55*tamanio, x + 40*e*tamanio, y - 40*tamanio, x + 45*e*tamanio, y - 55*tamanio);
                        if (auxBold > 1) {
                            x++;
                        }
                        cont++;
                    }
                    x = x + 30*tamanio* e;
                    if (auxSub) {
                        Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                    }
                }
            }
        }
        if (caracter == 'u' || caracter == 'U' || caracter == 'ü' || caracter == 'Ü' || caracter == 'ú' || caracter == 'Ú') {
            if (caracter == 'u' || caracter == 'ü' || caracter == 'ú') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                fun(root, puntosDeControl, x + 2*e, y, x - 6*e, y + 30, x + 9*e, y + 80, x + 24*e, y + 15, x + 28*e, y, x + 18*e, y + 30, x + 33*e, y + 100, x + 48*e, y + 15);
                pts(textoCoord, root, puntosDeControl, x+2*e, y, x+24*e, y+15, x-6*e, y+30, x+9*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+28*e, y, x+48*e, y+15, x+18*e, y+30, x+33*e, y+100);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 80*tamanio, x + 24*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 28*e*tamanio, y, x + 18*e*tamanio, y + 30*tamanio, x + 33*e*tamanio, y + 100*tamanio, x + 48*e*tamanio, y + 15*tamanio);
                    if (caracter == 'ü') {
                        dibujo(grados,root, x + 2*e*tamanio, y - 10*tamanio, 2*tamanio);
                        dibujo(grados,root, x + 28*e*tamanio, y - 10*tamanio, 2*tamanio);
                        fun(root, puntosDeControl, x + 2*e, y - 10, x + 28*e, y - 10);
                        Text t5 = new Text("\nX1: " + (x + 2*e) + " Y1: " + (y - 10));
                        Text t6 = new Text("\n");
                        Text t7 = new Text("\nX1: " + (x + 28*e) + " Y1: " + (y - 10));
                        Text t8 = new Text("\n");
                        t5.setFill(Color.BLUE);
                        t6.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t5);
                        textoCoord.getChildren().add(t6);
                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);

                    }
                    if (caracter == 'ú') {
                        dibujo(grados,root, x + 20*e*tamanio, y - 10*tamanio, x + 35*e*tamanio, y - 30*tamanio);
                        fun(root, puntosDeControl, x + 20*e, y - 10, x + 35*e, y - 30);
                        Text t9 = new Text("\nX1: " + (x + 20*e) + " Y1: " + (y - 10) + "\tX2: " + (x + 35*e) + " Y2: " + (y - 30) + "\n");
                        t9.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t9);
                    }
                    Text t10 = new Text("\n");
                    textoCoord.getChildren().add(t10);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de caracter i
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                fun(root, puntosDeControl, x + 2, y - 35, x - 6, y + 30, x + 9, y + 80, x + 24 + 5, y + 15, x + 28 + 5, y - 35, x + 18 + 5, y + 30, x + 33 + 5, y + 100, x + 48 + 5, y + 15, x + 2, y - 35, x + 10, y - 60, x - 20, y - 50, x - 20, y - 20);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+29*e, y+15, x-6*e, y+30, x+9*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+33*e, y-35, x+53*e, y+15, x+22*e, y+30, x+38*e, y+100);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+20*e, y-20, x+10*e, y-60, x-20*e, y-50);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 80*tamanio, x + 29*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 33*e*tamanio, y - 35*tamanio, x + 23*e*tamanio, y + 30*tamanio, x + 38*e*tamanio, y + 100*tamanio, x + 53*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y - 60*tamanio, x - 20*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y - 20*tamanio);
                    if (caracter == 'Ü') {
                        dibujo(grados,root, x + 2*e*tamanio, y - 60*tamanio, 2*tamanio);
                        dibujo(grados,root, x + 33*e*tamanio, y - 60*tamanio, 2*tamanio);
                        fun(root, puntosDeControl, x + 2*e, y - 60, x + 33*e, y - 60);
                        Text t7 = new Text("\nX1: " + (x + 2*e) + " Y1: " + (y - 60) + "\n");
                        Text t8 = new Text("\nX1: " + (x + 33*e) + " Y1: " + (y - 60) + "\n");
                        t7.setFill(Color.BLUE);
                        t8.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t7);
                        textoCoord.getChildren().add(t8);
                    }
                    if (caracter == 'Ú') {
                        dibujo(grados,root, x + 20*e*tamanio, y - 60*tamanio, x + 35*e*tamanio, y - 80*tamanio);
                        fun(root, puntosDeControl, x + 20*e, y - 60, x + 35*e, y - 80);
                        Text t9 = new Text("\nX1: " + (x + 20*e) + " Y1: " + (y - 60) + "\tX2: " + (x + 35*e) + " Y2: " + (y - 80) + "\n");
                        t9.setFill(Color.BLUE);
                        textoCoord.getChildren().add(t9);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
                x = x + 55*tamanio* e;
            }
        }
        if (caracter == 'v' || caracter == 'V') {
            if (caracter == 'v') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3*e, y, x+63*e, y, x+10*e, y+63, x+25*e, y+63);
                pts(textoCoord, root, puntosDeControl, x+35*e, y, x+30*e, y+25, x+35*e, y-20, x+10*e, y+12);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+25, x+50*e, y+15, x+35*e, y+25, x+45*e, y+20);
                fun(root, puntosDeControl, x - 3*e, y, x + 10*e, y + 63, x + 25*e, y + 63, x + 35*e, y, x + 35*e, y, x + 35*e, y - 20, x + 10*e, y + 12, x + 30*e, y + 25, x + 30*e, y + 25, x + 35*e, y + 25, x + 45*e, y + 20, x + 50*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x - 3*e*tamanio, y, x + 10*e*tamanio, y + 63*tamanio, x + 25*e*tamanio, y + 63*tamanio, x + 35*e*tamanio, y);
                    dibujo(grados,root, x + 35*e*tamanio, y, x + 35*e*tamanio, y - 20*tamanio, x + 10*e*tamanio, y + 12*tamanio, x + 30*e*tamanio, y + 25*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 25*tamanio, x + 35*e*tamanio, y + 25*tamanio, x + 45*e*tamanio, y + 20*tamanio, x + 50*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //espaciocaracter v
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x-20*e, y-20, x+10*e, y-60, x-20*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+35*e, y-15, x-6*e, y+30, x+9*e, y+100);
                pts(textoCoord, root, puntosDeControl, x+35*e, y-15, x+30*e, y+10, x+35*e, y-35, x+10*e, y-3);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+10, x+50*e, y, x+35*e, y+10, x+45*e, y+5);
                fun(root, puntosDeControl, x + 2*e, y - 35, x + 10*e, y - 60, x - 20*e, y - 50, x - 20*e, y - 20, x + 2*e, y - 35, x - 6*e, y + 30, x + 9*e, y + 100, x + 35*e, y - 15, x + 35*e, y - 15, x + 35*e, y - 20 - 15, x + 10*e, y + 12 - 15, x + 30*e, y + 25 - 15, x + 30*e, y + 25 - 15, x + 35*e, y + 25 - 15, x + 45*e, y + 20 - 15, x + 50*e, y);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y - 60*tamanio, x - 20*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y - 20*tamanio);
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 100*tamanio, x + 35*e*tamanio, y - 15*tamanio);
                    dibujo(grados,root, x + 35*e*tamanio, y - 15*tamanio, x + 35*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y -3*tamanio, x + 30*e*tamanio, y + 10*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y + 10*tamanio, x + 35*e*tamanio, y + 10*tamanio, x + 45*e*tamanio, y + 5*tamanio, x + 50*e*tamanio, y);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }

                if(auxBold > 1){
                    x++;
                }
                //espaciocaracter v
                x = x + 50*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }

            }
        }
        if (caracter == 'w' || caracter == 'W') {
            if (caracter == 'w') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+4*e, y, x+24*e, y+15, x-6*e, y+30, x+9*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+24*e, y+15, x+50*e, y, x+20*e, y+73, x+40*e, y+83);
                pts(textoCoord, root, puntosDeControl, x+50*e, y, x+45*e, y+25, x+50*e, y-20, x+25*e, y+12);
                pts(textoCoord, root, puntosDeControl, x+45*e, y+25, x+65*e, y+15, x+50*e, y+25, x+60*e, y+20);
                fun(root, puntosDeControl, x + 4*e, y, x - 6*e, y + 30, x + 9*e, y + 80, x + 24*e, y + 15, x + 24*e, y + 15, x + 20*e, y + 73, x + 40*e, y + 83, x + 50*e, y, x + 50*e, y, x + 50*e, y - 20, x + 25*e, y + 12, x + 45*e, y + 25, x + 45*e, y + 25, x + 50*e, y + 25, x + 60*e, y + 20, x + 65*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados,root, x + 4*e*tamanio, y, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 80*tamanio, x + 24*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 24*e*tamanio, y + 15*tamanio, x + 20*e*tamanio, y + 73*tamanio, x + 40*e*tamanio, y + 83*tamanio, x + 50*e*tamanio, y);
                    dibujo(grados,root, x + 50*e*tamanio, y, x + 50*e*tamanio, y - 20*tamanio, x + 25*e*tamanio, y + 12*tamanio, x + 45*e*tamanio, y + 25*tamanio);
                    dibujo(grados,root, x + 45*e*tamanio, y + 25*tamanio, x + 50*e*tamanio, y + 25*tamanio, x + 60*e*tamanio, y + 20*tamanio, x + 65*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //espaciocaracter v
                x = x + 65*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }

            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);

                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+29*e, y+15, x-6*e, y+30, x+9*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+30*e, y+25, x+60*e, y-13, x+25*e, y+73, x+45*e, y+83);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x-20*e, y-20, x+10*e, y-60, x-20*e, y-50);
                pts(textoCoord, root, puntosDeControl, x+55*e, y-15, x+55*e, y+10, x+60*e, y-35, x+35*e, y-3);
                pts(textoCoord, root, puntosDeControl, x+55*e, y+10, x+75*e, y, x+60*e, y+10, x+70*e, y+5);
                fun(root, puntosDeControl, x + 2*e, y - 35, x - 6*e, y + 30, x + 9*e, y + 80, x + 24*e + 5, y + 15, x + 30*e, y, x + 25*e, y + 73, x + 45*e, y + 83, x + 60*e, y - 13, x + 2*e, y - 35, x + 10*e, y - 60, x - 20*e, y - 50, x - 20*e, y - 20, x + 60*e, y - 15, x + 60*e, y - 20 - 15, x + 35*e, y + 12 - 15, x + 55*e, y + 25 - 15, x + 55*e, y + 25 - 15, x + 60*e, y + 25 - 15, x + 70*e, y + 20 - 15, x + 75*e, y);

                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 80*tamanio, x + 29*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y, x + 25*e*tamanio, y + 73*tamanio, x + 45*e*tamanio, y + 83*tamanio, x + 60*e*tamanio, y - 13*tamanio);
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y - 60*tamanio, x - 20*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y - 20*tamanio);
                    dibujo(grados,root, x + 60*e*tamanio, y - 15*tamanio, x + 60*e*tamanio, y -35*tamanio, x + 35*e*tamanio, y -3*tamanio, x + 55*e*tamanio, y + 10*tamanio);
                    dibujo(grados,root, x + 55*e*tamanio, y + 10*tamanio, x + 60*e*tamanio, y + 10*tamanio, x + 70*e*tamanio, y + 5*tamanio, x + 75*e*tamanio, y);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 70*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if (caracter == 'x' || caracter == 'X') {
            if (caracter == 'x') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-3*e, y+10, x+60*e, y+15, x+45*e, y+100, x+50*e, y+50);
                pts(textoCoord, root, puntosDeControl, x+5*e, y+50, x+45*e, y, x+30*e, y+10);
                fun(root, puntosDeControl, x - 3*e, y + 10, x + 45*e, y + 100, x + 50*e, y + 50, x + 60*e, y + 15, x + 5*e, y + 50, x + 30*e, y + 10, x + 45*e, y);
                while(cont < auxBold) {
                    dibujo(grados,root, x - 3*e*tamanio, y + 10*tamanio, x + 45*e*tamanio, y + 100*tamanio, x + 50*e*tamanio, y + 50*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x + 5*e*tamanio, y + 50*tamanio, x + 30*e*tamanio, y + 10*tamanio, x + 45*e*tamanio, y);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+80*e, y+15, x+45*e, y+100, x+50*e, y+50);
                pts(textoCoord, root, puntosDeControl, x, y+50, x+45*e, y-50, x-10*e, y);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x-20*e, y-20, x-5*e, y-60, x-20*e, y-50);
                fun(root, puntosDeControl, x + 2*e, y - 35, x + 45*e, y + 100, x + 50*e, y + 50, x + 80*e, y + 15, x, y + 50, x - 10*e, y, x + 45*e, y - 50, x + 2*e, y - 35, x - 5*e, y - 60, x - 20*e, y - 50, x - 20*e, y - 20);
                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x + 45*e*tamanio, y + 100*tamanio, x + 50*e*tamanio, y + 50*tamanio, x + 80*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x, y + 50*tamanio, x - 10*e*tamanio, y, x + 45*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x - 5*e*tamanio, y - 60*tamanio, x - 20*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y - 20*tamanio);
                    if(auxBold > 1){
                        x++;
                    }
                    cont++;
                }
                //tamaÃ±ocaracter x
                x = x + 80*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }

            }
        }
        if (caracter == 'y' || caracter == 'Y') {
            if (caracter == 'y') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y, x+24*e, y+15, x-6*e, y+30, x+9*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+24*e, y, x+24*e, y+50, x+35*e, y+113, x-40*e, y+98);
                pts(textoCoord, root, puntosDeControl, x+23*e, y+51, x+45*e, y+15, x+35*e, y+50);
                fun(root, puntosDeControl, x + 2*e, y, x - 6*e, y + 30, x + 9*e, y + 80, x + 24*e, y + 15, x + 24*e, y, x + 35*e, y + 113, x - 40*e, y + 98, x + 24*e, y + 50, x + 23*e, y + 51, x + 35*e, y + 50, x + 45*e, y + 15);

                while(cont < auxBold) {
                    dibujo(grados, root, x + 2*e*tamanio, y, x - 6*e*tamanio, y + 30*tamanio, x + 9*e*tamanio, y + 80*tamanio, x + 24*e*tamanio, y + 15*tamanio);
                    dibujo(grados, root, x + 24*e*tamanio, y, x + 35*e*tamanio, y + 113*tamanio, x - 40*e*tamanio, y + 98*tamanio, x + 24*e*tamanio, y + 50*tamanio);
                    dibujo(grados, root, x + 23*e*tamanio, y + 51*tamanio, x + 35*e*tamanio, y + 50*tamanio, x + 45*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //espaciocaracter v
                x = x + 45*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x+30*e, y-35, x-6*e, y-20, x+9*e, y+30);
                pts(textoCoord, root, puntosDeControl, x+30*e, y-50, x+25*e, y+10, x+30*e, y+90, x-35*e, y+55);
                pts(textoCoord, root, puntosDeControl, x+28*e, y+10, x+50*e, y, x+40*e, y+10);
                pts(textoCoord, root, puntosDeControl, x+2*e, y-35, x-20*e, y-20, x+10*e, y-60, x-20*e, y-50);
                fun(root, puntosDeControl, x + 2*e, y - 35, x - 6*e, y + 30 - 50, x + 9*e, y + 80 - 50, x + 30*e, y + 15 - 50, x + 30*e, y - 50, x + 30*e, y + 140 - 50, x - 45*e, y + 105 - 50, x + 25*e, y + 10, x + 28*e, y + 10, x + 40*e, y + 10, x + 50*e, y, x + 2*e, y - 35, x + 10*e, y - 60, x - 20*e, y - 50, x - 20*e, y - 20);

                while(cont < auxBold) {
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x - 6*e*tamanio, y -20*tamanio, x + 9*e*tamanio, y + 30*tamanio, x + 30*e*tamanio, y -35*tamanio);
                    dibujo(grados,root, x + 30*e*tamanio, y - 50*tamanio, x + 30*e*tamanio, y + 90*tamanio, x - 35*e*tamanio, y + 55*tamanio, x + 25*e*tamanio, y + 10*tamanio);
                    dibujo(grados,root, x + 28*e*tamanio, y + 10*tamanio, x + 40*e*tamanio, y + 10*tamanio, x + 50*e*tamanio, y);
                    dibujo(grados,root, x + 2*e*tamanio, y - 35*tamanio, x + 10*e*tamanio, y - 60*tamanio, x - 20*e*tamanio, y - 50*tamanio, x - 20*e*tamanio, y - 20*tamanio);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 46*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }

            }
        }
        if (caracter == 'z' || caracter == 'Z') {
            if (caracter == 'z') {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x-1*e, y+10, x+40*e, y, x, y-21, x-32*e, y+40);
                pts(textoCoord, root, puntosDeControl, x+40*e, y, x+7*e, y+47);
                pts(textoCoord, root, puntosDeControl, x+7*e, y+47, x+35*e, y+90, x+50*e, y+10, x+45*e, y+80);
                pts(textoCoord, root, puntosDeControl, x+35*e, y+90, x+40*e, y+50, x+15*e, y+120, x-15*e, y+45);
                pts(textoCoord, root, puntosDeControl, x+40*e, y+50, x+60*e, y+15, x+55*e, y+50, x+60*e, y+15);
                fun(root, puntosDeControl, x - 1*e, y + 10, x, y - 21, x - 32*e, y + 40, x + 40*e, y, x + 40*e, y, x + 7*e, y + 47, x + 7*e, y + 47, x + 50*e, y + 10, x + 45*e, y + 80, x + 35*e, y + 90, x + 35*e, y + 90, x + 15*e, y + 120, x - 15*e, y + 45, x + 40*e, y + 50, x + 40*e, y + 50, x + 55*e, y + 50, x + 60*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x - 1*e*tamanio, y + 10*tamanio, x, y - 21*tamanio, x - 32*e*tamanio, y + 40*tamanio, x + 40*e*tamanio, y);
                    dibujo(grados,root, x + 40*e*tamanio, y, x + 7*e*tamanio, y + 47*tamanio);
                    dibujo(grados,root, x + 7*e*tamanio, y + 47*tamanio, x + 50*e*tamanio, y + 10*tamanio, x + 45*e*tamanio, y + 80*tamanio, x + 35*e*tamanio, y + 90*tamanio);
                    dibujo(grados,root, x + 35*e*tamanio, y + 90*tamanio, x + 15*e*tamanio, y + 120*tamanio, x - 15*e*tamanio, y + 45*tamanio, x + 40*e*tamanio, y + 50*tamanio);
                    dibujo(grados,root, x + 40*e*tamanio, y + 50*tamanio, x + 55*e*tamanio, y + 50*tamanio, x + 60*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                //largo de z
                x = x + 60*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            } else {
                Text t = new Text("\n"+caracter+":");
                textoCoord.getChildren().add(t);
                pts(textoCoord, root, puntosDeControl, x, y-50, x+65*e, y-50, x+25*e, y-45);
                pts(textoCoord, root, puntosDeControl, x+65*e, y-50, x, y+50, x+25*e, y-45);
                pts(textoCoord, root, puntosDeControl, x+50*e, y+10, x+65*e, y+15, x+10*e, y+20, x+50*e, y+100);
                pts(textoCoord, root, puntosDeControl, x, y+15, x+40*e, y+15, x+10*e, y-15, x+20*e, y+40);
                fun(root, puntosDeControl, x, y - 50, x + 25*e, y - 45, x + 65*e, y - 50, x + 65*e, y - 50, x + 25*e, y - 45, x, y + 50, x, y + 50, x + 10*e, y + 20, x + 50*e, y + 100, x + 65*e, y + 15, x, y + 50 - 35, x + 10*e, y + 20 - 35, x + 20*e, y + 40, x + 40*e, y + 15);
                while(cont < auxBold) {
                    dibujo(grados,root, x, y - 50*tamanio, x + 25*e*tamanio, y - 45*tamanio, x + 65*e*tamanio, y - 50*tamanio);
                    dibujo(grados,root, x + 65*e*tamanio, y - 50*tamanio, x + 25*e*tamanio, y - 45*tamanio, x, y + 50*tamanio);
                    dibujo(grados,root, x, y + 50*tamanio, x + 10*e*tamanio, y + 20*tamanio, x + 50*e*tamanio, y + 100*tamanio, x + 65*e*tamanio, y + 15*tamanio);
                    dibujo(grados,root, x, y + 15*tamanio, x + 10*e*tamanio, y  - 15*tamanio, x + 20*e*tamanio, y + 40*tamanio, x + 40*e*tamanio, y + 15*tamanio);
                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }
                x = x + 65*tamanio* e;
                if (auxSub) {
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }

    }

    public void Simbolos(boolean cursiva,String estilo, char caracter, char caracterAnt, AnchorPane root, TextFlow textoCoord, ToggleButton puntosDeControl, int borrar, ScrollPane scrollPane, int tamanio ){
        auxK=cursiva;
        if (borrar == 1) {

            if(tras == false){
                x = 30;
                y = 100;
            }else{
                x = xTras;
                y = yTras;
            }

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
                if (e == 1) {
                    x = x + 50 * e;
                }
            }
            if (e == -1 && x == 30) {
                x = 1450;
            }

            if (x != 1450 && e == -1) {
                x = x - 50;
            }
            auxSub = false;
            auxK = false;
            auxBold = 1;
            xa=x;
            ya=y;
        }
        if(estilo.contains("N")){
            auxBold = 4;
        }

        if(estilo.contains("S")){
            auxSub = true;
            xInicialSu = x;
            yInicialSu = y + 55;
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                        y++;
                    }

                    cont++;
                }
                x = x + 55;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                        y++;
                    }

                    cont++;
                }

                x = x + 70;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
        }
        if(caracter == '«' || caracter == '»'){
            Text t = new Text("\n"+caracter+":");
            textoCoord.getChildren().add(t);
            if (caracter == '«'){

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

                    x = x + 20;

                    Line l3 = new Line(x + 10, y + 25, x + 50, y);
                    l3.setFill(Color.TRANSPARENT);
                    l3.setStroke(color);
                    l3.setStrokeWidth(grosor);

                    Line l4 = new Line(x + 10, y + 25, x + 50, y + 50);
                    l4.setFill(Color.TRANSPARENT);
                    l4.setStroke(color);
                    l4.setStrokeWidth(grosor);

                    root.getChildren().add(l1);
                    root.getChildren().add(l2);
                    root.getChildren().add(l3);
                    root.getChildren().add(l4);

                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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

                    x = x + 20;

                    Line l3 = new Line(x + 10, y, x + 50, y + 25);
                    l3.setFill(Color.TRANSPARENT);
                    l3.setStroke(color);
                    l3.setStrokeWidth(grosor);

                    Line l4 = new Line(x + 10, y + 50, x + 50, y + 25);
                    l4.setFill(Color.TRANSPARENT);
                    l4.setStroke(color);
                    l4.setStrokeWidth(grosor);

                    root.getChildren().add(l3);
                    root.getChildren().add(l4);


                    if(auxBold > 1){
                        x++;
                    }

                    cont++;
                }

                x = x + 65;
                if(auxSub){
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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

                pts(textoCoord, root, puntosDeControl, x+5, y-20, x+5, y-50);
                pts(textoCoord, root, puntosDeControl, x+5, y-20, x+7, y-20);
                fun(root, puntosDeControl, x + 5, y - 20, x, y - 35, x + 5, y - 50, x + 5, y - 20, x + 25, y + 15, x + 35, y - 20, x + 7, y - 20);

                cont = 0;

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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
                }
            }
            x=x+20;
            if(auxSub){
                Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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
                    Subrayar(xInicialSu, yInicialSu*tamanio, x*tamanio, root);
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

    public void dibujo(int r,AnchorPane root, int... lista){
        if(lista.length == 8) {
            //cubica
            CubicCurve c1 = new CubicCurve(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5], lista[6], lista[7]);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(color);
            c1.setStrokeWidth(grosor);
            if(auxK){
                c1.getTransforms().add(new Rotate(r, x,y));
            }else{
                c1.getTransforms().add(new Rotate(r, xa,ya));
            }
            root.getChildren().add(c1);
        }
        else if(lista.length == 6) {
            //cuadratica
            QuadCurve q = new QuadCurve(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5]);
            q.setFill(Color.TRANSPARENT);
            q.setStroke(color);
            q.setStrokeWidth(grosor);
            if(auxK){
                q.getTransforms().add(new Rotate(r, x,y));
            }else{
                q.getTransforms().add(new Rotate(r, xa,ya));
            }

            root.getChildren().add(q);
        }
        else if(lista.length == 4) {
            //linea
            Line l = new Line(lista[0], lista[1], lista[2], lista[3]);
            l.setFill(Color.TRANSPARENT);
            l.setStroke(color);
            l.setStrokeWidth(grosor);
            if(auxK){
                l.getTransforms().add(new Rotate(r, x,y));
            }else{
                l.getTransforms().add(new Rotate(r, xa,ya));
            }

            root.getChildren().add(l);
        }
        else if(lista.length == 3) {
            //punto
            Circle p = new Circle(lista[0], lista[1], lista[2]);
            p.setFill(Color.TRANSPARENT);
            p.setStroke(color);
            p.setStrokeWidth(grosor);
            if(auxK){
                p.getTransforms().add(new Rotate(r, x,y));
            }else{
                p.getTransforms().add(new Rotate(r, xa,ya));
            }

            root.getChildren().add(p);
        }
    }

}
