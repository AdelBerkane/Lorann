package modelTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Position;

public class BoneTest {
	
	
	public void Bone(String orientation, Position position) {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * We declare a new position and we instantiate a new bone
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		Position position = new Position(2,2);
		Object orientation;
		bo = new Bone(orientation, position);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * We verified that the bone that was instantiated is a bone
	 * If true works it's a bone and if true doesn't work it's not a bone
	 */

	@Test
	public void testIsBone() {
		assertEquals(bo.isBone(), true);
	}
}
