package AlgorithmAnalysis2;

import java.util.Comparator;

public class Pair {

	public int vertices, weight;
	
	public Pair(int weightValue, int verticesValue) {
		this.weight = weightValue;
		this.vertices = verticesValue;
	}
	
	public int getVertices() {
		return this.vertices;
	}
	
	public int getWeight() {
		return this.weight;
	}

	public static final Comparator<Pair> pairSortedWeight = new Comparator<Pair>() {

		public int compare(Pair pair1, Pair pair2) {
			return pair1.getWeight() - pair2.getWeight(); 
		}
		
	}; 
	
}
