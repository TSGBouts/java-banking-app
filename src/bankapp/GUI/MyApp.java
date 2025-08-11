package bankapp.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new StackPane(new Label("Hello")), 300, 150));
        stage.setTitle("HelloFX");
        stage.show();
    }
}