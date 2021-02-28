package JUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CountClumpsTest {
	private ArrOperation newArrOperation;
	private int[] inputValues;
	private int outputValues;
	
	@Before
	public void initialize(){
		newArrOperation = new ArrOperation();
	}
	public CountClumpsTest(int[] inputValues, int outputValues) {
		this.inputValues = inputValues;
		this.outputValues = outputValues;
	}
	
	@Parameterized.Parameters
	public static Collection arrays(){
		return Arrays.asList(new Object[][] {{new int[]{1, 2, 2, 3, 4, 4}, 2},
				{new int[]{1, 1, 2, 1, 1}, 2}, {new int[]{1, 1, 1, 1, 1}, 1}, 
				{new int[]{-1, -1, 3, 2, -6, -6, 4}, 2}});
	}
	
	@Test
	public void testfindLargestMirror() {
		assertEquals(outputValues, newArrOperation.findNumberClumps(inputValues));
	}

}
