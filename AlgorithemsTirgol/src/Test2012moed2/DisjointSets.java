package Test2012moed2;

public class DisjointSets {
	int rank[],parent[];
	public DisjointSets(int size) {
		rank = new int [size];
		parent = new int[size];
	}
	
	public void makeSet(int x){
		rank[x] = 0;
		parent[x] = x;
	}
	
	public int find(int x){
		if(parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public boolean union(int x ,int y){
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot!=yRoot){
			if(rank[xRoot]<rank[yRoot]) parent[xRoot] = yRoot;
			else if(rank[xRoot]>rank[yRoot]) parent[yRoot] = xRoot;
			else {
				parent[yRoot] = xRoot;
				rank[xRoot] ++;
			}
			return true;
		}
		
		return false;
	}
}
