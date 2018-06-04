package model;

import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
	public void move();

	public boolean isWeapon();

	public boolean isEnemy();

	public void setHit(boolean hit);

	public boolean getHit();

	public boolean getWin();

	public Direction getDIrection();

	public void setDirection(Direction direction);

	public boolean getNeedToMove();

	public void setNeedToMove(boolean bool);

	public Position getPosition();

	public void setImage(Direction direction);

	public void setLastDirection(Direction direction);

	public void setSprite(int color);

	public void setPrivateAttribute(int privateAttribute);

	public int getPrivateAttribute();

	public void animate();
	public void setMobilesHaveMoved();
	public void addMissile();
	

	public void animate(Position Lorann, ArrayList<Direction> possiblePath);

}
