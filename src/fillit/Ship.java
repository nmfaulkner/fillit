package fillit;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ship extends Circle{
	
	private Circle _ship;
	
	public Ship(Pane gamePane){
		_ship = new Circle(10);
		_ship.setFill(Color.BLACK);
		_ship.setCenterX(325);
		_ship.setCenterY(500);
//		gamePane.setFocusTraversable(true);
//		gamePane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		gamePane.getChildren().addAll(_ship);
	}
	
	
	public void moveUp(){
		if(_ship.getCenterY() > 0){
		_ship.setCenterY(_ship.getCenterY() - 10);
		}
		
	}
	
	public void moveLeft(){
		if(_ship.getCenterX() > 0){
		_ship.setCenterX(_ship.getCenterX() - 10);
		}
	}
	
	public void moveRight(){
		if(_ship.getCenterX() < 650){
		_ship.setCenterX(_ship.getCenterX() + 10);
		}
	}
	
	public void moveDown(){
		if(_ship.getCenterY() < 500){
		_ship.setCenterY(_ship.getCenterY() + 10);
		}
	}
	
	public double getX(){
		return _ship.getCenterX();
	}
	
	public double getY(){
		return _ship.getCenterY();
	}
	
	
}