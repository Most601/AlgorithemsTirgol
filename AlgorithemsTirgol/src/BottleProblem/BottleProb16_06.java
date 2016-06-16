package BottleProblem;

import java.util.Arrays;

public class BottleProb16_06 {
	
	public static int getIndex(int i, int j ,int n){
		return (n+1)*i+j;
	}
	
	/*
	 * assuming n>m
	 */
	public static int[][] initRibs(int n, int m) {
		int dim = (n+1)*(m+1);
		int mat[][] = new int[dim][dim];
		int ind1,ind2;
		
		if(n>m){
			int temp = n;
			n = m;
			m = temp;
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				ind1 = getIndex(i, j, m);
				
				mat[ind1][getIndex(i, 0, m)] = 1;
				mat[ind1][getIndex(i, m, m)] = 1;
				mat[ind1][getIndex(0, j, m)] = 1;
				mat[ind1][getIndex(n, j, m)] = 1;
				
				ind2 = getIndex(Math.min(i+j, n), i+j - Math.min(i+j, n), m);
				mat[ind1][ind2] = 1;
				ind2 = getIndex(i+j - Math.min(i+j, m), Math.min(i+j, m), m);
				mat[ind1][ind2] = 1;
			}
		}
		for (int i = 0; i < mat.length; i++)  mat[i][i] = 0;
		return mat;
		
	}
	public static boolean[][] intToBoolean(int mat[][]){
		boolean ans [][]= new boolean [mat.length][mat.length];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				if(mat[i][j] == 1) ans[i][j]=true;
			}
		}
		return ans;
	}
	public static String[][] ConnectPossibleVertex(boolean mat[][],int m) {
		String ans[][] = new String[mat.length][mat.length];
		int a1,b1,a2,b2;
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				a1 = i/(m+1);
				b1 = i%(m+1);
				a2 = j/(m+1);
				b2 = j%(m+1);
				
				if(mat[i][j]) ans[i][j] = "("+a1+","+b1+")"+"->"+"("+a2+","+b2+")";
				else ans[i][j] = new String();
			}
		}
		
		for (int k = 0; k < ans.length; k++) {
			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < ans.length; j++) {
					if(mat[i][j] == false){
						mat[i][j] = mat[i][k]&&mat[k][j];
					}
					if(mat[i][j]){
						ans[i][j] = ans[i][k] + "->"+ans[k][j];
					}
				}
			}
		}
		return ans;
	}
	private static void getPath(String[][] paths, int i, int j,int m) {
		System.out.println(paths[i][j]);
		
	}
	
	public static void main(String[] args) {
		int mat[][] = initRibs(1,2);
		printMat(mat);
		boolean mat2[][] = intToBoolean(mat);
		String Paths[][]= ConnectPossibleVertex(mat2, 2);
		printMat(mat2);
		//getPath(Paths,1,1,2);
		System.out.println(Paths[0][0]);
	}
	
	

	public static void printMat(int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	public static void printMat(boolean mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	public static void printMat(String mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
}
