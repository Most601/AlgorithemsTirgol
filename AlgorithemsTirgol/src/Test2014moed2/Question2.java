package Test2014moed2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Question2 {

	static int n = 3;
	static int size ;
	public static int[] connectedComponents(ArrayList<Integer>[] graph){

		size = graph.length;
		int color[] = new int[size];
		
		ArrayList<Integer> numOfVer = new ArrayList<>();
		while(componentsLeft(color).length==1){
			
			int source = componentsLeft(color)[0];
			ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(size);
			q.add(source);
			int numOfVertex=1;
			while(!q.isEmpty()){
				int u = q.poll();
				for (Integer v : graph[u]) {
					if(color[v] == 0){
						q.add(v);
						color[v] = 1;
						numOfVertex++;
					}
				}
				color[u] = 2;
			}
			numOfVer.add(numOfVertex);
		}
		
		int arr[] = new int [numOfVer.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = numOfVer.get(i);
		}
		Arrays.sort(arr);
		return arr;
	}

	private static int[] componentsLeft(int color[]) {
		for (int i = 0; i < color.length; i++) {
			if(color[i] == 0) return new int[]{i};
		}
		return new int[]{};
	}



	public static void main(String[] args) {
		ArrayList<Integer> g [] = initGraph();
		System.out.println(Arrays.toString(connectedComponents(g)));
	}

	public static ArrayList<Integer>[] initGraph(){
		int n = 4;
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i=0; i<n; i++){
			graph [i] = new ArrayList<Integer>(n);
		}
		graph[0].add(1);
		graph[1].add(0);
		graph[1].add(2);
		graph[2].add(1);
		return graph;
	}
}
