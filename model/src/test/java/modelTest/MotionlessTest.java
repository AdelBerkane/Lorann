package modelTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionlessTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * We declare a new position, a new sprite and a new permeability for the gate and test if it's a gate or not.
	 */

	@Test
	public void testIsGate(){
		IElement element = new Motionless(new Sprite("NN", "Nop"), Permeability.PENETRABLE, new Position(1,1));
		assertFalse(element.isGate());
	}
	
	/**
	 * We declare a new position, a new sprite and a new permeability for the crystalball and test if it's a crystalball or not.
	 */
	
	@Test
	public void testIsCrystaBall(){
		IElement element = new Motionless(new Sprite("NN", "Nop"), Permeability.PENETRABLE, new Position(1,1));
		assertFalse(element.isCrystaBall());
	}
	
	/**
	 * We declare a new position, a new sprite and a new permeability for the bone and test if it's a bone or not.
	 */
	
	@Test
	public void testIsBone(){
		IElement element = new Motionless(new Sprite("NN", "Nop"), Permeability.PENETRABLE, new Position(1,1));
		assertFalse(element.isBone());
	}
	
	/**
	 * We declare a new position, a new sprite and a new permeability for the purse and test if it's a purse or not.
	 */
	
	@Test
	public void testIsPurse(){
		IElement element = new Motionless(new Sprite("NN", "Nop"), Permeability.PENETRABLE, new Position(1,1));
		assertFalse(element.isPurse());
	}
	
}
