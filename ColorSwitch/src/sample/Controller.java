package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.sql.Time;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    public Arc arc1, arc2, arc3, arc4, arc5, arc6, arc7, arc8;
    @FXML
    public Group circle1;

    static GameData toBeLoaded;
    static boolean isLoaded;
    public void rotateArc(KeyEvent keyEvent) {
    }

    public void rotate(Node node) {
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(Integer.MAX_VALUE);
        rotate1.setDuration(Duration.millis(1200));
        rotate1.setNode(node);
        rotate1.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rotate(arc1);
        rotate(arc2);
        rotate(arc3);
        rotate(arc4);
        rotate(arc5);
        rotate(arc6);
        rotate(arc7);
        rotate(arc8);
        rotate(circle1);
//        AnimationTimer a = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                if(isSaved.isSavedGame) {
//                    try {
//                        toBeSaved = (HashMap) ois.readObject();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    toBeSaved.put(isSaved.nameOfSavedGame, newGame);
//                    isSaved.isSavedGame = false;
//                    try {
//                        oos.writeObject(toBeSaved);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        a.start();
    }

    public void newGame(MouseEvent mouseEvent) {
        isLoaded = false;
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitGame(MouseEvent mouseEvent) throws IOException {
        SavedGames.serialize();
        System.exit(0);
    }

    public void loadGame(MouseEvent mouseEvent) {
//        isLoaded = true;
//        toBeLoaded = SavedGames.getGame("F");
//        try {
//            Game newGame = new Game();
//            newGame.start(new Stage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            Select_Game sg = new Select_Game();
            sg.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class GameData implements Serializable {
    int ballColor, score, posColorSwitcher;
    ArrayList<Point_2D> ObstacleCoordinates;
    ArrayList<Boolean> isVisible;
    double angle;
    Point_2D ballCoordinates;

    GameData(double angle, int ballColor, int score, Point_2D ballCoordinates) {
        this.angle = angle;
        this.ballColor = ballColor;
        this.score = score;
        this.ballCoordinates = ballCoordinates;
        ObstacleCoordinates = new ArrayList<>();
        isVisible = new ArrayList<>();
    }
    public void addCoordinates(Point_2D coordinates) {
        ObstacleCoordinates.add(coordinates);
    }
    public void addVisibility(boolean vis) {
        isVisible.add(vis);
    }
    public int getBallColor() {
        return ballColor;
    }
    public int getScore() {
        return score;
    }
    public Point_2D getBallCoordinates() {
        return ballCoordinates;
    }
    public int getPosColorSwitcher() {
        return posColorSwitcher;
    }
    public Point_2D getObstacleCoordinates(int i) {
        return ObstacleCoordinates.get(i);
    }
    public boolean getVisibility(int i) {
        return isVisible.get(i);
    }
    public double getAngle() {
        return angle;
    }
}

class SavedGames {
    private Map<String, GameData> savedGames;
    private static SavedGames games;
    static File file = new File("SavedGames.txt");
    static FileOutputStream fos;
    static ObjectOutputStream oos;

    static {
        try {
            games = new SavedGames();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);

    private SavedGames() throws IOException {
        try {
            savedGames = (HashMap) ois.readObject();
        }
        catch (Exception e) {
            savedGames = new HashMap<>();
        }
    }

    public static void insert(String name, GameData gameData) {
        games.savedGames.put(name, gameData);
    }

    public static GameData getGame(String name) {
        return games.savedGames.get(name);
    }

    public static Map<String, GameData> getObject() {return games.savedGames;}

    public static void serialize() throws IOException {
        oos.writeObject(games.savedGames);
    }
}

class sortByY implements Comparator<Group> {
    @Override
    public int compare(Group g, Group g1) {
        return (int) (g1.getTranslateY() - g.getTranslateY());
    }
}