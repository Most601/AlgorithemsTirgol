package AlgoRehearsal3;

import java.util.ArrayList;
import java.util.Stack;

public class Euler3 {
	
	int deg[],numOfOddVert,v_start;
	ArrayList<Integer> g[];
	boolean isCycle,isPath;
	public Euler3(ArrayList<Integer> g[]) {
		this.g = g;
		isCycle=isPath=false;
		init();
		
	}
	private void init() {
		int n = g.length;
		deg = new int[n];
		numOfOddVert = 0;
		v_start = 0;
		for (int i = 0; i < n; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2 == 1 ){
				numOfOddVert++;
				v_start = i;
			}
		}
		if(numOfOddVert==0) isPath=isCycle = true;
		else if (numOfOddVert==2) isPath = true;
	}
	
	public ArrayList<Integer> eulerPath(){
		if(!isPath) return null;
		return eulerAlgo();
	}
	public ArrayList<Integer> eulerCycle(){
		if(!isCycle) return null;
		return eulerAlgo();
	}
	
	private ArrayList<Integer> eulerAlgo() {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		s.push(v_start);
		while(!s.isEmpty()){
			int v = s.peek();
			if(deg[v] == 0){
				ans.add(v);
				s.pop();
			}
			else{
				int u = g[v].get(0);
				s.add(u);
				deg[v]--;
				deg[u]--;
				g[u].remove((Integer)v);
				g[v].remove((Integer)u);
			}
		}
		
		return ans;
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
	//	g[3].add(5);
		g[4].add(0);
		g[4].add(5);
		g[5].add(4);
	//	g[5].add(3);
		Euler3 e = new Euler3(g);
		System.out.println(e.eulerPath());
	}
}
