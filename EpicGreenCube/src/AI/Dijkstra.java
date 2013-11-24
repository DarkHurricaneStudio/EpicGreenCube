package AI;

import game.Updater;

import java.util.ArrayList;

public class Dijkstra {
	
	private static Node node;

	public static ArrayList<Node> computePath(Updater u, Node start, Node goal) {
		
		
		boolean[] openList = new boolean[u.getActualLevel().getWaypoints().size()];
		boolean[] closedList = new boolean[u.getActualLevel().getWaypoints().size()];
		ArrayList<Node> nodes = u.getActualLevel().getWaypoints();
		ArrayList<Node> path = new ArrayList<Node>();
		ArrayList<Node> inversePath = new ArrayList<Node>();
		boolean end = false;
		
		//we add the start as the first position
		path.add(0,start);
		start.setParent(null);
		closedList[start.getID()] = true;
		
		// we had all the neighbors of the start to the open list
		for (Node n:start.getNeighbors()) {
			n.setDistance(start.distanceTo(n));
			n.setParent(start);
			openList[n.getID()] = true;
		}
		// now that we have the base, we check if there is no more nodes to check or we have finally succeed to find the goal
		while (end == false) {
			
			Dijkstra.node = new Node(0,0,0);
			Dijkstra.node.setDistance(99999999);
			end = true; // we check if there is no more thing in the openList
			// we take the nearest node from the open list and had it to the close list
			for(int i = 0; i < openList.length;i++) {
				if (openList[i]) {
					end = false;
					if (nodes.get(i).getDistance() <= Dijkstra.node.getDistance())
						Dijkstra.node = nodes.get(i);
				}
			}

			// we now have the nearest node
			openList[Dijkstra.node.getID()] = false;
			closedList[Dijkstra.node.getID()] = true;
			
			
			// is it the goal ?
			if (node == goal) {
				// Yeah ! We found it !
				end = true;
				System.out.println("trouvé!");
				// we have to take all the parents until we join the start
				// TODO !
			
			} else {
				// we had all neighbors that are not in the closed list
				for (Node n:node.getNeighbors()) {
					//System.out.println(n);
					if (closedList[n.getID()] == false) {
						if (openList[n.getID()] == false || n.getDistance() >= Dijkstra.node.getDistance()+Dijkstra.node.distanceTo(n)) {
							n.setDistance(Dijkstra.node.getDistance()+Dijkstra.node.distanceTo(n));
							n.setParent(Dijkstra.node);
							openList[n.getID()] = true;
						}
					}
				}
			}
		}
		// we successfully join the goal
		// we now have to retrieve all the nodes
		while (Dijkstra.node.getParent() != start) {
			System.out.println(node);
			inversePath.add(Dijkstra.node);
			Node node2 = Dijkstra.node.getParent();
			Dijkstra.node = node2;
		}
			// we had the first
			inversePath.add(Dijkstra.node);
			Node node2 = Dijkstra.node.getParent();
			Dijkstra.node = node2;
		
		// and we inverse it
		for (int i=1; i <=inversePath.size();i++) {
			path.add(i,inversePath.get(inversePath.size()-i));
		}
		path.add(goal);
		
		return path;
	}
}
