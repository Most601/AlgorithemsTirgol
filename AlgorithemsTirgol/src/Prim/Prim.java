package Prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

	private Edge [] tree;
	private ArrayList<Node> graph[];
	private int[] parent,color,weight;
	private static final int inf = Integer.MAX_VALUE;
	public Prim(ArrayList<Node> g[]) {
		graph = g;
		int n = graph.length;
		tree = new Edge[n-1]; //creating MST
		int numEdges = 0;
		Arrays.fill(weight, inf);
		Arrays.fill(parent, -1);
		findMST(0);
		makeMST();
	}

	private void makeMST() {
		int size = 0;
		for (int i = 0; i < graph.length; i++) {
			if(parent[i]!=-1){
				tree[size++] = new Edge(i,parent[i], weight[i]);
			}
		}
		
	}
	
	private Edge[] getTree(){
		return tree;
	}
	
	private void findMST(int source) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(source,0));
		color[source] = 1;
		weight[source] = 0;
		while(!q.isEmpty()){
			Node u = q.poll();
			for (Node n : graph[u.id]) {
				if(color[n.id] == 0 ){
					color[n.id] = 1;
					parent[n.id] = u.id;
					weight[n.id] = u.weight;
					q.add(new Node(u.id,u.weight));
				}
				else if(color[n.id] == 1){
					if(weight[n.id]>u.weight){
						parent[n.id] = u.id;
						weight[n.id] = u.weight;
					}
				}
			}
			color[u.id] = 2;
		}
	}

	public static void main(String[] args) {
		
	}
}
