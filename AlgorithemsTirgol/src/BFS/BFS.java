package BFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class BFS {
	
	ArrayList<Integer> tree[];
	int color[];
	int pred[];
	int dist[];
	
	public BFS(ArrayList<Integer> g[]) {
		this.tree = g;
		color = new int[g.length];
		pred = new int[g.length];
		dist = new int[g.length];
		Arrays.fill(dist, -1);
		Arrays.fill(pred,-1);
		BFS(0);
	}
	
	private void BFS(int source) {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(tree.length);
		q.add(source);
		color[source] = 1;
		dist[source] = 0;
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : tree[u]) {
				if(color[v] == 0){
					color[v] = 1;
					pred[v] = u;
					dist[v] = dist[u]+1;
					q.add(v);
				}
			}
			color[u] = 2;
		}
		
	}
	
	public String getPath(int from,int to){
		
		String path="";
		while(from!=to){
			path =  "->" +to+path;
			to = pred[to];
		}
		path = from+path;
		return path;
	}
	public int numOfEdges(){
		return tree.length;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(5);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[5].add(1);
		g[5].add(6);
		g[6].add(5);
		BFS b = new BFS(g);
		b.printMats();
		System.out.println(b.getPath(0, 5));
	}

	private void printMats() {
		System.out.println("====Color====");
		System.out.println(Arrays.toString(color));
		System.out.println("=============");
		System.out.println("====Pred=====");
		System.out.println(Arrays.toString(pred));
		System.out.println("=============");
		System.out.println("====Dist=====");
		System.out.println(Arrays.toString(dist));
		System.out.println("=============");
	}
}
