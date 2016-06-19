package AlgoRehearsal2;

public class Edge implements Comparable<Edge>{
	int v1,v2,weight;
	public Edge(int v1,int v2,int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge e) {
		if(this.weight > e.weight) return 1;
		if(this.weight < e.weight) return -1;
		return 0;
	}
	public String toString() {
		return String.valueOf(weight);
	}
}
