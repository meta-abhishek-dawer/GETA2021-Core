package Recursion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class LcmHcfTest {
	private LcmHcf newLcmHcf;

	
	@Before
	public void initialize(){
		newLcmHcf = new LcmHcf();
	}
	
	
	@Test
	public void testLcm() {
		assertEquals(64, newLcmHcf.findLCM(4, 64));
	}
	@Test
	public void testHcf(){
		assertEquals(6, newLcmHcf.findHCF(366,60));
	}
	

}
