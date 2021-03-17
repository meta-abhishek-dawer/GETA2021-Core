package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class VCPMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter command with name like mkdir filename, ls, cd, find , exit");
		String input = scanner.nextLine();
		VirtualCommandPrompt object = new VirtualCommandPrompt();
		String[] command = input.split(" ");
		while(true) {
			switch(command[0].toLowerCase()) {
	    	case "mkdir" :
	    		String result = object.createDirectory(command[1]);
	    		System.out.println(result);
	    		break;
	    		
	    	case "ls" :
	    		object.listCurrentDirectory();
	    		break;
	    		
	    	case "cd" :
	    		String resultChange = object.changeDirectory(command[1]);
	    		System.out.println(resultChange);
	    		break;
	    		
	    	case "find" :
	    		ArrayList<String> path = object.find(command[1]);
	    		for(int i= 0; i< path.size(); i++)
	    			System.out.println(path.get(i));
	    		break;
	    	
	    	case "tree" :
	    		object.displayDirectory();
	    		break;
	    		
	    	case "bk" :
	    		object.moveToParent();
	    		break;
	    		
	    	case "exit":
	    		System.exit(0);
	    		break;
	    		
	    	default:
	    		System.out.println("Invalid Input!!!");
	    		break;
	    	}
		}
	}

}
