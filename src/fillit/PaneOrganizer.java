package fillit;

import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

public class PaneOrganizer{
	
private Pane _root;
	
	
	public PaneOrganizer(){
		
		_root = new Pane();
		_root.setPrefSize(650, 800);
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: navy;");
		borderPane.setPrefSize(800, 650);
		Pane gamePane = new Pane();
		gamePane.setPrefSize(650, 500);
		gamePane.setStyle("-fx-background-color: white;");
		gamePane.setLayoutX(75);
		gamePane.setLayoutY(100);
		Game game = new Game(gamePane);
		_root.getChildren().addAll(borderPane, gamePane);
		scoreBoard scoreBoard = new scoreBoard(_root);
	}
	
	
	public Pane getRoot() {
		return _root;
	}
	
}