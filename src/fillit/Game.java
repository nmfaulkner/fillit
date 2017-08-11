package fillit;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Game{
	
	private Ship _ship;
	private Bird _bird;
	private Timeline _timeline;
	private Pane _gamePane;
	private ArrayList<Line> _lines;
	private boolean _safe;
	private int _xDirection;
	private int _yDirection;
	
	
	public Game(Pane gamePane){
		_lines = new ArrayList<Line>();
		_gamePane = gamePane;
		_ship = new Ship(gamePane);
		_bird = new Bird(gamePane);
		_bird.randomDirection();
		gamePane.setFocusTraversable(true);
		gamePane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		this.setUpTimeline();
	}
	
	
	private class KeyHandler implements EventHandler<KeyEvent> {
		public KeyHandler() {
//		System.out.println("Hi");
		}

		@Override
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();

			if (keyPressed == KeyCode.RIGHT) {
				if(!_bird.getDead()){
				_ship.moveRight();
				_xDirection = -10;
				_yDirection = 0;
				}
			}
			if (keyPressed == KeyCode.LEFT) {
				if(!_bird.getDead()){
				_ship.moveLeft();
				_xDirection = 10;
				_yDirection = 0;
				}
			}

			if (keyPressed == KeyCode.UP) {
				if(!_bird.getDead()){
				_ship.moveUp();
				_xDirection = 0;
				_yDirection = 10;
				}

			}

			if (keyPressed == KeyCode.DOWN) {
				if(!_bird.getDead()){
				_ship.moveDown();
				_xDirection = 0;
				_yDirection = -10;
				}
			}

			e.consume();
		}
	}
	
	public void setUpTimeline() {
		_timeline = new Timeline();
		_timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(8), new TimeHandler()));
		_timeline.setCycleCount(Timeline.INDEFINITE);
		_timeline.play();
	}
	
	
	public class TimeHandler implements EventHandler<ActionEvent> {
		public TimeHandler() {
		}

		public void handle(ActionEvent event) {
			_bird.moveRandom();
			_bird.hitsWall();
			if(_bird.intersectsShip(_ship)){
				_bird.setColor();
			}
			
			if(_ship.getY() < 500 && _ship.getX() < 650 && _ship.getX() > 0 && _ship.getY() > 0){
				Line line = new Line(_gamePane, _ship.getX(), _ship.getY());
				_lines.add(line);
				
			}
			
			_bird.intersectsLine(_lines);
			
			if(_ship.getY() > 498 || _ship.getY() < 2 || _ship.getX() > 648 || _ship.getX() < 2){
				isSafe();
				}
			
			shipHitsLine();

		}

	}
	
	
	public void isSafe(){
		for(int j = 0; j < _lines.size(); j++){
			_lines.get(j).setSafeTrue();
		}
	}
	
	public void shipHitsLine(){
		for(int i = 0; i < _lines.size(); i++){
//			System.out.println(line.get(i).getPositionX());
			double xDif = _lines.get(i).getPositionX() - _ship.getX();
			double yDif = _lines.get(i).getPositionY() - _ship.getY();
			double distanceSquared = xDif * xDif + yDif * yDif;
			if( distanceSquared < ((_ship.getRadius() + 10)) * ((_ship.getRadius() + 10))){
				if(_lines.get(i).getSafe() == true){
					this.isSafe();
					
				}
//				else{
//					_bird.setDead();
//				}
			}
			
//			System.out.println("Line: " + line.get(i).getPositionX());
//			System.out.println("Bird" + _bird.getCenterX());
//			if(_bird.intersects(line.get(i).getX(), line.get(i).getY(), 3, 3)){
//				System.out.println("hi");
//				_xAngle = _xAngle*-1;
//			}
		}
	}
	
}