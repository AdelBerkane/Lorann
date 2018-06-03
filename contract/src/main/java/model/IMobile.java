package model;

import java.util.ArrayList;

public interface IMobile {
	
	public void move();
	public boolean isWeapon();
	public boolean isEnemy();
	
	public void setHit(boolean hit);
	public boolean getHit();
	public boolean getWin();
	public Direction getDirection();
	public void setDirection(Direction direction);
	public boolean getNeedToMove();
	public void setNeedToMove(boolean bool);
	public Position getPosition();
	public void setImage(Direction direction);
	public Direction getLastDirection();
	public void setLastDirection(Direction direction);
	public void setSprite(int color);
	public void setPrivateAttribute(int privateAttribute);
	public int getPrivateAttribute();
	
	public void animate();
	public void animate(Position Lorann, ArrayList<Direction> possiblePath);
}
