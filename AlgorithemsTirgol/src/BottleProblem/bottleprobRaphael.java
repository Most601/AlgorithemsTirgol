package BottleProblem;

public class bottleprobRaphael {

	public static int getindex(int i , int j , int n){
		return (n+1)*i+j;
	}
	
	public static int[][] initRibs(int n, int m) { 
		
		int dim=(n+1)*(m+1);
		int [][] mat= new int[dim][dim];
		int ind1 , ind2;
		for(int i=0 ; i<=n ; i++){
			for(int j=0 ; j<=m ; j++){
				ind1=getindex(i,j,m);
				
				mat[ind1][getindex(0,j,m)]= 1;
				mat[ind1][getindex(n,j,m)]= 1;
				mat[ind1][getindex(i,0,m)]= 1;
				mat[ind1][getindex(i,m,m)]= 1;
				
				ind2 = getindex(Math.min(i+j,n), i+j-Math.min(i+j,n),m);
				mat[ind1][ind2]=1 ;
				
				ind2 = getindex(i+j-Math.min(i+j,m), Math.min(i+j,m),m); 
				mat[ind1][ind2]= 1;
			}
		}
		for(int t=0; t<dim ;t++){
			mat[t][t]=0;
		}
		return mat;
	}
	public static void printmat(int [][] mat){
		for(int i=0 ; i<mat.length ; i++){
			System.out.print("[ ");
			for(int j=0 ; j<mat[0].length ; j++){
				System.out.print(mat[i][j]+",");
			}
			System.out.println("]");
		}
	}	
	public static void printmat2(boolean [][] mat){
		for(int i=0 ; i<mat.length ; i++){
			System.out.print("[ ");
			for(int j=0 ; j<mat[0].length ; j++){
				System.out.print(mat[i][j]+",");
			}
			System.out.println("]");
		}
	}

	public static boolean[][] inttoboolean(int [][] mat){
		boolean [][] ans=new boolean[mat.length][mat.length];
		for(int i=0 ; i<ans.length ; i++){
			for(int j=0 ; j<ans.length ; j++){
				if(mat[i][j]==0 ){
					ans[i][j]=false;
				}else{
					ans[i][j]=true;
				}
			}
		}
		return ans;
	}
	
	public static String[][] ConnectPossibleVertex(boolean mat[][],int m) {
		int dim=mat.length;
		int a0=0, b0=0, a1=0, b1=0;
		String ans[][] = new String[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
			
				a0= i / (m+1);
				b0= i % (m+1);
				a1= j / (m+1);
				b1= j % (m+1);
				
				if(mat[i][j]==true){
					ans[i][j]= "["+a0+","+b0+"]->["+a1+","+b1+"]";
				}else{
					ans[i][j]=new String();
				}
			}
		}
		for (int k = 0; k < ans.length; k++) {
			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < ans.length; j++) {
					if(mat[i][j]==false){
						mat[i][j]=mat[i][k]&&mat[k][j];
						if(mat[i][j]==true){
							ans[i][j]= ans[i][k]+"--->"+ans[k][j];
						}
					}
				}
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		int [][] mat=initRibs(1,2);
		printmat(mat);
		boolean [][] mat2=inttoboolean(mat);
		printmat2(mat2);
		
	}
}
