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
	public void insertInBegin(int value) {
		Node newNode = new Node(value);
		if(head == null)
		    head = newNode;
		else {
		    newNode.next = head;
		    head = newNode;	
		}		
	}
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
		}
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
	}
}
