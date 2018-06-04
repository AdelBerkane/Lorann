package model;

import model.Direction;
import model.Position;

public class Lorann extends Mobile {

	public boolean win = false;

	public Lorann(Direction direction, Position position) {
		super(new Sprite("L", "lorann_" + direction), ObstacleType.BLOCKING, position, direction);
		this.needToMove = false;
	}

	/**
	 * Returns flase for isEnemy
	 */

	@Override
	public boolean isEnemy() {
		return false;
	}

	/**
	 * Set direction as value direction.
	 */

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Set sprite for Lorann and its directions
	 */

	public void setImage(Direction direction) {
		String image = "lorann_";
		image += direction;
		this.getSprite().setImage(image);
	}

	/**
	 * Sets win to the value of win.
	 * 
	 * @param win
	 *            The value win(true win, false lose)
	 */
	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean getWin() {
		return this.win;
	}

}
