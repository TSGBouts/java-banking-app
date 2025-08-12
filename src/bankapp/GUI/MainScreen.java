package bankapp.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));

        Scene scene = new Scene(root, Color.BLANCHEDALMOND);
        stage.setTitle("Banking App");
        Image logo = new Image("logo.png");
        stage.setResizable(false);

        ImageView logoView = new ImageView(logo);
        logoView.setX(-70);
        logoView.setY(-50);
        logoView.setFitWidth(750);
        logoView.setFitHeight(800);

        stage.getIcons().add(logo);

        Text text = new Text();
        text.setText("Welcome to the Banking App!!");
        text.setX(30);
        text.setY(100);
        text.setFont(Font.font("Verdana", 35));
        text.setFill(Color.DARKBLUE);

        Line line = new Line();
        line.setStartX(30);
        line.setStartY(110);
        line.setEndX(570);
        line.setEndY(110);
        line.setStrokeWidth(5);
        line.setStroke(Color.DARKBLUE);


//        root.getChildren().add(text);
//        root.getChildren().add(line);
//        root.getChildren().add(logoView);

        stage.setScene(scene);
        stage.show();
    }
}