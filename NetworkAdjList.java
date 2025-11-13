package a3;

import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
/**
* CS146 Assignment 3 Node class
* This class is used for undirected graphs represented as adjacency lists
* @author andreopo
*/

public class NetworkAdjList {
    private static final int max_num_vertices = 4000; // Adjust this based on the number of nodes
    private static Node[] adjacencyList = new Node[max_num_vertices];

    static {
        // Initialize adjacency list
        for (int i = 0; i < max_num_vertices; i++) {
            adjacencyList[i] = new Node(i);
        }
        // Populate the adjacency list from the file
        createAdjacencyList();
    }

    // Method to create the adjacency list from the file
    //using Scanner to read the file- having some issues with it reading
public static void createAdjacencyList() {
	try (Scanner file = new Scanner(new File ("3980.edges"))) {
		while (file.hasNextLine()) {
			String line = file.nextLine();
			String[] parts = line.split(" ");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);

			Edges(A, B);
			Edges(B, A); 
                }
            } 
	catch (IOException e) {
                e.printStackTrace();
            }
        }

//allows for node to check that friend are next to each other as well as check in reverse,A-B, B-A
private static void Edges(int A, int B) {
    Node newNode = new Node(B);
    Node current = adjacencyList[A];
    if (current == null) {
        adjacencyList[A] = newNode;
    } else {
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }
}
// Will check if Friends are next to each other
public static boolean areFriends(int A, int B) {
    Node current = adjacencyList[A];
    while (current != null) {
        if (current.getName() == B) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}

public static void BFStraversal(int start) {
    boolean[] visited = new boolean[max_num_vertices];
    int[] distances = new int[max_num_vertices];
    Arrays.fill(distances, -1); 
    
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    distances[start] = 0;
    queue.add(start);
    
    //while loop,tracks who is visited to add as friend
    while (!queue.isEmpty()) {
        int current = queue.poll();
        Node neighbor = adjacencyList[current].getNext(); 
        while (neighbor != null) {
            int neighborID = neighbor.getName();
            if (!visited[neighborID]) {
                visited[neighborID] = true;
                distances[neighborID] = distances[current] + 1;
                queue.add(neighborID);
            }
            neighbor = neighbor.getNext();
        }
    }
    
    for (int i = 0; i < max_num_vertices; i++) {
        if (distances[i] != -1) {
            System.out.println(i + " is at a distance of " + distances[i] + " from " + start);
        }
    }
}

public static void main(String[] args) {
   // to check if BFS works starting with 3980
	  System.out.println("Testing BFS from person 3980...");
      BFStraversal(3980);
      
/**
* These test cases assume the file 3980.edges was used
*/
	System.out.println("Testing...");
	assertEquals(areFriends(4038, 4014), true);
	System.out.println("1 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(3982, 4037), true);
	System.out.println("2 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(4030, 4017), true);
	System.out.println("3 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(4030, 1), false);
	System.out.println("4 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(1, 4030), false);
	System.out.println("5 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(4003, 3980), true);
	System.out.println("6 of 7");
	System.out.println("Testing...");
	assertEquals(areFriends(3985, 4038), false);
	System.out.println("7 of 7");
	System.out.println("Success!");
		}
	}

