package AI;

import game.Entity;

import java.util.ArrayList;

public class Node {

	private double x;
	private double y;
	private int id;
	private ArrayList<Node>neighbors;
	// used for Dijkstra algorithm :
	private double distance;
	private Node parent;

	public Node(int id, double x, double y) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.neighbors = new ArrayList<Node>();
		this.parent = null;
	}
	
	public void addNeighbor(Node n) {
		this.neighbors.add(n);
	}
	
	public double distanceTo(double nodeX, double ndoeY) {
		return Math.sqrt((this.x-nodeX)*(this.x-nodeX) + (this.x-nodeX)*(this.x-nodeX));
	}
	
	public double distanceTo(Entity e) {
		return distanceTo(e.getPosX(),e.getPosY());
	}
	
	public double distanceTo(Node n) {
		return distanceTo(n.getX(),n.getY());
	}

	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public int getID() {
		return this.id;
	}
	
	public ArrayList<Node> getNeighbors() {
		return this.neighbors;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public String toString() {
		
		String nei = "Neighbor : s";
		for(Node n:neighbors) {
			nei += n.getID() + ";";
		}
		return ("Node "+id+" | X : "+x+" | Y : "+y+" | "+nei);
	}
}
