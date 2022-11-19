package codigo.proyecto;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ventana.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Transformador a Script");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        stage.setMinHeight(660);
        stage.setMinWidth(1000);
    }

    public static void main(String[] args) {
        launch();
    }
}



