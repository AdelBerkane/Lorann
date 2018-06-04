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
	
	public void getLorann() {
		this.Lorann=this.model.getLorann();	}
}




}
