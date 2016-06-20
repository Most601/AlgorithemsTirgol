package Test2014moed1;

import java.util.ArrayList;
import java.util.Arrays;

public class Question3 {
	
	public static int[] diameter(ArrayList<Integer>[] tree){
		ArrayList<Integer> leaves = new ArrayList<>();
		int deg [] = new int [tree.length];
		for (int i = 0; i < deg.length; i++) {
			deg[i] = tree[i].size();
			if(deg[i]==1) leaves.add(i);
		}
		
		int v = tree.length;
		while(v>2){
			int leave = leaves.remove(0);
			deg[leave]--;
			v--;
			for (int i = 0; i < tree[leave].size(); i++) {
				int neighbor = tree[leave].get(i);
				deg[neighbor]--;
				if(deg[neighbor]==1){
					leaves.add(neighbor);
				}
			}
			
		}
		if(leaves.size()==2) return new int[]{leaves.remove(0),leaves.remove(0)};
		return new int[]{leaves.remove(0)};
	}
	
	
	public static ArrayList<Integer>[] initTree(){
		 int n = 4;
		 ArrayList<Integer>[] tree = new ArrayList[n];
		 for (int i=0; i<n; i++){
		 tree[i] = new ArrayList<Integer>(n);
		 }
		 tree[0].add(1);
		 tree[1].add(0); tree[1].add(2);
		 tree[2].add(1); tree[2].add(3);
		 tree[3].add(2);
		 return tree;
		 }
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = initTree();
		System.out.println(Arrays.toString(diameter(g)));
	}
}
