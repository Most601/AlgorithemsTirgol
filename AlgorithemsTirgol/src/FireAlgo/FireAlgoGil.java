package FireAlgo;

import java.util.ArrayList;

/**
 * Find the center of tree graph (connected without cycles) and the radius
 * Complexity: O(|V|) , (|E|=|V|-1)
 */
public class FireAlgoGil {
	private int center1,center2;
	private int radius;
	private ArrayList<Integer>[] tree;

	public FireAlgoGil(ArrayList<Integer>[] g){
		tree = g;
		center1=center2=-1;
		radius = -1;
		fire();
	}

	private void fire(){
		radius = 0;
		int n = tree.length;
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		int[] deg = new int[n];
		for (int i = 0; i < n; i++) {
			deg[i] = tree[i].size();
			if(deg[i]==1)leaves.add(i);
		}
		int v = n;
		while(v>2){
			int l = leaves.size();
			for (int i = 0; i < l; i++) {
				int index = leaves.remove(0);
				deg[index] = 0;
				v--;
				for (int j = 0; j < tree[index].size(); j++) {
					int ni = tree[index].get(j);
					deg[ni]--;
					if(deg[ni]==1)leaves.add(ni);
				}
			}
			radius++;
		}
		if(leaves.size()>1) {
			center1 = leaves.remove(0);
			center2 = leaves.remove(0);
		}
		else {
			center1 = center2 = leaves.remove(0);
		}
	}

	public int getRadius(){
		return radius;
	}

	public int getCenter1(){
		return center1;
	}

	public int getCenter2(){
		return center2;
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
		System.out.println(f2.center1);
		System.out.println(f2.center2);
		System.out.println(f2.radius);
		System.out.println(f2.diameter);
	}
}
