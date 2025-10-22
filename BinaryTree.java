import java.util.*;
import java.io.*;

public class BinaryTree{
	public Node root;
	public BinaryTree(Node root){
		this.root = root;
	}
	//pre: requires an int key, post: calls addRecur
	public void add(Node n){
		int key = n.frequency;
		root = addRecur(root, key);
	}
	//pre: a binary tree should be initialized
	//this method checks if the Node is null, if so intializing the Node to the key value the user wants other wise checks if the 
	//currentNode is greater than the key value, if so then placed on the left side, otherwise the right side
	//post: returns the innerRoot
	public Node addRecur(Node innerRoot, int key){
		if(innerRoot == null){
			innerRoot = new Node(null, key);
			return innerRoot;
		}
		Node holder = new Node(null, key);
		if(innerRoot.compareTo(holder) > 0){
			innerRoot.left = addRecur(innerRoot.left, key);
		}else if(innerRoot.compareTo(holder) < 0){
			innerRoot.right = addRecur(innerRoot.right, key);
		}
		return innerRoot;
	}

	// public void preOrder(){
	// 	preOrderRecur(root);
	// }
	
	// public void preOrderRecur(Node root){
	// 	if(root == null){
	// 		return;
	// 	}
	// 	System.out.println(root.frequency + " ");

	// 	preOrderRecur(root.left);

	// 	preOrderRecur(root.right);
	// }
	//pre: the binary tree needs to be initialized
	//this method calls the traversalRecur and creates a HashMap that stores all the bit values created by the method
	//returns the HashMap with the binary value and the character that belongs to it;
	public HashMap<String, String> encode(Node root){
		HashMap<String, String> occur = new HashMap<String, String>();
		traversalRecur(root, "",occur);
		return occur;

	}
	//pre: binary tree needs to be intialized and the encode method call needs to be called for this method to run
	//checks if the null given is null otherwise recusrivly going through the BinaryTree checking if the node is a
	//leaf. Otherwise whilst traverising, added the bit value of 1 if left and 0 if right until you have a completed
	//binary and found the character. 
	public void traversalRecur(Node root, String binaryReturn,HashMap<String, String> occur){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			occur.put(root.character, binaryReturn);
			return;
		}

		if(root.left != null){
			traversalRecur(root.left, binaryReturn + "1", occur);
		}

		if(root.right != null){
			traversalRecur(root.right, binaryReturn + "0", occur);
		}


	}
}
