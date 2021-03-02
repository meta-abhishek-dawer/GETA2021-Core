package SCCR;

import java.util.Scanner;
public class HexCalc {
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("enter two hexadecimal numbers.");
	    String hexadecimalNumber1 = scanner.next();
        String hexadecimalNumber2 = scanner.next();  
	    HexCalc hexCalculator = new HexCalc();
		      
	    //method for adding two hexadecimal numbers
	    String addResult = hexCalculator.add(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(addResult);
		   
	    //method for subtracting two hexadecimal numbers
	    String subtractResult = hexCalculator.subtract(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(subtractResult);
		   
	    //method for multiply two hexadecimal numbers
        String multiplyResult = hexCalculator.multiply(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(multiplyResult);
		   
	    //method for divide two hexadecimal numbers
	    String divideResult = hexCalculator.divide(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(divideResult);
		   
	    //method to check equality
	    boolean equalResult = hexCalculator.checkEquality(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(equalResult);
		   
	    //method to check greater
	    boolean greaterResult = hexCalculator.checkGreater(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(greaterResult);
		   
	    //method to check smaller
	    boolean smallerResult = hexCalculator.checkSmaller(hexadecimalNumber1, hexadecimalNumber2);
	    System.out.println(smallerResult);
    }

    // function to convert hexadecimal to decimal
    public int hexadecimalToDecimal(String value1) {
    	int baseValue =16;
	    return Integer.parseInt(value1, baseValue);
    }
	
    //function to convert decimal to hexadecimal
    public String decimalToHexadecimal(int value) {
	    return Integer.toHexString(value);
    }
	
    //function to add two hexadecimals
    public String add(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    int result=  number1 + number2;
	    return this.decimalToHexadecimal(result);
    }
	
    //function to subtract two hexadecimals
    public String subtract(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    int subtractResult= number1 - number2;
	    return this.decimalToHexadecimal(subtractResult);
    }
		
    //function to multiply two hexadecimals
	public String multiply(String value1, String value2) {
		int number1 = this.hexadecimalToDecimal(value1);
		int number2 = this.hexadecimalToDecimal(value2);
		int multiplyResult= number1 * number2;
		return this.decimalToHexadecimal(multiplyResult);
	}
				
    //function to divide two hexadecimals
    public String divide(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    int divideResult = number1 / number2;
	    return this.decimalToHexadecimal(divideResult);
    }
				
    //check two hexadecimal numbers are equal or not
    public boolean checkEquality(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    if(number1 == number2)
		    return true;
		return false;
    }
				
    // greater function
    public boolean checkGreater(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    if(number1 > number2)
	    	return true;
		return false;
    }
				
    //smaller function 
    public boolean checkSmaller(String value1, String value2) {
    	int number1 = this.hexadecimalToDecimal(value1);
    	int number2 = this.hexadecimalToDecimal(value2);
	    if(number2> number1)
		    return true;
		return false;
    }			
}
