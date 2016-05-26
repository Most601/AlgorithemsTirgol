package BottleProblem;

public class BottProb26_05 {

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
	public static int getIndex(int i,int j, int n){
		return (n+1)*i +j;
	}

	/*
	 * 
	 */

	public static int [][] initMat(int n,int m){
		int dim = (n+1)*(m+1); // dim of matrix, and num of V in graph
		int mat[][] = new int[dim][dim];
		int ind1,ind2;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				ind1 = getIndex(i, j, m);
				mat[ind1][getIndex(0, j, m)] = 1; //Rib 1
				mat[ind1][getIndex(i, 0, m)] = 1; //Rib 2
				mat[ind1][getIndex(i, m, m)] = 1; //Rib 3
				mat[ind1][getIndex(n, j, m)] = 1; //Rib 4

				ind2 = getIndex(Math.min(i+j, n), i+j -Math.min(i+j, n) , m);
				mat[ind1][ind2] = 1; //Rib 5

				ind2 = getIndex(i+j - Math.min(i+j, m), Math.min(i+j, m), m);
				mat[ind1][ind2] = 1; //Rib 6
			}
		}
		for (int i = 0; i < dim; i++) {
			mat[i][i] = 0;
		}

		return mat;
	}

	static String[][] getPaths (int mat[][], int n){
		String Paths[][] = new String[mat.length][mat.length];
		int a0,a1,b0,b1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				a0 = i / (n+1);
				b0 = i % (n+1);
				a1 = j / (n+1);
				b1 = j % (n+1);
				if(mat[i][j] == 1){
					Paths[i][j] = a0 +"," + b0 + "->" +a1 +","+ b1; 
				}
				else Paths[i][j] = new String();
			}
		}
		for (int k = 0; k < mat.length; k++) /// k present the number of neighbors
		{
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					if(mat[i][k] != 0 && mat[k][j] != 0)
					{
						mat[i][j] = mat[i][k] + mat[k][j];
						Paths[i][j] =  Paths[i][k] + Paths[k][j];
					}

				}
			}
		}

		return Paths;

	}


	static void printMat ( int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + "-");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int mat[][] = BottProb26_05.initMat(1, 2);
		String P [][]= getPaths(mat, 2);
	//	P.toString();
		printMat(mat);
	}


}
