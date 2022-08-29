
package com.example.codigo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import javax.swing.JPanel;


public class Vocales extends JPanel {
    
    String palabra;

    public Vocales(String palabra) {
        this.palabra = palabra;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        int x=50,y=250, aux=0;
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        //palabra en A mayuscula
        for(int i = 0 ;i<palabra.length() ;i++ ){
            //ESPACIO
            if(palabra.charAt(i)==' '){
                x=x+80;
            }
            else{
                // A MINUSCULA
                if(palabra.charAt(i)=='a'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.drawOval(x+30, y, 100, 100);
                    g2.draw(new QuadCurve2D.Double(x+30,y+50, x+40, y+100,x,y+100));
                    g2.draw(new QuadCurve2D.Double(x+130,y+50, x+120, y+100,x+160,y+100));
                    x=x+155;
                }
                // O MINUSCULA
                if(palabra.charAt(i)=='o'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.drawOval(x+30, y, 100, 100);
                    g2.draw(new QuadCurve2D.Double(x+30,y+50, x+40, y+100,x,y+100));
                    g2.draw(new QuadCurve2D.Double(x+130,y+50, x+120, y+100,x+160,y+100));
                    g2.draw(new QuadCurve2D.Double(x+38,y+25, x+90, y+85,x+150,y));
                    x=x+155;
                }

                //u minuscule
                if(palabra.charAt(i) == 'u'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.draw(new QuadCurve2D.Double(x+5, y+100, x+40, y+100, x+40, y)); //Inicio primera curva
                    g2.draw(new QuadCurve2D.Double(x+40, y, x+40, y+100, x+70, y+100)); //Final primera curva

                    g2.draw(new QuadCurve2D.Double(x+70, y+100, x+105, y+100, x+105, y)); //Inicio segunda curva
                    g2.draw(new QuadCurve2D.Double(x+105, y, x+105, y+100, x+135, y+100)); //Finañ segunda curva
                    x = x + 138;
                }

                // PUNTO
                if(palabra.charAt(i)=='.'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.fillOval(x+30, y+95, 8, 8);
                    x=x+70;
                }
                // COMA
                if(palabra.charAt(i)==','){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.fillOval(x+30, y+95, 8, 8);
                    g2.draw(new QuadCurve2D.Double(x+35, y+100, x+38, y+104,x+30, y+108));
                    x=x+70;
                }

                //Comillas españolas mayor que
                if (palabra.charAt(i) == '>'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.draw(new Line2D.Double(x+30, y+10, x+80, y+50)); //Primera linea (1)
                    g2.draw(new Line2D.Double(x+80, y+50, x+30, y+90)); //Segunda Linea (1)

                    g2.draw(new Line2D.Double(x+60, y+10, x+110, y+50)); //Primera linea (2)
                    g2.draw(new Line2D.Double(x+110, y+50, x+60, y+90)); //Segunda linea (2)
                    x = x + 120;
                }

                //Comillas españolas menor que
                if (palabra.charAt(i) == '<'){
                    x=x+40;
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.draw(new Line2D.Double(x+30, y+10, x-20, y+50)); //Primera linea (1)
                    g2.draw(new Line2D.Double(x-20, y+50, x+30, y+90)); //Segunda Linea (1)

                    g2.draw(new Line2D.Double(x+60, y+10, x+10, y+50)); //Primera linea (2)
                    g2.draw(new Line2D.Double(x+10, y+50, x+60, y+90)); //Segunda Linea (2)
                    x = x + 80;
                }

                //Cierra parenthesis
                if (palabra.charAt(i) == ')'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.draw(new QuadCurve2D.Double(x+20, y, x+50, y+50, x+20 ,y+100));
                    x = x + 45;
                }

                //Abre parenthesis
                if (palabra.charAt(i) == '('){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);
                    g2.draw(new QuadCurve2D.Double(x+20, y, x-10, y+50, x+20 ,y+100));
                    x = x + 20;
                }

                // PUNTO Y COMA
                if(palabra.charAt(i)==';'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    //punto
                    g2.setStroke(grosor);
                    g2.fillOval(x+30, y+50, 8, 8);
                    //coma
                    g2.fillOval(x+30, y+95, 8, 8);
                    g2.draw(new QuadCurve2D.Double(x+35, y+100, x+38, y+104,x+30, y+108));
                    x=x+70;
                }

                //COMILLAS 
                if (palabra.charAt(i) == '"'){

                    if (aux == 0) {
                        //primera comilla
                        Graphics2D g2 = (Graphics2D) g;
                        BasicStroke grosor = new BasicStroke(3);
                        g2.setStroke(grosor);

                        g2.fillOval(x, y-3, 8, 8);
                        g2.draw(new QuadCurve2D.Double(x+1, y, x, y-12,x+7, y-11));

                        g2.fillOval(x-10, y-3, 8, 8);
                        g2.draw(new QuadCurve2D.Double(x-9, y, x-10, y-12,x-3, y-11));
                        x=x+70;
                        aux = 1;
                    }
                    else {
                        //segunda comilla
                        Graphics2D g2 = (Graphics2D) g;
                        BasicStroke grosor = new BasicStroke(3);
                        g2.setStroke(grosor);

                        g2.fillOval(x+20, y-10, 8, 8);
                        g2.draw(new QuadCurve2D.Double(x+24, y-8, x+28, y+4,x+20, y+3));

                        g2.fillOval(x+30, y-10, 8, 8);
                        g2.draw(new QuadCurve2D.Double(x+34, y-8, x+38, y+4,x+30, y+3));
                        x=x+70;
                        aux = 0;
                    }
                }
                if(palabra.charAt(i)==':'){
                    Graphics2D g2=(Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    //punto
                    g2.setStroke(grosor);
                    g2.fillOval(x+30, y+50, 8, 8);
                    //punto bajo
                    g2.fillOval(x+30, y+95, 8, 8);
                    x=x+70;
                } 
            }

            //Comillas simples
            if (palabra.charAt(i) == '\'' ){

                if (aux == 0) {
                    Graphics2D g2 = (Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);

                    g2.fillOval(x, y-3, 8, 8);
                    g2.draw(new QuadCurve2D.Double(x+1, y, x, y-12,x+7, y-11));
                    x = x + 20;
                    aux = 1;
                }
                else {
                    Graphics2D g2 = (Graphics2D) g;
                    BasicStroke grosor = new BasicStroke(3);
                    g2.setStroke(grosor);

                    g2.fillOval(x+20, y-10, 8, 8);
                    g2.draw(new QuadCurve2D.Double(x+24, y-8, x+28, y+4,x+20, y+3));
                    x = x + 20;
                    aux = 0;
                }
            }
        }
    }            
}            
             
                
            
        
   

