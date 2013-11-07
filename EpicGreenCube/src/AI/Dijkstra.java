package AI;

import java.util.ArrayList;

public class Dijkstra {

	public static ArrayList<Node> computePath(Node start, Node goal) {
		
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closedList = new ArrayList<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		boolean end = false;
		
		//we add the start as the first position
		path.add(0,start);
		
		// we had all the neighbors of the start to the open list
		for (Node n:start.getNeighbors()) {
			n.setDistance(start.distanceTo(n));
			n.setParent(start);
			openList.add(n);
			
		}
		
		// now that we have the base, we check if there is no more ndoes to check or we have finally succed to find the goal
		while (openList.size() != 0 || end) {
			// we take the nearest node from the open list and had it to the close list
			Node node = new Node(0,0,0);
			node.setDistance(99999999);
			for(Node n:openList) {
				if (n.getDistance() <= node.getDistance())
					node = n;
			}
			// we now have the nearest node
			openList.remove(node);
			closedList.add(node);
			
			// is it the goal ?
			if (node == goal) {
				// Yeah ! We found it !
				end = true;
				// we have to take all the parents until we join the start
				// TODO !
			
			} else {
				// we had all neighbors that are not in the closed list
				for (Node n:node.getNeighbors()) {
					if (!closedList.contains(n)) {
						n.setDistance(n.getDistance()+node.distanceTo(n));
						n.setParent(node);
						openList.add(n);
					}
				}
			}
		}
		
		return null;
	}
}
