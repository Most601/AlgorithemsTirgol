package BottleProblem;

import java.util.Arrays;

public class BottleProb {
	int m,n,size;
	int h[][];
	String paths[][];
	int inf = Integer.MAX_VALUE;
	public BottleProb(int n,int m) {
		this.m = m;
		this.n = n;
		size = (n+1)*(m+1);
		initMatrBottle();
		bestPath();
	}
	private int getIndex(int i,int j){
		return (m+1)*i+j;
	}
	
	private int [][] initMatrBottle(){
		h = new int [size][size];
		paths = new String[size][size];
		for (int i = 0; i < h.length; i++) {
			Arrays.fill(h[i],inf);
			Arrays.fill(paths[i], "");
		}
		
		for (int i = 0; i <= n ; i++) {
			for (int j = 0; j <= m ; j++) {
				setPath(i, j, 0, j);
				setPath(i, j, i, 0);
				setPath(i, j, i, m);
				setPath(i, j, n, j);
				setPath(i, j, Math.max(0, i-(m-j)),Math.min(m, i+j));
				setPath(i, j, Math.min(n,i+j),Math.max(0,j-(n-i)));	
			}
		}
		return h;
	}
	
	private void setPath(int i1,int j1,int i2,int j2) {
		int from = getIndex(i1, j1);
		int to = getIndex(i2, j2);
		if(from == to) return;
		h[from][to] = 1;
		paths[from][to] = "->" + "("+i2+","+ j2+")";
	}
	public String getPath(int i,int j){
		if(h[getIndex(0,0)][getIndex(i, j)] == inf){
			return "No Such Path!";
		}
		else
			return "(0,0)"+ paths[getIndex(0, 0)][getIndex(i, j)];
		
	}
	private void bestPath(){
		for (int k = 0; k < size ; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(h[i][k] != inf && h[k][j] != inf &&(h[i][j] > h[i][k] + h[k][j])){
						h[i][j] = h[i][k] + h[k][j];
						paths[i][j] = paths[i][k] + paths[k][j];
					}
				}
			}
		}
	}
	
	
	<T> void PrintMat(){
		for (int i = 0; i < h.length; i++) {
			for (int j = 0; j < h[0].length; j++) {
				if(h[i][j] != inf)System.out.print(h[i][j] + ", ");
				else System.out.print((char)256 + ", ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		BottleProb B = new BottleProb(7,4);
		//B.PrintMat();
		System.out.println(B.getPath(6, 4));
	}
}
