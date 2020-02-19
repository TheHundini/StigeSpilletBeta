package testing;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardBeta extends Application {
	
	playerBeta player1 = new playerBeta();
	playerBeta player2 = new playerBeta();
	
	
	public int rand;
	public Label randResult;
	
	public int cirPos[][] = new int[10][10];
	public int ladderPos[][] = new int [6][3];
	
	public static final int tileSize = 80;
	public static final int width = 10;
	public static final int height = 10;
	
	
	public boolean gameStart = false;
	public Button gameButton;
	

	//public int posCir2 = 1;
	
	private Group tileGrp = new Group();
	
	private Parent createStuff() {
		Pane root = new Pane();
		root.setPrefSize((width*tileSize), (height*tileSize));
		root.getChildren().addAll(tileGrp);
		
		for(int i = 0; i < height; i++) {
			for(int j=0;j < width; j++) {
				Tiles tiles = new Tiles(tileSize,tileSize);
				tiles.setTranslateX(j * tileSize);
				tiles.setTranslateY(i * tileSize);
				tileGrp.getChildren().add(tiles);
			}
		}
		
		
		player1.createCircle( "Player 1");
		player1.getCircle().setFill(Color.AQUAMARINE);
		player2.createCircle( "Player 2");
		player2.getCircle().setFill(Color.BEIGE);
		
		Button button = new Button("Player 2");
		button.setTranslateX(700);
		button.setTranslateY(820);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(gameStart) {
					if(player2.isPlayerTurn()) {
						getDiceValue();
						randResult.setText(String.valueOf(rand));
						player2.movePlayer(rand, tileSize);
						player2.transPlayer();
						player2.setPlayerTurn(false);
						player1.setPlayerTurn(true);
					}
				}
			}
		});
		Button button2 = new Button("Player 1");
		button2.setTranslateX(80);
		button2.setTranslateY(820);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(gameStart) {
					if(player1.isPlayerTurn()) {
						getDiceValue();
						randResult.setText(String.valueOf(rand));
						player1.movePlayer(rand,tileSize);
						player1.transPlayer();
						player1.setPlayerTurn(false);
						player2.setPlayerTurn(true);
						
					}
				}
			}
		});
		
		gameButton = new Button("Start Game");
		gameButton.setTranslateX(380);
		gameButton.setTranslateY(830);
		gameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameButton.setText("Game Started");
				player1.resetPlayer();
				player2.resetPlayer();
				gameStart = true;
			}
		});
		
		randResult = new Label("0");
		randResult.setTranslateX(300);
		randResult.setTranslateY(820);
		
		
		
		tileGrp.getChildren().addAll(player1.getCircle(),player2.getCircle(),button,button2,gameButton, randResult);
		return root;
	}
	
	private void getDiceValue() {
		rand = (int)(Math.random()*6+1);
	}
	
	
	/*private void move2Player() {
		for(int i = 0; i < rand; i++) {
			if(posCir2 % 2 == 1) {
				player2.incX(tileSize);
			}
			if(posCir2 % 2 == 0) {
				player2.incX(-tileSize);
			}
			if(player2.getPlayerXPos() > 760) {
				player2.incY(-tileSize);
				player2.incX(-tileSize);
				posCir2++;
			}
			if(player2.getPlayerXPos() < 40) {
				player2.incY(-tileSize);
				player2.incX(tileSize);
				posCir2++;
			}
			if(player2.getPlayerXPos() < 30 || player2.getPlayerYPos()<30) {
				player2.setPLayerXPos(40);
				player2.setPlayerYPos(40);
				randResult.setText("Player 2 Won!");
				gameButton.setText("Start Again?");
			}
		}
	}*/
	
	
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		Scene scene = new Scene(createStuff());
		primaryStage.setTitle("Stige Spillet");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {launch(args);}
}
