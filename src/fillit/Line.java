package fillit;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Line extends Rectangle{
	private Rectangle _line;
	private boolean _safe;
	
	public Line(Pane gamePane, double xLocation, double yLocation){
		_safe = false;
		_line = new Rectangle(4,4);
		_line.setFill(Color.RED);
		_line.setX(xLocation);
		_line.setY(yLocation);
		gamePane.getChildren().addAll(_line);
		
	}
	
	public double getPositionX(){
		return _line.getX();
	}
	
	public double getPositionY(){
		return _line.getY();
	}
	
	public void setSafeTrue(){
		_safe = true;
	}
	
	public void setSafeFalse(){
		_safe = false;
	}
	
	public boolean getSafe(){
		return _safe;
	}

	
	
}