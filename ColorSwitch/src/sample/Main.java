package sample;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("selectGame.fxml"));
        stage.setTitle("Color Switch");
        Scene scene1 = new Scene(root1, 500, 700);
        stage.setScene(scene1);
        stage.show();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        Scene scene = new Scene(root, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    static MediaPlayer mediaPlayer1;
    public static void main(String[] args) {
    	String path1 = "C:\\Users\\Naman Aggarwal\\Downloads\\sound1.mp3";
        Media media1 = new Media(new File (path1).toURI().toString());
        mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.play();
      
    	launch(args);
       
    }
}
