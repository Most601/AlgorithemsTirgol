package AlgoRehearsal4;

import java.util.Arrays;

/*
 * Best arr : O(n)
 * Best Mat : O((n*m)^2)
 */

public class Best {

	int bestArr,iStart,iEnd,len,arr[];
	int bestMat,i1Start,i2End,j1Start,j2End,mat[][];
	
	public Best(int arr[]) {
		bestArr = Integer.MIN_VALUE;
		iStart=-1;
		iEnd=-1;
		this.arr = arr;
		bestArr();
	}
	private void bestArr() {
		bestArr = arr[0];
		int sum=bestArr;
		int tempBegin = 0;
		len = arr.length;
		for (int i = 1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				sum = 0;
				tempBegin = i+1;
			}
			else if(sum>bestArr){
				bestArr = sum;
				
					len = iEnd - iStart+1;
					iEnd = i;
					iStart = tempBegin;
			}
			if(sum == bestArr){
				if(i-tempBegin+1<len){
					len = i-tempBegin+1;
					iEnd = i;
					iStart = tempBegin;
				}
			}
		}

	}
	
	public Best(int mat[][]){
		this.mat = mat;
		bestMat=Integer.MIN_VALUE;
		i1Start=i2End=j1Start=j2End = -1;
		BestMatrix();
	}
	
	private void BestMatrix() {
		int h[][] = buildHelp();
		int n = mat.length;
		int m = mat[0].length;
		int maxSize = mat.length*mat[0].length;
		for (int i1 = 0; i1 < n ; i1++) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int i2 = i1; i2 < n; i2++) {
					for (int j2 = j1; j2 < m; j2++) {
						int currSize = (i2-i1+1)*(j2-j1+1);
						int sum = h[i2+1][j2+1] - h[i2+1][j1] - h[i1][j2+1] +h[i1][j1];
						if(sum>bestMat){
							bestMat = sum;
							maxSize = currSize;
							i1Start = i1;
							i2End = i2;
							j1Start = j1;
							j2End = j2;
							
						}
						if(sum==bestMat){
							if(currSize<maxSize)
							{maxSize = currSize;
							i1Start = i1;
							i2End = i2;
							j1Start = j1;
							j2End = j2;
							}
						}
					}
				}
			}
		}
	
	}
	private int[][] buildHelp() {
		int n = mat.length;
		int m = mat[0].length;
		int h[][] = new int[n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			h[i+1][1] = h[i][1] + mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			h[1][i+1] = h[1][i] + mat[0][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				h[i+1][j+1] = mat[i][j] + h[i+1][j]+h[i][j+1] - h[i][j];
			}
		}
		
		return h;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,-40,6,-90,1,5};
		Best b = new Best(arr);
		System.out.println(Arrays.toString(b.getBestArr()));
		int mat[][] = {{-50,2,3},
					{-3,4,5},
					{14,-2,-4}};
		
		int mat2[][] = {{20,-30,5,7}
						,{-40,5,1,7}
						,{5,-20,-1,-1}};
		Best b2 = new Best(mat2);
		System.out.println(Arrays.toString(b2.getBestMat()));
	}
	
	public int[] getBestArr(){return new int[]{bestArr,iStart,iEnd,len};}
	public int[] getBestMat(){return new int[]{bestMat,i1Start,j1Start,i2End,j2End};}
}
