package AlgoRehearsal3;

import java.util.PriorityQueue;

public class DijkstraBlackList {
	
	Vertex g[];
	int v_start;
	public DijkstraBlackList(Vertex g1[], int start) {
		this.g = copy(g1);
		this.v_start = start;
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(g[v_start]);
		g[v_start].distance=0;
		while(!q.isEmpty()){
			int u = q.poll().id;
			for (Edge ed : g[u].ed) {
				int v = ed.vertex;
				if(!g[v].isVisited && g[v].canVisit){
					if(g[v].distance > g[u].distance + ed.weight){
						q.remove(g[v]);
						g[v].distance = g[u].distance + ed.weight;
						g[v].parent = u;
						q.add(g[v]);
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Vertex v0 = new Vertex(0, null); 
		Vertex v1 = new Vertex(1, null); 
		Vertex v2 = new Vertex(2, null);
		Vertex v3 = new Vertex(3, null);
		Vertex v4 = new Vertex(4, null);
		Vertex v5 = new Vertex(5, null);
		v0.ed = new Edge[]{new Edge(1,7), new Edge(2,9), new Edge(5,14)};
		v1.ed = new Edge[]{new Edge(0,7), new Edge(2,10), new Edge(3,115)};
		v2.ed = new Edge[]{new Edge(0,9), new Edge(1, 10), new Edge(3,11), new Edge(5,2)};
		v3.ed = new Edge[]{new Edge(1,15), new Edge(2,11), new Edge(4, 6)};
		v4.ed = new Edge[]{new Edge(3,6), new Edge(5,9)};
		v5.ed = new Edge[]{new Edge(4,9), new Edge(2,2), new Edge(0,14)};
		Vertex[] vs = {v0,v1,v2,v3,v4,v5};
		DijkstraBlackList s2 = new DijkstraBlackList(vs, 0);
		System.out.println(s2.getPath(4));
		System.out.println(s2.getDist(4));
		int bl[] = {2};
		System.out.println(getDistBL(vs, 4, bl));
		System.out.println(getPathBL(vs,4,bl));
		
	}

	private static String getPathBL(Vertex[] v, int i, int[] bl) {
		for (int j = 0; j < bl.length; j++) {
			v[bl[j]].canVisit = false;
		}
		DijkstraBlackList d = new DijkstraBlackList(v, 0);
		for (int j = 0; j < bl.length; j++) {
			v[bl[j]].canVisit = false;
		}
		return d.getPath(i);
	}


	private double getDist(int i) {
		return g[i].distance;
	}

	private static double getDistBL(Vertex v[],int dist, int bl[]){
		for (int j = 0; j < bl.length; j++) {
			v[bl[j]].canVisit = false;
		}
		
		DijkstraBlackList d = new DijkstraBlackList(v, 0);
		for (int j = 0; j < bl.length; j++) {
			v[bl[j]].canVisit = true;
		}
		return d.getDist(dist);
	}
	
	private String getPath(int dist) {
		if(dist > g.length) return null;
		String ans = ""+dist;
		while(g[dist].parent!=-1){
			ans = g[dist].parent + "->" + ans ;
			dist = g[dist].parent;
		}
		if(dist!=v_start) return null;
		
		return ans;
	}
	
	private Vertex[] copy(Vertex[] g) {
		int n = g.length;
		Vertex[] temp = new Vertex[n];
		for (int i = 0; i < n; i++) {
			temp[i] = new Vertex(g[i]);
		}
		return temp;
	}
}
