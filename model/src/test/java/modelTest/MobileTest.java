package modelTest;

import org.junit.BeforeClass;

public class MobileTest {
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

	
	@Test
	public void testIsEnnemy(){
		
		assertFalse(new Lorann(Direction.UP, new Position(1,1)).isEnnemy());
	}
	
	@Test 
	public void testIsWeapon(){
		assertFalse(new Lorann(Direction.UP, new Position(1,1)).isWeapon());
	}
	
	@Test
	public void testMove(){
		IMobile mobile = new Lorann(Direction.UP, new Position(1,1));
		mobile.move();
		assertEquals((int) mobile.getPosition().getY(), 0);
		
		mobile.setDirection(Direction.DOWN);
		mobile.move();
		assertEquals((int) mobile.getPosition().getY(), 1);

		mobile.setDirection(Direction.LEFT);
		mobile.move();
		assertEquals((int) mobile.getPosition().getX(), 0);
		
		mobile.setDirection(Direction.RIGHT);
		mobile.move();
		assertEquals((int) mobile.getPosition().getX(), 1);
		
	}
}
