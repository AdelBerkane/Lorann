package model;

import model.Direction;
import model.Position;

public class Map {

	public Elements elements[][];
	private final int width;
	private final int height;
	char map[][] = new char[6][21];

	/**
	 * Places the elemets according to their signs
	 * 
	 * @param width
	 *            width of the map
	 * @param height
	 *            height of the map
	 * @param mapLevel
	 *            map of the level
	 */

	public Map(final int width, final int height, String mapLevel) {
		this.width = width;
		this.height = height;
		this.elements = new Elements[this.getWidth()][this.getHeight()];

		int value = 0;
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				switch (mapLevel.charAt(value)) {
				case 'V':
					this.addElement(new Bone("vertical", new Position(x, y)), x, y);
					break;
				case 'B':
					this.addElement(new Bone("round", new Position(x, y)), x, y);
					break;
				case 'H':
					this.addElement(new Bone("horizontal", new Position(x, y)), x, y);
					break;
				case 'P':
					this.addElement(new Purse(new Position(x, y)), x, y);
					break;
				case 'L':
					this.addElement(new Lorann(Direction.UP, new Position(x, y)), x, y);
					break;
				case '1':
					this.addElement(new Demon1(new Position(x, y), Direction.UP), x, y);
					break;
				case '2':
					this.addElement(new Demon2(new Position(x, y), Direction.UP), x, y);
					break;
				case '3':
					this.addElement(new Demon3(new Position(x, y), Direction.UP), x, y);
					break;
				case '4':
					this.addElement(new Demon4(new Position(x, y), Direction.UP), x, y);
					break;
				case 'D':
					this.addElement(new Gate("closed", new Position(x, y)), x, y);
					break;
				case 'O':
					this.addElement(new Gate("open", new Position(x, y)), x, y);
					break;
				case 'C':
					this.addElement(new Crystallball(new Position(x, y)), x, y);
					break;
				default:
					break;
				}
				value++;
			}
		}
	}

	/**
	 * 
	 * @return the width
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	public Elements[][] getAllElements() {
		return this.elements;
	}

	public Elements getElements(final int x, final int y) {
		if ((x < 0 || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight()))) {
			return null;
		}
		return this.elements[x][y];
	}

	/**
	 * sets 'element' to the value of element.
	 * 
	 * @param element
	 *            the element
	 * @param x
	 *            coordinate x
	 * @param y
	 *            coordinate y
	 */

	public void addElement(final Elements element, final int x, final int y) {
		this.elements[x][y] = element;
	}

}
