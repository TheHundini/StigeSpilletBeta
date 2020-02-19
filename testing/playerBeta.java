package testing;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class playerBeta {
	private Circle cir;
	private int size = 30;
	private int playerPosition = 1;
	private boolean playerTurn = true;
	private int playerXPos = 40;
	private int playerYPos = 760;
	private int posCir = 1;
	private boolean won = false;
	
	public int getPlayerYPos() {
		return playerYPos;
	}
	
	public void setPlayerYPos(int playerYPos) {
		this.playerYPos = playerYPos;
	}
	public void incY(int increment) {
		this.playerYPos += increment;
	}
	public void incX(int increment) {
		this.playerXPos += increment;
	}
	
	public int getPlayerXPos() {
		return playerXPos;
	}
	
	public void setPLayerXPos(int playerXPos) {
		this.playerXPos = playerXPos;
	}
	
	public int getPlayerPosition() {
		return playerPosition;
	}
	
	//Getter for playerTurn
	public boolean isPlayerTurn() {
		return playerTurn;
	}
	
	//Setter for playerTurn
	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}	
	
	//Creates a player object, i use circles
	public Circle createCircle(String playerNum) {
		cir = new Circle(size);
		cir.setId(playerNum);
		cir.setTranslateX(playerXPos);
		cir.setTranslateY(playerYPos);
		cir.getStyleClass().add("style.css");
		return cir;
	}
	
	public Circle getCircle() {
		return cir;
	}
	
	//Resets the player to starting position
	public void resetPlayer() {
		this.playerXPos = 40;
		this.playerYPos = 760;
	}
	
	//moves the player and checks if the game is won
	public void movePlayer(int rand, int tileSize) {
		for(int i = 0; i < rand; i++) {
			if(posCir % 2 == 1) {
				incX(tileSize);
			}
			if(posCir % 2 == 0) {
				incX(-tileSize);
			}
			if(getPlayerXPos() > 760) {
				incY(-tileSize);
				incX(-tileSize);
				posCir++;
			}
			if(getPlayerXPos() < 40) {
				incY(-tileSize);
				incX(tileSize);
				posCir++;
			}
			if(getPlayerXPos() < 30 || getPlayerYPos()<30) {
				setPLayerXPos(40);
				setPlayerYPos(40);
				won = true;
			}
		}
	}

	public int getPosCir() {
		return posCir;
	}

	public void setPosCir(int posCir) {
		this.posCir = posCir;
	}

	public boolean getWon() {
		return won;
	}
	
	//Animation when moving
	public void transPlayer() {
		TranslateTransition animate = new TranslateTransition(Duration.millis(1000), cir);
		animate.setToX(getPlayerXPos());
		animate.setToY(getPlayerYPos());
		animate.setAutoReverse(false);
		animate.play();
	}
}
