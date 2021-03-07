package DSA_Assignment2;

import java.util.Scanner;

public class InfixExpression {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infix = scanner.next();
        InfixExpression newInfixExpression = new InfixExpression();
        int result= newInfixExpression.evaluateExpression(infix);
        System.out.println(result);
	}
	/**
	 * Method to evaluate the infix expression
	 * @param expression contains value of Infix
	 * @return evaluated value of type int
	 */
    public static int evaluateExpression(String expression) {
    	Stack newStack = new Stack();
    	CharStack operations = new CharStack();
    	char[] characterArr = expression.toCharArray();
    	for(int i=0;i<characterArr.length;i++) {
    		if(characterArr[i]== ' ')
    			continue;
    		if(characterArr[i]>= '0' && characterArr[i]<='9') {
    			StringBuffer newStringBuffer = new StringBuffer();
    			while(i< characterArr.length && characterArr[i]>='0' && characterArr[i]<='9')
    				newStringBuffer.append(characterArr[i++]);
    			newStack.push(Integer.parseInt(newStringBuffer.toString()));
    			i--;
    		}
    		else if(characterArr[i]=='(')
    			operations.push(characterArr[i]);
    		else if(characterArr[i]==')') {
    			while(operations.peek()!='(')
    				newStack.push(applyOperations(operations.pop(),newStack.pop(),newStack.pop()));
    			
    			operations.pop();
    		}
    		else if(characterArr[i]== '+' || characterArr[i]== '-' || characterArr[i]== '*' || characterArr[i]== '/') {
    			while(!operations.isEmpty() && isPrecedence(characterArr[i], operations.peek()))
    				newStack.push(applyOperations(operations.pop(), newStack.pop(), newStack.pop()));
    			
    			operations.push(characterArr[i]);
    		}
    	}
    	while(!operations.isEmpty()) 
    		newStack.push(applyOperations(operations.pop(), newStack.pop(), newStack.pop()));
    	return newStack.pop();
    }
    
    /**
     * Method to check precedence
     * @param value1 containing the first character value
     * @param value2 containing the second precedence value
     * @return true if follow precedence else return false
     */
    public static boolean isPrecedence(char value1, char value2) {
    	if(value2=='(' || value2==')')
    		return false;
    	if((value1=='*' || value1== '/') && (value2=='+' || value2=='-'))
    		return false;
    	else 
    		return true;
    }
    
    /**
     * Method to perform operations on two numbers
     * @param operations contains operator 
     * @param value2 contains the second number
     * @param value1 contains the first number
     * @return calculated value of type int
     */
    public static int applyOperations(char operations, int value2, int value1) {
    	switch(operations) {
    	case '+':
    		return value1 + value2;
    	case '-':
    		return value1 - value2;
    	case '*':
    		return value1 * value2;
    	case '/':
    		if(value2==0)
    			throw new UnsupportedOperationException("Cannot divide by zero");
    		return value1/value2;
    	}
    	return 0;
    }
}
