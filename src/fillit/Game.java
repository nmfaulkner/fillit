package fillit;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game{
	
	private Ship _ship;
	private Bird _bird;
	private Timeline _timeline;
	
	
	public Game(Pane gamePane){
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
				_ship.moveRight();
				
			}
			if (keyPressed == KeyCode.LEFT) {
				_ship.moveLeft();
			}

			if (keyPressed == KeyCode.UP) {
				_ship.moveUp();
				

			}

			if (keyPressed == KeyCode.DOWN) {
				_ship.moveDown();
				
			}

			e.consume();
		}
	}
	
	public void setUpTimeline() {
		_timeline = new Timeline();
		_timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(50), new TimeHandler()));
		_timeline.setCycleCount(Timeline.INDEFINITE);
		_timeline.play();
	}
	
	
	public class TimeHandler implements EventHandler<ActionEvent> {
		public TimeHandler() {
		}

		public void handle(ActionEvent event) {
			_bird.moveRandom();
			_bird.hitsWall();
			if(_bird.intersects(_ship)){
				_bird.setColor();
			}

		}

	}
	
}