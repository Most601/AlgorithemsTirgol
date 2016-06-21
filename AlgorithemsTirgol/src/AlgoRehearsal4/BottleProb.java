package AlgoRehearsal4;

import java.util.Arrays;

/*
 * O(n*m)^3
 */
public class BottleProb {
	int n,m,size;
	int mat[][];
	String paths[][];
	private int inf = Integer.MAX_VALUE;
	public BottleProb(int n, int m) {
		this.n = n;
		this.m = m;
		size = (n+1)*(m+1);
		mat = new int[size][size];
		paths = new String[size][size];
		init();
		initFW();
	}
	
	
	private void initFW() {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(mat[i][k]!=inf && mat[k][j]!=inf && mat[i][j] > mat[i][k]+mat[k][j])
					{
						mat[i][j] = mat[i][k] + mat[k][j];
						paths[i][j] = paths[i][k] + paths[k][j];
					}
				}
			}
		}
		
	}


	private void init() {
		
		for (int i = 0; i < size; i++) {
			Arrays.fill(paths[i], "");
			Arrays.fill(mat[i], inf );
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				setPath(i,j,i,m);
				setPath(i,j,0,j);
				setPath(i,j,n,j);
				setPath(i,j,i,0);
				
				setPath(i,j,Math.max(0,i+j-m ),Math.min(i+j, m));
				setPath(i,j,Math.min(i+j, n),Math.max(i+j-n,0 ));
			}
		}
		
	}


	private void setPath(int i1, int j1, int i2, int j2) {
		int from = getIndex(i1, j1);
		int to = getIndex(i2, j2);
		if(from==to) return;
		mat[from][to] = 1;
		paths[from][to] = "->("+i2+","+j2+")";
		
	}


	public int getIndex(int i, int j){
		return (m+1)*i+j;
	}
	private String getPath(int i, int j) {
		if(mat[getIndex(0, 0)][getIndex(i, j)]== inf) return null;
		return "(0,0)"+ paths[getIndex(0, 0)][getIndex(i, j)];
	}
	
	public static void main(String[] args) {
		BottleProb b = new BottleProb(1, 2);
		System.out.println(b.getPath(1,2));
	}


	
}
