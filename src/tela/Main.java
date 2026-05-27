package tela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(
            FXMLLoader.load(getClass().getResource("Main.fxml"))
        );

        stage.setTitle("AutoPrime");
        stage.setWidth(1200);
        stage.setHeight(700);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}