# HuffMaster: Lossless Text Compression with Huffman Encoding
**Date Completed:** March 25, 2025  
**Course:** CS3  

---

## Project Overview
This program implements **lossless text compression** using **Huffman coding.**
It reads a text file, calculates character frequencies, builds a binary tree, and generates compressed bit patterns for the text.

---

## Features
-Counts occurrences of each character in a text file<br>
-Creates a priority queue of nodes based on frequency<br>
-Builds a Huffman tree by combining the two lowest-frequency nodes repeatedly<br>
-Generates a unique binary sequence for each character<br>
-Produces the compressed bit pattern for the original text<br>

---

## How It Works

1. The program reads a text file `(banana.txt)` into memory

2. It counts the frequency of each character and displays the counts<br>
```bash
CHARACTER COUNT:
[4:B, 4:D, 6: , 11:A, 6:N]
```

3. Each unique character is stored as a **node** in a **priority queue**

4. Huffman tree construction:<br>
    -Repeatedly remove the two nodes with the smallest frequencies

    -Create a new node with these two nodes as children

    -Add the new node back into the queue

    -Continue until only one node remains (the root of the tree)

5. Traverse the Huffman tree to assign **binary sequences** to each character:
    -Right traversal: append `0`

    -Left traversal: append `1`

6. Display the encoding for each character:
```bash
CHARACTER ENCODING:
{ =10, A=00, B=011, D=010, N=11}
```
7. Generate the compressed bit pattern for the original text using these sequences:
```bash
COMPRESSED BIT PATTERN:
0010011000101001100110011001000110101000100110011010100110011010001100
```

---

## INPUT `(banana.txt)`

```bash
A BAD BANANA AND A BAND BANDANA
```
## OUTPUT (console)
```bash
CHARACTER COUNT:
[4:B, 4:D, 6: , 11:A, 6:N]

CHARACTER ENCODING:
{ =10, A=00, B=011, D=010, N=11}

COMPRESSED BIT PATTERN:
0010011000101001100110011001000110101000100110011010100110011010001100
```

---

## Classes Overview
### **Entropy.java**
Handles:

    -Reading the input file

    -Counting character frequencies

    -Building nodes and the Huffman tree

    -Generating the compressed bit pattern
### **BinaryTree.java**
Handles:<br>

    -Constructing and storing the Huffman tree

    -Traversing the tree to generate bit sequences for each character
### **Node.java**
Handles:<br>

    -Storing character and frequency

    -Representing nodes in the Huffman tree

    -Comparing nodes by frequency for the priority queue

---

## How to Run
1. Clone Git Repo
```bash
git clone https://github.com/veda-rabishanker/HuffMaster.git
```
2. Compile the Java files:  
```bash
javac Entropy.java BinaryTree.java Node.java
```
3. Run the file:
```bash
java Entropy
