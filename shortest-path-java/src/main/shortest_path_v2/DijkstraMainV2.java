package main.shortest_path_v2;

public class DijkstraMainV2 {

	public static void main(String[] args) {
		Node n1 = new Node("N1", null, null);
		Node n2 = new Node("N2", null, null);
		Node n3 = new Node("N3", null, null);
		Node n4 = new Node("N4", null, null);
		Node n5 = new Node("N5", null, null);
		Node n6 = new Node("N6", null, null);
		Node n7 = new Node("N7", null, null);
		
		n1.to(n2, 4);
		n1.to(n3, 2);
		n2.to(n3, 7);
		n2.to(n4, 5);
		n2.to(n6, 9);
		n3.to(n6, 1);
		n3.to(n6, 1);
		n3.to(n5, 100);
		n6.to(n7, 1);
		n6.to(n5, 1);

		start(n1, n5);
		display(n5);
	}

	public static void display(Node node) {
		System.out.println(node.nodeName + " - " + node.currentShortestTravel);
		if(node.prevShortestTravelNode != null) {
			display(node.prevShortestTravelNode);			
		}
	}
	
	public static void start(Node from, Node to) {
		if(from.equals(to)) {
			return;
		}
		from.paths.forEach((path) -> {
			Double previousShortest = path.from.currentShortestTravel;
			Double currentShortest = path.to.currentShortestTravel;
			if(previousShortest == null) {
				path.from.currentShortestTravel = 0d;
				previousShortest = 0d;
			}
			if(currentShortest == null) {
				currentShortest = Double.POSITIVE_INFINITY;
			}
//			if(currentShortest == null) {
//				path.to.currentShortestTravel = path.distance;
//				path.to.prevShortestTravelNode = path.from;
//			} else if(previousShortest == null) {
//				path.to.currentShortestTravel = path.distance;
//				path.to.prevShortestTravelNode = path.from;
//			} else 
			if (previousShortest + path.distance < currentShortest ) {
				path.to.currentShortestTravel = previousShortest + path.distance;
				path.to.prevShortestTravelNode = path.from;
			}

//			System.out.println(path.to.nodeName + " - " + path.to.currentShortestTravel);
			start(path.to, to);
		});
	}
}
