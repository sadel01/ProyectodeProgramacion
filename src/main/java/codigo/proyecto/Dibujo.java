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
            Circle cd1 = new Circle(x+60, y+70, 40);
            cd1.setFill(Color.TRANSPARENT);
            cd1.setStroke(Color.BLACK);
            cd1.setStrokeWidth(grosor);

            if(det == 0){
                QuadCurve af = new QuadCurve(x+20,y+70, x+25, y+110,x,y+110);
                af.setFill(Color.TRANSPARENT);
                af.setStroke(Color.BLACK);
                af.setStrokeWidth(grosor);
                root.getChildren().add(af);
            }
            QuadCurve b = new QuadCurve(x+100,y+70, x+95, y+110,x+120,y+110);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            root.getChildren().add(cd1);
            root.getChildren().add(b);

            x = x+120;
        }
        if(letra == 'b'){
            QuadCurve af = new QuadCurve(x + 20, y + 78, x + 20, y + 110, x, y + 110);
            af.setFill(Color.TRANSPARENT);
            af.setStroke(Color.BLACK);
            af.setStrokeWidth(grosor);


            Line l = new Line(x + 20, y + 78, x + 20, y);
            l.setFill(Color.TRANSPARENT);
            l.setStroke(Color.BLACK);
            l.setStrokeWidth(grosor);

            Circle c1 = new Circle(x + 60, y + 70, 40);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(grosor);

            QuadCurve b = new QuadCurve(x + 100, y + 78, x + 100, y + 110, x + 120, y + 110);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            root.getChildren().add(l);
            root.getChildren().add(c1);
            root.getChildren().add(af);
            root.getChildren().add(b);

            x = x + 120;
        }
        if(letra == 'c'){
            if(det == 0){
                QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
                af.setFill(Color.TRANSPARENT);
                af.setStroke(Color.BLACK);
                af.setStrokeWidth(grosor);
                root.getChildren().add(af);
            }
            CubicCurve c = new CubicCurve(x+85, y+32, x-5, y+10+5, x-5, y+120, x+90, y+110);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            root.getChildren().add(c);

            x = x+90;
        }
        if(letra =='d'){
            if(det == 0){
                QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
                af.setFill(Color.TRANSPARENT);
                af.setStroke(Color.BLACK);
                af.setStrokeWidth(grosor);
                root.getChildren().add(af);
            }
            Circle c = new Circle(x+60, y+70, 40);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            Line l = new Line(x+100, y+78, x+100, y-40);
            l.setFill(Color.TRANSPARENT);
            l.setStroke(Color.BLACK);
            l.setStrokeWidth(grosor);

            QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(l);
            root.getChildren().add(b);
            x = x+120;
        }
        if(letra =='e'){
            if(det == 0){
                //curvaA
                QuadCurve a = new QuadCurve(x,y+110,x+60,y+110,x+50,y+50);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(Color.BLACK);
                a.setStrokeWidth(grosor);

                //curvaC
                QuadCurve c = new QuadCurve(x+30,y+50,x+40,y+10,x+50,y+50);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(Color.BLACK);
                c.setStrokeWidth(grosor);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(c);
            }
            else{
                x=x+30;
                //curvaA
                QuadCurve a = new QuadCurve(x+30,y+30,x+50,y+25,x+55,y-5);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(Color.BLACK);
                a.setStrokeWidth(grosor);

                //curvaC
                QuadCurve c = new QuadCurve(x+30,y+50,x+55,y-50,x+55,y-5);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(Color.BLACK);
                c.setStrokeWidth(grosor);

                //roots
                root.getChildren().add(a);
                root.getChildren().add(c);
            }
            QuadCurve b = new QuadCurve(x+80,y+110,x+20,y+110,x+30,y+50);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            root.getChildren().add(b);
            //tamaÃ±o letra
            x = x+80;
        }
        if(letra =='f'){
            CubicCurve c1 = new CubicCurve(x+30, y+210, x+10, y-70, x+180, y+60, x, y+110);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(grosor);

            QuadCurve c2 = new QuadCurve(x+30, y+210, x-50, y+120, x+120, y+110);
            c2.setFill(Color.TRANSPARENT);
            c2.setStroke(Color.BLACK);
            c2.setStrokeWidth(grosor);


            root.getChildren().add(c1);
            root.getChildren().add(c2);

            x = x+120;
        }
        if(letra =='g'){
            if(det == 0){
                QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
                af.setFill(Color.TRANSPARENT);
                af.setStroke(Color.BLACK);
                af.setStrokeWidth(grosor);

                root.getChildren().add(af);
            }

            Circle c = new Circle(x+60, y+70, 40);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            CubicCurve cu = new CubicCurve(x+120, y+110, x-50, y+170 ,x+100, y+330,x+100, y+60);
            cu.setFill(Color.TRANSPARENT);
            cu.setStroke(Color.BLACK);
            cu.setStrokeWidth(grosor);

            root.getChildren().add(c);
            root.getChildren().add(cu);

            x = x+120;
        }
        if(letra =='h'){
                    /*
        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);

        Line l = new Line(x+20, y+78, x+20, y);
        l.setFill(Color.TRANSPARENT);
        l.setStroke(Color.BLACK);
        l.setStrokeWidth(2);
        CubicCurve c = new CubicCurve(x+20, y+50, x+110, y+30, x+70, y+110,x+120, y+110);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(l);
        root.getChildren().add(c);
        root.getChildren().add(af);

         */

            QuadCurve qv1 = new QuadCurve(x, y+110, x+50, y+110, x+50, y+40); //Curva izquierda (conector)
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(grosor);

            CubicCurve cb1 = new CubicCurve(x+40, y+50,x+100, y+20, x+70, y-200, x+50, y+40); //"l" superior
            cb1.setFill(Color.TRANSPARENT);
            cb1.setStroke(Color.BLACK);
            cb1.setStrokeWidth(grosor);

            CubicCurve cb2 = new CubicCurve(x+50, y+45,x+85, y+30, x+95, y+60, x+90, y+80); //Semi ovalo
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            QuadCurve qv2 = new QuadCurve(x+90, y+80, x+90, y+110, x+120, y+110); //Curva izquierda (conector)
            qv2.setFill(Color.TRANSPARENT);
            qv2.setStroke(Color.BLACK);
            qv2.setStrokeWidth(grosor);

            root.getChildren().add(cb1);
            root.getChildren().add(qv1);
            root.getChildren().add(cb2);
            root.getChildren().add(qv2);

            x = x+120;
        }
        if(letra =='i'){
            if(det == 0){
                //curvaA
                QuadCurve a = new QuadCurve(x+20,y+30, x+25, y+110,x,y+110);
                a.setFill(Color.TRANSPARENT);
                a.setStroke(Color.BLACK);
                a.setStrokeWidth(grosor);
                root.getChildren().add(a);
                x=x-40;
            }
            x=x+40;
            Circle cd1 = new Circle(x+20, y+15, 2);
            cd1.setFill(Color.BLACK);
            cd1.setStroke(Color.BLACK);
            cd1.setStrokeWidth(grosor);
            root.getChildren().add(cd1);


            //CurvaB
            QuadCurve b = new QuadCurve(x+70-50,y+30, x+65-50, y+110,x+90-50,y+110);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //roots
            root.getChildren().add(b);

            //largo de letra i
            x=x+40;
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

            CubicCurve cb2 = new CubicCurve(x+25, y+50, x, y+60, x, y+30, x+30, y+35); //Curva principal
            cb2.setFill(Color.TRANSPARENT);
            cb2.setStroke(Color.BLACK);
            cb2.setStrokeWidth(grosor);

            QuadCurve d = new QuadCurve(x+30, y+35,x+40,y+30,x+55,y+15);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
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
            CubicCurve a = new CubicCurve(x+2,y,x-6,y+30,x+9,y+80,x+24,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurvaB
            CubicCurve b = new CubicCurve(x+28,y,x+18,y+30,x+33,y+100,x+48,y+15);
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
            CubicCurve a = new CubicCurve(x-3,y, x+10, y+63,x+25,y+63,x+35,y);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            CubicCurve b = new CubicCurve(x+35,y,x+35,y-20,x+10,y+12,x+30,y+25);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaC
            CubicCurve c = new CubicCurve(x+30,y+25,x+35,y+25,x+45,y+20,x+50,y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);

            //espacioLetra v
            x=x+50;
        }
        if(letra =='w'){
            //CurvaA
            CubicCurve a = new CubicCurve(x+4,y,x-6,y+30,x+9,y+80,x+24,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);
            //curvaA
            CubicCurve b = new CubicCurve(x+24,y+15, x+20, y+73,x+40,y+83,x+50,y);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //curvaB
            CubicCurve c = new CubicCurve(x+50,y,x+50,y-20,x+25,y+12,x+45,y+25);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //curvaC
            CubicCurve d = new CubicCurve(x+45,y+25,x+50,y+25,x+60,y+20,x+65,y+15);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);
            root.getChildren().add(d);

            //espacioLetra v
            x=x+65;
        }
        if(letra =='x'){
            //curva a
            CubicCurve a = new CubicCurve(x-3,y+10,x+45,y+100,x+50,y+50,x+60,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curva b
            QuadCurve b = new QuadCurve(x+5,y+50, x+30, y+10,x+45,y);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //roots
            root.getChildren().add(a);
            root.getChildren().add(b);

            //tamaÃ±oLetra x
            x=x+60;
        }
        if(letra =='y'){
            //curvaA
            CubicCurve a = new CubicCurve(x+2,y,x-6,y+30,x+9,y+80,x+24,y+15);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //CurvaB
            CubicCurve b = new CubicCurve(x+24,y,x+24,y+140,x-40,y+105,x+24,y+50);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            QuadCurve c = new QuadCurve(x+23,y+50, x+35, y+50,x+45,y+15);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //Roots
            root.getChildren().add(a);
            root.getChildren().add(b);
            root.getChildren().add(c);

            //espacioLetra v
            x=x+46;
        }
        if(letra =='z'){
            //CurvA
            CubicCurve a = new CubicCurve(x-1,y+10,x,y-21,x-32,y+40,x+40,y);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(grosor);

            //curvaB
            Line b = new Line(x+40,y,x+7,y+47);
            b.setFill(Color.TRANSPARENT);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(grosor);

            //CurvC
            CubicCurve c = new CubicCurve(x+7,y+47,x+50,y+10,x+45,y+80,x+35,y+90);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(grosor);

            //CurvD
            CubicCurve d = new CubicCurve(x+35,y+90,x+15,y+120,x-15,y+45,x+40,y+50);
            d.setFill(Color.TRANSPARENT);
            d.setStroke(Color.BLACK);
            d.setStrokeWidth(grosor);

            //curvaE
            QuadCurve e = new QuadCurve(x+40,y+50,x+55,y+50,x+60,y+15);
            e.setFill(Color.TRANSPARENT);
            e.setStroke(Color.BLACK);
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
    }
}