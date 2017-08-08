package fillit;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bird implements Collidable{
	private Circle _bird;
	private Double _xAngle;
	private Double _yAngle;
	
	public Bird(Pane gamePane){
		_bird = new Circle(10);
		_bird.setFill(Color.GREEN);
		_bird.setCenterX(250);
		_bird.setCenterY(325);
		gamePane.getChildren().addAll(_bird);
		
	}
	
	public void setColor(){
		_bird.setFill(Color.RED);
	}
	
	public void randomDirection(){
		int radius = 360;
		double angle = Math.random()*Math.PI*2;
		double x = Math.cos(angle)*radius;
		double y = Math.sin(angle)*radius;
		_xAngle = x * (Math.PI / 180) / 10;
		_yAngle = y * (Math.PI / 180) / 10;
		
	}
	
	public void moveRandom(){
		_bird.setCenterX(_bird.getCenterX() + (10*_xAngle));
		_bird.setCenterY(_bird.getCenterY() + (10*_yAngle));
		
	}
	
	public void hitsWall(){ 
		if(_bird.getCenterX() < 10 || _bird.getCenterX() > 640){
			_xAngle = _xAngle*-1;
//			this.randomDirection();
//			_yAngle = _yAngle*-1;
			
		}
		if(_bird.getCenterY() < 10 || _bird.getCenterY() > 490){
//			_xAngle = _xAngle*-1;
			_yAngle = _yAngle*-1;
//			this.randomDirection();
			
		}
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Ship ship) {
		double xDif = ship.getX() - _bird.getCenterX();
		double yDif = ship.getY() - _bird.getCenterY();
		double distanceSquared = xDif * xDif + yDif * yDif;
		return distanceSquared < (2*(_bird.getRadius() + ship.getRadius())) * (2*(_bird.getRadius() + ship.getRadius()));
	}
}