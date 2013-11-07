package AI;

public class DijNode extends Node {
	
	private double distance;
	private DijNode parent;
	
	public DijNode(int id, double x, double y) {
		super(id, x, y);
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void setParent(DijNode parent) {
		this.parent = parent;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public DijNode getParent() {
		return this.parent;
	}

}
