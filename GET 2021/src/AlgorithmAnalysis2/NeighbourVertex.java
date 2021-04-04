package AlgorithmAnalysis2;

public class NeighbourVertex {
	
	public int vertices, weight;
	
	public NeighbourVertex(int verticesValue, int weightValue) {
		this.vertices = verticesValue;
		this.weight = weightValue;
	}
	
	public int getNeighbourVertex() {
		return this.vertices;
	}
	
	public int getNeighbourWeight() {
		return this.weight;
	}
}
