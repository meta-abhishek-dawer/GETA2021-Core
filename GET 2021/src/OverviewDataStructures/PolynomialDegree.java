package OverviewDataStructures;

import java.util.Scanner;

public class PolynomialDegree {
    public Node head= null;
    
    class Node {
	    String data;
	    Node next;
	    public Node(String value) {
		    data = value;
		    next = null;
	    }
    }
    /**
     * Method to insert value in LinkedList
     * @param value contain value which we want to add in list
     */
    public void insertInBegin(String value) {
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
	    Node temp2 = head;
	    if(head == null)
		    System.out.println("LinkedList is empty!!");
	    else {
		    System.out.println("Elements in LinkedList:- ");
		    while(temp2.next!= null) {
		        System.out.print(temp2.data + " + ");
		        temp2 = temp2.next;
		    }
		    System.out.print(temp2.data);
		    System.out.println();
	    }
    }
    
    /**
     * Method to Find maximum degree of a polynomial
     * @param headNode containing the first node of a LinkedList
     */
    public void findDegree(Node headNode) {
    	Node temp1 = headNode;
    	int maxDegree= 0;
    	while(temp1!= null) {
    		String value = temp1.data;
    		int sumDegree= 0;
    		char[] charArr= value.toCharArray();
    		for(int i= 0; i< value.length()-1; i++) {
    			
    			if(value.charAt(i)== 'x')
    				sumDegree = sumDegree + Character.getNumericValue(value.charAt(i+1));
    			else if(value.charAt(i)== 'y')
    				sumDegree = sumDegree + Character.getNumericValue(value.charAt(i+1));
    			else if(value.charAt(i)== 'z')
    				sumDegree = sumDegree + Character.getNumericValue(value.charAt(i+1));
    			else
    				continue;
    			
    		}
    		if(maxDegree< sumDegree) {
    			maxDegree = sumDegree;
    			sumDegree= 0;
    		}
    		temp1= temp1.next;
    	}
    	System.out.println("Maximum degree is:- "+ maxDegree);
    }
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PolynomialDegree newPolynomialDegree = new PolynomialDegree();
    System.out.println("enter the number of values to add in PolyNomial.");
    int numberOfValues = scanner.nextInt();
    System.out.println("Please enter values in format 2X2Y3Z1 ");
    String[] arr = new String[numberOfValues];
    for(int i =0; i< numberOfValues; i++)
        arr[i]= scanner.next();
    
    for(int i=0;i< arr.length; i++)
        newPolynomialDegree.insertInBegin(arr[i]);
    
    newPolynomialDegree.display();
    newPolynomialDegree.findDegree(newPolynomialDegree.head);
    }
}