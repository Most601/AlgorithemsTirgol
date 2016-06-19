package AlgoRehearsal2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	
	ArrayList<Integer> g[];
	int [] color,pred,dist;
	public BFS(ArrayList<Integer> g[]) {
		this.g = g;
		bfs(0);
	}
	
	
	private void init() {
		int n = g.length;
		color = new int[n];
		pred = new int[n];
		dist = new int[n];
		Arrays.fill(pred, -1);
		Arrays.fill(dist, -1);
		
	}


	private void bfs(int source) {
		int n = g.length;
		init();
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(n);
		q.add(source);
		dist[source] = 0;
		color[source] = 1;
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : g[u]) {
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
	
	public void printMats(){
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
		System.out.println(b.getPath(2,6));
	}


	private String getPath(int from, int to) {
		int n = g.length;
		if(from >= n || to >= n || from < 0 || to < 0) return "";
		String ans = "";
		bfs(from);
		while(to!=from){
			ans = "->"+to+ans;
			to = pred[to];
		}
		ans = from + ans;
		return ans;
		
	}
}
