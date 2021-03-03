package OverviewDataStructures;

import java.awt.font.NumericShaper;
import java.util.LinkedList;
import java.util.Scanner;
public class RotateSublist {
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
    public void rotateSubList(int left, int right, int numberOfElements) {
    	int size = right - left + 1;
    	if(numberOfElements > size)
            numberOfElements = numberOfElements % size;
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
   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of elements to add in LinkedList");
    int numberOfElements = scanner.nextInt();
    int[] arr = new int[numberOfElements];
    for(int i= 0; i< numberOfElements; i++) 
        arr[i] = scanner.nextInt();
    RotateSublist newRotateSublist = new RotateSublist();
    for(int i=0; i< numberOfElements; i++)
    	newRotateSublist.insertInBegin(arr[i]);
    
    System.out.println("Enter leftPosition, rightPosition and NumberOfPlaces in LinkedList!!");
    int leftPosition = scanner.nextInt();
    int rightPosition = scanner.nextInt();
    int numberOfPlaces = scanner.nextInt();
    newRotateSublist.rotateSubList(leftPosition, rightPosition, numberOfPlaces);
    newRotateSublist.display();
    }
}
