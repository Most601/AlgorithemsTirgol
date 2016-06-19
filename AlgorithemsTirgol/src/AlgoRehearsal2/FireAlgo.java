package AlgoRehearsal2;

import java.util.ArrayList;


public class FireAlgo {
	
	ArrayList<Integer> graph[];
	ArrayList<Integer> leaves;
	int center1,center2,radius;
	int deg[];
	int diameter;
	public FireAlgo(ArrayList<Integer> g[]) {
		this.graph = g;
		center1=center2=-1;
		init();
		fire();
	}
	
	private void init() {
		deg = new int[graph.length];
		leaves = new ArrayList<>();
		for (int i = 0; i < deg.length; i++) {
			deg[i] = graph[i].size();
			if(deg[i]==1)leaves.add(i);
		}
		
	}

	private void fire() {
		radius = 0;
		int n = graph.length;
		while(n>2){
			int l = leaves.size();
			for (int i = 0; i < l; i++) {
				int index = leaves.remove(0);
				deg[index]--;
				n--;
				for (int j = 0; j < graph[index].size(); j++) {
					int u = graph[index].get(j);
					deg[u]--;
					if(deg[u]==1) leaves.add(u);
				}
			}
			radius++;
			
		}
		
		
		if(leaves.size()>1){
			center1=leaves.remove(0);
			center2=leaves.remove(0);
			radius++;
			diameter = (2*radius)-1;
		}
		else{
			center1=center2=leaves.remove(0);
			diameter = 2*radius;
		}
		
	}

	public static void main(String[] args) {
		
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
		g[6].add(5);
		FireAlgo f = new FireAlgo(g);
		System.out.println(f.center1);
		System.out.println(f.center2);
		System.out.println(f.radius);
		System.out.println(f.diameter);
		
		ArrayList<Integer> tree[] = new ArrayList[7];
		for (int i=0; i<tree.length; i++)
		{
			tree[i] = new ArrayList<Integer>();
		}
		tree[0].add(1);//1->2
		////////////
		tree[1].add(0);//2->1
		tree[1].add(2);//2->3
		tree[1].add(4);//2->5
		///////////
		tree[2].add(1);//3->2
		tree[2].add(3);//3->4
		/////////////
		tree[3].add(2);//4->3
		////////////
		tree[4].add(1);//5->2
		tree[4].add(5);//5->6
		////////////
		tree[5].add(4);//6->5
		tree[5].add(6);//6->7
		////////////
		tree[6].add(5);//7->6
		
		System.out.println("======F2=========");
		FireAlgo f2 = new FireAlgo(tree);
		System.out.println("center1:"+f2.center1);
		System.out.println("center2:"+f2.center2);
		System.out.println("radius:"+f2.radius);
		System.out.println("diameter:"+f2.diameter);
	}
	
}
