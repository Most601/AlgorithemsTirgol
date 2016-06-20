package Test2014moed1;

public class Question2 {
	public static double bestCycle(double[] a){
		double neg[] = new double[a.length];
		double sum=0;
		for (int i = 0; i < neg.length; i++) {
			neg[i] = a[i]*-1;
			sum=sum+a[i];
		}
		return Math.max(best(a),sum + best(neg));
	}
	
	private static double best(double []a){
		double max=a[0],sum=max;
		for (int i = 1; i < a.length; i++) {
			sum+=a[i];
			if(sum<=0) sum=0;
			else if(sum>=max)max=sum;
		}
		return max;
	}
	
	public static void main(String[] args) {
		double a[] = {1,2,-8,3};
		System.out.println(bestCycle(a));
	}
}
