package AlgoRehearsal3;

public class Vertex implements Comparable<Vertex>{
	int parent,id;
	double distance;
	Edge ed[];
	boolean isVisited,canVisit;
	public Vertex(int id,Edge ed[]) {
		this.id = id;
		this.ed = ed;
		this.isVisited = false;
		this.canVisit = true;
		distance = Double.POSITIVE_INFINITY;
		parent = -1;
	}
	public Vertex(Vertex v){
		this.id = v.id;
		this.distance = v.distance;
		this.parent = v.parent;
		this.canVisit = v.canVisit;
		this.isVisited = v.isVisited;
		this.ed = new Edge[v.ed.length];
		for (int i = 0; i < ed.length; i++) {
			ed[i] = new Edge(v.ed[i].vertex, v.ed[i].weight);
		}
	}
	
	
	@Override
	public int compareTo(Vertex o) {
		return ((Double)this.distance).compareTo(o.distance);
	}
	
}
