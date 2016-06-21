package AlgoRehearsal4;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * O(|V|+|E|)
 */
public class DFS {
	
	int [] color,pred,first,last;
	int time;
	ArrayList<Integer>[] g;
	public DFS(ArrayList<Integer>[] g) {
		this.g = g;
		time = 0;
		int n = g.length;
		color = new int[n];
		pred = new int[n];
		first = new int [n];
		last = new int [n];
		Arrays.fill(pred, -1);
		first[0] = 0;
		
		DFS(0);
	}
	
	private void DFS(int source) {
		first[source] = ++time;
		color[source] = 1;
		for (int v : g[source]) {
			
			if(color[v] == 0){
				pred[v] = source;
				DFS(v);
			}
		}
		
		color[source] = 2;
		last[source] = ++time;
		
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
		System.out.println("====First=====");
		System.out.println(Arrays.toString(first));
		System.out.println("=============");
		System.out.println("====Last=====");
		System.out.println(Arrays.toString(last));
		System.out.println("=============");
	}
}
