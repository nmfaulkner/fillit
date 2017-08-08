package fillit;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class scoreBoard{
	
	private Pane _gamePane;
	private HBox _scorePane;
	
	
	public scoreBoard(Pane gamePane){
		_gamePane = gamePane;
		_scorePane = new HBox();
		this.createScoreBoard();
	}
	
	
	public void createScoreBoard(){
		_scorePane.setPrefWidth(800);
		_scorePane.setPrefHeight(50);
		Label lives = new Label();
		lives.setText("Lives: 3");
		lives.setTextFill(Color.WHITE);
		lives.setAlignment(Pos.BOTTOM_CENTER);
		_scorePane.setStyle("-fx-background-color: black;");
		_scorePane.getChildren().add(lives);
//		_gamePane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		_gamePane.getChildren().addAll(_scorePane);
	}
	
//	private class KeyHandler implements EventHandler<KeyEvent> {
//		public KeyHandler() {
//		System.out.println("Hi");
//		}
//
//		@Override
//		public void handle(KeyEvent e) {
//			KeyCode keyPressed = e.getCode();
//
//			if (keyPressed == KeyCode.RIGHT) {
//				
//			}
//			if (keyPressed == KeyCode.LEFT) {
//				
//			}
//
//			if (keyPressed == KeyCode.UP) {
//				System.out.println("UP");
//				
//
//			}
//
//			if (keyPressed == KeyCode.DOWN) {
//				
//			}
//
//			e.consume();
//		}

//	}
}