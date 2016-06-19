package AlgoRehearsal2;

import java.util.Arrays;

public class BottleProb {
	
	String Path[][];
	int mat[][];
	int size,n,m;
	private static final int inf = Integer.MAX_VALUE;
	/*
	 * assuming n>m
	 */
	public BottleProb(int n, int m) {
		size = (n+1)*(m+1);
		this.n = n;
		this.m = m;
		initMat();
		bestPath();
	}
	
	
	private void bestPath() {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(mat[i][k]!= inf && mat[k][j] != inf && (mat[i][j]>mat[i][k]+mat[k][j])){
						mat[i][j] = mat[i][k]+mat[k][j];
						Path[i][j] = Path[i][k]+Path[k][j];
					}
				}
			}
		}
		
	}

	private String getPath(int i,int j){
		if(Path[i][j]!=null){
			return "(0,0)"+Path[i][j];
		}
		return null;
	}
	
	public String getPath2(int x, int y) {
		if(mat[getIndex(0,0)][getIndex(x,y)] == inf) {
			return "no path!";
		}
		return "(0,0)" + Path[getIndex(0,0)][getIndex(x,y)];
	}
	
	private void initMat() {
		mat = new int [size][size];
		Path = new String[size][size];
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], inf);
			Arrays.fill(Path[i], "");
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m ; j++) {
				setPath(i,j,0,j);
				setPath(i,j,i,0);
				setPath(i,j,n,j);
				setPath(i,j,i,m);
				setPath(i,j,Math.max(0, i+j-m),Math.min(m, i+j));
				setPath(i,j,Math.min(n, i+j),Math.max(0, i+j-n));
			}
		}
		
	}
	
	private void setPath(int i1, int j1, int i2, int j2) {
		int from = getIndex(i1, j1);
		int to = getIndex(i2, j2);
		if(from == to) return;
		mat[from][to] = 1;
		Path[from][to] = "->"+"(" + i2+","+j2+")";
		
	}


	private int getIndex(int i,int j){
		return (m+1)*i+j;
	}
	
	public static void main(String[] args) {
		BottleProb b = new BottleProb(7,4);
		System.out.println(b.getPath(0, 2));
		System.out.println(b.getPath2(0, 2));
	}
}
