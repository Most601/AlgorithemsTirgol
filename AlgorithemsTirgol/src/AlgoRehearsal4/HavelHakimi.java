package AlgoRehearsal4;

import java.util.ArrayList;
import java.util.Arrays;

public class HavelHakimi {

	public static boolean isGraph(int deg[]){
		int n = deg.length;
		int sum = 0;
		for (int i = 0; i < n ; i++) {
			sum+=deg[i];
		}

		if(sum % 2 != 0) return false;

		Arrays.sort(deg);
		for (int i = n-1; i >= 0; i--) {
			if(deg[i]!=0){
				int d = deg[i];
				if(i-d<0) return false;
				deg[i] =0;
				for (int j = i-1; j >= i-d; j--) {
					if(deg[j]==0) return false;
					deg[j]--;
				}
			}
			if(i!=0)
				Arrays.sort(deg,0,i-1);

		}

		return true;
	}

	public static boolean isTree(int deg[]){
		int sum = 0;
		for (int i = 0; i < deg.length; i++) {
			if(deg[i]==0) return false;
			sum+=deg[i];
		}
		if(sum != 2*deg.length - 2) return false;
		return isGraph(deg);
	}

	public static ArrayList<Integer> [] buildTree(int de[]){
		int deg[] = new int [de.length];
		for (int i = 0; i < deg.length; i++) {
			deg[i] = de[i];
		}
		if(!isTree(de)) return null;
		ArrayList<Integer> g[] = new ArrayList[deg.length];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i = 0; i < g.length; i++) {
			int d = deg[i];
			int k = 0;
			while(k<d){
				if(k==i || g[i].contains(k)) {k++;d++;}
				else {
					g[i].add(k);
					g[k].add(i);
					deg[k]--;
					k++;
				}
			}
			k=0;
		}

		return g;
	}

	public static void main(String[] args) {
		int deg[] = {1,2,1};
		ArrayList<Integer> g[] = buildTree(deg);
		System.out.println(Arrays.toString(g));
	}

}
