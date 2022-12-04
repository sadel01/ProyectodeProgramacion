package codigo.proyecto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador extends Dibujo implements Initializable {
    String tamanio = "";
    String grados="", grados2="";
    int numTam = 1, numGra=0, numGra2=0;
    int a = 0, b= 0, c = 0;
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
    private ToggleButton botonTraslacion;

    @FXML
    private ToggleButton botonEspejo;

    @FXML
    private ToggleButton botonEspejoY;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    private Text T;

    @FXML
    private TextField XTRASTEXT;

    @FXML
    private TextField YTRASTEXT;

    @FXML
    private Button botonTraslacionText;

    int g =0;
    private void obtenerLetra() {

        textoCoord.setStyle("-fx-font-size: 15px; -fx-padding: 5 0 0 5; -fx-font-weight: bold; -fx-font-family: Arial");
        String frase = " " + CuadroTexto.getText();
        root.getChildren().clear();
        root.getChildren().add(T);
        textoCoord.getChildren().clear();
        boolean cursiva = false;
        String estilos = "";

        String[] estilosComa = {};

        ArrayList<String> estilosFIN = new ArrayList<>();


        if (frase.matches("((.*)\\^[NKS]\\+[NKS]\\+[NKS],(.*))|((.*)\\^[NKS],(.*))|((.*)\\^[NKS]\\+[NKS],(.*))|((.*)(\\^,)(.*))|((.*)\\^[NKS]\\+,(.*))|((.*)\\^[NKS]\\+[NKS]\\+,(.*))")){

            Pattern ptr = Pattern.compile("(\\^[NKS]\\+[NKS]\\+[NKS],(.*))|(\\^[NKS],(.*))|(\\^[NKS]\\+[NKS],(.*))|(\\^,)(.*)|(\\^[NKS]\\+,(.*))|(\\^[NKS]\\+[NKS]\\+,(.*))");
            Matcher mtc = ptr.matcher(frase);

            if (mtc.find()){
                estilosComa = mtc.group(0).split(", "); // Se añaden los estilos por separado a estilosComa
            }

            String[] fraseAux = frase.split("(\\^[NKS]\\+[NKS]\\+[NKS],(.*))|(\\^[NKS],(.*))|(\\^[NKS]\\+[NKS],(.*))|(\\^,)(.*)|(\\^[NKS]\\+,(.*))|(\\^[NKS]\\+[NKS]\\+,(.*))");

            frase = fraseAux[0]; // frase = [texto] (se elimina todo el texto de estilos)

        }


        int contadorPalabras = 0;

        String[] palabra = frase.split("\\s+");


        for (int i = 1; i < palabra.length; i++) { // Por cada palabra en el texto se añade un espacio vacio en estilosFIN
            estilosFIN.add(" ");
            contadorPalabras++;
        }


        for (int i = 0; i < estilosComa.length && i < contadorPalabras; i++) {
            estilosFIN.set(i, estilosComa[i]); // Se setean los estilos en estilosFIN, para que corresponda con cada palabra del texto
        }

        int k = 0;
        for (int i =0; i <frase.length(); i++) {

            if (frase.charAt(i) == ' '){
                g++;
            }

            if (i == 0){
                estilosFIN.add(" ");
            }

            if (frase.contains("^R")) { // Invertir el texto

                if (frase.length() <= 3){
                    frase = " ";
                }else{ // (*) = puede ser ""
                    String[] fraseAux = frase.split(" \\^[R]"); // Dividir el texto: [texto (*)] ^R[texto que se va a invertir]

                    if (fraseAux.length != 1){ // Si existe texto, es decir, no es solo ^R
                        String[] cantPalabrasAux = fraseAux[1].split(" "); // Dividir las palabras que se van a invertir: [texto (*)] ^R[frase que se divide]

                        String[] cantPalabrasNoReverse = fraseAux[0].split(" "); // Dividir las palabras que no se van a invertir: [frase que se divide (*))] ^R[texto]

                        frase = fraseAux[0] + InvertirOrden(fraseAux[1]); // frase = palabras que no se invierten (*) + palabras invertidas

                        if (cantPalabrasAux.length >= 2){ // Si existen dos o mas palabras a invertir

                            if (cantPalabrasNoReverse.length - 1 != 0){ // Si existen palabras que no se van a invertir
                                List<String> estilosReverse = estilosFIN.subList(cantPalabrasNoReverse.length-1, estilosFIN.size()-1); // Se seleccionan los estilos que si se van a invertir
                                Collections.reverse(estilosReverse); // Se invierten los estilos
                            }else{
                                Collections.reverse(estilosFIN); // Se invierte la lista de estilos completa
                                estilosFIN.remove(0); // Se elimina el primer estilo (es vacio)
                                estilosFIN.add(" "); // Se añade el estilo vacio al final (necesario)
                            }
                        }

                    }else{
                        frase = fraseAux[0];
                    }
                }

            }

            if (frase.charAt(i) == ' ' && k < palabra.length){
                estilos = estilosFIN.get(k);
                k++;
            }


            boolean matches = String.valueOf(frase.charAt(i)).matches("[0-9]");
            if (i >= 3 && matches && frase.charAt(i - 1) == 'T') {
                if(frase.charAt(i - 2) == '^' ||  frase.charAt(i - 2) == '+') {
                    a = 1;
                    tamanio = tamanio + frase.charAt(i);
                }
            } else if (a == 1 && matches) {
                tamanio = tamanio + frase.charAt(i);
            } else if (frase.charAt(i) == ' ') {
                a = 0;
                tamanio = "";
                numTam = 1;
            }

            if (i >= 3 && matches && frase.charAt(i - 1) == 'a') {
                if(frase.charAt(i - 2) == '^' ||  frase.charAt(i - 2) == '+') {
                    b = 1;
                    grados = grados + frase.charAt(i);
                }
            } else if (b == 1 && matches) {
                grados = grados + frase.charAt(i);
            } else if (frase.charAt(i) == ' ') {
                b = 0;
                grados = "";
                numGra = 0;
            }

            if (i >= 3 && matches && frase.charAt(i - 1) == 'A') {
                if(frase.charAt(i - 2) == '^' ||  frase.charAt(i - 2) == '+') {
                    c = 1;
                    grados2 = grados2 + frase.charAt(i);
                }
            } else if (c == 1 && matches) {
                grados2 = grados2 + frase.charAt(i);
            } else if ( String.valueOf(frase.charAt(i)).matches("[a-zA-Z]|[áéíóúÁÉÍÓÚÜüñÑ]")) {
                if (grados2.length() != 0) {
                    numGra2 = Integer.parseInt(grados2);
                }
                c = 0;
                grados2="";
            } else if (!frase.contains("^A")) {
                numGra2=0;
                auxAng=false;
            }

            if (tamanio.length() != 0) {
                numTam = Integer.parseInt(tamanio)/10;
            }
            if (grados.length() != 0) {
                numGra = Integer.parseInt(grados);
            }

            String letra = String.valueOf(frase.charAt(i));

            if (i == 0) {
                if (String.valueOf(frase.charAt(i)).matches("[a-mA-M]|[áéíÁÉÍ]")) {
                    Letras1(cursiva,estilos, frase.charAt(i), frase.charAt(i), root, textoCoord, 1, scrollPane, numTam, numGra, numGra2);

                } else if (String.valueOf(frase.charAt(i)).matches("[n-zN-Z]|[óúÓÚÜüñÑ]")) {
                    Letras2(cursiva,estilos, frase.charAt(i), frase.charAt(i), root, textoCoord, 1, scrollPane, numTam, numGra, numGra2);
                }
                else {
                    Simbolos(cursiva,estilos, frase.charAt(i), frase.charAt(i), root, textoCoord, 1, scrollPane, numGra);
                }

            } else {

                if (frase.charAt(i) == 'K') {
                    if (frase.charAt(i - 1) == '^' || frase.charAt(i - 1) == '+') {
                        cursiva = true;
                    }
                }

                if (estilos.contains("K")){
                    cursiva = true;
                }

                if (frase.charAt(i) == ' ') {
                    cursiva = false;
                }
                if (String.valueOf(frase.charAt(i)).matches("[a-zA-Z]|[áéíóúÁÉÍÓÚÜüñÑ]")) {
                    if (cursiva) {
                        if (String.valueOf(frase.charAt(i)).matches("[a-mA-M]|[áéíÁÉÍ]")) {
                            Cursivas1(cursiva,estilos, frase.charAt(i), frase.charAt(i-1), root, textoCoord, 0, scrollPane, numTam, numGra, numGra2);

                        } else if (String.valueOf(frase.charAt(i)).matches("[n-zN-Z]|[óúÓÚÜüñÑ]")) {
                            Cursivas2(cursiva,estilos, frase.charAt(i), frase.charAt(i-1), root, textoCoord, 0, scrollPane, numTam, numGra, numGra2);
                        }
                    } else {
                        if (String.valueOf(frase.charAt(i)).matches("[a-mA-M]|[áéíÁÉÍ]")) {
                            Letras1(cursiva,estilos, frase.charAt(i), frase.charAt(i-1), root, textoCoord, 0, scrollPane, numTam, numGra, numGra2);

                        } else if (String.valueOf(frase.charAt(i)).matches("[n-zN-Z]|[óúÓÚÜüñÑ]")) {
                            Letras2(cursiva,estilos, frase.charAt(i), frase.charAt(i-1), root, textoCoord, 0, scrollPane, numTam, numGra, numGra2);
                        }
                    }
                } else {
                    if (cursiva) {
                        Simbolos(cursiva,estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, 0, scrollPane, 15);
                    } else {
                        Simbolos(cursiva,estilos, frase.charAt(i), frase.charAt(i - 1), root, textoCoord, 0, scrollPane, numGra);
                    }
                }

            }

            if (puntosDeControl.isSelected()) {
                BotonAct(puntosDeControl);
            }
        }


        if (frase.length() < 2) {
            puntosDeControl.setDisable(true);
            auxSub = false;
            auxBold = 1;
        } else {
            puntosDeControl.setDisable(false);
            botonTraslacion.setDisable(false);
            botonEspejo.setDisable(false);
            botonEspejoY.setDisable(false);
        }


    }

    private String InvertirOrden(String frase) {

        String[] p = frase.split(" "); // Se divide la frase

        String fraseInvertida = " "; // Donde se guarda la nueva frase

        for (int i = p.length - 1; i >= 0; i--) { // Se invierte la frase
            fraseInvertida = fraseInvertida + p[i] + " ";
        }

        return fraseInvertida;

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

        obtenerLetra();
    }

    private void activarEspejo() {
        espejo = botonEspejo.isSelected();

        if (botonEspejo.isSelected()){
            e = -1;
            botonEspejo.setText("Desactivar espejo (x)");
        }else{
            e = 1;
            botonEspejo.setText("Activar espejo (x)");
        }

        obtenerLetra();
    }

    private void activarEspejoY() {
        espejoY = botonEspejoY.isSelected();

        if (botonEspejoY.isSelected()){
            eY = -1;
            botonEspejoY.setText("Desactivar espejo (y)");
        }else{
            eY = 1;
            botonEspejoY.setText("Activar espejo (y)");
        }

        obtenerLetra();
    }

    @FXML
    void activarTraslacion() {

        if (botonTraslacion.isSelected()){

            XTRASTEXT.setVisible(true);
            YTRASTEXT.setVisible(true);
            botonTraslacionText.setVisible(true);
            botonTraslacionText.setDisable(true);

            XTRASTEXT.setOnKeyTyped(e ->{
                if (XTRASTEXT.getText().equals("") || YTRASTEXT.getText().equals("")){
                    botonTraslacionText.setDisable(true);
                }else{
                    botonTraslacionText.setDisable(false);
                }
            });

            YTRASTEXT.setOnKeyTyped(e->{
                if (XTRASTEXT.getText().equals("") || YTRASTEXT.getText().equals("")){
                    botonTraslacionText.setDisable(true);
                }else{
                    botonTraslacionText.setDisable(false);
                }
            });

            botonTraslacionText.setOnAction(actionEvent -> {

                try{
                    Integer.parseInt(XTRASTEXT.getText());
                    Integer.parseInt(YTRASTEXT.getText());
                    int xNuevo;

                    if (e != -1){
                        xNuevo = Integer.parseInt(XTRASTEXT.getText())-50; // Se obtiene la posicion de X del mouse y se le resta 50 por el espacio de al princio del texto
                    }else{
                        xNuevo = Integer.parseInt(XTRASTEXT.getText()) - 100; // Se obtiene la posicion de X del mouse y se le resta 50 por el espacio de al princio del texto
                    }
                    int yNuevo = Integer.parseInt(YTRASTEXT.getText()) - 50;
                    traslacion(xNuevo, yNuevo);
                    obtenerLetra();

                }catch (NumberFormatException e){

                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText("Error");
                    alerta.setContentText("Solo ingresar números");
                    alerta.showAndWait();
                }
            });

            vbox.setOnMouseClicked(ev ->{
                int xNuevo;
                int yNuevo = (int)ev.getY() - 50;

                if (e != -1){
                    xNuevo = (int)ev.getSceneX()-50; // Se obtiene la posicion de X del mouse y se le resta 50 por el espacio de al princio del texto
                }else{
                    xNuevo = (int)ev.getSceneX() + 50; // Se obtiene la posicion de X del mouse y se le resta 50 por el espacio de al princio del texto
                }

                if (eY == -1){
                    yNuevo = (int)ev.getY() + 50;
                }
                traslacion(xNuevo, yNuevo);
                XTRASTEXT.setText(String.valueOf((int)ev.getX()));
                YTRASTEXT.setText(String.valueOf((int)ev.getY()));
                obtenerLetra();
            });

            vbox.setCursor(Cursor.HAND);

            vbox.setOnMouseMoved(e -> {

                // Setear texto y posicion del texto que muestra la posicion de X e Y

                T.setText("X:" + (int)e.getX() + "\nY:" + ((int)e.getY()) + "");
                T.setX(e.getX());
                T.setY(e.getY()+50);

                // Para que el texto siempre sea visible

                if (T.getX() > vbox.getWidth() - 110){
                    T.setLayoutX(-105);
                }else{
                    T.setLayoutX(0);
                }

                if (T.getY() > vbox.getHeight() - 60){
                    T.setLayoutY(-100);
                }else{
                    T.setLayoutY(15);
                }
            });

            scrollPane.setOnMouseMoved(e->{

                if (e.getX() > vbox.getWidth()){
                    T.setText("");
                }else if (e.getY() > vbox.getHeight()){
                    T.setText("");
                }else if (e.getY() < 1){
                    T.setText("");
                }

            });

            T.setText("");

            botonTraslacion.setText("Desactivar traslación");
        }else{
            vbox.setOnMouseClicked(null);
            vbox.setOnMouseMoved(null);
            T.setText("");
            vbox.setCursor(Cursor.DEFAULT);
            botonTraslacion.setText("Activar traslación");
            XTRASTEXT.setVisible(false);
            YTRASTEXT.setVisible(false);
            botonTraslacionText.setVisible(false);
            XTRASTEXT.setText("");
            YTRASTEXT.setText("");
            XTRASTEXT.setPromptText("X:");
            YTRASTEXT.setPromptText("Y:");
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colores.getItems().addAll("Azul", "Celeste", "Gris", "Morado", "Naranjo", "Negro", "Rojo", "Rosado", "Verde", "Violeta");
        Colores.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family: Arial");
        Colores.setValue("Negro");
        Colores.setOnAction(actionEvent -> { SelectorColor(Colores.getValue()); ColorRectangulo();});
        puntosDeControl.setDisable(true);
        puntosDeControl.setCursor(Cursor.HAND);
        puntosDeControl.setOnAction(actionEvent -> BotonAct(puntosDeControl));
        botonTraslacion.setCursor(Cursor.HAND);
        botonTraslacion.setOnAction(actionEvent -> activarTraslacion());
        CuadroTexto.setOnKeyTyped(actionEvent -> obtenerLetra());
        botonEspejo.setOnAction(actionEvent -> activarEspejo());
        botonEspejoY.setOnAction(actionEvent -> activarEspejoY());

        vbox.widthProperty().addListener((observable, oldValue, newValue) ->
                {
                    if (newValue != oldValue) {
                        obtenerLetra();
                    }
                }
        );

        vbox.heightProperty().addListener((observable, oldValue, newValue) ->
                {
                    if (newValue != oldValue) {
                        obtenerLetra();
                    }
                }
        );
    }

}