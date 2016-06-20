package AlgoRehearsal3;

import java.util.PriorityQueue;


public class Dijkstra {
	Vertex[] graph;
	int start;
	public Dijkstra(Vertex[] ve, int start) {
		this.start = start;
		graph = ve;
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		graph[start].distance = 0;
		q.add(graph[start]);
		while(!q.isEmpty()){
			int u = q.poll().id;
			graph[u].isVisited = true;
			for (Edge ed : graph[u].ed) {
				int v = ed.vertex;
				if(!graph[v].isVisited){
					if(graph[v].distance > graph[u].distance + ed.weight){
						q.remove(graph[v]);
						graph[v].distance = graph[u].distance + ed.weight;
						graph[v].parent = u;
						q.add(graph[v]);
					}
				}
			}
		}
	}
	
	public String getPath(int source){
		if(source> graph.length) return null;
		String ans = ""+source;
		
		while(graph[source].parent!=-1)
		{
			ans = graph[source].parent +"->"+ ans;
			source = graph[source].parent;
		}
		if(source != start) return null;
		
		return ans;
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
		Dijkstra s2 = new Dijkstra(vs, 0);
		System.out.println(s2.getPath(4));
		System.out.println(s2.getDist(4));
	}

	private double getDist(int i) {
		return graph[i].distance;
	}
}
