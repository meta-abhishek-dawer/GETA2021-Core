package OverviewDataStructures;

import java.util.Scanner;

public class RotateSubList {
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
     * method to rotate sublist 
     * @param left starting index of sublist 
     * @param right ending index of sublist in linkedlist
     * @param numberOfElements value by which we have to rotate
     */
    public void rotateSubList(int[] array, int left, int right, int numberOfTimes) {
    	
    	for(int i =0 ;i <numberOfTimes; i++) {
    		int temp = array[left-1];
    		for(int j = left-1; j < right-1;j++) {
    			array[j] = array[j+1]; 
    		}
    		array[right-1] = temp;
    		temp =0;
    	}
    	
    	RotateSubList rotateList2 = new RotateSubList();
    	for(int i=0; i< array.length; i++)
    		rotateList2.insertInBegin(array[i]);
    	
    	Node head1 = rotateList2.head;
    	while(head1!= null) {
    		System.out.print(head1.data+ " ");
    		head1 = head1.next;
    	}
    }
    
    
   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of elements to add in LinkedList");
    int numberOfElements = scanner.nextInt();
    int[] arr = new int[numberOfElements];
    for(int i= 0; i< numberOfElements; i++) 
        arr[i] = scanner.nextInt();
    RotateSubList newRotateSublist1 = new RotateSubList();
    
    System.out.println("Enter leftPosition, rightPosition and NumberOfPlaces in LinkedList!!");
    int leftPosition = scanner.nextInt();
    int rightPosition = scanner.nextInt();
    int numberOfPlaces = scanner.nextInt();
    newRotateSublist1.rotateSubList(arr, leftPosition, rightPosition, numberOfPlaces);
    }
}
