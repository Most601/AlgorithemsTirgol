package Huffman;

import java.util.concurrent.ArrayBlockingQueue;

public class Huffman {
	
	private int weight=0,left=1,right=2,parent=3;
	char chars[];
	int freq[];
	int tree[][];
	int size ;
	String codes[];
	ArrayBlockingQueue<Integer> q1,q2;
	/*
	 * assuming that chars and freq length are the same,
	 * and freq is sorted ascending
	 */
	public Huffman(char chars[] , int freq[]) {
		size = chars.length;
		this.chars = chars;
		this.freq = freq;
		codes = new String [size];
		tree = new int[2*size-1][4];
		q1 = new ArrayBlockingQueue<>(size);
		q2 = new ArrayBlockingQueue<>(size);
		for (int i = 0; i < freq.length; i++) {
			tree[i][weight] = freq[i];
			q1.add(i);
		}
		buildTree();
		buildCode("",2*size-2);
	}
	
	private int getMin(){
		if(q1.isEmpty() && q2.isEmpty()) return -1;
		if(q1.isEmpty()) return q2.poll();
		if(q2.isEmpty()) return q1.poll();
		if(tree[q1.peek()][weight] > tree[q2.poll()][weight]) return q2.poll();
		return q1.poll();
	}
	private void buildCode(String code, int i) {
		if(i<size){
			codes[i] = code;
			return;
		}
		buildCode(code + "0", tree[i][left]);
		buildCode(code + "1", tree[i][right]);
		
	}

	private void buildTree() {
		int k = size;
		while(q1.size()+q2.size() > 1){
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

	public static void main(String[] args) {
		char chars[] = {'f','e','c','b','d','a'};
		int freq[] = {5,9,12,13,16,45};
		HuffmanGil h = new HuffmanGil(chars, freq);
		System.out.println(h.getCode());
		System.out.println();
	}
}
