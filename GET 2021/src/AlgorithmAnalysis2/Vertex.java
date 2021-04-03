package AlgorithmAnalysis2;

import java.util.ArrayList;

public class Vertex {
	
	public ArrayList<NeighbourVertex> neighboursList = new ArrayList<>();
	
	public void addNeighbour(int vertices, int weight) {
		NeighbourVertex newNeighbourVertex = new NeighbourVertex(vertices, weight);
		this.neighboursList.add(newNeighbourVertex);
	}
	
	public ArrayList<NeighbourVertex> getNeighbours() {
		return this.neighboursList;
	}
}
