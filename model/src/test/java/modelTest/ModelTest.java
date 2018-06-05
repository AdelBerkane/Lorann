package modelTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Map;

public class ModelTest {
	
	protected int Widht = 5;
	protected int Height = 15;
	protected int actualMap = 0;
	protected int score = 0;
	protected int resurection = 0;
	protected boolean gameWin = false;
	protected boolean gameLose = false;
	protected Map map;
	protected String mapLevel = "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	//@Test
	//public void testGetMessage() {
	//	Assert.assertEquals("", this.model.getMessage());
	//}

	/**
	 * Test method for {@link model.Model#loadMessage(java.lang.String)}.
	 */
	/*@Test
	public void testGetMessageString() {
		this.model.loadMessage("GB");
		Assert.assertEquals("Hello world", this.model.getMessage());
		this.model.loadMessage("FR");
		Assert.assertEquals("Bonjour le monde", this.model.getMessage());
		this.model.loadMessage("DE");
		Assert.assertEquals("Hallo Welt", this.model.getMessage());
		this.model.loadMessage("ID");
		Assert.assertEquals("Salamat pagi dunia", this.model.getMessage());
	}*/
	
	//@Test
	//public void testSaveVariable() {
		
		//try {
			//this.daoscore.saveScore(1000, 4, 2);
		//}catch(SQLException e){
			//assert(e.getMessage().contains("Connection refused"));
	//	}
	//}
	
	//@Test
	//public void testNewMap(){
	//	try {
	//		this.model.newMap(0);;
	//	}catch(SQLException e){
	///		assert(e.getMessage().contains("Connection refused"));
	//	}
	//}
	
	@Test
	public void testGetImageByPosition(){
		assertNull(this.model.getImageByPosition(-1, -1));
	}
	
	@Test
	public void testAddMissile(){
		assertNull(this.model.getMissile());
		this.model.addMissile(Direction.UP, new Position(1, 1));
		assertNotNull(this.model.getMissile());
	}
	
	@Test
	public void testRemoveMobile(){
		this.model.addMissile(Direction.UP, new Position(1,1));
		this.model.removeMobile(new Position(1,1));
		assertNull(this.model.getMissile());
		this.model.addMissile(Direction.UP, new Position(-1,-1));
	}
	
	@Test
	public void testGetNextPosition(){
		Position nextPos = this.model.getNextPosition(new Missile(1, new Position(0,0), Direction.RIGHT));
		Position pos = new Position(1,0);
		assertTrue( nextPos.getX() == pos.getX() && nextPos.getY() == pos.getY());
	}
	
	@Test
	public void testGetLorran(){
		assertNull(this.model.getLorran());
	}
	
	@Test
	public void testGetMissile(){
		assertNull(this.model.getMissile());
		this.model.addMissile(Direction.LEFT, new Position(1,1));
		assertNotNull(this.model.getMissile());
	}
	
	@Test
	public void testGetMonster(){
		assertNotNull(this.model.getMonster());
	}
	
	@Test
	public void testIsCollision(){
		assertNull(this.model.isCollision(new Monster1(new Position(-1, -1), Direction.UP)));
	}
	
	@Test
	public void testAddScore(){
		this.model.score = 0;
		this.model.addScore(10);
		assertEquals(this.model.getScore(), 10);
	}
	
	@Test
	public void testInitGame(){
		this.model.setGameWin(true);
		this.model.setGameLose(true);
		this.model.initGame();
		assertFalse(this.model.getGameLose());
		assertFalse(this.model.getGameWin());
	}

}
