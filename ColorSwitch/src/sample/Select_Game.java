package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Select_Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("selectGame.fxml"));
        stage.setTitle("Color Switch");
        Scene scene = new Scene(root, 500, 700);
        stage.setScene(scene);
        stage.show();
    }
}
