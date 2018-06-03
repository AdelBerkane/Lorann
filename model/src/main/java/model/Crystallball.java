package model;

public class Crystallball extends Motionless {
	
	/**
	 * Set settings of the crystal ball which allows the player to open the door once picked up.
	 * 
	 * @param position
	 * Position of the crystal ball
	 */
	
	public Crystallball(Position position){
		super(new Sprite("cb", "crystal_ball"), ObstacleType.PENETRABLE, position);
	}
	
	/**
	 * Return true for isCrystalball
	 */
	
	public boolean isCrystalBall() {
		return true;
	}
	

}
