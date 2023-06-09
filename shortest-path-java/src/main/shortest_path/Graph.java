package main.shortest_path;

import java.util.LinkedList;

import main.shortest_path.WeightedGraph.Edge;

public class Graph {
	int vertices;
	LinkedList<Edge>[] adjacencylist;
	Edge prev;
	Integer currentTravelsalWeight;

	Graph(int vertices) {
		this.vertices = vertices;
		adjacencylist = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencylist[i] = new LinkedList<>();
		}
	}

	public void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].addFirst(edge); // for directed graph
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			LinkedList<Edge> list = adjacencylist[i];
			for (int j = 0; j < list.size(); j++) {
				System.out.println("vertex-" + i + " is connected to " + list.get(j).destination + " with weight "
						+ list.get(j).weight);
			}
		}
	}

}
