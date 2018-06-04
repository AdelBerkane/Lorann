package model;

import model.Direction;
import model.Position;

public class Missile extends Mobile {
	public int color = 1;

	public Missile(int color, Position position, Direction direction) {
		super(new Sprite(/** signeàmettre */
				"fireball_" + color), ObstacleType.BLOCKING, position, direction);
		super.setNeedToMove(true);
	}

	/**
	 * Changes the color of the missile.
	 */

	public void setSprite(int color) {
		String image = "";
		image += "fireball_";
		image += color;
		this.getSprite().setImage(image);
	}

	/**
	 * Get the value move from an upper class.
	 */

	@Override
	public void move() {
		super.move();
	}

	@Override
	public boolean isWeapon() {
		return true;
	}

	/**
	 * Sets color to the value privateAttribute
	 */

	public void setPrivateAttribute(int privateAttribute) {
		this.color = privateAttribute;
	}

	/**
	 * Returns the color of the missile
	 */

	public int getPrivateAttribute() {
		return this.color;
	}

}
