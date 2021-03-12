package Assignment3;

import java.util.Scanner;

class PriorityQueue implements PriorityQueueInterface{
    public  Bowler[] bowlerArray;
    public int size, capacity;

    /**
     * Constructor of Priority queue
     * @param capacity contain the size of array
     */
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
	    bowlerArray = new Bowler[this.capacity];
	    size = 0;
    }
    
    /**
     * Method to insert value in queue
     * @param name contain name of bowler
     * @param balls contain number of balls of bowler
     */
    
    public void insert(String name, int balls) {
	    Bowler bowler = new Bowler(name, balls);
	    if(size == 0) {
	    	size++;
	    	bowlerArray[0] = bowler;
	    	return;
	    }
	    if(size == bowlerArray.length) {
	    	System.out.println("Queue is full");
	    	return;
	    }
	    else {
	    	Bowler temp = bowler;
	    	for(int i= 0; i< size; i++) {
	    		if(bowler.numberOfBalls<= bowlerArray[i].numberOfBalls) {
	    			Bowler next;
	    			temp = bowlerArray[i];
	    			bowlerArray[i] = bowler;
	    			while(i< size - 1) {
	    				next = bowlerArray[i + 1];
	    				bowlerArray[i+1] = temp;
	    				temp = next;
	    				i++;
	    			}
	    			break;
	    		}
	    	}
	    	bowlerArray[size] = temp;
	    	size++;
	    }
    }
    
    /**
     * Method to remove from queue
     * return bowler of type bowler
     */
    public Bowler remove() {
        if(size == 0) {
        	Bowler bowler = null;
        	return bowler;
        }
        else {
        	Bowler bowler = bowlerArray[size-1];
        	size--;
        	return bowler;
        }
    }
    
   /**
    * Method to check queue is empty 
    * @param return true if empty else return false
    */
    public boolean isEmpty() {
	    if(size == 0)
		    return true;
	    else
		    return false;
    }
    
    /**
     * Method to check queue is full
     * return true if full else false
     */
    public boolean isFull() {
    	if(size == capacity)
    		return true;
    	else
    		return false;
    }

    /**
     * Method to check size of queue
     * @param return size of queue
     */
    public int size() {
	    return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter size of queue:- ");
        int queueSize = scanner.nextInt();
        PriorityQueue newPriorityQueue = new PriorityQueue(queueSize);
        int input;

        do {
	        System.out.println("Operations on Priority queue:- ");
 	        System.out.print("Press 1 to insert, 2 to remove, 3 to check queue is empty, 4 to check full, ");
	        System.out.println(" 5 to check size");
	        int selectedInput = scanner.nextInt();
	        switch(selectedInput) {
	        case 1:
	    		System.out.println("Please enter name of job and its priority");
	    		String jobName = scanner.next();
	    		int setPrioriry = scanner.nextInt();
	    		newPriorityQueue.insert(jobName, setPrioriry);
	    		break;
	    	
	    	case 2:
	    		System.out.println("job removed from queue:- " + newPriorityQueue.remove());
	    		break;
	    		
	    	case 3:
	    		System.out.println("Queue is empty:- " + newPriorityQueue.isEmpty());
	    		break;
	    		
	    	case 4:
	    		System.out.println("Queue is full:- " + newPriorityQueue.isFull());
	    		break;
	    	
	    	case 5:
	    		System.out.println("Size of queue is:- " + newPriorityQueue.size());
	    		break;
	    		
	    	default:
	    		System.out.println("Please provide input between 1 to 6");
	    		break;
	    	}
	    	System.out.println("Press 1 to continue...");
	    	input = scanner.nextInt();
	    }
	    while(input == 1);
    }
}
