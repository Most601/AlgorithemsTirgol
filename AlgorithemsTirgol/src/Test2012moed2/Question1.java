package Test2012moed2;

import java.util.ArrayList;
import java.util.Arrays;

public class Question1 {
	
	public static boolean isPath(ArrayList<Integer> g[]){
		int numOfOdd= 0;
		int deg [] = new int[g.length];
		for (int i = 0; i < g.length; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2 == 1) numOfOdd++;
		}
		if(numOfOdd==0 || numOfOdd==2) return true;
		return false;
	}
	public static void main(String[] args) {
		ArrayList<Integer> g[] = init1();
		ArrayList<Integer> g2[] = init2();
		System.out.println((isPath(g)));
		System.out.println((isPath(g2)));
	}
	private static ArrayList<Integer>[] init2() {
		ArrayList<Integer> g[] = new ArrayList[3];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		return g;
	}

	public static ArrayList<Integer> [] init1(){
		ArrayList<Integer> g[] = new ArrayList[4];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(3);
		g[2].add(1);
		g[3].add(1);
		return g;
	}
	
}
