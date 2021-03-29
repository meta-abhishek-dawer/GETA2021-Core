package Recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathematicOperationsTest {
	private MathematicOperations newLcmHcf;
	
	@Before
	public void initialize(){
		newLcmHcf = new MathematicOperations();
	}		
	@Test
	public void testLcm() {
		assertEquals(0, newLcmHcf.findLCM(100, 0));
	}
	@Test
	public void testHcf(){
		assertEquals(6, newLcmHcf.findHCF(366,60));
	}
	
}
