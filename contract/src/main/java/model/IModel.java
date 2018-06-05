package model;

import java.awt.Image;
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
	public int getWidth();
	public int getHeight();
	public void initGame();
	public IMobile updatePosition(IMobile mobile); 

	public boolean isEnemy();
	public IMobile getLorann();
	public IMobile getMissile();
	public ArrayList<IMobile> getDemon();
	public void addScore(int addValue);
	public void removeMobile(Position position);
	public void setGameLose(boolean state);

	public void setHit(boolean hit);

	public boolean getHit();

	public boolean getWin();

	public Direction getDirection();

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
	public void addMissile(Direction direction, Position position);
	public boolean getGameWin();
	public boolean getGameLose();
	
	public Image getImageByPosition(int x, int y);
	public int getResurection();
	public int getScore();
	public void saveVariable();
	public void setScore(int score);
	public void setResurection(int value);
	public void newMap(int numberLevel) throws SQLException;
	public void buildMap(String mapLevel);


	public void animate(Position Lorann, ArrayList<Direction> possiblePath);

}
