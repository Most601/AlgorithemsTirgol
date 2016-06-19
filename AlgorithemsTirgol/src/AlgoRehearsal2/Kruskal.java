package AlgoRehearsal2;

import java.util.Arrays;

public class Kruskal {

	Edge g[];
	Edge tree[];
	DisjointSets group;
	int numOfVertices;
	int sum;
	
	public Kruskal(Edge ed[]) {
		g = ed;
		numOfVertices();
		Arrays.sort(g);
		tree = new Edge[numOfVertices-1];
		group = new DisjointSets(numOfVertices);
		
		for (int i = 0; i < numOfVertices; i++) {
			group.makeGroup(i);
		}
		int i = 0,k=0;
		while(i<g.length && k < numOfVertices-1){
			if(group.union(ed[i].v1, ed[i].v2))
			{
				tree[k++] = g[i];
				sum+=g[i].weight;
			}
			i++;
		}

	}
	private void numOfVertices() {
		numOfVertices=0;
		for (int i = 0; i < g.length; i++) {
			if(g[i].v1>numOfVertices) numOfVertices = g[i].v1;
			if(g[i].v2>numOfVertices) numOfVertices = g[i].v2;
		}
		numOfVertices++;
	}
	public Edge[] getTree() {
		return tree;
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
	}
	private int getCost() {
		return sum;
	}
	
}
