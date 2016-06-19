package AlgoRehearsal2;

import java.util.Arrays;

public class FloydWarshall {
	/*
	 * this floyd warshall gets weight on vertex
	 */
	private final int inf = 999;
	private int weight[];
	private int fw[][];
	boolean graph[][];
	private String Path[][];
	public FloydWarshall(boolean g[][], int weight[]) {
		this.weight = weight;
		this.graph = g;
		Path = new String [g.length][g.length];
		fw = new int [g.length][g.length];
		for (int i = 0; i < Path.length; i++) {
			Arrays.fill(Path[i], "");
		}
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				this.graph[i][j] = g[i][j];
				if(g[i][j]) {
					fw[i][j] = weight[i] + weight[j];
					Path[i][j] = "->" + j;
				}
				else fw[i][j] = inf;
				
				if(i==j) fw[i][j] = 0 ;
			}
		}
		
		floydWarshall();
		fixFW();
	}
	private void fixFW() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				fw[i][j] = (fw[i][j] + weight[i] + weight[j])/2;
			}
		}
		
	}
	private void floydWarshall() {
		for (int k = 0; k < Path.length; k++) {
			for (int i = 0; i < Path.length; i++) {
				for (int j = 0; j < Path.length; j++) {
					
						if(fw[i][j]>fw[i][k]+fw[k][j]){
							fw[i][j] = fw[i][k] + fw[k][j];
							Path[i][j] = Path[i][k] + Path[k][j];
						}
					
				}
			}
		}
		
	}
	
	
	public double getPathWeight(int source, int dest) {
		return fw[source][dest];
	}

	public String getPath(int source, int dest) {
		return source + Path[source][dest];
	}

	
	public static void main(String[] args) {
		boolean t = true, f = false;
		boolean mat [][] = {{t,t,t,f},
							{t,t,f,t},
							{t,f,t,t},
							{f,t,t,t}};
		int w []= {1,2,3,4};
		FloydWarshall fw = new FloydWarshall(mat, w);
		for (int i = 0; i < w.length; i++) {
			System.out.println(Arrays.toString(fw.fw[i]));
		}
		System.out.println(fw.getPathWeight(1, 2));
		System.out.println(fw.getPath(1, 2));
	}
	
}
