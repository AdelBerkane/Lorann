package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerOrder;
import model.Direction;
import controller.IController;
import model.IModel;
import model.IMobile;
import view.IView;
import model.Position;


public class Controller implements IController {
	private static int TIME_SLEEP = 100;
	private boolean gifDelay = false;
	/**
	 * The view
	 */
	private  IView view;
	/**
	 * The model
	 */
	private IModel model;
	private IMobile Lorann;
	private IMobile Missile;
	private ArrayList<IMobile> Demon = null;
	
	public Controller(final IModel model) {
		this.setModel(model);
	}
	private void setModel(final IModel model) {
		this.model = model;
	}
	public void play() {
		String message;
		this.endUserOrder(view.displayMessage("Welcome"));
		
		do {
			gameLoop();
			if(this.model.getGameWin())
				message = "WIN";
			else {
				message = "LOSE";
			}
		}while(this.endUserOrder(view.displayMessage(message)));
		view.closeAll();
	}
	
	//protected boolean endUserOrder(ControllerOrder controllerOrder) {
	//	if(controllerOrder != null) {
			//switch(controllerOrder) {
		//	case QUIT:
			//	if(this.model.getGameWin())
	//				this.model.saveVariable());
		//			return false;
	//				case
		//	}
		//}
//	}
	
public void orderPerform(final ControllerOrder controllerOrder) {
		
		this.getLorann();
		Direction direction = null;

		switch (controllerOrder) {
			case UP:
				direction = Direction.UP;
				break;
			case DOWN:
				direction = Direction.DOWN;
				break;
			case RIGHT:
				direction = Direction.RIGHT;
				break;
			case LEFT:
				direction = Direction.LEFT;
				break;
			case NE:
				direction = Direction.NE;
				break;
			case NW:
				direction = Direction.NW;
				break;
			case SE:
				direction = Direction.SE;
				break;
			case SW:
				direction = Direction.SW;
				break;
			case SHOOT:
				this.launchMissile();
				break;
			case NOPE:
				break;
			default:
				break;
		}
		if(Lorann != null && direction != null){
			Lorann.setDirection(direction);
			Lorann.setNeedToMove(true);
			if(Demon != null){
				IMobile actualMobile;
				for(int i = 0; Demon.size() > i; i++){
	                actualMobile = (IMobile) Demon.toArray()[i];
	                actualMobile.setNeedToMove(true);
	            }
			}
			this.model.setMobilesHaveMoved();
		}
		

	}

/**
 * Launches a misile in the opposite direction only if it's not already launched
 */
public void launchMissile() {
	this.getLorann();
	if(Lorann != null) {
		this.getMissile();
		double x = Lorann.getPosition().getX();
		double y = Lorann.getPosition().getY();
		if(Missile == null && Lorann.getLastDirection() != null) {
			switch (Lorann.getLastDirection()) {
			case UP:
				y += 1;
				model.addMissile(Direction.DOWN, new Position(x,y));
				break;
			case DOWN:
				y -= 1;
				model.addMissile(Direction.UP, new Position(x,y));
				break;
			case LEFT:
				x += 1;
				model.addMissile(Direction.RIGHT, new Position(x,y));
				break;
			case RIGHT:
				x -=1;
				model.addMissile(Direction.LEFT, new Position(x,y));
				break;
			case NW:
				x += 1;
				y += 1;
				model.addMissile(Direction.SE, new Position(x,y));
				break;
			case NE:
				x -= 1;
				y += 1;
				model.addMissile(Direction.SW, new Position(x,y));
				break;
			case SW:
				x += 1;
				y -= 1;
				model.addMissile(Direction.NE, new Position(x,y));
				break;
			case SE:
				x -= 1;
				y -= 1;
				model.addMissile(Direction.NW, new Position(x,y));
				break;
			}
		}
	}
}
	protected boolean endUserOrder(ControllerOrder controllerOrder){
		if(controllerOrder != null){
			switch(controllerOrder){
			case QUIT:
				//Save Score to Database
				if(this.model.getGameWin())
						this.model.saveVariable();
				return false;
			case AGAIN:
				this.newMap(0);
				return true;
			case LEVEL1:
				this.newMap(1);
				return true;
			case LEVEL2:
				this.newMap(2);
				return true;
			case LEVEL3:
				this.newMap(3);
				return true;
			case LEVEL4:
				this.newMap(4);
				return true;
			case LEVEL5:
				this.newMap(5);
				return true;
			default:
				return false;
			}
		}
		return false;
	}
	private void newMap(int numberMap) {
		if(this.model.getGameWin())
		{
			this.model.saveVariable();
			this.model.setScore(0);
			this.model.setResurection(0);
		}
		else if(numberMap == 0) {
			this.model.setScore(0);
			this.model.setResurection(this.model.getResurection()+1);
		}
		else {
			this.model.setScore(0);
			this.model.setResurection(0);
		}
		try {
			this.model.newMap(numberMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getLorann() {
		this.Lorann=this.model.getLorann();
		}
	public void getMissile() {
		this.Missile= this.model.getMissile();
	}
	public void getDemon() {
		this.Demon = this.model.getDemon();
	}
	
	
	
	public void gameLoop() {
		this.model.initGame();
		while(!this.model.getGameWin() && !this.model.getGameLose()) {
			this.getLorann();
			this.getMissile();
			this.getDemon();
			this.moveAllMobile();
			this.checkHitMobile();
			this.model.setMobilesHaveMoved();
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
	
	public void checkHitMobile() {
		if(Lorann == null || Lorann.getHit()) {
			this.model.setGameLose(true);
	}
		if(Missile!= null && Missile.getHit())
			this.model.removeMobile(Missile.getPosition());
		if(Demon != null) {
			IMobile actualMobile;
			for(int i = 0; Demon.size() > i; i++) {
				actualMobile = (IMobile) Demon.toArray()[i];
				if(actualMobile.getHit()) {
					this.model.removeMobile(actualMobile.getPosition());
					this.model.addScore(20);
				}
			}
		}
	}
	public void moveAllMobile() {
		if(Lorann != null && Lorann.getNeedToMove()) {
			this.model.updatePosition(Lorann);
			Lorann.setNeedToMove(false);
			gifDelay = true;
		}
		else if(Lorann != null) {
			if(this.gifDelay) {
				gifDelay = false;
				Lorann.setDirection(Lorann.getDirection());
				Lorann.setImage(Lorann.getDirection());
			}
			else {
				Direction direction;
				if(Lorann.getDirection().ordinal() >= 7) {
					direction = Direction.UP;
				}
				else {
					direction = Direction.values()[Lorann.getDirection().ordinal() + 1];
				}
				Lorann.setDirection(direction);
				Lorann.setImage(direction);
			}
		}
		
		/**
		 * Missile movement
		 */
		
		if(Missile != null) {
			this.model.updatePosition(Missile);
			if(Missile.getPrivateAttribute() == 4) {
				Missile.setSprite(1);
				Missile.setPrivateAttribute(1);
			}
			else {
				Missile.setSprite(Missile.getPrivateAttribute() + 1);
				Missile.setPrivateAttribute(Missile.getPrivateAttribute() + 1);
			}
		}
		
		/**
		 * Enemies movement
		 */
		if(Demon != null) {
			IMobile actualMobile;
			for(int i=0; Demon.size() > i; i++) {
				actualMobile = (IMobile) Demon.toArray()[i];
				this.Demon.toArray()[i] = this.model.updatePosition(actualMobile);
			}
		}
	}
			
public void setView(IView viewSystem) {
	this.view = viewSystem;
}
}





