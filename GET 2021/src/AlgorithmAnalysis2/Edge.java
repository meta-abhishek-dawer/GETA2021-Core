package AlgorithmAnalysis2;

import java.util.Comparator;

public class Edge {
	
	public int start, end, weight;
	
	public Edge(int vertices1, int vertices2, int weight) {
		this.start = vertices1;
		this.end = vertices2;
		this.weight = weight;
	}
	
	public int getStart() {
		return this.start;
	}
	
	public int getEnd() {
		return this.end;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public static final Comparator<Edge> weightedSort = new Comparator<Edge>() {

		public int compare(Edge edge1, Edge edge2) {
			return edge1.getWeight() - edge2.getWeight();
		}
	};
	
}
