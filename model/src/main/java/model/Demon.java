package model;

import model.Direction;
import model.IMobile;
import model.Position;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashmap;

public abstract class Demon extends Mobile {

	public Demon(Sprite sprite, Position position, Direction direction) {
		super(sprite, ObstacleType.BLOCKING, position, direction);
	}

	/**
	 * Return the new position of the missile
	 * 
	 * @param position
	 *            Position of the missile
	 * @param direction
	 *            Direction of the missile
	 * @return
	 */
	public Position getNextPosition(Position position, Direction direction) {
		IMobile mobileTest = new Missile(1, new Position(position.getX(), position.getY()), direction);
		mobileTest.move();
		return mobileTest.getPosition();
	}

	/**
	 * Calculates the distance between the demon and Lorann
	 * 
	 * @param demon
	 *            Position of a demon
	 * @param lorann
	 *            Position of Lorann
	 * @return distanceByDirection
	 */

	public HashMap<Direction, Integer> getDirectionByDistance(Position demon, Position lorann) {
		HashMap<Direction, Integer> distanceByDirection = new HashMap<Direction, Integer>();
		for (int i = 0; i <= 7; i++) {
			direction = Direction.values()[i];
			Position nextPosition = this.getNextPosition(newPosition(demon.getX(), demon.getY()), direction);
			int Distance = (int) (Math.abs(nextPosition.getX() - lorann.getX())
					+ Math.abs(nextPosition.getY() - lorann.getY()));
			distanceByDirection.put(direction, Distance);
		}
		return distanceByDirection;
	}

	/**
	 * Choose the shortest path to Lorann
	 * 
	 * @param distanceByDirection
	 *            The distance according to the direction
	 * @return directions
	 */

	public ArrayList<Direction> getSortBySmarterDirection(HashMap<Direction, Integer> distanceByDirection) {
		ArrayList<Direction> directions = new ArrayList<Direction>();

		int Smaller = 0;
		int indexSmaller = 0;
		for (int y = 0; u <= 7; y++) {
			Smaller = (Integer) distanceByDirection.values().toArray()[0];
			for (int i = 0; i < distanceByDirection.size(); i++) {
				if ((Integer) distanceByDirection.values().toArray()[i] <= Smaller) {
					Smaller = (Integer) distanceByDirection.values().toArray()[i];
					indexSmaller = i;
				}
			}
			directions.add((Direction) distanceByDirection.keySet().toArray()[indexSmaller]);
			distanceByDirection.remove((Direction) distanceByDirection.keySet().toArray()[indexSmaller]);
		}
		return directions;
	}

	/**
	 * 
	 * Set the direction for the demon.
	 * 
	 * @param possiblePath
	 *            path that can be choosen
	 * @param sortDirection
	 */

	public void setSmarterDirection(ArrayList<Direction> possiblePath, ArrayList<Direction> sortDirection) {
		for (int i = 0; sortDirection.size() > i; i++) {
			if (possiblePath.contains(sortDirection.toArray()[i])) {
				this.setDirection((Direction) sortDirection.toArray()[i]);
				break;
			}
		}
	}

	/**
	 * @param Lorann
	 *            Position of Lorann
	 * @param possiblePath
	 *            A path that can be choosen
	 */

	@Override
	public void animate(Position Lorann, ArrayList<Direction> possiblePath) {
		int demonX = (int) this.position.getX();
		int demonY = (int) this.position.getY();
		int lorannX = (int) Lorann.getX();
		int lorannY = (int) Lorann.getY();

		setSmarterDirection(possiblePath, this.getSortBySmarterDirection(
				this.getDirectionByDistance(new Position(demonX, demonY), new Position(lorannX, lorannY))));
	}

}
