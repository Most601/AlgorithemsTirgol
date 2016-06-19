package AlgoRehearsal;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {

	public static final int inf = 999;

	private static int[][] floydWarshall(int[][] mat) {

		int len = mat.length;
		int ans[][] = new int[len][len];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				if(mat[i][j]!=0) ans[i][j] = mat[i][j];
				else ans[i][j] = inf;
			}
		}

		for (int k = 0; k <len; k++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if(ans[i][k]!=0 && ans[k][j]!= 0)
						if(ans[i][j] > ans[i][k] + ans[k][j]){
							ans [i][j] = ans[i][k] + ans[k][j];
						}
				}
			}
		}
		for (int i = 0; i < ans.length; i++) ans[i][i] = 0;

		return ans;
	}

	/*
	 * creates only unDirectedGraph
	 */
	public static ArrayList<Integer>[] createGraph (int mat[][]){
		@SuppressWarnings("unchecked")
		ArrayList<Integer> tree[] = new ArrayList[mat.length];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(i!=j){
					if(mat[i][j]!=mat[j][i]) return null;
					if(mat[i][j]!=0)tree[i].add(j);
				}
			}
		}
		return tree;
	}

	public static void main(String[] args) {
		int mat[][] = {	{0,2,3,6},
						{2,0,7,0},
						{3,7,0,1},
						{6,0,1,0}
		};
		int fw[][]=floydWarshall(mat);
		printMat(fw);
		ArrayList<Integer> t[] = createGraph(mat);
		printList(t);
	}




	private static void printList(ArrayList<Integer>[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
		System.out.println();

	}

	private static void printMat(int[][] fw) {
		for (int i = 0; i < fw.length; i++) {
			System.out.println(Arrays.toString(fw[i]));
		}
		System.out.println();

	}
}

