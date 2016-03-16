package BottleProblem;

public class BottleProb {
	static int m,n;
	static boolean h[][];
	private static int getIndex(int i,int j){
		return (n+1)*i+j;
	}
	/*private static int getIindex(int index){
		return index/(n+1);
	}
	private static int getJindex(int index){
		return index % (n+1);
	}*/
	
	private static boolean [][] initMatrBottle(int m,int n){
		int size = (n+1)*(m+1);
		h = new boolean[size][size];
		for (int i = 0; i <= m ; i++) {
			for (int j = 0; j <= n ; j++) {
				
				int Index = getIndex(i,j);
				
				int i1 = getIndex(m, j);
				h[Index][i1] = true;
				int i2 = getIndex(0, j);
				h[Index][i2] = true;
				int i3 = getIndex(i,n);
				h[Index][i3] = true;
				int i4 = getIndex(i,0);
				h[Index][i4] = true;
				int i5 = getIndex(Math.max(0, i+j-n),Math.min(i+j, n));
				h[Index][i5] = true;
				int i6 = getIndex(Math.min(m,i+j),Math.max(0,i+j-m));
				h[Index][i6] = true;
			}
		}
		return h;
	}
	static <T> void PrintMat(boolean [][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		boolean mat [][] = initMatrBottle(2, 1);
		PrintMat(mat);
	}
}
