package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to take input from captain containing input and methods
 * @author abhishek.dawer_metac
 *
 */
public class CaptainInput {
	PriorityQueue queue;
	static Scanner scanner = new Scanner(System.in);
	ArrayList<String> bowlers = new ArrayList<>();
	
	/**
	 * Constructor of CaptainInput 
	 * @param value containing size of queue
	 */
	public CaptainInput(int value) {
		queue = new PriorityQueue(value);
	}
	
	/**
	 * Method to take input of bowler and insert in queue
	 * @param number containing number of bowler
	 */
	public void bowlerInput(int number) {
		for(int i= 0; i< number; i++) {
			System.out.println("Input Bowler name with capacity..");
			String bowlerName = scanner.next();
			int numberOfBalls = scanner.nextInt();
			queue.insert(bowlerName, numberOfBalls);
		}
	}
	
	/**
	 * Method to get Order of bowler
	 * @param balls containing the number of Balls for Batsman
	 */
	public void getBowlerOrder(int balls) {
		while(balls>0) {
			if(queue.isEmpty()) {
				break;
			}
			Bowler bowler = queue.remove();
			bowlers.add(bowler.bowlerName);
			balls = balls- bowler.numberOfBalls;
		}
		System.out.println("Order of bowling:-" + this.bowlers);
	}
	
    public static void main(String[] ar) {
	   System.out.println("Please enter the size of queue");
       int queueSize = scanner.nextInt();
       CaptainInput captain = new CaptainInput(queueSize);
       
       System.out.println("Enter the number of bowlers..");
       int numberOfBowlers = scanner.nextInt();
       captain.bowlerInput(numberOfBowlers);
       
       System.out.println("Enter the number of balls");
       int numberOfBalls = scanner.nextInt();
       captain.getBowlerOrder(numberOfBalls);
   }
}
