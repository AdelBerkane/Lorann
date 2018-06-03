package model;

public class Purse extends Motionless {
	
	/**
	 * Settings of a purse
	 * @param position
	 * Position on the purse
	 */

	public Purse( Position position) {
		super(new Sprite(/**signeàmettre**/"purse"), ObstacleType.PENETRABLE, position);
	}
	
	/**
	 * Return true for isPurse
	 */
	
	public boolean isPurse() {
		return true;
	}

}
