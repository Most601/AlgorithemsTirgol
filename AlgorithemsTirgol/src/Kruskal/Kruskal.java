package Kruskal;

import java.util.Arrays;

public class Kruskal {

	int VerticesSet [];
	Edge [] Tree;
	int numOfEdges,numOfVertices;
	private int minCost;
	
	public Kruskal(Edge[] edges) {
		numOfVertices(edges);
		numOfEdges = edges.length;
		Tree = new Edge[numOfVertices-1];
		VerticesSet = new int[numOfVertices];
		minCost = 0;
		MST(edges);
	}
	
	private void numOfVertices(Edge[] edges2) {
		numOfVertices=0;
		for (Edge edge : edges2) {
			if(edge.v > numOfVertices) numOfVertices = edge.v;
			if(edge.u > numOfVertices) numOfVertices = edge.u;
		}
		numOfVertices++;
	}

	public Edge [] MST(Edge edges[]) {
		
		for (int i = 0; i < numOfVertices; i++) {
			VerticesSet[i] = i;
		}
		Arrays.sort(edges);
		int k = 0, i=0;
		while(k<numOfVertices && i<numOfEdges){
			Edge e = edges[i];
			if(VerticesSet[e.u]!=VerticesSet[e.v]){
				Tree[k++] = e;
				minCost += e.weight;
				union(e.u,e.v);
			}
			i++;
		}
		return Tree;
	}
	public int getCost(){
		return minCost;
	}
	private void union(int u, int v) {
		for (int i = 0; i < numOfVertices; i++) {
			if(VerticesSet[i] == VerticesSet[u]) {
				VerticesSet[i] = VerticesSet[v];
				if(i!=u)System.out.println(u +"->"+i);
			}
		}
	}

	public static void main(String[] args) {
		Edge e1 = new Edge(0, 1, 19);
		Edge e2 = new Edge(0, 2, 6);
		Edge e3 = new Edge(0, 6, 25);
		Edge e4 = new Edge(1, 4, 9);
		Edge e5 = new Edge(2, 5, 17);
		Edge e6 = new Edge(2, 6, 11);
		Edge e7 = new Edge(3, 4, 14);
		Edge e8 = new Edge(3, 6, 2);
		Edge e9 = new Edge(3, 7, 21);
		Edge e10 = new Edge(5, 6, 8);
		Edge edges [] = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10};
		Kruskal k = new Kruskal(edges);
		Edge ans[] = k.getTree();
		System.out.println(Arrays.toString(ans));
		System.out.println(k.getCost());
		System.out.println(k.numOfVertices);
		System.out.println(k.numOfEdges);
	}

	private Edge[] getTree() {
		return Tree;
	}
}
