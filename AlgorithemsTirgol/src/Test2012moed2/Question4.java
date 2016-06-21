package Test2012moed2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Question4 {

	Edge tree[],graph[];
	DisjointSets set;
	int numOfVertecis;
	int parent[],weight[];
	int sumTree;
	public Question4(Edge ed[]) {
		this.graph = ed;
		Arrays.sort(graph);
		numOfVertecis();
		tree = new Edge[numOfVertecis-1];
		sumTree = 0;
		set = new DisjointSets(numOfVertecis);
		for (int i = 0; i < numOfVertecis; i++) {
			set.makeSet(i);
		}
		makeMST();
	}

	private void makeMST(){
		int i = 0 , k = 0;
		while(i<graph.length && k < numOfVertecis-1){
			if(set.union(graph[i].v1, graph[i].v2)){
				tree[k++] = graph[i];
				sumTree+= graph[i].weight;
			}
			i++;
		}
	}
	
	private void numOfVertecis() {
		numOfVertecis=0;
		for (int i = 0; i < graph.length; i++) {
			if(graph[i].v1 > numOfVertecis) numOfVertecis = graph[i].v1;
			if(graph[i].v2 > numOfVertecis) numOfVertecis = graph[i].v2;
		}
		numOfVertecis++;
		
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
		Question4 k = new Question4(edges);
		Edge ans[] = k.tree;
		System.out.println(Arrays.toString(ans));
		System.out.println(k.sumTree);
	}
}

