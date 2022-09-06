package codigo.proyecto;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

public class Dibujo {

    int x = 50;
    int y = 250;


    void LetraA(int det, AnchorPane root) {
        Circle cd1 = new Circle(x+60, y+70, 40);
        cd1.setFill(Color.TRANSPARENT);
        cd1.setStroke(Color.BLACK);
        cd1.setStrokeWidth(2);

        if(det == 0){
            QuadCurve af = new QuadCurve(x+20,y+70, x+25, y+110,x,y+110);
            af.setFill(Color.TRANSPARENT);
            af.setStroke(Color.BLACK);
            af.setStrokeWidth(2);
            root.getChildren().add(af);
        }
        QuadCurve b = new QuadCurve(x+100,y+70, x+95, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(cd1);
        root.getChildren().add(b);

        x = x+120;
    }

    void LetraB(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);


        Line l = new Line(x+20, y+78, x+20, y);
        l.setFill(Color.TRANSPARENT);
        l.setStroke(Color.BLACK);
        l.setStrokeWidth(2);

        Circle c1 = new Circle(x+60, y+70, 40);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(l);
        root.getChildren().add(c1);
        root.getChildren().add(af);
        root.getChildren().add(b);

        x = x+120;
    }

    void LetraC(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);


        CubicCurve c = new CubicCurve(x+80, y+40, x, y, x, y+150, x+90, y+100);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+90,y+100, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(c);
        root.getChildren().add(af);
        root.getChildren().add(b);

