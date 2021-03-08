package DSA_Assignment4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Class in which we define the method to calculate Molecular mass
 * @author abhishek.dawer_metac
 *
 */
public class MassCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the molecule...");
		String inputString = scanner.next();
		MassCalculator newMassCalculator = new MassCalculator();
		int result = newMassCalculator.calculateMass(inputString.toUpperCase());
		System.out.println("Molecular mass is:-" + result);
	}
    /**
     * Method to calculate the molecular mass 
     * @param input containing the input string
     * @return molecular mass of type int
     */
	public int calculateMass(String input) {
		int result = 0;
		String atoms = "HOC";
		Stack<String> newStack = new Stack<>();
		for(int i= 0; i< input.length(); i++) {
			char character = input.charAt(i);
			if(character == '(')
				newStack.push("(");
			else if(atoms.contains(String.valueOf(character))) {
				newStack.push(String.valueOf(this.getValue(character)));
			}
			else if(character == ')') {
				int temp = 0;
				while(!newStack.peek().contains("("))
					temp = temp + Integer.parseInt(newStack.pop());
				newStack.pop();
				newStack.push(String.valueOf(temp));
			}
			else if(Character.isDigit(character)) {
				int temp =0;
				if(!newStack.isEmpty()) {
					temp = Integer.parseInt(newStack.pop()) * Integer.parseInt(String.valueOf(character));
					newStack.push(String.valueOf(temp));
				}
			}
		}
		while(!newStack.isEmpty() && !newStack.peek().contains("("))
			result = result + Integer.parseInt(newStack.pop());
		
		return result;
	}
	
	/**
	 * Method to find the mass of atom 
	 * @param value containing value of atom 
	 * @return mass of atom of type int
	 */
	public int getValue(char value) {
		if(value == 'H')
			return 1;
		else if(value == 'C')
			return 12;
		else 
			return 16;
	}
}
