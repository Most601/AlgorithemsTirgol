package GraphProbs;

import java.util.Arrays;

public class GraphProbs {

	public static int numOfEdges(int mat[][]){
		int count=0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = i+1; j < mat.length; j++) {
				if(mat[i][j] == 1) count++; ///check if there is edge between two
			}
		}
		return count;
	}
	public static boolean isDirectedGraph(int mat[][]){

		for (int i = 0; i < mat.length; i++) {
			for (int j = i+1; j < mat.length; j++) {
				if(mat[i][j] != mat[j][i]) return true;
			}
		}	
		return false;
	}

	public static boolean isTiableGraph(int mat[][]) {
		System.out.println("Before Connections:");
		printMat(mat);
		System.out.println("After Connections:");
		int ans[][] = ConnectPossibleVertex(mat);
		printMat(ans);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				if(ans[i][j]==0) return false;
			}
		}
		return true;
	}
	public static int[][] ConnectPossibleVertex(int m[][]){
		int dim = m.length;
		int mat[][] = new int[dim][dim];
		for (int k=0; k<dim; k++) {
			for (int i=0; i<dim; i++) {
				for (int j=0; j<dim; j++) {
					if ((m[i][k]!=0) && (m[k][j] !=0) && (m[i][j]>m[i][k]+m[k][j])) {
						mat[i][j] = m[i][k]+ m[k][j];
					}
				}
			}
		}
		return mat;
	}
	public static void printMat(int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
		public static void main(String[] args) {
			/*
			 * this mat describes mat of neighbors
			 * of n=1,m=2
			 * BottleProb
			 */
			int mat[][] = { {0,1,0,0,1,0},
					{1,0,1,0,0,1},
					{1,1,0,1,1,0},
					{0,1,1,0,1,1},
					{1,0,0,1,0,1},
					{0,1,0,0,1,0}
			};
			System.out.println(numOfEdges(mat));
			System.out.println(isDirectedGraph(mat));
			System.out.println(isTiableGraph(mat));
			/*boolean mat2[][] = { {false,true,false,false,true,false},
					{true,false,true,false,false,true},
					{true,true,false,true,true,false},
					{false,true,true,false,true,true},
					{true,false,false,true,false,true},
					{false,true,false,false,true,false}
			};*/
			
		}
	}
