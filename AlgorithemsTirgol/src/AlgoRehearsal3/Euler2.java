package AlgoRehearsal3;

import java.util.ArrayList;
import java.util.Stack;


public class Euler2 {
	int deg[];
	ArrayList<Integer> g[];
	int numOfOddVert,v_start;
	boolean isPath,isCycle;
	public Euler2(ArrayList<Integer> g[]) {
		this.g = g;
		init();
		
	}
	
	private void init() {
		numOfOddVert = 0;
		v_start = 0;
		int n = g.length;
		isCycle=isPath=false;
		deg = new int[n];
		for (int i = 0; i < n; i++) {
			deg[i] = g[i].size();
			if(deg[i] % 2 == 1){
				numOfOddVert++;
				v_start = i;
			}
		}
		if(numOfOddVert==0)isCycle=isPath=true;
		else if(numOfOddVert==2) isPath = true;
		
	}

	private ArrayList<Integer> eulerPath() {
		if(isPath==false) return null;
		return euler();
	}
	private ArrayList<Integer> eulerCycle() {
		if(isCycle==false) return null;
		return euler();
	}
	private ArrayList<Integer> euler() {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		s.push(v_start);
		while(!s.isEmpty()){
			int u = s.peek();
			if(deg[u]==0){
				ans.add(u);
				s.pop();
			}
			else{
				int v = g[u].get(0);
				s.push(v);
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
		ArrayList<Integer> g[] = new ArrayList[6];
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
		Euler2 e = new Euler2(g);
		System.out.println(e.eulerPath());
	}

	
}
