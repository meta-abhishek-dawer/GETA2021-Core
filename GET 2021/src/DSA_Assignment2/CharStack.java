package DSA_Assignment2;
/**
 * Class to define character stack and its methods
 * @author abhishek.dawer_metac
 *
 */
public class CharStack {
    final StringBuilder newStringBuilder= new StringBuilder();
    /**
     * Method to insert value in stack
     * @param value containing value to be inserted in stack
     */
    public void push(char value) {
    	newStringBuilder.append(value);
    }
    
    /**
     * Method to remove value from stack
     * @return value of type char
     */
    public char pop() {
    	int last = newStringBuilder.length()-1;
    	char character = newStringBuilder.charAt(last);
    	newStringBuilder.setLength(last);
    	return character;
    }
    
    /**
     * method to get size of stack
     * @return length of stack of type int
     */
    public int size() {
    	return newStringBuilder.length();
    }
    
    /**
     * Method to get element at peek of stack
     * @return value of type char
     */
    public char peek() {
    	return newStringBuilder.charAt(newStringBuilder.length()-1);
    }
    
    /**
     * Method to check stamp is empty or not
     * @return true if stack is empty else false
     */
    public boolean isEmpty() {
    	if(newStringBuilder.length()==0)
    		return true;
    	else
    		return false;
    }
    
}
