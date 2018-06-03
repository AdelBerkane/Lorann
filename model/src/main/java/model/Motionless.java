package model;


public class Motionless extends Elements {
	/**
	 * Get the sprite, obstacletype and position of a non mobile element
	 * 
	 * @param sprite
	 * Sprite of the element
	 * @param obtype
	 * Obstacle type of the element
	 * @param position
	 * Position of the element
	 */
	
	public Motionless(Sprite sprite, ObstacleType obtype, Position position) {
		super(sprite, obtype, position);
	}
	
	/**
	 * returns false for isGate
	 */
	
	public boolean isGate() {
		return false;
	}
	
	/**
	 * returns false for isPurse
	 */
	
	public boolean isPurse() {
		return false;
	}
	
	/**
	 * returns false for isCrystall_ball
	 */
	
	public boolean isCrystall_ball() {
		return false;
	}
	
	/**
	 * returns false for isBone
	 */
	
	public boolean isBone() {
		return false;
	}



	public boolean isCrystaBall() {
		return false;
	}
	
}
