//controllerTest


package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.Direction;
import contract.IMobile;
import contract.IViewSystem;
import contract.Position;
import model.Model;

public class ControllerTest {
	Controller controller;
	Model model;
	IViewSystem viewSystem;
	IMobile lorann;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new Model(20, 12);
		controller = new Controller(model);
		controller.getLorran();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMoveAllMobile(){
		//mettre en place une situation et vérifier que les positions ont bien chagner
		Position lorannPosition = this.model.getLorran().getPosition();
		this.model.getLorran().setDirection(Direction.RIGHT);
		this.controller.moveAllMobile();
		assertEquals((int) lorannPosition.getX(),(int) this.model.getLorran().getPosition().getX());
		assertEquals((int) lorannPosition.getY(), (int) this.model.getLorran().getPosition().getY());
	}
	
	@Test
	public void testCheckHitMobile(){
		this.model.getLorran().setHit(true);
		this.controller.checkHitMobile();
		assertTrue(this.model.getGameLose());
	}
	
	@Test
	public final void testEndUserOrder() {
		assertFalse(this.controller.endUserOrder(ControllerOrder.QUIT));
		assertTrue(this.controller.endUserOrder(ControllerOrder.AGAIN));
		assertTrue(this.controller.endUserOrder(ControllerOrder.LEVEL1));
		assertTrue(this.controller.endUserOrder(ControllerOrder.LEVEL2));
		assertTrue(this.controller.endUserOrder(ControllerOrder.LEVEL3));
		assertTrue(this.controller.endUserOrder(ControllerOrder.LEVEL4));
		assertTrue(this.controller.endUserOrder(ControllerOrder.LEVEL5));
		assertFalse(this.controller.endUserOrder(ControllerOrder.DIAG_DOWN_LEFT));
		assertFalse(this.controller.endUserOrder(null));
	}
	
	@Test
	public final void testLaunchMissile() {
		this.controller.launchMissile();
		assertNull(this.model.getMissile());
		this.model.addMissile(Direction.DOWN, new Position(1,1));
		assertEquals(this.model.getMissile().getDirection(), Direction.DOWN);
	}

}
