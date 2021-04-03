package AlgorithmAnalysis2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.sound.sampled.ReverbType;

public class GraphImplementation {

	public int numberOfVertices;
	public Vertex[] vertices;
	public LinkedList<Edge> edgeList;
	public Edge edge;
	
	public GraphImplementation(int noOfVertices) {
		this.numberOfVertices = noOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();
		for(int i= 0; i< numberOfVertices; i++) {
			vertices[i] = new Vertex();
		}
	}
	
	public void addEdge(int start, int end, int value) {
		edgeList.add(new Edge(start, end, value));
		vertices[start].addNeighbour(end, value);
		vertices[end].addNeighbour(start, end);
	}
	
	public LinkedList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void numberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}
	
	public int getNumberOfVertices() {
		return this.numberOfVertices;
	}
	
	public boolean isConnected() {
		if(this.numberOfVertices <= 0)
			return false;
		return this.DFS(0).size() == this.getNumberOfVertices();
	}
	
	public HashSet<Integer> DFS(int start) {
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int vertices = stack.pop();
			if(visited.contains(vertices))
				continue;
			visited.add(vertices);
			for(NeighbourVertex newNeighbourVertex : this.vertices[vertices].getNeighbours())
				stack.push(newNeighbourVertex.getNeighbourVertex());
		}
		return visited;
	}
	
	public Integer[] reachable(int vertices) {
		HashSet<Integer> visited = this.DFS(vertices);
		Integer[] result = visited.toArray(new Integer[0]);
		Arrays.sort(result);
		return result;
	}
	
	public ArrayList<Edge> mst() {
		ArrayList<Edge> mstResult = new ArrayList<>();
		Collections.sort(this.edgeList, Edge.weightedSort);
		HashMap<Integer, Integer> previousVertices = new HashMap<>();
		for(int i= 0; i < numberOfVertices; i++)
			previousVertices.put(i, i);
		int i= 0;
		for(Edge edge:  this.getEdgeList()) {
			if(i> this.getNumberOfVertices() -1) 
				break;
			else if(!isCycle(previousVertices, edge.getStart(), edge.getEnd()))
				mstResult.add(edge);
		}
		return mstResult;
	}
	
	public boolean isCycle(HashMap<Integer, Integer> previousVertices, int start, int end) {
		int previous1 = previous(previousVertices, start);
		int previous2 = previous(previousVertices, end);
		if(previous1 == previous2)
			return true;
		previousVertices.put(previous1, previous2);
		return false;
	}
	
	public int previous(HashMap<Integer, Integer> previousVertices, int vertex) {
		while(previousVertices.get(vertex)!= vertex)
			vertex = previousVertices.get(vertex);
		return vertex;
	}
	
	public int shortestPath(int start, int end) {
		int[] distance = this.dijkastra(start);
		return distance[end];
	}
	
	public int[] dijkastra(int start) {
		int[] result = new int[this.getNumberOfVertices()];
		for(int i= 0; i< this.getNumberOfVertices(); i++)
			result[i] = Integer.MAX_VALUE;
		HashSet<Integer> visited = new HashSet<>();
		result[start] = 0;
		PriorityQueue<Pair> newPriorityQueue = new PriorityQueue<Pair>(this.getNumberOfVertices(), Pair.pairSortedWeight);
		newPriorityQueue.add(new Pair(0, start));
		while(!newPriorityQueue.isEmpty()) {
			Pair pair = newPriorityQueue.peek();
			newPriorityQueue.remove();
			if(visited.contains(pair.getVertices())) 
				continue;
			visited.add(pair.getVertices());
			for(NeighbourVertex newNeighbourVertex : this.vertices[pair.getVertices()].getNeighbours()) {
				if(result[newNeighbourVertex.getNeighbourVertex()]> result[pair.getVertices()] + newNeighbourVertex.getNeighbourWeight()) {
					newPriorityQueue.add(new Pair(result[newNeighbourVertex.getNeighbourVertex()], newNeighbourVertex.getNeighbourVertex()));
				}
			}
		}
		return result;
	}
}
