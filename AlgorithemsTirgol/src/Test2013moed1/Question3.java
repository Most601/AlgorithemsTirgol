package Test2013moed1;

import java.util.concurrent.ArrayBlockingQueue;

public class Question3 {
	
	int weight=0,left=1,right=2,parent=3;
	char chars[];
	String codes[];
	int freq[],tree[][];
	int n;
	ArrayBlockingQueue<Integer> q1,q2;
	public Question3(char chars[],int freq[]) {
		n = chars.length;
		this.chars = chars;
		this.freq = freq;
		codes = new String [n];
		tree = new int[2*n-1][4];
		q1 = new ArrayBlockingQueue<Integer>(n);
		q2 = new ArrayBlockingQueue<Integer>(n);
		for (int i = 0; i < n; i++) {
			q1.add(i);
		}
		buildTree();
		buildCode("",2*n-2);
	}
	
	
	private void buildTree() {
		int k = n;
		while(q1.size() + q2.size() > 1){
			int l = getMin();
			int r = getMin();
			tree[l][parent] = k;
			tree[r][parent] = k;
			tree[k][weight] = tree[l][weight] + tree[r][weight];
			tree[k][left] = l;
			tree[k][right] = r;
			q2.add(k);
			k++;
		}
		
	}


	private int getMin() {
		if(q1.isEmpty()) return q2.poll();
		if(q2.isEmpty()) return q1.poll();
		if(tree[q1.peek()][weight] > tree[q2.peek()][weight]) return q2.poll();
		return q1.poll();
	}


	private void buildCode(String code, int i) {
		if(i<n){
			codes[i] = code;
			return;
		}
		buildCode( code + "0", tree[i][left]);
		buildCode(code + "1", tree[i][right]);
		
	}
	
	private String getCode() {
		String ans = "";
		for (int i = 0; i < codes.length; i++) {
			ans = ans + chars[i] + ":" + codes[i] + "\n";
		}
		return ans;
	}

	public static void main(String[] args) {
		char chars[] = {'f','e','c','b','d','a'};
		int freq[] = {5,9,12,13,16,45};
		Question3 q = new Question3(chars, freq);
		System.out.println(q.getCode());
		System.out.println();
	}


	
}
