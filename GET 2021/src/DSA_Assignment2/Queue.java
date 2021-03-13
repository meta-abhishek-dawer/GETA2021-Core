package DSA_Assignment2;

import java.util.Scanner;

/**
 * Class queue implementing queue Interface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Queue implements QueueInterface{
	public int currentSize, maxSize;
    public int[] queueElements;
    
    public int rear, front;
    
    /**
     * Constructor of a Queue
     * @param size containing size for array
     */
    public Queue(int size) {
    	this.maxSize = size;
    	queueElements = new int[this.maxSize];
    	currentSize = 0;
    	rear = -1;
    	front = -1;
    }
    
    /**
     * Method to insert value in queue
     * @param value contain value to be inserted in queue
     */
    public void enQueue(int value) {
    	if(isFull())
    		System.out.println("Queue is full!!");
    	else {
    		rear = (rear + 1) % queueElements.length;
    		queueElements[rear] = value;
    		currentSize++;
    		if(front == -1)
    			front = rear;
    	}
    }
    
    /**
     * method to remove first element from queue
     */
    public int deQueue() {
    	int elementDequeued;
    	if(isEmpty()) {
    		System.out.println("queue is empty!! So, return -1");
    		return -1;
    	}
    	else {
    		elementDequeued = queueElements[front];
    		queueElements[front] = 0;
    		front = (front + 1) % queueElements.length;
    		currentSize--;
    		return elementDequeued;
    	}
    }
    /**
     * Method to check the queue is full
     */
    public boolean isFull() {
    	if(currentSize == queueElements.length)
    		return true;
    	else
    		return false;
    }
    
    /**
     * Method to check queue is empty
     */
    public boolean isEmpty() {
    	if(currentSize == 0)
    		return true;
    	else
    		return false;
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the queue size.");
		int queueSize = scanner.nextInt();
        Queue newQueue = new Queue(queueSize);
        int[] arr= new int[queueSize];
        for(int i = 0; i < queueSize; i++)
        	arr[i] = scanner.nextInt();
        
        for(int i = 0; i < queueSize; i++)
        	newQueue.enQueue(arr[i]);
        
        System.out.println("Dequeue element from queue:- "+ newQueue.deQueue());
        newQueue.enQueue(4);
        System.out.println("To check Queue is empty:- "+ newQueue.isEmpty());
	}

}
