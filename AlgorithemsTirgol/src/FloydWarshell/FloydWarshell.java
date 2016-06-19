package FloydWarshell;

import java.util.Arrays;

public class FloydWarshell {
	public static final int inf = 9999;
	public static int[][] floydWarshall(int mat[][]){
		int len = mat.length;
		int ans[][] = new int[len][len];
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(mat[i][j] != 0)ans[i][j] = mat[i][j];
				else ans[i][j] = inf;
			}
		}
		
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if(ans[i][j]>ans[i][k]+ans[k][j] )
						if(ans[i][k]!=0 && ans[k][j]!=0)
						ans[i][j] = ans[i][k]+ans[k][j];
				}
			}
		}
		
		for (int i = 0; i < ans.length; i++) ans[i][i] = 0;
		return ans;
	}
	public static void printMat(int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	public static void main(String[] args) {
		int mat[][] = {	{0,0,3,0},
						{2,0,0,0},
						{0,7,0,1},
						{6,0,0,0}
					  };
		int fw[][]=floydWarshall(mat);
		printMat(fw);
	}
}
