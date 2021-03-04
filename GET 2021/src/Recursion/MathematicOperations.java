package Recursion;

import java.util.Scanner;

public class MathematicOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please provide number 1");
		int number1 = scanner.nextInt();
		System.out.println("please provide number 2");
		int number2 = scanner.nextInt();
		MathematicOperations newMathematicOperation = new MathematicOperations();
		//HCF method
		int hcf = newMathematicOperation.findHCF(number1, number2);
		System.out.println("HCF of two number is:- "+ hcf);
		
		//LCM method
		int lcm = newMathematicOperation.findLCM(number1, number2);
		System.out.println("LCM of two number is:- "+ lcm);
	}
	
	/**
	 * Find HCF of two numbers using Recursion
	 * @param number1 value1 which we use to find HCF
	 * @param number2 value2 which we use to find HCF
	 * @return value containing HCF of both values
	 */
	public int findHCF(int number1, int number2) {
		    if(number2!= 0)
			    return findHCF(number2, number1 % number2);
		    else
			    return  number1;
	}
	
	/**
	 * Find LCM of two methods using recursion
	 * @param number1 value1 used in method  findLCM
	 * @param number2 value2 used in method findLCM
	 * @return value containing LCM of two numbers
	 */
	public int findLCM(int number1, int number2){
		try {
			if(number1== 0 || number2== 0)
				throw new AssertionError();
		    return (number1 / findHCF(number1, number2) * number2);
		}
		catch(AssertionError e) {
			System.out.println("number 1 or number2 cannot be empty");
		}
		return 0;
	}
}
