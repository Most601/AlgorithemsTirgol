package Kruskal;

import java.util.Arrays;

public class KruskalDisjoint {
	private Edge [] graph,Tree;
	private DisjointSets set;
	private int numOfVert;
	private int sumTree=0;
	public KruskalDisjoint(Edge [] ed){
		numOfVertices(ed);
		graph = copy(ed);
		Arrays.sort(graph);
		set = new DisjointSets(numOfVert);
		Tree = new Edge[numOfVert-1];
		for (int i = 0; i < numOfVert; i++) {
			set.makeSet(i);
		}
		makeMST();
	}
	private Edge[] copy(Edge[] ed) {
		Edge[] temp = new Edge [ed.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new Edge(ed[i].v, ed[i].u, ed[i].weight);
		}
		return temp;
	}
	private void makeMST() {
		int i =0,k=0;
		while(i<graph.length && k < numOfVert-1){
			if(set.union(graph[i].u, graph[i].v)){
				Tree[k++] = graph[i];
				sumTree+=graph[i].weight;
			}
			i++;
		}
		
	}
	private void numOfVertices(Edge[] ed) {
		numOfVert = 0;
		for (Edge edge : ed) {
			if(edge.u > numOfVert) numOfVert = edge.u;
			if(edge.v > numOfVert) numOfVert = edge.v;
		}
		numOfVert++;
	}
	private Edge[] getTree() {
		return Tree;
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
		KruskalDisjoint k = new KruskalDisjoint(edges);
		Edge ans[] = k.getTree();
		System.out.println(Arrays.toString(ans));
		System.out.println(k.sumTree);
	}
}
