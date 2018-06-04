package model;

import model.Direction;
import model.IMobile;
import model.Position;

import java.util.ArrayList;

public class Mobile extends Elements implements IMobile {

	protected Direction direction = null;
	public boolean needToMove = false;
	protected Direction lastDirection;
	protected boolean hit = false;

	/**
	 * Gets the sprite, obstacle type and position and sets direction
	 * 
	 * @param sprite
	 *            sprite of the element
	 * @param obtype
	 *            obtype of the element
	 * @param position
	 *            position of the element
	 * @param direction
	 *            direction of the element
	 */

	public Mobile(Sprite sprite, ObstacleType obtype, Position position, Direction direction) {
		super(sprite, obtype, position);
		this.direction = direction;
	}

	protected void moveUp() {
		this.getPosition().setY(this.getPosition().getY() +1);
	}

	/**
	 * Change value of X to move a controlled character right.
	 */

	protected void moveRight() {
		this.getPosition().setX(this.getPosition().getX() + 1);
	}

	/**
	 * Change value of Y to move a controlled character down.
	 */

	protected void moveDown() {
		this.getPosition().setY(this.getPosition().getY() + -1);
	}

	/**
	 * Change value of X to move a controlled character right.
	 */

	protected void moveLeft() {
		this.getPosition().setX(this.getPosition().getX() - 1);
	}

	/**
	 * Sets moves for the player
	 */

	public void move() {
		switch (this.getDirection()) {
		case UP:
			this.moveUp();
			break;
		case DOWN:
			this.moveDown();
			break;
		case RIGHT:
			this.moveRight();
			break;
		case LEFT:
			this.moveLeft();
			break;
		case NW:
			this.moveUp();
			this.moveLeft();
		case NE:
			this.moveUp();
			this.moveRight();
		case SE:
			this.moveDown();
			this.moveRight();
		case SW:
			this.moveDown();
			this.moveLeft();
		}
	}

	/**
	 * Sets hit to the value of hit
	 */

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	/**
	 * Allows the use of hit in another class
	 */

	public boolean getHit() {
		return this.hit;
	}

	/**
	 * Return false for isWeapon
	 */

	public boolean isWeapon() {
		return false;
	}

	/**
	 * Change value of Y to move a controlled character up.
	 */

	/**
	 * Overloaded method in the subclasses
	 */

	public void setSprite(int color) {
	}

	/**
	 * Return false for isEnemy.
	 */

	public boolean isEnemy() {
		return false;
	}

	/**
	 * Allows the use of direction in another class.
	 */

	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * Sets direction to the direction value.
	 */

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * ALlows the use of direction in another class.
	 */

	public Position getPosition() {
		return this.position;
	}

	public boolean getNeedToMove() {
		return this.needToMove;
	}

	public void setNeedToMove(boolean bool) {
		this.needToMove = bool;
	}

	/**
	 * Overloaded method in subclass
	 */

	public void setImage(Direction direction) {

	}

	public Direction getLastDirection() {
		return this.lastDirection;
	}

	public void setLastDirection(Direction direction) {
		this.lastDirection = direction;
	}

	/**
	 * Set moves for NPC (non player characters).
	 */

	public void animate() {
		switch (this.getDirection()) {
		case UP:
			this.setDirection(Direction.DOWN);
			break;
		case DOWN:
			this.setDirection(Direction.UP);
			break;
		case LEFT:
			this.setDirection(Direction.RIGHT);
			break;
		case RIGHT:
			this.setDirection(Direction.LEFT);
			break;
		case NW:
			this.setDirection(Direction.SE);
			break;
		case NE:
			this.setDirection(Direction.SW);
			break;
		case SW:
			this.setDirection(Direction.NE);
			break;
		case SE:
			this.setDirection(Direction.NW);
			break;
		}
	}

	public boolean getWin() {
		return false;
	}

	/**
	 * Overloaded method in the subclasses
	 */

	public void animate(Position Lorann, ArrayList<Direction> possiblePath) {

	}

	/**
	 * Overloaded method in the subclasses
	 * 
	 * @param privateAttribute
	 */

	public void setPrivateAttribute(int privateAttribute) {

	}

	/**
	 * Return the value of 'O' for getPrivateAttribute
	 */

	public int getPrivateAttribute() {
		return 0;
	}

}
