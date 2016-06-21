package AlgoRehearsal4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * O(|V|+|E|)
 */
public class BiPartite {
	int [] color,partition;
	ArrayList<Integer> g[];
	boolean isBiPartite;
	int numOfBi;
	public BiPartite(ArrayList<Integer> g[]) {
		this.g = g;
		int n = g.length;
		numOfBi=2;
		isBiPartite=BFSBi(0);
	}
	
	private boolean BFSBi(int source) {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		q.add(source);
		init();
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : g[u]) {
				if(partition[u]==partition[v] && color[v]!=0) return false;
				else if(partition[v] == 1 && color[v] == 0){
					partition[v] = 3 - partition[u];
					color[v] = 1;
					q.add(v);
				}
				
			}
			color[u] = 2;
		}
		return true;
	}
	private int numBFSBi(int source) {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		init();
		q.add(source);
		partition[source] = 1;
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : g[u]) {
				if(partition[u]==partition[v] && color[v]!= 0) {
					numOfBi++;
				}
				else if(partition[v] == 1 && color[v] == 0){
					partition[v] = (numOfBi+1) - partition[u];
					color[v] = 1;
					q.add(v);
				}
				
			}
			color[u] = 2;
		}
		return numOfBi;
	}

	private void init() {
		color = new int[g.length];
		partition = new int[g.length];
		Arrays.fill(partition, 1);
		Arrays.fill(color, 0);
		
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
	//	g[4].add(6);
		g[5].add(4);
		g[5].add(6);
		g[5].add(7);
	//	g[6].add(4);
		g[6].add(5);
		g[6].add(7);
		g[7].add(5);
		g[7].add(6);
		
		BiPartite b = new BiPartite(g);
		System.out.println(b.isBiPartite());
		System.out.println(b.numBFSBi(0));
		
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
		
		BiPartite b2 = new BiPartite(g2);
		System.out.println(b2.isBiPartite());
		System.out.println(b2.numBFSBi(0));
		
		ArrayList<Integer> g3[] = new ArrayList[4];
		for (int i = 0; i < g3.length; i++) {
			g3[i] = new ArrayList<>();
		}
		g3[0].add(1);
		g3[0].add(3);
		
		g3[1].add(0);
		g3[1].add(2);
		//g[1].add(3);

		g3[2].add(1);
		g3[2].add(3);
		
		g3[3].add(0);
		//g[3].add(1);
		g3[3].add(2);
		BiPartite b3 = new BiPartite(g3);
		System.out.println(b3.isBiPartite());
		System.out.println(b3.numBFSBi(0));
	}

	private boolean isBiPartite() {
		return isBiPartite;
	}
}
