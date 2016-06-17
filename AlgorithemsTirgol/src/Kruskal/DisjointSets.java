package Kruskal;

public class DisjointSets {

	int parent[];
	int rank[];
	public DisjointSets(int size) {
		rank = new int[size];
		parent = new int[size];
	}
	void makeSet(int k){
		parent[k] = k;
		rank[k] = 0;
	}
	boolean union(int g1,int g2){
		int xRoot = find(g1);
		int yRoot = find(g2);
		if(xRoot != yRoot){
			if(rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
			else if (rank[yRoot] < rank[xRoot]) parent[yRoot] = xRoot;
			else{
				parent[yRoot] = xRoot;
				rank[xRoot]++;
			}
			return true;
		}
		return false;
	}
	int find(int p){
		if(parent[p] != p) parent[p] = find(parent[p]);
		return parent[p];
	}
}
