package Best;

public class bestMatrix {
	
	/*
	 * this method use whole search on matrix for bestSubMatrix
	 * Complexity: O(n^4*n^2) = O(n^6)
	 * @return the sum of sub Matrix
	 */
	public static int getBestMatrix(int mat[][]) {
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
	public static void main(String[] args) {
		int m[][] = {{1,2,3},{-3,4,5},{-1,-2,-4}};
		System.out.println(getBestMatrix(m));
	}
}
