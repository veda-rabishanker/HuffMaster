import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;
import java.util.HashMap;
import java.io.*;

public class Entropy  {
    public static void main(String[] args){
        
        Scanner fileReader; 
        String content;
        try{
            fileReader= new Scanner(new FileReader("banana.txt"));
            content = fileReader.nextLine();
        }
        catch(FileNotFoundException e){
            System.out.println("cannot find file");
            return;
        }
        
        String [] sep = content.split("");
        HashMap<String, Integer> occurrences = new HashMap <String, Integer>();

        for(String letter : sep){
        	if(!occurrences.containsKey(letter)){
        		occurrences.put(letter, 1);
        	}else{
        		int value = occurrences.get(letter);
        		occurrences.put(letter, ++value);
        	}
        }
        System.out.println("CHARACTER ENCODING:");
        System.out.println(occurrences);

        Set<String> keys = occurrences.keySet();
        PriorityQueue<Node> nodes = new PriorityQueue<Node>();

        for(String key : keys){
        	Node store = new Node(key, occurrences.get(key));
        	nodes.add(store);
        }

        while(nodes.size() > 1){

        	Node x = nodes.poll();
        	Node y = nodes.poll();

        	Node newNode = new Node(null, x.frequency + y.frequency);

        	newNode.left = x;
        	newNode.right = y;

        	nodes.add(newNode);
        }
        BinaryTree theTree = new BinaryTree(nodes.poll());
        // theTree.preOrder();
        HashMap<String , String> j = theTree.encode(theTree.root);
        System.out.println(j);
        String bit = "";
        for(String character: sep){
        	bit+= j.get(character);
        }
        String k = "0010011000101001100110011001000110101000100110011010100110011010001100";
        System.out.println(bit);
        System.out.print(bit.equals(k));

    }
}