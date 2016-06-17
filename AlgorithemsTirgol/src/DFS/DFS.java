package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import BFS.BFS;

public class DFS {
	
	int color[];
	int pred[];
	int dist[];
	
	public DFS(ArrayList<Integer> g[]) {
		DFS(g,0);
	}
	
	
	private void DFS(ArrayList<Integer>[] g, int source) {
		int size = g.length;
		init(size);
		Stack<Integer> s = new Stack<>();
		s.push(source);
		dist[source] = 0;
		while(!s.isEmpty()){
			int u = s.pop();
			for (Integer v : g[u]) {
				if(color[v] == 0){
					color[v] = 1;
					pred[v] = u;
					dist[v] = dist[u]+1;
					s.push(v);
				}
			}
			color[u] = 2;
		}
	}


	private void init(int size) {
		color = new int[size];
		pred = new int[size];
		dist = new int[size];
		Arrays.fill(pred, -1);
		Arrays.fill(dist, -1);
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
		DFS b = new DFS(g);
		b.printMats();
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
