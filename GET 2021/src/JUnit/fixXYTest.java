package JUnit;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class fixXYTest {
	private ArrOperation newArrOperation;
	private int[] inputValues;
	private int[] outputValues;
	
	@Before
	public void initialize(){
		newArrOperation = new ArrOperation();
	}
	public fixXYTest(int[] inputValues, int[] outputValues) {
		this.inputValues = inputValues;
		this.outputValues = outputValues;
	}
	
	@Parameterized.Parameters
	public static Collection arrays(){
		return Arrays.asList(new Object[][] {{new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}},
				{new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}},
				{new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}}});
	}
	
	@Test
	public void testfixXY() {
		assertArrayEquals(outputValues, newArrOperation.fixXY(inputValues, 4, 5));
	}
	

}
