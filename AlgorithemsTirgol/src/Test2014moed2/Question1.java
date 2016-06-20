package Test2014moed2;

public class Question1 {

	
	public static double bestShortestSubInterval(double[] a){
		
		double max =a[0];
		double sum = max;
		double iStart=0,iEnd=0;
	//	double len = a.length;
		double tempBegin = -1;
		for (int i = 1; i < a.length; i++) {
			sum+=a[i];
			if(sum<=0) {
				sum=0;
				iStart=i+1;
			}
			else if(sum>=max){
				max = sum;
				iEnd=i;
				tempBegin = iStart;
			}
		}
		return iEnd - tempBegin+1;
		
	}
	
	public static void main(String[] args) {
		double a[] = {1,2,3,-50,2,4,-34,4};
		System.out.println(bestShortestSubInterval(a));
	}
}
