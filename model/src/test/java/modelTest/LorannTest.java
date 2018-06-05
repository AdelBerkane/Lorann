package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Direction;
import model.Lorann;

import model.Position;

public class LorannTest {
	Direction direction; 
	Position position ;
	Lorann lorann;
	
	
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
	public void testGetWin() {
		assertEquals(lorann.getWin(), false);
	}



	

}
