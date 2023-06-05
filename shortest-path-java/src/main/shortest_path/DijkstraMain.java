package main.shortest_path;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import main.shortest_path.WeightedGraph.Edge;

public class DijkstraMain {

//	static Map<Integer, Integer> distanceRecorder = new HashMap<>(); 
	
	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEgde(0, 1, 4);
		graph.addEgde(0, 2, 3);
		graph.addEgde(1, 3, 2);
		graph.addEgde(1, 2, 5);
		graph.addEgde(2, 3, 7);
		graph.addEgde(3, 4, 2);
		graph.addEgde(4, 0, 4);
		graph.addEgde(4, 1, 4);
		graph.addEgde(4, 5, 6);
		graph.printGraph();

		int from = 0;
		int to = 3;
		graph.printGraph();
		System.out.println("++++++++++++++++++++++++++++++++++++");
		LinkedList<Edge> initialEdges = graph.adjacencylist[from];
		start(from, to, graph);
	}
	
	private static void start(int from, int to, Graph graph) {
		LinkedList<Edge> initialEdges = graph.adjacencylist[from];
		if(from == to) {
			return;
		}
		for (int j = 0; j < initialEdges.size(); j++) {
			Edge current = initialEdges.get(j);
			System.out.println("+vertex-" + from + " is connected to " + current.destination + " with weight "
					+ current.weight);
			if(from == current.source) {
				current.currentTravelsalWeight = 0 + current.weight;
			}
			start(current.destination, to, graph);
		}
	}
	
//	private static void recordDistance(int currentTraversed, int weight) {
//		Integer value = distanceRecorder.get(currentTraversed);
//		if (value != null && ) {
//			if()
//			distanceRecorder.put(currentTraversed, value + weight)
//		} else {
//		    // No such key
//		}
//	}

}
