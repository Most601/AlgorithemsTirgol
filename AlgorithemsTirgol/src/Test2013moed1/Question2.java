package Test2013moed1;

import java.util.Arrays;

public class Question2 {
	
	public static int [] best(int arr[]){
		
		int max = arr[0],sum=max;
		int iStart=0,iEnd=0,tempBegin=0;
		int len=arr.length;
		for (int i = 1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				sum=0;
				tempBegin=i+1;
			}
			else if(sum >= max){
				max = sum;
				if(i-tempBegin+1 < len){
				len = i-tempBegin+1;
				iStart = tempBegin;
				iEnd = i;
				}
			}
		}
		
		
		return new int [] {max,iStart,iEnd};
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,-40,6,-90,2,4};
		System.out.println(Arrays.toString(best(arr)));
	}
}
