package Recursion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class QueenProblemTest {
	private QueenProblem newQueenProblem;
	private int[][] inputValues;
	private boolean outputValues;
	
	@Before
	public void initialize(){
		newQueenProblem = new QueenProblem();
	}
	public QueenProblemTest(int[][] inputValues, boolean outputValues) {
		this.inputValues = inputValues;
		this.outputValues = outputValues;
	}
	
	@Parameterized.Parameters
	public static Collection arrays(){
		return Arrays.asList(new Object[][] {{new int[][]{{0, 0}, {0, 0}}, false},
				{new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, true}});
	}
	
	@Test
	public void testNQueens() {
		assertEquals(outputValues, newQueenProblem.nQueens(inputValues, 0, inputValues.length));
	}

}