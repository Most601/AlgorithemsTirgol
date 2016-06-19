package BiPartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFSBipartite {
	
	private int color[],dist[],pred[];
	private int partition[];
	private ArrayList<Integer> tree[];
	private boolean isBiPartite;
	public BFSBipartite(ArrayList<Integer> g[]) {
		tree = g;
		isBiPartite = true;
		init();
		bfsPartite(0);
	}
	public boolean isBiPartite(){
		return isBiPartite;
	}
	private void init() {
		color = new int [tree.length];
		dist = new int[tree.length];
		pred = new int[tree.length];
		partition = new int[tree.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(pred, -1);
		Arrays.fill(partition, 1);
	}
	private void bfsPartite(int s) {
		dist[s] = 0;
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(tree.length);
		q.add(s);
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : tree[u]) {
				if(partition[v]==partition[u]){
					isBiPartite = false;
					return;
				}
				if(partition[v] == 0 && color[v] == 0){
					partition[v] = 3 - partition[u];
				}
				q.add(v);
			}
			
		}
		
		
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> g[] = new ArrayList[8];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[0].add(2);
		g[1].add(0);
		g[2].add(0);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[4].add(5);
		g[4].add(6);
		g[5].add(4);
		g[5].add(6);
		g[5].add(7);
		g[6].add(4);
		g[6].add(5);
		g[6].add(7);
		g[7].add(5);
		g[7].add(6);
		
		BFSBipartite b = new BFSBipartite(g);
		System.out.println(b.isBiPartite());
		
		
		ArrayList<Integer> g2[] = new ArrayList[4];
		for (int i = 0; i < g2.length; i++) {
			g2[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		
		BFSBipartite b2 = new BFSBipartite(g2);
		System.out.println(b2.isBiPartite());
	}
}
