import java.util.*;
import java.io.*;

public class Node implements Comparable<Node>{
	public String character;
	public Integer frequency;
	public Node left;
	public Node right;
	//intializes the frequency and the character itself to the Node
	public Node(String character, Integer frequency){
		this.character = character;
		this.frequency = frequency;
	}
	//pre: requires 2 nodes to exist, post: return a positive number if 
	//the currentNode versus another Node is greater and vice versa if the currentNode is less
	@Override
	public int compareTo(Node other){
		return this.frequency - other.frequency;
	}
	//returns the frequency and character of a node, requires it to be initialized
	@Override
	public String toString(){
		if(character == null){
			return "" + frequency;
		}
		return character + frequency;
	}

}