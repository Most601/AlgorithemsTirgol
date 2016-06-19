package AlgoRehearsal2;

public class DisjointSets {
	int parent[],rank[];
	public DisjointSets(int num) {
		rank = new int[num];
		parent = new int[num];

	}

	 void makeGroup(int num) {
		rank[num] = 0;
		parent[num] = num;
	}

	private int find(int x){
		if(parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	 boolean union(int x, int y){
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot!=yRoot){
			if(rank[xRoot]<rank[yRoot])parent[xRoot] = yRoot;
			else if(rank[xRoot]>rank[yRoot]) parent[yRoot] = xRoot;
			else{
				parent[yRoot] = xRoot;
				rank[xRoot]++;
			}
			return true;
		}
		return false;
	}
}
