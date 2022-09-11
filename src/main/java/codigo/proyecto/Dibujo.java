package codigo.proyecto; // K L M N Ñ O P Q

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

public class Dibujo {

    int x = 50;
    int y = 300;
    int grosor = 4;
    Color color = Color.BLACK;

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

    public void Selector(char letra, int det, AnchorPane root){

        if(letra == 'a' || letra == 'A'){

            if(letra == 'a'){
                CubicCurve c= new CubicCurve(x+30, y+10, x-5, y-30, x-20, y+85, x+25, y+30);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+35, y, x+10, y+60, x+50, y+65, x+60, y+15);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);


                root.getChildren().add(c);
                root.getChildren().add(c2);

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

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                x = x+65;
            }



        }
        if(letra == 'b' || letra == 'B'){

            if(letra == 'b'){
                CubicCurve cb1 = new CubicCurve(x, y+15, x+70, y-80, x-10, y-80, x, y+50); //"l" superior
                cb1.setFill(Color.TRANSPARENT);
                cb1.setStroke(color);
                cb1.setStrokeWidth(grosor);

                CubicCurve cb2 = new CubicCurve(x, y+30, x+50, y-50, x+35, y+100, x+5, y+50);
                cb2.setFill(Color.TRANSPARENT);
                cb2.setStroke(color);
                cb2.setStrokeWidth(grosor);

                CubicCurve cb3 = new CubicCurve(x+5, y+50, x, y+30, x+60, y+50, x+61, y+20);
                cb3.setFill(Color.TRANSPARENT);
                cb3.setStroke(color);
                cb3.setStrokeWidth(grosor);

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

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);
                root.getChildren().add(c5);
                x = x+80;
            }




        }


        if(letra == 'c' || letra == 'C'){

            if(letra == 'c'){
                CubicCurve c = new CubicCurve(x, y+25, x, y-20, x+40, y-5, x+25 , y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c1 = new CubicCurve(x, y+25, x-5, y+45, x+30, y+80, x+60, y+15);
                c1.setFill(Color.TRANSPARENT);
                c1.setStroke(color);
                c1.setStrokeWidth(grosor);

                root.getChildren().add(c);
                root.getChildren().add(c1);

                x = x+60;
            }else{

                CubicCurve c = new CubicCurve(x+20, y-40, x, y-10, x+10, y+110, x+60, y+15); // C
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+20, y-40, x+30, y-60, x+60, y-50, x+10, y);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+10, y, x-20, y+10, x, y-30, x+10, y-40);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+60;
            }

        }

        if(letra == 'd' || letra == 'D'){

            if (letra == 'd'){
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

                root.getChildren().add(c1);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+90;
            }



        }
        if(letra =='e' || letra == 'E'){

            if (letra == 'e'){
                CubicCurve b = new CubicCurve(x, y+25, x-5, y-20, x+50, y, x+5, y+30);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x, y+25, x, y+50, x+40, y+70, x+50, y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                root.getChildren().add(b);
                root.getChildren().add(c);

                x = x+50;
            }else{
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

                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                x = x+60;
            }

            //tamaÃ±o letra
        }
        if(letra =='f' || letra == 'F'){

            if (letra == 'f'){
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

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);

                x = x+50;
            }


        }

        if(letra =='g' || letra =='G'){

            if (letra == 'g'){
                CubicCurve c = new CubicCurve(x+25, y+10, x-10, y-20, x-10, y+70, x+25, y+40); // Circulo
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+25, y, x+35, y+100, x+10, y+100, x+10, y+80);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c3 = new CubicCurve(x+10, y+80, x+20, y+30, x+60, y+60, x+60, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

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

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                x = x + 80;
            }

        }

        if(letra =='h' || letra == 'H'){

            if(letra == 'h'){
                CubicCurve c2 = new CubicCurve(x, y+15, x+50, y-50, x-10, y-90, x, y+50); // l
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x, y+40, x+10, y, x+30, y+5, x+25, y+35); // guata
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);


                CubicCurve c3 = new CubicCurve(x+25, y+35, x+20, y+55, x+40, y+70, x+50, y+15);
                c3.setFill(Color.TRANSPARENT);
                c3.setStroke(color);
                c3.setStrokeWidth(grosor);

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

                root.getChildren().add(c);
                root.getChildren().add(c2);
                root.getChildren().add(c3);
                root.getChildren().add(c4);

                x = x+70;
            }
        }


        if(letra =='i' || letra == 'I'){

            if (letra == 'i'){
                Circle p = new Circle(x+2, y-10, 2);
                p.setFill(Color.TRANSPARENT);
                p.setStroke(color);
                p.setStrokeWidth(grosor);

                CubicCurve c = new CubicCurve(x+2, y, x-5, y+80, x+30, y+40, x+40, y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                root.getChildren().add(c);
                root.getChildren().add(p);

                x = x+40;
            }else{
                CubicCurve c = new CubicCurve(x+25, y-20, x+20, y-70, x+60, y-60, x+40, y+30); // primera curva hacia
                // abajo
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                CubicCurve c2 = new CubicCurve(x+40, y+30, x+30, y+80, x+20, y+20, x+35, y+20);
                c2.setFill(Color.TRANSPARENT);
                c2.setStroke(color);
                c2.setStrokeWidth(grosor);

                root.getChildren().add(c);
                root.getChildren().add(c2);

                x = x+60;
            }


        }

        if(letra =='j'){
            CubicCurve cb1 = new CubicCurve(x-15, y+65,x-15, y+50, x+30, y+35, x+30, y+15); //"l" superior
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            root.getChildren().add(cb1);

            CubicCurve cb2 = new CubicCurve(x, y+70,x-5, y+95, x-20, y+85, x-15, y+65); //Semi ovalo
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(cb2);

            CubicCurve cb3 = new CubicCurve(x, y,x-1, y+20, x+5, y+60, x, y+70); //"l" superior
            cb3.setFill(Color.TRANSPARENT);
            cb3.setStroke(color);
            cb3.setStrokeWidth(grosor);

            root.getChildren().add(cb3);

            Circle cd1 = new Circle(x, y-10, grosor);

            root.getChildren().add(cd1);

            x = x+30;
        }
        if(letra =='k'){

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

            root.getChildren().add(cb1);
            root.getChildren().add(cb2);
            root.getChildren().add(cb3);

            x = x+55;
        }
        if(letra =='l'){

            CubicCurve cb1 = new CubicCurve(x, y+15,x+37, y-40, x-3, y-120, x-1, y+40); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x-1, y+40,x, y+60, x+20, y+60, x+30, y+15);  //Curva derecha (conector)
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x+30;
        }
        if(letra =='m'){

            QuadCurve qv1 = new QuadCurve(x, y,x-1,y+50,x+8,y+50);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+25,x+18, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(color);
            qv1_5.setStrokeWidth(grosor);

            QuadCurve qv2 = new QuadCurve(x+20, y,x+15,y+50,x+25,y+48);
            qv2.setFill(Color.TRANSPARENT);
            qv2.setStroke(color);
            qv2.setStrokeWidth(grosor);

            QuadCurve qv2_5 = new QuadCurve(x+25, y+48,x+25,y+25,x+38, y);
            qv2_5.setFill(Color.TRANSPARENT);
            qv2_5.setStroke(color);
            qv2_5.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+40, y, x+35, y+85, x+50, y+55, x+60, y+15); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv1_5);
            root.getChildren().add(qv2);
            root.getChildren().add(qv2_5);
            root.getChildren().add(cb2);

            x = x+60;
        }
        if(letra =='n'){

            QuadCurve qv1 = new QuadCurve(x, y,x-1,y+50,x+8,y+50);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+10,x+20, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(color);
            qv1_5.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+21, y, x+15, y+85, x+30, y+55, x+40, y+15); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv1_5);
            root.getChildren().add(cb1);

            x = x+40;
        }
        if(letra =='ñ'){

            QuadCurve qv1 = new QuadCurve(x, y,x-1,y+50,x+8,y+50);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+10,x+20, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(color);
            qv1_5.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+21, y, x+15, y+85, x+30, y+55, x+40, y+15); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+5, y-15, x+10, y-25, x+15, y-5, x+20, y-15);
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv1_5);
            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x+40;
        }
        if(letra =='o'){

            Circle cd1 = new Circle(x+23, y+25, 25);
            cd1.setFill(Color.TRANSPARENT);
            cd1.setStroke(color);
            cd1.setStrokeWidth(grosor);

            QuadCurve qv1 = new QuadCurve(x+10, y+5,x+30,y+40,x+60,y+15);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            root.getChildren().add(cd1);
            root.getChildren().add(qv1);

            x = x + 60;
        }
        if(letra =='p'){

            QuadCurve qv1 = new QuadCurve(x, y,x-2,y+15,x,y+85);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+1, y+15, x+40, y-15, x+35, y+50, x+25, y+50); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+25, y+50, x, y+60, x, y+30, x+30, y+35); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            QuadCurve d = new QuadCurve(x+30, y+35,x+40,y+30,x+55,y+15);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(color);
            d.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(cb1);
            root.getChildren().add(cb2);
            root.getChildren().add(d);



            x = x + 55;

        }
        if(letra =='q'){

            QuadCurve qv1 = new QuadCurve(x+30, y,x+28,y+28, x+30,y+85);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(color);
            qv1.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+28, y+12, x-12, y-10, x-13, y+60, x+28, y+40); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(color);
            cb1.setStrokeWidth(grosor);

            QuadCurve qv2 = new QuadCurve(x+30, y+47,x+50,y+47,x+60,y+15);
            qv2.setFill(Color.TRANSPARENT);
            qv2.setStroke(color);
            qv2.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+30, y+85, x+40, y+80, x+40, y+50, x+30, y+47); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(color);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv2);
            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x + 60;

        }
        if(letra =='r' || letra == 'R' ){
            if(letra =='r'){
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                //EspacioDeLetraR
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                root.getChildren().add(e);

                x = x +80;
            }
        }
        if(letra =='s' || letra == 'S'){
            if(letra =='s'){
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //EspacioLetra s
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

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                x = x+70;
            }

        }
        if(letra =='t' || letra == 'T'){
            if(letra == 't'){
                //CurvaA
                CubicCurve a = new CubicCurve(x+10,y-50,x-20,y,x+15,y+100,x+30,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x-10,y-25,x-5,y-30,x+10,y-20,x+15,y-25);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                //EspacioLetraT
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

                root.getChildren().add(a);
                root.getChildren().add(b);
                x=x+30;




            }
        }
        if(letra =='u' || letra == 'U'){
            if(letra == 'u'){
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

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);

                //largo de letra i
                x=x+50;
            }
            else{
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

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //largo de letra i
                x=x+55;
            }
        }
        if(letra =='v' || letra == 'V'){
            if(letra =='v'){
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //espacioLetra v
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
                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                //espacioLetra v
                x=x+50;

            }
        }
        if(letra =='w' || letra == 'W'){
            if(letra == 'w'){
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);

                //espacioLetra v
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

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                root.getChildren().add(e);

                x=x+70;
            }
        }
        if(letra =='x' || letra == 'X'){
            if(letra == 'x' ){
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

                //tamaÃ±oLetra x
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

                //roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //tamaÃ±oLetra x
                x=x+80;

            }
        }
        if(letra =='y' || letra == 'Y'){
            if(letra == 'y'){
                //curvaA
                CubicCurve a = new CubicCurve(x+2,y,x-6,y+30,x+9,y+80,x+24,y+15);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(color);
                a.setStrokeWidth(grosor);

                //CurvaB
                CubicCurve b = new CubicCurve(x+24,y,x+24,y+140,x-40,y+105,x+24,y+50);
                b.setFill(Color.TRANSPARENT);
                b.setStroke(color);
                b.setStrokeWidth(grosor);

                QuadCurve c = new QuadCurve(x+23,y+50, x+35, y+50,x+45,y+15);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(color);
                c.setStrokeWidth(grosor);

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);

                //espacioLetra v
                x=x+46;
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

                //Roots
                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                x=x+46;

            }
        }
        if(letra =='z' || letra == 'Z'){
            if(letra == 'z' ){
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

                root.getChildren().add(a);
                root.getChildren().add(b);
                root.getChildren().add(c);
                root.getChildren().add(d);
                x=x+65;


            }
        }
    }
}