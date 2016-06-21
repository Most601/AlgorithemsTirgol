package Best;

public class bestMatrix {
	
	/*
	 * this method use whole search on matrix for bestSubMatrix
	 * Complexity: O(n^4*n^2) = O(n^6)
	 * @return the sum of sub Matrix
	 */
	public static int BestMatrixWholeSearch(int mat[][]) {
		int maxSum=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				for (int i2 = i; i2 < mat.length; i2++) {
					for (int j2 = 0; j2 < mat.length; j2++) {
						int sum = sum(mat,i,j,i2,j2);
						if(sum>maxSum) maxSum = sum;
					}
				}
			}
		}
		return maxSum;
	}

	private static int sum(int[][] mat, int i, int j, int i2, int j2) {
		int sum = 0;
		for (int r = i; r <= i2; r++) {
			for (int c = j; c <= j2; c++) {
				sum+=mat[r][c];
			}
		}
		return sum;
	}
	
	public static int BestMatrixDynamic(int mat[][]){
		int h[][] = BuildMatrixDynamic(mat);
		int sum = 0;
		int max =0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				for (int i2 = i; i2 < mat.length; i2++) {
					for (int j2 = j; j2 < mat.length; j2++) {
						sum = sumDynamic(h,i,j,i2,j2);
						if(sum>max) max = sum;
					}
				}
			}
		}
		return max;
	}
	
	private static int sumDynamic(int[][] h, int i, int j, int i2, int j2) {
		return h[i2+1][j2+1] - h[i][j2+1]- h[i2+1][j] + h[i][j];
		
	}

	public static int[][] BuildMatrixDynamic(int mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		int h [][]= new int[n+1][m+1];
		for (int i = 0; i < n; i++) { ///Init i=0 col
			h[i+1][1] = mat[i][0] + h[i][1];
		}
		for (int i = 0; i < m; i++) { ///Init i=0 row
			h[1][i+1] = mat[0][i] + h[1][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				h[i+1][j+1] = h[i][j+1] + h[i+1][j] - h[i][j] + mat[i][j];
			}
		}
		
		
		
		return h;
	}
	
	public static void main(String[] args) {
		int m[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};
		int mat2[][] = {{20,-30,5,7}
						,{-40,5,1,7}
						,{5,-20,-1,-1}};
		System.out.println(BestMatrixDynamic(mat2));
	}
}
