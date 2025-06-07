package sample;
	
import javafx.scene.shape.Polygon;
import java.io.Serializable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;

class _Circle implements Obstacle{
	private Circle circle;
	public _Circle(Circle circle) {
		super();
		this.circle = circle;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	@Override
	public String toString() {
		return "_Circle [circle=" + circle + "]";
	}
	
}
class _Line implements Obstacle{
	private Line line;

	public _Line(Line line) {
		super();
		this.line = line;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "_Line [line=" + line + "]";
	}
	
}
class _Polygon implements Obstacle{
	private Polygon polygon;

	public _Polygon(Polygon polygon) {
		super();
		this.polygon = polygon;
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

	@Override
	public String toString() {
		return "_Polygon [polygon=" + polygon + "]";
	}
	
}
class Star implements Component{
	private double height;
	private double width;
	private boolean is_consumed;
	public void consume() {
		
	}
	public Star(double height, double width, boolean is_consumed) {
		super();
		this.height = height;
		this.width = width;
		this.is_consumed = is_consumed;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public boolean isIs_consumed() {
		return is_consumed;
	}
	public void setIs_consumed(boolean is_consumed) {
		this.is_consumed = is_consumed;
	}
	@Override
	public String toString() {
		return "Star [height=" + height + ", width=" + width + ", is_consumed=" + is_consumed + "]";
	}
	
}
class Obstacle implements Component{
	private Shape shape;
	private double height;
	private double width;
	public void move_periodically() {
		
	}
	public Obstacle(Shape shape, double height, double width) {
		super();
		this.shape = shape;
		this.height = height;
		this.width = width;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Obstacle [shape=" + shape + ", height=" + height + ", width=" + width + "]";
	}
	
}
class Ball implements Component{
	private int radius;
	private double velocity;
	private boolean is_dead;
	public void kill() {
		
	}
	public void switch_color() {
		
	}
	public boolean check_collision() {
		return false;
	}
	public void jump() {
		
	}
	public Ball(int radius, double velocity, boolean is_dead) {
		super();
		this.radius = radius;
		this.velocity = velocity;
		this.is_dead = is_dead;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	public boolean isIs_dead() {
		return is_dead;
	}
	public void setIs_dead(boolean is_dead) {
		this.is_dead = is_dead;
	}
	@Override
	public String toString() {
		return "Ball [radius=" + radius + ", velocity=" + velocity + ", is_dead=" + is_dead + "]";
	}
	
}
class Explosion_Ball extends Ball{
	private int random_int;
	private double velocity;
	public void explode() {
		
	}
	public Explosion_Ball(int radius, double velocity, boolean is_dead, int random_int, double velocity2) {
		super(radius, velocity, is_dead);
		this.random_int = random_int;
		velocity = velocity2;
	}
	public int getRandom_int() {
		return random_int;
	}
	public void setRandom_int(int random_int) {
		this.random_int = random_int;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	@Override
	public String toString() {
		return "Explosion_Ball [random_int=" + random_int + ", velocity=" + velocity + "]";
	}
	
}
class InsufficientStars extends Game{
	private String message;
	public void display() {
		
	}
	public InsufficientStars(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "InsufficientStars [message=" + message + "]";
	}
	
}
class Color_switcher extends Game{
	private int radius;
	public Color changed_color() {
		return null;
	}
	public Color_switcher(int radius) {
		super();
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Color_switcher [radius=" + radius + "]";
	}
	
}
class Color extends Component{
	private int r_value;
	private int b_value;
	private int g_value;
	public void random_color() {
		
	}
	public Color(int r_value, int b_value, int g_value) {
		super();
		this.r_value = r_value;
		this.b_value = b_value;
		this.g_value = g_value;
	}
	public int getR_value() {
		return r_value;
	}
	public void setR_value(int r_value) {
		this.r_value = r_value;
	}
	public int getB_value() {
		return b_value;
	}
	public void setB_value(int b_value) {
		this.b_value = b_value;
	}
	public int getG_value() {
		return g_value;
	}
	public void setG_value(int g_value) {
		this.g_value = g_value;
	}
	@Override
	public String toString() {
		return "Color [r_value=" + r_value + ", b_value=" + b_value + ", g_value=" + g_value + "]";
	}
	
}
class Component extends Game{
	protected Point2D cord;
	protected Color color;
	public void display() {
		
	}
	public Component(Point2D cord, Color color) {
		super();
		this.cord = cord;
		this.color = color;
	}
	public Point2D getCord() {
		return cord;
	}
	public void setCord(Point2D cord) {
		this.cord = cord;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Component [cord=" + cord + ", color=" + color + "]";
	}
	
}
class GameLost extends Game{
	private String message;
	public void display() {
		
	}
	public GameLost(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GameLost [message=" + message + "]";
	}
	
}
class App{
	public GameMenu gameMenu;

