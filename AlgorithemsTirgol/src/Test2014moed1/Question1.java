package Test2014moed1;

import java.util.Arrays;

public class Question1 {
	
	static final double inf = Double.MAX_VALUE;
	public static double[][] distances(boolean[][]graph,double[]weightVertex){
		int n = graph.length;
		int m = graph[0].length;
		double ans[][] = new double [n][m] ;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m ; j++) {
				if(graph[i][j])ans[i][j] = weightVertex[i] + weightVertex[j];
				else ans[i][j] = inf; 
			}
		}
		for (int i = 0; i < ans.length; i++) {
			ans[i][i] =0;
		}
		for (int k = 0; k < ans.length; k++) {
			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < ans.length; j++) {
					if(ans[i][k]!=inf && ans[k][j]!=inf &&
							ans[i][j]>ans[i][k]+ans[k][j]){
						ans[i][j] = ans[i][k]+ans[k][j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ans[i][j]!=inf) ans[i][j] = (
						ans[i][j] + weightVertex[i]+weightVertex[j])/2;
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		boolean t = true, f = false;
		boolean mat [][] = {{t,t,t,f},
				{t,t,f,t},
				{t,f,t,t},
				{f,t,t,t}};
		double w []= {1,2,3,4};
		double dist[][] = distances(mat, w);
		for (int i = 0; i < dist.length; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
	}
}
