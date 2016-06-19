package AlgoRehearsal2;

import java.util.Arrays;

public class BestMatrix {
	

	private static int[] BestMatrixDynamic(int[][] m) {
		int max = 0;
		int h[][] = BuildMatrix(m);
		int f1=0,f2=0,t1=0,t2=0;
		for (int i1 = 0; i1 < m.length; i1++) {
			for (int j1 = 0; j1 < m[0].length; j1++) {
				for (int i2 = 0; i2 < m.length; i2++) {
					for (int j2 = 0; j2 < m[0].length; j2++) {
						int sum = getSum(h,i1,j1,i2,j2);
						if(sum>max) {
							max = sum;
							f1=i1;
							f2=j1;
							t1=i2;
							t2=j2;
						}
					}
				}
			}
		}
		return new int[]{max,f1,f2,t1,t2};
	}


	private static int getSum(int[][] h, int i1, int j1, int i2, int j2) {
		return h[i2+1][j2+1] - h[i1][j2+1] - h[i2+1][j1] +h[i1][j1];
	}


	private static int[][] BuildMatrix(int mat[][]) {
		int n = mat.length;
		int m = mat[0].length;
		int h[][] = new int [n+1][m+1];
		
		for (int i = 0; i < n; i++) { // init
			h[i+1][1] = mat[i][0] + h[i][1];
		}
		for (int i = 0; i < m; i++) { // init
			h[1][i+1] = mat[0][i] + h[1][i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				h[i+1][j+1] = mat[i][j] + h[i+1][j] + h[i][j+1] - h[i][j];
			}
		}
		
		
		return h;
	}

	public static void main(String[] args) {
		int m[][] = {
				{1,2,3},
				{-3,4,5},
				{-1,-2,-4}};
		System.out.println(Arrays.toString(BestMatrixDynamic(m)));
	}

}
