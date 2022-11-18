package codigo.proyecto;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.nio.channels.Selector;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controlador extends Dibujo implements Initializable {
    String tamanio = "";
    int numTam = 1;
    int a = 0;
    @FXML
    private AnchorPane root;

    @FXML
    private TextField CuadroTexto;

    @FXML
    private ChoiceBox<String> Colores;

    @FXML
    private Rectangle rectColor;

    @FXML
    private TextFlow textoCoord;

    @FXML
    private ToggleButton puntosDeControl;

    @FXML
    private ToggleButton Traslacion;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    void SeleccionPtoTraslacion(ActionEvent event) {
        Traslacion.setCursor(Cursor.HAND);
        vbox.setCursor(Cursor.HAND);
        vbox.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent ev) {
                traslacion((int) ev.getScreenX(), (int)ev.getScreenY());
                obtenerLetra();
            }
        });

    }


    @FXML
    private void obtenerLetra() {

        textoCoord.setStyle("-fx-font-size: 15px; -fx-padding: 5 0 0 5; -fx-font-weight: bold; -fx-font-family: Arial");
        String frase = "" + CuadroTexto.getText();
        root.getChildren().clear();
        textoCoord.getChildren().clear();
        boolean cursiva = false;

        String estilos = EstilodePalabras(frase);

        for (int i = 0; i < frase.length(); i++) {

            if (frase.contains("^R")) {

                String fraseAux = " ";

                for (int j = 3; j < frase.length(); j++) {
                    fraseAux = fraseAux + frase.charAt(j);
                }

                frase = InvertirOrden(fraseAux);

            }


            if (i >= 3 && String.valueOf(frase.charAt(i)).matches("[0-9]") && frase.charAt(i - 1) == 'T' && frase.charAt(i - 2) == '^') {
                a = 1;
                tamanio = tamanio + frase.charAt(i);
            } else if (a == 1 && String.valueOf(frase.charAt(i)).matches("[0-9]")) {
                tamanio = tamanio + frase.charAt(i);
            } else if (frase.charAt(i) == ' ') {
                a = 0;
                tamanio = "";
                numTam = 1;
                estilos = "";
            }

            if (tamanio.length() != 0) {
                numTam = Integer.parseInt(tamanio);
            }

            if (i == 0) {
                if (String.valueOf(frase.charAt(i)).matches("[a-zA-Z]||[áéíóúÁÉÍÓÚÜüñÑ]")) {
                    Letras(estilos, frase.charAt(i), frase.charAt(i), root, textoCoord, puntosDeControl, 1, scrollPane, numTam);

                } else {
                    Simbolos(estilos, frase.charAt(i), frase.charAt(i), root, textoCoord, puntosDeControl, 1, scrollPane, numTam);
                }

            } else {

                if (frase.charAt(i) == 'K') {
                    if (frase.charAt(i - 1) == '^' || frase.charAt(i - 1) == '+') {
                        cursiva = true;
                    }
                }

                if (frase.charAt(i) == ' ') {
                    cursiva = false;
                }

                if (String.valueOf(frase.charAt(i)).matches("[a-zA-Z]||[áéíóúÁÉÍÓÚÜüñÑ]")) {

                    if (cursiva) {
                        Cursivas(estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, puntosDeControl, 0, scrollPane, numTam);
                    } else {
                        Letras(estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, puntosDeControl, 0, scrollPane, numTam);
                    }
                } else {
                    if (cursiva) {
                        SimbolosCursivas(estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, puntosDeControl, 0, scrollPane, numTam);
                    } else {
                        Simbolos(estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, puntosDeControl, 0, scrollPane, numTam);
                    }
                }

            }

            if (puntosDeControl.isSelected()) {
                BotonAct(puntosDeControl);
            }
        }


        if (frase.length() < 2) {
            puntosDeControl.setDisable(true);
        } else {
            puntosDeControl.setDisable(false);
        }
    }

    private String InvertirOrden(String palabra) {

        String p[] = palabra.split(" ");

        String palabraInvertida = " ";

        for (int i = p.length - 1; i >= 0; i--) {
            palabraInvertida = palabraInvertida + p[i] + " ";
        }

        return palabraInvertida;

    }

    private void ColorRectangulo() {

        if (Colores.getValue().equals("Rojo")) {
            rectColor.setFill(Color.RED);
            rectColor.setStroke(Color.RED);
        } else if (Colores.getValue().equals("Verde")) {
            rectColor.setFill(Color.GREEN);
            rectColor.setStroke(Color.GREEN);
        } else if (Colores.getValue().equals("Azul")) {
            rectColor.setFill(Color.BLUE);
            rectColor.setStroke(Color.BLUE);
        } else if (Colores.getValue().equals("Negro")) {
            rectColor.setFill(Color.BLACK);
            rectColor.setStroke(Color.BLACK);
        } else if (Colores.getValue().equals("Gris")) {
            rectColor.setFill(Color.GREY);
            rectColor.setStroke(Color.GREY);
        } else if (Colores.getValue().equals("Naranjo")) {
            rectColor.setFill(Color.ORANGE);
            rectColor.setStroke(Color.ORANGE);
        } else if (Colores.getValue().equals("Violeta")) {
            rectColor.setFill(Color.VIOLET);
            rectColor.setStroke(Color.VIOLET);
        } else if (Colores.getValue().equals("Morado")) {
            rectColor.setFill(Color.PURPLE);
            rectColor.setStroke(Color.PURPLE);
        } else if (Colores.getValue().equals("Celeste")) {
            rectColor.setFill(Color.SKYBLUE);
            rectColor.setStroke(Color.SKYBLUE);
        } else if (Colores.getValue().equals("Rosado")) {
            rectColor.setFill(Color.PINK);
            rectColor.setStroke(Color.PINK);
        }
    }

    public String EstilodePalabras(String frase) {
        String p[] = frase.split(" ");

        for (int i = 0; i < p.length; i++) {

            String estilos = "";

            if (p[i].contains("^N") || p[i].contains("^S") || p[i].contains("^K")) {

                if (p[i].contains("^S") || p[i].contains("+S")) {
                    estilos = estilos + "S";
                }

                if (p[i].contains("^N") || p[i].contains("+N")) {
                    estilos = estilos + "N";
                }

                if (p[i].contains("^K") || p[i].contains("+K")) {
                    estilos = estilos + "K";
                }

                return estilos;
            }
        }
        return "";
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family: Arial");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> {
            SelectorColor(Colores.getValue());
            ColorRectangulo();
        });
        puntosDeControl.setDisable(true);
        puntosDeControl.setCursor(Cursor.HAND);
        puntosDeControl.setOnAction(actionEvent -> BotonAct(puntosDeControl));
        CuadroTexto.setOnKeyPressed(actionEvent -> obtenerLetra());
    }

}