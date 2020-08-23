import java.util.*;
import java.io.*;

public class Huffman{
	private String original_String, encoded_String, decoded_String;
	public HashMap<Character, Integer> mapWC;
	public HashMap<String, Character> mapCodeR;
	public HashMap<Character, String> mapCode;
	private PriorityQueue<node> q;
	private int treeSize;
	private node root;

	private class node{
		node left, right;
		int count;
		char ch;
		private node(char ch, int count, node left, node right){
			this.ch = ch;
			this.count = count;
			this.left = left;
			this.right = right;
		}
	}

	protected String decode(){
		StringBuilder sb = new StringBuilder();
		String t = "";
		for(int i = 0; i < encoded_String.length(); i++){
			t += encoded_String.charAt(i);
			if(mapCodeR.containsKey(t)){
				sb.append(mapCodeR.get(t));
				t = "";
			}
		}
		decoded_String = sb.toString();
		return decoded_String;
	}

	protected String encode(){
		StringBuilder sb = new StringBuilder();
		char ch;
		for(int i = 0; i < original_String.length(); i++){
			ch = original_String.charAt(i);
			sb.append(mapCode.get(ch));
		}
		encoded_String = sb.toString();
		return encoded_String;
	}

	private boolean isLeaf(node n){
		if(n.left != null)return false;
		else if(n.right != null)return false;
		return true;
	}
	private void map_char_to_code(node n, String code){
		if(n != null){
			if(isLeaf(n)){
				mapCode.put(n.ch, code);
				mapCodeR.put(code, n.ch);
			}
			else{
				map_char_to_code(n.left, code + '0');
				map_char_to_code(n.right, code + '1');
			}
		}
	}

	private void make_tree(){
		node left, right;
		while(!q.isEmpty()){
			left = q.poll();
			if(q.peek() != null){
				right = q.poll();
				root = new node('\0', left.count + right.count, left, right);
				treeSize++;
			}
			else{
				root = new node('\0', left.count, left, null);
			}
			if(q.peek()!= null)q.offer(root);
			//left else part
			else{
				treeSize++;
				break;
			}
		}
	}

	private void map_Char_to_count(){
		for(int i = 0; i < original_String.length(); i++){
			mapWC.put(original_String.charAt(i), mapWC.getOrDefault(original_String.charAt(i), 0)+1);
		}
	}

	private void make_leaf(){
		for(Map.Entry<Character,Integer> e: mapWC.entrySet()){
			q.offer(new node(e.getKey(), e.getValue(), null, null));
		}
	}

	Huffman(String original_String){
		this.original_String = original_String;
		treeSize = 0;
		mapWC = new HashMap<>();
		mapCode = new HashMap<>();
		mapCodeR = new HashMap<>();
		q = new PriorityQueue<node>(new Comparator<node>()
		{
			@Override
			public int compare(node n1, node n2){
				if(n1.count < n2.count)return -1;
				else if(n1.count > n2.count) return 1;
				return 0;
			}
		});

		map_Char_to_count();
		make_leaf();
		make_tree();
		map_char_to_code(root, "");
	}

}