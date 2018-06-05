package view;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IModel;

public class GraphicsBuildTest {

	
	private IModel buildgraph;
	
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
	public void testGetGlobalWidth() {
		assertEquals(buildgraph.getWidth(), 10);
	}
	
	
	@Test
	public void getGlobalHeight() {
		assertEquals(buildgraph.getHeight(),10);
	}
}
