package principal;

import javafx.application.Application;
import javafx.stage.Stage;
import tela.principal;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        principal tela = new principal();

        tela.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}