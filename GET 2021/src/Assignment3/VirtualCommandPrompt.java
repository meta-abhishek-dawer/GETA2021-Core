package Assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class VirtualCommandPrompt {
    Directory root, currentDirectory;
    
    public VirtualCommandPrompt() {
    	root = new Directory("root");
    	currentDirectory = root;
    }
    
    public void runCommand(String string) {
    	String[] command = string.split(" ");
    	switch(command[0].toLowerCase()) {
    	case "mkdir" :
    		String result = createDirectory(command[1]);
    		System.out.println(result);
    		break;
    		
    	case "ls" :
    		listCurrentDirectory();
    		break;
    		
    	case "cd" :
    		String resultChange = changeDirectory(command[1]);
    		System.out.println(resultChange);
    		break;
    		
    	case "find" :
    		ArrayList<String> path = find(command[1]);
    		for(int i= 0; i< path.size(); i++)
    			System.out.println(path.get(i));
    		break;
    	
    	case "tree" :
    		displayDirectory();
    		break;
    		
    	case "bk" :
    		moveToParent();
    		break;
    		
    	case "exit":
    		System.exit(0);
    		break;
    		
    	default:
    		System.out.println("Invalid Input!!!");
    		break;
    	}
    	
    }
    public String createDirectory(String name) {
    	String result = "";
    	try {
    		if(name.length() == 0)
    			throw new InputMismatchException();
    		if(isDirectoryPresent(name, this.currentDirectory)==false) {
    			Directory newDirectory = new Directory(name);
    			newDirectory.parentDirectory = currentDirectory;
    			currentDirectory.subDirectory.add(newDirectory);
    			result= "Directory Created";
    		}
    		else {
    			result = "Directory already present!!";
    		}
    	}
    	catch(InputMismatchException e) {
    		System.out.println("Input Mismatched!!");
    	}
    	return result;
    }
    
    public void listCurrentDirectory() {
    	for(Directory newDirectory : currentDirectory.subDirectory)
    		System.out.println(newDirectory.directoryName + " " + newDirectory.timeStamp);
    }
    
    public String changeDirectory(String changeName) {
    	for(int i= 0; i< currentDirectory.subDirectory.size(); i++) {
    		String dirName =currentDirectory.subDirectory.get(i).directoryName;
    		if(dirName.equals(changeName)) {
    			currentDirectory = currentDirectory.subDirectory.get(i);
    			return "Directory Changed..";
    		}
    	}
    	return "No directory present!!";
    }
    
    public boolean isDirectoryPresent(String name, Directory currentDirectory) {
    	for(int i= 0; i< currentDirectory.subDirectory.size(); i++) {
    		String dirName =currentDirectory.subDirectory.get(i).directoryName; 
    		if(dirName.equals(name))
    			return true;
    	}
    	return false;
    }
    
    public void moveToParent() {
    	currentDirectory = currentDirectory.parentDirectory;
    }
    
    public void displayDirectory() {
    	displayStructure(root);
    }
    public void displayStructure(Directory newDirectory) {
        for(Directory directory : newDirectory.subDirectory) {
        	System.out.println(" " + directory.directoryName);
        	displayDirectory();
        }
    }
    
    public ArrayList<String> find(String dirName) {
    	ArrayList<String> directoryPaths = new ArrayList<>();
    	findPath(dirName, root, directoryPaths);
    	return directoryPaths;
    }
    
    public void findPath(String dirName, Directory newDirectory, ArrayList<String> directoryPaths) {
    	for(int i= 0; i< newDirectory.subDirectory.size(); i++) {
    		String currentName = newDirectory.subDirectory.get(i).directoryName;
    		if(currentName.equals(dirName)) {
    			String currentPath = "";
    			Directory folder = newDirectory.subDirectory.get(i).parentDirectory;
    			while(folder.parentDirectory!= null) {
    				currentPath = folder.directoryName + "\\" + currentPath;
    				folder = folder.parentDirectory;
    			}
    			directoryPaths.add("root\\" + currentPath);
    		}
    		else {
    			findPath(dirName, newDirectory.subDirectory.get(i), directoryPaths);
    		}
    	}
    }
}
