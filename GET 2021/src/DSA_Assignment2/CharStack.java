package DSA_Assignment2;

public class CharStack {
    final StringBuilder newStringBuilder= new StringBuilder();
    
    public void push(char ch) {
    	newStringBuilder.append(ch);
    }
    
    public char pop() {
    	int last = newStringBuilder.length()-1;
    	char character = newStringBuilder.charAt(last);
    	newStringBuilder.setLength(last);
    	return character;
    }
    
    public int size() {
    	return newStringBuilder.length();
    }
    public char peek() {
    	return newStringBuilder.charAt(newStringBuilder.length()-1);
    }
    public boolean isEmpty() {
    	if(newStringBuilder.length()==0)
    		return true;
    	else
    		return false;
    }
    
}
