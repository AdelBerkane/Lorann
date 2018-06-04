package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Direction;
import model.IMobile;
import model.IModel;
import model.Position;

public class Model extends Observable implements IModel {

	private ArrayList<IMobile> mobiles = new ArrayList<IMobile>();
	public ArrayList<Elements> ListElements = new ArrayList<Elements>();
	public Elements elements[][];
	protected int Width = 20;
	protected int Height = 5;
	protected int actualMap = 0;
	protected int score = 0;
	protected int resurection = 0;
	protected boolean gameWin = false;
	protected boolean gameLose = false;
	protected Map map;
	protected String mapLevel = "";

	/**
	 * Sets width, height, and instanciates the array of element.
	 * 
	 * @param Width
	 * @param Height
	 * @throws SQLException
	 */
	public Model(int Width, int Height) throws SQLException {
		this.Width = Width;
		this.Height = Height;
		this.elements = new Elements[this.Height][this.Width];

	}

	/**
	 * Adds a missile to the game on the given position
	 * 
	 * @param direction
	 * @param position
	 */

	public void addMissile(Direction direction, Position position) {
		if (!((position.getX() < 0) || (position.getY() < 0) || (position.getX() >= this.getWidth())
				|| (position.getY() >= this.getHeight())))
			this.elements[(int) position.getX()][(int) position.getY()] = new Missile(1, position, direction);
	}

	/**
	 * removes a mobile from the map.
	 */

	public void removeMobile(Position position) {
		this.elements[(int) position.getX()][(int) position.getY()] = null;
	}

	/**
	 * return all the mobile on the game
	 */

	public ArrayList<IMobile> getMobiles() {
		return mobiles;
	}

	/**
	 * notifies observer who allows the view to be refreshed
	 */

	public void setMobilesHaveMoved() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * @returns Observable
	 */

	public Observable getObservable() {
		return null;
	}

	/**
	 * get the next position of a mobile
	 * 
	 * @param IMobile
	 *            mobile
	 * @return Position
	 */

	public Position getNextPosition(IMobile mobile) {
		IMobile mobileTest = new Missile(1, new Position(mobile.getPosition().getX(), mobile.getPosition().getY()),
				mobile.getDirection());
		mobileTest.move();
		return mobileTest.getPosition();
	}

	/**
	 * return the global height.
	 * 
	 * @return int
	 */

	public int getHeight() {
		return this.Height;
	}

	public int getWidth() {
		return this.Width;
	}

	/**
	 * Returns the hero if found
	 * 
	 * @return IMobile
	 */

