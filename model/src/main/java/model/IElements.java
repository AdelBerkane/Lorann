package model;
import model.Position;

public interface IElements {
	
	public Sprite getSprite();

	public ObstacleType obtype();
		
	public Position getPosition();
	
	public boolean isGate();
	
	public boolean isCrystaBall();
	
	public boolean isBone();
	
	public boolean isPurse();

}
