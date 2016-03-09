package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.*;

import org.junit.*;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.impl.DefaultStock;

public class DefaultStockTest {
	
	
	// define dummy vars
	
	private String name = "default";
	private Stock stock; 
	
	@Before
	public void setUp() throws Exception {
		
		// init test object
		this.stock = new DefaultStock(name);
		
	}
	
	@Test
	public void testName()
	{
		// check name is correct
		assertEquals("Expecting 'default'.", name, stock.getName());
	}
	
	// preform teardown
	@After
	public void tearDown(){
		stock = null; 
		name = null;
	}
}
