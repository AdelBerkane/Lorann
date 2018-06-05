package modelTest;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Direction;

import model.Position;
import model.Sprite;

public class DemonTest {
	
	
	Sprite sprite; 
	Position position;
	Direction direction ; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Add new directions for a monster and test if it takes the good direction.
	 */
	@Test
	public void testAnimate(){
		ArrayList<Direction> possiblePath = new ArrayList<Direction>();
		possiblePath.add(Direction.UP);
		possiblePath.add(Direction.RIGHT);
		this.monster.animate(new Position(0,0), possiblePath);
		assertEquals(this.monster.getDirection(), Direction.UP);
	}
	
	
	
}
