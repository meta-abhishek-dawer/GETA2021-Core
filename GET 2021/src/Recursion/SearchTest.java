package Recursion;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class SearchTest {
	private Search newSearch;

	
	@Before
	public void initialize(){
		newSearch = new Search();
	}
	
	
	@Test
	public void testLinear() {
		assertEquals(2, newSearch.linearSearch(new int[]{1,  2,  3,  4, 5}, 0, 4,3));
	}
	@Test
	public void testBinary(){
		assertEquals(2, newSearch.binarySearch(new int[]{1,  2,  3,  4, 5}, 0, 4,3));
	}
}
