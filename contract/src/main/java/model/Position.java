package model;
/**
 * This sets up the position of elements in the frame.
 * @author adel
 *
 */
public class Position {
	private double x;
	private double y;
	

	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position position) {
		this.x = position.getX();
		this.y = position.getX();
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double X) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}

}
