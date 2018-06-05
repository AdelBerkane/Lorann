package modelTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Sprite;

public class SpriteTest {


	Sprite sprite;
	private String c ="al";
	private String pathImage = "monster_1";
	
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
	 * We check if the variable 'c' get the sprite
	 */
	
	@Test
	public void testSprite(){
		this.sprite = new Sprite(c, this.pathImage);
		this.sprite = new Sprite(c);
	}
}