	public App(GameMenu gameMenu) {
		super();
		this.gameMenu = gameMenu;
	}

	public GameMenu getGameMenu() {
		return gameMenu;
	}

	public void setGameMenu(GameMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	@Override
	public String toString() {
		return "App [gameMenu=" + gameMenu + "]";
	}
	
}
class Game extends GameMenu implements Serializable{
	private Component ball;
	private Component stars;
	private Component obstacles;
	private int points;
	private Color_switcher color_switcher;
	public void play() {
		
	}
	public void pause() {
		
	}
	public void save_game() {
		
	}
	public void revive() {
		
	}
	public Game(Component ball, Component stars, Component obstacles, int points, Color_switcher color_switcher) {
		super();
		this.ball = ball;
		this.stars = stars;
		this.obstacles = obstacles;
		this.points = points;
		this.color_switcher = color_switcher;
	}
	public Component getBall() {
		return ball;
	}
	public void setBall(Component ball) {
		this.ball = ball;
	}
	public Component getStars() {
		return stars;
	}
	public void setStars(Component stars) {
		this.stars = stars;
	}
	public Component getObstacles() {
		return obstacles;
	}
	public void setObstacles(Component obstacles) {
		this.obstacles = obstacles;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Color_switcher getColor_switcher() {
		return color_switcher;
	}
	public void setColor_switcher(Color_switcher color_switcher) {
		this.color_switcher = color_switcher;
	}
	@Override
	public String toString() {
		return "Game [ball=" + ball + ", stars=" + stars + ", obstacles=" + obstacles + ", points=" + points
				+ ", color_switcher=" + color_switcher + "]";
	}
	
}
class GameMenu extends App{
	private String name;
	private Game newGame;
	private Saved_Games savedGames;
	public void quit() {
		
	}
	public void startNewGame() {
		
	}
	public void loadGame() {
		
	}
	public void saveGame() {
		
	}
	public GameMenu(GameMenu gameMenu, String name, Game newGame, Saved_Games savedGames) {
		super(gameMenu);
		this.name = name;
		this.newGame = newGame;
		this.savedGames = savedGames;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Game getNewGame() {
		return newGame;
	}
	public void setNewGame(Game newGame) {
		this.newGame = newGame;
	}
	public Saved_Games getSavedGames() {
		return savedGames;
	}
	public void setSavedGames(Saved_Games savedGames) {
		this.savedGames = savedGames;
	}
	@Override
	public String toString() {
		return "GameMenu [name=" + name + ", newGame=" + newGame + ", savedGames=" + savedGames + "]";
	}
	
}
class Saved_Games extends GameMenu{
	private Game games;
	public void resume() {
		
	}
	public Saved_Games(GameMenu gameMenu, String name, Game newGame, Saved_Games savedGames, Game games) {
		super(gameMenu, name, newGame, savedGames);
		this.games = games;
	}
	public Game getGames() {
		return games;
	}
	public void setGames(Game games) {
		this.games = games;
	}
	@Override
	public String toString() {
		return "Saved_Games [games=" + games + "]";
	}
	
}
public class Classes extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
