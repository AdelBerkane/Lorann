package model;

public abstract class Elements implements IElements {

	protected Sprite sprite;
	protected ObstacleType obtype;

	protected Position position;

	/**
	 * Implements the settings for the sprite, its obstacle type and position.
	 * 
	 * @param sprite
	 *            Sprite of the element
	 * @param obtype
	 *            the type of the element
	 * @param position
	 *            position of the element
	 */

	public Elements(final Sprite sprite, final ObstacleType obtype, final Position position) {
		this.setSprite(sprite);
		this.setObstacleType(obtype);
		this.setPosition(position);
	}

	/**
	 * Allows the use sprite in another class
	 */

	public Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the Sprite sprite to the value sprite.
	 * 
	 * @param sprite
	 *            The sprite of an element
	 */

	private void setSprite(final Sprite sprite) {
		this.sprite = sprite;

	}

	/**
	 * Allows to use Position in other classes
	 */

	public Position getPosition() {
		return this.position;
	}

	private void setPosition(final Position position) {
		this.setPosition(position);

	}

	public ObstacleType getObstacleType() {
		return this.obtype;
	}

	private void setObstacleType(final ObstacleType obtype) {
		this.setObstacleType(obtype);

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

}