        x = x+120;
    }

    void LetraD(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);

        Circle c = new Circle(x+60, y+70, 40);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        Line l = new Line(x+100, y+78, x+100, y);
        l.setFill(Color.TRANSPARENT);
        l.setStroke(Color.BLACK);
        l.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(c);
        root.getChildren().add(l);
        root.getChildren().add(af);
        root.getChildren().add(b);
        x = x+120;

    }

    void LetraE(int det,AnchorPane root){
        if(det == 0){
            CubicCurve c1 = new CubicCurve(x, y+110, x+130, y+70, x+50, y-20,x+50, y+50);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(2);

            QuadCurve qv1 = new QuadCurve(x+50, y+50, x+60, y+110,x+120, y+110);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(2);

            root.getChildren().add(c1);
            root.getChildren().add(qv1);
        }
        else{
            CubicCurve c1 = new CubicCurve(x+60, y+30, x+160, y+5, x-20, y-30,x+70, y+80);
            c1.setFill(Color.TRANSPARENT);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(2);

            QuadCurve qv1 = new QuadCurve(x+70, y+80, x+95, y+110,x+120, y+110);
            qv1.setFill(Color.TRANSPARENT);
            qv1.setStroke(Color.BLACK);
            qv1.setStrokeWidth(2);

            root.getChildren().add(c1);
            root.getChildren().add(qv1);
        }


        x = x+120;
    }

    void LetraF(AnchorPane root){


        CubicCurve c1 = new CubicCurve(x+30, y+210, x+10, y-70, x+180, y+60, x, y+110);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2);

        QuadCurve c2 = new QuadCurve(x+30, y+210, x-50, y+120, x+120, y+110);
        c2.setFill(Color.TRANSPARENT);
        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(2);


        root.getChildren().add(c1);
        root.getChildren().add(c2);

        x = x+120;



    }

    void LetraG(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);

        Circle c = new Circle(x+60, y+70, 40);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        CubicCurve cu = new CubicCurve(x+120, y+110, x-50, y+170 ,x+100, y+330,x+100, y+60);
        cu.setFill(Color.TRANSPARENT);
        cu.setStroke(Color.BLACK);
        cu.setStrokeWidth(2);

        root.getChildren().add(c);
        root.getChildren().add(cu);
        root.getChildren().add(af);

        x = x+120;

    }

    void LetraH(AnchorPane root){

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


        x = x+120;

    }

    void LetraI(int det,AnchorPane root){
        if(det == 0){
            //curvaA
            QuadCurve a = new QuadCurve(x+20,y+30, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(2);
            root.getChildren().add(a);
            x=x-40;
        }
        x=x+40;
        Circle cd1 = new Circle(x+20, y+15, 2);
        cd1.setFill(Color.BLACK);
        cd1.setStroke(Color.BLACK);
        cd1.setStrokeWidth(2);
        root.getChildren().add(cd1);


        //CurvaB
        QuadCurve b = new QuadCurve(x+70-50,y+30, x+65-50, y+110,x+90-50,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //roots
        root.getChildren().add(b);

        //largo de letra i
        x=x+40;



    }

    void LetraJ(AnchorPane root){

        QuadCurve ci = new QuadCurve(x, y+110, x+70, y+100, x+70, y+30);
        ci.setFill(Color.TRANSPARENT);
        ci.setStroke(Color.BLACK);
        ci.setStrokeWidth(2);

        CubicCurve cf = new CubicCurve(x+120, y+110, x-80, y+170 ,x+130, y+350,x+70, y+30);
        cf.setFill(Color.TRANSPARENT);
        cf.setStroke(Color.BLACK);
        cf.setStrokeWidth(2);

        Circle cd1 = new Circle(x+70, y+15, 2);

        root.getChildren().add(ci);
        root.getChildren().add(cf);
        root.getChildren().add(cd1);

        x = x+120;

    }

    void LetraK(AnchorPane root){

        CubicCurve cb1 = new CubicCurve(x, y+110, x+120, y+55-55, x+50, y-40, x+50, y+110);
        cb1.setFill(Color.TRANSPARENT);
        cb1.setStroke(Color.BLACK);
        cb1.setStrokeWidth(2);

        QuadCurve q1 = new QuadCurve(x+53, y+80, x+80, y+70, x+53, y+90);
        q1.setFill(Color.TRANSPARENT);
        q1.setStroke(Color.BLACK);
        q1.setStrokeWidth(2);

        CubicCurve cb2 = new CubicCurve(x+53, y+90, x+100, y+90, x+50, y+110, x+120, y+110);
        cb2.setFill(Color.TRANSPARENT);
        cb2.setStroke(Color.BLACK);
        cb2.setStrokeWidth(2);


        root.getChildren().add(cb1);
        root.getChildren().add(cb2);
        root.getChildren().add(q1);

        x = x+120;
    }

    void LetraL(AnchorPane root){

        CubicCurve c1 = new CubicCurve(x, y+110, x+130, y+70, x+50, y-20,x+50, y);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2);

        QuadCurve qv1 = new QuadCurve(x+50, y, x+60, y+110,x+120, y+110);
        qv1.setFill(Color.TRANSPARENT);
        qv1.setStroke(Color.BLACK);
        qv1.setStrokeWidth(2);


        root.getChildren().add(c1);
        root.getChildren().add(qv1);

        x = x+120;
    }

    void LetraM(AnchorPane root){

        CubicCurve cb1 = new CubicCurve(x, y+110, x+20, y+110, x+25, y-50,x+30, y+110);
        cb1.setFill(Color.TRANSPARENT);
        cb1.setStroke(Color.BLACK);
        cb1.setStrokeWidth(2);

        QuadCurve qv1 = new QuadCurve(x+28, y+50, x+60, y+10,x+60, y+110);
        qv1.setFill(Color.TRANSPARENT);
        qv1.setStroke(Color.BLACK);
        qv1.setStrokeWidth(2);

        CubicCurve cb2 = new CubicCurve(x+55, y+50, x+100, y+10, x+70, y+120,x+120, y+110);
        cb2.setFill(Color.TRANSPARENT);
        cb2.setStroke(Color.BLACK);
        cb2.setStrokeWidth(2);

        root.getChildren().add(cb1);
        root.getChildren().add(cb2);
        root.getChildren().add(qv1);

        x = x+120;
    }

    void LetraN(AnchorPane root){

        QuadCurve cn1 = new QuadCurve(x+20,y+50, x+20, y+110, x,y+110);
        cn1.setFill(Color.TRANSPARENT);
        cn1.setStroke(Color.BLACK);
        cn1.setStrokeWidth(2);

        QuadCurve c1 = new QuadCurve(x+20, y+50, x+30, y+10, x+40, y+110);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2);

        CubicCurve cb = new CubicCurve(x+40, y+110, x+80, y-60, x+80, y+120 , x+120, y+110);
        cb.setFill(Color.TRANSPARENT);
        cb.setStroke(Color.BLACK);
        cb.setStrokeWidth(2);

        root.getChildren().add(cn1);
        root.getChildren().add(c1);
        root.getChildren().add(cb);

        x = x+120;
    }

    void LetraN_(AnchorPane root){

        QuadCurve cn1 = new QuadCurve(x+20,y+50, x+20, y+110, x,y+110);
        cn1.setFill(Color.TRANSPARENT);
        cn1.setStroke(Color.BLACK);
        cn1.setStrokeWidth(2);

        QuadCurve c1 = new QuadCurve(x+20, y+50, x+30, y+10, x+40, y+110);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(2);

        CubicCurve ft = new CubicCurve(x+30, y+20, x+50, y, x+60, y+40, x+80, y+20);
        ft.setFill(Color.TRANSPARENT);
        ft.setStroke(Color.BLACK);
        ft.setStrokeWidth(2);

        CubicCurve cb = new CubicCurve(x+40, y+110, x+80, y-60, x+80, y+120 , x+120, y+110);
        cb.setFill(Color.TRANSPARENT);
        cb.setStroke(Color.BLACK);
        cb.setStrokeWidth(2);

        root.getChildren().add(cn1);
        root.getChildren().add(c1);
        root.getChildren().add(cb);
        root.getChildren().add(ft);

        x = x+120;
    }

    void LetraO(int det,AnchorPane root){
        Circle cd1 = new Circle(x+60, y+70, 40);
        cd1.setFill(Color.TRANSPARENT);
        cd1.setStroke(Color.BLACK);
        cd1.setStrokeWidth(2);

        if(det == 0){
            QuadCurve af = new QuadCurve(x+20,y+70, x+25, y+110,x,y+110);
            af.setFill(Color.TRANSPARENT);
            af.setStroke(Color.BLACK);
            af.setStrokeWidth(2);
            root.getChildren().add(af);
        }

        QuadCurve c = new QuadCurve(x+25,y+50,x+30,y+70,x+145,y+30);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        root.getChildren().add(cd1);
        root.getChildren().add(c);

        x = x+85;
    }

    void LetraP(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+82, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);

        Circle cd1 = new Circle(x+60, y+70, 40);
        cd1.setFill(Color.TRANSPARENT);
        cd1.setStroke(Color.BLACK);
        cd1.setStrokeWidth(2);

        Line l1 = new Line(x+20, y+60, x+20, y+160);
        l1.setFill(Color.TRANSPARENT);
        l1.setStroke(Color.BLACK);
        l1.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(af);
        root.getChildren().add(cd1);
        root.getChildren().add(l1);
        root.getChildren().add(b);

        x = x+120;
    }

    void LetraQ(AnchorPane root){

        QuadCurve af = new QuadCurve(x+20,y+78, x+20, y+110, x,y+110);
        af.setFill(Color.TRANSPARENT);
        af.setStroke(Color.BLACK);
        af.setStrokeWidth(2);

        Circle cd1 = new Circle(x+60, y+70, 40);
        cd1.setFill(Color.TRANSPARENT);
        cd1.setStroke(Color.BLACK);
        cd1.setStrokeWidth(2);

        Line l1 = new Line(x+100, y+60, x+100, y+160);
        l1.setFill(Color.TRANSPARENT);
        l1.setStroke(Color.BLACK);
        l1.setStrokeWidth(2);

        QuadCurve b = new QuadCurve(x+100,y+78, x+100, y+110,x+120,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        root.getChildren().add(af);
        root.getChildren().add(cd1);
        root.getChildren().add(l1);
        root.getChildren().add(b);

        x = x+120;
    }

    void LetraR(AnchorPane root){
        //CurvaA
        QuadCurve a = new QuadCurve(x+20,y+35, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //CurvaB
        QuadCurve b = new QuadCurve(x+20,y+35,x+40,y+45,x+70,y+35);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //CurvaC
        QuadCurve c = new QuadCurve(x+70,y+35, x+65, y+110,x+90,y+110);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //Roots
        root.getChildren().add(a);
        root.getChildren().add(b);
        root.getChildren().add(c);

        //EspacioDeLetraR
        x = x+90;


    }

    void LetraS(AnchorPane root){

        //CurvaA
        QuadCurve a = new QuadCurve(x+20,y+35, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //CurbaB
        QuadCurve b = new QuadCurve(x+20,y+35,x+35,y+60,x+60,y+60);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //CurbaD
        QuadCurve c = new QuadCurve(x+60,y+60,x+95,y+60,x+95,y+90);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //CurbaE
        QuadCurve e = new QuadCurve(x+60,y+110,x+95,y+110,x+95,y+90);
        e.setFill(Color.TRANSPARENT);
        e.setStroke(Color.BLACK);
        e.setStrokeWidth(2);

        //CurbaF
        QuadCurve f = new QuadCurve(x+85,y+106, x+95, y+110,x+105,y+110);
        f.setFill(Color.TRANSPARENT);
        f.setStroke(Color.BLACK);
        f.setStrokeWidth(2);

        //Roots
        root.getChildren().add(a);
        root.getChildren().add(b);
        root.getChildren().add(c);
        root.getChildren().add(e);
        root.getChildren().add(f);

        //EspacioLetra s
        x=x+105;


    }

    void LetraT(AnchorPane root){

        //CurvaA
        QuadCurve a = new QuadCurve(x+30,y, x+30, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //CurvaB
        QuadCurve b = new QuadCurve(x+30,y, x+30, y+110,x+60,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //lineaA
        Line al = new Line(x+5,y+20,x+55,y+20);
        al.setFill(Color.TRANSPARENT);
        al.setStroke(Color.BLACK);
        al.setStrokeWidth(2);

        //Roots
        root.getChildren().add(a);
        root.getChildren().add(b);
        root.getChildren().add(al);

        //EspacioLetraT
        x=x+60;


    }

    void LetraU(int det,AnchorPane root){
        if(det == 0){
            //curvaA
            QuadCurve a = new QuadCurve(x+20,y+30, x+25, y+110,x,y+110);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(Color.BLACK);
            a.setStrokeWidth(2);
            root.getChildren().add(a);
            x=x-40;
        }
        x=x+40;
        //CurvaB
        QuadCurve b = new QuadCurve(x+20,y+30, x+15, y+95,x+40-5,y+110-5);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //CurvaC
        QuadCurve c = new QuadCurve(x+80,y+30, x+85, y+95,x+60+5,y+110-5);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //CurvaD
        QuadCurve d = new QuadCurve(x+80,y+30, x+75, y+110,x+110,y+110);
        d.setFill(Color.TRANSPARENT);
        d.setStroke(Color.BLACK);
        d.setStrokeWidth(2);

        //LineaA
        QuadCurve al = new QuadCurve(x+40-5,y+110-5,x+50,y+115,x+60+5,y+110-5);
        al.setFill(Color.TRANSPARENT);
        al.setStroke(Color.BLACK);
        al.setStrokeWidth(2);

        //roots
        root.getChildren().add(b);
        root.getChildren().add(al);
        root.getChildren().add(c);
        root.getChildren().add(d);

        //largo de letra i
        x=x+110;
    }

    void LetraV(AnchorPane root){

        //curvaA
        QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //curvaB
        QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //curvaC
        QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //curvaD
        QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
        d.setFill(Color.TRANSPARENT);
        d.setStroke(Color.BLACK);
        d.setStrokeWidth(2);

        //curvaE
        QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+30);
        e.setFill(Color.TRANSPARENT);
        e.setStroke(Color.BLACK);
        e.setStrokeWidth(2);

        //lineaA
        Line al = new Line(x+105,y+30,x+160,y+30);
        al.setFill(Color.TRANSPARENT);
        al.setStroke(Color.BLACK);
        al.setStrokeWidth(2);

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

    void LetraW(AnchorPane root){
        //curvaA
        QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //curvaB
        QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //curvaC
        QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //curvaD
        QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
        d.setFill(Color.TRANSPARENT);
        d.setStroke(Color.BLACK);
        d.setStrokeWidth(2);

        //curvaE
        QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+40);
        e.setFill(Color.TRANSPARENT);
        e.setStroke(Color.BLACK);
        e.setStrokeWidth(2);

        //curvaF
        QuadCurve f = new QuadCurve(x+105,y+40, x+105, y+110,x+125,y+110);
        f.setFill(Color.TRANSPARENT);
        f.setStroke(Color.BLACK);
        f.setStrokeWidth(2);

        //curvaG
        QuadCurve g = new QuadCurve(x+125,y+110, x+145, y+110,x+145,y+30);
        g.setFill(Color.TRANSPARENT);
        g.setStroke(Color.BLACK);
        g.setStrokeWidth(2);

        //lineaA
        Line al = new Line(x+145,y+30,x+210,y+30);
        al.setFill(Color.TRANSPARENT);
        al.setStroke(Color.BLACK);
        al.setStrokeWidth(2);

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

    void LetraX(AnchorPane root){
        //curva a
        QuadCurve a = new QuadCurve(x+100,y+40, x+40, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //curva b
        QuadCurve b = new QuadCurve(x+20,y+40, x+100, y+110,x+125,y+110);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //roots
        root.getChildren().add(a);
        root.getChildren().add(b);

        //tamañoLetra x
        x=x+125;
    }

    void LetraY(AnchorPane root){
        //curvaA
        QuadCurve a = new QuadCurve(x+25,y+50, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //curvaB
        QuadCurve b = new QuadCurve(x+25,y+50,x+27,y+30,x+45,y+30);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //curvaC
        QuadCurve c = new QuadCurve(x+45,y+30,x+58,y+30,x+60,y+50);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //curvaD
        QuadCurve d = new QuadCurve(x+60,y+50, x+60, y+110,x+85,y+110);
        d.setFill(Color.TRANSPARENT);
        d.setStroke(Color.BLACK);
        d.setStrokeWidth(2);

        //curvaE
        QuadCurve e = new QuadCurve(x+85,y+110, x+105, y+110,x+105,y+30);
        e.setFill(Color.TRANSPARENT);
        e.setStroke(Color.BLACK);
        e.setStrokeWidth(2);

        //curvaF
        QuadCurve f = new QuadCurve(x+105,y+200,x+100,y+220,x+80,y+210);
        f.setFill(Color.TRANSPARENT);
        f.setStroke(Color.BLACK);
        f.setStrokeWidth(2);

        //curvaG
        QuadCurve g = new QuadCurve(x+80,y+210,x+50,y+175,x+100,y+130);
        g.setFill(Color.TRANSPARENT);
        g.setStroke(Color.BLACK);
        g.setStrokeWidth(2);

        //curvaH
        QuadCurve h = new QuadCurve(x+100,y+130,x+120,y+110,x+130,y+110);
        h.setFill(Color.TRANSPARENT);
        h.setStroke(Color.BLACK);
        h.setStrokeWidth(2);


        //lineaA
        Line al = new Line(x+105,y+30,x+105,y+200);
        al.setFill(Color.TRANSPARENT);
        al.setStroke(Color.BLACK);
        al.setStrokeWidth(2);

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

    void LetraZ(AnchorPane root){
        //curvaA
        QuadCurve a = new QuadCurve(x+20,y+30, x+25, y+110,x,y+110);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(2);

        //curvaB
        QuadCurve b = new QuadCurve(x+55,y+105, x+160, y+210,x+55,y+220);
        b.setFill(Color.TRANSPARENT);
        b.setStroke(Color.BLACK);
        b.setStrokeWidth(2);

        //curvaC
        QuadCurve c = new QuadCurve(x+55,y+220, x+15, y+210,x+100,y+130);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        //curvaD
        QuadCurve d = new QuadCurve(x+100,y+130, x+120, y+110,x+130,y+110);
        d.setFill(Color.TRANSPARENT);
        d.setStroke(Color.BLACK);
        d.setStrokeWidth(2);

        //curvaE
        QuadCurve e = new QuadCurve(x+20,y+30,x+100,y+25,x+95,y+50);
        e.setFill(Color.TRANSPARENT);
        e.setStroke(Color.BLACK);
        e.setStrokeWidth(2);

        //curvaF
        QuadCurve f = new QuadCurve(x+95,y+50,x+95,y+60,x+55,y+105);
        f.setFill(Color.TRANSPARENT);
        f.setStroke(Color.BLACK);
        f.setStrokeWidth(2);


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
