package AlgoRehearsal2;

import java.util.Arrays;

public class GasStationBest {
	
	/*
	 * assuming gasStations and gasPrices length are equal!
	 */
	public static boolean GasStationBest(int gasStations[],int gasPrices[]) {
		int dif[] = new int [gasPrices.length];
		int n = dif.length;
		for (int i = 0; i < dif.length; i++) {
			dif[i] = gasStations[i]- gasPrices[i];
		}
		
		int best[] = getBestSum(dif);
		int sum = 0;
		for (int i = 0; i < dif.length; i++) {
			sum+=dif[(best[1]+i)%n];
			if(sum<0) return false;
		}
		
		return true;
	}
	private static int[] getBestSum(int[] dif) {
		int len = dif.length;
		int best1[] = best(dif);
		int negDif[] = new int [dif.length];
		int sumAll=0;
		for (int i = 0; i < dif.length; i++) {
			negDif[i] = dif[i]*-1;
			sumAll+=dif[i];
		}
		int negBest[] = best(negDif);
		
		
		if(best1[0]<0 || best1[0] >= sumAll + negBest[0] ) return best1;
		else{
			return new int[]{sumAll+negBest[0],negBest[2]%len,negBest[1]-1};
		}
		
		
		
	}
	public static int [] best(int arr[]){
		int i_start=0,i_end=0;
		int beginTemp=getFirstPost(arr);
		int max = arr[beginTemp];
		int sum=max;
		for (int i = beginTemp+1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum>=max){
				max = sum;
				i_end=i;
				i_start = beginTemp;
			}
			else if (sum<=0){
				sum = 0;
				i_start = i+1;
			}
		}
		return new int[]{max,i_start,i_end};
	}
	
	private static int getFirstPost(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		int gasStations[] = {1,4,3,7,2,4,8};
		int gasPrices[] = {3,5,2,1,4,3,9};
		System.out.println(GasStationBest(gasStations, gasPrices));
	}
}
