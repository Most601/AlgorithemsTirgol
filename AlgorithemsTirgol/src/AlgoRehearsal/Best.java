package AlgoRehearsal;

public class Best {

	public static int RegularBest(int arr[]){
		
		int start = getFirstPos(arr);
		int maxSum=arr[start];
		int sum = 0;
		int beginIndex=start;
		int endIndex;
		int tempBegin = start;
		for (int i = start; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				beginIndex = i+1;
				sum=0;
			}
			else if(sum>=maxSum){
				endIndex = i;
				maxSum = sum;
				beginIndex = tempBegin;
			}
		}
		
		return maxSum;
	}
	
	public static int CyclicBest(int arr[]){
		int temp[] = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i]*-1;
		}
		return Math.max(RegularBest(arr),arrSum(arr)+RegularBest(temp) );
	}
	
	public static int arrSum(int arr[]){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static int getFirstPos(int arr[]){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]<min) min = arr[i];
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		int arr[] = {-10,8,-1,8,-9,1,-1,-9,1,-9};
		int arr2[] = {1,-9,2,3};
		System.out.println(RegularBest(arr2));
		System.out.println(CyclicBest(arr2));
	}
}
