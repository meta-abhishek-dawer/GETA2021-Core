package Assignment3;

import java.util.Scanner;
/**
 * Class queue implementing queue methods
 * @author abhishek.dawer_metac
 *
 */
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
    
}
