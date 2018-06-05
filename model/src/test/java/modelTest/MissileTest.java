package modelTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IMobile;

public class MissileTest {
	IMobile missile;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public void testSetSprite(){
		//TODO
		//Don't know how to catch the exception without display in console
	}
	
	@Test public void testIsWeapon(){
		assertTrue(this.missile.isWeapon());
	}

	
	/**
	 * Test if the missile is considered as a weapon in isWeapon.
	 */

}
