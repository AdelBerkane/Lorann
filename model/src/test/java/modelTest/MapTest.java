package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Map;

public class MapTest {
	
	Map map;
	int Width = 6;
	int Height = 2;
	

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * We declare and create a new map.
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
	
		map= new Map(this.Width, this.Height, "BBBBBHHVP12L");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * We check that the map that was instantiated is a map with a width of 6.
	 */

	@Test
	public void GetWidth() {
		assertEquals(this.map.getWidth(), 6);
	}
	
	
	@Test
	public void GetHeight () {
		assertEquals(this.map.getHeight(), 2);
	}
	
}
