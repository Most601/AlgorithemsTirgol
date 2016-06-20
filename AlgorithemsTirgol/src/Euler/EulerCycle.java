package Euler;

import java.util.ArrayList;
import java.util.Stack;

public class EulerCycle {
	
	int deg[],start;
	ArrayList<Integer>[] graph;
	boolean isCycle,isPath;
	public EulerCycle(ArrayList<Integer> g[]) {
		intDeg(g);
		graph = copy(g);
	}
	private ArrayList<Integer>[] copy(ArrayList<Integer>[] g) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] copy = new ArrayList[g.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = new ArrayList<>();
			for (int j = 0; j < g[i].size(); j++) {
				copy[i].add(g[i].get(j));
			}
		}
		
		return copy;
	}
	
	private ArrayList<Integer> EulerAlgo(){
		int v = start;
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> s = new Stack<Integer>();
		s.push(v);
		while(!s.isEmpty()){
			v = s.peek();
			if(deg[v]==0){
				ans.add((v));
				s.pop();
			}
			else{
				int u = graph[v].get(0);
				s.push(u);
				
				deg[v]--;
				deg[u]--;
				graph[v].remove((Integer)u);
				graph[u].remove((Integer)v);
			}
		}
		return ans;
	}
	
	
	
	private void intDeg(ArrayList<Integer>[] g) {
		deg = new int[g.length];
		int numOfOddVer=0;
		start = 0;
		for (int i = 0; i < g.length; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2==1){
				numOfOddVer++;
				start = i;
			}
		}
		if(numOfOddVer == 0){
			isCycle=isPath=true;
		}
		else if(numOfOddVer == 2){
			isPath = true;
		}
		
	}


	public ArrayList<Integer> eulerPath() {

		if(!isPath) {
			return null;
		}
		return EulerAlgo();
	}
	
	public ArrayList<Integer> eulerCycle() {

		if(!isCycle) {
			return null;
		}
		return EulerAlgo();
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[0].add(4);
		g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(5);
		g[4].add(0);
		g[4].add(5);
		g[5].add(4);
		g[5].add(3);
		EulerCycle e = new EulerCycle(g);
		System.out.println(e.eulerPath());
	}
}
