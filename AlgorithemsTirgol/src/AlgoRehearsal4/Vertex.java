package AlgoRehearsal4;

public class Vertex implements Comparable<Vertex>{
	int id,parent;
	double distance;
	boolean isVisited;
	Edge [] ed;
	
	public Vertex(int id, Edge [] ed) {
		this.id = id;
		this.ed = ed;
		isVisited = false;
		distance = Double.POSITIVE_INFINITY;
		parent = -1;
	}
	public Vertex(Vertex v) {
		this.id = v.id;
		this.isVisited = v.isVisited;
		this.distance = v.distance;
		this.parent = v.parent;
		ed = new Edge[v.ed.length];
		for (int i = 0; i < ed.length; i++) {
			ed[i] = new Edge(v.ed[i].vetrex, v.ed[i].weight);
		}
	}
	
	public int compareTo(Vertex o) {
		return ((Double)this.distance).compareTo(o.distance);
	}
}
