package fillit;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

public interface Collidable{
	
	public Node getNode();
	
	public boolean intersects(Ship circle);
	
}