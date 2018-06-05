package modelTest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Crystallball;

public class CrystallballTest extends {
	protected CrystalBall crystalBall;
	protected Position position;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * We declares a new position and we instantiate a new crystal ball
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		position = new Position(2,2);
		crystalBall = new CrystalBall(position);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * We verified that the crystal ball that was instantiated is a crystal ball
	 * If true works it's a crystal ball and if true doesn't work it's not a crystal ball
	 */

	
	@Test
	public void testIsCrystalBall() {

		assertEquals(Crystallball.isCrystalBall(), true);
	}

}


	

}
