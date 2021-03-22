package JUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LargestMirrorTest {
	private ArrOperation newArrOperation;
	private int[] inputValues;
	private int outputValues;
	
	@Before
	public void initialize(){
		newArrOperation = new ArrOperation();
	}
	public LargestMirrorTest(int[] inputValues, int outputValues) {
		this.inputValues = inputValues;
		this.outputValues = outputValues;
	}
	
	@Parameterized.Parameters
	public static Collection arrays(){
		return Arrays.asList(new Object[][] {{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},
				{new int[]{7, 1, 4, 9, 7, 4, 1}, 2}, {new int[]{1, 2, 1, 4}, 3}, 
				{new int[]{1, 4, 5, 3, 5, 4, 1}, 7}});
	}
	
	@Test
	public void testfindLargestMirror() {
		assertEquals(outputValues, newArrOperation.findLargestMirror(inputValues));
	}

}
