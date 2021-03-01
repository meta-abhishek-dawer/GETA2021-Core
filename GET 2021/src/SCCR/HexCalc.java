package SCCR;

import java.util.Scanner;
public class HexCalc {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String hexNum1 = sc.next();
		String hexNum2 = sc.next();  
		HexCalc obj1 = new HexCalc();
		   
		//convert hexadecimal string to numbers
		int decNum1 = obj1.HexadecimalToDecimal(hexNum1);
		int decNum2 = obj1.HexadecimalToDecimal(hexNum2);
		   
		//method for adding two hexadecimal numbers
		int add = obj1.addTwoHexadecimals(decNum1,decNum2);
		String sumResult= obj1.decimalToHexadecimal(add);
		System.out.println(sumResult);
		   
		//method for subtracting two hexadecimal numbers
		int subtract = obj1.subtractTwoHexadecimals(decNum1,decNum2);
		String subtractResult= obj1.decimalToHexadecimal(subtract);
		System.out.println(subtractResult);
		   
		//method for multiply two hexadecimal numbers
		int multiply = obj1.multiplyTwoHexadecimals(decNum1,decNum2);
		String multiplyResult= obj1.decimalToHexadecimal(multiply);
		System.out.println(multiplyResult);
		   
		//method for divide two hexadecimal numbers
		int divide = obj1.divideTwoHexadecimals(decNum1,decNum2);
		String divideResult= obj1.decimalToHexadecimal(divide);
		System.out.println(divideResult);
		   
		//method to check equality
		boolean equalResult = obj1.checkEquality(hexNum1, hexNum2);
		System.out.println(equalResult);
		   
		//method to check greater
		boolean greaterResult = obj1.checkGreater(hexNum1,hexNum2);
		System.out.println(greaterResult);
		   
		//method to check smaller
		boolean smallerResult = obj1.checkSmaller(hexNum1,hexNum2);
		System.out.println(smallerResult);
	}

	// function to convert hexadecimal to decimal
	public int HexadecimalToDecimal(String value1){
		return Integer.parseInt(value1, 16);
	}
	
	//function to convert decimal to hexadecimal
	public String decimalToHexadecimal(int value){
		return Integer.toHexString(value);
	}
	
	//function to add two hexadecimals
	public int addTwoHexadecimals(int value1,int value2){
		return value1+value2;
	}
	
	//function to subtract two hexadecimals
	public int subtractTwoHexadecimals(int value1,int value2){
		return value1-value2;
	}
		
    //function to multiply two hexadecimals
	public int multiplyTwoHexadecimals(int value1,int value2){
		return value1*value2;
	}
				
	//function to divide two hexadecimals
	public int divideTwoHexadecimals(int value1,int value2){
		return value1/value2;
	}
				
	//check two hexadecimal numbers are equal or not
	public boolean checkEquality(String value1,String value2){
		if(value1.equals(value2))
			return true;
		else
			return false;
	}
				
	// greater function
	public boolean checkGreater(String value1,String value2){
		if((value1.compareTo(value2))==1)
			return true;
		else
			return false;
	}
				
	//smaller function 
	public boolean checkSmaller(String value1,String value2){
		if((value1.compareTo(value2))== -1)
			return true;
		else
			return false;
	}			
}
