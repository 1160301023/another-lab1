package debug.textProcesser;

import java.util.LinkedList;

public class Trie {
	Node root = new Node(this);
	Node pointer = new Node(this);
	LinkedList<Node> nodeSet = new LinkedList<Node>();
	
	// Adds a word to the Trie
	public void addWord(String s) {
		char[] arr = s.toCharArray();
		/*for(int i = 0;i<arr.length;i++){
			System.out.println(i);
		}*/
		for (int i=0;i<arr.length;i++){ 
				pointer.addChild(arr[i]);
		}
		
		Node leaf = new Node(true, s.hashCode());
		pointer.addLeafChild(leaf);
		nodeSet.add(leaf);
	}
	
	// Displays the current state of the Trie
	public void display() {
		pointer = root;
		for (Node n : nodeSet) {
			for(int i = 0; i < n.childValues().size(); i++) {
					System.out.println("Node Value: " + n + ", Children: "+n.childValues().get(i));
			}
			if(n.isLeaf){
				System.out.println("Node Value: " + n+ ", Children: "+", isLeaf: " + n.isLeaf + ", hashcode: " + n.hashCode());
			}
		}
	}
	// Prints all the nodes in a nodeSet and displays whether or not they have a
	// child that is a leaf
	public void hasLeaf() {
		for (Node n : nodeSet) {
			if (n.isLeaf){
				System.out.println("true");
			}
		}
	}
}
