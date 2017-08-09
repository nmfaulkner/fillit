package fillit;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bird implements Collidable{
	private Circle _bird;
	private Double _xAngle;
	private Double _yAngle;
	private Boolean _dead = false;
	
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
		_bird.setCenterX(_bird.getCenterX() + (5*_xAngle));
		_bird.setCenterY(_bird.getCenterY() + (5*_yAngle));
		
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
	public boolean intersectsShip(Ship ship) {
		double xDif = ship.getX() - _bird.getCenterX();
		double yDif = ship.getY() - _bird.getCenterY();
		double distanceSquared = xDif * xDif + yDif * yDif;
		return distanceSquared < (2*(_bird.getRadius() + ship.getRadius())) * (2*(_bird.getRadius() + ship.getRadius()));
	}

	@Override
	public void intersectsLine(ArrayList<Line> line) {
		for(int i = 0; i < line.size(); i++){
//			System.out.println(line.get(i).getPositionX());
			double xDif = line.get(i).getPositionX() - _bird.getCenterX();
			double yDif = line.get(i).getPositionY() - _bird.getCenterY();
			double distanceSquared = xDif * xDif + yDif * yDif;
//			System.out.println(distanceSquared);
			if( distanceSquared < ((_bird.getRadius() + 7)) * ((_bird.getRadius() + 7))){
				if(line.get(i).getSafe() == true){
					if(_yAngle >= _xAngle){
						_yAngle = _yAngle*-1;
					}
					else{
						_xAngle = _xAngle *-1;
					}
				}
				else{
					_dead = true;
					_yAngle = 0.0;
					_xAngle = 0.0;
				}
			}
			
//			System.out.println("Line: " + line.get(i).getPositionX());
//			System.out.println("Bird" + _bird.getCenterX());
//			if(_bird.intersects(line.get(i).getX(), line.get(i).getY(), 3, 3)){
//				System.out.println("hi");
//				_xAngle = _xAngle*-1;
//			}
		}
	}
	
	public boolean getDead(){
		return _dead;
	}
}