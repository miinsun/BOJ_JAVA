/* 백준 그래프 - 1991 :: 트리 순회 */

import java.util.*;
import java.io.*;

class Node { 
	public char data; 
	Node lt, rt;
	
	Node (char data){ 
		this.data = data;
	} 
}
	
class Tree{
	Node root;
	
	void add(char data, char left, char right) {
		if(root == null) {
			if(data != '.')
				root = new Node(data);
			if(left != '.')
				root.lt = new Node(left);
			if(right != '.')
				root.rt = new Node(right);
		}
		else
			search(root, data, left, right);
	}
	
	void search(Node root, char data, char left, char right) {
		if(root == null) return;
		else if(root.data == data) {
			if(left != '.') 
				root.lt = new Node(left);
			if(right != '.')
				root.rt = new Node(right);
		}
		else {
			search(root.lt, data, left, right);
			search(root.rt, data, left, right);
		}
	}
	
	void preOrder(Node root) {
		//root -> left -> right
		System.out.print(root.data);
		if(root.lt != null) preOrder(root.lt);
		if(root.rt != null) preOrder(root.rt);
	}
	
	void inOrder(Node root) {
		// left -> root -> right
		if(root.lt != null) inOrder(root.lt);
		System.out.print(root.data);
		if(root.rt != null) inOrder(root.rt);
	}
	
	void postOrder(Node root) {
		// left -> right -> root
		if(root.lt != null) postOrder(root.lt);
		if(root.rt != null) postOrder(root.rt);
		System.out.print(root.data);
	}
}

public class Main {		
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		Tree tree = new Tree();
		for(int i = 0; i < n; i++) {
			tree.add(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
		}
			
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
		sc.close();
	}
}