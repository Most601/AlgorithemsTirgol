package AlgoRehearsal3;

import java.util.ArrayList;
import java.util.Stack;


public class Euler {
	
	int deg[];
	ArrayList<Integer> g[];
	boolean isPath,isCycle;
	int v_start;
	public Euler(ArrayList<Integer> g[]) {
		this.g = g;
		isCycle=isPath=false;
		init();
	}
	private void init() {
		int n = g.length;
		int numOfOddDegrees=0;
		v_start = 0;
		deg = new int[n];
		for (int i = 0; i < n; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2 == 1){
				numOfOddDegrees++;
				v_start = i;
			}
		}
		if(numOfOddDegrees==0) isPath=isCycle=true;
		else if(numOfOddDegrees==2) isPath=true;
		
	}
	public ArrayList<Integer> eulerPath(){
		if(isPath==false) return null;
		return eulerAlgo();
	}
	public ArrayList<Integer> eulerCycle(){
		if(isCycle==false) return null;
		return eulerAlgo();
	}
	private ArrayList<Integer> eulerAlgo() {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		st.push(v_start);
		while(!st.isEmpty()){
			int u = st.peek();
				if(deg[u]==0){
					ans.add(u);
					st.pop();
				}
				else{
					int v = g[u].get(0);
					st.push(v);
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
		g[3].add(5);
		g[4].add(0);
		g[4].add(5);
		g[5].add(4);
		g[5].add(3);
		Euler e = new Euler(g);
		System.out.println(e.eulerPath());
	}
}
