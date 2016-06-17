package Kruskal;

public class Edge implements Comparable<Edge>{
	int v,u,weight;
	public Edge(int v,int u,int weight) {
		this.v = v;
		this.u = u;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge e) {
		if(this.weight > e.weight) return 1;
		if(this.weight < e.weight) return -1;
		return 0;
	}
	@Override
	public String toString() {
		return String.valueOf(weight);
	}
}
