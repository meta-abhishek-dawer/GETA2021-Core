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
    /**
     * method to rotate sublist of linkedlist
     * @param left starting index of sublist in linkedlist
     * @param right ending index of sublist in linkedlist
     * @param numberOfElements value by which we have to rotate
     */
    public void rotateSubList(int left, int right, int numberOfElements) {
    	int size = right - left + 1;
    	if(numberOfElements > size)
            numberOfElements = numberOfElements % size;
    	if(numberOfElements == 0 || numberOfElements == size) {
    		Node temp = head;
    		while(temp!= null){
    			System.out.print(temp.data);
    			temp = temp.next;
    		}
    	}
    	Node link = null;
    	if(left == 1)
    		link = head;
    	Node current = head;
    	int count =0;
    	Node end = null;
    	Node previous = null;
    	while(current != null) {
    		count++;
    		if(count == left - 1) {
    			previous = current;
    			link = current.next;
    		}
    		if(count == right - numberOfElements) {
    			if(left == 1) {
    				end = current;
    				head = current.next;
    			}
    			else {
    				end = current;
    				previous.next = current.next;
    			}
    		}
    		if(count == right) {
    			Node temp1 = current.next;
    			current.next = link;
    			end.next = temp1;
    			Node head1 = head;
    			while(head1 != null) {
    				System.out.print(head1.data + " ");
    				head1 = head1.next;
    			}
    		}
    		current = current.next;
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
    }
}
