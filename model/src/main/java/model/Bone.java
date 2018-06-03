package model;

public class Bone extends Motionless {
	
	/**
	 * Settings of the bone
	 * @param orientation
	 * Orientation of the bone (vertical or horizontal).
	 * @param position
	 * Position of the bone
	 */
	
	public Bone(String orientation, Position position) {
		super(new Sprite(/*signeàmettre*/ "bone_" + orientation), ObstacleType.BLOCKING, position);
	}
	
	/**
	 * Return true for isBone.
	 */
	
	public boolean isBone() {
		return true;
	}

}
