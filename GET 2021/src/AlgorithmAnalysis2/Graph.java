package AlgorithmAnalysis2;

import java.util.ArrayList;

public interface Graph {
	
	boolean isConnected();
	Integer[] reachable(int vertices);
	ArrayList<Edge> mst();
	int shortestPath(int start, int end);
}
