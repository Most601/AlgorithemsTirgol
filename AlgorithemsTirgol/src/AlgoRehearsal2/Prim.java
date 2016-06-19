package AlgoRehearsal2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {
	
	Edge tree[];
	int [] color,parent,weight;
	private ArrayList<Node>[] graph;
	private final int inf = Integer.MAX_VALUE;
	public Prim(ArrayList<Node> g[]){
		int n = g.length;
		graph = g;
		color = new int [n];
		parent = new int[n];
		weight = new int[n];
		Arrays.fill(parent, -1);
		Arrays.fill(weight, inf);
		tree = new Edge[n-1];
		findMST(0);
		createMST();
	}
	
	private void findMST(int source) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(source, 0));
		color[source] = 1;
		weight[source] = 0;
		while(!q.isEmpty()){
			Node n = q.poll();
			for (Node v : graph[n.id]) {
				if(color[v.id]==0){
					color[v.id]=1;
					weight[v.id] = v.weight;
					parent[v.id] = n.id;
					q.add(new Node(v.id, v.weight));
				}
				else if(color[v.id]==1){
					if(weight[v.id]>weight[n.id]){
						parent[v.id] = n.id;
						weight[v.id] = weight[n.id];
					}
				}
			}
			color[n.id] = 2;
		}
		
	}

	private void createMST() {
		int k = 0;
		for (int i = 0; i < graph.length; i++) {
			if(parent[i] != -1){
				tree[k++] = new Edge(i, parent[i], weight[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		
	}
}
