package sample;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.*;



public class GameController implements Initializable, Serializable {

    @FXML
    Circle ball;
    @FXML
    Group obstacle1, colorSwitcher, rectObstacle, plus1, plus2, colorSwitcher1,
            colorSwitcher2, star1, star2, displayPause, savePannel, displayPause1;
    @FXML
    Arc redArc, greenArc, blueArc;
    @FXML
    Line line2, purLine, greenLine, blueLine, redLine;
    @FXML
    Label scoreBoard, sc, scoreBoard1, scoreBoard12, scoreBoard111;
    @FXML
    Button psButton, resume, restart, save, exit;
    @FXML
    TextField nameOfGame;

    Color color[] = new Color[4];

    int ballColor, need = 1;

    ArrayList<Group> nodes = new ArrayList<>();
    boolean goDown = true, isStopped = false, isDead = false;
    int score = 0;
    double difficulty = 1;

    AnimationTimer timer;

    Random rand;

    void init() {
        nodes.add(colorSwitcher);
        nodes.add(obstacle1);
        nodes.add(star1);
        nodes.add(colorSwitcher1);
        nodes.add(rectObstacle);
        nodes.add(star2);
        nodes.add(colorSwitcher2);
        nodes.add(plus1);
        nodes.add(plus2);
        rand = new Random();
        color[0] = Color.web("#ff1f1f");
        color[1] = Color.web("#c3ff20");
        color[2] = Color.web("#1fe3ff");
        color[3] = Color.web("#a219dd");
        ballColor = rand.nextInt(4);
        ball.setFill(color[ballColor]);
        if(Controller.isLoaded) {
            for(int i = 0; i<nodes.size(); i++) {
                nodes.get(i).setTranslateX(Controller.toBeLoaded.getObstacleCoordinates(i).getX());
                nodes.get(i).setTranslateY(Controller.toBeLoaded.getObstacleCoordinates(i).getY());
                nodes.get(i).setVisible(Controller.toBeLoaded.getVisibility(i));
                nodes.get(i).setRotate(Controller.toBeLoaded.getAngle());
            }
            plus2.setRotate(180 - plus2.getRotate());
//            plus1.setRotate(40);
//            plus2.setRotate(220);
            Collections.sort(nodes, new sortByY());
            ballColor = Controller.toBeLoaded.getBallColor();
            ball.setFill(color[ballColor]);
            ball.setTranslateX(Controller.toBeLoaded.getBallCoordinates().getX());
            ball.setTranslateY(Controller.toBeLoaded.getBallCoordinates().getY());
            score = Controller.toBeLoaded.getScore();
            scoreBoard.setText((score > 9 ? "" : "0") + String.valueOf(score));
        }
    }
    boolean compare(Color c, Color c1) {
        return c.getBlue() == c1.getBlue() && c.getGreen() == c1.getGreen() && c.getRed() == c1.getRed();
    }
    Color getC(Group o, int initial, boolean isUp) {
        int angle = ((int)o.getRotate() + (isUp ? 180 : 0) - 1 - initial) % 360 + 1;
        if(angle >= 0 && angle <= 90)
            return color[2];
        if(angle >= 90 && angle <= 180)
            return color[1];
        if(angle >= 180 && angle <= 270)
            return color[0];
        return color[3];
    }
    boolean isDown(double o) {
        return (ball.getTranslateY() <= o && ball.getTranslateY() >= o - 17);
    }
    boolean isUp(double o) {
        return (ball.getTranslateY() >= o && ball.getTranslateY() <= o + 17);
    }
    void check1() {
        if((isDown(obstacle1.getTranslateY() + 100) && !compare(color[ballColor], getC(obstacle1, 0, false)))
                || (isUp(obstacle1.getTranslateY() - 100) && !compare(color[ballColor], getC(obstacle1, 0, true)))) {
            dead();
        }
    }
    void check2() {
        double angle = (rectObstacle.getRotate() - 1) % 90 + 1;
        if(angle > 45) angle = 90 - angle;
        double pos = 100.0/Math.cos(Math.toRadians(angle));
        if((isDown(rectObstacle.getTranslateY() + pos + 8.5) && !compare(color[ballColor], getC(rectObstacle, -45, false)))
                || (isUp(rectObstacle.getTranslateY() - pos - 8.5) && !compare(color[ballColor], getC(rectObstacle, -45, true)))) {
            dead();
        }
    }
    void check3() {
        Point_2D pnt = new Point_2D(plus1.getTranslateX(), plus2.getTranslateY());
        double angle = (plus1.getRotate() - 1) % 360 + 1;
        Color clr;
//        if(ballColor == 3 && ((Path) Shape.intersect(ball, purLine)).getElements().size() > 0)
//            dead();
//        else if(ballColor == 2 && ((Path) Shape.intersect(ball, blueLine)).getElements().size() > 0)
//            dead();
//        else if(ballColor == 1 && ((Path) Shape.intersect(ball, greenLine)).getElements().size() > 0)
//            dead();
//        else if(ballColor == 0 && ((Path) Shape.intersect(ball, redLine)).getElements().size() > 0)
//            dead();
        if(angle >= 350 && angle <= 10)
            clr = color[2];
        else if(angle >= 80 && angle <= 100)
            clr = color[1];
        else if(angle >= 170 && angle <= 190)
            clr = color[0];
        else if(angle >= 260 && angle <= 280)
            clr = color[3];
        else
            clr = color[ballColor];
        if(ball.getTranslateY() >= pnt.getY() - 20 && ball.getTranslateY() <= pnt.getY() + 20 && !compare(color[ballColor], clr)) {
            dead();
        }
    }
    boolean isColorSwitch(int i) {
        return nodes.get(i) == colorSwitcher || nodes.get(i) == colorSwitcher1 || nodes.get(i) == colorSwitcher2;
    }
    void check4(int i) {
        if(isColorSwitch(i)) {
            if(ball.getTranslateY() <= nodes.get(i).getTranslateY() + 10 && nodes.get(i).isVisible()) {
                ballColor = rand.nextInt(4);
                ball.setFill(color[ballColor]);
                nodes.get(i).setVisible(false);
            }
        }
    }
    void check5(int i) {
        if((nodes.get(i) == star1 || nodes.get(i) == star2) &&
            ball.getTranslateY() <= nodes.get(i).getTranslateY() + 10 && nodes.get(i).isVisible()) {
            score++;
            nodes.get(i).setVisible(false);
            scoreBoard.setText((score > 9 ? "" : "0") + String.valueOf(score));
            if(score%5 == 4)
                difficulty += 0.5;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("init");
        init();
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(goDown) {
                    ball.setTranslateY(ball.getTranslateY() + difficulty);
                    check1();
                    check2();
                    check3();
                }
                else {
                    for(int i = 0; i<49+(int)difficulty; i++) {
                        check1();
                        check2();
                        check3();
                        if(ball.getTranslateY() > 0)
                            ball.setTranslateY(ball.getTranslateY() - 1);
                        else
                            for(Group g:nodes)
                                g.setTranslateY(g.getTranslateY() + 1);
                        for(int j = 0; j<nodes.size(); j++) {
                            check4(j);
                            check5(j);
                        }
                    }
                    goDown = true;
                    if(nodes.get(0).getTranslateY() >= 450) {
                        if(nodes.get(0) == colorSwitcher || nodes.get(0) == colorSwitcher1 || nodes.get(0) == colorSwitcher2) {
                            Group temp = nodes.remove(0);
                            temp.setVisible(false);
                            temp.setTranslateY(nodes.get(7).getTranslateY() - 180);
                            temp.setVisible(true);
                            nodes.add(temp);
                        }
                        else {
                            Group temp1 = nodes.get(0), temp2 = nodes.get(1);
                            nodes.remove(0);
                            nodes.remove(0);
                            temp1.setVisible(false);
                            temp2.setVisible(false);
                            temp1.setTranslateY(nodes.get(6).getTranslateY() - 180);
                            temp2.setTranslateY(temp1.getTranslateY());
                            temp1.setVisible(true);
                            temp2.setVisible(true);
                            nodes.add(temp1);
                            nodes.add(temp2);
                        }
                    }
                }
                for(Group g:nodes) {
                    if(g == star1 || g == star2)
                        continue;
                    if(g == plus2)
                        g.setRotate(g.getRotate() - difficulty);
                    else
                        g.setRotate(g.getRotate() + difficulty);
                }
            }
        };
        timer.start();
    }

    public void KeyReleased(KeyEvent keyEvent) {
        //goDown = true;
        //System.out.println("released");
    }
   
    public void dead() {
    	Main.mediaPlayer1.pause();
    	String path = "C:\\Users\\Naman Aggarwal\\Downloads\\sound.mp3";
        Media media = new Media(new File (path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        Main.mediaPlayer1.play();
        timer.stop();
        isDead = true;
        scoreBoard12.setText((score > 9 ? "" : "0") + String.valueOf(score));
        scoreBoard111.setText((need > 9 ? "" : "0") + String.valueOf(need));
        displayPause1.setLayoutX(120);
        displayPause1.setLayoutY(280);
    }

    public void pressed(KeyEvent keyEvent) {
        goDown = false;
    }


    public void pauseGame(MouseEvent mouseEvent) {
        if (!isDead) {
            timer.stop();
            scoreBoard1.setText((score > 9 ? "" : "0") + String.valueOf(score));
            displayPause.setLayoutX(195);
        }
    }

    public void resumeGame(MouseEvent mouseEvent) {
        timer.start();
        displayPause.setLayoutX(-259);
    }

    public void restartGame(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ball.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        stage.setTitle("Color Switch");
        Scene scene = new Scene(root, 500, 700);
        stage.setScene(scene);
    }

    public void saveGame(MouseEvent mouseEvent) {
        savePannel.setLayoutX(195);
        savePannel.setLayoutY(319);
    }

    public void exitGame(MouseEvent mouseEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void save(MouseEvent mouseEvent) {
        int index = 0;
        for(int i = 0; i<nodes.size(); i++)
            if(nodes.get(i) == colorSwitcher) {
                index = i;
                break;
            }
        GameData toBeSaved = new GameData((colorSwitcher.getRotate()-1)%360 + 1, ballColor, score, new Point_2D(ball.getTranslateX(), ball.getTranslateY()));
        for(int i = index; i<nodes.size(); i++) {
            toBeSaved.addCoordinates(new Point_2D(nodes.get(i).getTranslateX(), nodes.get(i).getTranslateY()));
            toBeSaved.addVisibility(nodes.get(i).isVisible());
            //toBeSaved.addAngle(nodes.get(i).getRotate());
        }
        for(int i = 0; i<index; i++) {
            toBeSaved.addCoordinates(new Point_2D(nodes.get(i).getTranslateX(), nodes.get(i).getTranslateY()));
            toBeSaved.addVisibility(nodes.get(i).isVisible());
            //toBeSaved.addAngle((nodes.get(i).getRotate()-1)%360+1);
        }
        SavedGames.insert(nameOfGame.getText(), toBeSaved);
        SGController.addE(nameOfGame.getText());
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void cancel(MouseEvent mouseEvent) {
        savePannel.setLayoutX(-276);
        savePannel.setLayoutY(598);
    }

    public void resumeGame1(MouseEvent mouseEvent) {
        if(score >= need) {
            score -= need;
            need *= 2;
            displayPause1.setLayoutX(-533);
            displayPause1.setLayoutY(539);
            ball.setTranslateY(ball.getTranslateY() - 50);
            timer.start();
        }
        else {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        }
    }

    public void cancel1(MouseEvent mouseEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}
