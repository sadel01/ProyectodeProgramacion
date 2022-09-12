package codigo.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ventana.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Transformador a Script");
        stage.setScene(scene);
        stage.setMinWidth(1300);
        stage.setMinHeight(750);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



