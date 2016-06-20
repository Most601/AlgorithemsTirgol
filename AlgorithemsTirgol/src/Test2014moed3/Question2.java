package Test2014moed3;

public class Question2 {
	
	
	public static int maxSum(int[][] mat){
		int help[][] = buildHelpMatrix(mat);
		int max = 0;
		for (int i1 = 0; i1 < mat.length; i1++) {
			for (int j1 = 0; j1 < mat[0].length; j1++) {
				for (int i2 = 0; i2 < mat.length; i2++) {
					for (int j2 = 0; j2 < mat[0].length; j2++) {
						int sum = help[i2+1][j2+1] - help[i2+1][j1] - help[i1][j2+1] +help[i1][j1];
						if(sum>max) max = sum;
					}
				}
			}
		}
		return max;
	}
	private static int[][] buildHelpMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int h[][] = new int[n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			h[i+1][0] = h[i][0] + mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			h[0][i+1] = h[0][i] + mat[0][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m ; j++) {
				h[i+1][j+1] = mat[i][j] + h[i+1][j]+ h[i][j+1] - h[i][j];
			}
		}
		
		return h;
	}
	public static void main(String[] args) {
		int mat [][] = { {1,3,6},{-3,4,5},{-1,1,0}};
		System.out.println(maxSum(mat));
	}
}
