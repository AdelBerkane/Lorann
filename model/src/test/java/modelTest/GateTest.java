package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Gate;
import model.ObstacleType;
import model.Position;

public class GateTest {
	/**
	 * The test GateTest
	 */

		Gate gate;
		protected String state ="open";
		Position position;
		

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
		
		/**
		 * We declare a new position and we instantiate a new gate
		 * 
		 * @throws Exception
		 */

		@Before
		public void setUp() throws Exception {
			position = new Position(2,2);
			gate = new Gate(this.state, this.position);
		}

		@After
		public void tearDown() throws Exception {
		}
		
		/**
		 * We verified that the gate that was instantiated is a gate
		 * If true works it's a gate and if true doesn't work it's not a gate
		 */

		@Test
		public void testIsGate() {
			assertEquals(gate.isGate(), true);
		}

	}

		
		
		


