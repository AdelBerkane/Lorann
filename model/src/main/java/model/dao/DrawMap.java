package model.dao;

/**
 * This class draws the map from the database retrieved via stocked procedure
 * 
 * @author adel
 *
 */
public class DrawMap {
	private int X;
	private int Y;
	private String SPRITE;

	public DrawMap(final int X, final int Y, final String SPRITE) {
		this.setX(X);
		this.setY(Y);
		this.setSprite(SPRITE);
	}

	public DrawMap() {
		this.setX(0);
		this.setY(0);
		this.setSprite("");
	}

	public int getX() {
		return this.X;
	}

	public void setX(final int X) {
		this.X = X;
	}

	public int getY() {
		return this.Y;
	}

	public void setY(final int Y) {
		this.Y = Y;
	}

	public String getSPrite() {
		return this.SPRITE;
	}

	public void setSprite(final String SPRITE) {
		this.SPRITE = SPRITE;
	}

}
