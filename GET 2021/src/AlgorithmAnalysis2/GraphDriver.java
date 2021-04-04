package AlgorithmAnalysis2;

/*
 * Driver class to implement methods of graph
 */
public class GraphDriver {

	public static void main(String[] args) {
		GraphImplementation newGraphImplementation = new GraphImplementation(6);
		newGraphImplementation.addEdge(0, 1, 3);
		newGraphImplementation.addEdge(0, 2, 5);
		newGraphImplementation.addEdge(0, 3, 2);
		newGraphImplementation.addEdge(1, 2, 9);
		newGraphImplementation.addEdge(2, 3, 9);
		
		Integer[] resultReachable = newGraphImplementation.reachable(2);
		for(int i= 0; i < resultReachable.length; i++)
			System.out.print(resultReachable[i] + " ");
		
	}

}
