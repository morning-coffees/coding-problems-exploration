package main.shortest_path_v2;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String nodeName;
	Double currentShortestTravel;
	Node prevShortestTravelNode;
	List<Path> paths = new ArrayList<>();
	
	public Node(String nodeName, Double currentShortestTravel, Node prevShortestTravelNode) {
		this.nodeName = nodeName;
		this.prevShortestTravelNode = prevShortestTravelNode;
		this.currentShortestTravel = currentShortestTravel;
	}
	
	
	public void to(Node to, Integer distance) {
		Path p = new Path(this, to, distance);
		paths.add(p);
	}
}
