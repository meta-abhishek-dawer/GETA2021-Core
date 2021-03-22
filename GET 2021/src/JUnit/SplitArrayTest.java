package JUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	private ArrOperation newArrOperation;
	private int[] inputValues;
	private int outputValues;
	
	@Before
	public void initialize(){
		newArrOperation = new ArrOperation();
	}
	public SplitArrayTest(int[] inputValues, int outputValues) {
		this.inputValues = inputValues;
		this.outputValues = outputValues;
	}
	
	@Parameterized.Parameters
	public static Collection arrays(){
		return Arrays.asList(new Object[][] {{new int[]{1, 1, 1, 2, 1}, 3},
				{new int[]{2, 1, 1, 2, 1}, -1}, {new int[]{10, 10,}, 1}, 
				{new int[]{4, 1, 2, 6}, -1}});
	}
	
	@Test
	public void testfindLargestMirror() {
		assertEquals(outputValues, newArrOperation.findIndexSplitArray(inputValues));
	}

}
