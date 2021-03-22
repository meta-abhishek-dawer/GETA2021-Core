package DSA_Assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Class in which we define the method of unique characters
 * @author abhishek.dawer_metac
 *
 */
public class UniqueCharacters {
    HashMap<Character, Integer> charactersMap = new HashMap<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the input string..");
		String inputString = scanner.nextLine();
		String[] stringArray = inputString.split(" ");
		UniqueCharacters newUniqueCharacters = new UniqueCharacters();
		for(int i =0; i<stringArray.length;i++) {
			newUniqueCharacters.numberOfUniqueCharacters(stringArray[i]);
		}
		int count = 0;
		for(Map.Entry<Character, Integer> entry : newUniqueCharacters.charactersMap.entrySet()) {
		    if(entry.getValue() == 1) {
		    	count++;
		    }
		}
		
		System.out.println("Number of Unique Character in String is:- "+ count);
	}
	
	/**
	 * Method to find unique characters in a string
	 * @param string containg value of type String
	 */
    public void numberOfUniqueCharacters(String string) {
    	char[] array = string.toCharArray();
    	for(int i = 0; i< array.length; i++) {
    		if(this.charactersMap.containsKey(array[i])==false) {
    			this.charactersMap.put(array[i], 1);
    		}
    		else {
    			this.charactersMap.put(array[i], this.charactersMap.get(array[i])+1);
    		}
    	}
    }
}
