package Test2012moed2;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Question4ReverseKruskal {
	
	Edge tree[];
	int numOfVertecis;
	int color[];
	public Question4ReverseKruskal(Edge ed[], int numOfEdges) {
		tree = copy(ed);
		Arrays.sort(tree);
		getNumVer();
		color = new int [numOfVertecis];
		int i = 0;
		while( i < numOfVertecis-(numOfEdges-1)){
			Edge e = tree[i];
			remove(i);
			BFS();
			if(tree[i].isVisited) i++;
			else add(e);
		}
		
	}
	
	
	
	private void add(Edge e) {
		tree[tree.length-1] = e;
		Arrays.sort(tree);
	}



	private void BFS() {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(numOfVertecis);
		Arrays.fill(color, 0);
		q.add(0);
		while(!q.isEmpty()){
			int u = q.poll();
			tree[u].isVisited = true;
			
		}
		
	}



	private void remove(int index) {
		tree[index] = null;
		for (int i = index+1; i < tree.length; i++) {
			swap(i,i+1);
		}
	}



	private void swap(int i, int j) {
		Edge e = tree[i];
		tree[i] = tree[j];
		tree[j] = e;
		
	}



	private void getNumVer() {
		numOfVertecis = 0;
		for (int i = 0; i < tree.length; i++) {
			if(tree[i].v1>numOfVertecis)numOfVertecis = tree[i].v1;
			if(tree[i].v2>numOfVertecis)numOfVertecis = tree[i].v2;
		}
		numOfVertecis++;
	}



	private Edge[] copy(Edge[] ed) {
		Edge temp [] = new Edge[ed.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new Edge(ed[i].v1, ed[i].v2, ed[i].weight);
		}
		return temp;
	}
}
