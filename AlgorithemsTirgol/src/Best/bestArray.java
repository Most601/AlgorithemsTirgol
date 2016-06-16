package Best;

public class bestArray {
	
	int beginMax;
	int endMax;
	int arr[];
	int max;
	public bestArray(int arr[]) {
		this.arr = arr;
	}
	
	public int getBest(int arr[]){
		beginMax = getFirstPos(arr);
		max=arr[beginMax];
		int sum=0;
		int tempBegin = beginMax;
		for (int i = beginMax; i < arr.length; i++) {
			sum = sum + arr[i];
			if(sum<=0){
				sum = 0;
				beginMax = i+1;
			}
			else if (sum>=max){
				 max = sum;
				 beginMax = tempBegin;
				 endMax = i;
			}
		}
		return max;
	}
	public int cyclicBest(){
		int negativs[] = new int[arr.length];
		for (int i = 0; i < negativs.length; i++) {
			negativs[i] = arr[i]*-1;
		}
		return (Math.max(getBest(arr), getSum(arr) + getBest(negativs)));
	}
	
	public static int getSum(int arr[]){
		int sum=0;
		for (int i = 0; i < arr.length; i++) sum+=arr[i];
		return sum;
	}
	
	public static int getFirstPos(int arr[]){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int arr[] = {-10,8,-1,8,-9,1,-1,-9,1,-9};
		int arr2[] = {1,-9,2,3};
		bestArray b = new bestArray(arr);
		bestArray b2 = new bestArray(arr2);
		System.out.println(b2.cyclicBest());
	}
	
}
