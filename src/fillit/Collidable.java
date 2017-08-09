package fillit;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

public interface Collidable{
	
	public Node getNode();
	
	public boolean intersectsShip(Ship circle);
	
	public void intersectsLine(ArrayList<Line> line);
	
}