package tela;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class principal {

    public void mostrar(Stage stage) {

        Label texto = new Label("Olá JavaFX!");

        VBox layout = new VBox();
        layout.getChildren().add(texto);

        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Meu Sistema");
        stage.setScene(scene);
        stage.show();
    }
}