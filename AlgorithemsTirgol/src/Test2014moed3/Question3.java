package Test2014moed3;

import java.util.ArrayList;
import java.util.Arrays;

import BFS.BFS;

public class Question3 {
	
	ArrayList<Integer> leaves;
	int deg[];
	
	public int[] graphCentersBFS(ArrayList<Integer>[] graph){
		BFS b = new BFS(graph);
		int s = 0;
		for (int i = 0; i < b.dist.length; i++) {
			if(b.dist[i]>s) s = b.dist[i];
		}
		b.BFS(s);
		
		System.out.println(Arrays.toString(b.dist));
		
		int farest = 0;
		for (int i = 0; i < b.dist.length; i++) {
			if(b.dist[i]>b.dist[farest]){
				farest = i;
			}
		}
		
		int center=-1;
		int deg[] = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			deg[i] = graph[i].size();
		}
		if(deg[farest] %2 == 0){
		for (int i = 0; i < deg.length/2; i++) {
			center = b.pred[farest];
			farest =  b.pred[farest];
		}
		
		return new int[]{center};
		}
		for (int i = 0; i < deg.length/2; i++) {
			center = b.pred[farest];
			farest =  b.pred[farest];
		}
		int center2 = b.pred[farest];
		return new int[]{center,center2};
		}
	
	

	public static int[] graphCenters(ArrayList<Integer>[] graph){
		int n = graph.length;
		int deg[] = new int[n];
		ArrayList<Integer> leaves = new ArrayList<>();
		
		for (int i = 0; i < deg.length; i++) {
			deg[i] = graph[i].size();
			if(deg[i] == 1) leaves.add(i);
		}
		
		int numOfVertices = n;
		
		while(numOfVertices>2){
			for (int i = 0; i < leaves.size(); i++) {
				int l = leaves.remove(0);
				deg[l]--;
				numOfVertices--;
				for (int j = 0; j < graph[l].size(); j++ ) {
					int ni = graph[l].get(j);
					deg[ni]--;
					if(deg[ni] == 1){
						leaves.add(ni);
					}
				}
			}
		}
		
		
		
		if(leaves.size()== 2)return new int []{leaves.get(0),leaves.get(1)};
		return new int[]{leaves.get(0)};
	}
	
	public static ArrayList<Integer>[]getGraph(){
		int n = 3;
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i=0; i<n; i++){
		graph [i] = new ArrayList<Integer>(n);
		}
		graph[0].add(1);
		graph[1].add(0); graph[1].add(2);
		graph[2].add(1);
		return graph;
		}
	public static void main(String[] args) {
		ArrayList<Integer> g[] = getGraph();
		System.out.println(Arrays.toString(graphCenters(g)));
		
		Question3 q = new Question3();
		System.out.println(Arrays.toString(q.graphCentersBFS(g)));
	}
}
