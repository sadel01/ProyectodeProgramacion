
package com.example.codigo;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class Principal {

    public static void main(String[] args) {
        String palabra;
        palabra="a;o;,;.";
        //palabra=JOptionPane.showInputDialog("PALABRA");
        Ventana v = new Ventana();
        v.add(new Vocales(palabra));
        v.setVisible(true);
    }
}