	public IMobile getLorann() {
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (elements[x][y] instanceof Lorann) {
					return (IMobile) elements[x][y];
				}
			}
		}
		return null;
	}

	/**
	 * Returns the missile if found
	 */

	public IMobile getMissile() {
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (elements[x][y] instanceof Missile) {
					return (IMobile) elements[x][y];
				}
			}
		}
		return null;
	}

	/**
	 * Returns all the demons present in the game
	 */
	public ArrayList<IMobile> getDemon() {
		ArrayList<IMobile> mobiles = new ArrayList<IMobile>();
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (elements[x][y] instanceof Demon) {
					mobiles.add((IMobile) elements[x][y]);
				}
			}
		}
		return mobiles;
	}

	public void moveMobile(IMobile mobile) {
		this.removeMobile(mobile.getPosition());
		mobile.move();
		this.elements[(int) mobile.getPosition().getX()][(int) mobile.getPosition().getY()] = (Elements) mobile;
		IMobile mobiles = (IMobile) this.elements[(int) mobile.getPosition().getX()][(int) mobile.getPosition().getY()];
		mobiles.setLastDirection(mobile.getDirection());
		if (mobiles instanceof Lorann)
			mobiles.setNeedToMove(false);
	}

	/**
	 * turn the gate to the status open
	 */

	private void openGate() {
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				if (elements[x][y] instanceof Gate) {
					elements[x][y] = new Gate("open", new Position(x, y));
					break;
				}
			}
		}
	}

	/**
	 * Update the position with managed collision of the mobile given.
	 * 
	 * @param mobile
	 * @return IMobile
	 */

	public IMobile updatePosition(IMobile mobile) {
		/**
		 * Lorann collision
		 */
		if (mobile instanceof Lorann) {
			Elements element = isCollision(mobile);
			if (element != null) {
				if (element instanceof Demon) {
					mobile.setHit(true);
					this.gameLose = true;
				} else if (element instanceof Purse) {
					this.addScore(650);
					this.moveMobile(mobile);
				} else if (element instanceof Gate) {
					if (((Gate) element).open) {
						this.gameWin = true;
						this.moveMobile(mobile);
					} else {
						mobile.setHit(true);
						this.gameLose = true;
					}
				} else if (element instanceof Crystallball) {
					this.moveMobile(mobile);
					this.openGate();
				}

			} else {
				this.moveMobile(mobile);
			}
		}
		/**
		 * Missile collision
		 */

		else if (mobile instanceof Missile) {
			Elements element = isCollision(mobile);
			if (element != null) {
				if (element instanceof Lorann) {
					mobile.setHit(true);
				} else if (element instanceof Demon) {
					mobile.setHit(true);
					((Demon) element).setHit(true);
				} else
					mobile.animate();
			} else {
				this.moveMobile(mobile);
			}
		}
		/**
		 * Demon collision
		 */
		else {

			Elements element = isCollision(mobile);

			if (element != null) {
				if (element instanceof Lorann) {
					((Lorann) element).setHit(true);
					this.gameLose = true;
				} else if (element instanceof Missile) {
					mobile.setHit(true);
					((Missile) element).setHit(true);
				} else if (element instanceof Demon) {
					ArrayList<Direction> possiblePath = new ArrayList<Direction>();
					possiblePath = this.getPossiblePath(mobile);
					if (!possiblePath.isEmpty()) {
						mobile.setDirection((Direction) possiblePath.toArray()[0]);
						this.moveMobile(mobile);
					}
				} else {
					ArrayList<Direction> possiblePath = new ArrayList<Direction>();
					Direction direction = null;
					direction = mobile.getDirection();
					possiblePath = this.getPossiblePath(mobile);
					mobile.setDirection(direction);
					if (!possiblePath.isEmpty()) {
						if (this.getLorann() != null && mobile.getNeedToMove()) {
							mobile.animate(this.getLorann().getPosition(), possiblePath);
						} else {
							mobile.animate();
						}
						if (this.isCollision(mobile) == null)
							this.moveMobile(mobile);
					}
				}
			} else {
				if (mobile instanceof Demon2 && mobile.getNeedToMove()) {
					ArrayList<Direction> possiblePath = new ArrayList<Direction>();
					possiblePath = this.getPossiblePath(mobile);
					if (this.getLorann() != null)
						mobile.animate(this.getLorann().getPosition(), possiblePath);
				}
				if (this.getLorann() != null && !this.getLorann().getHit() && isCollision(mobile) == null) {
					if (!this.isCollisionAdvanced(mobile))
						this.moveMobile(mobile);
					else {
						mobile.animate();
						this.moveMobile(mobile);
					}
				}
			}
		}
		return mobile;
	}

	private boolean isCollisionAdvanced(IMobile mobile) {
		ArrayList<IMobile> Demon1 = this.getDemon();
		if (Demon1.size() > 1) {
			ArrayList<Position> allNextPosition1 = new ArrayList<Position>();
			IMobile actualMobile = null;

			/**
			 * Stores all of the next position
			 */

			for (int i = 0; Demon1.size() > i; i++) {
				actualMobile = (IMobile) Demon1.toArray()[i];
				if (actualMobile != mobile)
					allNextPosition1.add(this.getNextPosition(mobile));
			}

			/**
			 * Compares all of the positions
			 */

			for (int y = 0; allNextPosition1.size() > y; y++) {
				Position position2 = (Position) allNextPosition1.toArray()[y];
				Position position1 = this.getNextPosition(mobile);
				if (position1.getX() == position2.getX() && position2.getY() == position1.getY()) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Returns all the possible Path of a mobile. All the directions where the
	 * mobile can go.
	 * 
	 * @param mobile
	 * @return ArrayList<Direction>
	 */
	private ArrayList<Direction> getPossiblePath(IMobile mobile) {
		ArrayList<Direction> possiblePath = new ArrayList<Direction>();

		for (int i = 0; i <= 7; i++) {
			mobile.setDirection(Direction.values()[i]);
			Elements collision = null;
			collision = isCollision(mobile);
			if (collision == null || collision instanceof Lorann)
				possiblePath.add(mobile.getDirection());
		}
		return possiblePath;
	}

	/**
	 * Detects if the mobile can be in collision and returns the element in
	 * collision if there are none
	 * 
	 * @param mobile
	 * @return
	 */

	public Elements isCollision(IMobile mobile) {
		Position position = this.getNextPosition(mobile);
		if (!((mobile.getPosition().getX() < 0) || (mobile.getPosition().getY() < 0)
				|| (mobile.getPosition().getX() >= this.getWidth())
				|| (mobile.getPosition().getY() >= this.getHeight()))) {
			if (position.getY() < 0 || position.getX() < 0 || position.getX() >= this.getWidth()
					|| position.getY() >= this.getHeight()) {
				return new Bone("horizontal", position);
			} else if (!(this.elements[(int) position.getX()][(int) position.getY()] instanceof Elements != true)) {
				return this.elements[(int) position.getX()][(int) position.getY()];
			}
		}
		return null;
	}

	public void addScore(int addValue) {
		this.score += addValue;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getResurection() {
		return this.resurection;
	}
<<<<<<< HEAD
=======

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
>>>>>>> 6514dbce8a3defebf0ccd19610abe4fb20dba213

	public void setResurection(int value) {
		this.resurection = value;
	}

	public boolean getGameWin() {
		return this.gameWin;
	}

	public boolean getGameLose() {
		return this.gameLose;
	}

	/**
	 * Sets all the variables to 0, and sets one possible direction to all the
	 * present demons
	 */
	public void initGame() {
		this.gameLose = false;
		this.gameWin = false;
		ArrayList<IMobile> Monsters = this.getDemon();
		IMobile actualMobile;
		for (int i = 0; Monsters.size() > i; i++) {
			actualMobile = (IMobile) Monsters.toArray()[i];
			actualMobile.setDirection((Direction) this.getPossiblePath(actualMobile).toArray()[0]);
			actualMobile.setNeedToMove(false);
		}
	}

	public void setGameWin(boolean state) {
		this.gameWin = state;
	}

	public void setGameLose(boolean state) {
		this.gameLose = state;
	}
}
