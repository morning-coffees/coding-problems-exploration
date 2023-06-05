package main.shortest_path_v2;

public class Path {
	Node from;
	Node to;
	Integer distance;
	
	public Path(Node from, Node to, Integer distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
}