package AlgorithmAnalysis2;

import java.util.Comparator;

/*
 * class Edge containing starting position, ending position and weight of Edge
 */
public class Edge {
	
	public int start, end, weight;
	
	/*
	 * Constructor of Edge class
	 * @vertices1 starting value
	 * @vertices2 ending value
	 * @weight weight of edges
	 */
	public Edge(int vertices1, int vertices2, int weight) {
		this.start = vertices1;
		this.end = vertices2;
		this.weight = weight;
	}
	
	/*
	 * Method to get starting vertices
	 */
	public int getStart() {
		return this.start;
	}
	
	/*
	 * Method to get ending vertices
	 */
	public int getEnd() {
		return this.end;
	}
	
	/*
	 * Method to get weight between edge
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/*
	 * Method to sort by weightedSort
	 */
	public static final Comparator<Edge> weightedSort = new Comparator<Edge>() {

		public int compare(Edge edge1, Edge edge2) {
			return edge1.getWeight() - edge2.getWeight();
		}
	};
	
}
