package HavelHakimi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HavelHakimi {
	
	int deg[];
	int sumDeg;
	int sizeTree;
	boolean finished=false;
	public HavelHakimi(int deg[]) {
		this.deg = sort(deg,0);
		sizeTree = deg.length;
	}
	
	private void buildGraph() {
		
		for (int i = 0; i < deg.length; i++) {
			if(check() == false) break;
			System.out.println(Arrays.toString(deg));
			if(finished == true) break;
			
			int max = deg[i];
			deg[i] = 0;
			for (int j = i+1; j <= max + i; j++) {
				deg[j]--;
			}
			if(i!= deg.length-1)
			deg = sort(deg,i+1);
			
		}
		if(finished == true) System.out.println("Build Graph succesfuly");
		else System.out.println("Something went wrong");
		
		
	}
	
	private boolean check() {
		int count = 0;
		for (int i = 0; i < deg.length; i++) {
			if(deg[i]<0 || deg[i] >= deg.length) return false;
			if(deg[i] == 0) count++;
		}
		if((sumDeg % 2) == 1) return false;
		if(count == deg.length ) finished = true;
		return true;
		
	}
	
	private int[] sort(int[] deg,int from) {
		int temp []= new int[deg.length];
		Arrays.sort(deg,from,deg.length);
		int k = from;
		for (int i = deg.length-1; i >= from; i--) {
			temp[k++] = deg[i]; 
		}
		return temp;
	}

	public static void main(String[] args) {
		int deg[] = {1,2,1};
		HavelHakimi h = new HavelHakimi(deg);
		h.buildGraph();
		int deg2[] = {3,1,1,1};
		HavelHakimi h2 = new HavelHakimi(deg2);
		h2.buildGraph();
		int deg3[] = {4,3,3,3,1};
		HavelHakimi h3 = new HavelHakimi(deg3);
		h3.buildGraph();
	}

	
}	
