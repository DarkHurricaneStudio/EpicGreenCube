package game;

import java.util.ArrayList;

public class Node {

	private double x;
	private double y;
	private int id;
	private ArrayList<Node>neighbours;

	public Node(int id, double x, double y) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.neighbours = new ArrayList<Node>();
	}
	
	public void addNeighbour(Node n) {
		this.neighbours.add(n);
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
}
