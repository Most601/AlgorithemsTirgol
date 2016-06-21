package Test2013moed1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Question4 {
	ArrayList<Integer> g[];
	int [] color,dist;
	int diameter;
	int size;
	public Question4(ArrayList<Integer> g[]) {
		this.g = g;
		size = g.length;
		diameter = Integer.MIN_VALUE;
		
	}
	
	public int findDiameter (){
		BFS(0);
		int farest = findIndexMax();
		BFS(farest);
		
		for (int i = 0; i < dist.length; i++) {
			if(dist[i] > diameter ) diameter = dist[i];
		}
		
		
		
		return diameter;
	}
	public int findIndexMax(){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dist.length; i++) {
			if(dist[i]>max) max = i;
		}
		return max;
	}
	public void BFS(int source){
		color = new int[g.length];
		dist = new int[g.length];
		Arrays.fill(dist, Integer.MIN_VALUE);
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(size);
		q.add(source);
		dist[source] = 0;
		while(!q.isEmpty()){
			int u = q.poll();
			color[u] = 1;
			for (Integer v : g[u]) {
				if(color[v] == 0){
					color[v] = 1;
					dist[v] = dist[u]+1;
					q.add(v);
				}
			}
			color[u] = 2;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = init1();
		ArrayList<Integer> g2[] = init2();
		ArrayList<Integer> g3[] = init3();
		Question4 q = new Question4(g);
		Question4 q2 = new Question4(g2);
		Question4 q3 = new Question4(g3);
		System.out.println(q.findDiameter());
		System.out.println(q2.findDiameter());
		System.out.println(q3.findDiameter());
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
	
	public static ArrayList<Integer> [] init3(){
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(5);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[5].add(1);
		g[5].add(6);
		g[6].add(5);
		return g;
	}
}
