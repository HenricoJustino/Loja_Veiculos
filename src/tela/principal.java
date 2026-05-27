package tela;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class principal {

    public void start(Stage stage) {

        Label titulo = new Label("Sistema Loja de Veículos");

        Button botao = new Button("Clique aqui");

        botao.setOnAction(e -> {
            System.out.println("Botão clicado!");
        });

        VBox layout = new VBox(20);

        layout.getChildren().addAll(titulo, botao);

        layout.setAlignment(Pos.CENTER);

        Scene cena = new Scene(layout, 600, 400);

        stage.setTitle("Loja de Veículos");

        stage.setScene(cena);

        stage.show();
    }
}