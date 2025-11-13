/**
*
*/
package a2;

import static org.junit.Assert.*;
/**
* Name: Akmal Shaikh
* Student ID: 016450382
* Description of solution: This Solution utilizes the Tortoise and Hare method 
* (Floyds Cycle Detection Method) in which two pointers will be running through 
* the list one fast and one slow. If the two pointers point at each other then 
* the list is a cycle. If the pointers do not then we can assume the list is not
* a cycle. 
* @author name
*
*/

/* Class to Initialize Node */
class Node {
    String value;
    Node next;

    // setting the Value to zero
    Node(String value) {
        this.value = value;
        this.next = null;
    }

    //setter for Node
    void setNext(Node next) {
        this.next = next;
    }

    //Getter for Node
    Node getNext() {
        return this.next;
    }
}

public class CycleLinkedList {

	/*This function returns true if given linked
	list has a cycle, else returns false. */
	public static boolean hasCycle(Node head) {
		if(head == null || head.next == null) {
	
		return false;
	}
	
	//setting the Fast and Slow Nodes
	Node slow = head;
	Node fast = head.next;
	
	//Setting while loop for slow and fast Nodes to cycle through list
	while (fast!= null && fast.next != null) {
		if(slow == fast) {
			return true;
		}
		slow = slow.next;
		fast = fast.next.next;
	}
	return false;
	}
	
	//Initializing the AssertEquals Method 
	public static void assertEquals(boolean actual, boolean expected) {
		if(actual != expected){
			throw new AssertionError("Expected: "+ expected + "\n" + "Actual: " + actual + "\n");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Node head = new Node("start");
			Node prev = head;
			for (int i =0; i<4; i++) {
				Node temp = new Node(Integer.toString(i));
				prev.setNext(temp);
				prev=temp;
				}
				
				boolean b = hasCycle(head);
				System.out.println("Testing...");
				assertEquals(b, false);
				System.out.println("Success!");
				
				prev.setNext(head.getNext());
				
				b = hasCycle(head);
				System.out.println("Testing...");
				assertEquals(b, true);
				
				System.out.println("Success!");
				}
			}
