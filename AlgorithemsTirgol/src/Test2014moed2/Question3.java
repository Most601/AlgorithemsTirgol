package Test2014moed2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Question3 {

	public static boolean isTree(ArrayList<Integer>[] graph){
		
		if(!isDirected(graph)) return false;
		if(!isConnected(graph)) return false;
		return true;
	}

	private static boolean isConnected(ArrayList<Integer>[] graph) {
		int color[] = new int[graph.length];
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(graph.length);
		q.add(0);
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : graph[u]) {
				if(color[v] == 1) return false; //there is cycle
				if(color[v] == 0){
					color[v] = 1;
					q.add(v);
				}
			}
			color[u] = 2;
		}
		for (int i = 0; i < color.length; i++) {
			if(color[i] == 0) return false;
		}
		return true;
	}

	private static boolean isDirected(ArrayList<Integer>[] g) {
		for (int i = 0; i < g.length; i++) {
			for (Integer neighbor : g[i]) {
				if(!g[neighbor].contains(i))return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> g [] = initGraph();
		System.out.println((isTree(g)));
	}

	public static ArrayList<Integer>[] initGraph(){
		int n = 3; // make n = 4 to make graph unConnected
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i=0; i<n; i++){
			graph [i] = new ArrayList<Integer>(n);
		}
		graph[0].add(1);
		graph[1].add(0); ///remove this to make graph Directed
		graph[1].add(2);
		graph[2].add(1);
	//	graph[2].add(0); // add this to have a cycle in graph
		return graph;
	}
}
