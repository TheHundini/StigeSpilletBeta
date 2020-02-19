package testing;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tiles extends Rectangle {
	public Tiles(int x,int y) {
		setWidth(BoardBeta.tileSize);
		setHeight(BoardBeta.tileSize);
		
		setFill(Color.RED);
		setStroke(Color.BLACK);
	}
}
