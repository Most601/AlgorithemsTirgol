package BottleProblem;

import java.util.Arrays;

public class BottProb26_05 {
	int sizeMat;
	int mat[][];
	int n,m;
	String Paths[][];
	int inf = Integer.MAX_VALUE;

	public BottProb26_05(int n, int m) {
		this.n = n;
		this.m = m;
		sizeMat = (n+1)*(m+1);
		mat = new int[sizeMat][sizeMat];
		Paths = new String[sizeMat][sizeMat];
		initMat();
		bestPath();
	}
	/*
	 * function that gets the values of each bottle and
	 * the maximum bottle size and returns the index 
	 * in row or col in the matrix
	 * @param i Value of first bottle
	 * @param j Value of second bottle
	 * @param n the size of the Matrix
	 * @return the position in the matrix that fit the values
	 * of the two bottles
	 */
	public int getIndex(int i,int j){
		return (m+1)*i +j;
	}

	/*
	 * 
	 */

	public void initMat(){
		for (int i = 0; i < Paths.length; i++) {
			Arrays.fill(Paths[i], "");
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				setPath(i, j, 0, j);
				setPath(i, j, i, 0);
				setPath(i, j, n, j);
				setPath(i, j, i, m);
				setPath(i, j, Math.max(0, i-(m-j)),Math.min(m, i+j));
				setPath(i, j, Math.min(n, i+j),Math.max(0, j-(n-i)) );
			}
		}

	}

	void setPath(int i1,int j1, int i2, int j2){
		int from = getIndex(i1, j1);
		int to = getIndex(i2, j2);
		if (from == to) return;
		mat[from][to] = 1;
		Paths[from][to] = "->" +"("+ i2 + "," + j2+")";
	}

	void bestPath(){
		for (int k = 0; k < sizeMat; k++) /// k present the number of neighbors
		{
			for (int i = 0; i < sizeMat; i++) {
				for (int j = 0; j < sizeMat ; j++) {
					if(mat[i][k] != inf && mat[k][j] != inf &&(mat[i][j] > mat[i][k] + mat[k][j]))
					{
						mat[i][j] = mat[i][k] + mat[k][j];
						Paths[i][j] =  Paths[i][k] + Paths[k][j];
					}

				}
			}
		}
	}
	String getPath(int i, int j){
		if (mat[getIndex(0, 0)][getIndex(i, j)] == inf){
			return "There's no such path!";
		}
		return "(0,0)"+ Paths[getIndex(0, 0)][getIndex(i, j)] ;
	}
	void printMat (){

		System.out.println("=======Bottle Matrix========");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j] != inf)System.out.print(mat[i][j] + "-"); 
				else System.out.print("INF" + "-");
			}
			System.out.println();
		}
		System.out.println("============================");


	}
	public static void main(String[] args) {
		BottProb26_05 b = new BottProb26_05(2,1);
		b.printMat();
		System.out.println(b.getPath(2,1));

	}


}
