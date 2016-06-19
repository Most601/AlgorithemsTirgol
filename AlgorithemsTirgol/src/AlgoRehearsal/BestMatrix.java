package AlgoRehearsal;

public class BestMatrix {
	
	public static int bestMatrix(int mat[][]){
		int h[][] = createHelpMat(mat);
		
		int max = -1;
		for (int i1 = 0; i1 < mat.length; i1++) {
			for (int j1 = 0; j1 < mat[0].length; j1++) {
				for (int i2 = 0; i2 < mat.length; i2++) {
					for (int j2 = 0; j2 < mat[0].length; j2++) {
						int sum = getSum(h, i1, j1, i2, j2);
						if(max<sum)max = sum;
					}
				}
			}
		}
		return max;
		
	}
	
	public static int getSum(int m[][], int i1,int j1,int i2, int j2){
		return m[i2+1][j2+1] - m[i1][j2+1] - m[i2+1][j1] + m[i1][j1];
	}
	
	public static int[][] createHelpMat(int mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		int h[][] = new int[n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			h[i+1][1] = mat[i][0] + h[i][1];
		}
		for (int i = 0; i < m; i++) {
			h[1][i+1] = mat[0][i] + h[1][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				h[i+1][j+1] = h[i+1][j] + h[i][j+1] - h[i][j] + mat[i][j];
			}
		}
		
		return h;
	}
	
	public static void main(String[] args) {
		int m[][] = {{1,2,3},
					{-3,4,5},
					{-1,-2,-4}};
		System.out.println(bestMatrix(m));
	}
}
