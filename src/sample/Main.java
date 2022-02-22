package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
            // Establecemos el título de la ventana
            primaryStage.setTitle("MARVEL TEST");
            // Establecemos el ancho y el alto
            primaryStage.setScene(new Scene(root));
            // Mostramos la ventana
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}