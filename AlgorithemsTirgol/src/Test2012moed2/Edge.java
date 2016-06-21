package Test2012moed2;

public class Edge implements Comparable<Edge>{
	int v1,v2,weight;
	boolean isVisited;
	public Edge(int v1,int v2,int weight) {
		isVisited=false;
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.weight > o.weight) return 1;
		if(this.weight < o.weight) return -1;
		return 0;
	}
	public String toString(){
		return ""+this.weight;
	}
}
