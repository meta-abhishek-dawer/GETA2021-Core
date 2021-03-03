package OverviewDataStructures;

import java.util.LinkedList;
import java.util.Scanner;
public class DetectLoop {
    public Node head= null;
    
    class Node {
	    int data;
	    Node next;
	    public Node(int value) {
		    data = value;
		    next = null;
	    }
    }
    /**
     * Method to insert value in LinkedList
     * @param value contain value which we want to add in list
     */
    public void insertInBegin(int value) {
	    Node newNode = new Node(value);
	    if(head == null)
		    head = newNode;
	    else {
		    newNode.next = head;
		    head = newNode;	
	    }		
    }
    /**
     * Method to display the list
     */
    public void display() {
	    Node temp = head;
	    if(head == null)
		    System.out.println("LinkedList is empty!!");
	    else {
		    System.out.println("Elements in LinkedList:- ");
		    while(temp!= null) {
		        System.out.print(temp.data + " ");
		        temp = temp.next;
		    }
		    System.out.println();
	    }
    }
    /**
     * Method to detect Loop 
     * @param head containing the first value of list
     * @return true if loop is present else return false
     */
    public boolean detectLoop(Node head) {
	    Node fastPointer = head;
	    Node slowPointer = head;
	    while(fastPointer!= null && fastPointer.next!= null) {
		    fastPointer = fastPointer.next.next;
		    slowPointer = slowPointer.next;
		    if(fastPointer == slowPointer)
		        return true;
	    }
	    return false;
    }
	
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of elements to add in LinkedList");
    int numberOfElements = scanner.nextInt();
    int[] arr = new int[numberOfElements];
    for(int i= 0; i< numberOfElements; i++) 
        arr[i] = scanner.nextInt();
    
    DetectLoop newDetectLoop = new DetectLoop();
    for(int i=0; i< numberOfElements; i++)
        newDetectLoop.insertInBegin(arr[i]);
    newDetectLoop.display();
    newDetectLoop.head.next.next.next = newDetectLoop.head;
    if(newDetectLoop.detectLoop(newDetectLoop.head))
        System.out.println("Loop found in linkedlist!!");
    else
        System.out.println("Loop not found.");
	
    }
}
