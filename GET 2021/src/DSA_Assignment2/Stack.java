package DSA_Assignment2;

public class Stack implements StackInterface {
	Node root;
	class Node {
		int data;
		Node next;
		Node(int value) {
			this.data= value;
		}
	}
	public void push(int data) {
	    Node newNode = new Node(data);
	    if(root== null)
	    	root = newNode;
	    else {
	    	Node temp = root;
	    	root= newNode;
	    	newNode.next= temp;
	    }
	}

	public int pop() {
		if(root== null)
		    return -1;
		else {
			int popped = root.data;
			root = root.next;
			return popped;
		}
	}

	public boolean isEmpty() {
	    if(root== null)
		    return true;
	    else
	    	return false;
	}

	public int peek() {
		if(root== null)
		    return Integer.MIN_VALUE;
		else
			return root.data;
	}
	
}
