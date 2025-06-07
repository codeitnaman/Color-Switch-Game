package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SGController implements Initializable {
    @FXML
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9
            , button10, button11, button12, button13, button14, button15, button16, button17, button18;

    static Button buttons[] = new Button[18];

    static int id = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
        buttons[8] = button9;
        buttons[9] = button10;
        buttons[10] = button11;
        buttons[11] = button12;
        buttons[12] = button13;
        buttons[13] = button14;
        buttons[14] = button15;
        buttons[15] = button16;
        buttons[16] = button17;
        buttons[17] = button18;
        id = 0;
        SavedGames.getObject().forEach((k, v) -> {
            buttons[id].setText(k);
            buttons[id].setDisable(false);
            buttons[id].setVisible(true);
            id++;
        });
    }

    static void addE(String name) {
        buttons[id].setText(name);
        buttons[id].setDisable(false);
        buttons[id].setVisible(true);
        id++;
    }


    public void loadGame1(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button1.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame2(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button2.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame3(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button3.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame4(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button4.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame5(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button5.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame6(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button6.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame7(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button7.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame8(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button8.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame9(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button9.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame10(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button10.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame11(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button11.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame12(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button12.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame13(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button13.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame14(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button14.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame15(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button15.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame16(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button16.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame17(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button17.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadGame18(MouseEvent mouseEvent) {
        Controller.isLoaded = true;
        Controller.toBeLoaded = SavedGames.getGame(button18.getText());
        try {
            Game newGame = new Game();
            newGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
