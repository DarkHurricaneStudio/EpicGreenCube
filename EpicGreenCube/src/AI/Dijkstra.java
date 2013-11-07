package AI;

import java.util.ArrayList;

public class Dijkstra {

	public static ArrayList<Node> computePath(Node start, Node goal) {
		
		ArrayList<DijNode> openList = new ArrayList<DijNode>();
		ArrayList<DijNode> closedList = new ArrayList<DijNode>();
		ArrayList<Node> path = new ArrayList<Node>();
		boolean end = false;
		
		//we add the start as the first position
		path.add(0,start);
		
		// we had all the neighbors of the start to the open list
		for (Node node:start.getNeighbors()) {
			DijNode dNode = (DijNode) node;
			dNode.setDistance(start.distanceTo(dNode));
			dNode.setParent((DijNode) start);
			openList.add(dNode);
			
		}
		
		// now that we have the base, we check if there is no more ndoes to check or we have finally succed to find the goal
		while (openList.size() != 0 || end) {
			// we take the nearest node from the open list and had it to the close list
			DijNode node = new DijNode(0,0,0);
			node.setDistance(99999999);
			for(DijNode n:openList) {
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
				// we have to take all the aprents until we join the start
				// TODO !
			
			} else {
				// we had all neighbors that are not in the closed list
				for (Node n:node.getNeighbors()) {
					DijNode dn = (DijNode) n;
					if (!closedList.contains(dn)) {
						dn.setDistance(dn.getDistance()+node.distanceTo(dn));
						dn.setParent(node);
						openList.add(dn);
					}
				}
			}
		}
		
		return null;
	}
}
