package DSA_Assignment2;

/**
 * class Stack implementing stack interface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Stack implements StackInterface {
	Node root;
	class Node {
		int data;
		Node next;
		Node(int value) {
			this.data= value;
		}
	}
	
	/**
	 * Method to insert value in Stack
	 * data containing value of type int
	 */
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

	/**
	 * Method to remove value of stack of type int
	 */
	public int pop() {
		if(root== null)
		    return -1;
		else {
			int popped = root.data;
			root = root.next;
			return popped;
		}
	}

	/**
	 * method to check stack is empty or not
	 * return value of type boolean
	 */
	public boolean isEmpty() {
	    if(root== null)
		    return true;
	    else
	    	return false;
	}

	/**
	 * Method to get element at peek position
	 * return value of type int
	 */
	public int peek() {
		if(root== null)
		    return Integer.MIN_VALUE;
		else
			return root.data;
	}
	
}
