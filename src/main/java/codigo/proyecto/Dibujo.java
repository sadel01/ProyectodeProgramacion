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
    public void Selector(char letra, int det, AnchorPane root){

        if(letra == 'a'){

            CubicCurve c= new CubicCurve(x+30, y+10, x-5, y-30, x-20, y+85, x+25, y+30);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            CubicCurve c2 = new CubicCurve(x+35, y, x+10, y+60, x+50, y+65, x+60, y+15);
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);


            root.getChildren().add(c);
            root.getChildren().add(c2);

            x = x+60;
        }
        if(letra == 'b'){

            CubicCurve cb1 = new CubicCurve(x, y+15, x+70, y-80, x-10, y-80, x, y+50); //"l" superior
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x, y+30, x+50, y-50, x+35, y+100, x+5, y+50);
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            CubicCurve cb3 = new CubicCurve(x+5, y+50, x, y+30, x+60, y+50, x+61, y+20);
            cb3.setFill(Color.TRANSPARENT);
            cb3.setStroke(Color.BLACK);
            cb3.setStrokeWidth(grosor);

            root.getChildren().add(cb1);
            root.getChildren().add(cb2);
            root.getChildren().add(cb3);

            x = x+60;

        }


        if(letra == 'c'){


            CubicCurve c = new CubicCurve(x, y+25, x+5, y-5, x+40, y-5, x+25 , y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            CubicCurve c1 = new CubicCurve(x, y+25, x-5, y+45, x+30, y+80, x+60, y+15);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(c1);
            x = x+60;
        }

        if(letra == 'd'){
            CubicCurve c = new CubicCurve(x+25, y+15, x-15, y-30, x, y+90, x+25, y+25);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            CubicCurve c2 = new CubicCurve(x+25, y+5, x+80, y-50, x+20, y-80, x+25, y+25);
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);

            CubicCurve c3 = new CubicCurve(x+25, y+25, x+30, y+50, x+50, y+50, x+60, y+15);
            c3.setFill(Color.TRANSPARENT);
            c3.setStroke(Color.BLACK);
            c3.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(c2);
            root.getChildren().add(c3);

            x = x+60;

        }

        if(letra =='e'){

            CubicCurve b = new CubicCurve(x, y+25, x-5, y-20, x+50, y, x+5, y+30);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            CubicCurve c = new CubicCurve(x, y+25, x, y+50, x+40, y+70, x+50, y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            root.getChildren().add(b);
            root.getChildren().add(c);
            //tamaÃ±o letra
            x = x+50;
        }
        if(letra =='f'){

            CubicCurve c1 = new CubicCurve(x, y+10, x, y-60, x+60, y-60, x, y+10); // Curva Superior
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(grosor);

            CubicCurve c2 = new CubicCurve(x, y, x, y+110, x+50, y+60, x+2, y+15); // Curva inferior
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);

            QuadCurve c3 = new QuadCurve(x+2, y+25, x+35, y+60, x+50, y+15); // Conexion
            c3.setFill(Color.TRANSPARENT);
            c3.setStroke(Color.BLACK);
            c3.setStrokeWidth(grosor);

            root.getChildren().add(c1);
            root.getChildren().add(c2);
            root.getChildren().add(c3);

            x = x+50;
        }

        if(letra =='g'){

            CubicCurve c = new CubicCurve(x+25, y+10, x-10, y-20, x-10, y+70, x+25, y+40); // Circulo
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            CubicCurve c2 = new CubicCurve(x+25, y, x+35, y+100, x+10, y+100, x+10, y+80);
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);

            CubicCurve c3 = new CubicCurve(x+10, y+80, x+20, y+30, x+60, y+60, x+60, y+15);
            c3.setFill(Color.TRANSPARENT);
            c3.setStroke(Color.BLACK);
            c3.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(c2);
            root.getChildren().add(c3);

            x = x+60;
        }
        if(letra =='h'){

            CubicCurve c2 = new CubicCurve(x, y+15, x+50, y-50, x-10, y-90, x, y+50); // l
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);

            CubicCurve c = new CubicCurve(x, y+40, x+10, y, x+30, y+5, x+25, y+35); // guata
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);


            CubicCurve c3 = new CubicCurve(x+25, y+35, x+20, y+55, x+40, y+70, x+50, y+15);
            c3.setFill(Color.TRANSPARENT);
            c3.setStroke(Color.BLACK);
            c3.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(c2);
            root.getChildren().add(c3);

            x = x+50;
        }
        if(letra =='i'){

            Circle p = new Circle(x+2, y-10, 2);
            p.setFill(Color.TRANSPARENT);
            p.setStroke(Color.BLACK);
            p.setStrokeWidth(grosor);

            CubicCurve c = new CubicCurve(x+2, y, x-5, y+80, x+30, y+40, x+40, y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(p);

            x = x+40;

        }

        if(letra =='j'){
            CubicCurve cb1 = new CubicCurve(x-15, y+65,x-15, y+50, x+30, y+35, x+30, y+15); //"l" superior
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            root.getChildren().add(cb1);

            CubicCurve cb2 = new CubicCurve(x, y+70,x-5, y+95, x-20, y+85, x-15, y+65); //Semi ovalo
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(cb2);

            CubicCurve cb3 = new CubicCurve(x, y,x-1, y+20, x+5, y+60, x, y+70); //"l" superior
            cb3.setFill(Color.TRANSPARENT);
            cb3.setStroke(Color.BLACK);
            cb3.setStrokeWidth(grosor);

            root.getChildren().add(cb3);

            Circle cd1 = new Circle(x, y-10, grosor);

            root.getChildren().add(cd1);

            x = x+30;
        }
        if(letra =='k'){

            CubicCurve cb1 = new CubicCurve(x+2, y,x+37, y, x-3, y-150, x-1, y+50); //"l" superior
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x, y+18,x+7, y-10, x+42, y+20, x+17, y+30); //Semi ovalo
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            CubicCurve cb3 = new CubicCurve(x+17, y+30,x+37, y+72, x+47, y+50, x+55, y+15);  //Curva derecha (conector)
            cb3.setFill(Color.TRANSPARENT);
            cb3.setStroke(Color.BLACK);
            cb3.setStrokeWidth(grosor);

            root.getChildren().add(cb1);
            root.getChildren().add(cb2);
            root.getChildren().add(cb3);

            x = x+55;
        }
        if(letra =='l'){

            CubicCurve cb1 = new CubicCurve(x, y+15,x+37, y-40, x-3, y-120, x-1, y+40); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x-1, y+40,x, y+60, x+20, y+60, x+30, y+15);  //Curva derecha (conector)
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x+30;
        }
        if(letra =='m'){

            QuadCurve qv1 = new QuadCurve(x, y,x-1,y+50,x+8,y+50);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+25,x+18, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(Color.BLACK);
            qv1_5.setStrokeWidth(grosor);

            QuadCurve qv2 = new QuadCurve(x+20, y,x+15,y+50,x+25,y+48);
            qv2.setFill(Color.TRANSPARENT);
            qv2.setStroke(Color.BLACK);
            qv2.setStrokeWidth(grosor);

            QuadCurve qv2_5 = new QuadCurve(x+25, y+48,x+25,y+25,x+38, y);
            qv2_5.setFill(Color.TRANSPARENT);
            qv2_5.setStroke(Color.BLACK);
            qv2_5.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+40, y, x+35, y+85, x+50, y+55, x+60, y+15); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
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
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+10,x+20, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(Color.BLACK);
            qv1_5.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+21, y, x+15, y+85, x+30, y+55, x+40, y+15); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv1_5);
            root.getChildren().add(cb1);

            x = x+40;
        }
        if(letra =='ñ'){

            QuadCurve qv1 = new QuadCurve(x, y,x-1,y+50,x+8,y+50);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            QuadCurve qv1_5 = new QuadCurve(x+8, y+50,x+5,y+10,x+20, y);
            qv1_5.setFill(Color.TRANSPARENT);
            qv1_5.setStroke(Color.BLACK);
            qv1_5.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+21, y, x+15, y+85, x+30, y+55, x+40, y+15); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+5, y-15, x+10, y-25, x+15, y-5, x+20, y-15);
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
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
            cd1.setStroke(Color.BLACK);
            cd1.setStrokeWidth(grosor);

            QuadCurve qv1 = new QuadCurve(x+10, y+5,x+30,y+40,x+60,y+15);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            root.getChildren().add(cd1);
            root.getChildren().add(qv1);

            x = x + 60;
        }
        if(letra =='p'){

            QuadCurve qv1 = new QuadCurve(x, y,x-2,y+15,x,y+85);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+1, y+15, x+40, y-15, x+35, y+50, x+25, y+50); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+25, y+50, x, y+38, x+40, y+38, x+55, y+15); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x + 55;

        }
        if(letra =='q'){

            QuadCurve qv1 = new QuadCurve(x+30, y,x+28,y+28, x+30,y+85);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+28, y+12, x-12, y-10, x-13, y+60, x+28, y+40); //Curva principal
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            QuadCurve qv2 = new QuadCurve(x+30, y+47,x+50,y+47,x+60,y+15);
            qv2.setFill(Color.TRANSPARENT);
            qv2.setStroke(Color.BLACK);
            qv2.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+30, y+85, x+40, y+80, x+40, y+50, x+30, y+47); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            root.getChildren().add(qv1);
            root.getChildren().add(qv2);
            root.getChildren().add(cb1);
            root.getChildren().add(cb2);

            x = x + 60;

        }
        if(letra =='r'){
            //CurvA
            CubicCurve a = new CubicCurve(x+9-10,y+10,x+10-10,y-21,x-22-10,y+40,x+30,y);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurvaB
            CubicCurve b = new CubicCurve(x+30,y,x+9,y+28,x+25,y+95,x+55,y+15);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);

            //EspacioDeLetraR
            x = x+55;
        }
        if(letra =='s'){
            //CurvaA
            CubicCurve a = new CubicCurve(x+20,y+35,x-40,y-15,x+40,y-15,x,y+10+5);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurbaB
            CubicCurve b = new CubicCurve(x+20,y+35,x+45,y+60,x-10,y+60,x+22,y+40);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //CurbaC
            QuadCurve c = new QuadCurve(x+22,y+40,x+35,y+30,x+40,y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);


            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);

            //EspacioLetra s
            x=x+40;
        }
        if(letra =='t'){
            //CurvaA
            CubicCurve a = new CubicCurve(x+10,y-50,x-20,y,x+15,y+100,x+30,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurvaB
            CubicCurve b = new CubicCurve(x-10,y-25,x-5,y-30,x+10,y-20,x+15,y-25);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);

            //EspacioLetraT
            x=x+30;
        }
        if(letra =='u'){
            //CurvaA
            CubicCurve a = new CubicCurve(x+10-6,y,x-10+10-6,y+30,x+15-6,y+80,x+30-6,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurvaB
            CubicCurve b = new CubicCurve(x+34-6,y,x+24-6,y+30,x+39-6,y+100,x+54-6,y+15);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //roots
            root.getChildren().add(a);
            root.getChildren().add(b);

            //largo de letra i
            x=x+50;
        }
        if(letra =='v'){
            //curvaA
            QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaC
            QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //curvaD
            QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //curvaE
            QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+30);
            e.setFill(Color.TRANSPARENT);
            e.setStroke(Color.BLACK);
            e.setStrokeWidth(grosor);

            //lineaA
            Line al = new Line(x+105,y+30,x+160,y+30);
            al.setFill(Color.TRANSPARENT);
            al.setStroke(Color.BLACK);
            al.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);
            root.getChildren().add(d);
            root.getChildren().add(e);
            root.getChildren().add(al);

            //espacioLetra v
            x=x+100;
        }
        if(letra =='w'){
            //curvaA
            QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaC
            QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //curvaD
            QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //curvaE
            QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+40);
            e.setFill(Color.TRANSPARENT);
            e.setStroke(Color.BLACK);
            e.setStrokeWidth(2);

            //curvaF
            QuadCurve f = new QuadCurve(x+105,y+40, x+105, y+110,x+125,y+110);
            f.setFill(Color.TRANSPARENT);
            f.setStroke(Color.BLACK);
            f.setStrokeWidth(grosor);

            //curvaG
            QuadCurve g = new QuadCurve(x+125,y+110, x+145, y+110,x+145,y+30);
            g.setFill(Color.TRANSPARENT);
            g.setStroke(Color.BLACK);
            g.setStrokeWidth(grosor);

            //lineaA
            Line al = new Line(x+145,y+30,x+210,y+30);
            al.setFill(Color.TRANSPARENT);
            al.setStroke(Color.BLACK);
            al.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);
            root.getChildren().add(d);
            root.getChildren().add(e);
            root.getChildren().add(f);
            root.getChildren().add(g);
            root.getChildren().add(al);

            //espacioLetra v
            x=x+150;
        }
        if(letra =='x'){
            //curva a
            QuadCurve a = new QuadCurve(x+100,y+40, x+40, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curva b
            QuadCurve b = new QuadCurve(x+20,y+40, x+100, y+110,x+125,y+110);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //roots
            root.getChildren().add(a);
            root.getChildren().add(b);

            //tamaÃ±oLetra x
            x=x+125;
        }
        if(letra =='y'){
            //curvaA
            QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaC
            QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //curvaD
            QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //curvaE
            QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+30);
            e.setFill(Color.TRANSPARENT);
            e.setStroke(Color.BLACK);
            e.setStrokeWidth(grosor);

            //curvaF
            QuadCurve f = new QuadCurve(x+105,y+200,x+100,y+220,x+80,y+210);
            f.setFill(Color.TRANSPARENT);
            f.setStroke(Color.BLACK);
            f.setStrokeWidth(grosor);

            //curvaG
            QuadCurve g = new QuadCurve(x+80,y+210,x+50,y+175,x+100,y+130);
            g.setFill(Color.TRANSPARENT);
            g.setStroke(Color.BLACK);
            g.setStrokeWidth(grosor);

            //curvaH
            QuadCurve h = new QuadCurve(x+100,y+130,x+120,y+110,x+130,y+110);
            h.setFill(Color.TRANSPARENT);
            h.setStroke(Color.BLACK);
            h.setStrokeWidth(grosor);


            //lineaA
            Line al = new Line(x+105,y+30,x+105,y+200);
            al.setFill(Color.TRANSPARENT);
            al.setStroke(Color.BLACK);
            al.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);
            root.getChildren().add(d);
            root.getChildren().add(e);
            root.getChildren().add(f);
            root.getChildren().add(g);
            root.getChildren().add(h);
            root.getChildren().add(al);

            //espacioLetra v
            x=x+130;
        }
        if(letra =='z'){
            //curvaA
            QuadCurve a = new QuadCurve(x+20,y+30, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            QuadCurve b = new QuadCurve(x+55,y+105, x+160, y+210,x+55,y+220);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaC
            QuadCurve c = new QuadCurve(x+55,y+220, x+15, y+210,x+100,y+130);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //curvaD
            QuadCurve d = new QuadCurve(x+100,y+130, x+120, y+110,x+130,y+110);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //curvaE
            QuadCurve e = new QuadCurve(x+20,y+30,x+100,y+25,x+95,y+50);
            e.setFill(Color.TRANSPARENT);
            e.setStroke(Color.BLACK);
            e.setStrokeWidth(grosor);

            //curvaF
            QuadCurve f = new QuadCurve(x+95,y+50,x+95,y+60,x+55,y+105);
            f.setFill(Color.TRANSPARENT);
            f.setStroke(Color.BLACK);
            f.setStrokeWidth(grosor);


            //roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);
            root.getChildren().add(d);
            root.getChildren().add(e);
            root.getChildren().add(f);

            //largo de z
            x=x+130;
        }
    }
}